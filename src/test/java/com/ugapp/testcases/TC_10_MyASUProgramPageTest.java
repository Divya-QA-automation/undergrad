package com.ugapp.testcases;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.ugapp.base.Page;
import com.ugapp.pages.MyASUProgramPage;
public class TC_10_MyASUProgramPageTest extends Page
{
	@Test(priority = 1)
	public void validateMyProgramPage() throws Throwable
	{
		//check for my program page
		waitTillLoaderDisappears();
		Thread.sleep(2000);
		MyASUProgramPage.validateMyProgram();
	}
	


	@Test(priority = 2)
	public void errorText()
	{
		MyASUProgramPage.errorMessage();
	}
	@Test(priority = 3)
	public void academicCalender() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(2000);
		//click on link academic calender
		MyASUProgramPage.calender();
		//validate if link works as expected
		MyASUProgramPage.validateCalender();
	}
	@Test(priority = 4)
	public void SearchForProgram() throws Throwable
	{
		//interest area dropdown and validation
		MyASUProgramPage.interestArea();
		//college dropdown and validation
		MyASUProgramPage.college();
	}
	@Test(priority = 5)
	public void clearFilter() throws Throwable
	{
		//check the selected options and validation
		MyASUProgramPage.checkSelectedOptions();
		//clear all the filters
		MyASUProgramPage.clearAll();
	}
	@Test(priority = 4 , groups={"NonUS_Res_RNBSN_ArmF_AZadd"})
	public void Nursing() throws Throwable
	{
		MyASUProgramPage.searchNursing();
	}

	
	@Parameters({"colKey","colValue"})
	@Test(priority = 6)
	public void chooseProgram(String colKey,String colValue) throws Throwable
	{
		//randomly select a program
		MyASUProgramPage.chooseThisProgram();
		//randomly choose session
		MyASUProgramPage.chooseSession();
		//check for high requirement major
		MyASUProgramPage.highRequirementMajor();
		//careerAdvising section
		MyASUProgramPage.careerAdvising(colKey,colValue);
		
	}
}






