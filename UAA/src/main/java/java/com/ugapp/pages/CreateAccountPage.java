package java.com.ugapp.pages;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.com.ugapp.base.Page;
public class CreateAccountPage extends Page
{
	//	public static String validInputEmail;
	public static ThreadLocal<String> validInputEmail = new ThreadLocal<>();
	public static ThreadLocal<String> validInputReEmail = new ThreadLocal<>();
	public static ThreadLocal<String> validPassword = new ThreadLocal<>();

	WebElement createAccount;
	List<WebElement> errorMessage;
	public void OpenAndValidateCreateAcc() throws Throwable 
	{
		//click on create account and validate URl
		Thread.sleep(2000);
		click("CreateAccBtn_XPATH");
		Thread.sleep(500);
		if (getDriver().getCurrentUrl().equals("https://apply-qa.apps.asu.edu/user/create")) 
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
		//validate element present in login page
		Boolean loginToContinue = isElementPresent("loginToContinue_XPATH");
		if(loginToContinue)
			log.debug("Log in here link works as expected!");
		getDriver().navigate().back();
	}




	public void clickValidateCreateAnAccountLink() throws InterruptedException
	{
		//to check create an account here link functionality
		String parentWindowHandle = getDriver().getWindowHandle();
		click("createAnAccountHere_XPATH");
		Thread.sleep(2000);
		Set<String> windowID = getDriver().getWindowHandles();
		for(String wid:windowID)
		{
			getDriver().switchTo().window(wid);
			String URL = getDriver().getCurrentUrl();
			if(URL.contains("https://webapp4.asu.edu/uga_admissionsapp/"))
			{
				log.debug("Create An Account here link works as expected!");
				getDriver().close();
			}
		}
		getDriver().switchTo().window(parentWindowHandle);
	}




	public void checkAndValidateEnrollmentSupportPhone() throws InterruptedException
	{
		//to check for phone and email visibility
		Thread.sleep(2000);
		String expectedPhone = "866-277-6589";
		WebElement phone=findElement("phone_XPATH");
		String actualPhone=phone.getText();
		if(phone.isDisplayed())
			Assert.assertEquals(expectedPhone, actualPhone);
	}




	public void checkAndValidateEmail() throws Throwable
	{
		//validate the emaail present in create account page
		Thread.sleep(2000);
		String expectedEmail = "enrollmentonline@asu.edu";
		WebElement email=findElement("emaill_XPATH");
		String actualEmail=email.getText();
		if(email.isDisplayed())
			Assert.assertEquals(expectedEmail, actualEmail);
	}





	public void ValidateApplicationGuide() throws InterruptedException
	{
		WebElement elementToScrollTo2 = getDriver().findElement(By.xpath("//div[@data-cy='portal-block-app-quick-facts-application-guide']//a"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		log.debug("Validate the Application guide");
		String mainWindowHandle = getDriver().getWindowHandle();
		WebElement link = getDriver().findElement(By.xpath("//div[@data-cy='portal-block-app-quick-facts-application-guide']//a"));
		String linkText = link.getText();
		click("CreateaccEmailVerifyAppGuide_XPATH");
		Thread.sleep(1000);
		for (String windowHandle : getDriver().getWindowHandles()) 
		{
			if (!windowHandle.equals(mainWindowHandle)) 
			{
				getDriver().switchTo().window(windowHandle);

				// Validate the actual URL or title
				String actualUrl = getDriver().getCurrentUrl();
				// Create a map to store expected URLs or titles for each link
				Map<String, String> expectedLinks = new HashMap<>();
				expectedLinks.put("application guide", "https://future.asuonline.asu.edu/undergrad/application-guide");

				if (expectedLinks.containsKey(linkText)) {
					String expectedUrl = expectedLinks.get(linkText);

					if (actualUrl.equals(expectedUrl)) {
						log.debug("Link '" + linkText + "' navigated to the expected URL.");
					} else 
					{
						log.debug("Link '" + linkText + "' did not navigate to the expected URL.");
					}
				} else 
				{
					log.debug("No expected URL found for link '" + linkText + "'.");
				}

				// Close the new tab or window
				getDriver().close();

				// Switch back to the main window
				getDriver().switchTo().window(mainWindowHandle);
			}
		}

	}


	public void createAccount(String email, String reemail, String password, String repassword) throws Throwable {
		type("email_XPATH", email);
		type("reemail_XPATH", reemail);
		type("password_XPATH", password);
		type("repassword_XPATH", repassword);
	}








	public void validateAccount(String email, String reemail, String password, String repassword) throws Exception 
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
		errorMessage = getDriver().findElements(By.xpath("//div[@class='invalid-feedback']"));
		createAccount=findElement("CreateAccountBtn_XPATH");
		Boolean button=findElement("CreateAccountBtn_XPATH").isEnabled();








		// Refresh the page if any error elements are visible
		if(button==false)
		{
			log.debug("Refreshing the page...");
			getDriver().navigate().refresh();
		}
		else if(createAccount.isEnabled() || errorMessage.size()==0)
		{
			Random random = new Random();
			int randomNumber = 10000 + random.nextInt(90000);
			validInputEmail.set(email); 
			validInputReEmail.set(reemail); 
			validPassword.set(password);
			validEmail.set(String.valueOf(randomNumber) + validInputEmail.get()); 
			Thread.sleep(2000);
			//clear the email and reemail fields
			WebElement emailtextfield = findElement("email_XPATH");
			WebElement reemailtextfield = findElement("reemail_XPATH");
			emailtextfield.clear();
			reemailtextfield.clear();
		}
		log.debug("----------------------------------------------------");
	}



	public void CreateRandomAcc(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		validInputEmail.set("@test.asu.edu");
		Random random = new Random();
		int randomNumber = 100000 + random.nextInt(900000);
		validEmail.set(String.valueOf(randomNumber) + validInputEmail.get()); 
		validPassword.set("Testing10!");
		Thread.sleep(1000);
		type("email_XPATH", validEmail.get());
		type("reemail_XPATH", validEmail.get());
		type("password_XPATH", "Testing10!");
		type("repassword_XPATH", "Testing10!");
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 0, "Email", validEmail.get());
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		log.debug("VALID EMAIL :"+validEmail.get());
		log.debug("VALID PASSWORD :"+validPassword.get());
		click("CreateAccountBtn_XPATH");
		Thread.sleep(2000);
	}




	public void validInput(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{

		//send valid email inputs
		Thread.sleep(1000);
		type("email_XPATH", validEmail.get());
		type("reemail_XPATH", validEmail.get());
		waitUntilExcelFileIsNotEmpty(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 0, "Email", validEmail.get());
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		log.debug("VALID EMAIL :"+validEmail.get());
		log.debug("VALID PASSWORD :"+validPassword.get());
		click("CreateAccountBtn_XPATH");
		Thread.sleep(4000);

	}




}
































