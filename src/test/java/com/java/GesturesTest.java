package com.java;

import com.java.base.BaseTest;
import com.java.screens.CongratulationsScreen;
import com.java.screens.DragScreen;
import com.java.screens.HomeScreen;
import com.java.screens.SwipeScreen;
import com.java.screens.WebViewScreen;
import org.testng.annotations.Test;

public class GesturesTest extends BaseTest {

  @Test(description = "Open tha App and navigate to webview screen")
  public void test1() {
    HomeScreen homeScreen = new HomeScreen(driver);
    WebViewScreen webViewScreen = homeScreen.clickOnWebViewButton();
    webViewScreen.isTheWebViewScreenDisplayed();
  }

  @Test(description = "Navigate to the swipe screen and find the robot using Action gestures")
  public void test2() {
    HomeScreen homeScreen = new HomeScreen(driver);
    SwipeScreen swipeScreen = homeScreen.clickOnSwipeButton();
    swipeScreen.isTheSwipeScreenDisplayed();
    swipeScreen.swipeDownWithActionGesturesUntilTheRobotIsVisible();
  }

  @Test(description = "Navigate to the swipe screen and find the robot using specific drivers gestures")
  public void test3() {
    HomeScreen homeScreen = new HomeScreen(driver);
    SwipeScreen swipeScreen = homeScreen.clickOnSwipeButton();
    swipeScreen.isTheSwipeScreenDisplayed();
    swipeScreen.swipeDownWithSpecificDriverGesturesUntilTheRobotIsVisible();
  }

  @Test(description = "Navigate to the Drag screen and complete the puzzle")
  public void test4() {
    HomeScreen homeScreen = new HomeScreen(driver);
    DragScreen dragScreen = homeScreen.clickOnDragScreen();
    CongratulationsScreen congratulationsScreen = dragScreen.completePuzzle();
    congratulationsScreen.validateLabelCongratulations();
  }
}
