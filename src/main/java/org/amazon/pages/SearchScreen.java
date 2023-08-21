package org.amazon.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static org.openqa.selenium.By.xpath;

public class SearchScreen extends PageObject {
    WebDriverWait wait;

    public SearchScreen(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'results')]")
    WebElement showResults;

    @AndroidFindBy(xpath = "//android.view.View[@id='search']/android.view.View")
    List<WebElement> resultsList;

    public String getResultsFiltered(String filter) {
        WebElement filterBtn = getDriver()
                .findElement(androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().resource-id(\"apb-browse-search-filter\"));"));
        filterBtn.click();
        getDriver()
                .findElement(xpath("//android.view.View[@content-desc=\"" + filter + "\"]"))
                .click();
        String results = showResults.getAttribute("content-desc");
        showResults.click();
        return results;
    }

    public int getResultsList() {
        return resultsList.size();
    }
}
