package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.PreviewPage;

public class TC_17_PreviewTest {

	@Test(priority = 1)
	public void preview() throws Throwable
	{
		//validate redirection to preview page
		PreviewPage.validatePreview();

		//enability of download pdf button
		PreviewPage.downloadPdf();

		//validate back button
		PreviewPage.back();
	}

	@Test(priority = 2)
	public void writePreviewToExcel() throws Throwable
	{
		PreviewPage.previewProfile();

		PreviewPage.previewMyInfo();

		PreviewPage.previewMyProgram();

		PreviewPage.previewMySchools();

		PreviewPage.previewMyHighSchoolGrades();

		PreviewPage.previewArizonaResidency();

		PreviewPage.affidavit();

		PreviewPage.checkbox();

		PreviewPage.previousPage();

	}

	@Test(priority = 3)
	public void postPreview() throws Throwable
	{
		PreviewPage.signOut();
		
		PreviewPage.login();
		
		PreviewPage.validatePostLogin();
	}

}
