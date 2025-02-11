package com.java.base;

import static com.java.utils.WaitActions.isTheElementVisible;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class BaseScreen {

  private AndroidDriver driver;

  protected BaseScreen(AndroidDriver driver) {
    this.driver = driver;
  }

  public AndroidDriver getMobileDriver() {
    return driver;
  }

  public static void click(WebElement element, String description) {
    isTheElementVisible(element, 5);
    element.click();
    System.out.println(description);
  }
}
