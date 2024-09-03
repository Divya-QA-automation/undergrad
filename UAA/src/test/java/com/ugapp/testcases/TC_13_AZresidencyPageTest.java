package com.ugapp.testcases;
import org.testng.annotations.Test;

import com.ugapp.pages.AZResidencyPage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;








public class TC_13_AZresidencyPageTest extends BaseTest
{
	AZResidencyPage AZ = new AZResidencyPage();


	@Test(priority = 105)
	public void ValidateAZresidencyPage() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(1000);
		AZ.validateAZresidencyPage();
		Thread.sleep(1000);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 106)
	public void PermanentHome_OOSTest(String colKey,String colValue) throws Throwable
	{
		AZ.PermanentHome_OOS(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 107)
	public void PermanentHome_AZTest(String colKey,String colValue) throws Throwable
	{
		AZ.PermanentHome_AZ(colKey,colValue);
	}

	
	@Parameters({"colKey","colValue"})
	@Test(priority = 108)
	public void LivingInAZForLast12monsTest(String colKey,String colValue) throws Throwable
	{
		AZ.LivingInAZForLast12mons(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 109)
	public void EnrolledAnotherCollOrUniversityYesTest(String colKey,String colValue) throws Throwable
	{
		AZ.EnrolledAnotherCollOrUniversityYes(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 110)
	public void EnrolledAnotherCollOrUniversityNoTest(String colKey,String colValue) throws Throwable
	{
		AZ.EnrolledAnotherCollOrUniversityNo(colKey,colValue);
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 111)
	public void EnrolledAtASUTest(String colKey,String colValue) throws Throwable
	{
		AZ.EnrolledAtASU(colKey,colValue);
	}

	
	@Parameters({"colKey","colValue"})
	@Test(priority = 112)
	public void DependentOnParent_YesTest(String colKey,String colValue) throws Throwable
	{
		AZ.DependentOnParent_Yes(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 113)
	public void DependentOnParent_NoTest(String colKey,String colValue) throws Throwable
	{
		AZ.DependentOnParent_No(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 114)
	public void DriverLicense_YesTest(String colKey,String colValue) throws Throwable
	{
		AZ.DriverLicense_Yes(colKey,colValue);
	}

	
	@Parameters({"colKey","colValue"})
	@Test(priority = 115)
	public void OwnVehicleDetails_YesTest(String colKey,String colValue) throws Throwable
	{
		AZ.OwnVehicleDetails_Yes(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 116)
	public void OwnVehicleDetails_NoTest(String colKey,String colValue) throws Throwable
	{
		AZ.OwnVehicleDetails_No(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 117)
	public void StateTaxes_YesTest(String colKey,String colValue) throws Throwable
	{
		AZ.StateTaxes_Yes(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 118)
	public void StateTaxes_NoTest(String colKey,String colValue) throws Throwable
	{
		AZ.StateTaxes_No(colKey,colValue);
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 119)
	public void FinancialSupportTest(String colKey,String colValue) throws Throwable
	{
		AZ.FinancialSupport(colKey,colValue);
	}

	
	@Parameters({"colKey","colValue"})
	@Test(priority = 120)
	public void FiftyPercentOfFinancialSupportForParentTest(String colKey,String colValue) throws Throwable
	{
		AZ.FiftyPercentOfFinancialSupportForParent(colKey,colValue);
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 121)
	public void OtherFinancialSupportTest(String colKey,String colValue) throws Throwable
	{
		AZ.OtherFinancialSupport(colKey,colValue);
	}
	
	@Test(priority = 122)
	public void SourceOfSupportTest() throws Throwable
	{
		AZ.SourceOfSupport();
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 123)
	public void EmploymentDetails_YesTest(String colKey,String colValue) throws Throwable
	{
		AZ.EmploymentDetails_Yes(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 124)
	public void EmploymentDetails_NoTest(String colKey,String colValue) throws Throwable
	{
		AZ.EmploymentDetails_No(colKey,colValue);
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 125)
	public void SpouseOrDependentflowTest(String colKey,String colValue) throws Throwable
	{
		AZ.SpouseOrDependentflow(colKey,colValue);
	}
	

	@Parameters({"colKey","colValue"})
	@Test(priority = 126)
	public void ActiveDutyflowTest(String colKey,String colValue) throws Throwable
	{
		AZ.ActiveDutyflow(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 127)
	public void VeteranflowTest(String colKey,String colValue) throws Throwable
	{
		AZ.Veteranflow(colKey,colValue);
	}
	@Parameters({"colKey","colValue"})
	@Test(priority = 128)
	public void DriverLicense_NoTest(String colKey,String colValue) throws Throwable
	{
		AZ.DriverLicense_No(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 129)
	public void RegisteredToVoteTest(String colKey,String colValue) throws Throwable
	{
		AZ.RegisteredToVote(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 130)
	public void ArmedForcesReserveOrNationalGuradianflowTest(String colKey,String colValue) throws Throwable
	{
		AZ.ArmedForcesReserveOrNationalGuradianflow(colKey,colValue);
	}
	
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 131)
	public void AmericanIndianOrAlaskaNAtiveTest(String colKey,String colValue) throws Throwable
	{
		AZ.AmericanIndianOrAlaskaNAtive(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 132)
	public void ParentLegalGuardianDetails_AZTest(String colKey,String colValue) throws Throwable
	{
		AZ.ParentLegalGuardianDetails_AZ(colKey,colValue);
	}
	@Parameters({"colKey","colValue"})
	@Test(priority = 133)
	public void ParentLegalGuardianDetailsTest(String colKey,String colValue) throws Throwable
	{
		AZ.ParentLegalGuardianDetails(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 134)
	public void MarriageQuestionTest(String colKey,String colValue) throws Throwable
	{
		AZ.MarriageQuestion(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 135)
	public void SpouseRelatedDetailsTest(String colKey,String colValue) throws Throwable
	{
		AZ.SpouseRelatedDetails(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 136)
	public void Prop308flowTest(String colKey,String colValue) throws Throwable
	{
		AZ.Prop308flow(colKey,colValue);
	}
	
	
	@Test(priority = 137)
	public void NonResidentAZflowTest() throws Throwable
	{
		AZ.NonResidentAZflow();
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 138)
	public void NoneOftheseApplyTest(String colKey,String colValue) throws Throwable
	{
		AZ.DupAppCheckflow(colKey,colValue);
	}

	@Test(priority = 139)
	public void SavePageTest() throws Throwable
	{
		Thread.sleep(1000);
		AZ.SaveThePage();
		Thread.sleep(1000);
	}
	
	@Test(priority =140)
	public void ContinuePageTest() throws Throwable
	{
		Thread.sleep(2000);
		AZ.ContinueThePage();
		Thread.sleep(2000);
	}
}






















