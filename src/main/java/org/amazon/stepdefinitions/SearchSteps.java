package org.amazon.stepdefinitions;

import net.thucydides.core.annotations.Step;
import org.amazon.pages.HomeScreen;
import org.amazon.pages.SearchScreen;

public class SearchSteps {
    HomeScreen homeScreen;
    SearchScreen searchScreen;

    @Step
    public void openHomeScreen(){
        homeScreen.openHomeScreen();
    }

    public void enterMenu(){
        homeScreen.burgerMenu();
    }
    @Step
    public void searchByDepartment(String category){
        homeScreen.searchByDepartment(category);
    }
    @Step
    public void searchBySubcategory(String subcategory) {
        homeScreen.searchByCategory(subcategory);
    }
    @Step
    public String getPageDescription(){
        return getPageDescription();
    }

    @Step
    public String getFilteredResults(String filter){
        return searchScreen.getResultsFiltered(filter);
    }
    @Step
    public int resultsList(){
        return searchScreen.getResultsList();
    }
}
