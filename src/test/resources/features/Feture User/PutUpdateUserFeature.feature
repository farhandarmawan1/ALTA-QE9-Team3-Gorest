Feature: Put update User

  Scenario Outline:
    Given Put update user id <id> valid paramater and json with auth token
    When Send put update user parameter
    Then Status code should be 200 OK
    And Respons body should be name "ALTA GOREST", gender "male" and Status "active"
    And Validate put update user resources json schema
    Examples:
      | id     |
      | 431036 |
      | 441759 |
      | 440680 |
    Scenario: Put update user valid parameter and json without auth token
      Given Put update user id 440680 valid paramater and json without auth
      When Send put update user parameter
      Then Status code should be 401 Unauthorized
      And Respons body should be message "Authentication failed"
      And Validate put update user without token resources json schema

      Scenario: Put update user valid parameter and empty name json
        Given Put update user id 440680 valid parameter and empty name json with auth token
        When Send put update user parameter
        Then Status code should be 422 Unprocessable Entity
        And Respons body should be field "name" message "can't be blank"
        And Validate put update user invalid resources json schema

        Scenario: Put update user valid parameter and empty email json
          Given Put update user id 440680 valid  parameter and empty email json with auth token
          When Send put update user parameter
          Then Status code should be 422 Unprocessable Entity
          And Respons body should be field "email" message "can't be blank"
          And Validate put update user invalid resources json schema

          Scenario: Put update user user valid parameter and empty gender json
            Given Put update user id 440680 valid parameter and empty gender json with auth token
            When Send put update user parameter
            Then Status code should be 422 Unprocessable Entity
            And Respons body should be field "gender" message "can't be blank, can be male of female"
            And Validate put update user invalid resources json schema

     Scenario: Put update user user valid parameter and empty status json
       Given Put update user id 440680 valid parameter and empty status json with auth token
       When Send put update user parameter
       Then Status code should be 422 Unprocessable Entity
       And Respons body should be field "status" message "can't be blank"
       And Validate put update user invalid resources json schema

      Scenario Outline:
        Given Put update user id <id> invalid parameter with auth token
        When Send put update user parameter
        Then Status code should be 404 Not Found
        Examples:
          | id    |
          | 12    |
          | 13132 |
          | 67676 |





