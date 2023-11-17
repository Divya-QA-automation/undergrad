package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.ProfilePage;

public class TC_14_ProfileTest {

	@Test(priority = 1)
	public void profile() throws Throwable
	{
		ProfilePage.openprofile();
		Thread.sleep(1000);
		ProfilePage.validateEmail();
		Thread.sleep(1000);
		ProfilePage.pronouns();
		Thread.sleep(1000);
		ProfilePage.gender();
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
