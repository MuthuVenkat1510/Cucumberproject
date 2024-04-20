Feature: To Validate the Login Functionality

  Background: 
    Given We have to be in FB login page

  Scenario: To Validate Login With Invalid password and InvalidEmailId
    When User have to Enter the Invalid EmailID and Invalid Password
    And Click the loginButton
    Then User have to be in Invalid credientials page

  Scenario: To Validate Login With valid password and InvalidEmailId
    When User have to Enter the valid EmailID and Invalid Password
    And Click the loginButton
    Then User have to be in Invalid credientials page

  Scenario: To Validate Login With Invalid password and validEmailId
    When User have to Enter the Invalid EmailID and valid Password
    And Click the loginButton
    Then User have to be in Invalid credientials page
