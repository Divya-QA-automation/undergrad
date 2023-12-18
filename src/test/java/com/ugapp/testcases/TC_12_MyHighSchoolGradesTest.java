//package com.ugapp.testcases;
//
//
//
//
//import java.util.Hashtable;
//
//import org.testng.SkipException;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.ugapp.pages.MyHighSchoolGradesPage;
//import com.ugapp.utilities.Utilities;
//
//
//
//
//public class TC_12_MyHighSchoolGradesTest extends BaseTest{
//
//
//
//
//	@Test(priority = 1, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void MyHighSchoolGrade() throws Throwable
//	{
//		//validate the title
//		MyHighSchoolGradesPage.validateMyHighSchoolGrade();
//	}
//	
//	@Test(priority = 2, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","Lessthan18_US_Res_ActiveDuty_AZ"})
//	public void selectSelfReportCardTest() throws Throwable
//	{
//		MyHighSchoolGradesPage.selectSelfReportCard();
//	}
//	
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 3, groups={"18=>24_NonUS_Res_Veteran_PastGrad_OOS","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void selectTranscriptOnlyCardTest(String colKey,String colValue) throws Throwable
//	{
//		MyHighSchoolGradesPage.selectTranscriptOnlyCard(colKey,colValue);
//	}
//	
//	@Test(priority = 4, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","Lessthan18_US_Res_ActiveDuty_AZ"})
//	public void RequiredFields()
//	{
//		//scroll
//		MyHighSchoolGradesPage.scroll();
//		
//		//error text 
//		MyHighSchoolGradesPage.errorMessage();
//	}
//	
//	@Test(priority = 5 , dataProviderClass = Utilities.class, dataProvider = "dp", groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","Lessthan18_US_Res_ActiveDuty_AZ"})
//	public void overAllAcademicsTest(Hashtable<String, String> data) throws Throwable
//	{
//		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
//			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
//		} else {
//			MyHighSchoolGradesPage.academicDetails(data.get("unweightedGPA"),data.get("classrank"), data.get("classSize"));  
//			Thread.sleep(2000);
//			MyHighSchoolGradesPage.validateAcademicDetails(data.get("unweightedGPA"),data.get("classrank"), data.get("classSize"));  
//			Thread.sleep(2000);
//		}
//	}
//	
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 6, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","Lessthan18_US_Res_ActiveDuty_AZ"})
//	public void gpaScaleGradingSystem(String colKey,String colValue) throws Throwable
//	{
//		MyHighSchoolGradesPage.gpaScaleDropdown(colKey,colValue);
//		
//		MyHighSchoolGradesPage.gradingSystemDropdown(colKey,colValue);
//		
//	}
//	
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 7, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","Lessthan18_US_Res_ActiveDuty_AZ"})
//	public void addCourse(String colKey,String colValue) throws Throwable
//	{
//		
//		MyHighSchoolGradesPage.errorText();
//		
//		MyHighSchoolGradesPage.subjectTabs();
//		
//		MyHighSchoolGradesPage.academicYear();
//		
//		MyHighSchoolGradesPage.courseName();
//		
//		MyHighSchoolGradesPage.duration();
//		
//		MyHighSchoolGradesPage.courseLevel();
//		
//		MyHighSchoolGradesPage.grades();
//		
//		MyHighSchoolGradesPage.validateGradingSystem();
//		
//		MyHighSchoolGradesPage.selectGrades(colKey,colValue);
//		
//		MyHighSchoolGradesPage.validateCoursetitle();
//	}
//	@Test(priority = 8, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void SaveThePageTest() throws InterruptedException
//	{
//		MyHighSchoolGradesPage.SaveThePage();
//		Thread.sleep(2000);
//	}
//	
//	
//}
//
//
//
//
//
//
//
//
//
//
