	
package com.ugapp.testcases;
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
		Thread.sleep(2000);
		MyInfo.ValidateForMyInfo();
		Thread.sleep(1000);
	}
	@Test(priority = 2)
	public void requiredErrorMesssage() throws Throwable
	{
		MyInfo.requiredFields();
	}
//	@Test(priority = 3)
	public void validateNeedhelpform() throws Throwable
	{
		//		scrollUp(driver, 1);
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
		//		NeedHelp.ValidateHelpRequest();
		Thread.sleep(1000);
		NeedHelp.CloseNeedhelp();
	}


	@Test(priority = 4 , dataProviderClass = Utilities.class, dataProvider = "dp")
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
	@Test(priority = 5)
	public void ValidateFormerNames()
	{
		MyInfo.ValidateAddedFormerNames();
	}
	@Test(priority = 6)
	public void Edit_CancelFormerNameTest() throws InterruptedException
	{
		MyInfo.Edit_CancelFormerName();
	}
	@Test(priority = 7)
	public void Edit_SaveFormerNameTest() throws InterruptedException
	{
		MyInfo.Edit_SaveFormerName();
	}
	@Test(priority = 8)
	public void DeleteFormerNameTest() throws Exception
	{
		MyInfo.DeleteAddedFormerNames();
		//get the valid former names
		MyInfo.validFormer();
	}
	@Test(priority = 9)
	public void chooseLegalsexTest() throws Exception
	{
		MyInfo.chooseLegalSex();
	}
	@Test(priority = 10)
	public void ProfileLinkTest()
	{
		MyInfo.ValidateProfileLink();
	}
	@Test(priority = 11)
	public void PrimaryLangTest() throws Exception
	{
		MyInfo.ChoosePrimageLanguage();
	}
	@Test(priority = 12)
	public void HomeAddress() throws Throwable
	{
		MyInfo.HomeAddAndPhone();
	}
	@Test(priority = 13 , dataProviderClass = Utilities.class, dataProvider = "dp")
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
	@Test(priority = 14)
	public void EthnicityBackgroundTest() throws EncryptedDocumentException, Exception
	{
		MyInfo.EthnicRacialbackground();
	}
	@Test(priority = 15)
	public void US_CitizenshipTest() throws Exception
	{
		MyInfo.US_Citizenship();
	}
	@Test(priority = 16 , dataProviderClass = Utilities.class, dataProvider = "dp")
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
	@Test(priority = 17)
	public void ValidateParentNames() throws Throwable
	{
		MyInfo.ValidateAddedParentNames();
		Thread.sleep(1000);
		MyInfo.ParentNames();
	}
	@Test(priority = 18)
	public void Previous_ASU_affiliationTest() throws EncryptedDocumentException, Exception
	{
		MyInfo.Previous_ASU_affiliation();
	}
	@Test(priority = 19)
	public void ASU_affiliate_IDTest() throws Exception
	{
		MyInfo.ASU_affiliate_ID();
	}
	@Test(priority = 20)
	public void US_Uniformed_Services_MilitaryTest() throws Exception
	{
		MyInfo.US_Uniformed_Services_Military();
	}
	@Test(priority = 21)
	public void Partner_benefitsTest() throws Exception
	{
		MyInfo.Partner_benefits();
	}
	@Test(priority = 22)
	public void FloatingNeedHelp() throws InterruptedException
	{
		NeedHelp.validateFooterNeedHelp();
		Thread.sleep(1000);
		NeedHelp.ValidateFooterNeedhelpTitle();
		Thread.sleep(1000);
		NeedHelp.CloseFloatingNeedhelp();
	}
	//@Test(priority = 23)
	public void SavePageTest() throws InterruptedException
	{
		Thread.sleep(2000);
		MyInfo.SaveThePage();
		Thread.sleep(3000);
	}
}






