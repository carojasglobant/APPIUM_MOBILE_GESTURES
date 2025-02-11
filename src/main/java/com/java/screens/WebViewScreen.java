package com.java.screens;

import static com.java.utils.WaitActions.isTheElementVisible;

import com.java.base.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class WebViewScreen extends BaseScreen {

  AppiumBy lblWebViewText = new AppiumBy
    .ByAndroidUIAutomator(
    "new UiSelector().textContains(\"Next-gen browser and mobile automation\")");

  protected WebViewScreen(AndroidDriver driver) {
    super(driver);
  }

  public void isTheWebViewScreenDisplayed() {
    Assert.assertTrue(
      isTheElementVisible(getMobileDriver()
        .findElement(lblWebViewText), 20));
  }
}
