package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.ResetPasswordPage;

import org.testng.annotations.Test;

public class TC_06_ResetPasswordTest extends BaseTest{

	ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
	
	@Test(priority=11,groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
	public void ResetPassword() throws Throwable  
	{
		//Verify the Reset password link
		resetPasswordPage.verifyResetPasswordClick();
		
		//validate the reset password link funtionality
		resetPasswordPage.validateResetPassword();
	
		//verify the email textfield
		resetPasswordPage.resetPasswordEmailVerify();
	}
	
	
	@Test(priority=12,groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
	public void setNewPasswordPage() throws Throwable
	{
		//verify the setnewPassowrd Page 
		resetPasswordPage.setNewPasswordVerify();
		
		//back to loginpage
		resetPasswordPage.backToLogin();
	}
}
