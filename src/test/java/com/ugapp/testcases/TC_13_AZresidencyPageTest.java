package com.ugapp.testcases;








import org.testng.annotations.Parameters;
import org.testng.annotations.Test;








import com.ugapp.pages.AZResidencyPage;








public class TC_13_AZresidencyPageTest extends BaseTest
{
	AZResidencyPage AZ = new AZResidencyPage();


	@Test(priority = 1)
	public void validateMyInfoPage() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(1000);
		AZ.validateAZresidencyPage();
		Thread.sleep(1000);
	}






	@Parameters({"colKey","colValue"})
	@Test(priority = 2)
	public void PermanentHomeTest(String colKey,String colValue) throws Throwable
	{
		AZ.PermanentHome(colKey,colValue);
	}






	@Parameters({"colKey","colValue"})
	@Test(priority = 3)
	public void EnrolledAnotherCollOrUniversityTest(String colKey,String colValue) throws Throwable
	{
		AZ.EnrolledAnotherCollOrUniversity(colKey,colValue);
	}




	@Parameters({"colKey","colValue"})
	@Test(priority = 4)
	public void EnrolledAtASUTest(String colKey,String colValue) throws Throwable
	{
		AZ.EnrolledAtASU(colKey,colValue);
	}




	@Parameters({"colKey","colValue"})
	@Test(priority = 5)
	public void DriverLicenseTest(String colKey,String colValue) throws Throwable
	{
		AZ.DriverLicense(colKey,colValue);
	}




	@Parameters({"colKey","colValue"})
	@Test(priority = 6)
	public void VehicleDetailsTest(String colKey,String colValue) throws Throwable
	{
		AZ.VehicleDetails(colKey,colValue);
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 7)
	public void StateTaxesTest(String colKey,String colValue) throws Throwable
	{
		AZ.StateTaxes(colKey,colValue);
	}




	@Parameters({"colKey","colValue"})
	@Test(priority = 8)
	public void FinancialSupportTest(String colKey,String colValue) throws Throwable
	{
		AZ.FinancialSupport(colKey,colValue);
	}






	@Parameters({"colKey","colValue"})
	@Test(priority = 9)
	public void OtherFinancialSupportTest(String colKey,String colValue) throws Throwable
	{
		AZ.OtherFinancialSupport(colKey,colValue);
	}




	@Parameters({"colKey","colValue"})
	@Test(priority = 10)
	public void EmploymentDetailsTest(String colKey,String colValue) throws Throwable
	{
		AZ.EmploymentDetails(colKey,colValue);
	}




	@Parameters({"colKey","colValue"})
	@Test(priority = 11)
	public void SpouseOrDependentflowTest(String colKey,String colValue) throws Throwable
	{
		AZ.SpouseOrDependentflow(colKey,colValue);
	}




	@Parameters({"colKey","colValue"})
	@Test(priority = 12)
	public void AmericanIndianOrAlaskaNAtiveTest(String colKey,String colValue) throws Throwable
	{
		AZ.AmericanIndianOrAlaskaNAtive(colKey,colValue);
	}




	@Parameters({"colKey","colValue"})
	@Test(priority = 13)
	public void ParentLegalGuardianDetailsTest(String colKey,String colValue) throws Throwable
	{
		AZ.ParentLegalGuardianDetails(colKey,colValue);
	}




	@Parameters({"colKey","colValue"})
	@Test(priority = 14)
	public void SpouseRelatedDetailsTest(String colKey,String colValue) throws Throwable
	{
		AZ.SpouseRelatedDetails(colKey,colValue);
	}






	@Test(priority = 15)
	public void SavePageTest() throws Throwable
	{
		Thread.sleep(1000);
		AZ.SaveThePage();
		Thread.sleep(2000);
	}
}






















