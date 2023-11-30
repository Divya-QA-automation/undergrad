package com.ugapp.testcases;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.ugapp.pages.PreviewPage;


public class TC_17_PreviewTest {


//	@Test(priority = 1)
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
//	@Test(priority = 2)
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
	@Test(priority = 3)
	public void ComparePreviewwithReview(String colKey,String colValue) throws Throwable
	{
		PreviewPage.compareReviewAndPreview();
		
	}
		
//	@Test(priority = 4)
	public void ApplicationAffidavitCheck(String colKey,String colValue) throws Throwable
	{
		PreviewPage.affidavit();


		PreviewPage.checkbox();


		PreviewPage.previousPage();


	}


//	@Test(priority = 5)
	public void postPreview() throws Throwable
	{
		PreviewPage.signOut();
		
		PreviewPage.login();
		
		PreviewPage.validatePostLogin();
	}


}




