package com.java.utils;

import static com.java.base.BaseTest.getDriver;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

public class ActionGestures {

  /**
   * Swiping the screen vertically by percentage
   */
  public static void swipeDown() {
    int width = getDriver().manage().window().getSize().getWidth();
    int height = getDriver().manage().window().getSize().getHeight();
    int centerX =  width / 2;
    int startY = (int) (height * 0.5);
    int endY = (int) (height * 0.1);

    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

    Sequence sequence = new Sequence(finger1,0)
      .addAction(
        finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY))
      .addAction(
        finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
      .addAction(
        finger1.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), centerX, endY))
      .addAction(
        finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    getDriver().perform(List.of(sequence));
  }
}
