Feature: Delete Todo feature

  @gorest
  Scenario: Delete todos with valid id
    Given Delete todo with valid id
    When Send request delete todo
    Then Should return status code 404


  @gorest @NegativeCase
  Scenario: Delete todos with invalid id
    Given Delete todo with invalid id "zzzzz"
    When Send request delete todo
    Then Should return status code 404



