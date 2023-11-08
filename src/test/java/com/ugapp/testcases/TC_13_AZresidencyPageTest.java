package com.ugapp.testcases;




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




	@Test(priority = 2)
	public void PermanentHomeTest() throws Throwable
	{
		AZ.PermanentHome();
	}




	@Test(priority = 3)
	public void EnrolledAnotherCollOrUniversityTest() throws Throwable
	{
		AZ.EnrolledAnotherCollOrUniversity();
	}

	@Test(priority = 4)
	public void EnrolledAtASUTest() throws Throwable
	{
		AZ.EnrolledAtASU();
	}
	@Test(priority = 5)
	public void DriverLicenseTest() throws Throwable
	{
		AZ.DriverLicense();
	}

	@Test(priority = 6)
	public void VehicleDetailsTest() throws Throwable
	{
		AZ.VehicleDetails();
	}
	@Test(priority = 7)
	public void StateTaxesTest() throws Throwable
	{
		AZ.StateTaxes();
	}
	@Test(priority = 8)
	public void FinancialSupportTest() throws Throwable
	{
		AZ.FinancialSupport();
	}

	@Test(priority = 9)
	public void OtherFinancialSupportTest() throws Throwable
	{
		AZ.OtherFinancialSupport();
	}

	@Test(priority = 10)
	public void EmploymentDetailsTest() throws Throwable
	{
		AZ.EmploymentDetails();
	}
	@Test(priority = 11)
	public void SpouseOrDependentflowTest() throws Throwable
	{
		AZ.SpouseOrDependentflow();
	}

	@Test(priority = 12)
	public void AmericanIndianOrAlaskaNAtiveTest() throws Throwable
	{
		AZ.AmericanIndianOrAlaskaNAtive();
	}

	@Test(priority = 13)
	public void ParentLegalGuardianDetailsTest() throws Throwable
	{
		AZ.ParentLegalGuardianDetails();
	}

	@Test(priority = 14)
	public void SpouseRelatedDetailsTest() throws Throwable
	{
		AZ.SpouseRelatedDetails();
	}
	@Test(priority = 15)
	public void SavePageTest() throws InterruptedException
	{
		Thread.sleep(1000);
		AZ.SaveThePage();
		Thread.sleep(2000);
	}
}










