

  Feature: User first add product then empty cart
    Scenario: User should first add product then remove product from cart

      Given User opened Home Page
      Then User logged in
      Then User Add Product to Cart
      Then User removes Product from Cart
      Then User shuts chrome