package com.java.screens;

import static com.java.base.BaseTest.getDriver;
import static com.java.utils.Actions.click;

import com.java.base.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomeScreen extends BaseScreen {

  AppiumBy btnHome = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Home\")");

  AppiumBy btnWebView = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Webview\")");

  public HomeScreen(AndroidDriver driver) {
    super(driver);
  }

  public WebViewScreen clickOnWebViewButton() {
    click(getMobileDriver().findElement(btnWebView), "Tap on webview button");
    return new WebViewScreen(getMobileDriver());
  }
}
