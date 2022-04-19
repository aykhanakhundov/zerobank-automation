@ui
Feature: Pay bills page verification

  Background:
    Given user is on "Home Page"
    And user goes to "Pay Bills" page

  Scenario: Verify page title and successful pay operation
    Then verifies page title is "Zero - Pay Bills"
    And user completes "Successful" pay operation
    Then verifies "The payment was successfully submitted." message is displayed for "Successful"


  Scenario: Verify error message if no amount/date inserted
    And user completes "No Amount Selected" pay operation
    Then verifies "Please fill out this field!" message is displayed for "No Amount Selected"
    And user completes "No Date Selected" pay operation
    Then verifies "Please fill out this field!" message is displayed for "No Date Selected"


  Scenario: Verify wrong date is not accepted
    And user completes "Wrong Date" pay operation
    Then user verifies "Wrong Date" is not accepted

  Scenario: Verify wrong amount is not accepted
    And user completes "Wrong Amount" pay operation
    Then user verifies "Wrong Amount" is not accepted