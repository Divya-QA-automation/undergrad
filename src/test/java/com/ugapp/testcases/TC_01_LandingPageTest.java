package com.ugapp.testcases;

import java.util.Hashtable;

import org.apache.poi.EncryptedDocumentException;
import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.ugapp.base.Page;
import com.ugapp.pages.FooterLinksPage;
import com.ugapp.pages.LandingPage;
import com.ugapp.pages.ProvideFeedbackPage;
import com.ugapp.utilities.Utilities;

public class TC_01_LandingPageTest extends BaseTest
{
	LandingPage landingPage = new LandingPage();
	
	
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
		landingPage.MOL(colKey, colValue);

	}

//	@Test(priority = 3 ,dataProviderClass = Utilities.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String, String> data) throws Throwable {




		//Positive and negative testcases for CreateAccount and validation
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			landingPage.createAccount(data.get("email"), data.get("reemail"), data.get("password"), data.get("repassword"));
			Thread.sleep(4000);
			landingPage.validateAccount(data.get("email"), data.get("reemail"), data.get("password"), data.get("repassword"));
		}
	}


	@Parameters({"colKey","colValue"})
//	@Test(priority = 4)
	public void writeValidDetails(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		landingPage.validInput(colKey, colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 5)
	public void CreateRandomAccTest(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		landingPage.CreateRandomAcc(colKey, colValue);
	}

}
