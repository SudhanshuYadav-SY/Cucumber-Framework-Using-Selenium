

  Feature: User should be able to get product Description
    Scenario: User should try to add a product but before that he should read Product Description

      Given User is currently on the home page
      Then  User accesses the home page
      Then User completes a successful login
      Then the user looks up a valid product
      And User gets product description
      Then user shuts chrome down