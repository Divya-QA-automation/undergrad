package com.ugapp.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.ugapp.utilities.Utilities;
import com.ugapp.base.Page;
import com.ugapp.pages.PreAppDashboardPage;

public class TC_08_PreAppDashboardTest extends Page{


//	@Test(priority = 10)
	public void validatePreAppSubmissionPage()
	{
		//check for the url of pre app submission page
		
		PreAppDashboardPage.validatePreAppPage();
	}


	@Test(priority = 11 , dataProviderClass = Utilities.class, dataProvider = "dp")
	public void PreAppDashboardTest(Hashtable<String, String> data) throws Throwable {
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			PreAppDashboardPage.userDetails(data.get("firstname"),data.get("preferredfirstname"), data.get("middlename"), data.get("lastname"));  
			Thread.sleep(2000);
			PreAppDashboardPage.validateUserDetails(data.get("firstname"),data.get("preferredfirstname"), data.get("middlename"), data.get("lastname"));
			Thread.sleep(2000);
		}
	}
	
	
	@Test(priority = 12)
	public void PreAppDashboardElements() throws Throwable
	{
		//valid user details
		PreAppDashboardPage.validuser();
		
		//scroll
		PreAppDashboardPage.scroll();
		
		//check the optional tag
		PreAppDashboardPage.checkOptionalTag();
		
		//verify suffix dropdown
		PreAppDashboardPage.verifySuffixDropdown();
		
		//verify Suffix clear button
		PreAppDashboardPage.verifySuffixClear();
		
		//Verify 12 months
		PreAppDashboardPage.verifyMonths();
		
		//verify no of days
		PreAppDashboardPage.verifyDaysPresent();
		
		//verify years present 
		PreAppDashboardPage.verifyYearsPresent();
		
		//verify the clear button on month , year and day
		PreAppDashboardPage.verifyClearButton();
		
		//validate Error message when cleared birth day
		PreAppDashboardPage.validateErrorMessage();
		
		//select valid birthday
		PreAppDashboardPage.Birthday();
		
		//click Start new App
		PreAppDashboardPage.startNewAppbutton();
	}
	
}

