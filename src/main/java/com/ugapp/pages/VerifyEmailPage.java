package com.ugapp.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


import com.ugapp.base.Page;


public class VerifyEmailPage extends Page {


    
	public void verifyEmail()
	   {
		   String testEmail=findElement("testEmail_XPATH").getText();
		   String validEmail=CreateAccountPage.validEmail;
		   
		   Assert.assertEquals(testEmail, validEmail);
	   }
	
	
    public void verifyClickLogin() 
    {
        // Check if the email element is visible
        boolean isEmailVisible = isElementPresent("verifyYourEmail_XPATH ");


        // Refresh the page if the email element is visible
        if (isEmailVisible) {
            log.debug("Email validation passed ");
        } else {
            log.debug("Email validation failed ");
        }


        log.debug("----------------------------------------------------");
    }
    
    
    public void LoginInVerify() {
        click("loginVerify_XPATH");
    	try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("emailinLogin_XPATH")));
    
    
    public void LoginInValidation() {
    	  boolean isLoginToContinueVisible = isElementPresent("loginToContinue_XPATH");
          // Refresh the page if the email element is visible
          if (isLoginToContinueVisible) {
              log.debug("Login Validation passed ");
          } else {
              log.debug("Login Validation failed");
          }


          log.debug("----------------------------------------------------");
    }
    
    
    
    public void back()
    {
    	navigateBack();
    }
    
    
    public void clickResendEmail() {
    	click("resendEmail_XPATH");
    }
    
    public void clickResendEmailValidation () {
    	  boolean isResendEmailVisible = isElementPresent("verifyResendEmailValdiation_XPATH");


          // Refresh the page if the email element is visible
          if (isResendEmailVisible) {
             log.debug("Resend Email Validation passed");
          } else {
              log.debug("Resend Email Validation failed");
          }


          log.debug("----------------------------------------------------");
    }


    
}




