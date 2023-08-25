package org.amazon.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SettingsScreen extends PageObject {
    WebDriverWait wait;

    public SettingsScreen(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, ofSeconds(20));
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"landing-currencyButton\")")
    WebElement currencyBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"landing-doneButton\")")
    WebElement doneBtn;
    public void changeCurrency(String currency) {
        wait.until(visibilityOf(currencyBtn))
                .click();
        getDriver().findElement(androidUIAutomator("new UiScrollable(new UiSelector()" +
                ".scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + currency + "\"))"))
                .click();
        wait.until(visibilityOf(doneBtn)).click();
    }
}
