package com.restassured;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	  protected final Logger logger = Logger.getLogger(TestBase.class);
	    
	    @BeforeSuite
	    public void setup()
	    {
	    	//logger = Logger.getLogger(TestBase.class);
	    	logger.getRootLogger().setLevel(Level.INFO);
			BasicConfigurator.configure();
	        //logger.setLevel(Level.DEBUG);
	    }

}
