Feature: [User]delete user

  Scenario: Delete user id registered with auth token
    Given Delete user id registered valid parameter with auth token
    When Send delete user parameter
    Then Status code should be 204 No content

  Scenario: Delete user id registered without auth token
    Given Delete user id registered without auth token
    When Send delete user parameter
    Then Status code should be 401 Unauthorized
    And Respons body should be message "Authentication failed"
    And Validate delete new user resources json schema

  Scenario: Delete user id unregistered with auth token
    Given Delete user id 757576 registered  with auth token
    When Send delete user parameter
    Then Status code should be 404 Not Found
    And Respons body should be message "Resource not found"
    And Validate delete new user not found resources json schema