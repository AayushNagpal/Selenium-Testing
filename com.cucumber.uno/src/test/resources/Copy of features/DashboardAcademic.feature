Feature:Verifying scenarios in Dashboard

Scenario: Verifying scenarios in Dashboard - Academic Calendar
Given I go to UNO on "Mozilla"
And I click on "ACADEMIC_CALENDER"
Then verifyOptionsInNavigator "REHISTRAR";
Then verifyOptionsInNavigator "ACADEMIC_SCHEDULING";
Then verifyOptionsInNavigator "APP_FOR_DEGREE";
Then verifyOptionsInNavigator "APPEAL_FORM";
Then verifyOptionsInNavigator "COMMENCEMENT";
Then verifyOptionsInNavigator "COURSE_DESCRIPTION";
Then verifyOptionsInNavigator "DEGREE_AUDIT";
Then verifyOptionsInNavigator "ENROL_VERIFICATION";
Then verifyOptionsInNavigator "FAM_EDU_RIGHTS";
Then verifyOptionsInNavigator "FINAL_EXAM_SCHEDULE";
Then verifyOptionsInNavigator "FORMS";
Then verifyOptionsInNavigator "GRADE_CHANGE_FORM";
Then verifyOptionsInNavigator "ROOM_RESERVATION";
Then verifyOptionsInNavigator "TRANSCRIPT_REQUEST";
Then verifyOptionsInNavigator "TUTION_REFUND_POLICY";
Then verifyOptionsInNavigator "UNIVERSITY_CTALOG";
Then verifyOptionsInNavigator "VETERANS_AFFAIRS";
Then verifyOptionsInNavigator "CONTACT_US";
And CloseTheBrowser


Scenario: verification Of clicking on PDF LINK in academic calender
Given I go to UNO on "Mozilla"
And I click on "ACADEMIC_CALENDER"
And I click on "PDF_LINK"	
And CloseTheBrowser
			