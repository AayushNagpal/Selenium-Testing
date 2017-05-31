package com.pack.Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pack.base.GrabPropertyValue;
import com.pack.base.TestBaseSetup;
import com.pack.locators.Dashboard;
import com.pack.locators.Directory;
import com.pack.locators.Library;
import com.pack.pageObjects.DashBoard_LibraryPage;
import com.pack.pageObjects.DashboardPage;
import com.pack.pageObjects.Dashboard_DirectoryPage;
import com.selenium.Sync;

public class Dashboard_DirectoryTest extends TestBaseSetup implements Dashboard ,Directory{
	private WebDriver driver;
	DashboardPage DashboardMethods;
	DashBoard_LibraryPage LibraryPageMethods; 
	GrabPropertyValue data;
	Dashboard_DirectoryPage DirectoryMethod;
	
	static Logger log = Logger.getLogger("DashBoardTests");
		
	@BeforeMethod
	public void creationObjects() throws Exception
	{
		DashboardMethods     = new DashboardPage(getDriver());
		data 				 = new GrabPropertyValue();
		DirectoryMethod      = new Dashboard_DirectoryPage(getDriver());
		getDriver().manage().deleteAllCookies();
		getDriver().get(data.getValueOf("url"));
        (new Sync(getDriver())).waitForPageToLoad();
	}
	
	@Test
	public void verificationsOfPersonUnderDirectory() throws Exception
	{
		log.info("verifications Of Person Under Directory");
		DashboardMethods.clickOn(DIRECTORY);
		DirectoryMethod.enterTextInLocator(SEARCH_DIRECTORY_TXT, data.getValueOf("DIRECTORY_NAME"));
		DirectoryMethod.clickOn(SEARCH_PERSONNEL_BTN);
		DirectoryMethod.verifySearchResultText(data.getValueOf("DIRECTORY_NAME"));
	}

}