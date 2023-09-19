package com.ugapp.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ugapp.base.Page;

public class ProvideFeedbackPage extends Page

{
	public void OpenFeedback() throws InterruptedException
	{
		click("ProvideFeedback_XPATH");
		Thread.sleep(2000);
	}
	public void RateYourExperience()
	{
		
		List<WebElement> starOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//output//span[@class='b-rating-icon']")));

		// Get the count of available star rating options
		int numberOfOptions = starOptions.size();
		System.out.println(numberOfOptions);

		// Generate a random number within the range of star options
		Random random = new Random();
		int randomIndex = random.nextInt(numberOfOptions);

		// Select the random star option by clicking on it
		WebElement starToClick = wait.until(ExpectedConditions.elementToBeClickable(starOptions.get(randomIndex)));
		starToClick.click();		
	
	}
	public void TellAboutYourExperience() throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println("feedbackkkkkk");
		type("TellAboutYouExp_XPATH", "Testing........");
		Thread.sleep(2000);
	}
	public void SubmitFeedback() throws InterruptedException
	{
		click("SubmitFeedbackBtn_XPATH");
		Thread.sleep(2000);

	}
	public void CancelFeedback()
	{
		click("CancelBtn_XPATH");
	}
	public void CloseFeedback()
	{
		click("CloseBtn_XPATH");
	}
	public void ValidateFeedback() throws InterruptedException 
	{
		WebElement Title = findElement("Feedback_XPATH");
        boolean isElementVisible = Title.isDisplayed();

        if (isElementVisible) {
            log.debug(" Feedback form opened successfully ");
            System.out.println(" Feedback form opened successfully ");
            Thread.sleep(2000);
            CloseFeedback();
        } 
        else 
        {
            log.debug("Issue in displaying the Feedback page");
            System.out.println(" Feedback form opened successfully ");
	}
}}
