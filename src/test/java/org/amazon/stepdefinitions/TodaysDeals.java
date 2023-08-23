package org.amazon.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TodaysDeals {

    @When("Tab on Today's Deals")
public void checkTodaysDeals(){

    }
    @And("From Departments filter, Show see more")
    public void showMore(){

    }
    @And("Select Software department")
        public void selectSoftware(){

    }
    @Then("Assert on choosing the correct selected department")
    public void assertDepartment(){

    }

}
