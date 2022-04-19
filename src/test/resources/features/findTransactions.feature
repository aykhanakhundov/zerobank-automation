@ui
Feature: Find Transactions in Account Activity


  Background:
    Given user is on "Home Page"
    And user goes to "Account Activity" page
    And user clicks on "Find Transactions" on "Account Activity" page

  Scenario: Search by date range 1
    When user enters date range from "2012-09-01" to "2012-09-06"
    And user clicks on "Find" on "Account Activity" page
    Then verifies results should only show transactions dates between "2012-09-01" to "2012-09-06"
    And results should be sorted by most recent date

  Scenario: Search by date range 2
    When user enters date range from "2012-09-02" to "2012-09-06"
    And user clicks on "Find" on "Account Activity" page
    Then verifies results should only show transactions dates between "2012-09-02" to "2012-09-06"
    And results should not contain transaction dated "2012-09-01"


  Scenario: Search by description
    When user enters "ONLINE" to description box
    And user clicks on "Find" on "Account Activity" page
    Then verifies results should only show descriptions containing "ONLINE"
    But results should not show descriptions containing "OFFICE"
    When user enters "OFFICE" to description box
    And user clicks on "Find" on "Account Activity" page
    Then verifies results should only show descriptions containing "OFFICE"
    But results should not show descriptions containing "ONLINE"


  Scenario: Search by all types
    When user clicks on "Find" on "Account Activity" page
    Then results should show at least one result under "Deposit"
    And results should show at least one result under "Withdrawal"

  Scenario: Search by deposit type
    When user selects type "Deposit"
    And user clicks on "Find" on "Account Activity" page
    Then results should show at least one result under "Deposit"
    But results should show no result under "Withdrawal"

  Scenario: Search by withdrawal types
    When user selects type "Withdrawal"
    And user clicks on "Find" on "Account Activity" page
    Then results should show at least one result under "Withdrawal"
    But results should show no result under "Deposit"









