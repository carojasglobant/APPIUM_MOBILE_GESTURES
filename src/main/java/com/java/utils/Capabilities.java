package com.java.utils;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.cdimascio.dotenv.Dotenv;

public class Capabilities {

  public static UiAutomator2Options getAndroidCapabilities() {
    Dotenv dotenv = Dotenv.configure()
      .directory("src/test/resources")
      .filename("env")
      .load();

    return new UiAutomator2Options()
      .setApp(dotenv.get("MOBILE.APP.URL"))
      .setDeviceName(dotenv.get("MOBILE.DEVICE.NAME"))
      .setPlatformName(dotenv.get("MOBILE.PLATFORM.VERSION"))
      .setPlatformVersion(dotenv.get("MOBILE.FULL.RESET"))
      .setAppActivity(dotenv.get("MOBILE.APP.ACTIVITY"))
      .setFullReset(true);
  }
}
