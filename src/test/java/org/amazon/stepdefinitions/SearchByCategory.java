package org.amazon.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static java.lang.String.valueOf;
import static org.junit.Assert.assertTrue;

public class SearchByCategory {

    String filtered;
    @Steps
    SearchSteps searchSteps;

    @When("Click on Shop by Department from burger menu")
    public void shopByDepartment() {
        searchSteps.enterMenu();
    }

    @And("^Choose category (.*)")
    public void searchDepartment(String department) {
        searchSteps.filterByDepartment(department);
    }

    @And("^Choose sub-category category (.*)")
    public void searchCategory(String option) {
        searchSteps.filterByCategory(option);
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
