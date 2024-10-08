package com.ugapp.pages;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ugapp.base.Page;

public class NeedHelpPage extends Page
{
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	public void OpenNeedhelp() throws InterruptedException
	{
		WebElement elementToScrollTo1 = findElement("NeedhelpBtn_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("NeedhelpBtn_XPATH");
		Thread.sleep(1000);
	}
	public void ValidateNeedhelp()
	{
		WebElement Title = findElement("NeedhelpTitleCheck_XPATH");
		boolean isElementVisible = Title.isDisplayed();

		if (isElementVisible) 
		{
			log.debug(" Needhelp? page opened successfully ");
		} 
		else 
		{
			log.debug("Issue in displaying the Needhelp? page");
		}
	}


	public void ValidateNeedhelp_F1()
	{
		WebElement Title = findElement("NeedhelpTitleCheckF1_XPATH");
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
		List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='support-radio']"));
		int count = radioButtons.size();

		// Get a random number between 1 and 3
		int randomIndex = new Random().nextInt(3) + 1;

		// Click the randomly selected radio button using JavascriptExecutor
		WebElement selectedRadioButton = radioButtons.get(randomIndex - 1);
		((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", selectedRadioButton);
		Thread.sleep(1000);
		// Get the text of the clicked radio button
		String radioButtonText = selectedRadioButton.getAttribute("value");
		log.debug("Selectd Need help request option :"+radioButtonText);
	}
	public void SelectRequestF1() throws InterruptedException
	{
		Thread.sleep(2000);
		log.debug("Selecting a request option");
		List<WebElement> radioButtons = getDriver().findElements(By.xpath("(//input[@name='support-radio'])[position()>=7 and position()<=9 ]"));
		int count = radioButtons.size();

		// Get a random number between 7 and 9
		int randomIndex = new Random().nextInt(3) + 1;

		// Click the randomly selected radio button using JavascriptExecutor
		WebElement selectedRadioButton = radioButtons.get(randomIndex - 1);
		((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", selectedRadioButton);
		Thread.sleep(1000);
		// Get the text of the clicked radio button
		String radioButtonText = selectedRadioButton.getAttribute("value");
		log.debug("Selectd Need help request option :"+radioButtonText);
	}


	public void AdditionalInfo()
	{
		WebElement elementToScrollTo1 = findElement("AdditionalComments_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		type("AdditionalComments_XPATH","Test");
	}

	public void AdditionalInfo_F1()
	{
		WebElement elementToScrollTo1 = findElement("AdditionalCommentsF1_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		type("AdditionalCommentsF1_XPATH","Test");
	}
	public void checkAndValidateTechnicalSupportPhone()
	{
		log.debug("Validating the Technical support Phone link");
		// validate the Text for the link
		WebElement linkElement = getDriver().findElement(By.linkText("855-278-5080"));
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
		WebElement linkElement = getDriver().findElement(By.linkText("866-277-6589"));
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
		WebElement linkElement = getDriver().findElement(By.linkText("enrollmentonline@asu.edu"));
		// Get the href attribute value
		String hrefValue = linkElement.getAttribute("href");
		if (hrefValue != null && !hrefValue.isEmpty()) {
			log.debug("The enrollmentonline@asu.edu text is a link with URL: " + hrefValue);
		} else {
			log.debug("The text is not a link.");
		}
	}

	public void SubmitHelpRequest() throws InterruptedException
	{
		WebElement elementToScrollTo1 = findElement("SubmitHelpRequest_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("SubmitHelpRequest_XPATH");
		Thread.sleep(3000);
	}


	public void SubmitHelpRequestF1() throws InterruptedException
	{
		WebElement elementToScrollTo1 = findElement("SubmitHelpRequestF1_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("SubmitHelpRequestF1_XPATH");
		Thread.sleep(2000);
	}

	public void ValidateHelpRequest() throws IOException, InterruptedException 
	{

		WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[.='Your request has been sent. Please continue with your application and we will reach out to you within one to two business days.'])[2]")));

		// Fetch the text of the success message
		String successMessage = successMessageElement.getText();
		System.out.println("successMessage :"+successMessage);
		verifyEquals(successMessage,"Your request has been sent. Please continue with your application and we will reach out to you within one to two business days.");
		Thread.sleep(1000);
	}
	public void CloseNeedhelp() throws InterruptedException
	{
		WebElement elementToScrollTo1 = findElement("CloseNeedHelp_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		scrollUp(getDriver(), 1);
		click("CloseNeedHelp_XPATH");
		Thread.sleep(1000);
	}
	public void CloseNeedhelpPreApp()
	{
		WebElement elementToScrollTo1 = findElement("BackBtnNeedHelpPreApp_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("BackBtnNeedHelpPreApp_XPATH");
	}

	public void CloseNeedhelp_F1()
	{
		WebElement elementToScrollTo1 = findElement("BackBtnNeedHelpF1_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		scrollUp(getDriver(), 1);
		click("BackBtnNeedHelpF1_XPATH");
	}

	public void validateFooterNeedHelp() throws InterruptedException
	{
		WebElement elementToScrollTo1 = findElement("FloatingNeedHelpBtn_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
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

	public void CloseFloatingNeedhelp() throws InterruptedException
	{
		WebElement elementToScrollTo1 = findElement("CloseFloatingNeedHelp_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		scrollUp(getDriver(), 1);
		click("CloseFloatingNeedHelp_XPATH");
		Thread.sleep(1000);
	}
	public void ValidateAppguide() throws InterruptedException
	{
		WebElement elementToScrollTo1 = findElement("PreappNeedhelpAppGuide_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		log.debug("Validate the Application guide");
		String mainWindowHandle = getDriver().getWindowHandle();
		WebElement link = getDriver().findElement(By.xpath("(//div[@data-cy='portal-form-need-help-application-guide']//a)[3]"));
		String linkText = link.getText();
		click("PreappNeedhelpAppGuide_XPATH");
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



}
