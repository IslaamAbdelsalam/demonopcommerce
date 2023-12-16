package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.example.pages.P03_homePage;

public class D02_loginStepDef {
    P03_homePage homePage = new P03_homePage();
    P02_login loginPage = new P02_login();
    @Given("User navigates to login page")
    public void userNavigatesLoginPage() {
        homePage.clickOnLoginTab();
    }

    @When("User enters email {string}")
    public void userEntersEmail(String email) {
        loginPage.enterEmail(email);
    }

    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("Error Message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        loginPage.checkErrorMessage();
    }

    @Then("User could login into his account")
    public void userCouldLoginIntoHisAccount() {
        loginPage.successRedirectionAfterSuccessfulLogin();
    }
}
