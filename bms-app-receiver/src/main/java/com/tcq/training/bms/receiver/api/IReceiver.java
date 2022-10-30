package com.tcq.training.bms.receiver.api;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tcq.training.bms.battery.parameters.BatteryParameters;
import com.tcq.training.bms.dataContainer.DataContainer;

public interface IReceiver {

	public BatteryParameters getBatteryParametes(String jsonInputData) throws JsonParseException, JsonMappingException, IOException;
	
	public void processBatteryParametes(DataContainer dataContainer) ;
	
	public void logStatistics(String data);
}
