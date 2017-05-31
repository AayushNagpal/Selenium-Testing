package com.pack.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pack.base.GrabPropertyValue;
import com.pack.locators.AcademicCalendar;
import com.pack.locators.Dashboard;
import com.selenium.WebConnector;

public class DashBoard_AcademicCalendarPage extends WebConnector implements Dashboard,AcademicCalendar
{
	private WebDriver driver;
	GrabPropertyValue data;
	
	//Constructor to define/call methods	 
	public DashBoard_AcademicCalendarPage(WebDriver driver) throws Exception
	{		
		super(driver);
		this.driver = driver;
		data = new GrabPropertyValue();
		} 	

	public void clickOn(By locator)
	{
		ClickOn(locator,SHORTWAIT);
	}
	
	
	public void verifyOptionsInNavigator(By locator) throws Exception
	{
		boolean option =  isElementPresent(locator, MEDIUMWAIT);
		Assert.assertTrue(option, "Option is not present in Navigator");
	}
	
}
