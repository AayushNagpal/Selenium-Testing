package com.pack.Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pack.base.GrabPropertyValue;
import com.pack.base.TestBaseSetup;
import com.pack.locators.Dashboard;
import com.pack.pageObjects.DashboardPage;
import com.selenium.Sync;

public class DashBoardTests extends TestBaseSetup implements Dashboard {
	private WebDriver driver;
	DashboardPage DashboardMethods;
	GrabPropertyValue data;
	
	static Logger log = Logger.getLogger("DashBoardTests");
		
	@BeforeMethod
	public void creationObjects() throws Exception
	{
		DashboardMethods     =new DashboardPage(getDriver());
		data 				 = new GrabPropertyValue();
		
		getDriver().manage().deleteAllCookies();
		getDriver().get(data.getValueOf("url"));
        (new Sync(getDriver())).waitForPageToLoad();
        DashboardMethods.verifyOptionsUnderTab(LOGO);
        DashboardMethods.clickOn(LOGO);
	}
	
	@Test
	public void verifyOptionsUnderAboutTab() throws Exception

	{
		log.info("Checking All the options under About tab");
		DashboardMethods.clickOn(ABOUT);
		DashboardMethods.verifyOptionsUnderTab(ABOUT_UNO);
		DashboardMethods.verifyOptionsUnderTab(UNO_AT_GLANCE);
		DashboardMethods.verifyOptionsUnderTab(MISSION_VISION);
		DashboardMethods.verifyOptionsUnderTab(Administrative_OFFICE);
		DashboardMethods.verifyOptionsUnderTab(OFFICE_PRESIDENT);
		DashboardMethods.verifyOptionsUnderTab(ALUMNI);
		DashboardMethods.verifyOptionsUnderTab(UNO_HISTORY);		
	}
	
	@Test
	public void verifyRegardingProspectiveStudentTabNavigation()
	{
		log.info("Verifying the navigation of ProspectiveStudent sub tab ");
		DashboardMethods.clickOn(PROSPECTIVE_STUDENTS);
		DashboardMethods.verifyThePageUrlIs(data.getValueOf("PROSPECTIVE_STU_URL"));		
	}
	
	@Test
	public void verifySearchTextBoxNavigation()
	{
		log.info("Verifying the navigation of Search text box to google page");
		DashboardMethods.clickOn(SEARCH_TEXT_BOX);
		DashboardMethods.enterTestInLocator(SEARCH_TEXT_BOX,data.getValueOf("SEARCH_TEXT"));
		DashboardMethods.clickOn(SEARCH_BUTTON);
		DashboardMethods.verifyThePageUrlContains(data.getValueOf("SEARCH_URL"));		
	}
	
	@Test
	public void verifyFooterLinks() throws Exception
	{
		log.info("Verifying of footer links");
		DashboardMethods.verifyFooterLinks(NON_DISC_FTR_LNK);
		DashboardMethods.verifyFooterLinks(EMERGENCY_FTR_LNK);
		DashboardMethods.verifyFooterLinks(CONTACT_FTR_LNK);
		DashboardMethods.verifyFooterLinks(UL_FTR_LINK);
		DashboardMethods.verifyFooterLinks(SACSOC_FTR_LNK);
		DashboardMethods.verifyFooterLinks(COPYRIGHT_FTR_LNK);
	}
	
	@Test
	public void verifyFacebookFromDashboard(By locator)
	{
		log.info("Verifying the facebook link");
		DashboardMethods.clickOn(LIBRARY);
		DashboardMethods.clickOn(FACEBOOK);
		DashboardMethods.verifyThePageUrlIs("https://www.facebook.com/UniversityOfNewOrleans/");
		
	}
	
	@Test
	public void verifyingGivingLink()
	{
		log.info("Verifying the Giving link");
		DashboardMethods.clickOn(GIVING);
		DashboardMethods.switchTochild(1);
		DashboardMethods.HoverOnBusiness_Administration(Gift_BUSINESS_ADMIN);
	}
	
	


}
