package demoPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test(priority=1,groups= {"regression"}, retryAnalyzer=retry.Retry.class,description="Login with Valid username and password")
	public void loginWithValidCredentials() throws IOException
	{
		//String user="admin";
		//String pass="admin";
		String user=ExcelUtility.getStringData(1,0,"LoginPage");
		String pass=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage= new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickSigninButton();
		boolean isdashboarddisplayed =loginpage.isHomePageLoaded();
		Assert.assertTrue(isdashboarddisplayed,"After entering valid username and password home page is not displayed");
	}
	@Test(priority=2,description="Login with invalid credentials")
	public void loginWithInvalidCredentials() throws IOException
	{
		//String user="adm";
		//String pass="123";
		String user=ExcelUtility.getStringData(2,0,"LoginPage");
		String pass=ExcelUtility.getStringData(2,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickSigninButton();
		boolean isAlertMessageDisplayed=loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed,"After entering ivalid credentials the home page is displayed");
	}
	@Test(priority=3, description="Login with Valid username and invalid password")
	public void loginWithUsernameValid() throws IOException
	{
		//String user="admin";
		//String pass="123";
		String user=ExcelUtility.getStringData(3,0,"LoginPage");
		String pass=ExcelUtility.getStringData(3,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickSigninButton();
		boolean isAlertMessageDisplayed=loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed,"After entering valid username and invalid password home page is displayed");
	}
	@Test(priority=4,description="Login with valid password and invalid username")
	public void loginWithPasswordValid() throws IOException
	{
		//String user="1234";
		//String pass="admin";
		String user=ExcelUtility.getStringData(4,0,"LoginPage");
		String pass=ExcelUtility.getStringData(4,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickSigninButton();
		boolean isAlertMessageDisplayed=loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed,"After entering valid password and invalid username home page is displayed");
	}
	
}
