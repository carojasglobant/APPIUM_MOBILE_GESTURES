package com.java.screens;

import static com.java.utils.W3CActionGestures.dragAndDrop;
import static com.java.utils.W3CActionGestures.zoomIn;
import static com.java.utils.WaitActions.isTheElementVisible;

import com.java.base.BaseScreen;
import com.java.utils.AndroidDriverSpecificGestures;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
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

  @Step("Zoom in with W3C Action gesture")
  public void zoomInProductImage() {
    zoomIn(imgProduct, 500);
  }

  @Step("Validating the product detail screen is displayed")
  public void validateTheProductDetailScreenIsDisplayed() {
    Assert.assertTrue(isTheElementVisible(imgProduct, 5));
  }

  @Step("Drag And Drop tap with W3C Action gesture")
  public void w3CDragAndDrop() {
    dragAndDrop(imgProduct, btnAddToCart);
  }

  @Step("Drag And Drop tap with UiAutomator2 driver gesture")
  public void uiAutomator2DragAndDrop() {
    AndroidDriverSpecificGestures.dragAndDrop(imgProduct, btnAddToCart);
  }
}
