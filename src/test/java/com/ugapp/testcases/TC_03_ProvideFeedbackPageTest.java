package com.ugapp.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.ugapp.pages.ProvideFeedbackPage;

public class TC_03_ProvideFeedbackPageTest extends BaseTest
{
	@Test(priority=4)
	public void verifyFeedback() throws InterruptedException
	{
		ProvideFeedbackPage provideFeedback = new ProvideFeedbackPage();
		provideFeedback.OpenFeedback();
		provideFeedback.RateYourExperience();
		provideFeedback.TellAboutYourExperience();
		provideFeedback.SubmitFeedback();
	}

}
