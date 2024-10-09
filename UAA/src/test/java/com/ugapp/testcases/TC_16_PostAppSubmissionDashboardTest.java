package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.PostAppSubmissionDashboardPage;

import org.testng.annotations.Test;

public class TC_16_PostAppSubmissionDashboardTest extends BaseTest
{

	PostAppSubmissionDashboardPage PostApp = new PostAppSubmissionDashboardPage();
	@Test(priority = 154, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void postDashboard() throws Throwable
	{
		PostApp.validatePostDashboard();

	}
	@Test(priority = 155, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void links() throws Throwable
	{
		//qtr link validation
		PostApp.QTR();

		//transcripts link validation
		PostApp.transcripts();

		//fafsa link validation
		PostApp.fafsa();
	}

	@Test(priority = 156, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void LinkToPrview() throws Throwable
	{
		//view submitted application link validation
		PostApp.previewLink();
	}

}
