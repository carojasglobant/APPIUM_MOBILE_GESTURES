package com.java.screens;

import com.java.base.BaseScreen;
import com.java.utils.ActionGestures;
import com.java.utils.DriverSpecificGestures;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

public class LogInScreen extends BaseScreen {

  AppiumBy btnLogIn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"button-LOGIN\")");

  AppiumBy btnSignUp = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Sign up\")");
  protected LogInScreen(AndroidDriver driver) {
    super(driver);
  }

  @Step("Long Click on Log In button")
  public LogInScreen longClickLogInButton() {
    ActionGestures.longClickGesture(getMobileDriver().findElement(btnLogIn), 150, 80, 10 );
    DriverSpecificGestures.longClickGesture(getMobileDriver().findElement(btnSignUp), 100, 20, 10000 );
    return new LogInScreen(getMobileDriver());
  }
}
