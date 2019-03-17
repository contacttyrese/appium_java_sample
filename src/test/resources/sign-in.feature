Feature: Login
  As a user
  I want to use the login
  In order to login to the app

  @emulator
  Scenario: user selects sign in on login screen & sign in is displayed
    Given user is on login screen
    When user selects sign in on login screen
    Then Google sign in screen is displayed

  @android
  Scenario: user selects sign in on login screen & select account is displayed
    Given user is on login screen
    When user selects sign in on login screen
    Then Google select account screen is displayed