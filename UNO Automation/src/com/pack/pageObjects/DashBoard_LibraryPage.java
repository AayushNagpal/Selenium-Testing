package com.pack.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pack.base.GrabPropertyValue;
import com.pack.locators.Dashboard;
import com.pack.locators.Library;
import com.selenium.WebConnector;

public class DashBoard_LibraryPage extends WebConnector implements Dashboard,Library
{
	private WebDriver driver;
	GrabPropertyValue data;
	
	
	//Constructor to define/call methods	 
	public DashBoard_LibraryPage(WebDriver driver) throws Exception
	{		
		super(driver);
		this.driver = driver;
		data = new GrabPropertyValue();
		} 	

	public void clickOn(By locator)
	{
		ClickOn(locator,SHORTWAIT);
	}
	
	public void hoverOn(By locator)
	{
		mouseHover(locator,SHORTWAIT);
	}
	
	public void verifyThePageUrlIs(String expectedURL)
	{
		String ActualURL = getCurrentURL();
		Assert.assertEquals(expectedURL, ActualURL, "Expected url is not obtained");
	}

	
	
	
	public void verifyOptionsUnderTab(By locator) throws Exception
	{
		boolean option =  isElementPresent(locator, MEDIUMWAIT);
		Assert.assertTrue(option, "option is not present under tab");
	}
	
	public void verifySearchResultText(String expected) throws Exception
	{
		String ObtainedResult = safeGetText(CATALOG_SEARCH_RESULT,MEDIUMWAIT);
		assertTrue(ObtainedResult.contains(expected));
	}
	
		
	public void enterTextInLocator(By locator,String value)
	{
		try {
			waitForPageToLoad("UNIVERSITY");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		safeClearAndType(locator,value);
	}
	
	
}
