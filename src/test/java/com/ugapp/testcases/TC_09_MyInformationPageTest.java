package com.ugapp.testcases;
import java.util.Hashtable;

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
	
	
	@Test(priority = 2)
	public void validateMyInfoPage() throws InterruptedException
	{
		Thread.sleep(2000);
		MyInfo.ValidateForMyInfo();
		Thread.sleep(2000);
	}



	@Test(priority = 3 , dataProviderClass = Utilities.class, dataProvider = "dp")
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


	@Test(priority = 4)
	public void ValidateFormerNames()
	{
		MyInfo.ValidateAddedFormerNames();
	}



	@Test(priority = 5)
	public void Edit_CancelFormerNameTest() throws InterruptedException
	{
		MyInfo.Edit_CancelFormerName();
	}

	@Test(priority = 6)
	public void Edit_SaveFormerNameTest() throws InterruptedException
	{
		MyInfo.Edit_SaveFormerName();
	}

	@Test(priority = 7)
	public void DeleteFormerNameTest() throws InterruptedException
	{
		MyInfo.DeleteAddedFormerNames();
	}

	@Test(priority = 8)
	public void chooseLegalsexTest() throws InterruptedException
	{
		MyInfo.chooseLegalSex();
	}
	@Test(priority = 9)
	public void ProfileLinkTest()
	{
		MyInfo.ValidateProfileLink();
	}
	@Test(priority = 10)
	public void PrimaryLangTest() throws InterruptedException
	{
		MyInfo.ChoosePrimageLanguage();
	}
	@Test(priority = 11)
	public void HomeAddress() throws Throwable
	{
		MyInfo.HomeAddAndPhone();
	}
	
	
	@Test(priority = 12 , dataProviderClass = Utilities.class, dataProvider = "dp")
	public void HomeAddressTest(Hashtable<String, String> data) throws Throwable {
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			MyInfo.address(data.get("AddressLine1"),data.get("AddressLine2"),data.get("City"),data.get("Zip"));
			Thread.sleep(1000);
		}
	}



//	@Test(priority = 11)
	public void EthnicityBackgroundTest() throws InterruptedException
	{
		MyInfo.EthnicityBackground();
	}
//	@Test(priority = 12)
	public void RacialBackgroundTest() throws InterruptedException
	{
		MyInfo.RacialBackground();
	}

//	@Test(priority = 13)
	public void US_CitizenshipTest() throws InterruptedException
	{
		MyInfo.US_Citizenship();
	}
//	@Test(priority = 14 , dataProviderClass = Utilities.class, dataProvider = "dp")
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
	
	@Test(priority = 15)
	public void ValidateParentNames()
	{
		MyInfo.ValidateAddedParentNames();
	}
	
	@Test(priority = 16)
	public void Previous_ASU_affiliationTest() throws InterruptedException
	{
		MyInfo.Previous_ASU_affiliation();
	}
	@Test(priority = 17)
	public void ASU_affiliate_IDTest() throws InterruptedException
	{
		MyInfo.ASU_affiliate_ID();
	}
	@Test(priority = 18)
	public void US_Uniformed_Services_MilitaryTest() throws InterruptedException
	{
		MyInfo.US_Uniformed_Services_Military();
	}
}

