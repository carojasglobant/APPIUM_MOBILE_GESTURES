package com.java.screens;

import static com.java.utils.WaitActions.isTheElementVisible;

import com.java.base.BaseScreen;
import com.java.utils.ActionGestures;
import com.java.utils.DriverSpecificGestures;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class SwipeScreen extends BaseScreen {
  AppiumBy lblSwipeHorizontally =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Swipe horizontal\")");

  AppiumBy imgWebDriverLogo =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"WebdriverIO logo\")");

  protected SwipeScreen(AndroidDriver driver) {
    super(driver);
  }

  public void isTheSwipeScreenDisplayed() {
    Assert.assertTrue(
      isTheElementVisible(getMobileDriver()
        .findElement(lblSwipeHorizontally), 20));
  }

  public void swipeDownWithActionGesturesUntilTheRobotIsVisible() {
    for (int i = 0; i < 5; i++) {
      if (isTheElementVisible(imgWebDriverLogo, 5)) {
        break;
      } else {
        ActionGestures.swipeDown();
      }
    }
    Assert
      .assertTrue(isTheElementVisible(
        imgWebDriverLogo, 5));
  }

  public void swipeDownWithSpecificDriverGesturesUntilTheRobotIsVisible() {
    for (int i = 0; i < 5; i++) {
      if (isTheElementVisible(imgWebDriverLogo, 5)) {
        break;
      } else {
        DriverSpecificGestures.swipeDown();
      }
    }
    Assert
      .assertTrue(isTheElementVisible(
        imgWebDriverLogo, 5));
  }
}
