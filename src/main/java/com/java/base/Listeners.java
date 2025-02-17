package com.java.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

  Logger logger = LoggerFactory.getLogger(Listeners.class);

  @Override
  public void onTestFailure(ITestResult result) {
    logger.info("FAILED TEST: " + result.getStatus());
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    logger.info("SUCCESSFUL: " + result.getStatus());
  }
}
