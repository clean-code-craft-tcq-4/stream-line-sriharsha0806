package com.tcq.training.bms.battery.parameters;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Sample_no",
"SOC Sensor",
"Temperature Sensor",
"Battery Sensor"
})
@JsonRootName(value = "BatteryParameters")
public class BatteryParameters {

	@JsonProperty("Sample_no")
	Double sampleNo;

	@JsonProperty("SOC Sensor")
	Double soc;

	@JsonProperty("Temperature Sensor")
	Double temperature;

	@JsonProperty("Battery Sensor")
	Double batterySensor;

	/**
	 * Get the State-of-charge
	 * 
	 * @return soc
	 */
	@JsonProperty("SOC Sensor")
	public Double getSoc() {
		return soc;
	}

	/**
	 * Set the State-of-charge
	 * 
	 * @param soc
	 */
	@JsonProperty("SOC Sensor")
	public void setSoc(Double soc) {
		this.soc = soc;
	}

	/**
	 * Get battery Temperature
	 * 
	 * @return temperature
	 */
	@JsonProperty("Temperature Sensor")
	public Double getTemperature() {
		return temperature;
	}

	/**
	 * Set battery Temperature
	 * 
	 * @param temperature
	 */
	@JsonProperty("Temperature Sensor")
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	@JsonProperty("Sample_no")
	public Double getSampleNo() {
		return sampleNo;
	}

	@JsonProperty("Sample_no")
	public void setSampleNo(Double sampleNo) {
		this.sampleNo = sampleNo;
	}

	@JsonProperty("Battery Sensor")
	public Double getBatterySensor() {
		return batterySensor;
	}

	@JsonProperty("Battery Sensor")
	public void setBatterySensor(Double batterySensor) {
		this.batterySensor = batterySensor;
	}

	@Override
	public String toString() {
		return "BatteryParameters [ sampleNo=" + sampleNo + ", soc=" + soc + ", temperature=" + temperature
				+ ", batterySensor=" + batterySensor + "]";
	}

}
