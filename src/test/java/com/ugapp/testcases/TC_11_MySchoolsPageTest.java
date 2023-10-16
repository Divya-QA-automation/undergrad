package com.ugapp.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
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
	public void GraduationDateTest() throws Throwable
	{
		Thread.sleep(1000);
		MySchool.GraduationDate();

	}
	@Test(priority = 5)
	public void SelectNameOnTranscriptTest() throws Throwable
	{
		Thread.sleep(1000);
		MySchool.SelectNameOnTranscript();

	}
	
	@Test(priority = 6)
	public void DeleteAddedSchoolTest() throws Throwable
	{
		Thread.sleep(1000);
		MySchool.DeleteAddedSchool();

	}
	@Test(priority = 7)
	public void RecentSchoolAZTest() throws Throwable
	{
		Thread.sleep(1000);
		MySchool.RecentSchoolAZ();

	}
	
	@Test(priority = 8 , dataProviderClass = Utilities.class, dataProvider = "dp")
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
	
	@Test(priority = 9)
	public void HaveAttendedOrAttendingCollegeAndUniversitiesTest() throws InterruptedException
	{
		MySchool.HaveAttendedOrAttendingCollegeAndUniversities();
	}
	
	@Test(priority = 10 , dataProviderClass = Utilities.class, dataProvider = "dp")
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
	@Test(priority = 11)
	public void EnterFirstAndLastDateTest() throws InterruptedException
	{
		MySchool.EnterFirstAndLastDate();
	}
	
	@Test(priority = 12)
	public void saveInstitutionTest() throws InterruptedException
	{
		MySchool.saveInstitution();
	}
	
	@Test(priority = 13)
	public void validateAddSchoolTest() throws InterruptedException
	{
		MySchool.validateAddSchool();
	}
	
	@Test(priority = 14)
	public void PreviousCollegeEligibilityTest() throws InterruptedException
	{
		MySchool.PreviousCollegeEligibility();
	}
	
	@Test(priority = 15)
	public void TranscriptPolicyTest() throws InterruptedException
	{
		MySchool.TranscriptPolicy();
	}
	@Test(priority = 16)
	public void SaveThePageTest() throws InterruptedException
	{
		MySchool.SaveThePage();
		Thread.sleep(2000);
	}
}
	

