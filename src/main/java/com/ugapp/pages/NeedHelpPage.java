package com.ugapp.pages;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ugapp.base.Page;

public class NeedHelpPage extends Page
{
	public void OpenNeedhelp()
	{
		click("NeedhelpBtn_XPATH");
	}
	public void ValidateNeedhelp()
	{
		WebElement Title = findElement("NeedhelpTitleCheck_XPATH");
		boolean isElementVisible = Title.isDisplayed();

		if (isElementVisible) {
			log.debug(" Needhelp? page opened successfully ");
			CloseNeedhelp();
		} 
		else 
		{
			log.debug("Issue in displaying the Needhelp? page");
		}
	}
	public void SelectRequest()
	{
		List<WebElement> SupportOptions = driver.findElements(By.xpath("//input[@class='custom-control-input']"));

		// Get the count of available options
		int numberOfOptions = SupportOptions.size();

		// Generate a random number within the range of options
		Random random = new Random();
		int randomIndex = random.nextInt(numberOfOptions);

		// Select the random star option by clicking on it
		SupportOptions.get(randomIndex).click();
	}
	public void AdditionalInfo()
	{
		type("AdditionalComments_XPATH","Test");
	}
	public void SubmitHelpRequest()
	{
		click("SubmitHelpRequest_XPATH");
	}
	public void ValidateHelpRequest() throws IOException 
	{
		String successMessage = getText("ConfirmationRequest_XPATH");
		verifyEquals(successMessage,"Your request has been sent. Please continue with your application and we will reach out to you within one to two business days.");
	}
	public void CloseNeedhelp()
	{
		click("CloseNeedHelp_XPATH");
	}
}
