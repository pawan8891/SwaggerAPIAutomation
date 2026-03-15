package com.api.listeners;

import java.awt.event.ItemListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{
	 private static final Logger logger = LogManager.getLogger(TestListener.class);
	 
	public void onStart(ITestContext context) {
        logger.info("Test Started: {}");
    }

	  public void onTestStart(ITestResult result) {
	        logger.info("Test Started: {}", result.getMethod().getMethodName());
	        logger.info("Description: {}", result.getMethod().getDescription());
		  }
	  
    public void onTestSuccess(ITestResult result) {
        logger.info("Test Passed: {}", result.getMethod().getMethodName());

    }

  
    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed: {}", result.getMethod().getMethodName());
        logger.error("Exception: ", result.getThrowable());
    }
    
    public void onTestSkipped(ITestResult result) {
    	logger.info("Test Skipped: {}", result.getMethod().getMethodName());
    }

    public void onFinish(ITestContext context) {
    	logger.info("Test Completed: {}");
      }
}
