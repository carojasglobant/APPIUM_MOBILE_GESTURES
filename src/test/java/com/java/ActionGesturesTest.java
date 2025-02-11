package com.java;

import com.java.base.BaseTest;
import com.java.screens.HomeScreen;
import com.java.screens.WebViewScreen;
import org.testng.annotations.Test;

public class ActionGesturesTest extends BaseTest {

  @Test(description = "Open tha App and navigate to webview screen")
  public void test1() {
    HomeScreen homeScreen = new HomeScreen(driver);
    WebViewScreen webViewScreen = homeScreen.clickOnWebViewButton();
    webViewScreen.isTheWebViewScreenDisplayed();
  }
}
