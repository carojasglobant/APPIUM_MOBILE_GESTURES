package com.java;

import com.java.base.BaseTest;
import com.java.screens.ProductsScreen;
import com.java.screens.WelcomeScreen;
import org.testng.annotations.Test;

public class UiAutomator2GesturesTest extends BaseTest {
  @Test(testName = "Double Tap")
  public void test01() {
    WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
    welcomeScreen.isTheScreenDisplayed();
    welcomeScreen.uiAutomatorDoubleTap();
    welcomeScreen.isTheScreenDisplayed();
  }

  @Test(testName = "Swipe Down")
  public void test03() {
    WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
    welcomeScreen.isTheScreenDisplayed();
    ProductsScreen productsScreen = welcomeScreen.performLogIn("standard_user", "secret_sauce");
    productsScreen.validateTheProductScreenIsVisible();
    productsScreen.swipeDownWithUiAutomator2Actions(1);
    productsScreen.validateTheProductScreenIsVisible();
  }
}
