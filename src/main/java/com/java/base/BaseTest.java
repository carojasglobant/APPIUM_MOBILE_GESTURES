package com.java.base;

import static com.java.utils.Capabilities.getAndroidCapabilities;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  protected static AndroidDriver driver;

  public static AndroidDriver getDriver() {
    return driver;
  }

  private AndroidDriver createAndroidDriver() {
    try {
      URL url = new URL("http://127.0.0.1:4723");

      AndroidDriver androidDriver = new AndroidDriver(url, getAndroidCapabilities());
      androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      return androidDriver;
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  @BeforeMethod
  public void setUp() {
    driver = createAndroidDriver();
  }

  @AfterMethod
  public void tearDown() {
    getDriver().removeApp("com.wdiodemoapp");
  }
}
