Feature: Login Feature

  Scenario: Login to Orange HRM
    Given user is a valid orange HRM user
    When user logs into the HRM portal
    Then user should be on homepage

