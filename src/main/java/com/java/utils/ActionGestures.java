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
  public static void swipe(int percentageStartX, int percentageStartY, int percentageEndX,
                           int percentageEndY) {
    int width = getDriver().manage().window().getSize().getWidth();
    int height = getDriver().manage().window().getSize().getHeight();
    int startPositionX = width * percentageStartX;
    int endPositionX = width * percentageEndX;
    int startPositionY = height * percentageStartY;
    int endPositionY = height * percentageEndY;

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    Sequence sequence = new Sequence(finger, 0)
      .addAction(
        finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startPositionX,
          startPositionY))
      .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
      .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
        endPositionX, endPositionY))
      .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
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

  @Step("Double Tap on {0}")
  public static void doubleTap(WebElement element) {

    int centerElementX = (element.getSize().width / 2) + element.getRect().getX();
    int centerElementY = (element.getSize().height / 2) + element.getRect().getY();

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    Sequence sequence = new Sequence(finger, 0)
      .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
        centerElementX, centerElementY))
      .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
      .addAction(new Pause(finger, Duration.ofMillis(100)))
      .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
      .addAction(new Pause(finger, Duration.ofMillis(100)))
      .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
      .addAction(new Pause(finger, Duration.ofMillis(100)))
      .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    getDriver().perform(List.of(sequence));
  }

  @Step("Double Tap on {0}")
  public static void tap(WebElement element) {
    int X = (element.getSize().width / 2) + element.getRect().getX();
    int Y = (element.getSize().height / 2) + element.getRect().getY();

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence sequence = new Sequence(finger, 0)
      .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), X, Y))
      .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
      .addAction(new Pause(finger, Duration.ofMillis(100)))
      .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    getDriver().perform(List.of(sequence));
  }

  @Step("Navigate back")
  public static void navigateBack() {
    getDriver().navigate().back();
  }

  @Step("Drag {0} and drop into {1}")
  public static void zoomIn(WebElement element, int distance) {
    int fingerOneStartPositionX = element.getRect().getX();
    int fingerOneStartPositionY = element.getRect().getY();
    int fingerOneEndPositionX = (element.getRect().getX() - distance);
    int fingerOneEndPositionY = (element.getRect().getY() - distance);
    int fingerTwoStartPositionX = element.getSize().width + element.getRect().getX();
    int fingerTwoStartPositionY = element.getSize().height + element.getRect().getY();
    int fingerTwoEndPositionX = element.getSize().width + element.getRect().getX() + distance;
    int fingerTwoEndPositionY = element.getSize().height + element.getRect().getY() + distance;

    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

    Sequence sequence1 = new Sequence(finger1, 0)
      .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), fingerOneStartPositionX, fingerOneStartPositionY))
      .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
      .addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), fingerOneEndPositionX, fingerOneEndPositionY))
      .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    Sequence sequence2 = new Sequence(finger2, 0)
      .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), fingerTwoStartPositionX, fingerTwoStartPositionY))
      .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
      .addAction(finger2.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), fingerTwoEndPositionX, fingerTwoEndPositionY))
      .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    getDriver().perform(List.of(sequence1, sequence2));
  }
}
