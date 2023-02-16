Feature:Get single user


  Scenario: Get single user detail registered
    Given Get single user detail registered <id>
    When Send get single user parameter
    Then Status code should be 200 OK
    And Respons body should be id user
    And Validate get single user detali resources json schema

      | id     |
      | 401705 |
      | 740    |
      | 400040 |

