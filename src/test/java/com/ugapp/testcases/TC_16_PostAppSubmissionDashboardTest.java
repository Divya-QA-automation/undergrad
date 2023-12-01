package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.PostAppSubmissionDashboardPage;

public class TC_16_PostAppSubmissionDashboardTest {

	@Test(priority = 1, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void postDashboard() throws Throwable
	{
		PostAppSubmissionDashboardPage.validatePostDashboard();
		
		PostAppSubmissionDashboardPage.phone();
		
		PostAppSubmissionDashboardPage.email();
	}

	@Test(priority = 2, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
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
