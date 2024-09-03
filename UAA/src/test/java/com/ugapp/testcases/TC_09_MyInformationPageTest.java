
package com.ugapp.testcases;
import org.testng.annotations.Test;

import com.ugapp.base.Page;
import com.ugapp.pages.MyInformationPage;
import com.ugapp.pages.NeedHelpPage;
import com.ugapp.utilities.Utilities;

import java.util.Hashtable;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class TC_09_MyInformationPageTest extends BaseTest
{
	MyInformationPage MyInfo = new MyInformationPage();
	NeedHelpPage NeedHelp = new NeedHelpPage();
	@Test(priority = 30)
	public void validateMyInfoPage() throws Throwable
	{
		MyInfo.ValidateForMyInfo();
	}
	@Test(priority = 31)
	public void requiredErrorMesssage() throws Throwable
	{
		MyInfo.requiredFields();
	}
	@Test(priority = 32)
	public void validateNeedhelpform() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(3000);
		NeedHelp.OpenNeedhelp();
		Thread.sleep(1000);
		NeedHelp.ValidateNeedhelp();
		Thread.sleep(500);
		NeedHelp.checkAndValidateEmail();
		Thread.sleep(500);
		NeedHelp.checkAndValidateEnrollmentSupportPhone();
		Thread.sleep(500);
		NeedHelp.checkAndValidateTechnicalSupportPhone();
		Thread.sleep(500);
		NeedHelp.SelectRequest();
		Thread.sleep(500);
		NeedHelp.AdditionalInfo();
		Thread.sleep(500);
		NeedHelp.SubmitHelpRequest();
		Thread.sleep(1000);
		NeedHelp.ValidateHelpRequest();
		Thread.sleep(1000);
		NeedHelp.CloseNeedhelp();
		Thread.sleep(3000);
	}




	@Test(priority = 33, dataProviderClass = Utilities.class, dataProvider = "dp")
	public void FormerNameTest(Hashtable<String, String> data) throws Throwable {
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			MyInfo.FormerName(data.get("First_name"),data.get("Last_name"));
			MyInfo.ValidateFormerName(data.get("First_name"),data.get("Last_name"));
		}
	}
	@Test(priority = 34)
	public void ValidateFormerNames()
	{
		MyInfo.ValidateAddedFormerNames();
	}
	@Test(priority = 35)
	public void Edit_CancelFormerNameTest() throws InterruptedException
	{
		MyInfo.Edit_CancelFormerName();
	}
	@Test(priority = 36)
	public void Edit_SaveFormerNameTest() throws InterruptedException
	{
		MyInfo.Edit_SaveFormerName();
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 37)
	public void DeleteFormerNameTest(String colKey,String colValue) throws Exception
	{
		MyInfo.DeleteAddedFormerNames();
		//get the valid former names
		MyInfo.validFormer(colKey,colValue);
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 38)
	public void chooseLegalsexTest(String colKey,String colValue) throws Throwable
	{
		MyInfo.chooseLegalSex(colKey,colValue);
	}
	@Test(priority = 39)
	public void ProfileLinkTest()
	{
		MyInfo.ValidateProfileLink();
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 40)
	public void PrimaryLangTest(String colKey,String colValue) throws Exception
	{
		MyInfo.ChoosePrimageLanguage(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 41)
	public void Random_HomeaddressAndPhoneTest(String colKey,String colValue) throws Exception
	{
		MyInfo.Random_HomeaddressAndPhone(colKey,colValue);
	}
	
	@Test(priority = 42)
	public void HomeAddress() throws Throwable
	{
		MyInfo.HomeAddAndPhone();
	}
	@Test(priority = 43, dataProviderClass = Utilities.class, dataProvider = "dp")
	public void HomeAddressTest(Hashtable<String, String> data) throws Throwable {
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			MyInfo.address(data.get("AddressLine1"),data.get("AddressLine2"),data.get("City"),data.get("Zip"),data.get("State"),data.get("Phone_Number"),data.get("Mobile_Number"));
			Thread.sleep(1000);
			MyInfo.validateAddress(data.get("AddressLine1"),data.get("AddressLine2"),data.get("City"),data.get("Zip"),data.get("State"),data.get("Phone_Number"),data.get("Mobile_Number"));
			Thread.sleep(1000);
		}
	}

	
	@Parameters({"colKey","colValue"})
	@Test(priority = 44)
	public void EthnicityBackgroundTest(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		MyInfo.EthnicRacialbackground(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 45)
	public void US_CitizenshipTest(String colKey,String colValue) throws Exception
	{
		MyInfo.US_Citizenship(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 46)
	public void DupApp_US_CitizenshipTest(String colKey,String colValue) throws Exception
	{
		MyInfo.DupApp_US_Citizenship(colKey,colValue);
	}
	
	// Select Not a US Citizen
	@Test(priority = 47)
	public void Not_US_Citizenship() throws InterruptedException
	{
		MyInfo.NotUSctizenship();
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 48)
	public void Random_CitizenshipTest(String colKey,String colValue) throws Exception
	{
		MyInfo.Random_Citizenship(colKey,colValue);
	}
	
	

	// 6th flow
	// Select either F-1 / J-1 /JN [Not a US Citizen & Non-Resident]
	@Parameters({"colKey","colValue"})
	@Test(priority = 49)
	public void visaType_F1_J1_JNTest(String colKey,String colValue) throws Throwable
	{
		MyInfo.visaType_F1_J1_JN(colKey,colValue);
	}



	// Select either Permanent Resident or Refugee [Not a US Citizen but a Resident]
	@Parameters({"colKey","colValue"})
	@Test(priority = 50)
	public void visaType_PermResRefugeeTest(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		MyInfo.visaType_PermResRefugee(colKey,colValue);
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 51)
	public void visaType_DACA_UDTest(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		MyInfo.visaType_DACA_UD(colKey,colValue);
	}



	@Test(priority = 52, dataProviderClass = Utilities.class, dataProvider = "dp")
	public void ParentNameTest(Hashtable<String, String> data) throws Throwable {
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			MyInfo.ParentName(data.get("First_name"),data.get("Last_name"));
			Thread.sleep(1000);
			MyInfo.ValidateParentName(data.get("First_name"),data.get("Last_name"));
			Thread.sleep(1000);
		}
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 53)
	public void ValidateParentNames(String colKey,String colValue) throws Throwable
	{
		MyInfo.ValidateAddedParentNames();
		Thread.sleep(1000);
		MyInfo.ParentNames(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 54)
	public void Previous_ASU_affiliationTest(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		MyInfo.Previous_ASU_affiliation(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 55)
	public void ASU_affiliate_IDTest(String colKey,String colValue) throws Exception
	{
		MyInfo.ASU_affiliate_ID(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 56)
	public void DupApp_ASU_affiliate_IDTest(String colKey,String colValue) throws Exception
	{
		MyInfo.DupApp_ASU_affiliate_ID(colKey,colValue);
	}
	
	// 1st flow
	@Parameters({"colKey","colValue"})
	@Test(priority = 57)
	public void SpouseOrDependent_MilitaryTest(String colKey,String colValue) throws Exception
	{
		MyInfo.SpouseOrDependent_Military(colKey,colValue);
	}


	// 3rd flow
	@Parameters({"colKey","colValue"})
	@Test(priority = 58)
	public void ActiveDuty_MilitaryTest(String colKey,String colValue) throws Exception
	{
		MyInfo.ActiveDuty_Military(colKey,colValue);
	}

	// 2nd flow
	@Parameters({"colKey","colValue"})
	@Test(priority = 59)
	public void Veteran_MilitaryTest(String colKey,String colValue) throws Exception
	{
		MyInfo.Veteran_Military(colKey,colValue);
	}
	@Parameters({"colKey","colValue"})
	@Test(priority = 60)
	public void NoneOfTheseApply_MilitaryTest(String colKey,String colValue) throws Exception
	{
		MyInfo.NoneOfTheseApply_Military(colKey,colValue);
	}

	//	 4th flow
	@Parameters({"colKey","colValue"})
	@Test(priority = 61)
	public void ArmedForceReserveOrNationalGuardian_MilitaryTest(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		MyInfo.ArmedForceReserveOrNationalGuardian_Military(colKey,colValue);
	}




	@Test(priority = 62)
	@Parameters({"colKey","colValue"})
	public void Partner_benefitsTest(String colKey,String colValue) throws Exception
	{
		MyInfo.Partner_benefits(colKey,colValue);
	}


	@Test(priority = 63)
	public void FloatingNeedHelp() throws InterruptedException
	{
		NeedHelp.validateFooterNeedHelp();
		Thread.sleep(1000);
		NeedHelp.ValidateFooterNeedhelpTitle();
		Thread.sleep(1000);
		NeedHelp.CloseFloatingNeedhelp();
	}


	@Test(priority = 64)
	public void SavePageTest() throws InterruptedException
	{
		Thread.sleep(2000);
		MyInfo.SaveThePage();
		Thread.sleep(3000);
	}

}














