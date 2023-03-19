@API-negative
Feature: Negative test
  @API-negative1
  Scenario: the user enters a post with the contents swapped
    Given user have an API to access "https://reqres.in/api/users"
    And user give name as job "Manager"
    And user give job as name "Carolina"
    When user send a post respond
    Then respond code should be (201)
    And  respond should be name "Manager"
    And  respond should be job "Carolina"


  @API-negative2
  Scenario: User POST list from gorest API but only name
    Given user have an API to access "https://gorest.co.in/public/v2/users"
    And uset get the primary token "24761157b81008ea15deac547562f532cd961c6c741dca1c6dc1ea5b08f08cac"
    And user give name as "Nada"
    When user send post respond
    Then respond code should be (422)
