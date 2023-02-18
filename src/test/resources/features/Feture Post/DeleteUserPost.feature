Feature: Resources Delete user
    This test case is everything about delete user

  Scenario Outline: Delete user with valid id
    Given Delete single user with valid and existing parameter <id>
    When Send delete single user post
    Then Status code should be 204 No Content
    Examples:
      | id    |
      | 17933 |
      | 17811 |

  Scenario Outline: Delete user with previously deleted
    Given Delete single user with previously <id>
    When Send delete previously single user
    Then Status code should be 404 Not Found
    And Response body should be "Resource not found" as error message
    And Validate delete user json schema invalid
    Examples:
      | id    |
      | 17933 |
      | 17811 |

  Scenario: Delete user without parameter id
    Given Delete user without parameter id
    When Send delete single user without id post
    Then Status code should be 404 Not Found

  Scenario Outline: Delete user with invalid parameter id
    Given Delete single user with invalid "<id>"
    When Send delete single user post
    Then Status code should be 404 Not Found
    And Response body should be "Resource not found" as error message
    And Validate delete user json schema invalid
    Examples:
      | id     |
      | gregeg |
      | gergg  |