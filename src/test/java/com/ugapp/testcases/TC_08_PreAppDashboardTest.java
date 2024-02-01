package com.ugapp.testcases;


import org.testng.annotations.Test;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ugapp.base.Page;
import com.ugapp.pages.NeedHelpPage;
import com.ugapp.pages.PreAppDashboardPage;
import com.ugapp.utilities.Utilities;


public class TC_08_PreAppDashboardTest extends BaseTest{


	NeedHelpPage NeedHelp = new NeedHelpPage();
	PreAppDashboardPage preAppDashboardPage = new PreAppDashboardPage();



	@Test(priority = 16)
	public void validatePreAppSubmissionPage() throws Throwable
	{
		//check for the url of pre app submission page	
		preAppDashboardPage.validatePreAppPage();
	}




	@Test(priority = 17)
	public void NeedHelpTest() throws Throwable
	{
		preAppDashboardPage.IfIncorrectClickhereLink();
		Thread.sleep(5000);
		NeedHelp.ValidateNeedhelp();
		NeedHelp.checkAndValidateEmail();
		NeedHelp.checkAndValidateEnrollmentSupportPhone();
		NeedHelp.checkAndValidateTechnicalSupportPhone();
		NeedHelp.CloseNeedhelpPreApp();
	}



	@Test(priority = 18 ,dataProviderClass = Utilities.class, dataProvider = "dp")
	public void PreAppDashboardTest(Hashtable<String, String> data) throws Throwable {
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			preAppDashboardPage.userDetails(data.get("firstname"),data.get("preferredfirstname"), data.get("middlename"), data.get("lastname"));  
			Thread.sleep(2000);
			preAppDashboardPage.validateUserDetails(data.get("firstname"),data.get("preferredfirstname"), data.get("middlename"), data.get("lastname"));
			Thread.sleep(2000);
		}
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 19)
	public void PreAppDashboardElements(String colKey,String colValue) throws Throwable
	{
		//valid user details
		preAppDashboardPage.validuser(colKey,colValue);
		//scroll
		preAppDashboardPage.scroll();
		//check the optional tag
		preAppDashboardPage.checkOptionalTag();
		//verify suffix dropdown
		preAppDashboardPage.verifySuffixDropdown();
		//verify Suffix clear button
		preAppDashboardPage.verifySuffixClear();
		//Verify 12 months
		preAppDashboardPage.verifyMonths();
		//verify no of days
		preAppDashboardPage.verifyDaysPresent();
		//verify years present
		preAppDashboardPage.verifyYearsPresent();
		//verify the clear button on month , year and day
		preAppDashboardPage.verifyClearButton();
		//validate Error message when cleared birth day
		preAppDashboardPage.validateErrorMessage();
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 20)
	public void PreAppDashboardNames(String colKey,String colValue) throws Throwable
	{
		//valid user details
		preAppDashboardPage.validuser(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 21)
	public void BirthdayAge_Greater24Test(String colKey,String colValue) throws Throwable
	{
		preAppDashboardPage.BirthdayAge_Greater24(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 22)
	public void BirthdayAge_Btn18_24Test(String colKey,String colValue) throws Throwable
	{
		preAppDashboardPage.BirthdayAge_Btn18_24(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 23)
	public void BirthdayAge_24Test(String colKey,String colValue) throws Throwable
	{
		preAppDashboardPage.BirthdayAge_24(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 24)
	public void BirthdayAge_Less18Test(String colKey,String colValue) throws Throwable
	{
		preAppDashboardPage.BirthdayAge_Less18(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 25)
	public void BirthdayAge_18Test(String colKey,String colValue) throws Throwable
	{
		preAppDashboardPage.BirthdayAge_18(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 26)
	public void Birthday_Random(String colKey,String colValue) throws InterruptedException
	{
		preAppDashboardPage.randomBirthday();
	}



	@Test(priority = 27)
	public void StartNewAppTest() throws Throwable
	{
		//click Start new App
		preAppDashboardPage.startNewAppbutton();
	}
}




