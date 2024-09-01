package com.ugapp.testcases;


import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ugapp.pages.PreviewPage;


public class TC_17_PreviewTest extends BaseTest
{
	PreviewPage Preview = new PreviewPage();

	@Test(priority = 157, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void preview() throws Throwable
	{
		//validate redirection to preview page
		Preview.validatePreview();

		//enability of download pdf button
		Preview.downloadPdf();

		//validate back button
		Preview.back();
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 158, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void writePreviewToExcel(String colKey,String colValue) throws Throwable
	{
		Preview.previewProfile(colKey,colValue);


		Preview.previewMyInfo(colKey,colValue);


		Preview.previewMyProgram(colKey,colValue);


		Preview.previewMySchools(colKey,colValue);


		Preview.previewMyHighSchoolGrades(colKey,colValue);


		Preview.previewArizonaResidency(colKey,colValue);

	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 159, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void ComparePreviewWithReview(String colKey,String colValue) throws Throwable
	{
		Preview.compareReviewAndPreview(colKey,colValue);
		
	}
		
	@Test(priority = 160, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void ApplicationAffidavitCheck() throws Throwable
	{
		Preview.affidavit();


		Preview.checkbox();


		Preview.previousPage();


	}


	@Test(priority = 161, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void postPreview() throws Throwable
	{
		Preview.signOut();
		
		Preview.login();
		
		Preview.validatePostLogin();
	}

	
	
	

}




