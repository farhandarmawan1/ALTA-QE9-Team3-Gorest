Feature: [user] Get single user

  Scenario: Get single user detail registered
    Given Get single user detail registered
    When Send get single user parameter
    Then Status code should be 200 OK
    And Validate get single user detail resources json schema

  Scenario Outline: Get single user detail unregistered id
    Given Get single user detail unregistered <id>
    When Send get single user parameter
    Then Status code should be 404 Not Found
    And Respons body should error "Resource not found"
    And Validate json schema
    Examples:
        | id    |
        | 12    |
        | 13132 |
        | 67676 |

