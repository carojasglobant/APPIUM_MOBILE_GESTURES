package com.java.screens;

import static com.java.utils.ActionGestures.swipe;
import static com.java.utils.WaitActions.isTheElementVisible;

import com.java.base.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductsScreen extends BaseScreen {

  @AndroidFindBy(uiAutomator = "text(\"PRODUCTS\")")
  private WebElement lblProducts;

  @AndroidFindBy(uiAutomator = "description(\"test-Item\")")
  private List<WebElement> lstProducts;

  public ProductsScreen(AndroidDriver driver) {
    super(driver);
  }

  public ProductDetailScreen tapOnTheFirstProduct() {
    click(lstProducts.get(0), "Product one");
    return new ProductDetailScreen(driver);
  }

  public void validateTheProductScreenIsVisible() {
    Assert.assertTrue(isTheElementVisible(lblProducts, 7),
      "Validating the product title is visible");
  }

  public void swipeDownAnAmountOfTimes(int times){
    for (int i = 0; i < times; i++) {
      swipe(0.5, 0.9, 0.5, 0.2);
    }
  }
}
