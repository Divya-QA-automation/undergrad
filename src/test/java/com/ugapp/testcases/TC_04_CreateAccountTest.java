package com.ugapp.testcases;




import java.util.Hashtable;
import org.testng.annotations.Test;
import org.testng.SkipException;
import com.ugapp.pages.CreateAccountPage;
import com.ugapp.utilities.Utilities;




public class TC_04_CreateAccountTest extends BaseTest {




	CreateAccountPage createAccountPage = new CreateAccountPage();
	@Test(priority=1)
	public void verifyCreateAcc() throws Throwable
	{
		createAccountPage.OpenAndValidateCreateAcc();
	}
	
	@Test(priority=2)
	public void checkLinksInCreateAccount() throws Throwable
	{
		//log in here link functionality
    	createAccountPage.clickLogInHereLink();
    	
    	//log in here validation
    	createAccountPage.validateClickLoginInHereLink();
    	
    	//Create an account here link functionality and validation
    	//createAccountPage.clickValidateCreateAnAccountLink();
    	
    	//phone functionality and validation
    	createAccountPage.checkAndValidateEnrollmentSupportPhone();
    	
    	//email functionality and validation
    	createAccountPage.checkAndValidateEmail();
	}
	
	
    @Test(priority = 3 ,dataProviderClass = Utilities.class, dataProvider = "dp")
    public void createAccountTest(Hashtable<String, String> data) throws Throwable {

    	//Positive and negative testcases for CreateAccount and validation
        if (!data.get("Runmode").equalsIgnoreCase("Y")) {
            throw new SkipException("Skipping the test case as the Run mode for data set is NO");
        } else {
            createAccountPage.createAccount(data.get("email"), data.get("reemail"), data.get("password"), data.get("repassword"));
            Thread.sleep(4000);
            createAccountPage.validateAccount(data.get("email"), data.get("reemail"), data.get("password"), data.get("repassword"));
            }
        
    }
}










