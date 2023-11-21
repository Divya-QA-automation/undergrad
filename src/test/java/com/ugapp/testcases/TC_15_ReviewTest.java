package com.ugapp.testcases;




import org.testng.annotations.Test;




import com.ugapp.pages.ReviewPage;




public class TC_15_ReviewTest {




		@Test(priority = 1)
	public void review() throws Throwable
	{
		ReviewPage.validateReview();
	}




		@Test(priority = 2)
	public void writeReview() throws Throwable
	{	
		ReviewPage.profileSection();
		ReviewPage.myInfoSection();
		ReviewPage.myProgramSection();
		ReviewPage.mySchoolsSection();
		ReviewPage.myHighSchoolGradesSection();
		ReviewPage.arizonaResidencySection();

	}
		@Test(priority = 3)
	public void CompareTheData() throws Throwable
	{
		String filePath = System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx";
		String sheetName1 = "validData"; 
		String sheetName2 = "ReviewPageData";
		ReviewPage.compareValidDataWithReview(filePath, sheetName1, sheetName2);
	}


		@Test(priority = 4)
	public void edit() throws Throwable
	{
		ReviewPage.editFunctionality();




	}


	@Test(priority = 5)
	public void ApplicationAffidavitTest() throws Throwable
	{
		ReviewPage.ApplicationAffidavit();




	}
	@Test(priority = 6)
	public void ApplicationFeeTest() throws Throwable
	{
		ReviewPage.Acknowledgement();
		ReviewPage.ApplicationFee();




	}
}












