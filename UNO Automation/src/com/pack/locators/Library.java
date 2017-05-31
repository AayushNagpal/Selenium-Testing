package com.pack.locators;

import org.openqa.selenium.By;

public interface Library {
	
	public static By FIND					 = By.xpath("//img[@name='mbi_mbl6h0_1'][@alt='Find']");
	public static By FIND_BOOKS        	     = By.xpath("//a[text()='Find Books']");
	public static By FIND_DATABASES    		 = By.xpath("//a[text()='Find Databases']");
	public static By FIND_E_JOURNALS		 = By.xpath("//a[text()='Find E-journals']");
	public static By FIND_LIBRARIES			 = By.xpath("//a[text()='Find Other Libraries']");
	public static By FIND_MATERIALS			 = By.xpath("//a[text()='Find Materials on Reserve']");
	public static By MORE					 = By.xpath("//a[text()='More...']");	
	
	public static By DATABASE_LINK			 = By.xpath("//a[text()= 'Click here for on-campus database access']");
	public static By CATALOG				 = By.xpath("//html[@webdriver='true']//div[@id='tabbed_box_1']//a[@title='Catalog']");
	
	public static By CATALOG_SEARCH_TXT		 = By.xpath("//input[@id='searchform']");
	public static By CATALOG_SEARCH_BTN		 = By.xpath("//input[@class='searchbutton']");
	public static By CATALOG_SEARCH_RESULT	 = By.xpath("//div[@class='searchsummary']/strong");
	
	public static By CATALOG_ADV_SRCH_BTN	 = By.xpath("//a[@title='Advanced Search']");
	
	
	public static By POWER_KEYWORD			 = By.xpath("//select[@id='srchfield1']");
	public static By POWER_SEARCHDATA1		 = By.xpath("//input[@id='searchdata1']");
	public static By POWER_SEARCH			 = By.xpath("//input[@type='submit']");
	
	public static By FACEBOOK_ICON			 = By.xpath("//img[@alt='facebook']");
	public static By TWITTER_ICON			 = By.xpath("//img[@alt='twitter']");
	public static By FLICKER_ICON			 = By.xpath("//img[@alt='flikr']");

	

}
