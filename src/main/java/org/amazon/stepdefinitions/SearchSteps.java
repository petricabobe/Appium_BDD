package org.amazon.stepdefinitions;

import net.thucydides.core.annotations.Step;
import org.amazon.pages.HomeScreen;
import org.amazon.pages.ProductsScreen;
import org.amazon.pages.SearchScreen;

public class SearchSteps {
    HomeScreen homeScreen;
    SearchScreen searchScreen;
    ProductsScreen productsScreen;

    @Step
    public void openHomeScreen(){
        homeScreen.openHomeScreen();
    }

    public void enterMenu(){
        homeScreen.burgerMenu();
    }
    @Step
    public void searchByDepartment(String category){
        homeScreen.shopByElectronicsDepartment();
    }
    @Step
    public void searchBySubcategory(String subcategory) {
        productsScreen.seeAllResults();
        productsScreen.chooseSubCategory(subcategory);
    }
    @Step
    public String getPageDescription(){
        return getPageDescription();
    }

    @Step
    public String getFilteredResults(String filter){
        return productsScreen.filterWithOption(filter);
    }
    @Step
    public int resultsList(){
        return searchScreen.getResultsList();
    }
    @Step
    public void checkPromotions(String promo){
        homeScreen.goHomeScreen();
        homeScreen.checkAllDeals(promo);
    }
}
