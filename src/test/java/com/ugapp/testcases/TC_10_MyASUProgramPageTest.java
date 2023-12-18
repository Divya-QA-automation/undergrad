//package com.ugapp.testcases;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.ugapp.pages.MyASUProgramPage;
//public class TC_10_MyASUProgramPageTest extends BaseTest
//{
//	@Test(priority = 1, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void validateMyProgramPage() throws Throwable
//	{
//		//check for my program page
//		waitTillLoaderDisappears();
//		Thread.sleep(2000);
//		MyASUProgramPage.validateMyProgram();
//	}
//	
//
//
//	@Test(priority = 2, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void errorText()
//	{
//		MyASUProgramPage.errorMessage();
//	}
//	@Test(priority = 3, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void academicCalender() throws Throwable
//	{
//		waitTillLoaderDisappears();
//		Thread.sleep(2000);
//		//click on link academic calender
//		MyASUProgramPage.calender();
//		//validate if link works as expected
//		MyASUProgramPage.validateCalender();
//	}
//	@Test(priority = 4, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void SearchForProgram() throws Throwable
//	{
//		//interest area dropdown and validation
//		MyASUProgramPage.interestArea();
//		//college dropdown and validation
//		MyASUProgramPage.college();
//	}
//	@Test(priority = 5, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
//	public void clearFilter() throws Throwable
//	{
//		//check the selected options and validation
//		MyASUProgramPage.checkSelectedOptions();
//		//clear all the filters
//		MyASUProgramPage.clearAll();
//	}
//	@Test(priority = 6 , groups={"24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void Nursing() throws Throwable
//	{
//		MyASUProgramPage.searchNursing();
//	}
//
//	
//	@Parameters({"colKey","colValue"})
//	@Test(priority = 7, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void chooseProgram(String colKey,String colValue) throws Throwable
//	{
//		//randomly select a program
//		MyASUProgramPage.chooseThisProgram();
//		//randomly choose session
//		MyASUProgramPage.chooseSession();
//		//check for high requirement major
//		MyASUProgramPage.highRequirementMajor();
//		//careerAdvising section
//		MyASUProgramPage.careerAdvising(colKey,colValue);
//		
//	}
//	@Test(priority = 8, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
//	public void SaveThePageTest() throws InterruptedException
//	{
//		MyASUProgramPage.SaveThePage();
//		Thread.sleep(2000);
//	}
//}
//
//
//
//
//
//
