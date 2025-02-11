package com.java.screens;

import com.java.base.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CongratulationsScreen extends BaseScreen {

  AppiumBy lblCongratulations =
    new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Congratulations\")");

  protected CongratulationsScreen(AndroidDriver driver) {
    super(driver);
  }

  @Step("Validate the congratulations screen is visible")
  public void validateLabelCongratulations() {
    WebElement element = getMobileDriver().findElement(lblCongratulations);
    String congratulations = element.getDomAttribute("text");
    Assert.assertEquals(congratulations, "Congratulations");
  }
}
