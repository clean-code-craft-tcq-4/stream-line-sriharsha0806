package com.tcq.training.bms.receiver.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.tcq.training.bms.battery.parameters.BatteryParameters;
import com.tcq.training.bms.dataContainer.DataContainer;
import com.tcq.training.bms.dataContainer.DataUtil;
import com.tcq.training.bms.receiver.api.Factory;
import com.tcq.training.bms.receiver.api.ILogger;
import com.tcq.training.bms.receiver.api.IReceiver;

public class BMSReceiverApp {
	DataContainer dataContainer ;

	IReceiver iReceiver;

	ILogger logger;
	
	static DataUtil dataUtil;

	/**
	 * App entry point
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		BMSReceiverApp bmsReceiverApp = new BMSReceiverApp();
		bmsReceiverApp.startApplication(args);
		
		dataUtil = new DataUtil();
	}

	public void startApplication(String[] args) throws IOException {
		logger = Factory.getLogger("console");

		iReceiver = Factory.getReceiver("console");

		dataContainer = new DataContainer();

		List<BatteryParameters> batteryParameters = new ArrayList<BatteryParameters>();

		if (args.length > 0) {
			for (String jsonInputData : args)
				batteryParameters.add(iReceiver.getBatteryParametes(jsonInputData));
		}
		
		dataContainer.setBatteryParameters(batteryParameters);
		
		iReceiver.processBatteryParametes(dataContainer);
		
		logStatisticsDetails();
	}
	
	public void logStatisticsDetails() {
		iReceiver.logStatistics("Statistic data of BMS:");

		List<Double> listOfSoc = new LinkedList<Double>();
		List<Double> listOfTemperrature = new LinkedList<Double>();

		listOfTemperrature = dataContainer.getListOfTemperrature();
		listOfSoc = dataContainer.getListOfSoc();

		Double average = dataUtil.findAverage(listOfTemperrature, 5);

		iReceiver.logStatistics("Average of temperature" + average);

		average = dataUtil.findAverage(listOfSoc, 5);

		iReceiver.logStatistics("Average of SOC" + average);

		Double minValue = dataUtil.findMin(listOfTemperrature);
		Double maxValue = dataUtil.findMax(listOfTemperrature);

		iReceiver.logStatistics("Minimum value of temperature" + minValue);
		iReceiver.logStatistics("Maximum value of temperature" + maxValue);

		minValue = dataUtil.findMin(listOfSoc);
		maxValue = dataUtil.findMax(listOfSoc);

		iReceiver.logStatistics("Minimum value of SOC" + minValue);
		iReceiver.logStatistics("Maximum value of SOC" + maxValue);

	}
}
