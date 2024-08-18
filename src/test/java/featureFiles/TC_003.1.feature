Feature: Product Search

  Background:
    Given The User navigate to the Trendyol Homepage
    When The homepage should load successfully
    Then The Trendyol logo and menu bar should be visible

  Scenario: Search for a Non-existing Product
    Given The user enter the name of an existing product asdfghty55 in the search bar
    When The user perform the search
    Then Product not found message should be displayed