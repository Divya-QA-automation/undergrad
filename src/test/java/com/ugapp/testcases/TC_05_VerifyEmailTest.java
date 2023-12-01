package com.ugapp.testcases;


import org.testng.annotations.Test;


import com.ugapp.pages.VerifyEmailPage;


public class TC_05_VerifyEmailTest extends BaseTest {


    @Test(priority = 1, groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Veteran_PastGrad_OOS","Lessthan18_US_Res_ActiveDuty_AZ","24yr_NonUS_Res_RNBSN_AForNG_AZ"})
    public void verifyEmail() throws Throwable {
    	
        VerifyEmailPage verifyEmailPage = new VerifyEmailPage();
        
        //verify the email present
        verifyEmailPage.verifyEmail();
        
        //verify login click
        verifyEmailPage.verifyClickLogin();
        
        //verify login button
        verifyEmailPage.LoginInVerify();
        Thread.sleep(2000);
        
        //validate login button
        verifyEmailPage.LoginInValidation();
        Thread.sleep(2000);
        
        //navigate back to verify email page
        verifyEmailPage.back();
        Thread.sleep(2000);
        
        //check resend email
        verifyEmailPage.clickResendEmail();
        Thread.sleep(2000);
        
        //validate resend email
        verifyEmailPage.clickResendEmailValidation();
        Thread.sleep(2000);
        
        verifyEmailPage.LoginInVerify();
        Thread.sleep(2000);
    }     
}




