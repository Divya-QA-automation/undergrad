package com.ugapp.testcases;


import java.util.Hashtable;


import org.testng.SkipException;
import org.testng.annotations.Test;


import com.ugapp.base.Page;
import com.ugapp.pages.FormerNamePage;
import com.ugapp.pages.MyInformationPage;
import com.ugapp.utilities.Utilities;


public class TC_09_MyInformationPageTest extends Page
{
FormerNamePage formerNamePage = new FormerNamePage();


	MyInformationPage myInformationPage = new MyInformationPage();
	@Test(priority = 1)
    public void validateMyInfoPage() throws InterruptedException
    {
		MyInformationPage MyInfo = new MyInformationPage();
		MyInfo.ValidateForMyInfo();
		formerNamePage.scroll();
    }


	@Test(priority = 2 ,dataProviderClass = Utilities.class, dataProvider = "dp")
    public void FormerNameTest(Hashtable<String, String> data) throws Throwable {


    	//Positive and negative testcases for Former Name and validation
        if (!data.get("Runmode").equalsIgnoreCase("Y")) {
            throw new SkipException("Skipping the test case as the Run mode for data set is NO");
        } else {
        	
        				formerNamePage.FormerName(data.get("First_name"), data.get("Last_name"));
			Thread.sleep(3000);
        }
    }
}
