@Smoke
Feature: Wishlist Functionality

  Scenario: Add Product to Wishlist
    Given User navigates to home page
    When User click the wishlist button for the product "HTC One M8 Android L 5.0 Lollipop"
    Then the success message "The product has been added to your wishlist" is displayed with a green background
