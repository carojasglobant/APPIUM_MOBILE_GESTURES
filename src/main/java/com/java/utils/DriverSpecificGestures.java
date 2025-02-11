package com.java.utils;

import static com.java.base.BaseTest.getDriver;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class DriverSpecificGestures {

  public static void swipeDown() {
    int width = getDriver().manage().window().getSize().getWidth()/2;
    int height = getDriver().manage().window().getSize().getHeight()/2;

    getDriver().executeScript("mobile: swipeGesture", ImmutableMap.of(
      "left", width/2,
      "top", height/2,
      "width", width/2,
      "height", height/2,
      "direction", "up",
      "percent", 0.5
    ));
  }

  public static void longClickGesture(WebElement element, int xOffset, int yOffset, int durationMillis) {
    getDriver().executeScript("mobile: longClickGesture", ImmutableMap.of(
      "elementId", ((RemoteWebElement) element).getId(),
      "x", xOffset,
      "y", yOffset,
      "duration", durationMillis
    ));
  }
}
