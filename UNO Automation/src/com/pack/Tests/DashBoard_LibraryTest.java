package com.pack.Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pack.base.GrabPropertyValue;
import com.pack.base.TestBaseSetup;
import com.pack.locators.Dashboard;
import com.pack.locators.Library;
import com.pack.pageObjects.DashBoard_LibraryPage;
import com.pack.pageObjects.DashboardPage;
import com.selenium.Sync;

public class DashBoard_LibraryTest extends TestBaseSetup implements Dashboard ,Library{
	private WebDriver driver;
	DashboardPage DashboardMethods;
	DashBoard_LibraryPage LibraryPageMethods; 
	GrabPropertyValue data;
	
	static Logger log = Logger.getLogger("DashBoardTests");
		
	@BeforeMethod
	public void creationObjects() throws Exception
	{
		DashboardMethods     = new DashboardPage(getDriver());
		data 				 = new GrabPropertyValue();
		LibraryPageMethods	 = new DashBoard_LibraryPage(getDriver());
		
		getDriver().manage().deleteAllCookies();
		getDriver().get(data.getValueOf("url"));
        (new Sync(getDriver())).waitForPageToLoad();
	}
	
	//@Test
	public void verificationsOfOptionsUnderLibraryFind() throws Exception
	{
		log.info("verifications Of  Options Under Library -- Find Tab");
		
				DashboardMethods.clickOn(LIBRARY);
				LibraryPageMethods.hoverOn(FIND);				
				DashboardMethods.verifyOptionsUnderTab(FIND_BOOKS);
				DashboardMethods.verifyOptionsUnderTab(FIND_DATABASES);
				DashboardMethods.verifyOptionsUnderTab(FIND_E_JOURNALS);
				DashboardMethods.verifyOptionsUnderTab(FIND_LIBRARIES);
				DashboardMethods.verifyOptionsUnderTab(FIND_MATERIALS);
				DashboardMethods.verifyOptionsUnderTab(MORE);
	}
	
//	@Test
//	public void verificationsCatalogSearch() throws Exception
//	{
//		log.info("verifications Of  Options Under Library -- Find Tab");
//		
//				DashboardMethods.clickOn(LIBRARY);
//				LibraryPageMethods.clickOn(CATALOG);
//				LibraryPageMethods.enterTextInLocator(CATALOG_SEARCH_TXT, "Computer Science");
//				LibraryPageMethods.clickOn(CATALOG_SEARCH_BTN);
//				LibraryPageMethods.verifySearchResultText("Computer Science");
//	}
	
	@Test
	public void verificationOfFacebookLibrarySite()
	{
		log.info("verification of facebook library link");
		DashboardMethods.clickOn(LIBRARY);
		LibraryPageMethods.clickOn(FACEBOOK_ICON);
		LibraryPageMethods.verifyThePageUrlIs("https://www.facebook.com/ekl.library/");
		
	}
	
	@Test
	public void verificationOfTwitterLibrarySite()
	{
		log.info("verification of twitter library link");
		DashboardMethods.clickOn(LIBRARY);
		LibraryPageMethods.clickOn(TWITTER_ICON);
		LibraryPageMethods.verifyThePageUrlIs("https://twitter.com/ekl_library");	
	}
	
	@Test
	public void verificationOfFlickrLibrarySite()
	{
		log.info("verification of Flickr library link");
		DashboardMethods.clickOn(LIBRARY);
		LibraryPageMethods.clickOn(FLICKER_ICON);
		LibraryPageMethods.verifyThePageUrlIs("https://www.flickr.com/photos/33249530@N07/");
	}
	
	
}
