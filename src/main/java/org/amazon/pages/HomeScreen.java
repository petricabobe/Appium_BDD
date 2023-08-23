package org.amazon.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomeScreen extends PageObject {
    WebDriverWait wait;

    public HomeScreen(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, ofSeconds(30));
    }

    @AndroidFindBy(id = "com.android.permissioncontroller:id/content_container")
    WebElement allowNotificationsPopup;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
    WebElement skipSignInBtn;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/sso_splash_logo")
    WebElement amazonLogo;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/btn_stay_marketplace")
    WebElement stayOnAmazon;
    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/btn_cancel")
    WebElement cancel;

    @AndroidFindBy(uiAutomator = "text(\"Shop by Department\")")
    WebElement shopByDepartment;

    @AndroidFindBy(uiAutomator = "descriptionContains(\"Menu\")")
    WebElement menuBurger;

    @AndroidFindBy(uiAutomator = "descriptionContains(\"Home\")")
    WebElement homeBurger;
    @AndroidFindBy(uiAutomator="text(\"Electronics\")")
    WebElement electronicsOption;

    @AndroidFindBy(uiAutomator = "description(\"Home Theater, TV & Video\"")
    WebElement pageDescription;

    public void openHomeScreen() {
        wait.until(visibilityOf(amazonLogo));
        wait.until(visibilityOf(stayOnAmazon))
                .click();
        wait.until(visibilityOf(skipSignInBtn))
                .click();
    }

    public void burgerMenu() {
        wait.until(elementToBeClickable(menuBurger)).click();
    }

    public void shopByElectronicsDepartment() {
        wait.until(visibilityOf(shopByDepartment))
                .click();
        wait.until(visibilityOf(electronicsOption))
                .click();
    }

    public String getPageDescription() {
        return pageDescription.getText();
    }

    public void goHomeScreen() {
        wait.until(elementToBeClickable(homeBurger))
                .click();
    }

    public void checkAllDeals(String promo) {
        getDriver().findElement(
                        androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + promo + "\")).getChildByText(\"See all deals\")"))
                .click();
        //tap See all deals

    }
}
