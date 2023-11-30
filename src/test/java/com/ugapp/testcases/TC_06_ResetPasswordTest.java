package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.ResetPasswordPage;

public class TC_06_ResetPasswordTest extends BaseTest{

	ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
	
	@Test(priority=1,groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Refugee_ActiveDuty_PastGrad_OOS"})
	public void ResetPassword() throws Throwable  
	{
		//Verify the Reset password link
		resetPasswordPage.verifyResetPasswordClick();
		
		//validate the reset password link funtionality
		resetPasswordPage.validateResetPassword();
	
		//verify the email textfield
		resetPasswordPage.resetPasswordEmailVerify();
	}
	
	
	@Test(priority=2,groups={"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS","18=>24_NonUS_Res_Refugee_ActiveDuty_PastGrad_OOS"})
	public void setNewPasswordPage() throws Throwable
	{
		//verify the setnewPassowrd Page 
		resetPasswordPage.setNewPasswordVerify();
		
		//back to loginpage
		resetPasswordPage.backToLogin();
	}
}
