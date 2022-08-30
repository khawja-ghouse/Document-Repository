package com.skg.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SL4JDemo {

	private static Logger logger = LoggerFactory.getLogger(SL4JDemo.class);

	public static void main(String[] args) {
		logger.trace("Trace Logger .......");
		logger.debug("Debug Logger........");
		logger.info("Info Logger..........");
		logger.warn("Warning Logger ......");
		logger.error("Error Logger........");
	}

}
