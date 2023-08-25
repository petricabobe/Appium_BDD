package org.amazon.stepdefinitions;

import net.thucydides.core.annotations.Step;
import org.amazon.screens.FiltersScreen;
import org.amazon.screens.MainScreen;
import org.amazon.screens.ListScreen;

public class DealsSteps {
    MainScreen mainScreen;
    FiltersScreen filtersScreen;
    ListScreen listScreen;
    @Step
    public void checkPromotions(){
//        mainScreen.goHomeScreen();
        mainScreen.checkAllDeals();
    }
    @Step
    public void filterByDepartment(String dept){
        filtersScreen.filterDeals(dept);
    }
    @Step
    public boolean getDepartmentFiltered(String dept){
        return listScreen.getScreenDepartment(dept);
    }
}
