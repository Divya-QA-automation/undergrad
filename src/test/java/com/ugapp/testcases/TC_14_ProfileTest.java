package com.ugapp.testcases;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.ugapp.pages.ProfilePage;


public class TC_14_ProfileTest {


	@Parameters({"colKey","colValue"})
	@Test(priority = 1, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void profile(String colKey,String colValue) throws Throwable
	{
		ProfilePage.openprofile();
		Thread.sleep(1000);
		ProfilePage.validateEmail();
		Thread.sleep(1000);
		ProfilePage.pronouns(colKey,colValue);
		Thread.sleep(1000);
		ProfilePage.gender(colKey,colValue);
	}
	
	@Test(priority = 2, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_OOS"})
	public void dashboard() throws Throwable
	{
		ProfilePage.returnToDashboard();
		Thread.sleep(1000);
		ProfilePage.statusCheck();
		Thread.sleep(1000);
	}
	
	
	
	
}




