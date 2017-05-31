package com.pack.locators;

import org.openqa.selenium.By;

public interface Dashboard
{
	public static By ABOUT 					= By.xpath("//span[text() = 'About']");
	public static By ABOUT_UNO 				= By.xpath("//li[@class='megaLinksFirst']/a[@title='About UNO']");
	public static By UNO_AT_GLANCE			= By.xpath("//a[text() = 'UNO at a Glance']");
	public static By MISSION_VISION 		= By.xpath("//a[text() = 'Mission & Vision']");
	public static By Administrative_OFFICE	= By.xpath("//a[text() = 'Administrative Offices']");
	public static By OFFICE_PRESIDENT		= By.xpath("//a[text() = 'Office of the President']");
	public static By ALUMNI					= By.xpath("//a[text() = 'Alumni']");
	public static By UNO_HISTORY			= By.xpath("//a[text() = 'UNO History']");
	
	public static By PROSPECTIVE_STUDENTS	= By.xpath("//a[@title='Prospective Students']");
	//public static By SEARCH_TEXT_BOX		= By.xpath("//form[@id='search']");
	public static By SEARCH_TEXT_BOX		= By.xpath("//input[@id='search']");
	public static By SEARCH_BUTTON			= By.xpath("//input[@class='searchBtn']");
	public static By LOGO					= By.xpath("//img[@class='logoFooter']");
	
	public static By APPLY_NOW				= By.xpath("//ul[@class='utilityNav']/li[6]/a[text() = 'Apply Now']");
	public static By APPLY_NOW_BTN			= By.xpath("//div[@class='apply-button']");
	
		
	public static By NON_DISC_FTR_LNK		= By.xpath("//a[text()='Non-Discrimination Statement']");
	public static By EMERGENCY_FTR_LNK		= By.xpath("//a[text()='Emergency Preparedness']");
	public static By CONTACT_FTR_LNK		= By.xpath("//a[text()='Contact UNO']");
	public static By UL_FTR_LINK			= By.xpath("//a[text()='A Member of the UL Systema']");
	public static By SACSOC_FTR_LNK			= By.xpath("//a[text()='SACSCOC Accreditation']");
	public static By COPYRIGHT_FTR_LNK		= By.xpath("//a[text()='Copyright 2017']");
			
	public static By ACADEMIC_CALENDER		 = By.xpath("//li[@class='first']/a[text() ='Academic Calendar']");
	
	public static By LIBRARY				 = By.xpath("//div[@id='footer']//div[@class='footerUtilityList']//a[@href='http://library.uno.edu']");
	public static By DIRECTORY               = By.xpath("//div[@id='footer']//div[@class='footerUtilityList']//a[text()='Directory']");
	
	public static By FACEBOOK				 = By.xpath("//a[text()='Facebook']");
	
	public static By GIVING			     = By.xpath("//div[@id='footer']//div[@class='footerContainer']//a[@href='http://www.unoalumni.com/donate']");
	public static By Gift_BUSINESS_ADMIN	 = By.xpath("//h2[text()[contains(.,'Business Administration')]]");

}
