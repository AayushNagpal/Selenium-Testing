package com.pack.pageObjects;

import static org.testng.Assert.assertTrue;



import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.pack.base.GrabPropertyValue;
import com.pack.locators.Dashboard;
import com.selenium.WebConnector;
	
	public class DashboardPage extends WebConnector implements Dashboard
	{
		private WebDriver driver;
		GrabPropertyValue data;
		
		//Constructor to define/call methods	 
		public DashboardPage(WebDriver driver) throws Exception
		{		
			super(driver);
			this.driver = driver;
			data = new GrabPropertyValue();
			} 	
	
		public void clickOn(By locator)
		{
			ClickOn(locator,SHORTWAIT);
		}
		
		
		public void verifyOptionsUnderTab(By locator) throws Exception
		{
			boolean option =  isElementPresent(locator, MEDIUMWAIT);
			Assert.assertTrue(option, "option is not present under tab");
		}
		
		public void verifyThePageUrlIs(String expectedURL)
		{
			String ActualURL = getCurrentURL();
			Assert.assertEquals(expectedURL, ActualURL, "Expected url is not obtained");
		}
		
		public void verifyThePageUrlContains(String expectedURL)
		{
			String ActualURL = getCurrentURL();
			assertTrue(getCurrentURL().contains(expectedURL));
		}
		
		public void enterTestInLocator(By locator,String value)
		{
			try {
				waitForPageToLoad("UNIVERSITY");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			safeClearAndType(locator,value);
		}
		
		public void verifyFooterLinks(By locator) throws Exception
		{
			boolean option =  isElementPresent(locator, MEDIUMWAIT);
			Assert.assertTrue(option, "Footer link is not being displayed ");
		}
		
		public void HoverOnBusiness_Administration(By locator)
		{
			mouseHover(locator,SHORTWAIT);
		}
		
		public void switchTochild(int i)
		{
		switchToWindow(i);
		}
	}
