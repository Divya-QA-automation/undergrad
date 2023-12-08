package com.ugapp.testcases;








import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ugapp.pages.PreviewPage;
import com.ugapp.pages.ReviewPage;








public class TC_15_ReviewTest extends BaseTest{








	@Test(priority = 1, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void review() throws Throwable
	{
		ReviewPage.validateReview();
	}






	@Parameters({"colKey","colValue"})
	@Test(priority = 2, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void writeReview(String colKey,String colValue) throws Throwable
	{	
		ReviewPage.profileSection(colKey,colValue);
		ReviewPage.myInfoSection(colKey,colValue);
		ReviewPage.myProgramSection(colKey,colValue);
		ReviewPage.mySchoolsSection(colKey,colValue);
		ReviewPage.myHighSchoolGradesSection(colKey,colValue);
		ReviewPage.arizonaResidencySection(colKey,colValue);


	}
	//	@Test(priority = 3)
	//	public void CompareTheData() throws Throwable
	//	{
	//		String filePath = System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx";
	//		String sheetName1 = "validData"; 
	//		String sheetName2 = "ReviewPageData";
	//		ReviewPage.compareValidDataWithReview(filePath, sheetName1, sheetName2);
	//	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 3, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void CompareValidWithReview(String colKey,String colValue) throws Throwable
	{
		ReviewPage.compareValidAndReview(colKey,colValue);

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
	public void ApplicationFee_VisaTest() throws Throwable
	{
		ReviewPage.Acknowledgement();
		ReviewPage.ApplicationFee_Visa();
	}

	@Test(priority = 7)
	public void ApplicationFee_MasterCardTest() throws Throwable
	{
		ReviewPage.Acknowledgement();
		ReviewPage.ApplicationFee_MasterCard();
	}
	@Test(priority = 8)
	public void ApplicationFee_DiscoverTest() throws Throwable
	{
		ReviewPage.Acknowledgement();
		ReviewPage.ApplicationFee_Discover();
	}

	@Test(priority = 9)
	public void ApplicationFee_PayLaterTest() throws Throwable
	{
		ReviewPage.Acknowledgement();
		ReviewPage.ApplicationFee_PayLater();
	}
}


























