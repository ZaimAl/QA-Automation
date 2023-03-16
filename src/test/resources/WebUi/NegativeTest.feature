@WebUi-negative
Feature: test Negative
  @WebUi-negative1
  Scenario: User choose the item and purchase it
    Given user is on home page
    And user choose the item
    And user check the item
    When user click checkout button
    Then user input the empty information user
    And user get the error massage "Error: First Name is required"

  @WebUi-negative1
  Scenario: Login Using password and empty username
    Given user is on login page
    And user input username with ""
    And user input password with "secret_sauce"
    When user click login button
    Then user still in login page
    And User see Error message "Epic sadface: Username is required"