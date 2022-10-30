package com.tcq.training.bms.receiver.api;

import com.tcq.training.bms.receiver.loggerImpl.ConsoleLogger;
import com.tcq.training.bms.receiver.loggerImpl.ReceiveFrmConsoleImpl;

public class Factory {

	/**
	 * Initialize and Returns the object of Logger
	 * 
	 * @param logger type
	 * @return object of Logger
	 */
	public static ILogger getLogger(String logger) {

		if (logger != null && !logger.isEmpty()) {
			if (logger.equalsIgnoreCase("console")) {
				return new ConsoleLogger();
			}
		}
		return null;

	}

	public static IReceiver getReceiver(String receiver) {

		if (receiver != null && !receiver.isEmpty()) {
			if (receiver.equalsIgnoreCase("console")) {
				return new ReceiveFrmConsoleImpl();
			}
		}
		return null;

	}
}
