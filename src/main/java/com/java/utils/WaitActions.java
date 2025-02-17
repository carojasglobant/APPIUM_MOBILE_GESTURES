package com.java.utils;

import static com.java.base.BaseTest.getDriver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitActions {

  private static final Duration defaultDuration = Duration.ofSeconds(20);

  // Explicit Wait
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

  // Explicit Wait
  public static boolean isTheElementVisible(AppiumBy by, int seconds) {
    getDriver().manage().timeouts().implicitlyWait(Duration.ZERO);
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
    try {
      WebElement element = wait
        .until(ExpectedConditions.visibilityOfElementLocated(by));
      return element.isDisplayed();
    } catch (IllegalStateException | StaleElementReferenceException | TimeoutException
             | NoSuchElementException e) {
      return false;
    } finally {
      getDriver().manage().timeouts().implicitlyWait(defaultDuration);
    }
  }

  //Fluent Wait
  public static boolean isTheElementVisibleWithFluentWait(WebElement element, int maxTime, int  every) {
    getDriver().manage().timeouts().implicitlyWait(Duration.ZERO);
    FluentWait<AndroidDriver> wait = new FluentWait<>(getDriver())
      .withTimeout(Duration.ofSeconds(maxTime))
      .pollingEvery(Duration.ofSeconds(every));
    try {
      wait.until(ExpectedConditions.visibilityOf(element));
      return true;
    } catch (IllegalStateException | StaleElementReferenceException | TimeoutException
             | NoSuchElementException e) {
      return false;
    } finally {
      getDriver().manage().timeouts().implicitlyWait(defaultDuration);
    }
  }

  public static boolean isTheElementVisibleWithFluentWait(AppiumBy by, int maxTime, int  every) {
    getDriver().manage().timeouts().implicitlyWait(Duration.ZERO);
    FluentWait<AndroidDriver> wait = new FluentWait<>(getDriver())
      .withTimeout(Duration.ofSeconds(maxTime))
      .pollingEvery(Duration.ofSeconds(every))
      .ignoring(Exception.class);
    try {
      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      return element.isDisplayed();
    } catch (IllegalStateException | StaleElementReferenceException | TimeoutException
             | NoSuchElementException e) {
      return false;
    } finally {
      getDriver().manage().timeouts().implicitlyWait(defaultDuration);
    }
  }
}
