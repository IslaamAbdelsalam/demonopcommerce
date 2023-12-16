@Smoke
  Feature: hover Categories Feature
    Scenario: Users wants to select randomly from menu main or sub categories
      Given User navigates to home page
      And User hover on main menu
      And  sub menu is displayed - if found
      When  User can click on main or sub menu
      Then User redirected to the chosen item page
