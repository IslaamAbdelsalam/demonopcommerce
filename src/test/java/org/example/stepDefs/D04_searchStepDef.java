package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.example.pages.P04_search;
import org.example.pages.P05_productInfo;

public class D04_searchStepDef {
    P03_homePage homePage = new P03_homePage();
P04_search searchPage = new P04_search();
    P05_productInfo productInfoPage = new P05_productInfo();
    @When("User enters product name or Sku {string}")
    public void userEntersProductName(String productName) {
        homePage.searchForProduct(productName);
    }

    @Given("User navigates to home page")
    public void userNavigatesToHomePage() {
    }
    @And("User clicks on search button")
    public void userClicksOnSearchButton() {
        homePage.clickOnSearchButton();
    }

    @Then("Products that searched by name will be displayed {string}")
    public void productsThatSearchedByNameWillBeDisplayed(String productName) {

        searchPage.VerifyProductSearchedByNameDisplayedSuccessfull(productName);
    }

    @When("User clicks product in search result")
    public void userClicksProductInSearchResult() {
        searchPage.clickOnSearchedProduct();
    }

    @Then("Verify Sku displayed as searched {string}")
    public void verifySkuDisplayedAsSearched(String productSku) {
        productInfoPage.CheckSkuIsDisplayedCorrectly(productSku);
    }
}
