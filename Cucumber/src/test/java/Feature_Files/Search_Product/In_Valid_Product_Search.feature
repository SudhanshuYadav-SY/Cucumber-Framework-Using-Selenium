

Feature: User searches for a invalid product
  Scenario: To check if the User can login with valid credentials and then search for an invalid product

    Given User opens Automation window
    Then Navigates to Home Page
    Then User Sign in to System using valid credentials
    And Search for an InValid Product