package com.java.screens;

import static com.java.utils.ActionGestures.dragAndDrop;
import static com.java.utils.WaitActions.isTheElementVisible;

import com.java.base.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class DragScreen extends BaseScreen {
  AppiumBy dragPiece2 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drag-c1\")");
  AppiumBy dropPiece2 =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"drop-c1\")");

  protected DragScreen(AndroidDriver driver) {
    super(driver);
  }

  public void completePuzzle() {
    if (isTheElementVisible(dragPiece2, 5) && isTheElementVisible(dropPiece2, 5)) {
      dragAndDrop(getMobileDriver().findElement(dragPiece2),
        getMobileDriver().findElement(dropPiece2));
    }
  }
}
