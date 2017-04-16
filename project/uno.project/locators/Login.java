package com.pack.locators;

import org.openqa.selenium.By;

public interface Login {
	
	public static By USER_LOGIN				= By.xpath("//a[@id='UserLoginLink']");
	public static By LOGIN_TXT				= By.xpath("//input[@id='ay-login']");
	public static By USERNAME_TXT			= By.xpath("//input[@id='ay-password']");
	public static By LOGIN_BTN				= By.xpath("//input[@id='ay-loginSubmit']");
	

}
