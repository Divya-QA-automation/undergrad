package java.com.ugapp.testcases;


import org.testng.annotations.Test;
import java.util.Hashtable;

import org.apache.poi.EncryptedDocumentException;
import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.com.ugapp.pages.MySchoolsPage;
import java.com.ugapp.utilities.Utilities;


public class TC_11_MySchoolsPageTest extends BaseTest
{
	MySchoolsPage MySchool = new MySchoolsPage();


	@Test(priority = 74)
	public void validateMySchoolsPage() throws Throwable
	{
		waitTillLoaderDisappears();
		MySchool.ValidateForMySchools();
	} 


	@Test(priority = 75)
	public void RecentHighSchool_CountryTest() throws Throwable
	{
		Thread.sleep(1000);
		MySchool.RandomHighSchool_country();
	}


	@Test(priority = 76, dataProviderClass = Utilities.class, dataProvider = "dp")
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

	@Parameters({"colKey","colValue"})
	@Test(priority = 77)
	public void Random_RecentSchoolTest(String colKey,String colValue) throws Throwable
	{
		Thread.sleep(1000);
		MySchool.Random_RecentSchool(colKey,colValue);
	}

	@Test(priority = 78)
	public void FutureGraduationDateTest() throws Throwable
	{
		Thread.sleep(1000);
		MySchool.FutureGraduationDate();
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 79)
	public void PastGraduationDateTest(String colKey,String colValue) throws Throwable
	{
		Thread.sleep(1000);
		MySchool.PastGraduationDate(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 80)
	public void RandomGraduationDateTest(String colKey,String colValue) throws Throwable
	{
		Thread.sleep(1000);
		MySchool.RandomGraduationDate(colKey,colValue);
	}
	

	@Test(priority = 81)
	public void SelectNameOnTranscriptTest() throws Throwable
	{
		Thread.sleep(1000);
		MySchool.SelectNameOnTranscript();
	}


	@Test(priority = 82)
	public void DeleteAddedSchoolTest() throws Throwable
	{
		Thread.sleep(1000);
		MySchool.DeleteAddedSchool();


	}


		
	@Parameters({"colKey","colValue"})
	@Test(priority = 83)
	public void Random_CollegeUniversitiesTest(String colKey,String colValue) throws Throwable
	{
		Thread.sleep(1000);
		MySchool.Random_CollegeUniversities(colKey,colValue);
	}

	
	
	
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 84)
	public void RecentSchoolAZTest(String colKey,String colValue) throws Throwable
	{
		Thread.sleep(1000);
		MySchool.RecentSchoolAZ(colKey,colValue);


	}


	@Test(priority = 85, dataProviderClass = Utilities.class, dataProvider = "dp")
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

	@Parameters({"colKey","colValue"})
	@Test(priority = 86)
	public void HaveAttendedOrAttendingCollegeAndUniversitiesYesTest(String colKey,String colValue) throws Exception
	{
		MySchool.HaveAttendedOrAttendingCollegeAndUniversities_Yes(colKey,colValue);
	}

	
	
	
	@Test(priority = 87, dataProviderClass = Utilities.class, dataProvider = "dp")
	public void CollegeUniversitiesTest(Hashtable<String, String> data) throws Throwable {
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			MySchool.CollegeUniversities(data.get("State"),data.get("City"),data.get("Institution_name"),data.get("Degree_Concentration"));
			Thread.sleep(500);
			MySchool.ValidateCollegeUniversities(data.get("State"),data.get("City"),data.get("Institution_name"),data.get("Degree_Concentration"));
			Thread.sleep(500);
		}
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 88)
	public void EnterFirstAndLastDateTest(String colKey,String colValue) throws Exception
	{
		MySchool.EnterFirstAndLastDate(colKey,colValue);
	}


	@Test(priority = 89)
	public void saveInstitutionTest() throws InterruptedException
	{
		MySchool.saveInstitution();
	}


	@Test(priority = 90)
	public void validateAddSchoolTest() throws InterruptedException
	{
		MySchool.validateAddSchool();
	}


	@Parameters({"colKey","colValue"})
	@Test(priority = 91)
	public void PreviousCollegeEligibilityTest(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		MySchool.PreviousCollegeEligibility(colKey,colValue);
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 92)
	public void HaveAttendedOrAttendingCollegeAndUniversitiesNoTest(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		MySchool.HaveAttendedOrAttendingCollegeAndUniversities_No(colKey,colValue);
	}



	@Test(priority = 93)
	public void TranscriptPolicyTest() throws InterruptedException
	{
		MySchool.TranscriptPolicy();
	}


	@Test(priority = 94)
	public void SaveThePageTest() throws InterruptedException
	{
		MySchool.SaveThePage();
	}
	
}








