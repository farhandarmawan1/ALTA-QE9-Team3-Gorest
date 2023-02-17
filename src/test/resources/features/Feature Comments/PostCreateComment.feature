Feature: [Go Rest API] Post Comment Resources
  Scenario: Positive Case Post Create Comment with Valid JSON and Parameter
    Given Post create comments valid json and parameter 731 with auth token
    When Send post create comment
    Then Status code should be 201 Created
    And Response should be id is 15123 and post id is 731 and name is "Ambar Chattopadhyay" and email is "ambar_chattopadhyay@smitham.io" and body is "Quia esse porro. Eveniet maiores repellat."
    And Validate post create comment resources json schema

  Scenario: Negative Case Post Create Comment with Invalid JSON and Valid Parameter
    Given Post create comments invalid json and parameter 9 with auth token
    When Send post create comment
    Then Status code should be 422 Unprocessable Entity

  Scenario: Negative Case Post Create Comment with valid JSON and Parameter without Auth Token
    Given Post create comments valid json and parameter 731 without auth token
    When Send post create comment
    Then Status code should be 401 Unauthorized