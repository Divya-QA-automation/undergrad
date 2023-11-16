package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.PostAppSubmissionDashboardPage;

public class TC_16_PostAppSubmissionDashboardTest {

	@Test(priority = 1)
	public void postDashboard() throws Throwable
	{
		PostAppSubmissionDashboardPage.validatePostDashboard();
		
		PostAppSubmissionDashboardPage.phone();
		
		PostAppSubmissionDashboardPage.email();
	}

	@Test(priority = 2)
	public void links() throws Throwable
	{
		//qtr link validation
		PostAppSubmissionDashboardPage.QTR();

		//transcripts link validation
		PostAppSubmissionDashboardPage.transcripts();

		//fafsa link validation
		PostAppSubmissionDashboardPage.fafsa();

		//view submitted application link validation
		PostAppSubmissionDashboardPage.previewLink();
	}

}
