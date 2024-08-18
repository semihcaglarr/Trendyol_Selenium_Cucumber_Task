Feature: Homepage Access

  Scenario: Accessing the Trendyol Homepage
    Given The User navigate to the Trendyol Homepage
    When The homepage should load successfully
    Then The Trendyol logo and menu bar should be visible
