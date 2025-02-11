package com.java.base;

import static com.java.utils.Capabilities.getAndroidCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

  protected static AndroidDriver driver;

  public static AndroidDriver getDriver() {
    return driver;
  }

  private AndroidDriver createAndroidDriver() {
    try {
      URL url = new URL("http://127.0.0.1:4723");
      return new AndroidDriver(url, getAndroidCapabilities());
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  @BeforeSuite
  public void setUp() {
    driver = createAndroidDriver();
  }
}
