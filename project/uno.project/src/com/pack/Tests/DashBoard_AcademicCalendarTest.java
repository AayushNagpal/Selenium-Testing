package com.pack.Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pack.base.GrabPropertyValue;
import com.pack.base.TestBaseSetup;
import com.pack.locators.AcademicCalendar;
import com.pack.locators.Dashboard;
import com.pack.pageObjects.DashBoard_AcademicCalendarPage;
import com.pack.pageObjects.DashboardPage;
import com.selenium.Sync;

public class DashBoard_AcademicCalendarTest extends TestBaseSetup implements Dashboard,AcademicCalendar {
	private WebDriver driver;
	DashboardPage DashboardMethods;
	DashBoard_AcademicCalendarPage AcademicCalendarMethods; 
	GrabPropertyValue data;
	
	static Logger log = Logger.getLogger("DashBoard_AcademicCalendarTest");
		
	@BeforeMethod
	public void creationObjects() throws Exception
	{
		DashboardMethods     	 = new DashboardPage(getDriver());
		AcademicCalendarMethods	 = new DashBoard_AcademicCalendarPage(getDriver());
		getDriver().manage().deleteAllCookies();
		getDriver().get(data.getValueOf("url"));
        (new Sync(getDriver())).waitForPageToLoad();
	}
	
	@Test
	public void verificationOfNavigationTabInAcademicCalendar() throws Exception
	{
		log.info("verification Of  Navigation Tab In AcademicCalendar");
		DashboardMethods.clickOn(ACADEMIC_CALENDER);
		AcademicCalendarMethods.verifyOptionsInNavigator(REHISTRAR);
		AcademicCalendarMethods.verifyOptionsInNavigator(ACADEMIC_CALENDER_NAV);
		AcademicCalendarMethods.verifyOptionsInNavigator(ACADEMIC_SCHEDULING);
		AcademicCalendarMethods.verifyOptionsInNavigator(APP_FOR_DEGREE);
		AcademicCalendarMethods.verifyOptionsInNavigator(APPEAL_FORM);
		AcademicCalendarMethods.verifyOptionsInNavigator(COMMENCEMENT);
		AcademicCalendarMethods.verifyOptionsInNavigator(COURSE_BULLETIN);
		AcademicCalendarMethods.verifyOptionsInNavigator(COURSE_DESCRIPTION);
		AcademicCalendarMethods.verifyOptionsInNavigator(DEGREE_AUDIT);
		AcademicCalendarMethods.verifyOptionsInNavigator(ENROL_VERIFICATION);
		AcademicCalendarMethods.verifyOptionsInNavigator(FAM_EDU_RIGHTS);
		AcademicCalendarMethods.verifyOptionsInNavigator(FINAL_EXAM_SCHEDULE);
		AcademicCalendarMethods.verifyOptionsInNavigator(FORMS);
		AcademicCalendarMethods.verifyOptionsInNavigator(GRADE_CHANGE_FORM);
		AcademicCalendarMethods.verifyOptionsInNavigator(ROOM_RESERVATION);
		AcademicCalendarMethods.verifyOptionsInNavigator(TRANSCRIPT_REQUEST);
		AcademicCalendarMethods.verifyOptionsInNavigator(TUTION_REFUND_POLICY);
		AcademicCalendarMethods.verifyOptionsInNavigator(UNIVERSITY_CTALOG);
		AcademicCalendarMethods.verifyOptionsInNavigator(VETERANS_AFFAIRS);
		AcademicCalendarMethods.verifyOptionsInNavigator(CONTACT_US);

	}
	
	@Test
	public void verifyClickOnDownloadPdf()
	{
		log.info("verification Of  Download of pdf under AcademicCalendar");
		DashboardMethods.clickOn(ACADEMIC_CALENDER);
		AcademicCalendarMethods.clickOn(PDF_LINK);		
	}
	
}
