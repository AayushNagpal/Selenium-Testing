package stepDefination;

import org.junit.Assert;

import com.base.WebConnector;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AllStepMethods {

		WebConnector application=new WebConnector();
		
		@Given("^I go to UNO on \"([a-zA-Z]{1,})\"$")
		public void gotoUno(String browserType){
			System.out.println("Going to uno.edu on "+browserType);
			application.openBrowser(browserType);
			application.navigate("http://www.uno.edu");
		}
		
		@And("I enter \"(.*?)\" as \"(.*?)\"$")
		public void input(String object,String data){
			System.out.println("Entering in "+ object +" value "+ data);
			application.input(object,data);
		}
		
		@And("I click on \"(.*?)\"$")
		public void click(String object){
			System.out.println("Clicking "+ object);
			application.click(object);
		}
		
		@Then("login should be \"([a-zA-Z]{1,})\"$")
		public void verifyLogin(String expectedElement){
			System.out.println("Expected esult  - "+ expectedElement);
			Assert.assertTrue("Login not successfull", application.elementPresent(expectedElement));
			
		}
		
		@Given("^selectOptionInDropDown in \"(.*?)\" as \"(.*?)\"$")
		public void selectoptionindropdown_in_as(String arg1, String arg2) throws Throwable {
			System.out.println("From  "+ arg1+ "drop-down, Selecting "+ arg2+" option");
			application.safeSelectOptionInDropDown(arg1, arg2);
		}

		@Then("^verifyAccountCreationLink\"(.*?)\"$")
		public void verifyaccountcreationlink(String expectedElement) throws Throwable {
			System.out.println("Expected Result  - "+ expectedElement);
			Assert.assertTrue("Account not created successfully", application.elementPresent(expectedElement));
			
		}
		
		@Then("^verifySearchResultText\"(.*?)\"$")
		public void verifysearchresulttext(String expectedElement) throws Throwable {
			System.out.println("Expected Result  - "+ expectedElement);
			Thread.sleep(10);
			Assert.assertTrue("Person name is not found under search result", application.elementPresent(expectedElement));
			
		}
		
		@Then("^verifyOptionsInNavigator \"(.*?)\";$")
		public void verifyoptionsinnavigator(String expectedElement) throws Throwable {
			Thread.sleep(300);
			Assert.assertTrue("Option is not present in Navigator", application.elementPresent(expectedElement));
			System.out.println("Expected Result  - "+ expectedElement);

		}
		
		@And("^CloseTheBrowser$")
		public void closethebrowser()  {
			application.quit();		    
		}
		
		@And("^I hoverOn in \"(.*?)\"$")
		public void i_hoverOn_in(String locator) throws Throwable {
			application.mouseHover(locator);
		}

		@Then("^I verifyOptionsUnderTab \"(.*?)\"$")
		public void i_verifyOptionsUnderTab(String expectedElement) throws Throwable {
			Assert.assertTrue("Option is not present under Tab", application.elementPresent(expectedElement));
			System.out.println("Expected Result  - "+ expectedElement);
		   
		}
		
		@Then("^I verifyThePageUrlIs \"(.*?)\"$")
		public void i_verifyThePageUrlIs(String expectedURL) throws Throwable {
			String ActualURL = application.getCurrentURL();
			Assert.assertEquals(ActualURL, expectedURL);
			System.out.println("URL is matching --> Part executed");
		}
		

		@Then("^I verifyFooterLink \"(.*?)\"$")
		public void i_verifyFooterLink(String expectedElement) throws Throwable {
			Assert.assertTrue("Footer link is not displayed", application.elementPresent(expectedElement));
			System.out.println("Expected Result  - "+ expectedElement);		    
		}
		
		@Given("^SwitchToChildWindow \"(.*?)\"$")
		public void switchtochildwindow(String arg1) throws Throwable {
			application.switchToWindow(1);		   
		}
		
		@Then("^hoveron \"(.*?)\"$")
		public void hoveron(String locator) throws Throwable {
			application.mouseHover(locator);
 		}


		@After
		public void browserquit()
		{
			application.quit();
		}
		
		
	}
