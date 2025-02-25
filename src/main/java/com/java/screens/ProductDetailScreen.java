package com.java.screens;

import static com.java.utils.W3CActionGestures.dragAndDrop;
import static com.java.utils.W3CActionGestures.zoomIn;
import static com.java.utils.WaitActions.isTheElementVisible;

import com.java.base.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductDetailScreen extends BaseScreen {

  @AndroidFindBy(uiAutomator = "description(\"test-Image Container\")")
  WebElement imgProduct;

  @AndroidFindBy(uiAutomator = "descriptionContains(\"test-ADD TO CART\")")
  WebElement btnAddToCart;

  public ProductDetailScreen(AndroidDriver driver) {
    super(driver);
  }

  public void zoomInProductImage() {
    zoomIn(imgProduct, 500);
  }

  public void validateTheProductDetailScreenIsDisplayed() {
    Assert.assertTrue(isTheElementVisible(imgProduct, 5));
  }

  public void w3CDragAndDrop() {
    dragAndDrop(imgProduct, btnAddToCart);
  }
}
