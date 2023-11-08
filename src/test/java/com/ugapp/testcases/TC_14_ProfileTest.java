package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.ProfilePage;

public class TC_14_ProfileTest {

	@Test(priority = 1)
	public void profile() throws Throwable
	{
		ProfilePage.openprofile();
		
		ProfilePage.validateEmail();
		
		ProfilePage.pronouns();
		
		ProfilePage.gender();
	}
	
	@Test(priority = 2)
	public void dashboard() throws Throwable
	{
		ProfilePage.returnToDashboard();
		
		ProfilePage.statusCheck();
	}
	
	
	
	
}
