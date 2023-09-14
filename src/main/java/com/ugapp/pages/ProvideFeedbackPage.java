package com.ugapp.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ugapp.base.Page;

public class ProvideFeedbackPage extends Page

{
	public void OpenFeedback()
	{
		click("ProvideFeedback_XPATH");
	}
	public void RateYourExperience()
	{
		List<WebElement> starOptions = driver.findElements(By.xpath("//span[@class='b-rating-icon']"));

		// Get the count of available star rating options
		int numberOfOptions = starOptions.size();

		// Generate a random number within the range of star options
		Random random = new Random();
		int randomIndex = random.nextInt(numberOfOptions);

		// Select the random star option by clicking on it
		starOptions.get(randomIndex).click();
	}
	public void TellAboutYourExperience()
	{
		type("TellAboutYourExp_ID", "Test");
	}
	public void SubmitFeedback()
	{
		click("SubmitFeedbackBtn_XPATH");

	}
	public void CancelFeedback()
	{
		click("CancelBtn_XPATH");
	}
	public void CloseFeedback()
	{
		click("CloseBtn_XPATH");
	}
	public void ValidateFeedback() 
	{
		WebElement Title = findElement("Feedback_XPATH");
        boolean isElementVisible = Title.isDisplayed();

        if (isElementVisible) {
            log.debug(" Feedback form opened successfully ");
            System.out.println(" Feedback form opened successfully ");
            CloseFeedback();
        } 
        else 
        {
            log.debug("Issue in displaying the Feedback page");
            System.out.println(" Feedback form opened successfully ");
	}
}}
