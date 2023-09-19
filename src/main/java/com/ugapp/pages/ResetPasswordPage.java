package com.ugapp.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ugapp.base.Page;

public class ResetPasswordPage extends Page{

	public void verifyResetPasswordClick() throws Throwable
	{
		click("resetPassword_XPATH");
		Thread.sleep(3000);
	}


	public void validateResetPassword()
	{
		String url=driver.getCurrentUrl();
		if(url.contains("user/reset-password"))
		{
			System.out.println("Reset Password link works as expected");
		}
		else
		{
			System.out.println("Reset Password link does not work");
		}
	}


	public void resetPasswordEmailVerify()
	{
		type("resetPasswordEmail_XPATH","abcdxyz");
		String error=findElement("invalidEmail_XPATH").getText();
		Boolean sendCode = findElement("sendCode_XPATH").isEnabled();
		if(sendCode==false)
			Assert.assertEquals(error, "Invalid email format.");
		type("resetPasswordEmail_XPATH",Keys.CONTROL+"A"+Keys.BACK_SPACE);
		String resetPassowrdEmail = CreateAccountPage.validEmail;
		type("resetPasswordEmail_XPATH",resetPassowrdEmail);
		click("sendCode_XPATH");
	}


	public void setNewPasswordVerify() throws Throwable
	{
		Thread.sleep(2000);
		String setNewPassowrdUrl =driver.getCurrentUrl();
		if(setNewPassowrdUrl.contains("/user/new-password"))
		{
			System.out.println("Send Code button functionality works as expected");
		}
		else
		{
			System.out.println("Send Code button does not work");
		}
	}
	
	public void backToLogin()
	{
		click("returnToLogin_XPATH");
	}
}
