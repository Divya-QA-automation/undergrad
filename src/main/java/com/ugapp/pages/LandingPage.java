package com.ugapp.pages;

import org.openqa.selenium.WebElement;

import com.ugapp.base.Page;

public class LandingPage extends Page
{
	public void ValidateForLogIn() throws InterruptedException
	{
		WebElement loginButton = findElement("LogInBtn_XPATH");

        // Check if the "Log In" button is present on the landing page
        if (loginButton.isDisplayed()) 
        {
        	log.debug("Log In button is present on the landing page.");
            System.out.println("Log In button is present on the landing page.");
            
            // Click the "Log In" button to navigate to the login page
           
            loginButton.click();
            Thread.sleep(2000);
            
            // Check if the URL of the current page is the expected login page URL
            if (driver.getCurrentUrl().equals("https://apply-qa.apps.asu.edu/user/login")) 
            {
            	log.debug("Successfully redirected to the login page.");
                System.out.println("Successfully redirected to the login page.");
            } else 
            {
            	log.debug("Failed to redirect to the login page.");
                System.out.println("Failed to redirect to the login page.");
            }
          
            navigateBack();
        } 
        else 
        {
        	log.debug("Log In button is not present on the landing page.");
            System.out.println("Log In button is not present on the landing page.");
        }
	}
	
	public void ValidateForCreateAcc() throws InterruptedException
	{
		WebElement CreateAccButton = findElement("CreateAccBtn_XPATH");

        // Check if the "Create account" button is present on the landing page
        if (CreateAccButton.isDisplayed()) 
        {
        	log.debug("CreateAccount button is present on the landing page.");
            System.out.println("CreateAccount button is present on the landing page.");
            
            // Click the "create account" button to navigate to the Create account page
           
            CreateAccButton.click();
            Thread.sleep(2000);
            
            // Check if the URL of the current page is the expected create account page URL
            if (driver.getCurrentUrl().equals("https://apply-qa.apps.asu.edu/user/create")) 
            {
            	log.debug("Successfully redirected to the Create Account page.");
            } else 
            {
            	log.debug("Failed to redirect to the Create Account page.");
            }
          
            navigateBack();
        } 
        else 
        {
        	log.debug("Create Account button is not present on the landing page.");
        }
	}
	public void CreateAcc() throws InterruptedException
	{
		WebElement CreateAccButton = findElement("CreateAccBtn_XPATH");

        // Check if the "Create account" button is present on the landing page
        if (CreateAccButton.isDisplayed()) 
        {
        	log.debug("CreateAccount button is present on the landing page.");
            System.out.println("CreateAccount button is present on the landing page.");
            
            // Click the "create account" button to navigate to the Create account page
           
            CreateAccButton.click();
            Thread.sleep(2000);
            
            // Check if the URL of the current page is the expected create account page URL
            if (driver.getCurrentUrl().equals("https://apply-qa.apps.asu.edu/user/create")) 
            {
            	log.debug("Successfully redirected to the Create Account page.");
            } else 
            {
            	log.debug("Failed to redirect to the Create Account page.");
            }
        }
	
}
}