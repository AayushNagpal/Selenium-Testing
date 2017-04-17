package com.pack.Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pack.base.GrabPropertyValue;
import com.pack.base.TestBaseSetup;
import com.pack.locators.CreateaAccount;
import com.pack.locators.Dashboard;
import com.pack.pageObjects.CreateAccountPage;
import com.pack.pageObjects.DashboardPage;
import com.pack.pageObjects.LoginPage;
import com.selenium.Sync;


public class CreateAccountTest extends TestBaseSetup implements Dashboard,CreateaAccount {
	private WebDriver driver;
	DashboardPage DashboardMethods;
	CreateAccountPage CreateMethod;
	GrabPropertyValue data;
	
	static Logger log = Logger.getLogger("CreateAccountTest");
		
	@BeforeMethod
	public void creationObjects() throws Exception
	{
		DashboardMethods     = new DashboardPage(getDriver());
		CreateMethod		 = new CreateAccountPage(getDriver());
		data 				 = new GrabPropertyValue();
		getDriver().manage().deleteAllCookies();
		getDriver().get(data.getValueOf("url"));
        (new Sync(getDriver())).waitForPageToLoad();
	}
	
	@Test
	public void verifyCreateAccountFunctionality() throws Exception
	{
		log.info("Verifying create account functionality");
		DashboardMethods.clickOn(APPLY_NOW);
		DashboardMethods.clickOn(APPLY_NOW_BTN);
		CreateMethod.clickOn(CREATE_ACCOUNT);
		
		CreateMethod.enterValueInTextBox(LAST_NAME, data.getValueOf("LAST_NAME"));
		CreateMethod.enterValueInTextBox(FIRST_NAME, data.getValueOf("FIRST_NAME"));
		CreateMethod.enterValueInTextBox(MIDDLE_NAME, data.getValueOf("MIDDLE_NAME"));
		CreateMethod.selectOptionInDropDown(DOB_MONTH, data.getValueOf("DOB_MONTH"));
		CreateMethod.selectOptionInDropDown(DOB_DAY, data.getValueOf("DOB_DAY"));
		CreateMethod.selectOptionInDropDown(DOB_YEAR, data.getValueOf("DOB_YEAR"));
		Thread.sleep(10);
		CreateMethod.clickOn(NO_RD_BTN);
		CreateMethod.selectOptionInDropDown(COUNTRY_DD, data.getValueOf("COUNTRY_DD"));
		CreateMethod.enterValueInTextBox(ADDRESS_LINE_1, data.getValueOf("ADDRESS_LINE_1"));
		CreateMethod.enterValueInTextBox(ADDRESS_LINE_2, data.getValueOf("ADDRESS_LINE_2"));
		CreateMethod.enterValueInTextBox(CURRENT_CITY, data.getValueOf("CURRENT_CITY"));
		CreateMethod.enterValueInTextBox(EMAIL_ADD,data.getValueOf("EMAIL_ADD"));		
		CreateMethod.enterValueInTextBox(VERIFY_EMAIL_ADD, data.getValueOf("VERIFY_EMAIL_ADD"));	
		CreateMethod.enterValueInTextBox(CRT_USERNAME, data.getValueOf("CRT_USERNAME"));
		CreateMethod.enterValueInTextBox(CRT_PASSWORD, data.getValueOf("CRT_PASSWORD"));
		CreateMethod.enterValueInTextBox(CRT_VRYPASSWORD, data.getValueOf("CRT_VRYPASSWORD"));
		CreateMethod.clickOn(SUBIT_INFORMATION);
		CreateMethod.verifyAccountCreationLink(SUCCESS_LINK);
		
	}
}