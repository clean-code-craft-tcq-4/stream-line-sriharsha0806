package com.tcq.training.bms.receiver.loggerImpl;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcq.training.bms.battery.parameters.BatteryParameters;
import com.tcq.training.bms.dataContainer.DataContainer;
import com.tcq.training.bms.receiver.api.IReceiver;

public class ReceiveFrmConsoleImpl implements IReceiver {

	/**
	 * Parse the Json input to Java object
	 */
	@Override
	public BatteryParameters getBatteryParametes(String jsonInputData)
			throws JsonParseException, JsonMappingException, IOException {
		byte[] jsonData = jsonInputData.toString().getBytes();

		ObjectMapper mapper = new ObjectMapper();
		BatteryParameters batteryParameter = mapper.readValue(jsonData, BatteryParameters.class);

		return batteryParameter;
	}

	/**
	 * Parse the battery parameters to DataContainer
	 */
	@Override
	public void processBatteryParametes(DataContainer dataContainer) {
		if (dataContainer != null) {
			for (BatteryParameters batteryParameters : dataContainer.getBatteryParameters()) {
				dataContainer.getListOfSoc().add(batteryParameters.getSoc());
				dataContainer.getListOfTemperrature().add(batteryParameters.getTemperature());
			}

		}

	}
	
	/**
	 * Logger
	 */
	@Override
	public void logStatistics(String data) {
		System.out.println(data);
	}

}
