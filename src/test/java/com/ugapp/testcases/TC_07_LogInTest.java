package com.ugapp.testcases;


import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.ugapp.base.Page;
import com.ugapp.pages.CreateAccountPage;
import com.ugapp.pages.LogInPage;
import com.ugapp.utilities.Utilities;


public class TC_07_LogInTest extends Page {
	LogInPage logInPage = new LogInPage();
	
	@Test(priority=1,groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
	public void LogInUsingAsurite() throws Throwable
	{
		//functionality of logInWith ASUrite button
		LogInPage.logInWithAsurite();
		
		//Validation of LogInWithASURite button functionality
		LogInPage.validatelogInWithAsurite();
	}
	
	
	
//	@Test(priority = 2 ,dataProviderClass = Utilities.class, dataProvider = "dp",groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
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
	
	
	@Test(priority = 3,groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Refugee_ActiveDuty_PastGrad_OOS"})
	public void login() throws Throwable
	{
		Thread.sleep(500);
		LogInPage.validLogIn();
	}

	

}




