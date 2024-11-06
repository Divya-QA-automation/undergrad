package com.ugapp.testcases;


import org.testng.annotations.Test;

import com.ugapp.pages.PreviewPage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TC_17_PreviewTest extends BaseTest
{
	PreviewPage Preview = new PreviewPage();

	@Test(priority = 169)
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
	@Test(priority = 170)
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
	@Test(priority = 171)
	public void ComparePreviewWithReview(String colKey,String colValue) throws Throwable
	{
		Preview.compareReviewAndPreview(colKey,colValue);
		
	}
		
	@Test(priority = 172)
	public void ApplicationAffidavitCheck() throws Throwable
	{
		Preview.affidavit();


		Preview.checkbox();


		Preview.previousPage();


	}


	@Test(priority = 173)
	public void postPreview() throws Throwable
	{
		Preview.signOut();
		
		Preview.login();
		
		Preview.validatePostLogin();
	}

	
	
	

}




