package org.amazon.stepdefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class TodaysDeals {
    @Steps
    DealsSteps dealsSteps;

    @When("Tab on Today's Deals")
    public void checkTodaysDeals() {
        dealsSteps.checkPromotions();
    }

    @When("From Departments filter, Show see more and select {string}")
    public void from_departments_filter_show_see_more_and_select(String dept) {
        dealsSteps.filterByDepartment(dept);

    }
    @Then("Assert on choosing the correct {string} department")
    public void assert_on_choosing_the_correct_department(String dept) {
        assertThat(dealsSteps.getDepartmentFiltered(dept), is(true));

    }
}
