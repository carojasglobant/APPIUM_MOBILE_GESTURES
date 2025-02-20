package com.java.screens;

import static com.java.utils.W3CActionGestures.longClickGesture;
import static com.java.utils.WaitActions.isTheElementVisible;

import com.java.base.BaseScreen;
import com.java.utils.AndroidDriverSpecificGestures;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WelcomeScreen extends BaseScreen {

  @AndroidFindBy(uiAutomator = "description(\"test-LOGIN\")")
  private WebElement btnLogIn;

  @AndroidFindBy(uiAutomator = "description(\"test-Username\")")
  private WebElement txtUserName;

  @AndroidFindBy(uiAutomator = "description(\"test-Password\")")
  private WebElement txtPassword;

  public WelcomeScreen(AndroidDriver driver) {
    super(driver);
  }

  public void clickOnLogInButton() {
    click(btnLogIn, "Button Log In");
  }

  public void isTheScreenDisplayed() {
    Assert.assertTrue(isTheElementVisible(txtUserName, 15),
      "Validating the username field is displayed");

    Assert.assertTrue(isTheElementVisible(txtPassword, 5),
      "Validating the password field is displayed");

    Assert.assertTrue(isTheElementVisible(btnLogIn, 5),
      "Validating the log in button is displayed");
  }

  public ProductsScreen performLogIn(String username, String password) {
    txtUserName.sendKeys(username);
    txtPassword.sendKeys(password);
    clickOnLogInButton();
    return new ProductsScreen(driver);
  }

  public void w3CLongPressLogInButton() {
    longClickGesture(btnLogIn, 50, 30, 10);
  }

  public void uiAutomatorDoubleTap() {
    AndroidDriverSpecificGestures.doubleTap(btnLogIn, 100, 30);
  }
}
