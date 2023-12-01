package com.ugapp.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;

import com.ugapp.base.Page;


public class LogInPage extends Page {

	static String parentWindowHandle="";


	public static void logInWithAsurite()
	{
		//check for log in with asurite
		click("loginWithAsurite_XPATH");
	}

	public static void validatelogInWithAsurite() throws Throwable
	{	
		//validate url of log in with asurite
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


	public void validateEmail(String email, String password) throws Throwable
	{
		//valid email regex
		String emailRegex =".*@.*\\..*";
		boolean isEmailValid = email.matches(emailRegex);
		System.out.println("isEmailValid :"+isEmailValid);


		//if email is valid
		if (isEmailValid)
		{
			log.debug("Email is valid: " + email);
			//password regex
			String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{10,}$";
			boolean isPasswordValid = password.matches(passwordRegex);
			System.out.println("isPasswordValid :"+isPasswordValid);

			//if password is not valid
			if(isPasswordValid==false)
			{
				System.out.println("Password is not valid");
				try
				{
					//check for email not found error
					click("logInButton_XPATH");
					Thread.sleep(3000);
					String emailNotFound_XPATH = findElement("emailNotFound_XPATH").getText();
					Assert.assertEquals(emailNotFound_XPATH, "Email not found.");
				}
				catch(Exception e) {}
				driver.navigate().refresh();
			}
			else
			{
				//check for incorrect email or password
				click("logInButton_XPATH");
				Thread.sleep(3000);
				String IncorrectEmailOrPassword_XPATH = findElement("IncorrectEmailOrPassword_XPATH").getText();
				Assert.assertEquals(IncorrectEmailOrPassword_XPATH, "Incorrect email or password.");
				driver.navigate().refresh();
			}
		} 
		else
		{
			//if email is invalid


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
					//if password is invalid
					System.out.println("Invalid email format");
					String errorInvalidEmailFormat = findElement("invalidEmailFormat_XPATH").getText();
					Assert.assertEquals(errorInvalidEmailFormat, "Invalid email format.");
					boolean login=findElement("logInButton_XPATH").isEnabled();
					Assert.assertEquals(false, login);
				}
				catch(Exception e) {
				}

				driver.navigate().refresh();
			}

		}
	}


	public static void validLogIn() throws Throwable
	{
		type("email_XPATH", CreateAccountPage.validEmail); 
		type("password_XPATH", CreateAccountPage.validPassword);   
		click("logInButton_XPATH");
		Thread.sleep(2500);
	}

}






