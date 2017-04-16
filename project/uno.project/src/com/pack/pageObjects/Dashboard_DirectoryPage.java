package com.pack.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pack.base.GrabPropertyValue;
import com.pack.locators.Dashboard;
import com.pack.locators.Directory;
import com.pack.locators.Library;
import com.selenium.WebConnector;

public class Dashboard_DirectoryPage extends WebConnector implements Dashboard,Directory
{
	private WebDriver driver;
	GrabPropertyValue data;
	
	
	//Constructor to define/call methods	 
	public Dashboard_DirectoryPage(WebDriver driver) throws Exception
	{		
		super(driver);
		this.driver = driver;
		data = new GrabPropertyValue();
		} 	

	public void clickOn(By locator)
	{
		ClickOn(locator,SHORTWAIT);
	}
		public void verifySearchResultText(String expected) throws Exception
	{
		String ObtainedResult = safeGetText(SEARCH_PERSONNEL_RESULT,MEDIUMWAIT);
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
