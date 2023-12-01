package com.ugapp.testcases;


import java.util.Hashtable;
import org.testng.annotations.Test;
import org.apache.poi.EncryptedDocumentException;
import org.testng.SkipException;
import com.ugapp.pages.CreateAccountPage;
import com.ugapp.utilities.Utilities;
import org.testng.annotations.Parameters;




public class TC_04_CreateAccountTest extends BaseTest {


	CreateAccountPage createAccountPage = new CreateAccountPage();



	@Test(priority=1, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void verifyCreateAcc() throws Throwable
	{
		createAccountPage.OpenAndValidateCreateAcc();
	}


	@Test(priority=2, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
	public void checkLinksInCreateAccount() throws Throwable
	{
		//log in here link functionality
		createAccountPage.clickLogInHereLink();


		//log in here validation
		createAccountPage.validateClickLoginInHereLink();


		//Create an account here link functionality and validation
		//createAccountPage.clickValidateCreateAnAccountLink();


		//phone functionality and validation
		createAccountPage.checkAndValidateEnrollmentSupportPhone();


		//email functionality and validation
		createAccountPage.checkAndValidateEmail();
	}




	@Test(priority = 3 ,dataProviderClass = Utilities.class, dataProvider = "dp", groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
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
	@Test(priority = 4, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void writeValidDetails(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		createAccountPage.validInput(colKey, colValue);
	}
}














































