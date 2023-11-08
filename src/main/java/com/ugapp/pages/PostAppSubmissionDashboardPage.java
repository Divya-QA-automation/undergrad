package com.ugapp.pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ugapp.base.Page;

public class PostAppSubmissionDashboardPage extends Page{

	static JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

	public static void validatePostDashboard()
	{
		try
		{
			findElement("validateTitle_XPATH");	
			System.out.println("Redirected to post app submission page");
		}
		catch(Exception e)
		{
			System.out.println("Not Redirected to post app submission page");
		}

	}

	public static void phone() throws InterruptedException
	{
		//to check for phone visibility
		Thread.sleep(1000);
		String expectedPhone = "866-277-6589";
		WebElement phone=findElement("postPhone_XPATH");
		String actualPhone=phone.getText();
		if(phone.isDisplayed())
			Assert.assertEquals(expectedPhone, actualPhone);
	}

	public static void email() throws Throwable
	{
		//validate the emaail present 
		Thread.sleep(2000);
		String expectedEmail = "enrollmentonline@asu.edu";
		WebElement email=findElement("postEmail_XPATH");
		String actualEmail=email.getText();
		if(email.isDisplayed())
			Assert.assertEquals(expectedEmail, actualEmail);
	}

	public static void qtr()
	{
		WebElement elementToScrollTo1 = findElement("qtr_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);

		String parentWindowHandle = driver.getWindowHandle();
		findElement("qtr_XPATH").click();
		Set<String> windowID = driver.getWindowHandles();
		for(String wid:windowID)
		{
			driver.switchTo().window(wid);
			String URL = driver.getCurrentUrl();
			if(URL.contains("tuition"))
			{
				System.out.println("QTR link works as expected!");
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle);
	}


	public static void transcripts()
	{
		WebElement elementToScrollTo1 = findElement("transcripts_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);

		String parentWindowHandle = driver.getWindowHandle();
		findElement("transcripts_XPATH").click();
		Set<String> windowID = driver.getWindowHandles();
		for(String wid:windowID)
		{
			driver.switchTo().window(wid);
			String URL = driver.getCurrentUrl();
			if(URL.contains("transcripts"))
			{
				System.out.println("Transcripts link works as expected!");
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle);
	}


	public static void fafsa()
	{
		WebElement elementToScrollTo1 = findElement("fafsa_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		String parentWindowHandle = driver.getWindowHandle();
		findElement("fafsa_XPATH").click();
		Set<String> windowID = driver.getWindowHandles();
		for(String wid:windowID)
		{
			driver.switchTo().window(wid);
			String URL = driver.getCurrentUrl();
			if(URL.contains("fafsa"))
			{
				System.out.println("FAFSA link works as expected!");
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle);
	}

	public static void previewLink() throws Throwable
	{
		WebElement elementToScrollTo1 = findElement("previewLink_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		findElement("previewLink_XPATH").click();
		waitTillLoaderDisappears();
	}

}
