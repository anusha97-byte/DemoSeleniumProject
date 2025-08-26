package demoPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base
{
	@Test(groups= {"regression"},description="To add a new news ")
	public void manageNews() throws IOException
	{
		/*String news="New news is added";
		String user="admin";
		String pass="admin";*/
		String user=ExcelUtility.getStringData(1,0,"LoginPage");
		String pass=ExcelUtility.getStringData(1,1,"LoginPage");
		String news=ExcelUtility.getStringData(1,0,"ManageNews");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickSigninButton();
		ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews.clickMoreInfo();
		managenews.clickNewButton();
		managenews.enterTheNews(news);
		managenews.clickSaveButton();
		boolean alertdisplayed=managenews.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed,"After saving new news alert is not displayed");
	}
	@Test(description="To update a news")
	public void newsUpdate() throws IOException
	{
		/*String news="This is the updated news";
		String user="admin";
		String pass="admin";*/
		String user=ExcelUtility.getStringData(1,0,"LoginPage");
		String pass=ExcelUtility.getStringData(1,1,"LoginPage");
		String news=ExcelUtility.getStringData(1,1,"ManageNews");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickSigninButton();
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickMoreInfo();
		managenewspage.clickUpdateButton();
		managenewspage.enterUpdatedNews(news);
		managenewspage.clickTheUpdateButton();
		boolean alertdisplayed=managenewspage.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed,"After updating news alert is not displayed");
	}
	
}
