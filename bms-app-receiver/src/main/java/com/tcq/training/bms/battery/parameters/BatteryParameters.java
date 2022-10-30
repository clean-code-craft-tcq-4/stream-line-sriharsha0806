package com.tcq.training.bms.battery.parameters;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"sampleNo",
"soc",
"temperature",
"batterySensor"
})
@JsonRootName(value = "BatteryParameters")
public class BatteryParameters {

	@JsonProperty("sampleNo")
	Double sampleNo;

	@JsonProperty("soc")
	Double soc;

	@JsonProperty("temperature")
	Double temperature;

	@JsonProperty("batterySensor")
	Double batterySensor;

	/**
	 * Get the State-of-charge
	 * 
	 * @return soc
	 */
	@JsonProperty("soc")
	public Double getSoc() {
		return soc;
	}

	/**
	 * Set the State-of-charge
	 * 
	 * @param soc
	 */
	@JsonProperty("soc")
	public void setSoc(Double soc) {
		this.soc = soc;
	}

	/**
	 * Get battery Temperature
	 * 
	 * @return temperature
	 */
	@JsonProperty("temperature")
	public Double getTemperature() {
		return temperature;
	}

	/**
	 * Set battery Temperature
	 * 
	 * @param temperature
	 */
	@JsonProperty("temperature")
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	@JsonProperty("sampleNo")
	public Double getSampleNo() {
		return sampleNo;
	}

	@JsonProperty("sampleNo")
	public void setSampleNo(Double sampleNo) {
		this.sampleNo = sampleNo;
	}

	@JsonProperty("batterySensor")
	public Double getBatterySensor() {
		return batterySensor;
	}

	@JsonProperty("batterySensor")
	public void setBatterySensor(Double batterySensor) {
		this.batterySensor = batterySensor;
	}

	@Override
	public String toString() {
		return "BatteryParameters [ sampleNo=" + sampleNo + ", soc=" + soc + ", temperature=" + temperature
				+ ", batterySensor=" + batterySensor + "]";
	}

}
