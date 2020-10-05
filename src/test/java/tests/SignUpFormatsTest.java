package tests;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.SignUpPage;

public class SignUpFormatsTest extends TestBase
{
	SignUpPage SignUpObject;

	CSVReader Reader;

	@Test (priority = 7, description = "Check Formats of Fields in Sign Up Page")
	@Story("Valid Formats of Fields")
	@Feature("Formats of Fields Test")
	@Severity(SeverityLevel.NORMAL)
	@Description ("Check Formats of Fields in Register Page")
	public void SignUpProcess() throws IOException, CsvException
	{
		SignUpObject = new SignUpPage(driver);

		//Get Path of CSV File
		String CSVFile = System.getProperty("user.dir") + "\\src\\test\\java\\data\\SignUpDataFormats.csv";
		Reader = new CSVReader(new FileReader(CSVFile));

		List <String[]> CSVCell;
		CSVCell = Reader.readAll();
		String [] Row = CSVCell.get(0);

		String FName = Row[0];
		String LName = Row[1];
		String MobileNumber = Row[2];
		String Password = Row[3];

		SignUpObject.ClearSignUpPageFields();

		try {
			SignUpObject.CheckFieldsFormats(FName, LName, MobileNumber, Password);

			Assert.assertEquals(SignUpObject.FirstNameField.getAttribute("value"), "Omar");
			Assert.assertEquals(SignUpObject.LastNameField.getAttribute("value"), "El-Hefnawy");
			Assert.assertEquals(SignUpObject.MobileNumberField.getAttribute("value"), "01008090772");
			Assert.assertEquals(SignUpObject.PasswordField.getAttribute("value"), "123456aSu");
		} catch (AssertionError err) 
		{
			saveFailureScreenShot();
			throw err;
		}

	}

	@Attachment
	public byte[] saveFailureScreenShot() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
}
