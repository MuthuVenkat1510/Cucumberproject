Feature: To validate the Forgetten Password functionality in Fb Page

  Scenario: To validate the Forgetten Password using invalid mobile No
    Given We have to be in FB login page
    And User have to click forgotten password
    When User have to enter invalid mobile number
    And user have to click search button
    Then User have to be in Identiy account
