//
//package com.ugapp.testcases;
//import java.util.Hashtable;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.openqa.selenium.WebDriver;
//import org.testng.SkipException;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.ugapp.base.Page;
//import com.ugapp.pages.MyInformationPage;
//import com.ugapp.pages.NeedHelpPage;
//import com.ugapp.utilities.Utilities;
//public class TC_09_MyInformationPageTest extends BaseTest
//{
//	MyInformationPage MyInfo = new MyInformationPage();
//	NeedHelpPage NeedHelp = new NeedHelpPage();
//	@Test(priority = 1, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void validateMyInfoPage() throws Throwable
//	{
//		waitTillLoaderDisappears();
//		Thread.sleep(3000);
//		MyInfo.ValidateForMyInfo();
//		Thread.sleep(1000);
//	}
//	@Test(priority = 2, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void requiredErrorMesssage() throws Throwable
//	{
//		MyInfo.requiredFields();
//	}
//	@Test(priority = 3, groups = {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void validateNeedhelpform() throws Throwable
//	{
//		waitTillLoaderDisappears();
//		Thread.sleep(3000);
//		NeedHelp.OpenNeedhelp();
//		Thread.sleep(1000);
//		NeedHelp.ValidateNeedhelp();
//		Thread.sleep(500);
//		NeedHelp.checkAndValidateEmail();
//		Thread.sleep(500);
//		NeedHelp.checkAndValidateEnrollmentSupportPhone();
//		Thread.sleep(500);
//		NeedHelp.checkAndValidateTechnicalSupportPhone();
//		Thread.sleep(500);
//		NeedHelp.SelectRequest();
//		Thread.sleep(500);
//		NeedHelp.AdditionalInfo();
//		Thread.sleep(500);
//		NeedHelp.SubmitHelpRequest();
//		Thread.sleep(1000);
//		//		NeedHelp.ValidateHelpRequest();
//		Thread.sleep(1000);
//		NeedHelp.CloseNeedhelp();
//	}
//
//
//
//
//	@Test(priority = 4 , dataProviderClass = Utilities.class, dataProvider = "dp", groups = {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void FormerNameTest(Hashtable<String, String> data) throws Throwable {
//		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
//			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
//		} else {
//			MyInfo.FormerName(data.get("First_name"),data.get("Last_name"));
//			Thread.sleep(1000);
//			MyInfo.ValidateFormerName(data.get("First_name"),data.get("Last_name"));
//			Thread.sleep(1000);
//		}
//	}
//	@Test(priority = 5, groups = {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void ValidateFormerNames()
//	{
//		MyInfo.ValidateAddedFormerNames();
//	}
//	@Test(priority = 6, groups = {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void Edit_CancelFormerNameTest() throws InterruptedException
//	{
//		MyInfo.Edit_CancelFormerName();
//	}
//	@Test(priority = 7, groups = {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void Edit_SaveFormerNameTest() throws InterruptedException
//	{
//		MyInfo.Edit_SaveFormerName();
//	}
//
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 8, groups = {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void DeleteFormerNameTest(String colKey,String colValue) throws Exception
//	{
//		MyInfo.DeleteAddedFormerNames();
//		//get the valid former names
//		MyInfo.validFormer(colKey,colValue);
//	}
//
//
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 9, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void chooseLegalsexTest(String colKey,String colValue) throws Exception
//	{
//		MyInfo.chooseLegalSex(colKey,colValue);
//	}
//	@Test(priority = 10, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void ProfileLinkTest()
//	{
//		MyInfo.ValidateProfileLink();
//	}
//
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 11, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void PrimaryLangTest(String colKey,String colValue) throws Exception
//	{
//		MyInfo.ChoosePrimageLanguage(colKey,colValue);
//	}
//	@Test(priority = 12, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void HomeAddress() throws Throwable
//	{
//		MyInfo.HomeAddAndPhone();
//	}
//	@Test(priority = 13 , dataProviderClass = Utilities.class, dataProvider = "dp", groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void HomeAddressTest(Hashtable<String, String> data) throws Throwable {
//		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
//			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
//		} else {
//			MyInfo.address(data.get("AddressLine1"),data.get("AddressLine2"),data.get("City"),data.get("Zip"),data.get("State"),data.get("Phone_Number"),data.get("Mobile_Number"));
//			Thread.sleep(1000);
//			MyInfo.validateAddress(data.get("AddressLine1"),data.get("AddressLine2"),data.get("City"),data.get("Zip"),data.get("State"),data.get("Phone_Number"),data.get("Mobile_Number"));
//			Thread.sleep(1000);
//		}
//	}
//
//	
//	
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 14, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void EthnicityBackgroundTest(String colKey,String colValue) throws EncryptedDocumentException, Exception
//	{
//		MyInfo.EthnicRacialbackground(colKey,colValue);
//	}
//
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 15, groups = {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","Lessthan18_US_Res_ActiveDuty_AZ"})
//	public void US_CitizenshipTest(String colKey,String colValue) throws Exception
//	{
//		MyInfo.US_Citizenship(colKey,colValue);
//	}
//	
//
//	// Select Not a US Citizen
//		@Test(priority = 16 , groups={"18=>24_NonUS_Res_Veteran_PastGrad_OOS","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//		public void Not_US_Citizenship() throws InterruptedException
//		{
//			MyInfo.NotUSctizenship();
//		}
//
//	// Select either Permanent Resident or Refugee [Not a US Citizen but a Resident]
//		@Parameters({"colKey","colValue"})
//		@Test(priority = 17 , groups={"18=>24_NonUS_Res_Veteran_PastGrad_OOS","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//		public void Visa_Type(String colKey,String colValue) throws EncryptedDocumentException, Exception
//		{
//			MyInfo.visaType(colKey,colValue);
//		}
//
//	@Test(priority = 18 , dataProviderClass = Utilities.class, dataProvider = "dp", groups = {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void ParentNameTest(Hashtable<String, String> data) throws Throwable {
//		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
//			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
//		} else {
//			MyInfo.ParentName(data.get("First_name"),data.get("Last_name"));
//			Thread.sleep(1000);
//			MyInfo.ValidateParentName(data.get("First_name"),data.get("Last_name"));
//			Thread.sleep(1000);
//		}
//	}
//
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 19, groups = {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void ValidateParentNames(String colKey,String colValue) throws Throwable
//	{
//		MyInfo.ValidateAddedParentNames();
//		Thread.sleep(1000);
//		MyInfo.ParentNames(colKey,colValue);
//	}
//
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 20, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void Previous_ASU_affiliationTest(String colKey,String colValue) throws EncryptedDocumentException, Exception
//	{
//		MyInfo.Previous_ASU_affiliation(colKey,colValue);
//	}
//
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 21, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void ASU_affiliate_IDTest(String colKey,String colValue) throws Exception
//	{
//		MyInfo.ASU_affiliate_ID(colKey,colValue);
//	}
//	
//	
//// 1st flow
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 22, groups = {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void SpouseOrDependent_MilitaryTest(String colKey,String colValue) throws Exception
//	{
//		MyInfo.SpouseOrDependent_Military(colKey,colValue);
//	}
//
//
//	// 3rd flow
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 23, groups = {"Lessthan18_US_Res_ActiveDuty_AZ"})
//	public void ActiveDuty_MilitaryTest(String colKey,String colValue) throws Exception
//	{
//		MyInfo.ActiveDuty_Military(colKey,colValue);
//	}
//
//// 2nd flow
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 24, groups ={"18=>24_NonUS_Res_Veteran_PastGrad_OOS"})
//	public void Veteran_MilitaryTest(String colKey,String colValue) throws Exception
//	{
//		MyInfo.Veteran_Military(colKey,colValue);
//	}
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 25, groups = {"18yr_NonUS_NonRes_F1/J1/JN"})
//	public void NoneOfTheseApply_MilitaryTest(String colKey,String colValue) throws Exception
//	{
//		MyInfo.NoneOfTheseApply_Military(colKey,colValue);
//	}
//	@Test(priority = 26, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	@Parameters({"colKey","colValue"})
//	public void Partner_benefitsTest(String colKey,String colValue) throws Exception
//	{
//		MyInfo.Partner_benefits(colKey,colValue);
//	}
//
//
//	@Test(priority = 27, groups = {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void FloatingNeedHelp() throws InterruptedException
//	{
//		NeedHelp.validateFooterNeedHelp();
//		Thread.sleep(1000);
//		NeedHelp.ValidateFooterNeedhelpTitle();
//		Thread.sleep(1000);
//		NeedHelp.CloseFloatingNeedhelp();
//	}
//	
//	
//
//
////  4th flow
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 28 , groups={"24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void ArmedForceReserveOrNationalGuardian_MilitaryTest(String colKey,String colValue) throws EncryptedDocumentException, Exception
//	{
//		MyInfo.ArmedForceReserveOrNationalGuardian_Military(colKey,colValue);
//	}
//
//
//
//	@Test(priority = 29, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void SavePageTest() throws InterruptedException
//	{
//		Thread.sleep(2000);
//		MyInfo.SaveThePage();
//		Thread.sleep(3000);
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
