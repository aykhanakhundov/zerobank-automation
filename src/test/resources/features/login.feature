@ui
Feature: Login functionality

  Background:
    Given user navigates to "Login Page"

  Scenario: Login with valid credentials
    When user sends "Valid" credentials
    Then verifies page title is "Zero - Account Summary"


  Scenario: Login with invalid credentials
    When user sends "Invalid" credentials
    Then verifies "Login and/or password are wrong." is displayed


  Scenario: Login with blank credentials
    When user sends "Blank" credentials
    Then verifies "Login and/or password are wrong." is displayed
