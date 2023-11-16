package com.ugapp.testcases;


import java.util.Hashtable;


import org.testng.SkipException;
import org.testng.annotations.Test;


import com.ugapp.base.Page;
import com.ugapp.pages.MyHighSchoolGradesPage;
import com.ugapp.pages.PreAppDashboardPage;
import com.ugapp.utilities.Utilities;


public class TC_12_MyHighSchoolGradesTest extends Page{


	@Test(priority = 1)
	public void MyHighSchoolGrade() throws Throwable
	{
		//validate the title
		MyHighSchoolGradesPage.validateMyHighSchoolGrade();
	}
	
	@Test(priority = 2)
	public void card() throws Throwable
	{
		MyHighSchoolGradesPage.selectCard();
	}
	
	
	@Test(priority = 3)
	public void RequiredFields()
	{
		//scroll
		MyHighSchoolGradesPage.scroll();
		
		//error text 
		MyHighSchoolGradesPage.errorMessage();
	}
	
	@Test(priority = 4 , dataProviderClass = Utilities.class, dataProvider = "dp")
	public void overAllAcademicsTest(Hashtable<String, String> data) throws Throwable
	{
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			MyHighSchoolGradesPage.academicDetails(data.get("unweightedGPA"),data.get("classrank"), data.get("classSize"));  
			Thread.sleep(2000);
			MyHighSchoolGradesPage.validateAcademicDetails(data.get("unweightedGPA"),data.get("classrank"), data.get("classSize"));  
			Thread.sleep(2000);
		}
	}
	
	@Test(priority = 5)
	public void gpaScaleGradingSystem() throws Throwable
	{
		MyHighSchoolGradesPage.gpaScaleDropdown();
		
		MyHighSchoolGradesPage.gradingSystemDropdown();
		
	}
	
	
	@Test(priority = 6)
	public void addCourse() throws Throwable
	{
		
		MyHighSchoolGradesPage.errorText();
		
		MyHighSchoolGradesPage.subjectTabs();
		
		MyHighSchoolGradesPage.academicYear();
		
		MyHighSchoolGradesPage.courseName();
		
		MyHighSchoolGradesPage.duration();
		
		MyHighSchoolGradesPage.courseLevel();
		
		MyHighSchoolGradesPage.grades();
		
		MyHighSchoolGradesPage.validateGradingSystem();
		
		MyHighSchoolGradesPage.selectGrades();
		
		MyHighSchoolGradesPage.validateCoursetitle();
	}
	
	
	
}




