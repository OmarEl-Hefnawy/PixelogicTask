package tests;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.SignUpPage;

public class SignUpTest extends TestBase 
{
	SignUpPage SignUpObject;
	
	CSVReader Reader;
	
	@Test (priority = 2, description = "Register a new User")
	@Story("Valid Data Register Test")
	@Feature("Register Test")
	@Severity(SeverityLevel.NORMAL)
	@Description ("Sign Up with Valid data")
	public void SignUpProcess() throws CsvValidationException, IOException
	{
		SignUpObject = new SignUpPage(driver);
		
		//Get Path of CSV File
		String CSVFile = System.getProperty("user.dir") + "\\src\\test\\java\\data\\SignUpData.csv";
		Reader = new CSVReader(new FileReader(CSVFile));
		
		String[] CSVCell;
		
		//While Loop will be executed till the end of CSV File
		while ((CSVCell = Reader.readNext()) != null)
		{
			String Password = CSVCell[4];
		
			SignUpObject.FillSignUpPage(Password);
			
			WebDriverWait Wait = new WebDriverWait(driver, 20);
			Wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("/html/body/div[2]/div/div[1]/div/div/div[1]/div/div[2]/h3"))));
			
			Assert.assertTrue(SignUpObject.SignUpMsg.getText().contains("Hi"));
		}
	}
	
	@Test (priority = 3, description = "Logout after registeration")
	@Story("Logout")
	@Feature("Logout Test")
	@Severity(SeverityLevel.NORMAL)
	@Description ("Logout Process")
	public void LogoutProcess()
	{
		SignUpObject.Logout();
		
		WebDriverWait Wait = new WebDriverWait(driver, 20);
		Wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("/html/body/div[2]/div[1]/section/div/div[1]/div[1]/div/h3"))));
		
		Assert.assertTrue(SignUpObject.LogoutMsg.getText().contains("Login"));
	}
}