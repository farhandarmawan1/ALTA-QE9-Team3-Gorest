Feature: [Go Rest API] Patch Update Comment Resource
  Scenario: Positive Case Put Update Comment with Valid JSON and Parameter with Auth
    Given Patch Update comments valid json and parameter 731 with auth token
    When Send patch Update comment
    Then Status code should be 200 OK
    And Response should be id is 731 and user id is 1468 and title is "Benigne coerceo sed ustilo thymum." and body is "Perspiciatis asdasdasjdhas"
    And Validate update comment resources json schema

  Scenario: Negative Case Patch Update Comment with Invalid JSON and Parameter with Auth
    Given Patch Update comments invalid json and parameter 731 with auth token
    When Send patch Update comment
    Then Status code should be 422 Unprocessable Entity

  Scenario: Negative Case Patch Update Comment with Valid JSON and Parameter without Auth
    Given Patch Update comments valid json and parameter 731 with auth token
    When Send patch Update comment
    Then Status code should be 401 Unauthorized