Feature: Login Feature

  Scenario: Login to Orange HRM with valid login
    Given user is a valid orange HRM user
    When user logs into the HRM portal
    Then user should be on homepage

  Scenario: Login to Orange HRM with invalid login
     Given user is a valid orangeHRM user
     When user logs into the HRM portal with invalid password
     Then user should be on login page