package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import test.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class StepDefinition extends Base{
	
	public static Logger log =LogManager.getLogger(Base.class.getName());

    @Given("^Initialize browser with chrome driver$")
    public void initialize_browser_with_chrome_driver() throws Throwable 
    {
    	driver =initializeBrowser();
		
    }
    
    @And("^Navigate to MercuryTour website$")
    public void navigate_to_mercurytour_website() throws Throwable 
    {
    	driver.get("http://demo.guru99.com/test/newtours/");
		log.info("Browser launched successfully"); 
    }

    @When("^User provides the \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_provides_the_something_and_something(String strArg1, String strArg2) throws Throwable 
    {
    	LandingPage lP = new LandingPage(driver);
		lP.getUsername().sendKeys(strArg1);
		lP.getPassword().sendKeys(strArg2);
    }
    
    @And("^click on SignIn button$")
    public void click_on_signin_button() throws Throwable 
    {
    	LandingPage lP = new LandingPage(driver);
    	lP.getSignIn().click();
		
    }

    @Then("^Login should be successfull$")
    public void login_should_be_successfull() throws Throwable 
    {
    	log.info("Login successfull");
    }

    @Then("^Login should not be successfull$")
    public void login_should_not_be_successfull() throws Throwable 
    {
    	log.info("Login successfull");
    }


    @And("^Verify the pageTitle$")
    public void verify_the_pagetitle() throws Throwable 
    {
    	LandingPage lP = new LandingPage(driver);
		lP.getRegisterLink().click();
		String actualTitle = driver.getTitle();
		System.out.println("The Title of Page: " +actualTitle);
		String expectedTitle = "Register: Mercury Tours";
		Assert.assertEquals(expectedTitle, actualTitle);
		log.info("Title Verified successfully");
    }
    
    @And("^Close Browser$")
    public void close_browser() throws Throwable {
        driver.quit();
    }

}