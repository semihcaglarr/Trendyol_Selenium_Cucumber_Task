Feature: Trendyol Shopping Processes Functionality

  @SmokeTest
  Scenario: The User searches for products and adds to basket

    Given Navigate to trendyol.com
    When The User clicks the Accept button
    And User must block notifications from trendyol.com
    And User should see the home page open
    And User hover and then click Login
    When Enter username and password and click login button
    And Already warning message should be displayed
    And User must enter the word laptop in the search box
    Then User selects a random product from the laptops according to the results and adds it to the basket
    When The price of the product before it is added to the basket and the price after it is added to the basket must be the same
    Then The number of items in the basket should be doubled and the total price updated correctly







