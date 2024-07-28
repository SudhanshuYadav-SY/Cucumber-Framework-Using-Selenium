

Feature: Check What Price is displayed just after login
  Scenario: Price should be $0.00 for a fresh user logged in

    Given User is at Home Page
    Then User logs in successfully
    Then Check Price in Cart
    And User ends the Session