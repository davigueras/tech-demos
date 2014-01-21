package com.davigueras.slf4j01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example3Foo {

	  static final Logger logger2 = LoggerFactory.getLogger(Example3Foo.class);
	  
	  public void doIt() {
		  logger2.debug("Did it again!");
	  }
	
}
