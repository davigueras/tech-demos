package com.davigueras.slf4j01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class Example3 {

	final static Logger logger1 = LoggerFactory.getLogger(Example3.class);	
	
	public static void main(String[] args) {
		// print internal state
	    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
	    StatusPrinter.print(lc);
		
		
	    logger1.info("Entering application.");

	    Example3Foo foo = new Example3Foo();
	    foo.doIt();
	    logger1.info("Exiting application.");
	
	}
}
