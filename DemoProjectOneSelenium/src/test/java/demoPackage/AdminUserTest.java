package demoPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base
{
	@Test(description="To create new Admin User Informations")
	public void addAdminUserInformations() throws IOException
	{
		String user=ExcelUtility.getStringData(1, 0,"LoginPage");
		String pass=ExcelUtility.getStringData(1,1,"LoginPage");
		//String username=ExcelUtility.getStringData(1, 0,"Admins");
		//String password=ExcelUtility.getStringData(1,1,"Admins");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickSigninButton();
		AdminUserPage adminpage=new AdminUserPage(driver);
		adminpage.clickMoreInfo();
		adminpage.clickNewButton();
		FakerUtility fakerutility=new FakerUtility();
		String username=fakerutility.createARandomFirstName();
		String password=fakerutility.createARandomFirstName();
		adminpage.enterUsername(username);
		adminpage.enterPassword(password);
		adminpage.selectUserType();
		adminpage.clickSaveButton();
		boolean alertdisplayed=adminpage.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed,"After saving new username and password alert is not displayed");
	}
}
