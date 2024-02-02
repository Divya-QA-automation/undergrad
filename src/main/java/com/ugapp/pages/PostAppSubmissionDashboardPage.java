package com.ugapp.pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ugapp.base.Page;

public class PostAppSubmissionDashboardPage extends Page{

	 JavascriptExecutor js = (JavascriptExecutor) getDriver();

	public  void validatePostDashboard() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(1000);
		try
		{
			findElement("validateTitle_XPATH");	
			log.debug("Redirected to post app submission page");
		}
		catch(Exception e)
		{
			log.debug("Not Redirected to post app submission page");
		}

	}

	public  void phone() throws InterruptedException
	{
		//to check for phone visibility
		Thread.sleep(1000);
		WebElement elementToScrollTo1 = findElement("postPhone_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		String expectedPhone = "866-277-6589";
		WebElement phone=findElement("postPhone_XPATH");
		String actualPhone=phone.getText();
		if(phone.isDisplayed())
			Assert.assertEquals(expectedPhone, actualPhone);
	}

	public  void email() throws Throwable
	{
		//validate the emaail present 
		Thread.sleep(2000);
		WebElement elementToScrollTo1 = findElement("postEmail_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		String expectedEmail = "enrollmentonline@asu.edu";
		WebElement email=findElement("postEmail_XPATH");
		String actualEmail=email.getText();
		if(email.isDisplayed())
			Assert.assertEquals(expectedEmail, actualEmail);
	}

	public  void QTR()
	{
		WebElement elementToScrollTo1 = findElement("qtr_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);

		String parentWindowHandle = getDriver().getWindowHandle();
		findElement("qtr_XPATH").click();
		Set<String> windowID = getDriver().getWindowHandles();
		for(String wid:windowID)
		{
			getDriver().switchTo().window(wid);
			String URL = getDriver().getCurrentUrl();
			if(URL.contains("tuition"))
			{
				log.debug("QTR link works as expected!");
				getDriver().close();
			}
		}
		getDriver().switchTo().window(parentWindowHandle);
	}


	public  void transcripts()
	{
		WebElement elementToScrollTo1 = findElement("transcripts_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);

		String parentWindowHandle = getDriver().getWindowHandle();
		findElement("transcripts_XPATH").click();
		Set<String> windowID = getDriver().getWindowHandles();
		for(String wid:windowID)
		{
			getDriver().switchTo().window(wid);
			String URL = getDriver().getCurrentUrl();
			if(URL.contains("transcripts"))
			{
				log.debug("Transcripts link works as expected!");
				getDriver().close();
			}
		}
		getDriver().switchTo().window(parentWindowHandle);
	}


	public  void fafsa()
	{
		WebElement elementToScrollTo1 = findElement("fafsa_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		String parentWindowHandle = getDriver().getWindowHandle();
		findElement("fafsa_XPATH").click();
		Set<String> windowID = getDriver().getWindowHandles();
		for(String wid:windowID)
		{
			getDriver().switchTo().window(wid);
			String URL = getDriver().getCurrentUrl();
			if(URL.contains("fafsa"))
			{
				log.debug("FAFSA link works as expected!");
				getDriver().close();
			}
		}
		getDriver().switchTo().window(parentWindowHandle);
	}

	public  void previewLink() throws Throwable
	{
		WebElement elementToScrollTo1 = findElement("previewLink_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		findElement("previewLink_XPATH").click();
		waitTillLoaderDisappears();
		Thread.sleep(3000);
	}

}
