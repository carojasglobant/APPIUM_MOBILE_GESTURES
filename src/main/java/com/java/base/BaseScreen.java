package com.java.base;

import io.appium.java_client.android.AndroidDriver;

public class BaseScreen {

  private AndroidDriver driver;

  protected BaseScreen(AndroidDriver driver) {
    this.driver = driver;
  }

  public AndroidDriver getMobileDriver() {
    return driver;
  }
}
