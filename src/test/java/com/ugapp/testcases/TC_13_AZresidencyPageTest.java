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
	public void PermanentHome_OOSTest(String colKey,String colValue) throws Throwable
	{
		AZ.PermanentHome_OOS(colKey,colValue);
	}

	
	
	@Parameters({"colKey","colValue"})
//	@Test(priority = 3)
	public void PermanentHome_AZTest(String colKey,String colValue) throws Throwable
	{
		AZ.PermanentHome_AZ(colKey,colValue);
	}

	
	@Parameters({"colKey","colValue"})
//	@Test(priority = 4)
	public void LivingInAZForLast12monsTest(String colKey,String colValue) throws Throwable
	{
		AZ.LivingInAZForLast12mons(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
//	@Test(priority = 5)
	public void EnrolledAnotherCollOrUniversityYesTest(String colKey,String colValue) throws Throwable
	{
		AZ.EnrolledAnotherCollOrUniversityYes(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
//	@Test(priority = 6)
	public void EnrolledAnotherCollOrUniversityNoTest(String colKey,String colValue) throws Throwable
	{
		AZ.EnrolledAnotherCollOrUniversityNo(colKey,colValue);
	}


	@Parameters({"colKey","colValue"})
//	@Test(priority = 7)
	public void EnrolledAtASUTest(String colKey,String colValue) throws Throwable
	{
		AZ.EnrolledAtASU(colKey,colValue);
	}

	
	@Parameters({"colKey","colValue"})
//	@Test(priority = 8)
	public void DependentOnParent_YesTest(String colKey,String colValue) throws Throwable
	{
		AZ.DependentOnParent_Yes(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
//	@Test(priority = 9)
	public void DependentOnParent_NoTest(String colKey,String colValue) throws Throwable
	{
		AZ.DependentOnParent_No(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
//	@Test(priority = 10)
	public void DriverLicense_YesTest(String colKey,String colValue) throws Throwable
	{
		AZ.DriverLicense_Yes(colKey,colValue);
	}

	
	@Parameters({"colKey","colValue"})
//	@Test(priority = 12)
	public void OwnVehicleDetails_YesTest(String colKey,String colValue) throws Throwable
	{
		AZ.OwnVehicleDetails_Yes(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
//	@Test(priority = 13)
	public void OwnVehicleDetails_NoTest(String colKey,String colValue) throws Throwable
	{
		AZ.OwnVehicleDetails_No(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
//	@Test(priority = 14)
	public void StateTaxes_YesTest(String colKey,String colValue) throws Throwable
	{
		AZ.StateTaxes_Yes(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
//	@Test(priority = 15)
	public void StateTaxes_NoTest(String colKey,String colValue) throws Throwable
	{
		AZ.StateTaxes_No(colKey,colValue);
	}


	@Parameters({"colKey","colValue"})
//	@Test(priority = 16)
	public void FinancialSupportTest(String colKey,String colValue) throws Throwable
	{
		AZ.FinancialSupport(colKey,colValue);
	}

	
	@Parameters({"colKey","colValue"})
//	@Test(priority = 17)
	public void FiftyPercentOfFinancialSupportForParentTest(String colKey,String colValue) throws Throwable
	{
		AZ.FiftyPercentOfFinancialSupportForParent(colKey,colValue);
	}


	@Parameters({"colKey","colValue"})
//	@Test(priority = 18)
	public void OtherFinancialSupportTest(String colKey,String colValue) throws Throwable
	{
		AZ.OtherFinancialSupport(colKey,colValue);
	}




	@Parameters({"colKey","colValue"})
//	@Test(priority = 19)
	public void EmploymentDetails_YesTest(String colKey,String colValue) throws Throwable
	{
		AZ.EmploymentDetails_Yes(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
//	@Test(priority = 20)
	public void EmploymentDetails_NoTest(String colKey,String colValue) throws Throwable
	{
		AZ.EmploymentDetails_No(colKey,colValue);
	}


	@Parameters({"colKey","colValue"})
//	@Test(priority = 21)
	public void SpouseOrDependentflowTest(String colKey,String colValue) throws Throwable
	{
		AZ.SpouseOrDependentflow(colKey,colValue);
	}
	

	@Parameters({"colKey","colValue"})
//	@Test(priority = 22)
	public void ActiveDutyflowTest(String colKey,String colValue) throws Throwable
	{
		AZ.ActiveDutyflow(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 23)
	public void VeteranflowTest(String colKey,String colValue) throws Throwable
	{
		AZ.Veteranflow(colKey,colValue);
	}
	@Parameters({"colKey","colValue"})
	@Test(priority = 24)
	public void DriverLicense_NoTest(String colKey,String colValue) throws Throwable
	{
		AZ.DriverLicense_No(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 25)
	public void RegisteredToVoteTest(String colKey,String colValue) throws Throwable
	{
		AZ.RegisteredToVote(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
//	@Test(priority = 26)
	public void ArmedForcesReserveOrNationalGuradianflowTest(String colKey,String colValue) throws Throwable
	{
		AZ.ArmedForcesReserveOrNationalGuradianflow(colKey,colValue);
	}
	
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 27)
	public void AmericanIndianOrAlaskaNAtiveTest(String colKey,String colValue) throws Throwable
	{
		AZ.AmericanIndianOrAlaskaNAtive(colKey,colValue);
	}



	@Parameters({"colKey","colValue"})
//	@Test(priority = 28)
	public void ParentLegalGuardianDetails_AZTest(String colKey,String colValue) throws Throwable
	{
		AZ.ParentLegalGuardianDetails_AZ(colKey,colValue);
	}
	@Parameters({"colKey","colValue"})
	@Test(priority = 29)
	public void ParentLegalGuardianDetailsTest(String colKey,String colValue) throws Throwable
	{
		AZ.ParentLegalGuardianDetails(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
//	@Test(priority = 30)
	public void MarriageQuestionTest(String colKey,String colValue) throws Throwable
	{
		AZ.MarriageQuestion(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
//	@Test(priority = 31)
	public void SpouseRelatedDetailsTest(String colKey,String colValue) throws Throwable
	{
		AZ.SpouseRelatedDetails(colKey,colValue);
	}


//	@Test(priority = 32)
	public void SavePageTest() throws Throwable
	{
		Thread.sleep(1000);
		AZ.SaveThePage();
		Thread.sleep(2000);
	}
}






















