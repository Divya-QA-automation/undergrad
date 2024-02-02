package com.ugapp.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.ugapp.pages.PostAppSubmissionDashboardPage;

public class TC_16_PostAppSubmissionDashboardTest extends BaseTest
{

	PostAppSubmissionDashboardPage PostApp = new PostAppSubmissionDashboardPage();
	@Test(priority = 145, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void postDashboard() throws Throwable
	{
		PostApp.validatePostDashboard();
		
		PostApp.phone();
		
		PostApp.email();
	}

	@Test(priority = 146, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void links() throws Throwable
	{
		//qtr link validation
		PostApp.QTR();

		//transcripts link validation
		PostApp.transcripts();

		//fafsa link validation
		PostApp.fafsa();

		//view submitted application link validation
		PostApp.previewLink();
	}

}
