package java.com.ugapp.pages;

import org.testng.Assert;

import java.com.ugapp.base.Page;

public class ResetPasswordPage extends Page
{
//	CreateAccountPage createacc = new CreateAccountPage();

	public void verifyResetPasswordClick() throws Throwable
	{
		click("resetPassword_XPATH");
		Thread.sleep(3000);
	}


	public void validateResetPassword()
	{
		String url=getDriver().getCurrentUrl();
		if(url.contains("user/reset-password"))
		{
			log.debug("Reset Password link works as expected");
		}
		else
		{
			log.debug("Reset Password link does not work");
		}
	}


	public void resetPasswordEmailVerify()
	{
		//positive and negative testcases for reset email text field
		type("resetPasswordEmail_XPATH","abcdxyz");
		String error=findElement("invalidEmail_XPATH").getText();
		Boolean sendCode = findElement("sendCode_XPATH").isEnabled();
		if(sendCode==false)
			Assert.assertEquals(error, "Invalid email format.");
		findElement("resetPasswordEmail_XPATH").clear();
		String resetPassowrdEmail = CreateAccountPage.validEmail.get();
		type("resetPasswordEmail_XPATH",resetPassowrdEmail);
		click("sendCode_XPATH");
	}


	public void setNewPasswordVerify() throws Throwable
	{
		//check for the set new password page url
		Thread.sleep(3000);
		String setNewPassowrdUrl =getDriver().getCurrentUrl();
		if(setNewPassowrdUrl.contains("/user/new-password"))
		{
			log.debug("Send Code button functionality works as expected");
		}
		else
		{
			log.debug("Send Code button does not work");
		}
	}
	
	public void backToLogin()
	{
		click("returnToLogin_XPATH");
	}
}
