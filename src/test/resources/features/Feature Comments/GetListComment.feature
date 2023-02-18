Feature: [Go Rest API] Get Comment Feature
  Scenario: Positive case Get list Comment with valid parameter
    Given Get list comments with valid parameter
    When Send request get list comment
    Then Status code should be 200 OK
    And Validate get comment json schema

  Scenario: Negative case Get list Comment with invalid parameter
    Given Get list comment with invalid parameter
    When Send request get list comment
    Then Status code should be 404 Not Found