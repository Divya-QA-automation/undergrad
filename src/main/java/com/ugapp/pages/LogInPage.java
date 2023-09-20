package com.ugapp.pages;

import java.util.regex.*;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ugapp.base.Page;


public class LogInPage extends Page {

	static String parentWindowHandle="";


	public static void logInWithAsurite()
	{
		click("loginWithAsurite_XPATH");
	}

	public static void validatelogInWithAsurite() throws Throwable
	{	
		Thread.sleep(2000);
		String URL = driver.getCurrentUrl();
		if(URL.contains("https://weblogin.asu.edu/cas/login"))
		{
			log.debug("Log In With Asurite button works as expected!");
		}
		else
		{
			log.debug("Log In With Asurite button does not work");
		}
		driver.navigate().back();
	}




	public void logIn(String email,String password) {
		type("email_XPATH", email); 
		type("password_XPATH", password);       
	}



	// Working code
	//	 public void validateEmail(String email, String password) {
	//		    try {
	//		        // Check if error element is visible in the DOM
	//		        WebElement errorElement = findElement("emailValidationInLogin_XPATH");
	//		        boolean isElementVisible = errorElement.isDisplayed();
	//
	//		        if (isElementVisible) {
	//		            log.debug("Error message is visible for: " + email);
	//		            log.debug("Refreshing the page...");
	//		            refreshPage();
	//		        } else {
	//		            log.debug("Error message is not visible for: " + email);
	//		            click("Login_XPATH");
	//		            try {
	//		                Thread.sleep(20000);
	//		            } catch (InterruptedException e) {
	//		                e.printStackTrace();
	//		            }
	//		        }
	//		    } catch (NoSuchElementException e) {
	//		        log.debug("Error element not found");
	//		    }
	//
	//		    log.debug("----------------------------------------------------");
	//		}






	public void validateEmail(String email, String password) throws Throwable
	{
		System.out.println("HI");
		//String emailRegex = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,4}$";
		String emailRegex =".*@.*\\..*";
		boolean isEmailValid = email.matches(emailRegex);
		System.out.println("isEmailValid :"+isEmailValid);
		if (isEmailValid)
		{
			log.debug("Email is valid: " + email);
			String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{10,}$";
			boolean isPasswordValid = password.matches(passwordRegex);
			System.out.println("isPasswordValid :"+isPasswordValid);
			if(isPasswordValid==false)
			{
				System.out.println("Password is not valid");
				try
				{
					System.out.println("email not found");
					click("logInButton_XPATH");
					Thread.sleep(3000);
					String emailNotFound_XPATH = findElement("emailNotFound_XPATH").getText();
					Assert.assertEquals(emailNotFound_XPATH, "Email not found.");
				}
				catch(Exception e) {}
				System.out.println("Above refresh Password is not valid");
				driver.navigate().refresh();
			}
			else
			{
				System.out.println("Password is valid :"+password);
				System.out.println("Incorrect email or password");
				click("logInButton_XPATH");
				Thread.sleep(3000);
				String IncorrectEmailOrPassword_XPATH = findElement("IncorrectEmailOrPassword_XPATH").getText();
				Assert.assertEquals(IncorrectEmailOrPassword_XPATH, "Incorrect email or password.");
				driver.navigate().refresh();
			}
		} 
		else
		{
			//email contains @ and .
			String regexPattern = ".*@.*\\..*";
			Pattern pattern = Pattern.compile(regexPattern);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches())
			{
				System.out.println("The string contains both '@' and '.' symbols.");
			} 
			else 
			{
				try
				{
					System.out.println("Invalid email format");
					String errorInvalidEmailFormat = findElement("invalidEmailFormat_XPATH").getText();
					Assert.assertEquals(errorInvalidEmailFormat, "Invalid email format.");
					boolean login=findElement("logInButton_XPATH").isEnabled();
					Assert.assertEquals(false, login);
				}
				catch(Exception e) {
					System.out.println("Something went wrong!");
				}

				System.out.println("Above refresh Invalid email format");
				driver.navigate().refresh();
			}

		}
	}
	
	
	
	
	public static void validLogIn()
	{
		type("email_XPATH", CreateAccountPage.validEmail); 
		type("password_XPATH", CreateAccountPage.validPassword);   
		click("logInButton_XPATH");
	}
	
}






