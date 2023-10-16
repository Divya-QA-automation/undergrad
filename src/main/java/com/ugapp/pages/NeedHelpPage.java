package com.ugapp.pages;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ugapp.base.Page;

public class NeedHelpPage extends Page
{
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	public void OpenNeedhelp() throws InterruptedException
	{
		WebElement elementToScrollTo1 = findElement("NeedhelpBtn_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("NeedhelpBtn_XPATH");
		Thread.sleep(1000);
	}
	public void ValidateNeedhelp()
	{
		WebElement Title = findElement("NeedhelpTitleCheck_XPATH");
		boolean isElementVisible = Title.isDisplayed();

		if (isElementVisible) {
			log.debug(" Needhelp? page opened successfully ");
		} 
		else 
		{
			log.debug("Issue in displaying the Needhelp? page");
		}
	}
	public void SelectRequest() throws InterruptedException
	{
		Thread.sleep(2000);
		log.debug("Selecting a request option");
		 List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='support-radio']"));
	        int count = radioButtons.size();
	        System.out.println("Number of Radio Buttons: " + count);

	        // Get a random number between 1 and 3
	        int randomIndex = new Random().nextInt(3) + 1;

	        // Click the randomly selected radio button using JavascriptExecutor
	        WebElement selectedRadioButton = radioButtons.get(randomIndex - 1);
	        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", selectedRadioButton);
	        Thread.sleep(1000);
	        // Get the text of the clicked radio button
	        String radioButtonText = selectedRadioButton.getAttribute("value");
	        System.out.println("Clicked Radio Button Text: " + radioButtonText);

	}
	public void AdditionalInfo()
	{
		WebElement elementToScrollTo1 = findElement("AdditionalComments_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		type("AdditionalComments_XPATH","Test");
	}
	public void checkAndValidateTechnicalSupportPhone()
	{
		log.debug("Validating the Technical support Phone link");
		// validate the Text for the link
		WebElement linkElement = driver.findElement(By.linkText("855-278-5080"));
		// Get the href attribute value
		String hrefValue = linkElement.getAttribute("href");
		if (hrefValue != null && !hrefValue.isEmpty()) {
			log.debug("The 855-278-5080 text is a link with URL: " + hrefValue);
		} else {
			log.debug("The text is not a link.");
		}
	}
	public void checkAndValidateEnrollmentSupportPhone()
	{
		 log.debug("Validating the Enrollment support Phone link");
			// validate the Text for the link
			WebElement linkElement = driver.findElement(By.linkText("866-277-6589"));
			// Get the href attribute value
			String hrefValue = linkElement.getAttribute("href");
			if (hrefValue != null && !hrefValue.isEmpty()) {
				log.debug("The 866-277-6589 text is a link with URL: " + hrefValue);
			} else {
				log.debug("The text is not a link.");
			}
	}
	public void checkAndValidateEmail() throws Throwable
	{
		log.debug("Validating the enrollmentonline@asu.edu link");
		// validate the Text for the link
		WebElement linkElement = driver.findElement(By.linkText("enrollmentonline@asu.edu"));
		// Get the href attribute value
		String hrefValue = linkElement.getAttribute("href");
		if (hrefValue != null && !hrefValue.isEmpty()) {
			log.debug("The enrollmentonline@asu.edu text is a link with URL: " + hrefValue);
		} else {
			log.debug("The text is not a link.");
		}
	}

	public void SubmitHelpRequest()
	{
		WebElement elementToScrollTo1 = findElement("SubmitHelpRequest_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("SubmitHelpRequest_XPATH");
	}
	public void ValidateHelpRequest() throws IOException 
	{
		 WebElement successMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[.='Your request has been sent. Please continue with your application and we will reach out to you within one to two business days.'])[1]")));

	        // Fetch the text of the success message
	        String successMessage = successMessageElement.getText();
		verifyEquals(successMessage,"Your request has been sent. Please continue with your application and we will reach out to you within one to two business days.");
	}
	public void CloseNeedhelp()
	{
		WebElement elementToScrollTo1 = findElement("CloseNeedHelp_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		scrollUp(driver, 1);
		click("CloseNeedHelp_XPATH");
	}
	public void validateFooterNeedHelp() throws InterruptedException
	{
		WebElement elementToScrollTo1 = findElement("FloatingNeedHelpBtn_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("FloatingNeedHelpBtn_XPATH");
		Thread.sleep(1000);
	}
	public void ValidateFooterNeedhelpTitle()
	{
		WebElement Title = findElement("NeedhelpFooterTitleCheck_XPATH");
		boolean isElementVisible = Title.isDisplayed();

		if (isElementVisible) {
			log.debug(" Needhelp? page opened successfully ");
		} 
		else 
		{
			log.debug("Issue in displaying the Needhelp? page");
		}
	}
	
	public void CloseFloatingNeedhelp()
	{
		WebElement elementToScrollTo1 = findElement("CloseFloatingNeedHelp_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		scrollUp(driver, 1);
		click("CloseFloatingNeedHelp_XPATH");
	}
	
}
