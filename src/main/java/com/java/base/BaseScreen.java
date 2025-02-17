package com.java.base;

import static com.java.utils.WaitActions.isTheElementVisible;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BaseScreen {

  private AndroidDriver driver;

  protected BaseScreen(AndroidDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  public AndroidDriver getMobileDriver() {
    return driver;
  }

  @Step("Click on {1}")
  public static void click(WebElement element, String description) {
    isTheElementVisible(element, 5);
    element.click();
    System.out.println(description);
  }
}
