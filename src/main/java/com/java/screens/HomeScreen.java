package com.java.screens;

import static com.java.utils.ActionGestures.navigateBack;
import static com.java.utils.WaitActions.isTheElementVisible;
import static com.java.utils.WaitActions.isTheElementVisibleWithFluentWait;

import com.java.base.BaseScreen;
import com.java.utils.ActionGestures;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomeScreen extends BaseScreen {

  @AndroidFindBy(uiAutomator = "resourceId(\"com.lexa.fakegps:id/title\").text(\"Almost there ...\")")
  private WebElement dlgAlmostThere;

  @AndroidFindBy(uiAutomator = "resourceId(\"com.lexa.fakegps:id/map_container\")")
  private WebElement fraMapView;

  @AndroidFindBy(uiAutomator = "descriptionContains(\"Zoom in\")")
  private WebElement btnZoomIn;

  @AndroidFindBy(uiAutomator = "descriptionContains(\"Zoom out\")")
  private WebElement btnZoomOut;

  @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.lexa.fakegps:id/include\"]/android.widget.ImageView")
  private WebElement imgPointer;

  @AndroidFindBy(uiAutomator = "descriptionContains(\"Open navigation drawer\")")
  private WebElement btnNavigationDriver;

  public HomeScreen(AndroidDriver driver) {
    super(driver);
  }

  public void isTheHomeScreenDisplayed() {
    if(isTheElementVisibleWithFluentWait(dlgAlmostThere,6, 2)) {
      navigateBack();
    }
    Assert.assertTrue(isTheElementVisible(fraMapView, 10));
  }

  public void tapTwoTimesWithW3Cations() {
    ActionGestures.doubleTap(imgPointer);
  }
}
