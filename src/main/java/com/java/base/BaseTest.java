package com.java.base;

import static com.java.utils.Capabilities.getAndroidCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({com.java.base.Listeners.class})
public class BaseTest {

  Logger logger = LoggerFactory.getLogger(BaseTest.class);

  protected static AndroidDriver driver;

  public static AndroidDriver getDriver() {
    return driver;
  }

  private AndroidDriver createAndroidDriver() {
    try {
      URL url = new URL("http://127.0.0.1:4723");

      AndroidDriver androidDriver = new AndroidDriver(url, getAndroidCapabilities());
      androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
      return androidDriver;
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  @BeforeMethod
  public void setUp() {
    logger.warn("Starting Driver");
    if (driver != null) {
      driver.quit();
    }
    driver = createAndroidDriver();
  }

  @AfterMethod
  public void tearDown(ITestResult result) {
    // Capture screenshot on Failure
    if (ITestResult.FAILURE == result.getStatus()) {
      File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
      String screenShotPath =
        System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";
      try {
        FileUtils.copyFile(srcFile, new File(screenShotPath));
        Allure.addAttachment("Screenshot on failure", new FileInputStream(screenShotPath));
        FileUtils.deleteDirectory(new File(System.getProperty("user.dir") + "/screenshots/"));
      } catch (IOException e) {
        // Do nothing
      }
    }

    // Quit driver
    logger.warn("Closing Driver");
    getDriver().quit();
  }
}
