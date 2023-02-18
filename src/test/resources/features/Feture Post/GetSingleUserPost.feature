Feature: Resources Get single user
  This test case is everything about get single user

  Scenario Outline: Get single user with valid parameter
    Given Get single user with registered <id>
    When Send get single user post
    Then Status code should be 200 OK
    And Response body should be <id> user
    And Validate get single json schema
    Examples:
      | id    |
      | 18984 |
      | 19215 |
      | 19153 |

  Scenario Outline: Get single user with unregistered id
    Given Get single user with unregistered <id>
    When Send get single user post
    Then Status code should be 404 Not Found
    And Response body should be "Resource not found" as error message
    And Validate get single json schema invalid
    Examples:
      | id |
      | 20 |
      | 22 |
      | 21 |

  Scenario Outline: Get single user with invalid id
    Given Get single user with invalid "<id>"
    When Send get single user post
    Then Status code should be 404 Not Found
    And Response body should be "Resource not found" as error message
    And Validate get single json schema invalid
    Examples:
      | id |
      | 20 |
      | 22 |
      | 21 |

#  Scenario Outline: Get single user with invalid feature
#    Given Get single user with registered <id> and invalid "<feature>"
#    When Send get single user invalid feature
#    Then Status code should be 404 Not Found
#    Examples:
#      | id    | feature |
#      | 18984 | sdadbg  |
#      | 19215 | sdadasd |
#      | 19153 | dfsdfds |