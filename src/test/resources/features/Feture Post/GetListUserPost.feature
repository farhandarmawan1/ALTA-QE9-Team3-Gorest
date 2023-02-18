Feature: Resources Get list end point
  This test case is everything about get list end point

  Scenario: Get list user without parameter
    Given Get list user without parameter
    When Send get list user
    Then Status code should be 200 OK
    And Validate get list post resources json schema

  Scenario Outline: Get list user with invalid feature
    Given Get list user with invalid feature "<post>"
    When Send get list user invalid feature
    Then Status code should be 404 Not Found
    Examples:
      | post  |
      | asdsa |
      | dasda |

  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter <page>
    When Send get list user parameter valid page
    Then Status code should be 200 OK
    And Validate get list post resources json schema
    Examples:
      | page |
      | 1    |
      | 2    |

  Scenario Outline: Get list user with invalid parameter page
    Given Get list user with invalid parameter "<page>"
    When Send get list user parameter valid page
    Then Status code should be 404 Not Found
    Examples:
      | page       |
      | dnaskjknjj |
      | dadsadad   |