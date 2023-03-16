@WebUi-positive
Feature: test Positive
  @WebUi-positive1
  Scenario: User choose the item and purchase it
    Given user is on home page
    And user choose the item
    And user check the item
    When user click checkout button
    Then user input the information user
    And user get the checkout: overview
    And user get notification "Thank you for your order!"
  @WebUi-positive2
  Scenario: User choose the item and cancel it
    Given user is on home page
    And user choose the item
    And user check the item
    And user cancel the item
    When user click continue shopping button
    Then user back to the home page