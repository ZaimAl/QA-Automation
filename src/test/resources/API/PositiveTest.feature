@API-positive
Feature: Positive test
  @API-positive1
  Scenario: user GET list from reqres in page one and two
    Given user have an API to access "https://reqres.in/api/users?page="
    And user input to get page one (1) and page two (2)
    When user send a GET respond per page
    Then respond code should be (200)
    And  user GET API respond for each page

  @API-positive2
  Scenario: User POST change name from id in reqres API
    Given user have an API to access "https://reqres.in/api/users/"
    And user print name id before change
    And user change name as "Nebula"
    When user send POST respond to change name
    Then respond code should be (200)
