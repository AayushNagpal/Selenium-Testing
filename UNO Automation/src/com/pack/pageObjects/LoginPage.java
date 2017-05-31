package com.pack.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pack.base.GrabPropertyValue;
import com.pack.locators.Dashboard;
import com.selenium.WebConnector;

public class LoginPage extends WebConnector implements Dashboard
{
	private WebDriver driver;
	GrabPropertyValue data;
	
	//Constructor to define/call methods	 
	public LoginPage(WebDriver driver) throws Exception
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

}
