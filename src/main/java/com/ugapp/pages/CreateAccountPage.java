package com.ugapp.pages;
import org.openqa.selenium.JavascriptExecutor;
import java.util.ArrayList;
import java.util.Random;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.ugapp.base.Page;
public class CreateAccountPage extends Page 
{
	public static String validInputEmail;
	public void OpenAndValidateCreateAcc() 
	{
		click("CreateAccBtn_XPATH");
		if (driver.getCurrentUrl().equals("https://apply-qa.apps.asu.edu/user/create")) 
		{
			log.debug("Successfully redirected to the Create Account page.");
		} else 
		{
			log.debug("Failed to redirect to the Create Account page.");
		}

	}
	public void clickLogInHereLink() throws InterruptedException
	{
		//to check log in here link funcionality
		click("loginhere_XPATH");
		Thread.sleep(2000);
	}
	public void validateClickLoginInHereLink()
	{
		Boolean loginToContinue = isElementPresent("loginToContinue_XPATH");
		if(loginToContinue)
			log.debug("Log in here link works as expected!");
		driver.navigate().back();
	}
	public void clickValidateCreateAnAccountLink() throws InterruptedException
	{
		//to check create an account here link functionality
		String parentWindowHandle = driver.getWindowHandle();
		click("createAnAccountHere_XPATH");
		Thread.sleep(2000);
		Set<String> windowID = driver.getWindowHandles();
		for(String wid:windowID)
		{
			driver.switchTo().window(wid);
			String URL = driver.getCurrentUrl();
			if(URL.contains("https://webapp4.asu.edu/uga_admissionsapp/"))
			{
				log.debug("Create An Account here link works as expected!");
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle);
	}


	public void checkAndValidateEnrollmentSupportPhone()
	{
		//to check for phone and email visibility
		String expectedPhone = "866-277-6589";
		WebElement phone=findElement("phone_XPATH");
		String actualPhone=phone.getText();
		if(phone.isDisplayed())
			Assert.assertEquals(expectedPhone, actualPhone);
	}



	public void checkAndValidateEmail() throws Throwable
	{
		Thread.sleep(2000);
		String expectedEmail = "enrollmentonline@asu.edu";
		WebElement email=findElement("emaill_XPATH");
		String actualEmail=email.getText();
		if(email.isDisplayed())
			Assert.assertEquals(expectedEmail, actualEmail);
	}



	public void createAccount(String email, String reemail, String password, String repassword) throws Throwable {
		type("email_XPATH", email);
		type("reemail_XPATH", reemail);
		type("password_XPATH", password);
		type("repassword_XPATH", repassword);
	}



	public void validateAccount(String email, String reemail, String password, String repassword) throws InterruptedException 
	{
		// Standard Email format validation
		String emailRegex = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,4}$";


		if (!email.matches(emailRegex)) {
			try {
				WebElement errorElement = findElement("emailValidation_XPATH");
				String emailError=findElement("emailValidation_XPATH").getText();
				boolean isElementVisible = errorElement.isDisplayed();
				if (isElementVisible) {
					Assert.assertEquals(emailError, "Invalid email format.");
					log.debug("Error message is visible for: Invalid email format.");
				} else {
					log.debug("Error message is not visible for: Invalid email format.");
				}
			} catch (Exception e) {
				log.debug("Error element not found for: Invalid email format.");
			}
		}

		// Reentered Email validation logic
		boolean isReemailValid = reemail.matches(emailRegex);
		if (isReemailValid)
		{
			log.debug("Email is valid: " + reemail);
			if (reemail.equals(email))
			{
				log.debug("Retyped email matches the previously passed email.");
			}
			else
			{
				log.debug("Retyped email does not match the previously passed email.");
				try
				{
					WebElement errorElement = findElement("reemailValidation_XPATH");
					WebElement errorElement1 = findElement("reemailValidation_XPATH1");
					String reEmailError= findElement("reemailValidation_XPATH").getText();
					String reEmailError1=findElement("reemailValidation_XPATH1").getText();
					boolean isElementVisible = errorElement.isDisplayed() || errorElement1.isDisplayed();
					if (isElementVisible)
					{
						try
						{
							Assert.assertEquals(reEmailError, "Email does not match.");
						}
						catch(Exception e)
						{
							Assert.assertEquals(reEmailError1, "Invalid email format.");
						}
						log.debug("Error message is visible in Reenter Email.");
					}
					else
					{
						log.debug("Error message is not visible in Reenter Email.");
					}
				}
				catch (NoSuchElementException e)
				{
					log.debug("Error element not found in Reenter Email");
				}
			}
		}


		// Password validation logic
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{10,}$";
		boolean isPasswordValid = password.matches(passwordRegex);
		// Check if password is at least 10 characters long
		if (password.length() < 10) {
			try {
				WebElement errorElement = findElement("passwordValidation10_XPATH");
				boolean isElementVisible = errorElement.isDisplayed();
				if (isElementVisible)
				{
					String actualErrorMessage = errorElement.getText();
					if (actualErrorMessage.equals("The password must be at least 10 characters long."))
					{
						Assert.assertEquals(actualErrorMessage, "The password must be at least 10 characters long.");
						log.debug("Correct error message displayed: " + actualErrorMessage);
					}
					else
					{
						log.debug("Incorrect error message displayed. Expected: The password must be at least 10 characters long., Actual: " + actualErrorMessage);
					}
				}
				else
				{
					log.debug("Error message is not visible for: The password must be at least 10 characters long.");
				}
			}
			catch (NoSuchElementException e)
			{
				log.debug("Error element not found for: The password must be at least 10 characters long.");
			}
		}

		// Check if password contains at least 1 number
		if (!password.matches(".*\\d.*")) {
			try {
				WebElement errorElement = findElement("passwordValidation1_XPATH");
				boolean isElementVisible = errorElement.isDisplayed();
				if (isElementVisible) {
					String actualErrorMessage = errorElement.getText();
					if (actualErrorMessage.equals("The password must contain at least 1 number.")) {
						Assert.assertEquals(actualErrorMessage, "The password must contain at least 1 number.");
						log.debug("Correct error message displayed: " + actualErrorMessage);
					} else {
						log.debug("Incorrect error message displayed. Expected: The password must contain at least 1 number., Actual: " + actualErrorMessage);
					}
				} else {
					log.debug("Error message is not visible for: The password must contain at least 1 number.");
				}
			} catch (NoSuchElementException e) {
				log.debug("Error element not found for: The password must contain at least 1 number.");
			}
		}


		// Check if password contains at least 1 uppercase letter
		if (!password.matches(".*[A-Z].*")) {
			try {
				WebElement errorElement = findElement("passwordValidation1U_XPATH");
				boolean isElementVisible = errorElement.isDisplayed();
				if (isElementVisible) {
					String actualErrorMessage = errorElement.getText();
					if (actualErrorMessage.equals("The password must contain at least 1 uppercase letter.")) {
						Assert.assertEquals(actualErrorMessage, "The password must contain at least 1 uppercase letter.");
						log.debug("Correct error message displayed: " + actualErrorMessage);
					} else {
						log.debug("Incorrect error message displayed. Expected: The password must contain at least 1 uppercase letter., Actual: " + actualErrorMessage);
					}
				} else {
					log.debug("Error message is not visible for: The password must contain at least 1 uppercase letter.");
				}
			} catch (NoSuchElementException e) {
				log.debug("Error element not found for: The password must contain at least 1 uppercase letter.");
			}
		}


		// Check if password contains at least 1 lowercase letter
		if (!password.matches(".*[a-z].*")) {
			try {
				WebElement errorElement = findElement("passwordValidation1L_XPATH");
				boolean isElementVisible = errorElement.isDisplayed();
				if (isElementVisible) {
					String actualErrorMessage = errorElement.getText();
					if (actualErrorMessage.equals("The password must contain at least 1 lowercase letter.")) {
						Assert.assertEquals(actualErrorMessage, "The password must contain at least 1 lowercase letter.");
						log.debug("Correct error message displayed: " + actualErrorMessage);
					} else {
						log.debug("Incorrect error message displayed. Expected: The password must contain at least 1 lowercase letter., Actual: " + actualErrorMessage);
					}
				} else {
					log.debug("Error message is not visible for: The password must contain at least 1 lowercase letter.");
				}
			} catch (NoSuchElementException e) {
				log.debug("Error element not found for: The password must contain at least 1 lowercase letter.");
			}
		}



		// Check if any error elements are visible
		List<WebElement> errorMessage = driver.findElements(By.xpath("//div[@class='invalid-feedback']"));
		WebElement createAccount=findElement("CreateAccountBtn_XPATH");
		Boolean button=findElement("CreateAccountBtn_XPATH").isEnabled();
		//driver.findElement(By.xpath("//input[@id='__BVID__47']")).isDisplayed();
		// Refresh the page if any error elements are visible


		if(button==false)
		{
			//driver.findElement(By.xpath("//input[@id='__BVID__47']"));
			log.debug("Refreshing the page...");
			driver.navigate().refresh();
		}
		else if(createAccount.isEnabled() || errorMessage.size()==0)
		{
			// Generate a random four-digit number
			Random random = new Random();
			int randomNumber = 1000 + random.nextInt(9000);
			validInputEmail=email;
			validInputReEmail=reemail;
			validPassword=password;
			validEmail=String.valueOf(randomNumber) + validInputEmail; 

			Thread.sleep(2000);
			//clear the email and reemail fields
//			performKeyboardAction(findElement("email_XPATH"), "clear");
//			performKeyboardAction(findElement("reemail_XPATH"), "clear");
			WebElement emailtextfield = findElement("email_XPATH");
			WebElement reemailtextfield = findElement("reemail_XPATH");
			emailtextfield.clear();
			
			reemailtextfield.clear();
			
			
			//send valid email inputs
			type("email_XPATH", validEmail);
			type("reemail_XPATH", validEmail);
			
			
			
			System.out.println("VALID EMAIL :"+validEmail);
			System.out.println("VALID PASSWORD :"+validPassword);
			click("CreateAccountBtn_XPATH");
			Thread.sleep(4000);
		}
		log.debug("----------------------------------------------------");
	}
}






