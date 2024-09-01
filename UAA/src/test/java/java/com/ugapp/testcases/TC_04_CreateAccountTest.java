package java.com.ugapp.testcases;


import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;
import org.testng.annotations.Test;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.SkipException;
import java.com.ugapp.pages.CreateAccountPage;
import java.com.ugapp.utilities.Utilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class TC_04_CreateAccountTest extends BaseTest {


	CreateAccountPage createAccountPage = new CreateAccountPage();
	

	@Test(priority=5)
	public void verifyCreateAcc() throws Throwable
	{
		createAccountPage.OpenAndValidateCreateAcc();
	}


	@Test(priority=6)
	public void checkLinksInCreateAccount() throws Throwable
	{
		//log in here link functionality
		createAccountPage.clickLogInHereLink();


		//log in here validation
		createAccountPage.validateClickLoginInHereLink();


		//Create an account here link functionality and validation
		//		createAccountPage.clickValidateCreateAnAccountLink();


		//phone functionality and validation
		createAccountPage.checkAndValidateEnrollmentSupportPhone();


		//email functionality and validation
		createAccountPage.checkAndValidateEmail();
		
		// Validate the Application guide
		createAccountPage.ValidateApplicationGuide();
	}




	@Test(priority = 7 ,dataProviderClass = Utilities.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String, String> data) throws Throwable {




		//Positive and negative testcases for CreateAccount and validation
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			createAccountPage.createAccount(data.get("email"), data.get("reemail"), data.get("password"), data.get("repassword"));
			Thread.sleep(4000);
			createAccountPage.validateAccount(data.get("email"), data.get("reemail"), data.get("password"), data.get("repassword"));
		}
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 8)
	public void writeValidDetails(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		createAccountPage.validInput(colKey, colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 9)
	public void CreateRandomAccTest(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		createAccountPage.CreateRandomAcc(colKey, colValue);
	}

}














































