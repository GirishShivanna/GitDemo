package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class HomePage extends Base{
	
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public  void launchBrowser() throws IOException 
	{
		driver =initializeBrowser();
		driver.get("http://demo.guru99.com/test/newtours/");
		log.info("Browser launched successfully");

	}
	
	@Test(dataProvider="getdata")
	public void loginPage(String uname, String pass) throws IOException
	{
		
		LandingPage lP = new LandingPage(driver);
		lP.getUsername().sendKeys(uname);
		lP.getPassword().sendKeys(pass);
		lP.getSignIn().click();
		log.info("Login successfull");
	}
	
	@Test
	public void  verifyTitle() 
	{
		LandingPage lP = new LandingPage(driver);
		lP.getRegisterLink().click();
		String actualTitle = driver.getTitle();
		System.out.println("The Title of Page: " +actualTitle);
		String expectedTitle = "Register: Mercury Tours";
		Assert.assertEquals(expectedTitle, actualTitle);
		log.info("Title Verified successfully");
	}
	
	
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data = new Object[2][2];
		data[0][0]="demo1";
		data[0][1]="test1";
		data[1][0]="demo2";
		data[1][1]="test2";
		
		return data;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		log.info("Browser closed successfully");
	}
	
}
