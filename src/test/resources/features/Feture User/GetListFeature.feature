Feature: Get list user

  Scenario: Get list user with valid parameter
  Given Get list user with valid parameter
  When Send get list user parameter
  Then Status code should be 200 OK
  And Validate get list resources json schema