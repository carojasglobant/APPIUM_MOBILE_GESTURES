package com.java.utils;

import io.appium.java_client.android.options.UiAutomator2Options;

public class Capabilities {

  public static UiAutomator2Options getAndroidCapabilities() {
    return new UiAutomator2Options()
      .setApp("/Users/ca.rojas/Downloads/android.wdio.native.app.v1.0.8.apk")
      .setDeviceName("wasa 14")
      .setPlatformName("Android")
      .setPlatformVersion("14")
      .setFullReset(true);
  }
}
