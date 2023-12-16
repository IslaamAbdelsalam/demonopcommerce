package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D05_hoverCategoriesStepDef {
    P03_homePage homePage = new P03_homePage();

    @And("User hover on main menu")
    public void userHoverOnMainMenu()  {

    }

    @And("sub menu is displayed - if found")
    public void subMenuIsDisplayedIfFound() {

    }

    @When("User can click on main or sub menu")
    public void userCanClickOnMainOrSubMenu() {

    }

    @Then("User redirected to the chosen item page")
    public void userRedirectedToTheChosenItemPage()  throws InterruptedException{
        homePage.menuSelection();
    }



}
