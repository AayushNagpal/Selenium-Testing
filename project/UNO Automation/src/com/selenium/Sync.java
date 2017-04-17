/*************************************** PURPOSE **********************************

 - This class contains all synchronization methods
*/


package com.selenium;
import java.util.concurrent.TimeUnit;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pack.base.TestBaseSetup;

public class Sync implements TimeOuts
{
	private Logger log = Logger.getLogger("Sync");
	private WebDriver driver;
	
	public Sync(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	* Sets implicitWait to ZERO. This helps in making explicitWait work...
	* @param driver (WebDriver) The driver object to be used
	* @return void
	* @throws Exception
	*/
	public void nullifyImplicitWait()
	{
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
	}

	/**
	* Set driver's implicitlyWait() time according given waitTime.
	* @param driver (WebDriver) The driver object to be used
	* @param waitTimeInSeconds (int) The time in seconds to specify implicit wait
	* @return void
	* @throws Exception
	*/
	public void setImplicitWait(int waitTimeInSeconds)
	{
		driver.manage().timeouts().implicitlyWait(waitTimeInSeconds, TimeUnit.SECONDS);
	}
	
	
	/**
	 * Waits for an element till the timeout expires
	 * @param driver (WebDriver) The driver object to be used to wait and find the element
	 * @param bylocator (By) locator object of the element to be found
	 * @param waitTime (int) The time in seconds to wait until returning a failure
	 * @return - True (Boolean) if element is located within timeout period else false
	 */
    public boolean isElementPresent(By locator, int waitTime)
	{    	
    	boolean bFlag = false;	
    	nullifyImplicitWait();
    	log.info("Waiting for presence of element " + locator);
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 			
			if(driver.findElement(locator).isDisplayed()||driver.findElement(locator).isEnabled())
			{
				WebElement element = driver.findElement(locator);
				bFlag = true;
				log.info("Element " + locator + " is displayed");
				setHighlightInYellow(element);
			}
		}		
		
		catch (Exception e)
		{
			log.error("Element " + locator + " is not displayed" );
		}
		setImplicitWait(IMPLICITWAIT);
		return bFlag;
	}

 
	/**
	 * Method -  Waits for an element till the element is clickable
	 * @param driver (WebDriver) The driver object to be used to wait and find the element
	 * @param bylocator (By) locator object of the element to be found
	 * @param waitTime (int) The time in seconds to wait until returning a failure	 
	 * @return - True (Boolean) if element is located and is clickable within timeout period else false
	 * @throws Exception
	 */
	public boolean waitUntilClickable(By locator, int... optionWaitTime)
	{    	
		int waitTime =  getWaitTime(optionWaitTime);
		boolean bFlag = false;
    	nullifyImplicitWait();
		try
		{
			log.info("Waiting until element " + locator+" is clickable");
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			 
			if(driver.findElement((locator)).isDisplayed())
			{
				bFlag = true;
				log.info("Element " + locator + " is displayed and is clickable");
			}
		}
		
		catch (Exception e)
		{
			log.error("Element " + locator + " was not clickable" );		
		}
		setImplicitWait(IMPLICITWAIT);
		return bFlag;
	}
	
	/**
	 * 
	 * Method -  Waits for an element till the element is clickable
	 *
	 * @param locator (By) locator object of the element to be found
	 * @param optionWaitTime (int) The time in seconds to wait until returning a failure	
	 * @return True (Boolean) if element is located and is clickable on screen within timeout period else false
	 */
	public boolean isElementClickable(By locator, int... optionWaitTime)
	{    	
		int waitTime =  getWaitTime(optionWaitTime);
		boolean bFlag = false;
    	nullifyImplicitWait();
		try
		{
			log.info("Waiting until element " + locator+" is clickable");
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			 
			if(driver.findElement((locator)).isDisplayed())
			{
				bFlag = true;
				log.info("Element " + locator + " is displayed and is clickable");
			}
		}
		
		catch (Exception e)
		{
			log.error("Element " + locator + " was not clickable" );		
		}
		setImplicitWait(IMPLICITWAIT);
		return bFlag;
	}

	

	/**
	 * Method -  Waits for an element till the element is visible
	 * @param driver (WebDriver) The driver object to be used to wait and find the element
	 * @param bylocator (By) locator object of the element to be found
	 * @param waitTime (int) The time in seconds to wait until returning a failure	 
	 * @return - True (Boolean) if element is located and is visible on screen within timeout period else false
	 * @throws Exception
	 */
	public boolean isElementVisible(By locator, int... optionWaitTime)
	{
		int waitTime =  getWaitTime(optionWaitTime);
		boolean bFlag = false;
		nullifyImplicitWait(); 
		log.info("Waiting until element " + locator+" is visible");
		try
		{			
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			setImplicitWait(IMPLICITWAIT); 
			if(driver.findElement((locator)).isDisplayed())
			{
				bFlag = true;
			log.info("Element " + locator + " is displayed");
			}
		}
				
		catch (Exception e)
		{	
			log.error("Element " + locator + " was not displayed" );	
		}
		return bFlag;
	}


	/**
	 * Purpose- Wait for an element till it is either invisible or not present on the DOM.
	 * @param driver (WebDriver) The driver object to be used to wait and find the element
	 * @param bylocator (By) locator object of the element to be found
	 * @param waitTime (int) The time in seconds to wait until returning a failure	 
	 * @return - True (Boolean) if the element disappears in specified waitTime.
	 * @throws Exception
	 */
	public boolean waitUntilElementDisappears(By locator,int... optionWaitTime)
    {   
		int waitTime =  getWaitTime(optionWaitTime);
		boolean isNotVisible = false;
		log.info("Waiting until element " + locator+" is invisible");
		try
		{						
			nullifyImplicitWait(); 
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator)); 	
			isNotVisible = true;            
		}
		catch(Exception e)
		{           
			log.error("Element " + locator + " is not disappearing" );			
		}
		setImplicitWait(IMPLICITWAIT); 
		return isNotVisible;		
    }
    
   
	/**
	 * Method - Wait until a particular text appears on the screen
	 * @param driver (WebDriver) The driver object to be used to wait and find the element
	 * @param text (String) - text until which the WebDriver should wait.
	 * @return void
	 * @throws Exception
	 */
	public void waitForPageToLoad(final String text) throws Exception
	{
		log.info("Waiting for page to be loaded...");
		nullifyImplicitWait(); 
		(new WebDriverWait(driver, 20)).until(new ExpectedCondition<WebElement>() {
		    public WebElement apply(WebDriver d) 
		    {
		        return d.findElement(By.partialLinkText(text));
		    }
		});
		setImplicitWait(IMPLICITWAIT); 
	}
	
	
	/**
	* Waits until page is loaded.
	*
	* @param driver - The driver object to use to perform this element search
	* @param int - timeout in seconds
	* @return True (boolean)
	* @throws Exception
	*/
	public boolean waitForPageToLoad(int timeOutInSeconds)
	{
		log.info("Waiting for page to be loaded...");
		boolean isPageLoadComplete = false;
		nullifyImplicitWait(); //nullify implicitlyWait()
		try
		{
			new WebDriverWait(driver, timeOutInSeconds).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driverObject) {
			return (Boolean) ((String)((JavascriptExecutor)driver).executeScript("return document.readyState")).equals("complete");
			}
			});
			isPageLoadComplete = (Boolean) ((String)((JavascriptExecutor)driver).executeScript("return document.readyState")).equals("complete");
		}
		catch(Exception e)
	   	{		
			log.error("Unable to load web page" );
			Assert.fail("unable to load webpage"+"\n" );
	   	}
		setImplicitWait(IMPLICITWAIT);
		return isPageLoadComplete;
	}
	
	/**
	* Waits until page is loaded. Default timeout is 250 seconds. Poll time is every 500 milliseconds.
	*
	* @param driver - The driver object to use to perform this element search
	* @return void
	* @throws Exception
	*/
	
	public void waitForPageToLoad() throws Exception 
	{
		log.info("Waiting for page to be loaded...");
		try
		{
			int waitTime = 0;
			boolean isPageLoadComplete = false;
			do 
			{

				isPageLoadComplete = ((String)((JavascriptExecutor)driver).executeScript("return document.readyState")).equals("complete");
				System.out.print(".");
				Thread.sleep(500);
				waitTime++;
				if(waitTime > 500)
				{
					break;
				}
			} 
			while(!isPageLoadComplete);

			if(!isPageLoadComplete)
			{	

				log.error("Unable to load webpage with in default timeout 250 seconds");
				Assert.fail("unable to load webpage with in default timeout 250 seconds");
			}
		}
		catch(Exception e)
		{		
			log.error("Unable to load web page" );
			Assert.fail("unable to load webpage"+"\n"+e.getMessage());
		}

	}

    public boolean isElementPresent(By locator)
    {
    	log.info("Waiting for presence of element " + locator);
    	setImplicitWait(IMPLICITWAIT);
    	return driver.findElements(locator).size()>0;	
    }
	
    public boolean isElementDisplayed(By locator)
    {
    	log.info("Verifying if element " + locator+ " is displayed");
    	boolean isDisplayed = false;
    	setImplicitWait(IMPLICITWAIT);
    	
    	try
    	{
    		if(isElementPresent(locator))
	    	{
	    		isDisplayed = driver.findElement(locator).isDisplayed();	
	    	}
    	} 
 		catch (Exception e)
 		{
 			log.error("Exception occured while determining state of " + locator  );			
 		}	
    	return isDisplayed;
    }
    
    public boolean isElementEnabled(By locator)
    {
    	log.info("Verifying if element " + locator+ " is enabled");
    	boolean isEnabled = false;
    	setImplicitWait(IMPLICITWAIT);
    	try
    	{
    		if(isElementPresent(locator))
        	{
    			isEnabled = driver.findElement(locator).isEnabled();
        	}
    	} 
 		catch (Exception e)
 		{
 			log.error("Exception occured while determining state of " + locator  );			
 		}
    	return isEnabled;
    }

    public boolean isElementSelected(By locator)
    {
    	log.info("Verifying if element " + locator+ " is selected");
    	boolean isSelected = false;
    	setImplicitWait(IMPLICITWAIT);
    	try
    	{
    		if(isElementPresent(locator))
        	{
    			isSelected = driver.findElement(locator).isSelected();
           	}
    	}
 		catch (Exception e)
 		{
 			log.error("Exception occured while determining state of " + locator  );	
 		}
    	return isSelected;
    }
    
    
	public int getWaitTime(int[] optionalWaitArray)
	{
		if(optionalWaitArray.length<=0)
		{
			return MEDIUMWAIT;
		}
		else
		{
			return optionalWaitArray[0];
		}
	}
	
	/**
	@Method Highlights on current working element or locator
	@param Webdriver instance
	@param WebElement
	@return void (nothing)
	*/
	public void setHighlightInYellow(WebElement element)
	{
	        String attributevalue = "border:2px solid yellow;"; 
	        JavascriptExecutor executor = (JavascriptExecutor) driver;
	        String getattrib = element.getAttribute("style");
	        executor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, attributevalue);
	        try 
	        {
				Thread.sleep(100);
			} 
	        catch (InterruptedException e) 
			{
				log.error("Sleep interrupted - " );
			}
	        executor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, getattrib);
		     
    }

	}


