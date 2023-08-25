package org.amazon.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class FiltersScreen extends PageObject {
    WebDriverWait wait;

    public FiltersScreen(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, ofSeconds(20));
    }

    @AndroidFindBy(uiAutomator = "text(\"Filters\")")
    WebElement filtersBtn;
    @AndroidFindBy(uiAutomator = "text(\"Close\")")
    WebElement closeBtn;
    @AndroidFindBy(uiAutomator = "descriptionContains(\"results\")")
    WebElement showResults;
    @AndroidFindBy(uiAutomator = "resourceId(\"n/1266092011\")")
    WebElement TVCategory;
    @AndroidFindBy(uiAutomator = "text(\"Televisions\")")
    WebElement tvsubcategory;
    @AndroidFindBy(uiAutomator = "text(\"See more\")")
    WebElement seeMoreBtn;

    public void chooseSubCategory(String category) {
        wait.until(elementToBeClickable(filtersBtn))
                .click();
        wait.until(visibilityOf(closeBtn));

        getDriver().findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().textContains(\"Television\"));"));
        getDriver()
                .findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)). " +
                        "scrollForward();"));
        getDriver()
                .findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(1)).scrollBackward();"));
        TVCategory.click();
        scrollIntoViewWithMatchingText(category);
        tvsubcategory.click();
    }

    public String filterWithOption(String option) {
        System.out.println(option);
        wait.until(visibilityOf(
                        getDriver().findElement(androidUIAutomator("new UiSelector().text(\"" + option + "\");"))))
                .click();
        String results = showResults.getAttribute("content-desc");
        showResults.click();
        return results;
    }

    private void scrollIntoViewWithMatchingText(String match) {
        wait
                .until(visibilityOf(getDriver()
                        .findElement(androidUIAutomator("new UiSelector().resourceId(\"dropdown-content-s-all-filters\");"))));
        getDriver()
                .findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)). " +
                        "scrollForward();"));
        getDriver()
                .findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(1))" +
                        ".scrollTextIntoView(\"" + match + "\");"));
        getDriver()
                .findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(1)).scrollBackward();"));
    }

    public void seeAllResults() {
        getDriver()
                .findElement(androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"See all results\"));"));
        getDriver().findElement(androidUIAutomator("UiSelector().text(\"See all results\")")).click();
    }

    public void filterDeals(String option) {
        //click on filters
        wait.until(visibilityOf(filtersBtn))
                .click();
        //scroll to department show more
//        getDriver().findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(1)).scrollTextIntoView(\"Shop deals by department\");"));
        getDriver().findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(1)).scrollTextIntoView(\"Shop deals by deal type\");"));
        getDriver().findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(1)).scrollForward();"));

        seeMoreBtn.click();
        getDriver().findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(1)).scrollTextIntoView(\"Software\")"));
        getDriver().findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(1)).scrollForward();"));


        //click text with "Show results";
        showResults.click();
    }

}
