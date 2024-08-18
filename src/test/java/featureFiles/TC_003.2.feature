Feature: Product Search

  Background:
    Given The User navigate to the Trendyol Homepage
    When The homepage should load successfully
    Then The Trendyol logo and menu bar should be visible

  Scenario: Search for an Existing Product
    Given The user enter the name of an existing product laptop in the search bar
    When The user perform the search
    Then Relevant products should be listed