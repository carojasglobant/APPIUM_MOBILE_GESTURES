package com.java.screens;

import static com.java.utils.ActionGestures.zoomIn;
import static com.java.utils.WaitActions.isTheElementVisible;

import com.java.base.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductDetailScreen extends BaseScreen {

  @AndroidFindBy(uiAutomator = "description(\"test-Image Container\")")
  WebElement imgProduct;
  public ProductDetailScreen(AndroidDriver driver) {
    super(driver);
  }

  public void zoomInProductImage() {
    zoomIn(imgProduct, 500);
  }

  public void validateTheProductDetailScreenIsDisplayed() {
    Assert.assertTrue(isTheElementVisible(imgProduct, 5));
  }
}
