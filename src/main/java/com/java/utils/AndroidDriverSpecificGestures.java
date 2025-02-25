package com.java.utils;

import static com.java.base.BaseTest.getDriver;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidDriverSpecificGestures {

  public static void swipe(WebElement element, Directions direction, Double percent) {
    int width = getDriver().manage().window().getSize().getWidth()/2;
    int height = getDriver().manage().window().getSize().getHeight()/2;

    getDriver().executeScript("mobile: swipeGesture", ImmutableMap.of(
      "elementId", ((RemoteWebElement) element).getId(),
      "direction", direction.getDirection(),
      "percent", percent
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

  public static void doubleTap(WebElement element, int xOffset, int yOffset) {
    ((JavascriptExecutor) getDriver()).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
      "elementId", ((RemoteWebElement) element).getId(),
      "x", xOffset,
      "y", yOffset
    ));
  }

  public static void dragAndDrop(WebElement elementToDrag, WebElement elementToBeReached) {
   int endX =
     (int) (elementToBeReached.getRect().getX() + elementToBeReached.getRect().getWidth()*0.5);
    int endY =
      (int) (elementToBeReached.getRect().getY() + elementToBeReached.getRect().getY()*0.5);

    ((JavascriptExecutor) getDriver()).executeScript("mobile: dragGesture", ImmutableMap.of(
      "elementId", ((RemoteWebElement) elementToDrag).getId(),
      "endX", endX,
      "endY", endY
    ));
  }
}
