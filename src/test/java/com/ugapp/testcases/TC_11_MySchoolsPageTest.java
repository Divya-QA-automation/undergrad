package com.ugapp.testcases;


import java.util.Hashtable;


import org.apache.poi.EncryptedDocumentException;
import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.ugapp.base.Page;
import com.ugapp.pages.MySchoolsPage;
import com.ugapp.utilities.Utilities;


public class TC_11_MySchoolsPageTest extends Page
{
	MySchoolsPage MySchool = new MySchoolsPage();


	@Test(priority = 1)
	public void validateMySchoolsPage() throws Throwable
	{
		waitTillLoaderDisappears();
		MySchool.ValidateForMySchools();


	} 


	@Test(priority = 2)
	public void RecentHighSchoolTest() throws Throwable
	{
		Thread.sleep(1000);
		MySchool.RecentHighSchool();


	}


	@Test(priority = 3 , dataProviderClass = Utilities.class, dataProvider = "dp")
	public void GraduatingSchoolTest(Hashtable<String, String> data) throws Throwable {
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			MySchool.GraduatingSchool(data.get("State"),data.get("City"),data.get("School_name"),data.get("SAISno"));
			Thread.sleep(1000);
			MySchool.ValidateGraduatingSchool(data.get("State"),data.get("City"),data.get("School_name"),data.get("SAISno"));
			Thread.sleep(1000);
		}
	}


	@Test(priority = 4)
	public void FutureGraduationDateTest() throws Throwable
	{
		Thread.sleep(1000);
		MySchool.FutureGraduationDate();
	}
	
	@Test(priority = 5)
	public void PastGraduationDateTest() throws Throwable
	{
		Thread.sleep(1000);
		MySchool.PastGraduationDate();
	}








	@Test(priority = 6)
	public void SelectNameOnTranscriptTest() throws Throwable
	{
		Thread.sleep(1000);
		MySchool.SelectNameOnTranscript();


	}


	@Test(priority = 7)
	public void DeleteAddedSchoolTest() throws Throwable
	{
		Thread.sleep(1000);
		MySchool.DeleteAddedSchool();


	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 8)
	public void RecentSchoolAZTest(String colKey,String colValue) throws Throwable
	{
		Thread.sleep(1000);
		MySchool.RecentSchoolAZ(colKey,colValue);


	}


	@Test(priority = 9 , dataProviderClass = Utilities.class, dataProvider = "dp")
	public void AddMaxHighSchoolTest(Hashtable<String, String> data) throws Throwable 
	{
		if (!data.get("Runmode").equalsIgnoreCase("Y")) 
		{
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else 
		{
			MySchool.AddMaxHighSchool(data.get("State"),data.get("City"),data.get("School_name"),data.get("SAISno"));
			Thread.sleep(1000);


		}
	}


	@Test(priority = 10)
	public void HaveAttendedOrAttendingCollegeAndUniversitiesYesTest() throws InterruptedException
	{
		MySchool.HaveAttendedOrAttendingCollegeAndUniversities_Yes();
	}


	@Test(priority = 11)
	public void HaveAttendedOrAttendingCollegeAndUniversitiesNoTest() throws InterruptedException
	{
		MySchool.HaveAttendedOrAttendingCollegeAndUniversities_No();
	}


	@Test(priority = 12 , dataProviderClass = Utilities.class, dataProvider = "dp")
	public void CollegeUniversitiesTest(Hashtable<String, String> data) throws Throwable {
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			MySchool.CollegeUniversities(data.get("State"),data.get("City"),data.get("Institution_name"),data.get("Degree_Concentration"));
			Thread.sleep(1000);
			MySchool.ValidateCollegeUniversities(data.get("State"),data.get("City"),data.get("Institution_name"),data.get("Degree_Concentration"));
			Thread.sleep(1000);
		}
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 13)
	public void EnterFirstAndLastDateTest(String colKey,String colValue) throws Exception
	{
		MySchool.EnterFirstAndLastDate(colKey,colValue);
	}


	@Test(priority = 14)
	public void saveInstitutionTest() throws InterruptedException
	{
		MySchool.saveInstitution();
	}


	@Test(priority = 15)
	public void validateAddSchoolTest() throws InterruptedException
	{
		MySchool.validateAddSchool();
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 16)
	public void PreviousCollegeEligibilityTest(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		MySchool.PreviousCollegeEligibility(colKey,colValue);
	}


	@Test(priority = 17)
	public void TranscriptPolicyTest() throws InterruptedException
	{
		MySchool.TranscriptPolicy();
	}


	@Test(priority = 18)
	public void SaveThePageTest() throws InterruptedException
	{
		MySchool.SaveThePage();
		Thread.sleep(2000);
	}
}








