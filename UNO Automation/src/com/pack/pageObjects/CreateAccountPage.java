package com.pack.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pack.base.GrabPropertyValue;
import com.pack.locators.Dashboard;
import com.selenium.WebConnector;

//Methods belonging to create account page
public class CreateAccountPage extends WebConnector implements Dashboard
{
	private WebDriver driver;
	GrabPropertyValue data;
	
	//Constructor to define/call methods	 
	public CreateAccountPage(WebDriver driver) throws Exception
	{		
		super(driver);
		this.driver = driver;
		data = new GrabPropertyValue();
	} 	

	public void enterValueInTextBox(By locator,String value)
	{
		safeClearAndType(locator,value);
	}
	
	public void clickOn(By locator)
	{
		ClickOn(locator,SHORTWAIT);
	}
	
	public void selectOptionInDropDown(By locator, String Option)
	{
		safeSelectOptionInDropDown(locator, Option);
		
	}
	
	public void verifyAccountCreationLink(By locator) throws Exception
	{
		boolean option =  isElementPresent(locator, MEDIUMWAIT);
		Assert.assertTrue(option, "Account creation is not successfull");
	}
	
	

}
