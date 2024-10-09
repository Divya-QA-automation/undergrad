package com.ugapp.testcases;
import org.testng.annotations.Test;

import com.ugapp.pages.MyASUProgramPage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class TC_10_MyASUProgramPageTest extends BaseTest
{
	MyASUProgramPage myASUProgramPage = new MyASUProgramPage();


	@Test(priority = 69)
	public void GetProgListTest() throws Throwable
	{
		//check for my program page
		waitTillLoaderDisappears();
		Thread.sleep(2000);
		myASUProgramPage.GetProgList();
	}



	@Test(priority = 70)
	public void validateMyProgramPage() throws Throwable
	{
		//check for my program page
		waitTillLoaderDisappears();
		Thread.sleep(2000);
		myASUProgramPage.validateMyProgram();
	}





	@Test(priority = 71)
	public void errorText()
	{
		myASUProgramPage.errorMessage();
	}


	@Test(priority = 72)
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
	@Test(priority = 73)
	public void SearchForProgram() throws Throwable
	{
		//interest area dropdown and validation
		myASUProgramPage.interestArea();
		//college dropdown and validation
		myASUProgramPage.college();
	}
	@Test(priority = 74)
	public void clearFilter() throws Throwable
	{
		//check the selected options and validation
		myASUProgramPage.checkSelectedOptions();
		//clear all the filters
		myASUProgramPage.clearAll();
	}
	@Test(priority = 75)
	public void Nursing() throws Throwable
	{
		myASUProgramPage.searchNursing();
	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 76)
	public void RandomProgramChoiceTest(String colKey,String colValue) throws Throwable
	{
		//randomly select a program
		myASUProgramPage.RandomProgramChoice();
		//careerAdvising section
		myASUProgramPage.careerAdvising(colKey,colValue);

	}




	@Parameters({"colKey","colValue"})
	@Test(priority = 78)
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
	@Test(priority = 77)
	public void DupApp_chooseProgramTest(String colKey,String colValue) throws Throwable
	{
		//randomly select a program - African and African American studies, BA
		myASUProgramPage.DupApp_chooseThisProgram();
		//careerAdvising section
		myASUProgramPage.careerAdvising(colKey,colValue);

	}

	@Parameters({"colKey","colValue"})
	@Test(priority = 78)
	public void InpersonProgramTest(String colKey,String colValue) throws Throwable
	{
		//Select a program - African and African American studies, BA
		myASUProgramPage.InpersonProgram();
		//careerAdvising section
		myASUProgramPage.careerAdvising(colKey,colValue);

	}
	
	

	@Test(priority = 79)
	public void SaveThePageTest() throws InterruptedException
	{
		myASUProgramPage.SaveThePage();
	}
}






