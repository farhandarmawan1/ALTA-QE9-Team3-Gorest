Feature: [Go Rest API] Delete Comment Resources
  Scenario: Positive Case Delete Comment with Valid Parameter with Auth Token
    Given Delete comments valid parameter 731 with auth token
    When Send request delete comment
    Then Status code should be 204 No Content

  Scenario: Negative Case Delete Comment with Valid Parameter without Auth Token
    Given Delete comments valid parameter 731 without auth token
    When Send request delete comment
    Then Status code should be 401 Unauthorized

  Scenario Outline: Negative Case Delete Comment with Invalid Parameter with Auth Token
    Given Delete comments invalid parameter <id> with auth token
    When Send request delete comment not found
    Then Status code should be 404 Not Found
    Examples:
      | id       |
      | "asdasd" |
      | "#@$#@$" |

  Scenario: Negative Case Delete Comment with Blank Parameter with Auth Token
    Given Delete comments blank parameter blank with auth token
    When Send request delete comment blank
    Then Status code should be 404 Not Found