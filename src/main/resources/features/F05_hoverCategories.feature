@Smoke
  Feature: hover Categories Feature
    Scenario: Users wants to select randomly from menu main or sub categories
      Given User navigates to home page
      And Hover on main menu
      And  Sub menu will be displayed - if found
      When  User can click on main or sub menu
      Then User redirected to the chosen item page
