package com.java.utils;

import static com.java.base.BaseTest.getDriver;

import io.appium.java_client.AppiumBy;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitActions {

  private static final Duration defaultDuration = Duration.ofSeconds(20);

  public static boolean isTheElementVisible(WebElement mobileElement, int seconds) {
    getDriver().manage().timeouts().implicitlyWait(Duration.ZERO);
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
    try {
      wait.until(ExpectedConditions.visibilityOf(mobileElement));
      return true;
    } catch (Exception e) {
      return false;
    } finally {
      getDriver().manage().timeouts().implicitlyWait(defaultDuration);
    }
  }

  public static boolean isTheElementVisible(AppiumBy by, int seconds) {
    getDriver().manage().timeouts().implicitlyWait(Duration.ZERO);
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
    try {
      WebElement element =  wait
        .until(ExpectedConditions.visibilityOf(getDriver().findElement(by)));
      return element.isDisplayed();
    } catch (IllegalStateException | StaleElementReferenceException | TimeoutException
             | NoSuchElementException e) {
      return false;
    } finally {
      getDriver().manage().timeouts().implicitlyWait(defaultDuration);
    }
  }
}
