package com.ugapp.testcases;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.ugapp.pages.ProfilePage;


public class TC_14_ProfileTest {


	@Parameters({"colKey","colValue"})
	@Test(priority = 1)
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
	
	@Test(priority = 2)
	public void dashboard() throws Throwable
	{
		ProfilePage.returnToDashboard();
		Thread.sleep(1000);
		ProfilePage.statusCheck();
		Thread.sleep(1000);
	}
	
	
	
	
}




