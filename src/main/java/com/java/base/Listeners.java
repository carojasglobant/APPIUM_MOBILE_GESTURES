package com.java.base;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

  @Override
  public void onTestFailure(ITestResult result) {
    System.out.println("Fail " + result.getTestName());
    System.out.println("Taking screenshots");
  }
}
