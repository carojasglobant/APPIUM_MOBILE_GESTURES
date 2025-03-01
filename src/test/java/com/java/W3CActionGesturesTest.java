package com.java;

import com.java.base.BaseTest;
import com.java.screens.ProductDetailScreen;
import com.java.screens.ProductsScreen;
import com.java.screens.WelcomeScreen;
import org.testng.annotations.Test;

public class W3CActionGesturesTest extends BaseTest {

  @Test(testName = "Perform Log In")
  public void test01() {
    WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
    welcomeScreen.isTheScreenDisplayed();
    ProductsScreen productsScreen = welcomeScreen.performLogIn("standard_user", "secret_sauce");
    productsScreen.validateTheProductScreenIsVisible();
  }

  @Test(testName = "Zoom In")
  public void test02() {
    WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
    welcomeScreen.isTheScreenDisplayed();
    ProductsScreen productsScreen = welcomeScreen.performLogIn("standard_user", "secret_sauce");
    productsScreen.validateTheProductScreenIsVisible();
    ProductDetailScreen productDetailScreen = productsScreen.tapOnTheFirstProduct();
    productDetailScreen.zoomInProductImage();
    productDetailScreen.validateTheProductDetailScreenIsDisplayed();
  }

  @Test(testName = "Swipe Down")
  public void test03() {
    WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
    welcomeScreen.isTheScreenDisplayed();
    ProductsScreen productsScreen = welcomeScreen.performLogIn("standard_user", "secret_sauce");
    productsScreen.validateTheProductScreenIsVisible();
    productsScreen.swipeDownWithW3CActions(2);
  }

  @Test(testName = "Long Press")
  public void test04() {
    WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
    welcomeScreen.isTheScreenDisplayed();
    welcomeScreen.w3CLongPressLogInButton();
  }

  @Test(testName = "Drag and drop")
  public void test05() {
    WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
    welcomeScreen.isTheScreenDisplayed();
    ProductsScreen productsScreen = welcomeScreen.performLogIn("standard_user", "secret_sauce");
    productsScreen.validateTheProductScreenIsVisible();
    ProductDetailScreen productDetailScreen = productsScreen.tapOnTheFirstProduct();
    productDetailScreen.w3CDragAndDrop();
    productDetailScreen.validateTheProductDetailScreenIsDisplayed();
  }
}
