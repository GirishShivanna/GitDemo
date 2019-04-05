package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	WebDriver driver;
	By username = By.cssSelector("input[name='userName']");
	By password = By.cssSelector("input[name='password']");
	By loginbtn = By.cssSelector("input[value='Login']");
	By registerlink = By.linkText("REGISTER");
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getSignIn()
	{
		return driver.findElement(loginbtn);
	}
	
	public WebElement getRegisterLink()
	{
		return driver.findElement(registerlink);
	}

}
