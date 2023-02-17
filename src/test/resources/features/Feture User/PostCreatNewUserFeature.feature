Feature: Post creat new user

  Scenario: Post create new user valid parameter and json with auth token
    Given Post create new user valid paramater and json with auth token
    When Send post create new user parameter
    Then Status code should be 201 Created
    And Respons body should be name "ALTA GOREST", gender "male" and Status "active"
    And Validate post create new user resources json schema

  Scenario: Post create new user valid parameter and json without auth token
    Given Post create new user valid parameter and json without auth token
    When Send post create new user parameter
    Then Status code should be 401 Unauthorized
    And Respons body should be message "Authentication failed"
    And Validate post create new user resources json schema without auth token

  Scenario: Post create new user valid parameter and empty name json
    Given Post create new user valid parameter and empty name json with auth token
    When Send post create new user parameter
    Then Status code should be 422 Unprocessable Entity
    And Respons body should be field "name" message "can't be blank"
    And Validate post create new user resources json schema
