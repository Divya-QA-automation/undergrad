package com.ugapp.testcases;




import org.testng.annotations.Test;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ugapp.pages.MyHighSchoolGradesPage;
import com.ugapp.utilities.Utilities;




public class TC_12_MyHighSchoolGradesTest extends BaseTest{


	MyHighSchoolGradesPage HSpage = new MyHighSchoolGradesPage();

	@Test(priority = 89)
	public void MyHighSchoolGrade() throws Throwable
	{
		//validate the title
		HSpage.validateMyHighSchoolGrade();
	}
	
	
	@Test(priority = 90)
	public void NonResidentflowTest() throws Throwable
	{
		//validate the title
		HSpage.NonResidentflow();
	}
	
	
	@Test(priority = 91)
	public void selectSelfReportCardTest() throws Throwable
	{
		HSpage.selectSelfReportCard();
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 92)
	public void selectTranscriptOnlyCardTest(String colKey,String colValue) throws Throwable
	{
		HSpage.selectTranscriptOnlyCard(colKey,colValue);
	}
	
	@Test(priority = 93)
	public void RequiredFields()
	{
		//scroll
		HSpage.scroll();
		//error text 
		HSpage.errorMessage();
	}
	
	@Test(priority = 94 , dataProviderClass = Utilities.class, dataProvider = "dp")
	public void overAllAcademicsTest(Hashtable<String, String> data) throws Throwable
	{
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			HSpage.academicDetails(data.get("unweightedGPA"),data.get("classrank"), data.get("classSize"));  
			Thread.sleep(2000);
			HSpage.validateAcademicDetails(data.get("unweightedGPA"),data.get("classrank"), data.get("classSize"));  
			Thread.sleep(2000);
		}
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 95)
	public void gpaScaleGradingSystem(String colKey,String colValue) throws Throwable
	{
		HSpage.gpaScaleDropdown(colKey,colValue);
		
		HSpage.gradingSystemDropdown(colKey,colValue);
		
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 96)
	public void addCourse(String colKey,String colValue) throws Throwable
	{
		
		HSpage.errorText();
		
		HSpage.subjectTabs();
		
		HSpage.academicYear();
		
		HSpage.courseName();
		
		HSpage.duration();
		
		HSpage.courseLevel();
		
		HSpage.grades();
		
		HSpage.validateGradingSystem();
		
		HSpage.selectGrades(colKey,colValue);
		
		HSpage.validateCoursetitle();
	}
	@Test(priority = 97)
	public void SaveThePageTest() throws InterruptedException
	{
		HSpage.SaveThePage();
	}
	
	
}










