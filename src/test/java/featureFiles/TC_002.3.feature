Feature: Unsuccessful Login

  Background:
    Given The User navigate to the Trendyol Homepage
    When The homepage should load successfully
    Then The Trendyol logo and menu bar should be visible

  Scenario: Login with Incorrect Email and Password
    Given The User enter a incorrect email and an incorrect password
    When The User attempt to log in
    Then The User should receive an incorrect password error message