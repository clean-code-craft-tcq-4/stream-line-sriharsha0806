package com.tcq.training.bms.dataContainer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.tcq.training.bms.battery.parameters.BatteryParameters;

public class DataContainer {

	List<Double> listOfSoc = new LinkedList<Double>();

	List<Double> listOfTemperrature = new LinkedList<Double>();

	public List<Double> getListOfTemperrature() {
		return listOfTemperrature;
	}

	public void setListOfTemperrature(List<Double> listOfTemperrature) {
		this.listOfTemperrature = listOfTemperrature;
	}

	List<BatteryParameters> batteryParameters = new ArrayList<BatteryParameters>();

	public List<BatteryParameters> getBatteryParameters() {
		return batteryParameters;
	}

	public List<Double> getListOfSoc() {
		return listOfSoc;
	}

	public void setListOfSoc(List<Double> listOfSoc) {
		this.listOfSoc = listOfSoc;
	}

	public void setBatteryParameters(List<BatteryParameters> batteryParameters) {
		this.batteryParameters = batteryParameters;
	}

}
