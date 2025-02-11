package com.java.utils;

import static com.java.utils.WaitActions.isTheElementVisible;

import org.openqa.selenium.WebElement;

public class Actions {
  public static void click(WebElement element, String description) {
    isTheElementVisible(element, 5);
    element.click();
    System.out.println(description);
  }
}
