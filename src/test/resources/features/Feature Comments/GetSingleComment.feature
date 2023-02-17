Feature: [Go Rest API] Get Single Comment Feature
  Scenario : Positive Case Get SIngle Comment with Valid Parameter
    Given Get single comment with valid parameter id 731
    When Send request get single comment
    Then Status code should be 200 OK
    And Validate get single comment JSON


  Scenario Outline: Negative Case Get Single Comment with Invalid Parameter
    Given Get single comment with invalid parameter <id>
    When Send request get single comment
    Then Status code should be 404 Not Found
    Examples:
      | id       |
      | "asdasd" |
      | "@#$@$%" |

    Scenario: Negative Case Get SIngle Comment with Blank Parameter
      Given Get single comment with blank parameter id asdfh
      When Send request get single comment
      Then Status code should be 404 Not Found