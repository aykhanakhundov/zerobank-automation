@ui
Feature: Find Transactions in Account Activity


  Background:
    Given user is on "Home Page"
    And user goes to "Account Activity" page
    And user clicks on "Find Transactions" on "Account Activity" page

  Scenario: Search date range 1
    When user enters date range from "2012-09-01" to "2012-09-06"
    And user clicks on "Find" on "Account Activity" page
    Then verifies results should only show transactions dates between "2012-09-01" to "2012-09-06"
    And results should be sorted by most recent date

  Scenario: Search date range 2
    When user enters date range from "2012-09-02" to "2012-09-06"
    And user clicks on "Find" on "Account Activity" page
    Then verifies results should only show transactions dates between "2012-09-02" to "2012-09-06"
    And results should not contain transaction dated "2012-09-01"


  Scenario: Search description
    When user enters "ONLINE" to description box
    And user clicks on "Find" on "Account Activity" page
    Then verifies results should only show descriptions containing "ONLINE"
    But results should not show descriptions containing "OFFICE"
    When user enters "OFFICE" to description box
    And user clicks on "Find" on "Account Activity" page
    Then verifies results should only show descriptions containing "OFFICE"
    But results should not show descriptions containing "ONLINE"










