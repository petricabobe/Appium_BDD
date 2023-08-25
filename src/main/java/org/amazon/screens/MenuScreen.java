package org.amazon.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MenuScreen extends PageObject {
    WebDriverWait wait;

    public MenuScreen(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AndroidFindBy(uiAutomator = "text(\"Shop by Department\")")
    WebElement shopByDepartment;

    @AndroidFindBy(uiAutomator = "text(\"Electronics\")")
    WebElement electronicsOption;
    @AndroidFindBy(uiAutomator = "text(\"Settings\")")
    WebElement settings;
    @AndroidFindBy(uiAutomator = "text(\"Country & Language\")")
    WebElement countryAndLang;

    public void shopByElectronicsDepartment() {
        wait.until(visibilityOf(shopByDepartment))
                .click();
        wait.until(visibilityOf(electronicsOption))
                .click();
    }

    public void goToSettings() {
        wait.until(visibilityOf(settings)).click();
        wait.until(visibilityOf(countryAndLang)).click();
    }
}
