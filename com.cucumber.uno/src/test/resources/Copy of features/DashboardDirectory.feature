Feature:Searching for an person under Directory
In order to see my details
As a user
I will search in Directory

Scenario: Searching for an person under Directory
Given I go to UNO on "Mozilla"
And I click on "DIRECTORY"
And I enter "SEARCH_DIRECTORY_TXT" as "Shivank"
And I click on "SEARCH_PERSONNEL_BTN"
Then verifySearchResultText"DIRECTORY_NAME"
And CloseTheBrowser
