@WebUi-boundary
Feature: test Batas
  @WebUi-boundary1
  Scenario: the user made an appointment and has not logged in
    Given user is on home page to make appointment
    And user click make appointment button
    And user must login first
    And user input an information to login
    When user click button login
    Then user input an appointment schedule
    And  user click button book appointment
    And user see an appointment confirmation "Please be informed that your appointment has been booked as following:"
  @WebUi-boundary2
  Scenario: User choose the item and take more than quantity
    Given user is on home page website
    And user choose new outfit
    And user choose an item
    And user input quantity with: "99999"
    When user click add to cart button
    Then user get the error message with: "The maximum you may purchase is 10000."