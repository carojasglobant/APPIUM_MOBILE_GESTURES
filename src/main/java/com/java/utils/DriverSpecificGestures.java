package com.java.utils;

import static com.java.base.BaseTest.getDriver;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.TouchAction;

public class DriverSpecificGestures {

  public static void swipeDown() {
    getDriver().executeScript("mobile: swipeGesture", ImmutableMap.of(
      "left", 100, "top", 100, "width", 200, "height", 200,
      "direction", "up",
      "percent", 0.75
    ));
  }
}
