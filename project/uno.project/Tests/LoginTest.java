package com.pack.Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pack.base.GrabPropertyValue;
import com.pack.base.TestBaseSetup;
import com.pack.locators.Dashboard;
import com.pack.locators.Login;
import com.pack.pageObjects.DashboardPage;
import com.pack.pageObjects.LoginPage;
import com.selenium.Sync;

public class LoginTest extends TestBaseSetup implements Dashboard,Login {
	private WebDriver driver;
	DashboardPage DashboardMethods;
	LoginPage LoginMethods;
	GrabPropertyValue data;
	
	static Logger log = Logger.getLogger("DashBoardTests");
		
	@BeforeMethod
	public void creationObjects() throws Exception
	{
		DashboardMethods     =new DashboardPage(getDriver());
		LoginMethods		 =new LoginPage(getDriver());
		data 				 = new GrabPropertyValue();
		
		getDriver().manage().deleteAllCookies();
		getDriver().get(data.getValueOf("url"));
        (new Sync(getDriver())).waitForPageToLoad();
	}
	
	@Test
	public void verifyLoginFunctionality() throws Exception
	{
		log.info("Checking login functionality");
		DashboardMethods.clickOn(APPLY_NOW);
		DashboardMethods.clickOn(APPLY_NOW_BTN);
		LoginMethods.clickOn(USER_LOGIN);
		LoginMethods.enterValueInTextBox(LOGIN_TXT, data.getValueOf("username"));
		LoginMethods.enterValueInTextBox(USERNAME_TXT, data.getValueOf("password"));
		LoginMethods.clickOn(LOGIN_BTN);
		Thread.sleep(10);
		
	}
	
	
}