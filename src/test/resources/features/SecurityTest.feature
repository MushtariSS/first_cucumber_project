Feature: Security tests scenarios

  Scenario: validate sign in functionality with valid credential
    When user click on sign in link
    Then input the validate username and password
    And click on  login button
    # When user enter username and password and click on login
    Then user should be able to see account link