@Smoke
Feature: Verify Slider Clickable Links

  Scenario: Clicking on the first slider should navigate to the correct URL
    Given User navigates to home page
    When User clicks on the first slider (Nokia Lumia)
    Then User should be redirected to "https://demo.nopcommerce.com/nokia-lumia-1020"

  Scenario: Clicking on the second slider should navigate to the correct URL
    Given User navigates to home page
    When User clicks on the second slider - iPhone
    Then User should be redirected to "https://demo.nopcommerce.com/iphone-6"