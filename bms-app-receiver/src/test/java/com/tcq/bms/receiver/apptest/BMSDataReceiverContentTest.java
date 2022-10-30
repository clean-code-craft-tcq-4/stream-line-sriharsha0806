package com.tcq.bms.receiver.apptest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tcq.training.bms.battery.parameters.BatteryParameters;
import com.tcq.training.bms.dataContainer.DataContainer;
import com.tcq.training.bms.dataContainer.DataUtil;
import com.tcq.training.bms.receiver.api.IReceiver;
import com.tcq.training.bms.receiver.loggerImpl.ReceiveFrmConsoleImpl;

public class BMSDataReceiverContentTest {
	static DataContainer dataContainer;

	static List<BatteryParameters> batteryParameters = new LinkedList<BatteryParameters>();
	static BatteryParameters batteryParameter;

	@BeforeClass
	public static void init() throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);

		for (int index = 1; index <= 50; index++) {
			ObjectNode rootNode = mapper.createObjectNode();
			ObjectNode childNode1 = mapper.createObjectNode();
			childNode1.put("Sample_no", index);
			childNode1.put("SOC Sensor", 30 + index);
			childNode1.put("Temperature Sensor", 0 + index);
			childNode1.put("Battery Sensor", "7");
			rootNode.set("BatteryParameters", childNode1);
			String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
			batteryParameter = mapper.readValue(jsonString, BatteryParameters.class);
			batteryParameters.add(batteryParameter);
		}

	}

	@Test
	public void testReceivedData() throws JsonProcessingException {
		dataContainer = new DataContainer();
		dataContainer.setBatteryParameters(batteryParameters);
		IReceiver iReceiver = new ReceiveFrmConsoleImpl();
		iReceiver.processBatteryParametes(dataContainer);

		List<Double> listOfSoc = new LinkedList<Double>();

		List<Double> listOfTemperrature = new LinkedList<Double>();

		listOfSoc = dataContainer.getListOfSoc();
		listOfTemperrature = dataContainer.getListOfTemperrature();

		assertNotNull(listOfSoc);
		assertNotNull(listOfTemperrature);
		Double index = new Double(1);

	}

	@Test
	public void testReceivedSocData() throws JsonProcessingException {
		dataContainer = new DataContainer();
		dataContainer.setBatteryParameters(batteryParameters);
		IReceiver iReceiver = new ReceiveFrmConsoleImpl();
		iReceiver.processBatteryParametes(dataContainer);

		List<Double> listOfTemperrature = new LinkedList<Double>();

		listOfTemperrature = dataContainer.getListOfTemperrature();

		assertNotNull(listOfTemperrature);
		Double index = new Double(1);
		for (Double temperature : listOfTemperrature) {
			

			assertTrue(temperature.equals(index));

			index++;
		}

	}

	@Test
	public void testReceivedTemperatureData() throws JsonProcessingException {
		dataContainer = new DataContainer();
		dataContainer.setBatteryParameters(batteryParameters);
		IReceiver iReceiver = new ReceiveFrmConsoleImpl();
		iReceiver.processBatteryParametes(dataContainer);

		List<Double> listOfSoc = new LinkedList<Double>();

		listOfSoc = dataContainer.getListOfSoc();

		assertNotNull(listOfSoc);
		Double index = new Double(1);
		for (Double soc : listOfSoc) {
			assertTrue(soc.equals(30 + index));

			index++;
		}
	}

	@Test
	public void testReceivedDataAverage() throws JsonProcessingException {

		DataUtil dataUtil = new DataUtil();
		dataContainer = new DataContainer();
		dataContainer.setBatteryParameters(batteryParameters);
		IReceiver iReceiver = new ReceiveFrmConsoleImpl();
		iReceiver.processBatteryParametes(dataContainer);

		List<Double> listOfSoc = new LinkedList<Double>();
		List<Double> listOfTemperrature = new LinkedList<Double>();

		listOfTemperrature = dataContainer.getListOfTemperrature();
		Double average = dataUtil.findAverage(listOfTemperrature,5);
		assertNotNull(average);
		assertTrue(average.equals(48.0));
		
		listOfSoc = dataContainer.getListOfSoc();
		average = dataUtil.findAverage(listOfSoc,5);
		assertNotNull(average);
		assertTrue(average.equals(78.0));

	}
	
	@Test
	public void testReceivedMinimumValue() throws JsonProcessingException {

		DataUtil dataUtil = new DataUtil();
		dataContainer = new DataContainer();
		dataContainer.setBatteryParameters(batteryParameters);
		IReceiver iReceiver = new ReceiveFrmConsoleImpl();
		iReceiver.processBatteryParametes(dataContainer);

		List<Double> listOfSoc = new LinkedList<Double>();
		List<Double> listOfTemperrature = new LinkedList<Double>();

		listOfTemperrature = dataContainer.getListOfTemperrature();
		Double minValue = dataUtil.findMin(listOfTemperrature);
		Double maxValue = dataUtil.findMax(listOfTemperrature);
		assertNotNull(minValue);
		assertTrue(minValue.equals(1.0));
		
		assertNotNull(maxValue);
		assertTrue(maxValue.equals(50.0));
		
		listOfSoc = dataContainer.getListOfSoc();
		 minValue = dataUtil.findMin(listOfSoc);
		 maxValue = dataUtil.findMax(listOfSoc);
		assertNotNull(minValue);
		assertTrue(minValue.equals(31.0));
		
		assertNotNull(maxValue);
		assertTrue(maxValue.equals(80.0));

	}

}
