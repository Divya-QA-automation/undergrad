package com.ugapp.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ugapp.base.Page;

public class MySchoolsPage  extends Page
{
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	
	public void ValidateForMySchools() throws Throwable
	{
		waitTillLoaderDisappears();
		WebElement elementToScrollTo1 = findElement("MySchoolsTitle_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		String PageTitle = findElement("MySchoolsTitle_XPATH").getText();
		log.debug("Page title :"+" "+PageTitle);
	}
	public void RecentHighSchool() throws Throwable
	{
		log.debug("Current or most recent high school");
		click("SchoolCountryDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		System.out.println(Options);
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		// Get the text of the chosen random Country
		String 	selectedCountryText	=	driver.findElement(By.xpath("//div[@id='high_school_country_select']")).getText();
		System.out.println("Selected High school Country: " + selectedCountryText);
		log.debug("Selected High school Country: " + selectedCountryText);
	}
	public void GraduatingSchool(String State , String City ,String School_name, String SAISno ) throws InterruptedException //String State , String City ,String School_name, String SAISno 
	{
		// validate State
		Thread.sleep(2000);
		WebElement stateElement = driver.findElement(By.id("school_state")); 
		if (stateElement.getTagName().equals("div")) 
		{
			// It's a dropdown
			System.out.println("State is a dropdown.");
			log.debug("State is a dropdown.");
			click("SchoolStateDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			System.out.println(Options1);
			// Generate a random index to choose a random State
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			// Click on the random State
			WebElement randomOption1 = options1.get(randomIndex11);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			// Get the text of the chosen random State
			String 	selectedStateText	=	driver.findElement(By.xpath("//div[@id='school_state']")).getText();
			System.out.println("Selected High school State: " + selectedStateText);
			log.debug("Selected High school State: " + selectedStateText);
			

		}

		else if (stateElement.getTagName().equals("input")) 
		{
			// It's a textfield
			System.out.println("State is a textfield.");
			log.debug("State is a textfield.");
			Thread.sleep(1000);
			type("SchoolStateTextfield_XPATH",State);
//			type("SchoolStateTextfield_XPATH","Test State");
		}
		else 
		{
			// It's neither a dropdown nor a textfield
			System.out.println("State is neither a dropdown nor a textfield.");
			log.debug("State is neither a dropdown nor a textfield.");
		}
		// Validate City
		WebElement cityElement = driver.findElement(By.id("school_city")); 
		if (cityElement.getTagName().equals("div")) 
		{
			// It's a dropdown
			System.out.println("City is a dropdown.");
			log.debug("City is a dropdown.");
			click("SchoolCityDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			System.out.println(Options1);
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex11);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			String 	selectedCityText	=	driver.findElement(By.xpath("//div[@id='school_city']")).getText();
			System.out.println("Selected High school City: " + selectedCityText);
			log.debug("Selected High school City: " + selectedCityText);
			Thread.sleep(2000);
			// Validate for Arizona ----- SAIS No
			String 	selectedStateText	=	driver.findElement(By.xpath("//div[@id='school_state']")).getText();
			if(selectedStateText.equals("Arizona"))
			{
				type("SAISNo_ID",SAISno);
//				type("SAISNo_ID","1234567891");
			}
			// Validate High School
			click("HighSchoolDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options11  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options11 = options11.size();
			System.out.println(Options11);
			Random random111 = new Random();
			int randomIndex111 = random111.nextInt(options11.size());
			WebElement randomOption11 = options11.get(randomIndex111);
			Thread.sleep(1000);
			randomOption11.click();
			Thread.sleep(1000);
			String 	selectedHighSchoolText	=	driver.findElement(By.xpath("//div[@id='school_city']")).getText();
			System.out.println("Selected High school City: " + selectedHighSchoolText);
			log.debug("Selected High school City: " + selectedHighSchoolText);
			
			if(selectedHighSchoolText.contains("My High School is not on the list"))
			{
				Thread.sleep(2000);
				type("SchoolNameTextfield_XPATH",School_name);
//				type("SchoolNameTextfield_XPATH","Test School");
			}
			

		}

		else if (cityElement.getTagName().equals("input")) 
		{
			// It's a textfield ---- Enter School name
			System.out.println("City is a textfield.");
			log.debug("City is a textfield.");
			type("SchoolCityTextfield_XPATH",City);
//			type("SchoolCityTextfield_XPATH","Test City");
			Thread.sleep(2000);
			type("SchoolNameTextfield_XPATH",School_name);
//			type("SchoolNameTextfield_XPATH","Test School");
		}
		else 
		{
			// It's neither a dropdown nor a textfield
			System.out.println("City is neither a dropdown nor a textfield.");
			log.debug("City is neither a dropdown nor a textfield.");
		}
		
		
	}
	public void ValidateGraduatingSchool(String State , String City ,String School_name, String SAISno ) throws Throwable
	{
		System.out.println("State.length()"+State.length());
		System.out.println("City.length()"+City.length());
		System.out.println("School_name.length()"+School_name.length());
		//error message validation for State
		try
		{
			if(State.length() > 42)
			{
				String errorState = driver.findElement(By.xpath("//input[@id='school_state']/following-sibling::div[contains(text(),' The state should not be more than 30 characters. ')]")).getText();
				System.out.println("The error message is displayed when the input for State is greater than 30 char!");
				Assert.assertEquals(errorState, "The state should not be more than 30 characters.");
				findElement("SchoolStateTextfield_XPATH").clear();
			}



		}catch(Exception e) {}
		//error message validation for City
		try
		{
			if(City.length() > 42)
			{
				String errorCity = driver.findElement(By.xpath("//input[@id='school_city']/following-sibling::div[contains(text(),' The city should not be more than 30 characters. ')]")).getText();
				System.out.println("The error message is displayed when the input for City is greater than 30 char!");
				Assert.assertEquals(errorCity, "The city should not be more than 30 characters.");
				findElement("SchoolCityTextfield_XPATH").clear();
			}

		}catch(Exception e) {}
		//error message validation for School name
		try
		{
			if(School_name.length()>30)
			{
				String errorCity = driver.findElement(By.xpath("//input[@id='school_schoolname']/following-sibling::div[contains(text(),' The name should not be more than 30 characters. ')]")).getText();
				System.out.println("The error message is displayed when the input for School name is greater than 30 char!");
				Assert.assertEquals(errorCity, "The name should not be more than 30 characters.");
				findElement("SchoolNameTextfield_XPATH").clear();
			}

		}catch(Exception e) {}
		//error message validation for SAIS no
				try
				{
					if(SAISno.length()>30)
					{
						String errorSAISNo = driver.findElement(By.xpath("//input[@id='school_sais']/following-sibling::div[contains(text(),' The SAIS should not be more than 10 characters. ')]")).getText();
						System.out.println("The error message is displayed when the input for SAIS Number is greater than 10 char!");
						Assert.assertEquals(errorSAISNo, "The SAIS should not be more than 10 characters.");
						findElement("SAISNo_ID").clear();
					}

				}catch(Exception e) {}
		
	}
	
	
	
	
	
	
	
	public void GraduationDate()
	{
		
	}
}