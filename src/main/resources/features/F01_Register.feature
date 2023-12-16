@Smoke
  Feature: Feature: F01_Register | users could register with new accounts


    Scenario: Guest user could register with valid data successfully
   Given User navigates to register page
    And User select gender type "male"
    And User enter first name "automation" and last name "tester"
    And User enter date of birth "4" , "October" , "2018"
    And User enter email "Amit50786@example.com"
    And User enter Password and confirm password fields "P@ssw0rd"
    When User clicks on register button
    Then Success message is displayed