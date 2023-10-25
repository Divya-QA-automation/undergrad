package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.ReviewPage;

public class TC_14_ReviewTest {

	
	//@Test(priority = 1)
	public void review() throws Throwable
	{
		ReviewPage.validateReview();
	}
	
	
	//@Test(priority = 2)
	public void excel()
	{
		//My Info 1
		ReviewPage.former();
		
		//My program 2
		ReviewPage.career();
		
		//My HighSchoolGrades 4
		ReviewPage.subject();
		
		//writeToExcel
		ReviewPage.writeExcel();
	}
	
	
	@Test(priority = 3)
	public void writeReview()
	{
		
	//	ReviewPage.profileSection();
		
		ReviewPage.myInfoSection();
		
	//	ReviewPage.myProgramSection();
		
	//	ReviewPage.myHighSchoolGradesSection();
		
		ReviewPage.writeReviewData();
	}
	
	
	public void compare()
	{
		
	}
}
