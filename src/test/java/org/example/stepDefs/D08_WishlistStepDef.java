package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D08_WishlistStepDef {
    P03_homePage homePage = new P03_homePage();
    @When("User click wishlist button for HTC product")
    public void userClickWishlistButtonForHTCProduct() {
        homePage.wishListHTCProduct();
    }

    @Then("Verify success message is displayed with a green background")
    public void verifySuccessMessageIsDisplayedWithAGreenBackground()  throws InterruptedException{
        homePage.verifyWishlistSuccessMessage();
    }

    @Then("User will wait till the success addition message is disappeared")
    public void userWillWaitTillTheSuccessAdditionMessageIsDisappeared() {
homePage.waitTillWishlistMessageDisappeared();
    }

    @And("User Clicks on with list tab at the top of the page")
    public void userClicksOnWithListIconAtTheTopOfThePage() {
        homePage.clickOnWithListTabAtTheTopOfThePage();
    }

    @And("Assure if the product is added successfully")
    public void assureIfTheProductIsAddedSuccessfully() {
        homePage.assureProductAddedToWishList();
    }
}
