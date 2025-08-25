package demoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends Base
{
	@Test
	public void loginBothCorrect()
	{
		WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
		String user="admin";
		username.sendKeys(user);
		WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		String pass="admin";
		password.sendKeys(pass);
		WebElement signin=driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();
		WebElement dashboard=driver.findElement(By.xpath("//p[text()='Dashboard']"));
		boolean ishomepageloaded=dashboard.isDisplayed();
		Assert.assertTrue(ishomepageloaded);
	}
	@Test
	public void loginBothInCorrect()
	{
		WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
		String user="adm";
		username.sendKeys(user);
		WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		String pass="123";
		password.sendKeys(pass);
		WebElement signin=driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();
		WebElement alertpopup=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		boolean isalertdisplayed=alertpopup.isDisplayed();
		Assert.assertTrue(isalertdisplayed);
	}
	@Test
	public void loginUsernameCorrectPasswordIncorrect()
	{
		WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
		String user="admin";
		username.sendKeys(user);
		WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		String pass="123";
		password.sendKeys(pass);
		WebElement signin=driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();
		WebElement alert=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		boolean isalertdisplayed=alert.isDisplayed();
		Assert.assertTrue(isalertdisplayed);
	}
	@Test
	public void loginUsernameIncorrectPasswordCorrect()
	{
		WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
		String user="1234";
		username.sendKeys(user);
		WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		String pass="admin";
		password.sendKeys(pass);
		WebElement signin=driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();
		WebElement alert=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		boolean isalertdisplayed=alert.isDisplayed();
		Assert.assertTrue(isalertdisplayed);
	}
	@Test
	public void loginWithNoCredentials()
	{
		
		WebElement signin=driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();
	}
}
