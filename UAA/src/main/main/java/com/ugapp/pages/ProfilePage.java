package com.ugapp.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ugapp.base.Page;


public class ProfilePage extends Page
{
//CreateAccountPage createacc = new CreateAccountPage();

	 JavascriptExecutor js = (JavascriptExecutor) getDriver();
	public  void openprofile() throws Throwable
	{
		waitTillProgressbarDisappears();
		Thread.sleep(3000);
		findElement("profileIcon_XPATH").click();
		Thread.sleep(1000);


		findElement("editProfile_XPATH").click();
		waitTillProgressbarDisappears();
		Thread.sleep(3000);
	}


	public  void validateEmail() throws InterruptedException
	{
		Thread.sleep(2000);
		String profileEmail = findElement("profileEmail_XPATH").getText();
		log.debug("profileEmail :"+profileEmail);




//		if(profileEmail.equalsIgnoreCase(validEmail))
//			System.out.println("Correct email is displayed in profile page");


				if(profileEmail.equalsIgnoreCase(CreateAccountPage.validEmail.get()))
					log.debug("Correct email is displayed in profile page");
		else
			log.debug("Correct email is not displayed in profile page");
	}



	public  void pronouns(String colKey,String colValue) throws Throwable
	{
		WebElement elementToScrollTo1 = findElement("pronouns_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		findElement("pronouns_XPATH").click();
		Thread.sleep(2500);
		waitTillLoaderDisappears();
		waitTillProgressbarDisappears();
		Thread.sleep(5000);


		List<WebElement> pronoun = getDriver().findElements(By.xpath("//div[@data-cy='radio-group']//label"));
		ArrayList<Integer> random = getRandomNumber(1, pronoun.size(), 1);


		for(int ran :random)
		{
			getDriver().findElement(By.xpath("(//div[@data-cy='radio-group']//label)["+ran+"]")).click();
		}
		Thread.sleep(2000);
		findElement("pronounSave_XPATH").click();
		Thread.sleep(2000);
		waitTillLoaderDisappears();
		waitTillProgressbarDisappears();
		Thread.sleep(5000);
		WebElement elementToScrollTo11 = findElement("pronouns_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		String Pronoun = findElement("pronouns_XPATH").getText();
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 4, "Pronouns", Pronoun);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}




	public  void gender(String colKey,String colValue) throws Throwable
	{
		Thread.sleep(2000);
		findElement("gender_XPATH").click();
		Thread.sleep(2000);
		waitTillProgressbarDisappears();
		Thread.sleep(2000);


		List<WebElement> gender = getDriver().findElements(By.xpath("//div[@data-cy='radio-group']//label"));
		ArrayList<Integer> random = getRandomNumber(1, gender.size(), 1);


		for(int ran :random)
		{
			getDriver().findElement(By.xpath("(//div[@data-cy='radio-group']//label)["+ran+"]")).click();
		}


		findElement("pronounSave_XPATH").click();
		Thread.sleep(2000);
		waitTillProgressbarDisappears();
		Thread.sleep(2000);
		String GenderIdentity = findElement("gender_XPATH").getText();
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 5, "Gender identity", GenderIdentity);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}


	public  void returnToDashboard() throws Throwable
	{


		WebElement elementToScrollTo1 = findElement("returnToDashboard_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		findElement("returnToDashboard_XPATH").click();
		Thread.sleep(2000);
		waitTillProgressbarDisappears();
		Thread.sleep(2000);
	}


	public  void statusCheck() throws Throwable
	{
		String text = findElement("submittedText_XPATH").getText();	
		if(text.equalsIgnoreCase("In progress"))
			log.debug("The status "+text+" is displayed as expected!");
		else
			log.debug("The status "+text+" is displayed which is not expected!");


		getDriver().findElement(By.xpath("//button//span[.='Continue']/..")).click();
		waitTillProgressbarDisappears();
		Thread.sleep(3000);
	}


}




