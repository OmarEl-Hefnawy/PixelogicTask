package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class SignInPage extends PageBase
{
	public SignInPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy (xpath = "//*[@id=\"loginfrm\"]/div[3]/div[1]/label/input")
	WebElement EmailField;
	
	@FindBy (xpath = "//*[@id=\"loginfrm\"]/div[3]/div[2]/label/input")
	WebElement PasswordField;
	
	@FindBy (css = "button.btn.btn-primary.btn-lg.btn-block.loginbtn")
	WebElement LoginButton;
	
	@FindBy (xpath = "/html/body/div[2]/div[1]/div[1]/div/div/div[1]/div/div[2]/h3")
	public WebElement LoginMsg;
	
	@Step ("Sign In after registration: Email: {0} & Password: {1}")
	public void LoginProcess(String Email, String Password)
	{
		Typing(EmailField, Email);
		Typing(PasswordField, Password);
		ClickButton(LoginButton);
	}
}
