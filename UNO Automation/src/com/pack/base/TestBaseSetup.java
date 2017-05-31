package com.pack.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class TestBaseSetup  {

	public WebDriver driver;
	static String driverPath = "D://chromedrive//"; //need to set path when chrome driver is used
	static Logger log = Logger.getLogger(TestBaseSetup.class);

	
	public WebDriver getDriver() {
		log.info("Get the Driver");
		return driver;
	}
	
	private void setDriver(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//retrieves browser and url value
	private void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			log.info("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		log.info("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath
				+ "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		log.info("Launching Firefox browser..");
		
		FirefoxProfile fpi = new FirefoxProfile();
	    fpi.setPreference("browser.startup.homepage_override.mstone", "ignore");
	    fpi.setPreference("startup.homepage_welcome_url.additional", "about:blank");
	    
		WebDriver driver = new FirefoxDriver(fpi);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	//Before all Methods cases this method will be executed
	@BeforeClass
	public void initializeTestBaseSetup() {
		log.info("Grabing the browser type and url ");
		try {
			GrabPropertyValue data = new GrabPropertyValue();
				String browserType = data.getValueOf("browser");
				String appURL = data.getValueOf("url");
				setDriver(browserType,appURL);
				log.info("Browser type is   "+browserType);
				log.info("URL is  "+ appURL);
		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
			log.fatal("Error....." + e.getStackTrace());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}