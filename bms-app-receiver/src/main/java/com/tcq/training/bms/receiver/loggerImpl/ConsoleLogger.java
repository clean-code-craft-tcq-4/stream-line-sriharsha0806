package com.tcq.training.bms.receiver.loggerImpl;

import com.tcq.training.bms.receiver.api.ILogger;

public class ConsoleLogger implements ILogger {

	@Override
	public void log(String data) {
		System.out.println(data);
	}

}
