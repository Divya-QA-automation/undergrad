package com.ugapp.testcases;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ugapp.pages.AZResidencyPage;








public class TC_13_AZresidencyPageTest extends BaseTest
{
	AZResidencyPage AZ = new AZResidencyPage();


	@Test(priority = 1, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void ValidateAZresidencyPage() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(1000);
		AZ.validateAZresidencyPage();
		Thread.sleep(1000);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 2, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS"})
	public void PermanentHome_OOSTest(String colKey,String colValue) throws Throwable
	{
		AZ.PermanentHome_OOS(colKey,colValue);
	}

	
	@Parameters({"colKey","colValue"})
	@Test(priority = 3, groups = {"Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void PermanentHome_AZTest(String colKey,String colValue) throws Throwable
	{
		AZ.PermanentHome_AZ(colKey,colValue);
	}

	
	@Parameters({"colKey","colValue"})
	@Test(priority = 4, groups = {"Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void LivingInAZForLast12monsTest(String colKey,String colValue) throws Throwable
	{
		AZ.LivingInAZForLast12mons(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 5, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
	public void EnrolledAnotherCollOrUniversityYesTest(String colKey,String colValue) throws Throwable
	{
		AZ.EnrolledAnotherCollOrUniversityYes(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 6, groups = {"Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void EnrolledAnotherCollOrUniversityNoTest(String colKey,String colValue) throws Throwable
	{
		AZ.EnrolledAnotherCollOrUniversityNo(colKey,colValue);
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 7, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void EnrolledAtASUTest(String colKey,String colValue) throws Throwable
	{
		AZ.EnrolledAtASU(colKey,colValue);
	}

	
	@Parameters({"colKey","colValue"})
	@Test(priority = 8, groups = {"Lessthan18_US_Res_ActiveDuty_AZ"})
	public void DependentOnParent_YesTest(String colKey,String colValue) throws Throwable
	{
		AZ.DependentOnParent_Yes(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 9, groups = {"24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void DependentOnParent_NoTest(String colKey,String colValue) throws Throwable
	{
		AZ.DependentOnParent_No(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 10, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","Lessthan18_US_Res_ActiveDuty_AZ"})
	public void DriverLicense_YesTest(String colKey,String colValue) throws Throwable
	{
		AZ.DriverLicense_Yes(colKey,colValue);
	}

	
	@Parameters({"colKey","colValue"})
	@Test(priority = 11, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
	public void OwnVehicleDetails_YesTest(String colKey,String colValue) throws Throwable
	{
		AZ.OwnVehicleDetails_Yes(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 12, groups = {"24yr_NonUS_Res_RNBSN_AForNG_AZ","Lessthan18_US_Res_ActiveDuty_AZ"})
	public void OwnVehicleDetails_NoTest(String colKey,String colValue) throws Throwable
	{
		AZ.OwnVehicleDetails_No(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 13, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
	public void StateTaxes_YesTest(String colKey,String colValue) throws Throwable
	{
		AZ.StateTaxes_Yes(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 14, groups = {"24yr_NonUS_Res_RNBSN_AForNG_AZ","Lessthan18_US_Res_ActiveDuty_AZ"})
	public void StateTaxes_NoTest(String colKey,String colValue) throws Throwable
	{
		AZ.StateTaxes_No(colKey,colValue);
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 15, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void FinancialSupportTest(String colKey,String colValue) throws Throwable
	{
		AZ.FinancialSupport(colKey,colValue);
	}

	
	@Parameters({"colKey","colValue"})
	@Test(priority = 16, groups = {"Lessthan18_US_Res_ActiveDuty_AZ"})
	public void FiftyPercentOfFinancialSupportForParentTest(String colKey,String colValue) throws Throwable
	{
		AZ.FiftyPercentOfFinancialSupportForParent(colKey,colValue);
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 17, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void OtherFinancialSupportTest(String colKey,String colValue) throws Throwable
	{
		AZ.OtherFinancialSupport(colKey,colValue);
	}




	@Parameters({"colKey","colValue"})
	@Test(priority = 18, groups = {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
	public void EmploymentDetails_YesTest(String colKey,String colValue) throws Throwable
	{
		AZ.EmploymentDetails_Yes(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 19, groups = {"Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void EmploymentDetails_NoTest(String colKey,String colValue) throws Throwable
	{
		AZ.EmploymentDetails_No(colKey,colValue);
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 20, groups = {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
	public void SpouseOrDependentflowTest(String colKey,String colValue) throws Throwable
	{
		AZ.SpouseOrDependentflow(colKey,colValue);
	}
	

	@Parameters({"colKey","colValue"})
	@Test(priority = 21, groups = {"Lessthan18_US_Res_ActiveDuty_AZ"})
	public void ActiveDutyflowTest(String colKey,String colValue) throws Throwable
	{
		AZ.ActiveDutyflow(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 22, groups = {"18=>24_NonUS_Res_Veteran_PastGrad_OOS"})
	public void VeteranflowTest(String colKey,String colValue) throws Throwable
	{
		AZ.Veteranflow(colKey,colValue);
	}
	@Parameters({"colKey","colValue"})
	@Test(priority = 23, groups = {"18=>24_NonUS_Res_Veteran_PastGrad_OOS","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void DriverLicense_NoTest(String colKey,String colValue) throws Throwable
	{
		AZ.DriverLicense_No(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 24, groups = {"18=>24_NonUS_Res_Veteran_PastGrad_OOS"})
	public void RegisteredToVoteTest(String colKey,String colValue) throws Throwable
	{
		AZ.RegisteredToVote(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 25, groups = {"24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void ArmedForcesReserveOrNationalGuradianflowTest(String colKey,String colValue) throws Throwable
	{
		AZ.ArmedForcesReserveOrNationalGuradianflow(colKey,colValue);
	}
	
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 26, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void AmericanIndianOrAlaskaNAtiveTest(String colKey,String colValue) throws Throwable
	{
		AZ.AmericanIndianOrAlaskaNAtive(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 27, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","Lessthan18_US_Res_ActiveDuty_AZ"})
	public void ParentLegalGuardianDetails_AZTest(String colKey,String colValue) throws Throwable
	{
		AZ.ParentLegalGuardianDetails_AZ(colKey,colValue);
	}
	@Parameters({"colKey","colValue"})
	@Test(priority = 28, groups = {"24yr_NonUS_Res_RNBSN_AForNG_AZ","18=>24_NonUS_Res_Veteran_PastGrad_OOS"})
	public void ParentLegalGuardianDetailsTest(String colKey,String colValue) throws Throwable
	{
		AZ.ParentLegalGuardianDetails(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 29, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void MarriageQuestionTest(String colKey,String colValue) throws Throwable
	{
		AZ.MarriageQuestion(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 30, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void SpouseRelatedDetailsTest(String colKey,String colValue) throws Throwable
	{
		AZ.SpouseRelatedDetails(colKey,colValue);
	}


	@Test(priority = 31, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
	public void SavePageTest() throws Throwable
	{
		Thread.sleep(2000);
		AZ.SaveThePage();
		Thread.sleep(2000);
	}
}






















