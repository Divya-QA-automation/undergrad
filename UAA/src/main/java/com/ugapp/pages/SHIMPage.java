package com.ugapp.pages;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ugapp.base.Page;

public class SHIMPage extends Page
{
	public JavascriptExecutor js = (JavascriptExecutor) getDriver();
	public void Shim_Email() throws Throwable
	{
		WebElement elementToScrollTo121 = findElement("EmailAdd_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo121);
		// Enter the Email - Random Email which is not in the UG DB
		Random random = new Random();
		int randomNumber = 100000 + random.nextInt(900000);
		String Email = String.valueOf(randomNumber)+"@test.asu.edu"; 
		System.out.println("Email : "+Email);
		type("EmailAdd_XPATH", Email);
		log.debug("What's your email address? : "+Email);
		Thread.sleep(1000);
		click("EmailSubmit_ID");
		Thread.sleep(1000);

	}

	public void Shim_InPersonMOL(String colKey,String colValue) throws Throwable
	{
		//Choose the In person MOL
		WebElement elementToScrollTo1 = findElement("ImmersionRdBtn_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("ImmersionRdBtn_XPATH");
		log.debug("How would you like to attend?   -  Immersion");
	}


	public void Shim_OnlineMOL(String colKey,String colValue) throws Throwable
	{
		//Choose the Online MOL
		WebElement elementToScrollTo1 = findElement("OnlineRdBtn_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("OnlineRdBtn_XPATH");
		log.debug("How would you like to attend?   -  Online");

	}
	public void Shim_Degree(String colKey,String colValue) throws Throwable
	{
		//Are you pursuing a degree or only interested in taking classes?
		WebElement elementToScrollTo1 = findElement("DegreeRdBtn_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("DegreeRdBtn_XPATH");
		log.debug("Are you pursuing a degree or only interested in taking classes?  -  I want to pursue an associate or bachelor's degree.");

	}
	public void Shim_NonDegree(String colKey,String colValue) throws Throwable
	{
		//Are you pursuing a degree or only interested in taking classes?
		WebElement elementToScrollTo1 = findElement("NondegreeRdBtn_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("NondegreeRdBtn_XPATH");
		log.debug("Are you pursuing a degree or only interested in taking classes?  -  I want to take individual classes as a nondegree student.");

	}

	public void Shim_Starbucks(String colKey,String colValue) throws Throwable
	{
		// Are you applying as a Starbucks partner?
		WebElement elementToScrollTo1 = findElement("StarbucksPartnerCheckbox_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("StarbucksPartnerCheckbox_XPATH");
		log.debug("Are you applying as a Starbucks partner?  -  Yes, I want to be redirected to the Starbucks application. ");
	}



}
