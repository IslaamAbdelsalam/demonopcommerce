@Smoke
Feature: F07_followUs | Users could open Follow Us links

  Scenario: User opens Facebook link
    Given User navigates to home page
    When User opens the social media facebook link
    Then The page is opened in a new tab "https://www.facebook.com/nopCommerce"

  Scenario: User opens twitter link
    Given User navigates to home page
    When User opens the social media twitter link
    Then The page is opened in a new tab "https://twitter.com/nopCommerce"

  Scenario: User opens RSS  link
    Given User navigates to home page
    When User opens the social media RSS link
    Then The page is opened in a new tab "https://demo.nopcommerce.com/news/rss/1"

  Scenario: User opens YouTube   link
    Given User navigates to home page
    When User opens the social media YouTube link
    Then The page is opened in a new tab "https://www.youtube.com/user/nopCommerce"
