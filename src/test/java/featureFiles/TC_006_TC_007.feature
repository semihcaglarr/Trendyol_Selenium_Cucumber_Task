Feature: Increase Product Quantity in Cart

  Background:
    Given The User navigate to the Trendyol Homepage
    When The homepage should load successfully
    Then The Trendyol logo and menu bar should be visible
    Given The user enter the name of an existing product laptop in the search bar
    When The user perform the search
    Then Relevant products should be listed
    Given The user randomly selects a product
    When The user adds the product to the basket
    And The product must be successfully added to the basket
    Then The number of products added to the basket must be updated correctly
    And The user check the product price in the cart
    Then The price should remain the same before and after adding to the cart

    Scenario: Increase Product Quantity to Two
      Then The user should double the product quantity and the total price should be updated correctly