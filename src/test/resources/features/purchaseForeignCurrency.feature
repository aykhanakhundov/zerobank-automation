@ui
Feature: Purchase Foreign Currency

  Background:
    Given user is on "Home Page"
    And user goes to "Pay Bills" page
    And user clicks on "Purchase Foreign Currency" on "Pay Bills" page

  Scenario: Available currencies
    Then following currencies should be available in currency dropdown
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Hong Kong (dollar)    |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Sweden (krona)        |
      | Singapore (dollar)    |
      | Thailand (baht)       |


  Scenario: Error message for not selecting currency
    When user tries to calculate cost without selecting "Currency"
    Then "Please, ensure that you have filled all the required fields with valid values." should be displayed as error message


  Scenario: Error message for not entering amount
    When user tries to calculate cost without selecting "Amount"
    Then "Please, ensure that you have filled all the required fields with valid values." should be displayed as error message