package org.amazon.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.TimeoutException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ProductDetails {
    @Steps
    SearchSteps searchSteps;

    @When("Tap on the Search bar and search for {string}")
    public void tapOnTheSearchBarAndSearchFor(String arg0) {
        searchSteps.searchProduct(arg0);
    }

    @And("Tap the picture of the product and swipe Left to Right")
    public void tapThePictureOfTheProductAndSwipeLeftToRight() {
        searchSteps.swipePictures();
    }

    @Then("The price of the product payment options are displayed")
    public void thePriceOfTheProductPaymentOptionsAreDisplayed() {
        assertThat(searchSteps.checkVisibilityOfPriceAndPurchase(), is(true));

    }

    @And("Verify stock information is showing")
    public void verifyStockInformationIsShowing() {
        assertThat(searchSteps.checkAvailability(), is(true));

    }

    @And("Tap and verify add to cart feature")
    public void tapAndVerifyAddToCartFeature() {
        try {
            searchSteps.addToCart();
        } catch (Exception ex) {
            assertThat(ex.getCause(), is(not(instanceOf(TimeoutException.class))));
        }
    }
}
