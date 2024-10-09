package com.ugapp.testcases;


import org.testng.annotations.Test;

import com.ugapp.pages.VerifyEmailPage;

import org.testng.annotations.Test;


public class TC_02_VerifyEmailTest extends BaseTest {


	@Test(priority = 8)
	public void verifyEmailTest() throws Throwable 
	{

		VerifyEmailPage verifyEmailPage = new VerifyEmailPage();

		//verify the email verification page
		verifyEmailPage.verifyEmailPage();
		
		// verify the App details section
		verifyEmailPage.AppDetailsCheck();

		//verify the email present
		verifyEmailPage.verifyEmail();

		//verify login button
		verifyEmailPage.LoginInVerify();

		//validate login button
		verifyEmailPage.LoginInValidation();

		//navigate back to verify email page
		verifyEmailPage.back();

		//check resend email
		verifyEmailPage.clickResendEmail();

		//validate resend email
		verifyEmailPage.clickResendEmailValidation();
//
		verifyEmailPage.LoginInVerify();


	}     
}




