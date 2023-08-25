package org.amazon.screens;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ListScreen extends PageObject {
    WebDriverWait wait;
    public ListScreen(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AndroidFindBy(xpath = "//android.view.View[contains(@resource-id,'search')]/android.view.View")
    List<WebElement> resultsList;

    @AndroidFindBy(uiAutomator = "descriptionContains(\"Apple iPhone\")")
    List<WebElement> appleProducts;

    public int getResultsList() {
        //first is Filters button
        getDriver()
                .findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd();"));
        return resultsList.size() - 1;
    }
    public boolean getScreenDepartment(String dept){
        return getDriver().findElement(androidUIAutomator("new UiSelector().text(\""+dept+"\")"))
                .isSelected();
    }
    public void selectProduct(){
        wait.until(elementToBeClickable(appleProducts.get(0)))
                .click();
    }


}
