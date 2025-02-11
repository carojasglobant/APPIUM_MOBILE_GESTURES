package com.java.screens;

import static com.java.utils.ActionGestures.dragAndDrop;

import com.java.base.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

public class DragScreen extends BaseScreen {
  AppiumBy dragPiece1 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drag-l1\")");
  AppiumBy dropPiece1 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drop-l1\")");

  AppiumBy dragPiece2 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drag-c1\")");
  AppiumBy dropPiece2 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drop-c1\")");

  AppiumBy dragPiece3 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drag-r1\")");
  AppiumBy dropPiece3 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drop-r1\")");

  AppiumBy dragPiece4 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drag-l2\")");
  AppiumBy dropPiece4 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drop-l2\")");

  AppiumBy dragPiece5 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drag-c2\")");
  AppiumBy dropPiece5 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drop-c2\")");

  AppiumBy dragPiece6 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drag-r2\")");
  AppiumBy dropPiece6 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drop-r2\")");

  AppiumBy dragPiece7 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drag-l3\")");
  AppiumBy dropPiece7 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drop-l3\")");

  AppiumBy dragPiece8 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drag-c3\")");
  AppiumBy dropPiece8 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drop-c3\")");

  AppiumBy dragPiece9 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drag-r3\")");
  AppiumBy dropPiece9 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drop-r3\")");

  protected DragScreen(AndroidDriver driver) {
    super(driver);
  }

  @Step("Complete the puzzle")
  public CongratulationsScreen completePuzzle() {
    dragAndDrop(getMobileDriver().findElement(dragPiece1),
      getMobileDriver().findElement(dropPiece1));

    dragAndDrop(getMobileDriver().findElement(dragPiece2),
      getMobileDriver().findElement(dropPiece2));

    dragAndDrop(getMobileDriver().findElement(dragPiece3),
      getMobileDriver().findElement(dropPiece3));

    dragAndDrop(getMobileDriver().findElement(dragPiece4),
      getMobileDriver().findElement(dropPiece4));

    dragAndDrop(getMobileDriver().findElement(dragPiece5),
      getMobileDriver().findElement(dropPiece5));

    dragAndDrop(getMobileDriver().findElement(dragPiece6),
      getMobileDriver().findElement(dropPiece6));

    dragAndDrop(getMobileDriver().findElement(dragPiece7),
      getMobileDriver().findElement(dropPiece7));

    dragAndDrop(getMobileDriver().findElement(dragPiece8),
      getMobileDriver().findElement(dropPiece8));

    dragAndDrop(getMobileDriver().findElement(dragPiece9),
      getMobileDriver().findElement(dropPiece9));

    return new CongratulationsScreen(getMobileDriver());
  }
}

