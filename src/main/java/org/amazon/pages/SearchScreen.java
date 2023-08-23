package org.amazon.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchScreen extends PageObject {
    WebDriverWait wait;

    public SearchScreen(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AndroidFindBy(xpath = "//android.view.View[@id='search']/android.view.View")
    List<WebElement> resultsList;


    public int getResultsList() {
        //first is Filters button
        return resultsList.size() - 1;
    }
}
