package com.ugapp.testcases;




import org.testng.annotations.Test;

import com.ugapp.pages.MyHighSchoolGradesPage;
import com.ugapp.utilities.Utilities;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class TC_12_MyHighSchoolGradesTest extends BaseTest{


	MyHighSchoolGradesPage HSpage = new MyHighSchoolGradesPage();

	@Test(priority = 95)
	public void MyHighSchoolGrade() throws Throwable
	{
		HSpage.validateMyHighSchoolGrade();
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 96)
	public void RandomSelfReportSeniorYrOrAllHSgradesTest(String colKey,String colValue) throws Throwable
	{
		HSpage.RandomSelfReportSeniorYrOrAllHSgrades(colKey,colValue);
	}



	@Parameters({"colKey","colValue"})
	@Test(priority = 96)
	public void Random_FutureOrPastGradTest(String colKey,String colValue) throws Throwable
	{
		HSpage.Random_FutureOrPastGrad(colKey,colValue);
	}

	@Test(priority = 97)
	public void NonResidentflowTest() throws Throwable
	{
		//validate the title
		HSpage.NonResidentflow();
	}


	@Test(priority = 98)
	public void selectSelfReportCardTest() throws Throwable
	{
		HSpage.selectSelfReportCard();
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 99)
	public void selectTranscriptOnlyCardTest(String colKey,String colValue) throws Throwable
	{
		HSpage.selectTranscriptOnlyCard(colKey,colValue);
	}

	@Test(priority = 100)
	public void RequiredFields()
	{
		//scroll
		HSpage.scroll();
		//error text 
		HSpage.errorMessage();
	}

	@Test(priority = 101, dataProviderClass = Utilities.class, dataProvider = "dp")
	public void overAllAcademicsTest(Hashtable<String, String> data) throws Throwable
	{
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			HSpage.academicDetails(data.get("unweightedGPA"),data.get("classrank"), data.get("classSize"));  
			HSpage.validateAcademicDetails(data.get("unweightedGPA"),data.get("classrank"), data.get("classSize"));  
		}
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 102)
	public void gpaScaleGradingSystem(String colKey,String colValue) throws Throwable
	{
		HSpage.gpaScaleDropdown(colKey,colValue);

		HSpage.gradingSystemDropdown(colKey,colValue);

	}



	@Parameters({"colKey","colValue"})
	@Test(priority = 103)
	public void addCourse(String colKey,String colValue) throws Throwable
	{

		HSpage.errorText();
		log.debug("Pass errorText mtd");
		HSpage.subjectTabs();
		log.debug("Pass subjectTabs mtd");
		HSpage.academicYear();
		log.debug("Pass academicYear mtd");
		HSpage.courseName();
		log.debug("Pass courseName mtd");
		HSpage.duration();
		log.debug("Pass duration mtd");
		HSpage.courseLevel();
		log.debug("Pass courseLevel mtd");
		HSpage.grades();
		log.debug("Pass grades mtd");
		HSpage.validateGradingSystem();
		log.debug("Pass validateGradingSystem mtd");
		HSpage.selectGrades(colKey,colValue);
		log.debug("Pass selectGrades mtd");
		HSpage.validateCoursetitle();
	}
	@Test(priority = 104)
	public void SaveThePageTest() throws InterruptedException
	{
		HSpage.SaveThePage();
	}



	@Parameters({"colKey","colValue"})
	@Test(priority = 102)
	public void DefaultSelf_reportgradesTest(String colKey,String colValue) throws Throwable
	{
		HSpage.DefaultSelf_reportgrades(colKey,colValue);

	}


}