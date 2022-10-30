package com.tcq.training.bms.dataContainer;

import java.util.List;
import java.util.OptionalDouble;

public class DataUtil {

	/**
	 * Find minimum value of given data
	 * 
	 * @param data
	 * @return minimum value
	 */
	public Double findMin(List<Double> data) {
		return data.stream().min(Double::compare).get();

	}

	/**
	 * Find max value of given data
	 * 
	 * @param data
	 * @return max value
	 */
	public Double findMax(List<Double> data) {
		return data.stream().max(Double::compare).get();

	}

	/**
	 * Find average of last N no of elements
	 * 
	 * @param data
	 * @param delimiter
	 * @return average
	 */
	public Double findAverage(List<Double> data, int delimiter) {
		if (data.size() > delimiter)
			data = data.subList(data.size() - delimiter, data.size());
		OptionalDouble avg = data.stream().mapToDouble(it -> it).average();
		if (avg.isPresent()) {
			return avg.getAsDouble();
		}
		return null;
	}
}
