package com.base;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebConnector {
	//Initializing Properties file
	WebDriver driver = null;
	Properties OR=null;

	// default constructor
	public WebConnector(){
		// initialize properties
		System.out.println("***************Initializing Properties file*******************");
		try{
			OR = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\OR.properties");
			OR.load(fs);
		}catch(Exception e){
			System.out.println("Error in initializing Properties file");
		}
		
	}
	
	public void openBrowser(String bType){
		if(bType.equals("Mozilla"))
			driver = new FirefoxDriver();
		else if(bType.equals("Chrome")){
		 System.setProperty("user.dir", System.getProperty("user.dir")+"//chromedriver//chromedriver.exe");
		    driver = new ChromeDriver();   
		}else if(bType.equals("IE")){
			// set path to exe
			driver= new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
	}
	
	public void navigate(String URL){
		driver.get(URL);
	}
	
	public void quit()
	{
		driver.quit();
	}
	
	// click on any object
	public void click(String object){
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(object))));
		 
		if(driver.findElement(By.xpath(OR.getProperty(object))).isDisplayed())
		{
			WebElement selectElement = driver.findElement(By.xpath(OR.getProperty(object))); 
			setHighlight(selectElement);			
			driver.findElement(By.xpath(OR.getProperty(object))).click();

		}
		else
		{
			Assert.fail("Element is not found --" + object );
		}
		}

	// writing in a text field / select value from a list
	public void input(String object, String data){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(object))));
		 
		if(driver.findElement(By.xpath(OR.getProperty(object))).isDisplayed())
		{
			WebElement selectElement = driver.findElement(By.xpath(OR.getProperty(object))); 
			setHighlight(selectElement);		
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
		}
		else
		{
			Assert.fail("Element is not found --" + object );
		}
		}
	
	public void verifyTitle(){
		
	}
	
	
	
	public void verifyText(){
		
	}
	
	public void safeSelectOptionInDropDowonen(String  locator, String optionToSelect)
	{ 
		try
		{
			List<WebElement> options = Collections.<WebElement>emptyList();
			if(elementPresent(locator))
			{		 
				WebElement selectElement = driver.findElement(By.xpath(locator)); 
				setHighlight(selectElement);		
				Select select = new Select(selectElement); 
				//Get a list of the options 
				options = select.getOptions(); 
				// For each option in the list, verify if it's the one you want and then click it
				if(!options.isEmpty())
				{
					for (WebElement option: options) 
					{ 
						if (option.getText().contains(optionToSelect))
						{ 
							option.click(); 
							break; 
						}
					}
				}
			}
			else
			{
				Assert.fail("Unable to select " + optionToSelect + " from " + locator + "\n"  );
			}
		}
		catch(Exception e)
		{
			Assert.fail("Unable to select " + optionToSelect + " from " + locator + "\n"  );
		}
	}
	
	public void safeSelectOptionInDropDown(String locator, String optionToSelect, int... optionWaitTime)
	{ 
		try
		{
			List<WebElement> options = Collections.<WebElement>emptyList();
			if(elementPresent(locator))
			{		 
				WebElement selectElement = driver.findElement(By.xpath(OR.getProperty(locator))); 
				setHighlight(selectElement);		
				
				Select select = new Select(selectElement); 
				//Get a list of the options 
				options = select.getOptions(); 
				// For each option in the list, verify if it's the one you want and then click it
				if(!options.isEmpty())
				{
					for (WebElement option: options) 
					{ 
						if (option.getText().contains(optionToSelect))
						{ 
							option.click(); 
							System.out.println("Selected " + option + " from " + locator + " dropdown");
							break; 
						}
					}
				}
			}
			else
			{
				Assert.fail("Unable to select " + optionToSelect + " from " + locator + "\n"  );
			}
		}
		catch(Exception e)
		{
			Assert.fail("Unable to select " + optionToSelect + " from " + locator + "\n"  );
		}
	}
	
	public boolean elementPresent(String object){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty(object))));
		 
		if(driver.findElement(By.xpath(OR.getProperty(object))).isDisplayed())
		{
			WebElement selectElement = driver.findElement(By.xpath(OR.getProperty(object))); 
			setHighlight(selectElement);		
			return true;
		}
		else
		{
			return false;
		}
		}

	
	public void mouseHover(String locator)
	{
		try
		{
		    if(elementPresent(locator))
			{
			    Actions builder = new Actions(driver);
			    WebElement HoverElement = driver.findElement(By.xpath(OR.getProperty(locator)));
			    setHighlight(HoverElement);			    
			    builder.moveToElement(HoverElement).build().perform();
			    try {
			    	Thread.sleep(2000);
				} catch (InterruptedException e) {
					Assert.fail("Exception occurred while waiting" );
				}
			    System.out.println("Hovered on element " + locator);
		    }
		    else
			{	    
				Assert.fail("Element was not visible to hover "+"\n" );
			}
		}
		
		catch(Exception e)
		{
			Assert.fail("Unable to hover the cursor on " + locator + "\n"  );
		}
	}
	
	public String getCurrentURL()
	{
		String sUrl = null;
		try
		{
			sUrl = driver.getCurrentUrl();
		}
		catch(Exception e)
		{
			Assert.fail("Some exception occured while retriving current url, exception message: "+e.getMessage());
		}
		
		return sUrl;
	}
	
	public void switchToWindow(int num)
	{
		try
		{
			int numWindow = driver.getWindowHandles().size();
			String[] window = (String[])driver.getWindowHandles().toArray(new String[numWindow]);
			driver.switchTo().window(window[num]);
			System.out.println("Navigated succesfsully to window with sepcified number: "+num);
		}
		catch(NoSuchWindowException e)
		{
			Assert.fail("Window with sepcified number  "+num+"doesn't exists. Please check the window number or wait until the new window appears"+e.getMessage());			
		}
		catch(Exception e)
		{
			Assert.fail("Some exception occured while switching to new window with number: "+num+e.getMessage());			
		}
	}
	
	
	public void setHighlight(WebElement element)
	{
	        String attributevalue = "border:3px solid red;";
	        JavascriptExecutor executor = (JavascriptExecutor) driver;
	        String getattrib = element.getAttribute("style");
	        executor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, attributevalue);
	        try 
	        {
				Thread.sleep(100);
			} 
	        catch (InterruptedException e) 
			{
				Assert.fail("Sleep interrupted - " );
			}
	        executor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, getattrib);
		     
    }
	
	
	
	
	
}
