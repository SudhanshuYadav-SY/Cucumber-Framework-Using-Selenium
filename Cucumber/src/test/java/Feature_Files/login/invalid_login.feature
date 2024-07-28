

  Feature: User try to login with invalid Credentials
    Scenario: User having Invalid Credentials should not be allowed to login

      Given User on home page
      Then User reaches Login Page
      Then Enters Invalid Credentials
      When User Tries to Login
      And Gets Error Message
      Then User shuts chrome down