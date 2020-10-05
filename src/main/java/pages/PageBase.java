package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase 
{
	protected WebDriver driver; 
	public JavascriptExecutor Jse;
	public Select select;
	public Actions action;
	
	//Create Constructor
	public PageBase(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	protected static void ClickButton(WebElement Button)
	{
		Button.click();
	}

	protected static void Typing(WebElement TextField, String Value)
	{
		TextField.sendKeys(Value);
	}
	
	protected static void ClearTxt(WebElement TextField)
	{
		TextField.clear();
	}
	
	public void Scrolling()
	{
		Jse.executeScript("scrollBy (0,2500)");
	}
}