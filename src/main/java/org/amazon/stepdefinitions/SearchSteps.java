package org.amazon.stepdefinitions;

import net.thucydides.core.annotations.Step;
import org.amazon.screens.*;

import static com.google.common.base.Strings.isNullOrEmpty;

public class SearchSteps {
    MainScreen mainScreen;
    ListScreen listScreen;
    FiltersScreen filterSScreen;
    MenuScreen menuScreen;
    ProductScreen productScreen;

//    @Step
//    public void openHomeScreen() {
//        mainScreen.openHomeScreen();
//    }

    public void enterMenu() {
        mainScreen.burgerMenu();
    }

    @Step
    public void filterByDepartment(String category) {
        menuScreen.shopByElectronicsDepartment();
    }

    @Step
    public void filterByCategory(String subcategory) {
        filterSScreen.seeAllResults();
        filterSScreen.chooseSubCategory(subcategory);
    }

    @Step
    public String getFilteredResults(String filter) {
        return filterSScreen.filterWithOption(filter);
    }

    @Step
    public int resultsList() {
        return listScreen.getResultsList();
    }

    @Step
    public void searchProduct(String product) {
//        mainScreen.openHomeScreen();
        mainScreen.searchForProduct(product);
        listScreen.selectProduct();
    }

    @Step
    public void swipePictures() {
        productScreen.swipePictures();
    }

    @Step
    public boolean checkVisibilityOfPriceAndPurchase() {
        return isNullOrEmpty(productScreen.getPrice())
                && isNullOrEmpty(productScreen.getPurchaseOptions());
    }

    @Step
    public boolean checkAvailability(){
        return isNullOrEmpty(productScreen.getAvailability());
    }

    @Step
    public void addToCart(){
        productScreen.clickAddToCart();
    }
}
