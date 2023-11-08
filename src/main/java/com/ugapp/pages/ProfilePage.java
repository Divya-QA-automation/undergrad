package com.ugapp.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ugapp.base.Page;

public class ProfilePage extends Page{
	static JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	public static void openprofile() throws Throwable
	{
		findElement("profileIcon_XPATH").click();
		Thread.sleep(1000);

		findElement("editProfile_XPATH").click();
		waitTillLoaderDisappears();
	}

	public static void validateEmail()
	{
		String profileEmail = findElement("profileEmail_XPATH").getText();


		if(profileEmail.equalsIgnoreCase("2222embtest@test.asu.edu"))
			System.out.println("Correct email is displayed in profile page");

		//		if(profileEmail.equalsIgnoreCase(CreateAccountPage.validEmail))
		//			System.out.println("Correct email is displayed in profile page");
		else
			System.out.println("Correct email is not displayed in profile page");
	}


	public static void pronouns() throws Throwable
	{
		findElement("pronouns_XPATH").click();
		Thread.sleep(2500);
		waitTillLoaderDisappears();

		List<WebElement> pronoun = driver.findElements(By.xpath("//div[@data-cy='radio-group']//label"));
		ArrayList<Integer> random = getRandomNumber(1, pronoun.size(), 1);

		for(int ran :random)
		{
			driver.findElement(By.xpath("(//div[@data-cy='radio-group']//label)["+ran+"]")).click();
		}
		Thread.sleep(2000);
		findElement("pronounSave_XPATH").click();
		Thread.sleep(2000);
		waitTillLoaderDisappears();
	}


	public static void gender() throws Throwable
	{
		Thread.sleep(2000);
		findElement("gender_XPATH").click();
		Thread.sleep(2000);
		waitTillLoaderDisappears();

		List<WebElement> gender = driver.findElements(By.xpath("//div[@data-cy='radio-group']//label"));
		ArrayList<Integer> random = getRandomNumber(1, gender.size(), 1);

		for(int ran :random)
		{
			driver.findElement(By.xpath("(//div[@data-cy='radio-group']//label)["+ran+"]")).click();
		}

		findElement("pronounSave_XPATH").click();
		Thread.sleep(2000);
		waitTillLoaderDisappears();
	}

	public static void returnToDashboard() throws Throwable
	{

		WebElement elementToScrollTo1 = findElement("returnToDashboard_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		findElement("returnToDashboard_XPATH").click();
		Thread.sleep(2000);
		waitTillLoaderDisappears();
	}

	public static void statusCheck() throws Throwable
	{
		String text = findElement("submittedText_XPATH").getText();	
		if(text.equalsIgnoreCase("In progress"))
			System.out.println("The status "+text+" is displayed as expected!");
		else
			System.out.println("The status "+text+" is displayed which is not expected!");

		driver.findElement(By.xpath("//button//span[.='Continue']/..")).click();
		waitTillLoaderDisappears();
	}

}
