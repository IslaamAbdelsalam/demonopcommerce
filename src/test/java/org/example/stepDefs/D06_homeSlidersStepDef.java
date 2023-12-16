package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D06_homeSlidersStepDef {
P03_homePage homePage  = new P03_homePage();

    @When("User clicks on the first slider \\(Nokia Lumia)")
    public void userClicksOnTheFirstSliderNokiaLumia() {
        homePage.userClicksOnFirstSlider();
    }

    @Then("User should be redirected to {string}")
    public void userShouldBeRedirectedTo(String expectedUrl) {
        homePage.SliderRedirection(expectedUrl);
    }

    @When("User clicks on the second slider - iPhone")
    public void userClicksOnTheSecondSliderIPhone() {
        homePage.userClicksOnSecondSlider();
    }
}
