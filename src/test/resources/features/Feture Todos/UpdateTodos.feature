Feature: Update feature gorest API

  @gorest
  Scenario: Update todo with valid status
    Given Update todo with valid status
    When Send request update todo
    Then API should return response 200 OK
    And Validate json schema

  @gorest
  Scenario: Update todo with invalid status
    Given Update todo with invalid status
    When Send request update todo
    Then API should return response 422 Unprocessable Entity

  @gorest
  Scenario: Update todo with valid title json
    Given Update todo with valid title json
    When Send request update todo
    Then API should return response 200 OK
    And Validate json schema

  @gorest
  Scenario: Update todo with invalid title json
    Given Update todo with invalid title json
    When Send request update todo
    Then API should return response 422 Unprocessable Entity

  @gorest
  Scenario: update todo with valid doe_on json
    Given Update todo with valid doe_on json
    When Send request update todo
    Then API should return response 200 OK
    And Validate json schema

  @gorest
  Scenario: Update todo with invalid doe_on json
    Given Update todo with invalid doe_on json
    When Send request update todo
    Then API should return response 422 Unprocessable Entity