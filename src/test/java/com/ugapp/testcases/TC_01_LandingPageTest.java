package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.FooterLinksPage;
import com.ugapp.pages.LandingPage;
import com.ugapp.pages.ProvideFeedbackPage;

public class TC_01_LandingPageTest extends BaseTest
{
	@Test
	public void verifyLandingPage() throws InterruptedException
	{
	LandingPage landingPage = new LandingPage();
	landingPage.ValidateForLogIn();
	landingPage.ValidateForCreateAcc();
	ProvideFeedbackPage verifyfeedback = new ProvideFeedbackPage();
	verifyfeedback.OpenFeedback();
	verifyfeedback.ValidateFeedback();
	}
}
