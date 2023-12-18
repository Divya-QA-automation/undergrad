//package com.ugapp.testcases;
//
//
//import java.util.Hashtable;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.SkipException;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.ugapp.base.Page;
//import com.ugapp.pages.NeedHelpPage;
//import com.ugapp.pages.PreAppDashboardPage;
//import com.ugapp.utilities.Utilities;
//
//
//public class TC_08_PreAppDashboardTest extends Page{
//
//
//	NeedHelpPage NeedHelp = new NeedHelpPage();
//
//
//
//
//	@Test(priority = 1, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void validatePreAppSubmissionPage() throws Throwable
//	{
//		//check for the url of pre app submission page	
//		PreAppDashboardPage.validatePreAppPage();
//	}
//
//
//
//
//	@Test(priority = 2, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void NeedHelpTest() throws Throwable
//	{
//		PreAppDashboardPage.IfIncorrectClickhereLink();
//		Thread.sleep(5000);
//		NeedHelp.ValidateNeedhelp();
//		NeedHelp.checkAndValidateEmail();
//		NeedHelp.checkAndValidateEnrollmentSupportPhone();
//		NeedHelp.checkAndValidateTechnicalSupportPhone();
//		NeedHelp.CloseNeedhelpPreApp();
//	}
//
//
//
//	@Test(priority = 3 , dataProviderClass = Utilities.class, dataProvider = "dp",groups = {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void PreAppDashboardTest(Hashtable<String, String> data) throws Throwable {
//		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
//			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
//		} else {
//			PreAppDashboardPage.userDetails(data.get("firstname"),data.get("preferredfirstname"), data.get("middlename"), data.get("lastname"));  
//			Thread.sleep(2000);
//			PreAppDashboardPage.validateUserDetails(data.get("firstname"),data.get("preferredfirstname"), data.get("middlename"), data.get("lastname"));
//			Thread.sleep(2000);
//		}
//	}
//
//
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 4, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void PreAppDashboardElements(String colKey,String colValue) throws Throwable
//	{
//		//valid user details
//		PreAppDashboardPage.validuser(colKey,colValue);
//		//scroll
//		PreAppDashboardPage.scroll();
//		//check the optional tag
//		PreAppDashboardPage.checkOptionalTag();
//		//verify suffix dropdown
//		PreAppDashboardPage.verifySuffixDropdown();
//		//verify Suffix clear button
//		PreAppDashboardPage.verifySuffixClear();
//		//Verify 12 months
//		PreAppDashboardPage.verifyMonths();
//		//verify no of days
//		PreAppDashboardPage.verifyDaysPresent();
//		//verify years present
//		PreAppDashboardPage.verifyYearsPresent();
//		//verify the clear button on month , year and day
//		PreAppDashboardPage.verifyClearButton();
//		//validate Error message when cleared birth day
//		PreAppDashboardPage.validateErrorMessage();
//	}
//	
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 5, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void BirthdayAge_Greater24Test(String colKey,String colValue) throws Throwable
//	{
//		PreAppDashboardPage.BirthdayAge_Greater24(colKey,colValue);
//	}
//
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 6,groups={"18=>24_NonUS_Res_Veteran_PastGrad_OOS"})
//	public void BirthdayAge_Btn18_24Test(String colKey,String colValue) throws Throwable
//	{
//		PreAppDashboardPage.BirthdayAge_Btn18_24(colKey,colValue);
//	}
//
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 7 , groups={"24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void BirthdayAge_24Test(String colKey,String colValue) throws Throwable
//	{
//		PreAppDashboardPage.BirthdayAge_24(colKey,colValue);
//	}
//	
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 8, groups={"Lessthan18_US_Res_ActiveDuty_AZ"})
//	public void BirthdayAge_Less18Test(String colKey,String colValue) throws Throwable
//	{
//		PreAppDashboardPage.BirthdayAge_Less18(colKey,colValue);
//	}
//	
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 9, groups={"18yr_NonUS_NonRes_F1/J1/JN"})
//	public void BirthdayAge_18Test(String colKey,String colValue) throws Throwable
//	{
//		PreAppDashboardPage.BirthdayAge_18(colKey,colValue);
//	}
//	
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 10 , groups={"RandomAge_randomVisaType"})
//	public void Birthday_Random(String colKey,String colValue) throws InterruptedException
//	{
//		PreAppDashboardPage.randomBirthday();
//	}
//
//
//
//	@Test(priority = 11, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void StartNewAppTest() throws Throwable
//	{
//		//click Start new App
//		PreAppDashboardPage.startNewAppbutton();
//	}
//}
//
//
//
//
