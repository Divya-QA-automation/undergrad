package com.ugapp.testcases;


import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ugapp.pages.ProfilePage;


public class TC_14_ProfileTest extends BaseTest
{

	ProfilePage profilepg = new ProfilePage();
	@Parameters({"colKey","colValue"})
	@Test(priority = 141)
	public void profile(String colKey,String colValue) throws Throwable
	{
		profilepg.openprofile();
		profilepg.validateEmail();
		profilepg.pronouns(colKey,colValue);
		profilepg.gender(colKey,colValue);
	}
	
	@Test(priority = 142)
	public void dashboard() throws Throwable
	{
		profilepg.returnToDashboard();
		profilepg.statusCheck();
	}
	
	
	
	
}




