package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{	public WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Username']")WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement password;
	@FindBy(xpath="//button[@type='submit']")WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterUsername(String user) 
	{
		//username.clear();
		username.sendKeys(user);
	}
	public void enterPassword(String pass)
	{
		//password.clear();
		password.sendKeys(pass);
	}
	public void clickSigninButton()
	{
		signin.click();
	}
	public boolean isHomePageLoaded()
	{
		return dashboard.isDisplayed();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
}
