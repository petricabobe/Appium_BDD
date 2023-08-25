package org.amazon.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChangeCurrency {

    @Steps
    SettingsSteps settingsSteps;

    @When("Go to Currency Settings and Select Country & Language")
    public void goToCurrencySettings() {
        settingsSteps.gotoCurrencySettings();
    }

    @And("Change currency from USD to {string}")
    public void changeCurrencyFromUSDToAED(String currency) {
        settingsSteps.changeToCurrency(currency);
    }

    @Then("Assert on selected currency displayed for products")
    public void assertOnSelectedCurrencyDisplayedForProducts() {
        assertTrue(settingsSteps.checkCurrencyChanged("AED"));
        //will fail -> bug
        assertFalse(settingsSteps.checkCurrencyChanged("$"));
    }

}
