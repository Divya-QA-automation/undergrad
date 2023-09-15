package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.ResetPasswordPage;

public class TC_07_ResetPasswordTest extends BaseTest{

	ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
	
	@Test(priority=5)
	public void ResetPassword() throws Throwable  
	{
	
		//Verify the Reset password link
		resetPasswordPage.verifyResetPasswordClick();
		
		//validate the reset password link funtionality
		resetPasswordPage.validateResetPassword();
	
		//verify the email textfield
		resetPasswordPage.resetPasswordEmailVerify();
	}
	
	
	@Test(priority=6)
	public void setNewPasswordPage() throws Throwable
	{
		//verify the setnewPassowrd Page 
		resetPasswordPage.setNewPasswordVerify();
		
		
		//back to loginpage
		resetPasswordPage.backToLogin();
	}
}
