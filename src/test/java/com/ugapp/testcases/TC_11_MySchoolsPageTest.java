package com.ugapp.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.ugapp.base.Page;
import com.ugapp.pages.MySchoolsPage;
import com.ugapp.utilities.Utilities;

public class TC_11_MySchoolsPageTest extends Page
{
	MySchoolsPage MySchool = new MySchoolsPage();

	@Test(priority = 1)
	public void validateMySchoolsPage() throws Throwable
	{
		waitTillLoaderDisappears();
		MySchool.ValidateForMySchools();

	} 
	@Test(priority = 2)
	public void RecentHighSchoolTest() throws Throwable
	{
		Thread.sleep(1000);
		MySchool.RecentHighSchool();

	}
	@Test(priority = 3 , dataProviderClass = Utilities.class, dataProvider = "dp")
	public void GraduatingSchoolTest(Hashtable<String, String> data) throws Throwable {
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			MySchool.GraduatingSchool(data.get("State"),data.get("City"),data.get("School_name"),data.get("SAISno"));
			Thread.sleep(1000);
			MySchool.ValidateGraduatingSchool(data.get("State"),data.get("City"),data.get("School_name"),data.get("SAISno"));
			Thread.sleep(1000);
		}
	}
	}

	

