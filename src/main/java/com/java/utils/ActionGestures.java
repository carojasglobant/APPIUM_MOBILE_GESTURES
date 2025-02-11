package com.java.utils;

import static com.java.base.BaseTest.getDriver;

import io.qameta.allure.Step;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

public class ActionGestures {

  /**
   * Swiping the screen vertically by percentage
   */
  @Step("Swipe down")
  public static void swipeDown() {
    int width = getDriver().manage().window().getSize().getWidth();
    int height = getDriver().manage().window().getSize().getHeight();
    int centerX = width / 2;
    int startY = (int) (height * 0.5);
    int endY = (int) (height * 0.1);

    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

    Sequence sequence = new Sequence(finger1, 0)
      .addAction(
        finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY))
      .addAction(
        finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
      .addAction(
        finger1.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), centerX,
          endY))
      .addAction(
        finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    getDriver().perform(List.of(sequence));
  }

  @Step("Drag {0} and drop into {1}")
  public static void dragAndDrop(WebElement element, WebElement position) {
    int centerElementX = (element.getSize().width / 2) + element.getRect().getX();
    int centerElementY = (element.getSize().height / 2) + element.getRect().getY();

    int centerPositionX = (position.getSize().width / 2) + position.getRect().getX();
    int centerPositionY = (position.getSize().height / 2) + position.getRect().getY();

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence sequence = new Sequence(finger, 0)
      .addAction(
        finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
          centerElementX,
          centerElementY))
      .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
      .addAction(new Pause(finger, Duration.ofMillis(100)))
      .addAction(
        finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(),
          centerPositionX,
          centerPositionY))
      .addAction(new Pause(finger, Duration.ofMillis(100)))
      .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    getDriver().perform(List.of(sequence));
  }

  public static void longClickGesture(WebElement element, int xOffset, int yOffset,
                                      int durationSeconds) {

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    Sequence sequence = new Sequence(finger, 0)
      .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
        element.getRect().getX() + xOffset, element.getRect().getY() + yOffset))
      .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
      .addAction(new Pause(finger, Duration.ofSeconds(durationSeconds)))
      .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    getDriver().perform(List.of(sequence));

  }
}
