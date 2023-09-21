package com.ugapp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.github.dockerjava.api.model.Driver;
import com.ugapp.base.Page;

public class PreAppDashboardPage extends Page
{

	public static void validatePreAppPage()
	{
		String dashboard=driver.getCurrentUrl();
		if(dashboard.contains("apps.asu.edu/dashboard"))
		{
			System.out.println("Redirected to Pre-App Submission page successfully!");
		}
		else
			System.out.println("Failed to redirect to Pre-App Submission page");
	}


	public static void userDetails(String firstName , String preferredfirstname , String middlename , String lastName)
	{
		type("firstName_XPATH",firstName);
		type("preferredFirstName_XPATH",preferredfirstname);
		type("middleName_XPATH",middlename);
		type("lastName_XPATH",lastName);
	}

	public static void validateUserDetails(String firstName , String preferredfirstname , String middlename , String lastName) throws Throwable
	{
		//regex that checks numbers , special char , space at end or start
		String regex = "^(?!.*\\\\s$)(?!^\\\\s)(?!.*-$)[0-9A-Za-z!@#$%^&*()_+=`~{}\\\\[\\\\]:;\\\"'<>,.?\\\\\\\\/| ]+$";



		//Firstname validation
		boolean isFirstNameValid = firstName.matches(regex);
		System.out.println("isFirstNameValid :"+isFirstNameValid);
		if(isFirstNameValid)
		{
			String errorFirstName = findElement("errorFirstName_XPATH").getText();
			Assert.assertEquals(errorFirstName, "The first name can only contain letters, spaces and hyphens (-).");
		}
		else if(firstName.length()>25)
		{
			String errorFirstName25 = findElement("errorFirstName25_XPATH").getText();
			Assert.assertEquals(errorFirstName25, "The first name should not be more than 25 characters.");
		}
		else
			System.out.println("Firstname is not valid");


		//preferred First Name validation
		boolean isPreferredFirstNameValid = preferredfirstname.matches(regex);
		System.out.println("isPreferredFirstNameValid :"+isPreferredFirstNameValid);
		if(isPreferredFirstNameValid)
		{
			String errorPreferredFirstName = findElement("errorPreferredFirstName_XPATH").getText();
			Assert.assertEquals(errorPreferredFirstName, "The preferred first name can only contain letters, spaces and hyphens (-).");
		}
		else if(preferredfirstname.length()>30)
		{
			String errorPreferredFirstName30 = findElement("errorPreferredFirstName30_XPATH").getText();
			Assert.assertEquals(errorPreferredFirstName30, "The preferred first name should not be more than 30 characters.");
		}
		else
			System.out.println("preferredfirstname is not valid");


		//middlename
		boolean ismiddleNameValid = middlename.matches(regex);
		System.out.println("ismiddleNameValid :"+ismiddleNameValid);
		if(ismiddleNameValid)
		{
			String errorMiddleName = findElement("errorMiddleName_XPATH").getText();
			Assert.assertEquals(errorMiddleName, "The middle name can only contain letters, spaces and hyphens (-).");
		}
		else if(middlename.length()>25)
		{
			String errorMiddleName25 = findElement("errorMiddleName25_XPATH").getText();
			Assert.assertEquals(errorMiddleName25, "The middle name should not be more than 25 characters.");
		}
		else
			System.out.println("middlename is not valid");


		//lastname
		boolean isLastNameValid = lastName.matches(regex);
		System.out.println("isLastNameValid :"+isLastNameValid);
		if(isLastNameValid)
		{
			String errorLastName = findElement("errorLastName_XPATH").getText();
			Assert.assertEquals(errorLastName, "The last name can only contain letters, spaces and hyphens (-).");
		}
		else if(lastName.length()>25)
		{
			String errorLastName25 = findElement("errorLastName25_XPATH").getText();
			Assert.assertEquals(errorLastName25, "The last name should not be more than 25 characters.");
		}
		else
			System.out.println("lastName is not valid");


		//button enability
		boolean startnewAppButton = findElement("startNewApplicationButton_XPATH").isEnabled();
		if(startnewAppButton==false)
			driver.navigate().refresh();
		Thread.sleep(4000);
	}

	
	public static void checkOptionalTag()
	{
		
	}
	

}
