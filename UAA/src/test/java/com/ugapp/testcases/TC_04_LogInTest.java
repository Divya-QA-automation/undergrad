package com.ugapp.testcases;


import org.testng.annotations.Test;

import com.ugapp.base.Page;
import com.ugapp.pages.LogInPage;
import com.ugapp.utilities.Utilities;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;


public class TC_04_LogInTest extends Page {
	LogInPage logInPage = new LogInPage();
	
	
	@Test(priority = 12)
	public void login() throws Throwable
	{
		Thread.sleep(1000);
		logInPage.validLogIn();
	}

	
	@Test(priority = 12)
	public void CreateAccLinkClickTest() throws Throwable
	{
		Thread.sleep(1000);
		logInPage.CreateAccLinkClick();
	}

}




