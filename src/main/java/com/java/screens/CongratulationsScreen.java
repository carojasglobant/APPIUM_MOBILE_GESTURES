package com.java.screens;

import com.java.base.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CongratulationsScreen extends BaseScreen {

  AppiumBy lblCongratulations =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Congratulations\")");

  protected CongratulationsScreen(AndroidDriver driver) {
    super(driver);
  }

  public void validateLabelCongratulations() {
    WebElement element = getMobileDriver().findElement(lblCongratulations);
    String congratulations = element.getDomAttribute("text");
    Assert.assertEquals(congratulations, "Congratulations");
  }
}
