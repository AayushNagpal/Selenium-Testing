/*************************************** PURPOSE **********************************

 - This class contains all UserAction methods
*/
//comment addded for Jenkins autopoll test

package com.selenium;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebConnector extends Sync
{
	//Local WebDriver instance
	WebDriver driver;
	Logger log =Logger.getLogger("WebConnector");
	
	public WebConnector(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}

	//Method for Clicking on Element, waits until the element is loaded and then performs a click action
	public void ClickOn(By locator, int... optionWaitTime)
	{
		try
		{
			int waitTime =  getWaitTime(optionWaitTime);
			if(waitUntilClickable(locator, waitTime))
			{ 
				WebElement element = driver.findElement(locator);
				setHighlight(element);
				element.click();		
				log.info("Clicked on the element " + locator);
			}
			else
			{
				log.error("Unable to click the element ");
			}
		}
		catch(Exception e)
		{
			log.error("Element " + locator + " was not clickable");		
		}
	}

	//Method for double Clicking on Element, waits until the element is loaded and then performs a click action
	
	public void safeDblClick(By locator, int... optionWaitTime)
	{
		try
		{
			int waitTime =  getWaitTime(optionWaitTime);
			if(waitUntilClickable(locator, waitTime))
			{
 
				WebElement element = driver.findElement(locator);
				setHighlight(element);
				Actions userAction = new Actions(driver).doubleClick(element);
				userAction.build().perform();
				log.info("Double clicked the element " + locator);
			}
			else
			{			
				log.error("Unable to double click the element " + locator );
			}
		}
		catch(Exception e)
		{
			log.error("Element " + locator + " was not clickable" );		
		}
	}

	//Method for Clearing the text under text box and Typing new text into it
	public void safeClearAndType(By locator, String text, int... optionWaitTime)
	{
		try
		{
			int waitTime =  getWaitTime(optionWaitTime);
			if(isElementPresent(locator, waitTime))
			{
 
				WebElement element=driver.findElement(locator);
				setHighlight(element);
				element.clear();
				element.sendKeys(text);
				log.info("Cleared the field and entered - '"+text+" in the element - " + locator);
			}
			else
			{			
				log.error("Unable to clear and enter " + text + " in field "+ locator );
			}
		}
		catch(Exception e)
		{
			log.error("Unable to clear and enter '" + text + "' text in field with locator -"+ locator );
		}
	}

	//Method for entering value in text box

	public void safeType(By locator, String text, int... optionWaitTime)
	{
		try
		{
			int waitTime =  getWaitTime(optionWaitTime);
			if(isElementPresent(locator, waitTime))
			{
 
				WebElement element=driver.findElement(locator);
				setHighlight(element);
				element.sendKeys(text);
			}
			else
			{
				log.error("Unable to enter " + text + " in field " + locator );
			}
		}
		catch(Exception e)
		{
			log.error("Unable to enter '" + text + "' text in field with locator -"+ locator );
		}
	}


	
	// Selecting option in radio button
	public void safeSelectRadioButton(By locator, int... optionWaitTime)
	{
		try
		{
			int waitTime =  getWaitTime(optionWaitTime);
			if(waitUntilClickable(locator, waitTime))
			{
 
				WebElement element = driver.findElement(locator);
				setHighlight(element);
				element.click();		
				log.info("Clicked on element " + locator);
			}
			else			
			{
				log.error("Unable to select Radio button "+locator );
			}
		}
		
		catch(Exception e)
		{
			log.error("Unable to click on radio button with locator '" + locator + "'' " );		
		}	
	}
	
	
	/**
	 * Method - Safe Method for checkbox selection, waits until the element is loaded and then selects checkbox
	 * @param locator
	 * @param waitTime
	 * @return - boolean (returns True when the checkbox is selected else returns false)
	 * @throws Exception
	 */
	public void safeCheck(By locator, int... optionWaitTime)
	{
		try
		{
			int waitTime =  getWaitTime(optionWaitTime);
			if(isElementPresent(locator, waitTime))
			{
 
				WebElement checkBox = driver.findElement(locator);
				setHighlight(checkBox);
				if(checkBox.isSelected())
					log.info("CheckBox " + locator + "is already selected");
				else
					checkBox.click();
			}
			else
			{			
				log.error("Unable to select checkbox " + locator );
			}
		}
		
		catch(Exception e)
		{
			log.error("Unable to check the checkbox with locator '" + locator + "'' " );		
		}	
	}

	

	
	/**
	 * Method - Safe Method for checkbox deselection, waits until the element is loaded and then deselects checkbox
	 * @param locator
	 * @param waitTime
	 * @return - boolean (returns True when the checkbox is deselected else returns false)
	 * @throws Exception
	 */
	public void safeUnCheck(By locator, int... optionWaitTime)
	{
		try
		{
			int waitTime =  getWaitTime(optionWaitTime);
			if(isElementPresent(locator, waitTime))
			{
 
				WebElement checkBox = driver.findElement(locator);
				setHighlight(checkBox);
				if(checkBox.isSelected())
					checkBox.click();
				else
					log.info("CheckBox " + locator + "is already deselected");
	
			}
			else
			{			
				log.error("Unable to uncheck the checkbox " + locator );
			}
		}
		
		catch(Exception e)
		{
			log.error("Unable to uncheck the checkbox with locator '" + locator + "'' " );		
		}	
	}
	

	
	/**
	 * Method - Safe Method for checkbox Selection or Deselection based on user input, waits until the element is loaded and then deselects/selects checkbox
	 * @param locator
	 * @param checkOption
	 * @param waitTime
	 * @return - boolean (returns True when the checkbox is status is toggled else returns false)
	 * @throws Exception
	 */
	public void safeCheckByOption(By locator,boolean checkOption, int... optionWaitTime)
	{
		try
		{
			int waitTime =  getWaitTime(optionWaitTime);
			if(isElementPresent(locator, waitTime))
			{
 
				WebElement checkBox = driver.findElement(locator);
				setHighlight(checkBox);		
				if((checkBox.isSelected()==true && checkOption == false)||(checkBox.isSelected()==false && checkOption == true))
					checkBox.click();
				else
					log.info("CheckBox " + locator + "is already deselected");
			}
			else
			{			
				log.error("Unable to Select or Deselect checkbox " + locator );
			}
		}
		
		catch(Exception e)
		{
			log.error("Unable to check or uncheck the checkbox with locator '" + locator + "'' " );		
		}		
	}
	
	
	/**
	 * Method - Safe Method for getting checkbox value, waits until the element is loaded and then deselects checkbox
	 * @param locator
	 * @param checkOption
	 * @param waitTime
	 * @return - boolean (returns True when the checkbox is enabled else returns false)
	 * @throws Exception
	 */
	public boolean safeGetCheckboxValue(By locator, int... optionWaitTime)
	{
		boolean isSelected = false;
		try
		{
			int waitTime =  getWaitTime(optionWaitTime);
			if(isElementPresent(locator, waitTime))
			{				
 
				WebElement checkBox = driver.findElement(locator);
				setHighlight(checkBox);
				if (checkBox.isSelected())		
					isSelected = true; 
			}
			else
			{			
				log.error("Unable to get the status of checkbox " + locator );
			}
		}
				catch(Exception e)
		{
			log.error("Unable to get the status of checkbox " + locator );	
		}
		return isSelected;
	}
	
	
	/**
	 * Purpose- For selecting multiple check boxes at a time
	 * @param waitTime
	 * @param locator
	 * @throws Exception
	 * @functionCall - SelectMultipleCheckboxs(MEDIUMWAIT, By.id("Checkbox1"),By.id("Checkbox2"), By.xpath("checkbox")); u can pass 'N' number of locators at a time
	 */
	public void safeSelectCheckboxes(int waitTime ,By... locator) throws Exception
	  {			
		By check = null;
		try
		{
			if(locator.length>0)
			{
				for(By currentLocator:locator)
				{
					check = currentLocator;
					waitUntilClickable(currentLocator, waitTime);
					WebElement checkBox = driver.findElement(currentLocator);
					setHighlight(checkBox);
					if(checkBox.isSelected())
						log.info("CheckBox " + currentLocator + " is already selected");
					else
						checkBox.click();
				}
			}
			else
			{
				log.error("Expected atleast one locator as argument to safeSelectCheckboxes function" );
			}
		}
		
		catch(Exception e)
		{
			log.error("Unable to select checkbox " + check );	
		}
	  }
	
	/**
	 * Purpose- For deselecting multiple check boxes at a time
	 * @param waitTime
	 * @param locator
	 * @throws Exception
	 * @functionCall - DeselectMultipleCheckboxs(MEDIUMWAIT, By.id("Checkbox1"),By.id("Checkbox2"), By.xpath("checkbox")); u can pass 'N' number of locators at a time
	 */
	public void safeDeselectCheckboxes(int waitTime ,By...locator)
	{	
		By check = null;
		try
		{
			if(locator.length>0)
			{		
				for(By currentLocator:locator)
				{
					check = currentLocator;
					waitUntilClickable(currentLocator,  waitTime);
					WebElement checkBox = driver.findElement(currentLocator);
					setHighlight(checkBox);
					if(checkBox.isSelected())
						checkBox.click();
					else					
						log.info("CheckBox " + currentLocator + " is already deselected");
				}
			}
			else
			{
				log.error("Expected atleast one locator as argument to safeDeselectCheckboxes function" );
			}
		}
		
		catch(Exception e)
		{
			log.error("Unable to deselect checkbox " + check );	
		}
	}
	
	

	/**
	 * Method - Safe Method for User Select option from Drop down by option name, waits until the element is loaded and then selects an option from drop down
	 * @param locator
	 * @param sOptionToSelect
	 * @param waitTime
	 * @return - boolean (returns True when option is selected from the drop down else returns false)
	 * @throws Exception
	 */
	public void safeSelectOptionInDropDown(By locator, String optionToSelect, int... optionWaitTime)
	{ 
		try
		{
			List<WebElement> options = Collections.<WebElement>emptyList();
			int waitTime =  getWaitTime(optionWaitTime);
			if(isElementPresent(locator, waitTime))
			{		
 
				WebElement selectElement = driver.findElement(locator); 
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
							log.info("Selected " + option + " from " + locator + " dropdown");
							break; 
						}
					}
				}
			}
			else
			{
				log.error("Unable to select " + optionToSelect + " from " + locator + "\n"  );
			}
		}
		catch(Exception e)
		{
			log.error("Unable to select " + optionToSelect + " from " + locator + "\n"  );
			Assert.fail("Unable to select " + optionToSelect + " from " + locator + "\n"  );
		}
	}
	
	
	 
	/**
	 * Method - Safe Method for User Select option from Drop down by option index, waits until the element is loaded and then selects an option from drop down
	 * @param locator
	 * @param iIndexofOptionToSelect
	 * @param waitTime
	 * @return - boolean (returns True when option is selected from the drop down else returns false)	
	 * @throws Exception
	 */
	public void safeSelectOptionInDropDownByIndexValue(By locator, int iIndexofOptionToSelect, int... optionWaitTime)
	{ 
		try
		{
			int waitTime = getWaitTime(optionWaitTime);
			if(isElementPresent(locator, waitTime))
			{
 
				WebElement selectElement = driver.findElement(locator);
				setHighlight(selectElement);
				Select select = new Select(selectElement);
				select.selectByIndex(iIndexofOptionToSelect);
				log.info("Selected option from " + locator + " dropdown");
			}
			else
			{
		    	log.error("Unable to select option from " + locator + "\n"  );
		    	Assert.fail("Unable to select option from " + locator + "\n"  );
			}
		}
		
		catch(Exception e)
		{
			log.error("Unable to select option from " + locator + " dropdown"+ "\n"  );	
			Assert.fail("Unable to select option from " + locator + " dropdown"+ "\n"  );
		}
	} 
	
	/**
	 * Method - Safe Method for User Select option from Drop down by option value, waits until the element is loaded and then selects an option from drop down
	 * @param locator
	 * @param sValueOfOptionToSelect
	 * @param waitTime
	 * @return - boolean (returns True when option is selected from the drop down else returns false)	
	 * @throws Exception
	 */
	public void safeSelectOptionInDropDownByValue(By locator, String sValuefOptionToSelect, int... optionWaitTime)
	{ 
		try
		{
			int waitTime = getWaitTime(optionWaitTime);
			if(isElementPresent(locator, waitTime))
			{
 
				WebElement selectElement = driver.findElement(locator);
				setHighlight(selectElement);
				Select select = new Select(selectElement);
				select.selectByValue(sValuefOptionToSelect);
				log.info("Selected option from " + locator + " dropdown");
			}
			else
			{
		    	log.error("Unable to select option from " + locator + "\n"  );
		    	Assert.fail("Unable to select option from " + locator + "\n"  );
			}
		}
		
		catch(Exception e)
		{
			log.error("Unable to select option from " + locator + " dropdown"+ "\n"  );	
			Assert.fail("Unable to select option from " + locator + " dropdown"+ "\n"  );
		}
	} 
	
	/**
	 * Method - Safe Method for User Select option from Drop down by option lable, waits until the element is loaded and then selects an option from drop down
	 * @param locator
	 * @param sVisibleTextOptionToSelect
	 * @param waitTime
	 * @return - boolean (returns True when option is selected from the drop down else returns false)	
	 * @throws Exception
	 */
	public void safeSelectOptionInDropDownByVisibleText(By locator, String sVisibleTextOptionToSelect, int... optionWaitTime)
	{ 
		try
		{
			int waitTime = getWaitTime(optionWaitTime);
			if(isElementPresent(locator, waitTime))
			{
 
				WebElement selectElement = driver.findElement(locator);
				setHighlight(selectElement);
				Select select = new Select(selectElement);
				select.selectByVisibleText(sVisibleTextOptionToSelect);
				log.info("Selected option from " + locator + " dropdown");
			}
			else
			{
		    	log.error("Unable to select option from " + locator + "\n"  );
		    	Assert.fail("Unable to select option from " + locator + "\n"  );
			}
		}
		
		catch(Exception e)
		{
			log.error("Unable to select option from " + locator + " dropdown"+ "\n"  );	
			Assert.fail("Unable to select option from " + locator + " dropdown"+ "\n"  );
		}
	} 
	
	
	/**
	 * Method - Safe Method for User Select option from list menu, waits until the element is loaded and then selects an option from list menu
	 * @param locator
	 * @param sOptionToSelect
	 * @param waitTime
	 * @return
	 * @throws Exception
	 */
	public void safeSelectListBox(By locator, String sOptionToSelect, int... optionWaitTime)
    {
		try
		{
			int waitTime =  getWaitTime(optionWaitTime);
			List<WebElement> options = Collections.<WebElement>emptyList();
			if(isElementPresent(locator, waitTime))
			{
				//First, get the WebElement for the select tag 
				WebElement selectElement = driver.findElement(locator); 
				setHighlight(selectElement);
				//Then instantiate the Select class with that WebElement 
				Select select = new Select(selectElement); 
				//Get a list of the options 
				options = select.getOptions(); 
				if(!options.isEmpty())
				{
					boolean bExists = false;
					// For each option in the list, verify if it's the one you want and then click it 
					for (WebElement option: options) 
					{ 
						if (option.getText().contains(sOptionToSelect))
						{ 
							option.click(); 
							log.info("Selected " + option + " from " + locator + " Listbox");
							bExists = true;
							break; 
						}						
					}
					if(!bExists)
					{
						log.error("Unable to select " + sOptionToSelect + " from " + locator + "\n" );
						Assert.fail("Unable to select " + sOptionToSelect + " from " + locator + "\n" );
					}
				}
			}
			else
			{
				log.error("List box with locator " + locator +"is not displayed"+ "\n" );
				Assert.fail("List box with locator " + locator +"is not displayed"+ "\n" );
			}
		}
		
		catch(Exception e)
		{
			log.error("Unable to select " + sOptionToSelect + " from " + locator + "\n" );
			Assert.fail("Unable to select " + sOptionToSelect + " from " + locator + "\n" );
		}
    }
	
	
	
	/**
	 * Method - Method to hover on an element based on locator using Actions,it waits until the element is loaded and then hovers on the element
	 * @param locator
	 * @param waitTime
	 * @throws Exception
	 */
	public void mouseHover(By locator,int waitTime)
	{
		try
		{
		    if(isElementVisible(locator, waitTime))
			{
			    Actions builder = new Actions(driver);
			    WebElement HoverElement = driver.findElement(locator);
			    builder.moveToElement(HoverElement).build().perform();
			    try {
			    	Thread.sleep(2000);
				} catch (InterruptedException e) {
					log.error("Exception occurred while waiting" );
				}
			    log.info("Hovered on element " + locator);
		    }
		    else
			{	    
				log.error("Element was not visible to hover "+"\n" );
				Assert.fail("Element was not visible to hover "+"\n" );
			}
		}
		
		catch(Exception e)
		{
			log.error("Unable to hover the cursor on " + locator + "\n"  );	
			Assert.fail("Unable to hover the cursor on " + locator + "\n"  );
		}
	}
	

	/**
	 * Method - Method to hover on an element based on locator using Actions and click on given option,it waits until the element is loaded and then hovers on the element
	 * @param locator
	 * @param waitTime
	 * @throws Exception
	 */
	public void mouseHoverAndSelectOption(By locator,By byOptionlocator,int waitTime)
	{
		try
		{
		    if(isElementPresent(locator, waitTime))
			{
			    Actions builder = new Actions(driver);
			    WebElement HoverElement = driver.findElement(locator);
			    builder.moveToElement(HoverElement).build().perform();
			    try {
			    	builder.wait(4000);
				} catch (InterruptedException e) {
					log.error("Exception occurred while waiting" );
				}
			    WebElement element = driver.findElement(byOptionlocator);
			    element.click();
			    log.info("Hovered on element and select the Option" + locator);
		    }
		    else
			{	    
				log.error("Element was not visible to hover "+"\n" );
				Assert.fail("Element was not visible to hover "+"\n" );
			}
		}
		
		catch(Exception e)
		{
			log.error("Unable to hover the cursor on " + locator + "or unable to select "+ byOptionlocator +"option"+ "\n"  );	
			Assert.fail("Unable to hover the cursor on " + locator + "or unable to select "+ byOptionlocator +"option"+ "\n"  );
		}
	}
	
		
	/**
	 * Purpose- Method For performing drag and drop operations 
	 * @param Sourcelocator,Destinationlocator
	 * @param waitTime
	 * @throws Exception
	 * @function_call - eg: DragAndDrop(By.id(Sourcelocator), By.xpath(Destinationlocator), "MEDIUMWAIT");
	 */
	public void dragAndDrop(By Sourcelocator, By Destinationlocator, int waitTime)
	  {
		try
		  {
			  if(isElementPresent(Sourcelocator, waitTime))
			  {
				  WebElement source = driver.findElement(Sourcelocator);
				  if(isElementPresent(Destinationlocator, waitTime))
				  {
					  WebElement destination = driver.findElement(Destinationlocator);
					  Actions action = new Actions(driver);
					  action.dragAndDrop(source, destination).build().perform();
					  log.info("Dragged the element "+ Sourcelocator + " and dropped in to " + Destinationlocator);
				  }
				  else
				  {
					  log.error("Destination Element with locator "+Destinationlocator+" was not displayed to drop"+"\n" );
					  Assert.fail("Destination Element with locator "+Destinationlocator+" was not displayed to drop"+"\n" );
				  }
			  }
			  else
			  {
				  log.error("Source Element with locator "+Sourcelocator+" was not displayed to drag"+"\n" );
				  Assert.fail("Source Element with locator "+Sourcelocator+" was not displayed to drag"+"\n" );
			  }
		  }
		  
		  catch(Exception e)
		  {			  		 
			  log.error("Some exception occurred while performing drag and drop operation " );
			  Assert.fail("Some exception occurred while performing drag and drop operation " );
		  }
	  }
	
	
	
	/**
	 * Purpose - To select the context menu option for the given element
	 * @param locator
	 * @param OptionIndex
	 * @param waitTime
	 * @return
	 * @throws Exception
	 */
	public void safeSelectContextMenuOption(By locator, int iOptionIndex, int waitTime)
	{
		try
	    {
			if(isElementPresent(locator, waitTime))
			{
				selectContextMenuOption(locator, iOptionIndex);
			}
			else
			{
				log.error("Element with locator "+locator+"is not displayed to perform content menu operation" );
				Assert.fail("Element with locator "+locator+"is not displayed to perform content menu operation" );
			}
	    }
	    
	    catch(Exception e)
	    {
			log.error("Unable to select context menu option" );
		   	Assert.fail("Unable to select context menu option" );
	    }
	}
	
	
	private void selectContextMenuOption(By locator, int iOptionIndex) 
	{		
		WebElement Element = driver.findElement(locator);
		Actions _action = new Actions(driver);
		for (int count=1; count<=iOptionIndex; count++)
		{
			_action.contextClick(Element).sendKeys(Keys.ARROW_DOWN);
		}
		_action.contextClick(Element).sendKeys(Keys.RETURN).build().perform();
	}
    
	
	
	
	
	/**
	 * 
	 * TODO Safe method to get the attribute value
	 *
	 * @param locator - locator value by which an element is located
	 * @param sAttributeValue - attribute type
	 * @param waitTime - Time to wait for an element
	 * @return - returns the attribute value of type string
	 */
	public String safeGetAttribute(By locator,String sAttributeValue,int waitTime)
	{
		String sValue = null;
		try
		{
			if(isElementPresent(locator, waitTime))
			{
				sValue = driver.findElement(locator).getAttribute(sAttributeValue);
			}
			else
			{
				log.error("Unable to get attribute from locator "+locator);
				Assert.fail("Unable to get attribute from locator "+locator);
			}
		}
		
		catch(Exception e)
		{
			log.error("Unable to get attribute value of type " + sAttributeValue + " from the element "+ locator+ "\n" );		
			Assert.fail("Unable to get attribute value of type " + sAttributeValue + " from the element "+ locator+ "\n" );
		}		
		return sValue;		
	}
	
	/**
	 * 
	 * TODO Safe method to get text from an element
	 *
	 * @param locator - locator value by which an element is located
	 * @param waitTime - Time to wait for an element
	 * @return - returns the text value from element
	 */
	public String safeGetText(By locator,int waitTime)
	{
		String sValue =null;
		try
		{
			if(isElementPresent(locator, waitTime))
			{
				sValue = driver.findElement(locator).getText();
			}
			else
			{
				Assert.fail("Unable to get the text from the element "+ locator);
			}
			
		}
		
		catch(Exception e)
		{
			log.error("Unable to get the text from the element "+ locator+ "\n" );
			Assert.fail("Unable to get the text from the element "+ locator+ "\n" );
		}		
		return sValue;		
	}
	

	/**
	 * 
	 * TODO Safe method to retrieve the option selected in the drop down list 
	 *
	 * @param locator - locator value by which an element is located
	 * @param waitTime - Time to wait for an element
	 * @return - returns the option selected in the drop down list
	 */
	public String safeGetSelectedOptionInDropDown(By locator, int sWaitTime) throws Exception
	{
		String dropDownSelectedValue = null;
		
		try
		{
			//return getSelectedOptionInDropDown(locator, sWaitTime);
			if(isElementPresent(locator, sWaitTime))
			{
				Select dropDownName = new Select(driver.findElement(locator));
				//setHighlight(driver, dropDownName);
				dropDownSelectedValue = dropDownName.getFirstSelectedOption().getText();
			}
			else
			{
				log.error("Dropdown with locator: "+locator+" is not displayed" );
				Assert.fail("Dropdown with locator: "+locator+" is not displayed" );
			}
		}
		
		catch(Exception e)
		{
 			log.error("Unable to retrieve drop down field value:"+locator );
 		   	Assert.fail("Unable to retrieve drop down field value:"+locator );
		}
		return dropDownSelectedValue;
	}
	
	/**
	 * Method for switching to frame using frame id
	 * @param driver
	 * @param frame
	 */
	public void selectFrame(String frame)
	{
		try
		{
			driver.switchTo().frame(frame);
			log.info("Navigated to frame with id " + frame);	
		}
		catch(NoSuchFrameException e)
		{
			log.error("Unable to locate frame with id " + frame  );
			Assert.fail("Unable to locate frame with id " + frame  );
		}
		catch(Exception e)
		{
			log.error("Unable to navigate to frame with id " + frame  );
			Assert.fail("Unable to navigate to frame with id " + frame  );
		}
	}
	

	/**
	 * Method - Method for switching to frame in a frame
	 * @param driver
	 * @param ParentFrame
	 * @param ChildFrame
	 */
	public void selectFrame(String ParentFrame, String ChildFrame)
	{
		try
		{
			driver.switchTo().frame(ParentFrame).switchTo().frame(ChildFrame);
			log.info("Navigated to innerframe with id " + ChildFrame + "which is present on frame with id" + ParentFrame);
		}
		catch(NoSuchFrameException e)
		{
			log.error("Unable to locate frame with id " + ParentFrame+" or "+ ChildFrame );
			Assert.fail("Unable to locate frame with id " + ParentFrame+" or "+ ChildFrame );
		}
		catch(Exception e)
		{
			log.error("Unable to navigate to innerframe with id " + ChildFrame + "which is present on frame with id" + ParentFrame  );		
			Assert.fail("Unable to navigate to innerframe with id " + ChildFrame + "which is present on frame with id" + ParentFrame  );
		}
	}

	
	/**
	 * Method - Method for switching to frame using any locator of the frame
	 * @param driver
	 * @param ParentFrame
	 * @param ChildFrame
	 */
	public void selectFrame(By Framelocator, int waitTime)
	{
		try
		{
			if(isElementPresent(Framelocator,waitTime))
			{
				WebElement Frame = driver.findElement(Framelocator);             
			    driver.switchTo().frame(Frame);
			    log.info("Navigated to frame with locator " + Framelocator);	
			}
			else
			{
				log.error("Unable to navigate to frame with locator " + Framelocator  );
				Assert.fail("Unable to navigate to frame with locator " + Framelocator  );
			}
		}
		catch(NoSuchFrameException e)
		{
			log.error("Unable to locate frame with locator " + Framelocator );
			Assert.fail("Unable to locate frame with locator " + Framelocator );
		}
		catch(Exception e)
		{
			log.error("Unable to navigate to frame with locator " + Framelocator  );
			Assert.fail("Unable to navigate to frame with locator " + Framelocator  );
		}
	}
	
	
	/**
	 * Method - Method for switching back to webpage from frame
	 * @param driver
	 */
	public void defaultFrame()
	{
		try
		{
			driver.switchTo().defaultContent();
			log.info("Navigated to back to webpage from frame");
		}
		catch(Exception e)
		{
			log.error("unable to navigate back to main webpage from frame" );
			Assert.fail("unable to navigate back to main webpage from frame" );
		}
	}
	

 	/**
 	 * Method: Gets a UI element attribute value and compares with expected value
 	 * @param driver
 	 * @param locator
 	 * @param attributeName
 	 * @param expected
 	 * @param contains
 	 * @return - Boolean (true if matches)
 	 */
	public boolean getAttributeValue(WebDriver driver, By locator, String attributeName, String expected, boolean contains)
	{
		boolean bvalue = false;
		try
		{
			String sTemp=driver.findElement(locator).getAttribute(attributeName);
			if(contains)
			{
				if(sTemp.contains(expected))
					bvalue = true;
				else
					bvalue = false;
			}
			else
			{
				if(sTemp==expected)
					bvalue = true;
				else
					bvalue = false;
			}
		}
		catch(StaleElementReferenceException e)
		{			
			log.error("Element with " + locator +"is not attached to the page document" );
			Assert.fail("Element with " + locator +"is not attached to the page document" );			
		}
	    catch (NoSuchElementException e)
		{	    	
			log.error("Element " + locator + " was not found in DOM" );	
			Assert.fail("Element "+ locator +" was not found in DOM" );			
		}
		catch(Exception e)
		{
			log.error("Unable to get attribute value of type " + attributeName + " from the element "+ locator+ "\n" );		
			Assert.fail("Unable to get attribute value of type " + attributeName + " from the element "+ locator+ "\n" );
		}
		return bvalue;
	}
	
	
	/**
	@Method Highlights on current working element or locator
	@param Webdriver instance
	@param WebElement
	@return void (nothing)
	*/
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
				log.error("Sleep interrupted - " );
			}
	        executor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, getattrib);
		     
    }
	
	
	/**
	 * 
	 * This method is used to switch to windows based on provided number.
	 *
	 * @param num , Window number starting at 0
	 */
	public void switchToWindow(int num)
	{
		try
		{
			int numWindow = driver.getWindowHandles().size();
			String[] window = (String[])driver.getWindowHandles().toArray(new String[numWindow]);
			driver.switchTo().window(window[num]);
			log.info("Navigated succesfsully to window with sepcified number: "+num);
		}
		catch(NoSuchWindowException e)
		{
			log.error("Window with sepcified number "+num+" doesn't exists. Please check the window number or wait until the new window appears"+"\n" );
			Assert.fail("Window with sepcified number  "+num+"doesn't exists. Please check the window number or wait until the new window appears"+e.getMessage());			
		}
		catch(Exception e)
		{
			log.error("Some exception occured while switching to new window with number: "+num+"\n" );
			Assert.fail("Some exception occured while switching to new window with number: "+num+e.getMessage());			
		}
	}
	
	/**
	 * 
	 * This method is used to refresh the web page
	 *
	 */
	public void refresh()
	{
		try
		{
			driver.navigate().refresh();			
		}
		catch(Exception e)
		{
			log.error("Refreshing page didnt taje place");
			Assert.fail("Some exception occured while refreshing the page, exception message: "+e.getMessage());			
		}		
	}
	
	/**
	 * 
	 * This method is used to navigate to back page
	 *
	 */
	public void navigateToBackPage()
	{
		try
		{
			driver.navigate().back();
		}
		catch(Exception e)
		{
			log.error("Some exception occured while navigating to back page, exception message: "+e.getMessage());
			Assert.fail("Some exception occured while navigating to back page, exception message: "+e.getMessage());
		}
	}
	
	/**
	 * 
	 * This method is used to perform web page forward navigation
	 *
	 */
	public void navigateToForwardPage()
	{
		try
		{
			driver.navigate().forward();
		}
		catch(Exception e)
		{
			log.error("Some exception occured while forwarding to a page, exception message: "+e.getMessage());
			Assert.fail("Some exception occured while forwarding to a page, exception message: "+e.getMessage());
		}
	}
	
	/**
	 * 
	 * This method is used to retrieve current url
	 *
	 * @return, returns current url
	 */
	public String getCurrentURL()
	{
		String sUrl = null;
		try
		{
			sUrl = driver.getCurrentUrl();
		}
		catch(Exception e)
		{
			log.error("Some exception occured while retriving current url, exception message: "+e.getMessage());
			Assert.fail("Some exception occured while retriving current url, exception message: "+e.getMessage());
		}
		
		return sUrl;
	}
	
	/**
	 * 
	 * This method is used to retrieve current web page title
	 *
	 * @return , returns current web page title  
	 */
	public String getTitle()
	{
		String sTitle = null;
		try
		{
			sTitle = driver.getTitle();
		}
		catch(Exception e)
		{
			log.error("Some exception occured while retriving title of the web page, exception message: "+e.getMessage());
			Assert.fail("Some exception occured while retriving title of the web page, exception message: "+e.getMessage());
		}
		return sTitle;
	}

	/**
	 * This method is used to Delete all cookies
	 */
	public void deleteAllCookies()
	{
		try
		{
			driver.manage().deleteAllCookies();
		}
		catch(Exception e)
		{
			log.error("Some exception occured while deleting all cookies, exception message: "+e.getMessage());
			Assert.fail("Some exception occured while deleting all cookies, exception message: "+e.getMessage());
		}
	}
	
	/**
	 * 
	 * This method is used to retrieve page source of the web page
	 *
	 * @return , returns page source of the web page
	 */
	public String getPageSource()
	{
		String sPageSource = null;
		try
		{
			sPageSource = driver.getPageSource();
		}
		catch(Exception e)
		{
			log.error("Some exception occured while retriving page source, exception message: "+e.getMessage());
			Assert.fail("Some exception occured while retriving page source, exception message: "+e.getMessage());
		}
		return sPageSource;
	}
	
	/**
	 * 
	 * This method is used to return number of locators found
	 *
	 * @param Locator
	 * @return , returns number of locators
	 */
	public int getLocatorCount(By Locator)
	{
		int iCount = 0;
		try
		{
			iCount=driver.findElements(Locator).size();
		}
		catch(Exception e)
		{
			log.error("Some exception occured while retriving Locator count, exception message: "+e.getMessage());
			Assert.fail("Some exception occured while retriving Locator count, exception message: "+e.getMessage());
		}
		return iCount;
	}
	
	/**
	 * 
	 * This method is used to return list of WebElements matched by locator 
	 *
	 * @param Locator
	 * @return
	 */
	public List<WebElement> LocatorWebElements(By Locator) 
	{
		List<WebElement> list = null;
		try
		{
			list= driver.findElements(Locator);
		}
		catch(Exception e)
		{
			log.error("Some exception occured while retriving web elements of a locator, exception message: "+e.getMessage());
			Assert.fail("Some exception occured while retriving web elements of a locator, exception message: "+e.getMessage());
		}
		return list;
	}
}
