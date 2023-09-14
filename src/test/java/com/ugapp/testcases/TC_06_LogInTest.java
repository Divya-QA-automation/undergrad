package com.ugapp.testcases;


import java.util.Hashtable;


import org.testng.SkipException;
import org.testng.annotations.Test;


import com.ugapp.pages.LogInPage;
import com.ugapp.utilities.Utilities;


public class TC_06_LogInTest extends BaseTest {
	LogInPage logInPage = new LogInPage();
	
	@Test(priority=4)
	public void checkLinksInLogin()
	{
		
	}
	
	@Test(priority = 5 ,dataProviderClass = Utilities.class, dataProvider = "dp")
	public void loginTest(Hashtable<String, String> data) throws InterruptedException {
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		} else {
			logInPage.logIn(data.get("email"),data.get("password"));  
			Thread.sleep(2000);
			logInPage.validateEmail(data.get("email"),data.get("password"));
			Thread.sleep(2000);
		}
	}
}




