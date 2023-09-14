package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.ProvideFeedbackPage;

public class TC_03_ProvideFeedbackPageTest 
{
	@Test
	public void verifyFeedback()
	{
		ProvideFeedbackPage provideFeedback = new ProvideFeedbackPage();
		provideFeedback.OpenFeedback();
		provideFeedback.ValidateFeedback();
		provideFeedback.RateYourExperience();
		provideFeedback.TellAboutYourExperience();
		provideFeedback.SubmitFeedback();
	}

}
