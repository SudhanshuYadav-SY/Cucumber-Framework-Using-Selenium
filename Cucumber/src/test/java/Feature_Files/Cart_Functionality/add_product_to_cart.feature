

  Feature: User able to add product to Cart
    Scenario: User should login first and then add a product to Cart Successfully

      Given User opens Chrome Browser
      Then User launches application
      Then User signs in to system
      Then Searches a product
      And adds the product to cart
      Then User shuts down chrome