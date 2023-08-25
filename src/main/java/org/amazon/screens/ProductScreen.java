package org.amazon.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.google.common.collect.ImmutableMap.of;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ProductScreen extends PageObject {
    WebDriverWait wait;
    public ProductScreen(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AndroidFindBy(id = "corePrice_mobile_feature_div")
    WebElement price;
    @AndroidFindBy(id = "twister-plus-card")
    WebElement pruchaseOptions;

    @AndroidFindBy(id = "availability")
    WebElement availability;
    @AndroidFindBy(id = "add-to-cart-button")
    WebElement addToCart;

    public void swipePictures(){
        wait
                .until(visibilityOf(getDriver()
                .findElement(androidUIAutomator("new UiSelector().resourceId(\"a-page\");"))));

        AndroidDriver androidDriver = ((AndroidDriver)((WebDriverFacade) getDriver()).getProxiedDriver());

        RemoteWebElement remote = (RemoteWebElement) getDriver().findElement(androidUIAutomator("new UiSelector().resourceId" +
                "(\"landing-image-wrapper\")"));

        androidDriver.executeScript("mobile: swipeGesture", of(
                "elementId", remote.getId(),
                "direction", "left",
                "percent", 1
        ));

    }

    public String getPrice(){
        //scroll to price
        getDriver()
                .findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector().textContains(\"Price: $\"));"));

        wait.until(visibilityOf(price));
        System.out.println(price.getText());
        return price.getText();
    }
    public String getPurchaseOptions(){
        return pruchaseOptions.getText();
    }
    public String getAvailability(){
        return availability.getText();
    }

    public void clickAddToCart(){
        addToCart.click();
    }
}
