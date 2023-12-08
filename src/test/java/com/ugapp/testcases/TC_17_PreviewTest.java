package com.ugapp.testcases;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.ugapp.pages.PreviewPage;


public class TC_17_PreviewTest extends BaseTest
{


	@Test(priority = 1, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void preview() throws Throwable
	{
		//validate redirection to preview page
		PreviewPage.validatePreview();


		//enability of download pdf button
		PreviewPage.downloadPdf();


		//validate back button
		PreviewPage.back();
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 2, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void writePreviewToExcel(String colKey,String colValue) throws Throwable
	{
		PreviewPage.previewProfile(colKey,colValue);


		PreviewPage.previewMyInfo(colKey,colValue);


		PreviewPage.previewMyProgram(colKey,colValue);


		PreviewPage.previewMySchools(colKey,colValue);


		PreviewPage.previewMyHighSchoolGrades(colKey,colValue);


		PreviewPage.previewArizonaResidency(colKey,colValue);

	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 3, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void ComparePreviewwithReview(String colKey,String colValue) throws Throwable
	{
		PreviewPage.compareReviewAndPreview(colKey,colValue);
		
	}
		
	@Test(priority = 4, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void ApplicationAffidavitCheck() throws Throwable
	{
		PreviewPage.affidavit();


		PreviewPage.checkbox();


		PreviewPage.previousPage();


	}


	@Test(priority = 5, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void postPreview() throws Throwable
	{
		PreviewPage.signOut();
		
		PreviewPage.login();
		
		PreviewPage.validatePostLogin();
	}


}




