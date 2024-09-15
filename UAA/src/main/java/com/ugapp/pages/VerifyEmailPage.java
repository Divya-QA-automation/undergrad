package com.ugapp.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.ugapp.base.Page;


public class VerifyEmailPage extends Page {


	public void verifyEmail() throws Throwable {
		waitTillProgressbarDisappears();
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Step 1: Check your email']/following-sibling::p/strong"))  );
		String TestEmail =   element.getText();
		System.out.println("TestEmail :" +TestEmail);
		String testEmail = findElement("testEmail_XPATH").getText();
		String validEmail = CreateAccountPage.validEmail.get();
		//	        String validEmail = CreateAccountPage.validEmail;
		log.debug("TestEmail : " + testEmail);
		log.debug("validEmail : " + validEmail);
		Assert.assertEquals(testEmail, validEmail);
	}



	public void verifyEmailPage() 
	{

		// Check if the email element is visible

		if (getDriver().getCurrentUrl().equals("https://apply-qa.apps.asu.edu/user/verify-email")) 
		{
			log.debug("Successfully redirected to the Verify Email page.");
		} else 
		{
			log.debug("Failed to redirect to the Create Account page.");
		}

		log.debug("----------------------------------------------------");
	}


	public void LoginInVerify() throws InterruptedException
	{
		WebElement elementToScrollTo11 = findElement("loginVerify_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		click("loginVerify_XPATH");
		Thread.sleep(1000);	
	}


	public void LoginInValidation() {
		boolean isLoginToContinueVisible = isElementPresent("loginToContinue_XPATH");
		if (isLoginToContinueVisible) {
			log.debug("Login Validation passed ");
		} else {
			log.debug("Login Validation failed");
		}

		log.debug("----------------------------------------------------");
	}



	public void back()
	{
		getDriver().navigate().back();
	}


	public void clickResendEmail() throws InterruptedException 
	{
		Thread.sleep(2000);
		
		getDriver().findElement(By.xpath("//span[text()='Resend email verification']/..")).click();
	}

	public void clickResendEmailValidation () {
		boolean isResendEmailVisible = isElementPresent("verifyResendEmailValdiation_XPATH");
		if (isResendEmailVisible) {
			log.debug("Resend Email Validation passed");
		} else {
			log.debug("Resend Email Validation failed");
		}
		log.debug("----------------------------------------------------");
	}

	public void AppDetailsCheck () 
	{
		// Check if the Application details section is displayed
		WebElement AppDetailsSection = findElement("AppDetailsSection_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", AppDetailsSection);

		if (AppDetailsSection.isDisplayed()) 
		{
			log.debug("Application details is displayed on the Email verification page.");
		}
		else
		{
			log.debug("Issue with Application details displayed on the Email verification page.");
		}


	}

}


