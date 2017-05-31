Feature:Creation of account in UNO.EDU
In order to check the creation functionality
As a new user
I want to create account

Scenario: Creating New Account check
Given I go to UNO on "Mozilla"
And I click on "APPLY_NOW"
And I click on "APPLY_NOW_BTN"
And I click on "CREATE_ACCOUNT"
And I enter "LAST_NAME" as "testing123"
And I enter "FIRST_NAME" as "Testing@123"
And I enter "MIDDLE_NAME" as "Testing@123"
And selectOptionInDropDown in "DOB_MONTH" as "January"
And selectOptionInDropDown in "DOB_DAY" as "1"
And selectOptionInDropDown in "DOB_YEAR" as "1985"
And I click on "NO_RD_BTN"
And selectOptionInDropDown in "COUNTRY_DD" as "India"
And I enter "ADDRESS_LINE_1" as "Testing@123"
And I enter "ADDRESS_LINE_2" as "Testing@123"
And I enter "CURRENT_CITY" as "Testing@123"
And I enter "EMAIL_ADD" as "Testing@123@gmail.com"
And I enter "VERIFY_EMAIL_ADD" as "Testing@123@gmail.com"
And I enter "CRT_USERNAME" as "Testing@123"
And I enter "CRT_PASSWORD" as "Testing@123"
And I enter "CRT_VRYPASSWORD" as "Testing@123"
And I click on "SUBIT_INFORMATION"
Then verifyAccountCreationLink"SUCCESS_LINK"
And CloseTheBrowser
