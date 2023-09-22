package com.ugapp.pages;
import org.openqa.selenium.JavascriptExecutor;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.github.dockerjava.api.model.Driver;
import com.ugapp.base.Page;

public class PreAppDashboardPage extends Page
{

	public static void validatePreAppPage()
	{
		//validate the pre app page with url
		String dashboard=driver.getCurrentUrl();
		if(dashboard.contains("apps.asu.edu/dashboard"))
		{
			System.out.println("Redirected to Pre-App Submission page successfully!");
		}
		else
			System.out.println("Failed to redirect to Pre-App Submission page");
	}


	
	
	public static void userDetails(String firstName , String preferredfirstname , String middlename , String lastName) throws Throwable
	{
		Thread.sleep(1000);
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
			try {
				String errorFirstName = findElement("errorFirstName_XPATH").getText();
				Assert.assertEquals(errorFirstName, "The first name can only contain letters, spaces and hyphens (-).");
			}catch(Exception e) {
				if(firstName.length()>25)
				{
					String errorFirstName25 = findElement("errorFirstName25_XPATH").getText();
					Assert.assertEquals(errorFirstName25, "The first name should not be more than 25 characters.");
				}

			}
		}
		else
			System.out.println("Firstname is not valid");


		//preferred First Name validation
		boolean isPreferredFirstNameValid = preferredfirstname.matches(regex);
		System.out.println("isPreferredFirstNameValid :"+isPreferredFirstNameValid);
		if(isPreferredFirstNameValid)
		{
			try
			{
				String errorPreferredFirstName = findElement("errorPreferredFirstName_XPATH").getText();
				Assert.assertEquals(errorPreferredFirstName, "The preferred first name can only contain letters, spaces and hyphens (-).");
			}catch(Exception e)
			{
				if(preferredfirstname.length()>30)
				{
					String errorPreferredFirstName30 = findElement("errorPreferredFirstName30_XPATH").getText();
					Assert.assertEquals(errorPreferredFirstName30, "The preferred first name should not be more than 30 characters.");
				}
			}
		}
		else
			System.out.println("preferredfirstname is not valid");


		//middlename
		boolean ismiddleNameValid = middlename.matches(regex);
		System.out.println("ismiddleNameValid :"+ismiddleNameValid);
		if(ismiddleNameValid)
		{
			try
			{
				String errorMiddleName = findElement("errorMiddleName_XPATH").getText();
				Assert.assertEquals(errorMiddleName, "The middle name can only contain letters, spaces and hyphens (-).");
			}catch(Exception e)
			{
				if(middlename.length()>25)
				{
					String errorMiddleName25 = findElement("errorMiddleName25_XPATH").getText();
					Assert.assertEquals(errorMiddleName25, "The middle name should not be more than 25 characters.");
				}
			}
		}
		else
			System.out.println("middlename is not valid");


		//lastname
		boolean isLastNameValid = lastName.matches(regex);
		System.out.println("isLastNameValid :"+isLastNameValid);
		if(isLastNameValid)
		{
			try
			{
				String errorLastName = findElement("errorLastName_XPATH").getText();
				Assert.assertEquals(errorLastName, "The last name can only contain letters, spaces and hyphens (-).");
			}catch(Exception e)
			{
				if(lastName.length()>30)
				{
					String errorLastName25 = findElement("errorLastName25_XPATH").getText();
					Assert.assertEquals(errorLastName25, "The last name should not be more than 25 characters.");
				}
			}
		}
		else
			System.out.println("lastName is not valid");


		//button enability
		boolean startnewAppButton = findElement("startNewApplicationButton_XPATH").isEnabled();
		if(startnewAppButton==false)
			driver.navigate().refresh();
		Thread.sleep(2000);
	}


	
	
	public static void validuser()
	{
		type("firstName_XPATH","Test FN");
		type("preferredFirstName_XPATH","Automation PFN");
		type("middleName_XPATH","Automation MN");
		type("lastName_XPATH","Test LN");
	}
	
	public static void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
	}
	
	
	public static void checkOptionalTag()
	{
		//preferred firstname Optional tag
		try {
			findElement("preferredOptional_XPATH");
			System.out.println("Optional tag is  present for Preferred first name!");
		}
		catch(Exception e) {
			System.out.println("Optional tag is not present for Preferred first name!");
		}

		//Middlename Optional tag
		try {
			findElement("middleOptional_XPATH");
			System.out.println("Optional tag is present for middle name!");

		}
		catch(Exception e) {
			System.out.println("Optional tag is not present for middle ame!");
		}

		//suffix Optional tag
		try {
			findElement("suffixOptional_XPATH");
			System.out.println("Optional tag is present for suffix dropdown!");
		}
		catch(Exception e) {
			System.out.println("Optional tag is not present for suffix dropdown!");
		}

	}



	public static void verifySuffixDropdown() throws Throwable
	{
		//click on dropdown
		findElement("suffixDropdown_XPATH").click();
		Thread.sleep(1500);
		
		//get the number of elements in the dropdowm and stor them in an arraylist
		List<WebElement> suffix = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li[contains(text(),'')]"));
		ArrayList<String> suffixDropdownFields = new ArrayList<String>();
		
		int i=1;
		for(WebElement suff:suffix)
		{
			String suffixFields=driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li[contains(text(),'')])["+i+"]")).getText();
			suffixDropdownFields.add(suffixFields);
			i++;
		}
		
		//validate the elements present in the dropdown
		System.out.println("suffixDropdownFields :"+suffixDropdownFields);
		if(suffixDropdownFields.contains("II") && suffixDropdownFields.contains("III") && suffixDropdownFields.contains("IV") && suffixDropdownFields.contains("Jr.") && suffixDropdownFields.contains("Sr."))
			System.out.println("The Suffix dropdown contains all the expected data!");
		else
			System.out.println("The Suffix Dropdown does not contain all the expected data");

	}



	public static void verifySuffixClear() throws Throwable
	{
		//random click on any of the elements in the suffix dropdown 
		List<WebElement> suffix = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		ArrayList<Integer> ransuf = getRandomNumber(1, suffix.size(), 1);
		for(int r:ransuf)
		{
			driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+r+"]")).click();
		}

		//click on the clear button
		click("clearSuffix_XPATH");
		Thread.sleep(1000);
		try
		{
			List<WebElement> error = driver.findElements(By.xpath("//li[contains(text(),' This is a required field')]"));
			System.out.println("The error message is displayed when cleared the Suffix field!");
		}
		catch(Exception e) {
			System.out.println("The error message is not displayed when cleared the Suffix field");
		}
	}


	public static void verifyMonths() throws Throwable
	{	
		//click on the month dropdown
		click("month_XPATH");
		Thread.sleep(2000);
		
		//get the number of elements present in the moinths dropdown
		List<WebElement> months = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));	
		System.out.println("months.size :"+months.size());
		if(months.size()==12)
		{
			System.out.println("Month dropdown has all twelve months!");
		}
		else
		{
			System.out.println("Month dropdown does not have all twelve months!");
		}
	}

	
	
	public static void verifyDaysPresent() throws Throwable
	{
		//number of months
		List<WebElement> months = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));

		//random number to choose from months
		ArrayList<Integer> ran = getRandomNumber(1, months.size(), 1);

		//get the randomnly selected month
		String monthSelected="";
		for(int r:ran)
		{
			monthSelected = driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li[contains(text(),'')])[" + r + "]")).getText();
			System.out.println("monthSelected :"+monthSelected);
			driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+r+"]")).click();
		}

		//day dropdown
		click("day_XPATH");
		Thread.sleep(2000);

		//number of days
		List<WebElement> days = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		ArrayList<Integer> randay = getRandomNumber(1, days.size(), 1);

		if(monthSelected.equalsIgnoreCase("January") || monthSelected.equalsIgnoreCase("March") || monthSelected.equalsIgnoreCase("May") || monthSelected.equalsIgnoreCase("July") || monthSelected.equalsIgnoreCase("August") || monthSelected.equalsIgnoreCase("October") || monthSelected.equalsIgnoreCase("December"))
		{
			if(days.size()==31)
			{
				System.out.println("Day dropdown works as expected!");
			}
			else
				System.out.println("Day dropwdown is not working as expected");
		}
		else if(monthSelected.equalsIgnoreCase("April") || monthSelected.equalsIgnoreCase("June") || monthSelected.equalsIgnoreCase("September") || monthSelected.equalsIgnoreCase("November"))	
		{
			if(days.size()==30)
				System.out.println("Day dropdown works as expected!");
			else
				System.out.println("Day dropwdown is not working as expected");
		}
		else if(monthSelected.equalsIgnoreCase("February"))
		{
			if(days.size()==29)
				System.out.println("Day dropdown works as expected!");
			else
				System.out.println("Day dropwdown is not working as expected");
		}
		for(int r:randay)
		{
			driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li[contains(text(),'')])[" + r + "]")).click();
		}
	}

	
	
	
	public static void verifyYearsPresent() throws Throwable
	{
		//click year dropdown
		click("year_XPATH");
		Thread.sleep(2000);


		//number of years
		List<WebElement> year = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		ArrayList<Integer> ranyear = getRandomNumber(1, year.size(), 1);
		if(year.size()==100)
			System.out.println("year dropdown has 100 values as expected!");
		else
			System.out.println("year dropdown does not have 100 values!");


		//close the dropdown
		for(int r:ranyear)
		{
			driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li[contains(text(),'')])[" + r + "]")).click();
		}
	}




	public static void verifyClearButton()
	{
		//verify clear button
		click("clearmonth_XPATH");
		click("clearDay_XPATH");
		click("clearYear_XPATH");

	}

	public static void validateErrorMessage()
	{
		
		//validate the error message present after clearing the borthday fields
		List<WebElement> error = driver.findElements(By.xpath("//li[contains(text(),' This is a required field')]"));

		if(error.size()==3)
			System.out.println("The error message is displayed when cleared the birthday fields!");
		else
			System.out.println("The error message is not displayed when cleared the birthday fields");
	}


	public static void validBirthday() throws Throwable
	{
		
		//click on the month dropdown
		click("month_XPATH");
		Thread.sleep(1000);
		
		//give valid input to the birthday field
		driver.findElement(By.xpath("//ul[@class='vs__dropdown-menu']/li")).click();
		click("day_XPATH");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@class='vs__dropdown-menu']/li")).click();
		WebElement year=driver.findElement(By.xpath("//div[@id=\"create-application-birth-year\"]//input"));
		year.sendKeys("1995");
		year.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

	}

	
	public static void startNewAppbutton() throws Throwable
	{
		boolean startnewAppButton = findElement("startNewApplicationButton_XPATH").isEnabled();
		if(startnewAppButton==true)
			findElement("startNewApplicationButton_XPATH").click();
		Thread.sleep(2000);
	}
	
	
}
