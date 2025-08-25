package demoPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test(priority=1,groups= {"regression"}, retryAnalyzer=retry.Retry.class)
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
		Assert.assertTrue(isdashboarddisplayed);
	}
	@Test(priority=2)
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
		Assert.assertTrue(isAlertMessageDisplayed);
	}
	@Test(priority=3)
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
		Assert.assertTrue(isAlertMessageDisplayed);
	}
	@Test(priority=4)
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
		Assert.assertTrue(isAlertMessageDisplayed);
	}
	@Test
	public void loginWithNoCredentials()
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.clickSigninButton();
	}
}
