package com.ugapp.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.ugapp.base.Page;
import com.ugapp.pages.FooterLinksPage;
import com.ugapp.pages.LandingPage;
import com.ugapp.pages.ProvideFeedbackPage;

public class TC_01_LandingPageTest extends BaseTest
{
	LandingPage landingPage = new LandingPage();
	@Test(priority=1, groups= {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18To24_NonUS_Res_Veteran_PastGrad_OOS"})
	
	public void verifyLandingPage() throws InterruptedException
	{
		System.out.println("111111");
		landingPage.ValidateForLogIn();
		landingPage.ValidateForCreateAcc();
		ProvideFeedbackPage verifyfeedback = new ProvideFeedbackPage();
		verifyfeedback.OpenFeedback();
		verifyfeedback.ValidateFeedback();
	}

	@Test(priority=2)
	public void CreateNewAcc() throws InterruptedException
	{
		landingPage.CreateAcc();
	}
}
