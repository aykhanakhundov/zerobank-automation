@ui
Feature: Add new payee under pay bills

  Background:
    Given user is on "Home Page"
    When user goes to "Pay Bills" page
    And user clicks on "Add New Payee" on "Pay Bills" page


  Scenario: Add a new payee
    And fills out payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee Details | XYZ account                              |
    And user clicks on "Submit New Payee" on "Pay Bills" page
    Then "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." message should be displayed