package org.amazon.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class ProductsScreen extends PageObject {
    WebDriverWait wait;
    @AndroidFindBy(uiAutomator = "text(\"Filters\")")
    WebElement filtersBtn;
    @AndroidFindBy(uiAutomator = "descriptionContains(\"results\")")
    WebElement showResults;
    @AndroidFindBy(id = "n/1266092011")
    WebElement TVCategory;

    public ProductsScreen(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, ofSeconds(20));
    }

    public void chooseSubCategory(String category) {
        wait.until(elementToBeClickable(filtersBtn))
                .click();
        getDriver()
                .findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)). scrollForward();"));
        getDriver()
                .findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)). scrollForward();"));
        getDriver().findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(1)). scrollBackward();"));
        getDriver().findElement(By.xpath(("(//android.view.View[@content-desc='All'])[6]"))).click();
        scrollIntoViewWithMatchingText(category);
    }

    public String filterWithOption(String option) {
        scrollIntoViewWithMatchingText(option);
        return showResults.getAttribute("content-desc");
    }

    private void scrollIntoViewWithMatchingText(String match) {
//        getDriver()
//                .findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + match + "\"));"))
//                .click();
        getDriver()
                .findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)). scrollForward();"));
        getDriver().findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(1)). scrollBackward();"));
    }

    public void seeAllResults() {
        WebElement seeAllResults = getDriver()
                .findElement(androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"See all results\"));"));
        seeAllResults.click();
    }
}
