Feature:verifications Of Options Under Library

Scenario: Verifications Of Options Under Library Find
Given I go to UNO on "Mozilla"
And I click on "LIBRARY"
And I hoverOn in "FIND"
Then I verifyOptionsUnderTab "FIND_BOOKS"
Then I verifyOptionsUnderTab "FIND_DATABASES"
Then I verifyOptionsUnderTab "FIND_E_JOURNALS"
Then I verifyOptionsUnderTab "FIND_LIBRARIES"
Then I verifyOptionsUnderTab "FIND_MATERIALS"
Then I verifyOptionsUnderTab "MORE"
And CloseTheBrowser

				
Scenario: verification Of Facebook LibrarySite
Given I go to UNO on "Mozilla"
And I click on "LIBRARY"
And I click on "FACEBOOK_ICON"
Then I verifyThePageUrlIs "https://www.facebook.com/ekl.library/"
And CloseTheBrowser

	
Scenario: verification Of Twitter LibrarySite
Given I go to UNO on "Mozilla"
And I click on "LIBRARY"
And I click on "TWITTER_ICON"
Then I verifyThePageUrlIs "https://twitter.com/ekl_library"
And CloseTheBrowser

			
Scenario: verification Of Twitter LibrarySite
Given I go to UNO on "Mozilla"
And I click on "LIBRARY"
And I click on "FLICKER_ICON"
Then I verifyThePageUrlIs "https://www.flickr.com/photos/33249530@N07/"
And CloseTheBrowser
