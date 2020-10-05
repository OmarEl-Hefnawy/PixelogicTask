package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class SignUpPage extends PageBase 
{
	public SignUpPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy (xpath = "//*[@id=\"headersignupform\"]/div[3]/div[1]/div/label/input")
	public WebElement FirstNameField;
	
	@FindBy (xpath = "//*[@id=\"headersignupform\"]/div[3]/div[2]/div/label/input")
	public WebElement LastNameField;
	
	@FindBy (xpath = "//*[@id=\"headersignupform\"]/div[4]/label/input")
	public WebElement MobileNumberField;
	
	@FindBy (xpath = "//*[@id=\"headersignupform\"]/div[5]/label/input")
	public WebElement EmailField;
	
	@FindBy (xpath = "//*[@id=\"headersignupform\"]/div[6]/label/input")
	public WebElement PasswordField;
	
	@FindBy (xpath = "//*[@id=\"headersignupform\"]/div[7]/label/input")
	public WebElement ConfirmPasswordField;
	
	@FindBy (xpath = "//*[@id=\"headersignupform\"]/div[8]/button")
	WebElement SignUpButton;
	
	@FindBy (xpath = "/html/body/div[2]/div/div[1]/div/div/div[1]/div/div[2]/h3")
	public WebElement SignUpMsg;
	
	@FindBy (xpath = "//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[3]/div")
	WebElement AvatarDropMenu;
	
	@FindBy (xpath = "//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[3]/div/div/div/a[2]")
	WebElement LogoutButton;
	
	@FindBy (xpath = "/html/body/div[2]/div[1]/section/div/div[1]/div[1]/div/h3")
	public WebElement LogoutMsg;
	
	@FindBy (xpath = "//*[@id=\"headersignupform\"]/div[2]/div")
	public WebElement PasswordErrorMsg;
	
	@FindBy (xpath = "//*[@id=\"cookyGotItBtnBox\"]/div/button")
	WebElement GotItButton;
	
	@FindBy (css = "div.alert.alert-danger")
	public WebElement ExistingMailMsg;
	
	@FindBy (xpath = "//*[@id=\"loginfrm\"]/div[4]/div[1]/a")
	WebElement SignupButton;
	
	@Step ("Register New User: First Name: {0}, Last Name: {1}, Mobile Number: {2}, Email: {3}, Password: {4} & Confirm Password: {4}")
	public void FillSignUpPage (String Password)
	{
		Typing(ConfirmPasswordField, Password);
		ClickButton(SignUpButton);
	}
	
	@Step ("Logout from system")
	public void Logout()
	{
		ClickButton(AvatarDropMenu);
		ClickButton(LogoutButton);
	}
	
	public void FirstNameEmptyField (String LastName, String MobileNumber, String Email, String Password)
	{
		Typing(LastNameField, LastName);
		Typing(MobileNumberField, MobileNumber);
		Typing(EmailField, Email);
		Typing(PasswordField, Password);
		Typing(ConfirmPasswordField, Password);
		ClickButton(SignUpButton);
	}
	
	public void LastNameEmptyField(String FirstName, String MobileNumber, String Email, String Password)
	{
		Typing(FirstNameField, FirstName);
		ClearTxt(LastNameField);
		ClickButton(SignUpButton);
	}
	
	public void MobileNumberEmptyField(String FirstName, String LastName, String Email, String Password)
	{
		Typing(LastNameField, LastName);
		ClearTxt(MobileNumberField);
		ClickButton(SignUpButton);
	}
	
	public void EmailEmptyField(String FirstName, String LastName, String MobileNumber, String Password)
	{
		Typing(MobileNumberField, MobileNumber);
		ClearTxt(EmailField);
		ClickButton(SignUpButton);
	}
	
	public void PasswordEmptyField(String FirstName, String LastName, String MobileNumber, String Email, String Password)
	{
		Typing(EmailField, Email);
		ClearTxt(PasswordField);
		ClickButton(SignUpButton);
	}

	public void ConfirmPasswordEmptyField(String FirstName, String LastName, String MobileNumber, String Email, String Password)
	{
		Typing(PasswordField, Password);
		ClearTxt(ConfirmPasswordField);
		ClickButton(SignUpButton);
	}
	
	public void FillSignUpPageNS(String FirstName, String LastName, String MobileNumber, String Email, String Password, String ConfirmPassword)
	{
		Typing(FirstNameField, FirstName);
		Typing(LastNameField, LastName);
		Typing(MobileNumberField, MobileNumber);
		Typing(EmailField, Email);
		Typing(PasswordField, Password);
		Typing(ConfirmPasswordField, ConfirmPassword);
		ClickButton(SignUpButton);
	}
	
	public void CorrectPassword(String FirstName, String LastName, String MobileNumber, String Email, String Password)
	{
		ClearTxt(ConfirmPasswordField);
		Typing(ConfirmPasswordField, Password);
		ClickButton(GotItButton);
		ClickButton(SignUpButton);
	}

	public void OpenRegisterPage()
	{
		ClickButton(SignupButton);
	}
	
	public void ClearSignUpPageFields()
	{
		ClearTxt(FirstNameField);
		ClearTxt(LastNameField);
		ClearTxt(MobileNumberField);
		ClearTxt(EmailField);
		ClearTxt(PasswordField);
		ClearTxt(ConfirmPasswordField);
	}
	
	public void CheckFieldsFormats(String FirstName, String LastName, String MobileNumber, String Password)
	{
		Typing(FirstNameField, FirstName);
		Typing(LastNameField, LastName);
		Typing(MobileNumberField, MobileNumber);
		Typing(PasswordField, Password);
	}
}