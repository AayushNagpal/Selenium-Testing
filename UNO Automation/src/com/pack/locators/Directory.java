package com.pack.locators;

import org.openqa.selenium.By;

public interface Directory {
	
	public static By SEARCH_DIRECTORY_TXT	= By.xpath("//input[@id='frmKeyword']");
	public static By SEARCH_PERSONNEL_BTN	= By.xpath("//button[@id='btnSearchPerson']");
	public static By SEARCH_PERSONNEL_RESULT= By.xpath("//table[@id='tblPerson']//tr[2]/td[1]");

}
