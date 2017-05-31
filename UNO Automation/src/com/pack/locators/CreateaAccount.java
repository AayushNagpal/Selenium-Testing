package com.pack.locators;

import org.openqa.selenium.By;

public interface CreateaAccount {
	
	public static By CREATE_ACCOUNT			= By.xpath("//a[@id='CreateAccountLink']");
	public static By LAST_NAME				= By.xpath("//input[@id='lastname']");
	public static By FIRST_NAME				= By.xpath("//input[@id='firstname']");
	public static By MIDDLE_NAME			= By.xpath("//input[@id='middlename']");
	public static By DOB_MONTH				= By.xpath("//select[@id='dobMonthDrop']");
	public static By DOB_DAY				= By.xpath("//select[@id='dobDayDrop']");
	public static By DOB_YEAR				= By.xpath("//select[@id='dobYearDrop']");
	public static By YES_RD_BTN				= By.xpath("//input[@value='Y']");
	public static By NO_RD_BTN				= By.xpath("//input[@value='Y']");
	public static By COUNTRY_DD				= By.xpath("//select[@id='country']");
	public static By ADDRESS_LINE_1			= By.xpath("//input[@id='address1']");
	public static By ADDRESS_LINE_2			= By.xpath("//input[@id='address2']");
	public static By CURRENT_CITY			= By.xpath("//input[@id='city']");
	public static By EMAIL_ADD				= By.xpath("//input[@id='email']");
	public static By VERIFY_EMAIL_ADD		= By.xpath("//input[@id='verifyemail']");
	public static By CRT_USERNAME			= By.xpath("//input[@id='login']");
	public static By CRT_PASSWORD			= By.xpath("//input[@id='newpassword']");
	public static By CRT_VRYPASSWORD		= By.xpath("//input[@id='verifypassword']");
	public static By SUBIT_INFORMATION		= By.xpath("//input[@id='btnSetIPData']");	
	public static By SUCCESS_LINK			= By.xpath("//a[text() = 'please access your application']");


}
