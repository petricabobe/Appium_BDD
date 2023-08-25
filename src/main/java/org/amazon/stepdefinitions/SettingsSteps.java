package org.amazon.stepdefinitions;

import net.thucydides.core.annotations.Step;
import org.amazon.screens.MenuScreen;
import org.amazon.screens.MainScreen;
import org.amazon.screens.SettingsScreen;

public class SettingsSteps {
    MainScreen mainScreen;
    MenuScreen menuScreen;
    SettingsScreen settingsScreen;

    @Step
    public void gotoCurrencySettings(){
        mainScreen.openHomeScreen();
        mainScreen.burgerMenu();
        menuScreen.goToSettings();
    }

    @Step
    public void changeToCurrency(String currency){
        settingsScreen.changeCurrency(currency);
    }

    @Step
    public boolean checkCurrencyChanged(String currency){
       return mainScreen.searchForCurrencyOnHomeScreen(currency);
    }
}
