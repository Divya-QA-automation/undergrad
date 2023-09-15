package com.ugapp.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


import com.ugapp.base.Page;


public class VerifyEmailPage extends Page {


    
	public void verifyEmail() throws InterruptedException
	   {
		Thread.sleep(7000);
		   String testEmail=findElement("testEmail_XPATH").getText();
		   String validEmail=CreateAccountPage.validEmail;
		   System.out.println("testEmail :"+testEmail);
		   System.out.println("validEmail :"+validEmail);
		   Assert.assertEquals(testEmail, validEmail);
	   }
	
	
    public void verifyClickLogin() 
    {
        // Check if the email element is visible
        boolean isEmailVisible = isElementPresent("verifyYourEmail_XPATH ");

System.out.println("isEmailVisible :"+isEmailVisible);
        // Refresh the page if the email element is visible
        if (isEmailVisible) {
            log.debug("Email validation passed ");
        } else {
            log.debug("Email validation failed ");
        }


        log.debug("----------------------------------------------------");
    }
    
    
    public void LoginInVerify()
    {
        click("loginVerify_XPATH");
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
    	driver.navigate().back();
    }
    
    
    public void clickResendEmail() throws InterruptedException {
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//span[text()='Resend email verification']/..")).click();
    	//click("resendEmail_XPATH");
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




