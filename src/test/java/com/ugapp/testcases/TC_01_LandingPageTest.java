package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.FooterLinksPage;
import com.ugapp.pages.LandingPage;
import com.ugapp.pages.ProvideFeedbackPage;

public class TC_01_LandingPageTest extends BaseTest
{
	LandingPage landingPage = new LandingPage();
	@Test(priority=1, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void verifyLandingPage() throws InterruptedException
	{
	landingPage.ValidateForLogIn();
	landingPage.ValidateForCreateAcc();
	ProvideFeedbackPage verifyfeedback = new ProvideFeedbackPage();
	verifyfeedback.OpenFeedback();
	verifyfeedback.ValidateFeedback();
	}
	
	@Test(priority=2, groups={"18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void CreateNewAcc() throws InterruptedException
	{
		landingPage.CreateAcc();
	}
}
