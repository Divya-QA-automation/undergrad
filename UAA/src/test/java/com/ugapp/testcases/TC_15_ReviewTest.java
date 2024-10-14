package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.ReviewPage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;








public class TC_15_ReviewTest extends BaseTest{





	ReviewPage reviewPage = new ReviewPage();


	@Test(priority = 150)
	public void review() throws Throwable
	{
		
		reviewPage.validateReview();
	}






	@Parameters({"colKey","colValue"})
	@Test(priority = 151)
	public void writeReview(String colKey,String colValue) throws Throwable
	{	
		reviewPage.profileSection(colKey,colValue);
		reviewPage.myInfoSection(colKey,colValue);
		reviewPage.myProgramSection(colKey,colValue);
		reviewPage.mySchoolsSection(colKey,colValue);
		reviewPage.myHighSchoolGradesSection(colKey,colValue);
		reviewPage.arizonaResidencySection(colKey,colValue);


	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 152)
	public void CompareValidWithReview(String colKey,String colValue) throws Throwable
	{
		reviewPage.compareValidAndReview(colKey,colValue);

	}


	@Test(priority = 153)
	public void edit() throws Throwable
	{
		reviewPage.editFunctionality();
		waitTillLoaderDisappears();
		Thread.sleep(1000);

	}

	
	@Test(priority = 154)
	public void QTRcheckTest() throws Throwable
	{
		reviewPage.QTRcheck();
		waitTillLoaderDisappears();
		Thread.sleep(1000);

	}
	

	@Test(priority = 155)
	public void ApplicationAffidavitTest() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(1000);
		reviewPage.ApplicationAffidavit();
	}
	@Test(priority = 156)
	public void AcknowledgementTest() throws Throwable
	{
		Thread.sleep(1000);
		reviewPage.Acknowledgement();
	}
	
	@Test(priority = 157)
	public void ABOR_RandomChoiceTest() throws Throwable
	{
		Thread.sleep(1000);
		reviewPage.ABOR_RandomChoice();
	}
	
	
	
	@Test(priority = 158)
	public void ApplicationFee_VisaTest() throws Throwable
	{
		reviewPage.ApplicationFee_Visa();
	}

	@Test(priority = 159)
	public void ApplicationFee_MasterCardTest() throws Throwable
	{
		reviewPage.ApplicationFee_MasterCard();
	}
	@Test(priority = 160)
	public void ApplicationFee_DiscoverTest() throws Throwable
	{
		reviewPage.ApplicationFee_Discover();
	}

	@Test(priority = 161)
	public void ApplicationFee_PayLaterTest() throws Throwable
	{
		reviewPage.ApplicationFee_PayLater();
	}
	
	@Test(priority = 162)
	public void ApplicationFee_WaiverTest() throws Throwable
	{
		reviewPage.ApplicationFee_Waiver();
	}
	
	@Test(priority = 163)
	public void DupAppReviewCheckTest() throws Throwable
	{
		reviewPage.DupAppReviewCheck();
	}
	
	
	@Test(priority = 164)
	public void RandomPaymentMtd_Waiver_ABORTest() throws Throwable
	{
		reviewPage.RandomPaymentMtd_Waiver_ABOR();
	}
	
}


























