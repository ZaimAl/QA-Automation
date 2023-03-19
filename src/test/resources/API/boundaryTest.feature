@API-boundary
Feature: Boundary test
  @API-boundary1
  Scenario: user GET pokedex generation 1, 2, and 3 in respond
    Given user have an API to access all pokedex "https://pokeapi.co/api/v2/pokemon"
    And user know the number of pokedex gen one (151), gen two (251), and gen third (386)
    When user send a GET respond
    Then respond code should be (200)
    And  user GET API respond for each pokedex

  @API-boundary2
  Scenario: User GET list from reqres API
    Given user have an API to access "https://reqres.in/api/users"
    And user choose page (2) and per_page (7)
    When user send GET API respond
    Then respond code should be (200)
    And respond should be page (2) and per_page (7)
