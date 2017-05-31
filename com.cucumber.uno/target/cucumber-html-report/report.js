$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Dashboard.feature");
formatter.feature({
  "line": 1,
  "name": "Verifying options in Dashboard",
  "description": "",
  "id": "verifying-options-in-dashboard",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "verify Options Under AboutTab",
  "description": "",
  "id": "verifying-options-in-dashboard;verify-options-under-abouttab",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I go to UNO on \"Mozilla\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I click on \"ABOUT\"",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I verifyOptionsUnderTab \"ABOUT_UNO\"",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "I verifyOptionsUnderTab \"UNO_AT_GLANCE\"",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I verifyOptionsUnderTab \"MISSION_VISION\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I verifyOptionsUnderTab \"Administrative_OFFICE\"",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I verifyOptionsUnderTab \"OFFICE_PRESIDENT\"",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I verifyOptionsUnderTab \"ALUMNI\"",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I verifyOptionsUnderTab \"UNO_HISTORY\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Mozilla",
      "offset": 16
    }
  ],
  "location": "DashboardTest.gotoFacebook(String)"
});
formatter.result({
  "duration": 14525453934,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ABOUT",
      "offset": 12
    }
  ],
  "location": "DashboardTest.click(String)"
});
formatter.result({
  "duration": 768127531,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ABOUT_UNO",
      "offset": 25
    }
  ],
  "location": "DashboardTest.i_verifyOptionsUnderTab(String)"
});
formatter.result({
  "duration": 1028843749,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "UNO_AT_GLANCE",
      "offset": 25
    }
  ],
  "location": "DashboardTest.i_verifyOptionsUnderTab(String)"
});
formatter.result({
  "duration": 79103141,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "MISSION_VISION",
      "offset": 25
    }
  ],
  "location": "DashboardTest.i_verifyOptionsUnderTab(String)"
});
formatter.result({
  "duration": 74856309,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Administrative_OFFICE",
      "offset": 25
    }
  ],
  "location": "DashboardTest.i_verifyOptionsUnderTab(String)"
});
formatter.result({
  "duration": 67668931,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "OFFICE_PRESIDENT",
      "offset": 25
    }
  ],
  "location": "DashboardTest.i_verifyOptionsUnderTab(String)"
});
formatter.result({
  "duration": 66958404,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ALUMNI",
      "offset": 25
    }
  ],
  "location": "DashboardTest.i_verifyOptionsUnderTab(String)"
});
formatter.result({
  "duration": 54531416,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "UNO_HISTORY",
      "offset": 25
    }
  ],
  "location": "DashboardTest.i_verifyOptionsUnderTab(String)"
});
formatter.result({
  "duration": 59038106,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "verify Regarding Prospective Student Tab Navigation Options Under AboutTab",
  "description": "",
  "id": "verifying-options-in-dashboard;verify-regarding-prospective-student-tab-navigation-options-under-abouttab",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "I go to UNO on \"Mozilla\"",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "I click on \"PROSPECTIVE_STUDENTS\"",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I verifyThePageUrlIs \"http://uno.edu/prospectivestudents/index.aspx\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Mozilla",
      "offset": 16
    }
  ],
  "location": "DashboardTest.gotoFacebook(String)"
});
formatter.result({
  "duration": 15313006886,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "PROSPECTIVE_STUDENTS",
      "offset": 12
    }
  ],
  "location": "DashboardTest.click(String)"
});
formatter.result({
  "duration": 7010844514,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "http://uno.edu/prospectivestudents/index.aspx",
      "offset": 22
    }
  ],
  "location": "DashboardTest.i_verifyThePageUrlIs(String)"
});
formatter.result({
  "duration": 17165077,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "verify Footer Links",
  "description": "",
  "id": "verifying-options-in-dashboard;verify-footer-links",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "I go to UNO on \"Mozilla\"",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "I verifyFooterLink \"NON_DISC_FTR_LNK\"",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "I verifyFooterLink \"EMERGENCY_FTR_LNK\"",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "I verifyFooterLink \"CONTACT_FTR_LNK\"",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "I verifyFooterLink \"SACSOC_FTR_LNK\"",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "I verifyFooterLink \"COPYRIGHT_FTR_LNK\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Mozilla",
      "offset": 16
    }
  ],
  "location": "DashboardTest.gotoFacebook(String)"
});
formatter.result({
  "duration": 13815504227,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "NON_DISC_FTR_LNK",
      "offset": 20
    }
  ],
  "location": "DashboardTest.i_verifyFooterLink(String)"
});
formatter.result({
  "duration": 1254839793,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "EMERGENCY_FTR_LNK",
      "offset": 20
    }
  ],
  "location": "DashboardTest.i_verifyFooterLink(String)"
});
formatter.result({
  "duration": 57820927,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "CONTACT_FTR_LNK",
      "offset": 20
    }
  ],
  "location": "DashboardTest.i_verifyFooterLink(String)"
});
formatter.result({
  "duration": 54697968,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SACSOC_FTR_LNK",
      "offset": 20
    }
  ],
  "location": "DashboardTest.i_verifyFooterLink(String)"
});
formatter.result({
  "duration": 61937130,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "COPYRIGHT_FTR_LNK",
      "offset": 20
    }
  ],
  "location": "DashboardTest.i_verifyFooterLink(String)"
});
formatter.result({
  "duration": 56472652,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "verify Facebook From Dashboard",
  "description": "",
  "id": "verifying-options-in-dashboard;verify-facebook-from-dashboard",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 28,
  "name": "I go to UNO on \"Mozilla\"",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "I click on \"FACEBOOK\"",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "I verifyThePageUrlIs \"https://www.facebook.com/UniversityOfNewOrleans\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Mozilla",
      "offset": 16
    }
  ],
  "location": "DashboardTest.gotoFacebook(String)"
});
formatter.result({
  "duration": 15818570269,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "FACEBOOK",
      "offset": 12
    }
  ],
  "location": "DashboardTest.click(String)"
});
formatter.result({
  "duration": 4538019016,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.facebook.com/UniversityOfNewOrleans",
      "offset": 22
    }
  ],
  "location": "DashboardTest.i_verifyThePageUrlIs(String)"
});
formatter.result({
  "duration": 8215131935,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "verifying Giving Link",
  "description": "",
  "id": "verifying-options-in-dashboard;verifying-giving-link",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 33,
  "name": "I go to UNO on \"Mozilla\"",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "I click on \"GIVING\"",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "SwitchToChildWindow \"1\"",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "hoveron \"Gift_BUSINESS_ADMIN\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Mozilla",
      "offset": 16
    }
  ],
  "location": "DashboardTest.gotoFacebook(String)"
});
formatter.result({
  "duration": 23472593632,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "GIVING",
      "offset": 12
    }
  ],
  "location": "DashboardTest.click(String)"
});
formatter.result({
  "duration": 4430244742,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 21
    }
  ],
  "location": "DashboardTest.switchtochildwindow(String)"
});
formatter.result({
  "duration": 282564334,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Gift_BUSINESS_ADMIN",
      "offset": 9
    }
  ],
  "location": "DashboardTest.hoveron(String)"
});
formatter.result({
  "duration": 7773151138,
  "status": "passed"
});
});