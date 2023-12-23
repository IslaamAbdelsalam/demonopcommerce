package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D03_currenciesStepDef {
P03_homePage homePage = new P03_homePage();


    @When("User choose {string} currency")
    public void userChooseCurrecy(String currency) {
        homePage.selectCurrency(currency);
    }

    @Then("Displayed product prices symbol should be {string}")
    public void displayedProductPricesSymbolShouldBe(String euroSymbol){
        homePage.checkCurrencySymbol(euroSymbol);
    }

    @Given("User navigates to home page")
    public void userNavigatesToHomePage() {
    }
}
