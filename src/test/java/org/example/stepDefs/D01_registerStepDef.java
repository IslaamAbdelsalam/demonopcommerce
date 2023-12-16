package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.example.pages.P03_homePage;

public class D01_registerStepDef{

    P03_homePage homePage = new P03_homePage();
    P01_register registerPage = new P01_register();

    @Given("User navigates to register page")
    public void userNavigatesToRegisterPage() {
        homePage.clickOnRegisterTab();
    }

    @And("User select gender type {string}")
    public void userSelectGenderType(String gender) {
        registerPage.selectGeneder(gender);
    }

    @And("User enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String firstName, String lastName) {
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
    }

    @And("User enter date of birth {string} , {string} , {string}")
    public void userEnterDateOfBirth(String day, String month, String year) {
        registerPage.selectDay(day);
        registerPage.selectMonth(month);
        registerPage.selectYear(year);
    }

    @And("User enter email {string}")
    public void userEnterEmail(String email) {
        registerPage.enterEmail(email);
    }

    @And("User enter Password and confirm password fields {string}")
    public void userEnterPasswordAndConfirmPasswordFields(String password) {
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
    }

    @When("User clicks on register button")
    public void userClicksOnRegisterButton() {
        registerPage.clickOnRegisterButton();
    }

    @Then("Success message is displayed")
    public void successMessageIsDisplayed() {
        registerPage.checkRegisterSuccessMessage();
    }
}
