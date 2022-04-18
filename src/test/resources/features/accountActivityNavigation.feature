@ui
Feature: Navigating to specific accounts in Accounts Activity Scenario: Savings account redirect

  Background:
    Given user is on "Home Page"
    And user goes to "Account Summary" page

  Scenario: Savings account redirect
    When user clicks on "Savings Link" on "Account Summary" page
    Then verifies page title is "Zero - Account Activity"
    And verifies account dropdown default chosen option is "Savings"

  Scenario: Brokerage account redirect
    When user clicks on "Brokerage Link" on "Account Summary" page
    Then verifies page title is "Zero - Account Activity"
    And verifies account dropdown default chosen option is "Brokerage"

  Scenario: Checking account redirect
    When user clicks on "Checking Link" on "Account Summary" page
    Then verifies page title is "Zero - Account Activity"
    And verifies account dropdown default chosen option is "Checking"

  Scenario: Credit Card account redirect
    When user clicks on "Credit Card Link" on "Account Summary" page
    Then verifies page title is "Zero - Account Activity"
    And verifies account dropdown default chosen option is "Credit Card"

  Scenario: Loan account redirect
    When user clicks on "Loan Link" on "Account Summary" page
    Then verifies page title is "Zero - Account Activity"
    And verifies account dropdown default chosen option is "Loan"
