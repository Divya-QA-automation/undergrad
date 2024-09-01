package com.ugapp.testcases;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ugapp.pages.MyASUProgramPage;
public class TC_10_MyASUProgramPageTest extends BaseTest
{
	MyASUProgramPage myASUProgramPage = new MyASUProgramPage();
	
	
	@Test(priority = 64)
	public void GetProgListTest() throws Throwable
	{
		//check for my program page
		waitTillLoaderDisappears();
		Thread.sleep(2000);
		myASUProgramPage.GetProgList();
	}
	
	
	
	@Test(priority = 65)
	public void validateMyProgramPage() throws Throwable
	{
		//check for my program page
		waitTillLoaderDisappears();
		Thread.sleep(2000);
		myASUProgramPage.validateMyProgram();
	}
	

	
	

	@Test(priority = 66)
	public void errorText()
	{
		myASUProgramPage.errorMessage();
	}
	
	
	@Test(priority = 67)
	public void academicCalender() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(2000);
		//click on link academic calender
		myASUProgramPage.calender();
		//validate if link works as expected
		myASUProgramPage.validateCalender();
		Thread.sleep(1000);
	}
	@Test(priority = 68)
	public void SearchForProgram() throws Throwable
	{
		//interest area dropdown and validation
		myASUProgramPage.interestArea();
		//college dropdown and validation
		myASUProgramPage.college();
	}
	@Test(priority = 69)
	public void clearFilter() throws Throwable
	{
		//check the selected options and validation
		myASUProgramPage.checkSelectedOptions();
		//clear all the filters
		myASUProgramPage.clearAll();
	}
	@Test(priority = 70)
	public void Nursing() throws Throwable
	{
		myASUProgramPage.searchNursing();
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 71)
	public void chooseProgram(String colKey,String colValue) throws Throwable
	{
		//randomly select a program
		myASUProgramPage.chooseThisProgram();
		//randomly choose session
		myASUProgramPage.chooseSession();
		//check for high requirement major
		myASUProgramPage.highRequirementMajor();
		//careerAdvising section
		myASUProgramPage.careerAdvising(colKey,colValue);
	}
	
	@Parameters({"colKey","colValue"})
	@Test(priority = 72)
	public void DupApp_chooseProgramTest(String colKey,String colValue) throws Throwable
	{
		//randomly select a program - African and African American studies, BA
		myASUProgramPage.DupApp_chooseThisProgram();
		//careerAdvising section
		myASUProgramPage.careerAdvising(colKey,colValue);
		
	}
	
	@Test(priority = 73)
	public void SaveThePageTest() throws InterruptedException
	{
		myASUProgramPage.SaveThePage();
	}
}






