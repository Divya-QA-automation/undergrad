package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.ReviewPage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;








public class TC_15_ReviewTest extends BaseTest{





	ReviewPage reviewPage = new ReviewPage();


	@Test(priority = 143, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void review() throws Throwable
	{
		
		reviewPage.validateReview();
	}






	@Parameters({"colKey","colValue"})
	@Test(priority = 144, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void writeReview(String colKey,String colValue) throws Throwable
	{	
		reviewPage.profileSection(colKey,colValue);
		reviewPage.myInfoSection(colKey,colValue);
		reviewPage.myProgramSection(colKey,colValue);
		reviewPage.mySchoolsSection(colKey,colValue);
		reviewPage.myHighSchoolGradesSection(colKey,colValue);
		reviewPage.arizonaResidencySection(colKey,colValue);


	}
//		@Test(priority = 3)
//		public void CompareTheData() throws Throwable
//		{
//			String filePath = System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx";
//			String sheetName1 = "validData"; 
//			String sheetName2 = "reviewPageData";
//			reviewPage.compareValidDataWithReview(filePath, sheetName1, sheetName2);
//		}

	@Parameters({"colKey","colValue"})
	@Test(priority = 145, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void CompareValidWithReview(String colKey,String colValue) throws Throwable
	{
		reviewPage.compareValidAndReview(colKey,colValue);

	}


	@Test(priority = 146)
	public void edit() throws Throwable
	{
		reviewPage.editFunctionality();
		waitTillLoaderDisappears();
		Thread.sleep(1000);

	}

	
	@Test(priority = 147)
	public void QTRcheckTest() throws Throwable
	{
		reviewPage.QTRcheck();
		waitTillLoaderDisappears();
		Thread.sleep(1000);

	}
	

	@Test(priority = 148)
	public void ApplicationAffidavitTest() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(1000);
		reviewPage.ApplicationAffidavit();
	}
	@Test(priority = 149)
	public void AcknowledgementTest() throws Throwable
	{
		Thread.sleep(1000);
		reviewPage.Acknowledgement();
	}
	
	@Test(priority = 150)
	public void ABOR_RandomChoiceTest() throws Throwable
	{
		Thread.sleep(1000);
		reviewPage.ABOR_RandomChoice();
	}
	
	
	
	@Test(priority = 151)
	public void ApplicationFee_VisaTest() throws Throwable
	{
		reviewPage.ApplicationFee_Visa();
	}

	@Test(priority = 152)
	public void ApplicationFee_MasterCardTest() throws Throwable
	{
		reviewPage.ApplicationFee_MasterCard();
	}
	@Test(priority = 153)
	public void ApplicationFee_DiscoverTest() throws Throwable
	{
		reviewPage.ApplicationFee_Discover();
	}

	@Test(priority = 154)
	public void ApplicationFee_PayLaterTest() throws Throwable
	{
		reviewPage.ApplicationFee_PayLater();
	}
	
	@Test(priority = 154)
	public void ApplicationFee_WaiverTest() throws Throwable
	{
		reviewPage.ApplicationFee_Waiver();
	}
	
	@Test(priority = 155)
	public void DupAppReviewCheckTest() throws Throwable
	{
		reviewPage.DupAppReviewCheck();
	}
	
	
	@Test(priority = 155)
	public void RandomPaymentMtd_Waiver_ABORTest() throws Throwable
	{
		reviewPage.RandomPaymentMtd_Waiver_ABOR();
	}
	
}


























