package com.java;

import com.java.base.BaseTest;
import com.java.screens.HomeScreen;
import org.testng.annotations.Test;

public class ActionGesturesTest extends BaseTest {

  @Test(testName = "Open the app and validate the home screen")
  public void test_01() {
    HomeScreen homeScreen = new HomeScreen(driver);
    homeScreen.isTheHomeScreenDisplayed();
  }

  @Test(testName = "Double Tap with W3C actions")
  public void test_02() {
    HomeScreen homeScreen = new HomeScreen(driver);
    homeScreen.isTheHomeScreenDisplayed();
    homeScreen.tapTwoTimesWithW3Cations();
    homeScreen.isTheHomeScreenDisplayed();
  }
}
