package com.ugapp.testcases;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.EncryptedDocumentException;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.ugapp.base.Page;
import com.ugapp.pages.MyInformationPage;
import com.ugapp.pages.NeedHelpPage;
import com.ugapp.utilities.Utilities;


public class TC_09_MyInformationPageTest extends Page
{
	MyInformationPage MyInfo = new MyInformationPage();
	NeedHelpPage NeedHelp = new NeedHelpPage();

	@Test(priority = 1)
	public void validateMyInfoPage() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(3000);
		MyInfo.ValidateForMyInfo();
		Thread.sleep(2000);
	}

	//@Test(priority = 2)
	public void requiredErrorMesssage() throws Throwable
	{
		MyInfo.requiredFields();
	}



	//@Test(priority = 3)
	public void validateNeedhelpform() throws Throwable
	{
		Thread.sleep(1000);
		NeedHelp.OpenNeedhelp();
		Thread.sleep(500);
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
		Thread.sleep(2000);
		NeedHelp.CloseNeedhelp();
	}





	//@Test(priority = 4 , dataProviderClass = Utilities.class, dataProvider = "dp")
	public void FormerNameTest(Hashtable<String, String> data) throws Throwable {
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			MyInfo.FormerName(data.get("First_name"),data.get("Last_name"));  
			Thread.sleep(1000);
			MyInfo.ValidateFormerName(data.get("First_name"),data.get("Last_name"));  
			Thread.sleep(1000);
		}
	}


	//@Test(priority = 5)
	public void ValidateFormerNames()
	{
		MyInfo.ValidateAddedFormerNames();
	}



	//@Test(priority = 6)
	public void Edit_CancelFormerNameTest() throws InterruptedException
	{
		MyInfo.Edit_CancelFormerName();
	}

	//@Test(priority = 7)
	public void Edit_SaveFormerNameTest() throws InterruptedException
	{
		MyInfo.Edit_SaveFormerName();
	}

	//@Test(priority = 8)
	public void DeleteFormerNameTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		MyInfo.DeleteAddedFormerNames();

		//get the valid former names
		MyInfo.validFormer();
	}

	//@Test(priority = 9)
	public void chooseLegalsexTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		MyInfo.chooseLegalSex();
	}
	//@Test(priority = 10)
	public void ProfileLinkTest()
	{
		MyInfo.ValidateProfileLink();
	}
	//@Test(priority = 11)
	public void PrimaryLangTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		MyInfo.ChoosePrimageLanguage();
	}
	//@Test(priority = 12)
	public void HomeAddress() throws Throwable
	{
		MyInfo.HomeAddAndPhone();
	}


	//@Test(priority = 13 , dataProviderClass = Utilities.class, dataProvider = "dp")
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



	//	@Test(priority = 14)
	public void EthnicityBackgroundTest() throws InterruptedException
	{
		MyInfo.EthnicityBackground();
	}
	//	@Test(priority = 15)
	public void RacialBackgroundTest() throws InterruptedException
	{
		MyInfo.RacialBackground();
	}

	//@Test(priority = 16)
	public void US_CitizenshipTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		MyInfo.US_Citizenship();
	}


	//@Test(priority = 17 , dataProviderClass = Utilities.class, dataProvider = "dp")
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

	//	@Test(priority = 18)
	public void ValidateParentNames() throws Throwable
	{
		MyInfo.ValidateAddedParentNames();
	}

	//	@Test(priority = 19)
	public void Previous_ASU_affiliationTest() throws InterruptedException, IOException
	{
		MyInfo.Previous_ASU_affiliation();
	}
	//@Test(priority = 20)
	public void ASU_affiliate_IDTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		MyInfo.ASU_affiliate_ID();
	}
	//	@Test(priority = 21)
	public void US_Uniformed_Services_MilitaryTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		MyInfo.US_Uniformed_Services_Military();
	}
	@Test(priority = 22)
	public void Partner_benefitsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		MyInfo.Partner_benefits();
	}
	//	@Test(priority = 23)
	public void FloatingNeedHelp() throws InterruptedException
	{
		NeedHelp.validateFooterNeedHelp();
		Thread.sleep(1000);
		NeedHelp.ValidateFooterNeedhelpTitle();
		Thread.sleep(1000);
		NeedHelp.CloseFloatingNeedhelp();
	}
	//@Test(priority = 24)
	public void SavePageTest() throws InterruptedException
	{
		Thread.sleep(2000);
		MyInfo.SaveThePage();
		Thread.sleep(3000);
	}

}

