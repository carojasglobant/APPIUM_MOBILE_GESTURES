package com.java.base;

import static com.java.utils.WaitActions.isTheElementVisible;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseScreen {

  public AndroidDriver driver;

  static Logger logger = LoggerFactory.getLogger(BaseScreen.class);

  protected BaseScreen(AndroidDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  @Step("Click on {1}")
  public static void click(WebElement element, String description) {
    isTheElementVisible(element, 5);
    element.click();
    logger.info(description);
  }
}
