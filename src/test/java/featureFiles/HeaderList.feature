Feature: HeaderList feature

Scenario: Login to OrangeHRMPage with valid login
Given user is a valid OrangeHRMPage user
When user logs into the OrangeHRM portal
Then user should be on homepage and see list of Header elements

