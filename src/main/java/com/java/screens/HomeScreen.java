package com.java.screens;

import static com.java.utils.WaitActions.isTheElementVisible;

import com.java.base.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomeScreen extends BaseScreen {

  AppiumBy btnHome = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Home\")");

  AppiumBy btnWebView = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Webview\")");

  AppiumBy btnSwipe = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Swipe\")");

  AppiumBy btnDrag = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Drag\")");

  public HomeScreen(AndroidDriver driver) {
    super(driver);
  }

  public WebViewScreen clickOnWebViewButton() {
    click(getMobileDriver().findElement(btnWebView), "Tap on webview button");
    return new WebViewScreen(getMobileDriver());
  }

  public SwipeScreen clickOnSwipeButton() {
    click(getMobileDriver().findElement(btnSwipe), "Tap on swipe button");
    return new SwipeScreen(getMobileDriver());
  }

  public DragScreen clickOnDragScreen() {
    click(getMobileDriver().findElement(btnDrag), "Tap on swipe button");
    return new DragScreen(getMobileDriver());
  }
}
