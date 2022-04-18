@ui
Feature: Account summary, account activity verification

  Background:
    Given user is on "Home Page"

  Scenario: Verify account summary page
    When user goes to "Account Summary" page
    Then verifies page title is "Zero - Account Summary"
    And verifies "Account Summary" page has following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |


  Scenario: Verify account activity page
    When user goes to "Account Activity" page
    Then verifies page title is "Zero - Account Activity"
    And verifies account dropdown default chosen option is "Savings"
    And verifies account dropdown has following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    And verifies transactions table has following column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |