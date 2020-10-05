package tests;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.SignUpPage;


public class SignUpNSTest extends TestBase 
{
	SignUpPage SignUpObject;

	CSVReader Reader;
	
	@Test (priority = 6, description = "Sign Up With Negative Scenarios")
	@Story("InValid Data Register Test")
	@Feature("Register with Negative Scenarios Test")
	@Severity(SeverityLevel.NORMAL)
	@Description ("Sign Up with InValid data")
	public void SignUpNegativeScenarios() throws IOException, CsvException, InterruptedException
	{
		SignUpObject = new SignUpPage(driver);

		//Get Path of CSV File
		String CSVFile = System.getProperty("user.dir") + "\\src\\test\\java\\data\\SignUpDataNS.csv";
		Reader = new CSVReader(new FileReader(CSVFile));

		List <String[]> CSVCell;
		CSVCell = Reader.readAll();
		String [] Row = CSVCell.get(0);

		String FName = Row[0];
		String LName = Row[1];
		String MobileNumber = Row[2];
		String Email = Row[3];
		String Password = Row[4];
		String ConfirmPassword = Row[5];

		SignUpObject.OpenRegisterPage();
		
		SignUpObject.FillSignUpPageNS(FName, LName, MobileNumber, Email, Password, ConfirmPassword);
		Assert.assertTrue(SignUpObject.PasswordErrorMsg.getText().contains("Password not matching"));
		
		SignUpObject.CorrectPassword(FName, LName, MobileNumber, Email, Password);
		
		Thread.sleep(1000);
		Assert.assertEquals(SignUpObject.ExistingMailMsg.getText(), "Email Already Exists.");
	}
}