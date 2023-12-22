@Smoke
Feature: F07_followUs | Users could open Follow Us links

  Scenario: User opens Facebook link
    Given User navigates to home page
    When User opens the social media facebook link
    Then Verify the page "https://www.facebook.com/nopCommerce" is opened in a new tab then close it

  Scenario: User opens twitter link
    Given User navigates to home page
    When User opens the social media twitter link
    Then Verify the page "https://twitter.com/nopCommerce" is opened in a new tab then close it

  Scenario: User opens RSS  link
    Given User navigates to home page
    When User opens the social media RSS link
    Then Verify the page "https://demo.nopcommerce.com/news/rss/1" is opened in a new tab then close it

  Scenario: User opens YouTube   link
    Given User navigates to home page
    When User opens the social media YouTube link
    Then Verify the page "https://www.youtube.com/user/nopCommerce" is opened in a new tab then close it
