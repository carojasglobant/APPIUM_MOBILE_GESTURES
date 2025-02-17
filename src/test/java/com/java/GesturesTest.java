package com.java;

import com.java.base.BaseTest;
import com.java.screens.CongratulationsScreen;
import com.java.screens.DragScreen;
import com.java.screens.HomeScreen;
import com.java.screens.LogInScreen;
import com.java.screens.SwipeScreen;
import com.java.screens.WebViewScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GesturesTest extends BaseTest {

  @Test(description = "Open the App and navigate to webview screen", testName = "Navigate to webview")
  public void test1() {
    HomeScreen homeScreen = new HomeScreen(driver);
    WebViewScreen webViewScreen = homeScreen.clickOnWebViewButton();
    webViewScreen.isTheWebViewScreenDisplayed();
  }

  @Test(description = "Navigate to the swipe screen and find the robot using Action gestures", testName = "Find robot using action swipe")
  public void test2() {
    HomeScreen homeScreen = new HomeScreen(driver);
    SwipeScreen swipeScreen = homeScreen.clickOnSwipeButton();
    swipeScreen.isTheSwipeScreenDisplayed();
    swipeScreen.swipeDownWithActionGesturesUntilTheRobotIsVisible();
  }

  @Test(description = "Navigate to the swipe screen and find the robot using specific drivers gestures", testName = "Find robot using specific gesture swipe")
  public void test3() {
    HomeScreen homeScreen = new HomeScreen(driver);
    SwipeScreen swipeScreen = homeScreen.clickOnSwipeButton();
    swipeScreen.isTheSwipeScreenDisplayed();
    swipeScreen.swipeDownWithSpecificDriverGesturesUntilTheRobotIsVisible();
  }

  @Test(description = "Navigate to the Drag screen and complete the puzzle", testName = "Drag and Drop")
  public void test4() {
    HomeScreen homeScreen = new HomeScreen(driver);
    DragScreen dragScreen = homeScreen.clickOnDragButton();
    CongratulationsScreen congratulationsScreen = dragScreen.completePuzzle();
    congratulationsScreen.validateLabelCongratulations();
  }

  @Test(description = "Navigate to the log in screen and long press the login button", testName = "Long Press")
  public void test5() {
    HomeScreen homeScreen = new HomeScreen(driver);
    LogInScreen logInScreen = homeScreen.clickOnLogInButton();
    logInScreen.longClickLogInButton();
  }

  @Test(description = "Generate error and see the attachment in the report", testName = "Error")
  public void test6() {
    HomeScreen homeScreen = new HomeScreen(driver);
    LogInScreen logInScreen = homeScreen.clickOnLogInButton();
    Assert.assertTrue(false);
  }

  @Test(description = "Navigate to the log in screen and double tap the login button", testName = "Double Tap")
  public void test7() {
    HomeScreen homeScreen = new HomeScreen(driver);
    LogInScreen logInScreen = homeScreen.clickOnLogInButton();
    logInScreen.doubleTapLogInButton();
  }
}
