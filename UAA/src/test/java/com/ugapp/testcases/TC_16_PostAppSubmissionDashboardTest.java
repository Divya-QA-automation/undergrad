package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.PostAppSubmissionDashboardPage;

import org.testng.annotations.Test;

public class TC_16_PostAppSubmissionDashboardTest extends BaseTest
{

	PostAppSubmissionDashboardPage PostApp = new PostAppSubmissionDashboardPage();
	@Test(priority = 166)
	public void postDashboard() throws Throwable
	{
		PostApp.validatePostDashboard();

	}
	@Test(priority = 167)
	public void links() throws Throwable
	{
		//qtr link validation
		PostApp.QTR();

		//transcripts link validation
		PostApp.transcripts();

		//fafsa link validation
		PostApp.fafsa();
	}

	@Test(priority = 168)
	public void checkQtrAlertPresenceForAZ_OnlineTest() throws Throwable
	{
		//qtr alert validation
		PostApp.checkQtrAlertPresenceForAZ_Online();
	}

	
	@Test(priority = 169)
	public void LinkToPrview() throws Throwable
	{
		//view submitted application link validation
		PostApp.previewLink();
	}

}
