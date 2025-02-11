package com.java.screens;

import com.java.base.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

public class HomeScreen extends BaseScreen {

  AppiumBy btnHome = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Home\")");

  AppiumBy btnWebView = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Webview\")");

  AppiumBy btnSwipe = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Swipe\")");

  AppiumBy btnDrag = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Drag\")");

  AppiumBy btnLogIn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Login\")");

  public HomeScreen(AndroidDriver driver) {
    super(driver);
  }

  @Step("Click on Web view button")
  public WebViewScreen clickOnWebViewButton() {
    click(getMobileDriver().findElement(btnWebView), "Tap on webview button");
    return new WebViewScreen(getMobileDriver());
  }

  @Step("Click on Swipe button")
  public SwipeScreen clickOnSwipeButton() {
    click(getMobileDriver().findElement(btnSwipe), "Tap on swipe button");
    return new SwipeScreen(getMobileDriver());
  }

  @Step("Click on Drag button")
  public DragScreen clickOnDragButton() {
    click(getMobileDriver().findElement(btnDrag), "Tap on Drag button");
    return new DragScreen(getMobileDriver());
  }

  @Step("Click on Log In button")
  public LogInScreen clickOnLogInButton() {
    click(getMobileDriver().findElement(btnLogIn), "Tap on Log In button");
    return new LogInScreen(getMobileDriver());
  }
}
