package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility
{
	public void selectByVisibleText(WebElement element,String visibletext)
	{
		Select select=new Select(element);
		select.selectByVisibleText(visibletext);
	}
	public void selectElementByValue(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	public void selectElementByIndex(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void mouseOver(WebDriver driver,WebElement element)
	{
		 Actions actions=new Actions(driver);
		 actions.moveToElement(element).perform();	 
	}
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();
	}
	public void dragandDrop(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.dragAndDrop(element, element).perform();
	}
	public void click(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.click(element).perform();
	}
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
}
