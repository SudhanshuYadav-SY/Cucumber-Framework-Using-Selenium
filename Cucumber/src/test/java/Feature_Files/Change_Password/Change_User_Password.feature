

  Feature: Logged in User should be able to change Password
    Scenario: User should first log in to the application then change Password Successfully

      Given User at Home Page
      Then User logs in
      And User navigates to Change Password
      And User changes Password
      Then User closes browser