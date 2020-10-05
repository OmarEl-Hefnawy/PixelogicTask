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

public class SignUpMandatoryTest extends TestBase
{
	SignUpPage SignUpObject;

	CSVReader Reader;

	@Test (priority = 1, alwaysRun = true, description = "Check Mandatory Fields in Sign Up Page")
	@Story("Valid Mandatory Fields")
	@Feature("Mandatory Fields Test")
	@Severity(SeverityLevel.NORMAL)
	@Description ("Check Working of Mandatory Fields in Register Page")
	public void CheckMandatoryFields() throws IOException, CsvException, InterruptedException
	{
		SignUpObject = new SignUpPage(driver);

		//Get Path of CSV File
		String CSVFile = System.getProperty("user.dir") + "\\src\\test\\java\\data\\SignUpData.csv";
		Reader = new CSVReader(new FileReader(CSVFile));

		List <String[]> CSVCell;
		CSVCell = Reader.readAll();
		String [] Row = CSVCell.get(0);

		String FName = Row[0];
		String LName = Row[1];
		String MobileNumber = Row[2];
		String Email = Row[3];
		String Password = Row[4];

		SignUpObject.FirstNameEmptyField(LName, MobileNumber, Email, Password);
		Assert.assertEquals(SignUpObject.FirstNameField.getAttribute("validationMessage"), "Please fill out this field.");

		SignUpObject.LastNameEmptyField(FName, MobileNumber, Email, Password);
		Assert.assertEquals(SignUpObject.LastNameField.getAttribute("validationMessage"), "Please fill out this field.");

		SignUpObject.MobileNumberEmptyField(FName, LName, Email, Password);
		Assert.assertEquals(SignUpObject.MobileNumberField.getAttribute("validationMessage"), "Please fill out this field.");

		SignUpObject.EmailEmptyField(FName, LName, MobileNumber, Password);
		Assert.assertEquals(SignUpObject.EmailField.getAttribute("validationMessage"), "Please fill out this field.");

		SignUpObject.PasswordEmptyField(FName, LName, MobileNumber, Email, Password);
		Assert.assertEquals(SignUpObject.PasswordField.getAttribute("validationMessage"), "Please fill out this field.");

		SignUpObject.ConfirmPasswordEmptyField(FName, LName, MobileNumber, Email, Password);
		Assert.assertEquals(SignUpObject.ConfirmPasswordField.getAttribute("validationMessage"), "Please fill out this field.");		
	}
}