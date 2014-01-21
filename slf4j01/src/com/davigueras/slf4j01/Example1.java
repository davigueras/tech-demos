package com.davigueras.slf4j01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class Example1 {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger("com.davigueras.h2hibernate.Example1");
		logger.debug("Hello world.");

		// print internal state
	    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
	    StatusPrinter.print(lc);
	}
}