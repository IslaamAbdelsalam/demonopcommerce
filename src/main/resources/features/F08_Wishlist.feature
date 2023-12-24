@Smoke
Feature: Wishlist Functionality

  Scenario: Add Product to Wishlist
    Given User navigates to home page
    When User click wishlist button for HTC product
    Then Verify success message is displayed with a green background


  Scenario: Guest can successfully add product to wish list
    Given User navigates to home page
    When User click wishlist button for HTC product
    Then User will wait till the success addition message is disappeared
    And User Clicks on with list tab at the top of the page
    And Assure if the product is added successfully


