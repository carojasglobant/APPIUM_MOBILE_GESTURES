package com.java;

import com.java.base.BaseTest;
import com.java.screens.WelcomeScreen;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplorationTest extends BaseTest {

  @Test(testName = "Generate Error")
  @Description("Generate Error and take screenshot")
  public void test01() {
    WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
    welcomeScreen.isTheScreenDisplayed();
    welcomeScreen.uiAutomatorDoubleTap();
    Assert.assertTrue(false);
  }
}
