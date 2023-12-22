package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D07_followUsStepDef {
    P03_homePage homePage = new P03_homePage();

    @When("User opens the social media facebook link")
    public void userOpensTheSocialMediaFacebookLink() {
        homePage.clickOnFacebookIcon();
    }

    @Then("Verify the page {string} is opened in a new tab then close it")
    public void thePageIsOpenedInANewTab (String expectedLink) throws InterruptedException {
        homePage.VerifyOpenedLink(expectedLink);
    }

    @When("User opens the social media twitter link")
    public void userOpensTheSocialMediaTwitterLink() {
        homePage.clickOnTwitterIcon();
    }

    @When("User opens the social media RSS link")
    public void userOpensTheSocialMediaRSSLink() {
        homePage.clickOnRSSIcon();
    }

    @When("User opens the social media YouTube link")
    public void userOpensTheSocialMediaYouTubeLink() {
        homePage.clickOnYoutubeIcon();
    }
}
