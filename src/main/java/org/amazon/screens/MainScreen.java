package org.amazon.screens;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.google.common.collect.ImmutableMap.of;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.android.nativekey.AndroidKey.ENTER;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MainScreen extends PageObject {
    WebDriverWait wait;

    public MainScreen(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, ofSeconds(30));
    }

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
    WebElement skipSignInBtn;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/sso_splash_logo")
    WebElement amazonLogo;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/btn_stay_marketplace")
    WebElement stayOnAmazon;
    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/btn_cancel")
    WebElement cancel;

    @AndroidFindBy(uiAutomator = "descriptionContains(\"Menu\")")
    WebElement menuBurger;

    @AndroidFindBy(uiAutomator = "descriptionContains(\"Home\")")
    WebElement homeBurger;
    @AndroidFindBy(uiAutomator = "resourceId(\"com.amazon.mShop.android.shopping:id/chrome_search_hint_view\")")
    WebElement search;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
    WebElement searchInput;


    public void openHomeScreen() {
//        wait.until(visibilityOf(stayOnAmazon))
//                .click();
        wait.until(visibilityOf(skipSignInBtn))
                .click();
    }

    public void burgerMenu() {
        wait.until(elementToBeClickable(menuBurger)).click();
    }

    public void goHomeScreen() {
        wait.until(elementToBeClickable(homeBurger))
                .click();
    }

    public void checkAllDeals() {
        //first click on Home screen
        homeBurger.click();
        getDriver().findElement(
                        androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"See all deals\"));"))
                .click();
    }



    public boolean searchForCurrencyOnHomeScreen(String currency) {
        //search for $ after changing to AED
        //assert AED in text
        return getDriver().findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().textContains(\"" + currency + "\"))"))
                .isDisplayed();
    }

    public void searchForProduct(String product) {
        wait.until(visibilityOf(search))
                .click();
        searchInput.sendKeys(product);
        AndroidDriver androidDriver = ((AndroidDriver)((WebDriverFacade) getDriver()).getProxiedDriver());
        androidDriver.executeScript("mobile: performEditorAction", of("action", "Go"));


    }
}
