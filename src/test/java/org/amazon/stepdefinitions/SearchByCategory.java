package org.amazon.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static java.lang.String.valueOf;
import static org.junit.Assert.assertTrue;

@RunWith(SerenityRunner.class)
public class SearchByCategory {

    @Managed(driver = "Appium")
    public WebDriver appiumDriver;
    String filtered;
    @Steps
    SearchSteps searchSteps;

    @Given("Open Home screen")
    public void open() {
        searchSteps.openHomeScreen();
    }

    @When("Click on Shop by Department from burger menu")
    public void shopByDepartment() {
        searchSteps.enterMenu();
    }

    @And("^Choose category (.*)")
    public void searchDepartment(String department) {
        searchSteps.searchByDepartment(department);
    }

    @And("^Choose sub-category category (.*)")
    public void searchCategory(String option) {
        searchSteps.searchBySubcategory(option);
    }

    @And("^Filter with (.*) and show results")
    public void filterResults(String filter) {
        filtered = searchSteps.getFilteredResults(filter);
    }

    @Then("Check the total number of results match the total displayed in filter")
    public void checkResults() {
        String list = valueOf(searchSteps.resultsList());
        assertTrue(filtered.contains(list));
    }
}
