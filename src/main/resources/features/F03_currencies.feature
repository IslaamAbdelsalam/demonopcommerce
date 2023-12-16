@Smoke
  Feature: Currencies Feature
    Scenario: Check products currency when switch currency to euro
      Given User navigates to home page
      When User choose "Euro" currency
      Then Displayed product prices symbol should be "€"