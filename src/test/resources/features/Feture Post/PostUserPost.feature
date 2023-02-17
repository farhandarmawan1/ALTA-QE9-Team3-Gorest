@GoRest
  Feature: Post new user
    This test case is everything about post user

  Scenario: Post new user with valid data
    Given Post new user with valid parameter and json with auth token
    When Send post new user parameter
    Then Status code should be 201 Created
    And Response body should be 384520 as user_id
    And Validate put update user resources json schema

  Scenario: Post new user with invalid data
    Given Post new user with empty json
    When Send post new user parameter
    Then Status code should be 422 Unprocessable Entity
    And Validate post empty json data schema

  Scenario: Post new user with unregistered user_id
    Given Post new user with valid json data and unregistered id_user
    When Send post new user parameter
    Then Status code should be 422 Unprocessable Entity
    And Validate post unregistered User_id json data schema

  Scenario: Post new user without inputting user_id
    Given Post new user without inputting user_id
    When Send post new user parameter
    Then Status code should be 422 Unprocessable Entity
    And Validate post without inputting User_id json data schema

  Scenario: Post new user without inputting title
    Given Post new user without inputting title
    When Send post new user parameter
    Then Status code should be 422 Unprocessable Entity
    And Validate post without inputting title json data schema

  Scenario: Post new user without inputting body
    Given Post new user without inputting body
    When Send post new user parameter
    Then Status code should be 422 Unprocessable Entity
    And Validate post without inputting body json data schema
