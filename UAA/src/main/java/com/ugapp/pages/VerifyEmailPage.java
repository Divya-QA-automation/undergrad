package com.ugapp.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ugapp.base.Page;


public class VerifyEmailPage extends Page {
	public JavascriptExecutor js = (JavascriptExecutor) getDriver();

	public void verifyEmail() throws Throwable {
		waitTillProgressbarDisappears();
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Step 1: Check your email']/..//p//span"))  );
		String TestEmail =   element.getText();
		System.out.println("TestEmail :" +TestEmail);
		String testEmail = findElement("testEmail_XPATH").getText();
		String validEmail = CreateAccountPage.validEmail.get();
		//	        String validEmail = CreateAccountPage.validEmail;
		log.debug("TestEmail : " + testEmail);
		log.debug("validEmail : " + validEmail);
		Assert.assertEquals(testEmail, validEmail);
	}



	public void verifyEmailPage() {
		WebDriver driver = getDriver(); // Assuming getDriver() returns the WebDriver instance
		String expectedUrl = "https://apply-qa.apps.asu.edu/user/verify-email";

		try {
			// Wait until the email verification element is visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("your-email-element-selector")));

			if (driver.getCurrentUrl().contains(expectedUrl)) {
				log.debug("Successfully redirected to the Verify Email page.");
			} else {
				log.debug("Failed to redirect to the Verify Email page.");
			}
		} catch (Exception e) {
			log.debug("Error: Verify Email page did not load properly.");
			e.printStackTrace();
		}

		log.debug("----------------------------------------------------");
	}


	public void LoginInVerify() throws InterruptedException
	{
		WebElement logInButton = findElement("loginVerify_XPATH");
		Actions actions = new Actions(getDriver());
		actions.moveToElement(logInButton).click().perform();
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


	public void clickResendEmail() throws InterruptedException {
	    By resendEmailBtn = By.xpath("//span[text()='Resend email verification']/..");

	    for (int i = 1; i <= 6; i++) {
	        Thread.sleep(2000); // wait before each click
	        getDriver().findElement(resendEmailBtn).click();
	        Thread.sleep(1000); // wait for alert to appear

	        String alertText = findElement("VerifyEmailAlert_XPATH").getText();
	        System.out.println("Attempt " + i + ": " + alertText);

	        if (i <= 5) {
	            if (!alertText.contains("We have successfully sent you a mail")) {
	                System.out.println("Unexpected alert on attempt " + i);
	            }
	        } else {
	            if (!alertText.contains("The email verification link can only be sent five times per hour")) {
	                System.out.println("Rate-limit message not shown on 6th attempt.");
	            }
	        }
	    }
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


