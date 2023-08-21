package org.amazon.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
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

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/btn_redirect_marketplace")
    WebElement redirectToUAE;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'Menu')]")
    WebElement menuBurger;

    @AndroidFindBy(id = "sbceal")
    WebElement electronicsOption;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Home Theater, TV & Video\"]")
    WebElement pageDescription;

    public void openHomeScreen() {
        wait.until(visibilityOf(amazonLogo));
        wait.until(visibilityOf(redirectToUAE))
                        .click();
        wait.until(visibilityOf(skipSignInBtn))
                        .click();
    }

    public void burgerMenu() {
       wait.until(elementToBeClickable(menuBurger)).click();
    }

    public void searchByDepartment(String option) {
        getDriver().findElement(By.xpath("//android.view.ViewGroup[contains(text()," + option +")]"))
                        .click();
        wait.until(elementToBeClickable(electronicsOption)).click();
    }
    public void searchByCategory(String option){
        WebElement category = getDriver()
                .findElement(androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + option + "\"));"));
        category.click();
    }

    public String getPageDescription() {
        return pageDescription.getText();
    }
}
