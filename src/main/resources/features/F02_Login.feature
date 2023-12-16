@Smoke
Feature: F02_Login | users could use login functionality to use their accounts
  Scenario: User could login with valid email and password
  Given User navigates to login page
  When User enters email "Amit50786@example.com"
  And User enters password "P@ssw0rd"
  And User clicks on login button
  Then User could login into his account


  Scenario: User could login with invalid email and password
    Given User navigates to login page
    When User enters email "test@amit.com"
    And User enters password "Invalid"
    And User clicks on login button
    Then Error Message should be displayed
