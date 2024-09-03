package com.ugapp.testcases;


import org.testng.annotations.Test;

import com.ugapp.base.Page;
import com.ugapp.pages.LogInPage;
import com.ugapp.utilities.Utilities;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;


public class TC_07_LogInTest extends Page {
	LogInPage logInPage = new LogInPage();
	
//	@Test(priority=13)
	public void LogInUsingAsurite() throws Throwable
	{
		//functionality of logInWith ASUrite button
		logInPage.logInWithAsurite();
		
		//Validation of LogInWithASURite button functionality
		logInPage.validatelogInWithAsurite();
	}
	
//	@Test(priority = 14 ,dataProviderClass = Utilities.class, dataProvider = "dp")
	public void loginTest(Hashtable<String, String> data) throws Throwable {
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			logInPage.logIn(data.get("email"),data.get("password"));  
			Thread.sleep(2000);
			logInPage.validateEmail(data.get("email"),data.get("password"));
			Thread.sleep(2000);
		}
	}
	
	
	@Test(priority = 15, groups= {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18To24_NonUS_Res_Veteran_PastGrad_OOS"})
	public void login() throws Throwable
	{
		Thread.sleep(1000);
		logInPage.validLogIn();
	}

	

}




