package com.ugapp.testcases;


import java.util.Hashtable;


import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ugapp.utilities.Utilities;
import com.ugapp.base.Page;
import com.ugapp.pages.PreAppDashboardPage;
import com.ugapp.pages.NeedHelpPage;


public class TC_08_PreAppDashboardTest extends Page{


	NeedHelpPage NeedHelp = new NeedHelpPage();




	//	@Test(priority = 1)
	public void validatePreAppSubmissionPage()
	{
		//check for the url of pre app submission page	
		PreAppDashboardPage.validatePreAppPage();
	}




	@Test(priority = 2)
	public void NeedHelpTest() throws Throwable
	{
		PreAppDashboardPage.IfIncorrectClickhereLink();
		Thread.sleep(500);
		NeedHelp.ValidateNeedhelp();
		NeedHelp.checkAndValidateEmail();
		NeedHelp.checkAndValidateEnrollmentSupportPhone();
		NeedHelp.checkAndValidateTechnicalSupportPhone();
		NeedHelp.CloseNeedhelpPreApp();
	}












	@Test(priority = 3 , dataProviderClass = Utilities.class, dataProvider = "dp")
	public void PreAppDashboardTest(Hashtable<String, String> data) throws Throwable {
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			PreAppDashboardPage.userDetails(data.get("firstname"),data.get("preferredfirstname"), data.get("middlename"), data.get("lastname"));  
			Thread.sleep(2000);
			PreAppDashboardPage.validateUserDetails(data.get("firstname"),data.get("preferredfirstname"), data.get("middlename"), data.get("lastname"));
			Thread.sleep(2000);
		}
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 4)
	public void PreAppDashboardElements(String colKey,String colValue) throws Throwable
	{
		//valid user details
		PreAppDashboardPage.validuser(colKey,colValue);
		//scroll
		PreAppDashboardPage.scroll();
		//check the optional tag
		PreAppDashboardPage.checkOptionalTag();
		//verify suffix dropdown
		PreAppDashboardPage.verifySuffixDropdown();
		//verify Suffix clear button
		PreAppDashboardPage.verifySuffixClear();
		//Verify 12 months
		PreAppDashboardPage.verifyMonths();
		//verify no of days
		PreAppDashboardPage.verifyDaysPresent();
		//verify years present
		PreAppDashboardPage.verifyYearsPresent();
		//verify the clear button on month , year and day
		PreAppDashboardPage.verifyClearButton();
		//validate Error message when cleared birth day
		PreAppDashboardPage.validateErrorMessage();
	}	
	//			@Test(priority = 5)
	public void BirthdayAge_Greater24Test() throws Throwable
	{
		//select valid birthday
		PreAppDashboardPage.BirthdayAge_Greater24();
	}
	//			@Test(priority = 6)
	public void BirthdayAge_Btn18_24Test() throws Throwable
	{
		//select valid birthday
		PreAppDashboardPage.BirthdayAge_Btn18_24();
	}
	//			@Test(priority = 7)
	public void BirthdayAge_24Test() throws Throwable
	{
		//check for the url of pre app submission page
		PreAppDashboardPage.BirthdayAge_24();
	}
	//			@Test(priority = 8)
	public void BirthdayAge_Less18Test() throws Throwable
	{
		//check for the url of pre app submission page
		PreAppDashboardPage.BirthdayAge_Less18();
	}
	//			@Test(priority = 9)
	public void StartNewAppTest() throws Throwable
	{
		//click Start new App
		PreAppDashboardPage.startNewAppbutton();
	}
}




