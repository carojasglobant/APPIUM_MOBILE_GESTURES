package com.java.screens;

import static com.java.utils.W3CActionGestures.swipe;
import static com.java.utils.WaitActions.isTheElementVisible;

import com.java.base.BaseScreen;
import com.java.utils.AndroidDriverSpecificGestures;
import com.java.utils.Directions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
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

  @Step("Tapping on the first product")
  public ProductDetailScreen tapOnTheFirstProduct() {
    click(lstProducts.get(0), "Product one");
    return new ProductDetailScreen(driver);
  }

  @Step("Validating the product screen is visible")
  public void validateTheProductScreenIsVisible() {
    Assert.assertTrue(isTheElementVisible(lblProducts, 7),
      "Validating the product title is visible");
  }

  @Step("Swiping down with W3C Action gesture")
  public void swipeDownWithW3CActions(int times){
    for (int i = 0; i < times; i++) {
      swipe(0.5, 0.9, 0.5, 0.2);
    }
  }

  @Step("Swiping down with UiAutomator2 driver Action gesture")
  public void swipeDownWithUiAutomator2Actions(int times){
    for (int i = 0; i < times; i++) {
      AndroidDriverSpecificGestures.swipe(lstProducts.get(0), Directions.UP, 1.0);
    }
  }
  
  
}
