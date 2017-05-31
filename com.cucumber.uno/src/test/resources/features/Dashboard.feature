Feature:Verifying options in Dashboard

Scenario: verify Options Under AboutTab
Given I go to UNO on "Mozilla"
And I click on "ABOUT"
Then I verifyOptionsUnderTab "ABOUT_UNO"
Then I verifyOptionsUnderTab "UNO_AT_GLANCE"
Then I verifyOptionsUnderTab "MISSION_VISION"
Then I verifyOptionsUnderTab "Administrative_OFFICE"
Then I verifyOptionsUnderTab "OFFICE_PRESIDENT"
Then I verifyOptionsUnderTab "ALUMNI"
Then I verifyOptionsUnderTab "UNO_HISTORY"

Scenario: verify Regarding Prospective Student Tab Navigation Options Under AboutTab
Given I go to UNO on "Mozilla"
And I click on "PROSPECTIVE_STUDENTS"
Then I verifyThePageUrlIs "http://uno.edu/prospectivestudents/index.aspx"


Scenario: verify Footer Links
Given I go to UNO on "Mozilla"
Then I verifyFooterLink "NON_DISC_FTR_LNK"
Then I verifyFooterLink "EMERGENCY_FTR_LNK"
Then I verifyFooterLink "CONTACT_FTR_LNK"
Then I verifyFooterLink "SACSOC_FTR_LNK"
Then I verifyFooterLink "COPYRIGHT_FTR_LNK"

	
Scenario: verify Facebook From Dashboard
Given I go to UNO on "Mozilla"
And I click on "FACEBOOK"
Then I verifyThePageUrlIs "https://www.facebook.com/UniversityOfNewOrleans"

	
Scenario: verifying Giving Link
Given I go to UNO on "Mozilla"
And I click on "GIVING"
And SwitchToChildWindow "1"
Then hoveron "Gift_BUSINESS_ADMIN"

				

