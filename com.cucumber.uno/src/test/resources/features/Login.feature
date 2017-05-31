Feature:Logging in UNO.EDU
In order to see my account
As a user
I want to login

Scenario: Login functionality check
Given I go to UNO on "Mozilla"
And I click on "APPLY_NOW"
And I click on "APPLY_NOW_BTN"
And I click on "USER_LOGIN"
And I enter "USERNAME" as "testing123@gmail.com"
And I enter "PASSWORD" as "Testing@123"
And I click on "LoginButton"
Then login should be "Success"
And CloseTheBrowser
