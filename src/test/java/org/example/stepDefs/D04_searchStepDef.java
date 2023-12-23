package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D04_searchStepDef {
    P03_homePage homePage = new P03_homePage();
    @When("User enters product name or Sku {string}")
    public void userEntersProductName(String productName) {
        homePage.searchForProduct(productName);
    }

    @And("User clicks on search button")
    public void userClicksOnSearchButton() {
        homePage.clickOnSearchButton();
    }

    @Then("Products that searched by name will be displayed {string}")
    public void productsThatSearchedByNameWillBeDisplayed(String productName) {

        homePage.VerifyProductSearchedByNameDisplayedSuccessful(productName);
    }

    @When("User clicks product in search result")
    public void userClicksProductInSearchResult() {
        homePage.clickOnSearchedProduct();
    }

    @Then("Verify Sku displayed as searched {string}")
    public void verifySkuDisplayedAsSearched(String productSku) {
        homePage.CheckSkuIsDisplayedCorrectly(productSku);
    }
}
