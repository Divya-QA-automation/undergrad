package com.ugapp.testcases;


import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.ugapp.base.Page;
import com.ugapp.pages.CreateAccountPage;
import com.ugapp.pages.LogInPage;
import com.ugapp.utilities.Utilities;


public class TC_07_LogInTest extends Page {
	LogInPage logInPage = new LogInPage();
	
	@Test(priority=7)
	public void LogInUsingAsurite() throws Throwable
	{
		//functionality of logInWith ASUrite button
		LogInPage.logInWithAsurite();
		
		//Validation of LogInWithASURite button functionality
		LogInPage.validatelogInWithAsurite();
	}
	
	
	
	@Test(priority = 8 ,dataProviderClass = Utilities.class, dataProvider = "dp")
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
	
	
	@Test(priority = 9)
	public void login() throws Throwable
	{
//		Thread.sleep(2000);
//		type("email_XPATH", "6769testug@test.asu.edu"); 
//		type("password_XPATH", "Test123123123");   
//		click("logInButton_XPATH");
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Logging in ']/../..")));
//		Thread.sleep(4000);
		LogInPage.validLogIn();
	}
}




