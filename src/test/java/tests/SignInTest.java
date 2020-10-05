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
import pages.SignInPage;
import pages.SignUpPage;

public class SignInTest extends TestBase
{
	SignInPage SignInObject;
	SignUpPage SignUpObject;

	CSVReader Reader;

	@Test (priority = 4, description = "Login with valid data")
	@Story("Valid Data Sign In Test")
	@Feature("Login Test")
	@Severity(SeverityLevel.NORMAL)
	@Description ("Sign In with Valid data")
	public void SignInProcess() throws CsvValidationException, IOException
	{
		SignInObject = new SignInPage(driver);

		//Get Path of CSV File
		String CSVFile = System.getProperty("user.dir") + "\\src\\test\\java\\data\\SignInData.csv";
		Reader = new CSVReader(new FileReader(CSVFile));

		String[] CSVCell;

		//While Loop will be executed till the end of CSV File
		while ((CSVCell = Reader.readNext()) != null)
		{
			String Email = CSVCell[0];
			String Password = CSVCell[1];

			SignInObject.LoginProcess(Email, Password);

			WebDriverWait Wait = new WebDriverWait(driver, 20);
			Wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("/html/body/div[2]/div/div[1]/div/div/div[1]/div/div[2]/h3"))));

			Assert.assertTrue(SignInObject.LoginMsg.getText().contains("Hi"));
		}
	}
	
	@Test (priority = 5, description = "Logout after registeration")
	@Story("Logout")
	@Feature("Logout Test")
	@Severity(SeverityLevel.NORMAL)
	@Description ("Logout Process")
	public void LogoutProcess()
	{
		SignUpObject = new SignUpPage(driver);
		
		SignUpObject.Logout();
		
		WebDriverWait Wait = new WebDriverWait(driver, 20);
		Wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("/html/body/div[2]/div[1]/section/div/div[1]/div[1]/div/h3"))));
		
		Assert.assertTrue(SignUpObject.LogoutMsg.getText().contains("Login"));
	}
}