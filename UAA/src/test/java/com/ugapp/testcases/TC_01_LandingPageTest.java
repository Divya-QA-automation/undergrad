package com.ugapp.testcases;

import java.util.Hashtable;

import org.apache.poi.EncryptedDocumentException;
import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ugapp.base.Page;
import com.ugapp.pages.CreateAccountPage;
import com.ugapp.pages.FooterLinksPage;
import com.ugapp.pages.LandingPage;
import com.ugapp.pages.ProvideFeedbackPage;
import com.ugapp.utilities.Utilities;

import org.testng.annotations.Test;

// Includes * Choose random MOL * Create account * Verify footer links 
public class TC_01_LandingPageTest extends BaseTest
{
	LandingPage landingPage = new LandingPage();
	CreateAccountPage createAccountPage = new CreateAccountPage();
	
	
	@Test(priority=1,groups= {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
	public void verifyFooter() throws InterruptedException
	{
		FooterLinksPage footerLinksPage = new FooterLinksPage();
		footerLinksPage.validateFooterLinks();
		}

	
	
	
	@Parameters({"colKey","colValue"})
	@Test(priority=2, groups= {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18To24_NonUS_Res_Veteran_PastGrad_OOS"})

	public void verifyLandingPage(String colKey,String colValue) throws Throwable
	{
//		landingPage.ViewAppDetails();
//		landingPage.ValidateForCreateAcc();
//		landingPage.ValidateForLogIn();
		landingPage.Random_MOL(colKey, colValue);

	}
	@Parameters({"colKey","colValue"})
	@Test(priority=3, groups= {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18To24_NonUS_Res_Veteran_PastGrad_OOS"})

	public void ChooseInperson_MOL(String colKey,String colValue) throws Throwable
	{
		landingPage.Inperson_MOL(colKey, colValue);

	}
	@Parameters({"colKey","colValue"})
	@Test(priority=4, groups= {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18To24_NonUS_Res_Veteran_PastGrad_OOS"})

	public void ChooseOnline_MOL(String colKey,String colValue) throws Throwable
	{
		landingPage.Online_MOL(colKey, colValue);

	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 5)
	public void writeValidDetails(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		landingPage.validInput(colKey, colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 6)
	public void CreateRandomAccTest(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		landingPage.CreateRandomAcc(colKey, colValue);
	}

	@Test(priority = 7,dataProviderClass = Utilities.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String, String> data) throws Throwable 
	{

		//Positive and negative testcases for CreateAccount and validation
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			createAccountPage.createAccount(data.get("email"), data.get("reemail"), data.get("password"), data.get("repassword"));
			Thread.sleep(4000);
			createAccountPage.validateAccount(data.get("email"), data.get("reemail"), data.get("password"), data.get("repassword"));
		}
	}
}
