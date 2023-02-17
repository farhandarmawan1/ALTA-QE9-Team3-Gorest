@GoRest
  Feature: Update User
    This test case is everything about update user

  Scenario: Update valid user
    Given Put update user with valid parameter 19519 as id and json with auth token
    When Send put update user parameter
    Then Status code should be 200 OK
    And Response body should be 384520 as user_id
    And Validate put update user resources json schema

  Scenario Outline: Update invalid id user
    Given Put update user with valid parameter "<id>" as id and json with auth token
    When Send put update user parameter
    Then Status code should be 404 Not Found
    And Response body should be "Resource not found" as error message
    And Validate get single json schema invalid
    Examples:
      | id    |
      | 19519 |
      | adasd |

  Scenario: Update user with unregistered user_id
    Given Put update user with valid parameter 19519 as id and invalid user_id with auth token
    When Send put update user parameter
    Then Status code should be 422 Unprocessable Entity
#    And Response body should be "user" as field and "must exist" as message
    And Validate put unregistered id resources json schema

  Scenario: Update user without inputting title
    Given Put update user with valid parameter 19519 as id and not inputting title
    When Send put update user parameter
    Then Status code should be 200 OK
    And Response body should be 384520 as user_id
    And Validate put update user resources json schema

  Scenario: Update user without inputting body
    Given Put update user with valid parameter 19519 as id and not inputting body
    When Send put update user parameter
    Then Status code should be 200 OK
    And Response body should be 384520 as user_id
    And Validate put update user resources json schema