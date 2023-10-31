package com.ugapp.pages;


import java.time.Year;
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
			// Validate for SAISNO ----- SAIS No


			String 	selectedStateText	=	driver.findElement(By.xpath("//div[@id='school_state']")).getText();
			if(selectedStateText.equals("Arizona"))
			{
				WebElement elementToScrollTo1 = findElement("SAISNo_ID");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				type("SAISNo_ID",SAISno);
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
		//error message validation for State
		try
		{
			if(State.length() > 30)
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
			if(City.length() > 30)
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
			if(SAISno.length()>10)
			{
				String errorSAISNo = driver.findElement(By.xpath("//input[@id='school_sais']/following-sibling::div[contains(text(),' The SAIS should not be more than 10 characters. ')]")).getText();
				System.out.println("The error message is displayed when the input for SAIS Number is greater than 10 char!");
				Assert.assertEquals(errorSAISNo, "The SAIS should not be more than 10 characters.");
				findElement("SAISNo_ID").clear();
			}


		}catch(Exception e) {}


	}


	public void GraduationDate() throws InterruptedException {


		// Select Graduation Month
		WebElement elementToScrollTo1 = findElement("GradMonth_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("GradMonth_ID");
		Thread.sleep(500);
		List<WebElement> options11 = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options11 = options11.size();
		System.out.println(Options11);
		Random random111 = new Random();
		int randomIndex111 = random111.nextInt(options11.size());


		// If the selected year is 2028, ensure the selected month is not November (10) or December (11)
		int selectedYear = 2028;
		if (randomIndex111 == 10 || randomIndex111 == 11) {
			randomIndex111 = random111.nextInt(10); // Choose from 0 to 9 for Jan to Oct
		}


		WebElement randomOption11 = options11.get(randomIndex111);
		Thread.sleep(1000);
		randomOption11.click();
		Thread.sleep(1000);
		String selectedMonthText = findElement("GradMonth_ID").getText();
		System.out.println("Selected Graduation Month: " + selectedMonthText);
		log.debug("Selected Graduation Month: " + selectedMonthText);


		// Select Graduation Year ---- Future Graduation date flow
		WebElement elementToScrollTo2 = findElement("GradYear_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		click("GradYear_ID");
		Thread.sleep(500);
		List<WebElement> optionsList1 = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options111 = optionsList1.size();
		System.out.println(Options111);


		// Generate a random index to choose a random graduation year between 2023 and 2028
		Random random1111 = new Random();
		int randomIndex1111 = random1111.nextInt(4); // Random index between 0 and 4 (inclusive) for 5 years (2023 to 2028)
		int selectedYear1 = 2028 - randomIndex1111; // Calculate the selected year
		System.out.println(selectedYear1);


		// Assuming optionsList is your list of WebElement options retrieved from the dropdown
		WebElement selectedOption1 = optionsList1.get(randomIndex1111);
		selectedOption1.click();
		Thread.sleep(1000);
		String selectedYearText = findElement("GradYear_ID").getText();
		System.out.println("Selected Graduation Year: " + selectedYearText);
		log.debug("Selected Graduation Year: " + selectedYearText);
	}


	public void SelectNameOnTranscript() throws InterruptedException {


		// Select Graduation Month
		WebElement elementToScrollTo1 = findElement("TranscriptName_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("TranscriptName_ID");
		Thread.sleep(500);
		List<WebElement> options11 = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options11 = options11.size();
		System.out.println(Options11);
		Random random111 = new Random();
		int randomIndex111 = random111.nextInt(options11.size());
		WebElement randomOption11 = options11.get(randomIndex111);
		randomOption11.click();
		Thread.sleep(1000);
		String selectedNameText = findElement("TranscriptName_ID").getText();
		System.out.println("Name on transcript" +" "+ selectedNameText);
		log.debug("Name on transcript" + selectedNameText);
		if(selectedNameText.contains("Other"))
		{
			type("FirstName_ID","First name");
			type("LastName_ID","Last name");
			driver.findElement(By.xpath("(//button[.=' Save '])[2]")).click();
			Thread.sleep(2000);
		}
		click("SaveSchool_XPATH");
	}
	public void DeleteAddedSchool() throws InterruptedException
	{
		WebElement elementToScrollTo1 = driver.findElement(By.xpath("//span[.='Current or most recent high school']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		List<WebElement> deleteButtons1 = driver.findElements(By.xpath("//a[@class='text-dark-3 ml-space-xs']"));
		Random random = new Random();
		int randomIndex1 = random.nextInt(deleteButtons1.size());
		// Click on the random Edit button
		WebElement randomDeleteButton1 = deleteButtons1.get(randomIndex1);
		randomDeleteButton1.click();
		log.debug("Deleting the Randomly added Recent High school");
		Thread.sleep(1000);
		click("Delete_XPATH");
	}
	public void RecentSchoolAZ() throws InterruptedException
	{
		Thread.sleep(1000);
		log.debug("Add AZ as Recent high school");
		WebElement elementToScrollTo1 = findElement("SchoolCountryDD_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("SchoolCountryDD_XPATH");
		Thread.sleep(1000);
		click("UScountryDD_XPATH");
		String 	selectedCountryText	=	findElement("SchoolCountryDD_XPATH").getText();
		System.out.println("Selected High school Country: " + selectedCountryText);
		log.debug("Selected High school Country: " + selectedCountryText);
		//		WebElement elementToScrollTo11 = findElement("SchoolStateDD_XPATH");
		//		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		Thread.sleep(500);
		click("SchoolStateDD_XPATH");
		WebElement elementToScrollTo111 = findElement("AZstateDD_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		click("AZstateDD_XPATH");
		String 	selectedStateText	=	findElement("SchoolStateDD_XPATH").getText();
		System.out.println("Selected High school State: " + selectedStateText);
		log.debug("Selected High school State: " + selectedStateText);
		WebElement elementToScrollTo1111 = findElement("SchoolCityDD_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
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
		String 	selectedCityText	=	findElement("SchoolCityDD_XPATH").getText();
		System.out.println("Selected High school City: " + selectedCityText);
		log.debug("Selected High school City: " + selectedCityText);
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
		String 	selectedHighSchoolText	=	findElement("HighSchoolDD_XPATH").getText();
		System.out.println("Selected High school City: " + selectedHighSchoolText);
		log.debug("Selected High school City: " + selectedHighSchoolText);


		if(selectedHighSchoolText.contains("My High School is not on the list"))
		{
			Thread.sleep(2000);
			type("SchoolNameTextfield_XPATH","Test School");
		}


		// Select Graduation Month
		WebElement elementToScrollTo11 = findElement("GradMonth_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		click("GradMonth_ID");
		Thread.sleep(500);
		List<WebElement> options111 = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options111 = options111.size();
		System.out.println(Options111);
		Random random1111 = new Random();
		int randomIndex1111 = random1111.nextInt(options111.size());


		// If the selected year is 2028, ensure the selected month is not November (10) or December (11)
		int selectedYear = 2028;
		if (randomIndex1111 == 10 || randomIndex1111 == 11) {
			randomIndex1111 = random1111.nextInt(10); // Choose from 0 to 9 for Jan to Oct
		}


		WebElement randomOption111 = options111.get(randomIndex1111);
		Thread.sleep(1000);
		randomOption111.click();
		Thread.sleep(1000);
		String selectedMonthText = findElement("GradMonth_ID").getText();
		System.out.println("Selected Graduation Month: " + selectedMonthText);
		log.debug("Selected Graduation Month: " + selectedMonthText);


		// Select Graduation Year ---- Future Graduation date flow
		WebElement elementToScrollTo2 = findElement("GradYear_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		click("GradYear_ID");
		Thread.sleep(500);
		List<WebElement> optionsList1 = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1111 = optionsList1.size();
		System.out.println(Options1111);


		// Generate a random index to choose a random graduation year between 2023 and 2028
		Random random11111 = new Random();
		int randomIndex11111 = random11111.nextInt(4); // Random index between 0 and 4 (inclusive) for 5 years (2023 to 2028)
		int selectedYear1 = 2028 - randomIndex11111; // Calculate the selected year
		System.out.println(selectedYear1);


		// Assuming optionsList is your list of WebElement options retrieved from the dropdown
		WebElement selectedOption1 = optionsList1.get(randomIndex11111);
		selectedOption1.click();
		Thread.sleep(1000);
		String selectedYearText = findElement("GradYear_ID").getText();
		System.out.println("Selected Graduation Year: " + selectedYearText);
		log.debug("Selected Graduation Year: " + selectedYearText);
		WebElement elementToScrollTo = findElement("SaveSchool_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		click("SaveSchool_XPATH");		


	}


	public void AddMaxHighSchool(String State , String City ,String School_name, String SAISno ) throws InterruptedException //String State , String City ,String School_name, String SAISno 
	{
		Thread.sleep(1000);
		WebElement elementToScrollTo1 = findElement("AddHighschoolBtn_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		boolean AddHighschoolButton = findElement("AddHighschoolBtn_XPATH").isEnabled();
		if(AddHighschoolButton==true)
		{
			WebElement elementToScrollTo2 = findElement("AddHighschoolBtn_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			Thread.sleep(1000);
			findElement("AddHighschoolBtn_XPATH").click();
			System.out.println("clickinggggg");
			Thread.sleep(1000);
		}
		else 
		{
			String MaxErrorMsg = findElement("MaxLimitErrMsg_XPATH").getText();
			Assert.assertEquals(MaxErrorMsg, "Reached maximum limit ");
			log.debug("Reached maximum limit...... ");
		}


		WebElement elementToScrollTo2 = findElement("SchoolCountryDD_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
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






		// Choose Random Month for first attended date
		WebElement elementToScrollTo = findElement("DateFirstMonth_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		click("DateFirstMonth_ID");
		Thread.sleep(1000);
		List<WebElement> options1 = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1 = options1.size();
		System.out.println(Options1);
		Random random = new Random();
		int randomIndex = random.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex);
		Thread.sleep(1000);
		randomOption1.click();
		Thread.sleep(1000);
		String selectedMonth = findElement("DateFirstMonth_ID").getText();
		System.out.println("Selected Month for first attended date: " + selectedMonth);
		log.debug("Selected Month for first attended date: " + selectedMonth);














		// Choose Random Year for first attended date
		WebElement elementToScrollTo11 = findElement("DateFirstYear_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		click("DateFirstYear_ID");
		Thread.sleep(1000);
		List<WebElement> options11 = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options11 = options11.size();
		System.out.println(Options11);
		Random random11 = new Random();
		int randomIndex11 = random11.nextInt(options11.size());
		WebElement randomOption11 = options11.get(randomIndex11);
		Thread.sleep(1000);
		randomOption11.click();
		Thread.sleep(1000);
		String selectedYear = findElement("DateFirstYear_ID").getText();
		System.out.println("Selected Year for first attended date: " + selectedYear);
		log.debug("Selected Year for first attended date: " + selectedYear);






		// Choose Random Year for last attended date ensuring it's greater than the first attended year
		WebElement elementToScrollTo111 = findElement("DateLastYear_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		click("DateLastYear_ID");
		Thread.sleep(1000);
		Random random1111 = new Random();
		// Choose Random Year for last attended date ensuring it's greater than or equal to the first attended year
		int firstYear = Integer.parseInt(selectedYear);
		List<WebElement> options11111 = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options111 = options11111.size();
		System.out.println(Options111+" No of years");
		int randomIndex11111 = random1111.nextInt(options11111.size());


		// Calculate the selected year between firstYear and 2023
		int selectedYear1 = firstYear + randomIndex11111;
		System.out.println(selectedYear1+"Selected last year");


		if (selectedYear1 < firstYear) 
		{
			selectedYear1 = firstYear; // Set the minimum allowed year to firstYear
		} 
		else if (selectedYear1==firstYear) 
		{
			selectedYear1 = firstYear+randomIndex11111; // Set the minimum allowed year to firstYear
		}
		else if (selectedYear1 > 2023) 
		{
			selectedYear1 = 2023; // Set the maximum allowed year to 2023
		}
		String selectedYear1Text;
		selectedYear1Text = String.valueOf(selectedYear1);


		List<WebElement> yearOptions = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));


		boolean yearFound = false;
		for (WebElement option : yearOptions) {
			if (option.getText().equals(selectedYear1Text)) {
				Thread.sleep(1000);
				option.click();
				yearFound = true;
				break;
			}
		}


		if (!yearFound) {
			// Handle the case when the desired year is not found in the dropdown options.
			// For example, you could handle this by selecting the first available option.
			WebElement firstOption = yearOptions.get(0);
			Thread.sleep(1000);
			firstOption.click();
			selectedYear1Text = firstOption.getText();
		}


		String SelectedLastYear = findElement("DateLastYear_ID").getText();
		System.out.println("Selected Year for last attended date: " + SelectedLastYear);
		log.debug("Selected Year for last attended date: " + SelectedLastYear);






		// Choose Random Month for last attended date
		Thread.sleep(1000);
		WebElement elementToScroll = findElement("DateLastMonth_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		click("DateLastMonth_ID");
		Thread.sleep(1000);
		List<WebElement> options111 = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1111 = options111.size();
		System.out.println(Options1111);
		Random random111 = new Random();
		int randomIndex111 = random111.nextInt(options111.size());
		WebElement randomOption111 = options111.get(randomIndex111);
		Thread.sleep(1000);
		randomOption111.click();
		Thread.sleep(1000);
		String selectedMonth1 = findElement("DateLastMonth_ID").getText();
		System.out.println("Selected Month for last attended date: " + selectedMonth1);
		log.debug("Selected Month for last attended date: " + selectedMonth1);




		// Save the School
		WebElement elementToScrollTo1111 = findElement("SaveSchool_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
		Thread.sleep(1000);
		click("SaveSchool_XPATH");
		log.debug("High school added successfully!!!");




	}
	public void HaveAttendedOrAttendingCollegeAndUniversities() throws InterruptedException
	{
		WebElement elementToScrollTo2 = driver.findElement(By.xpath("//h3[.=' Have you previously attended or are you currently attending a college or university? ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		log.debug("Have you previously attended or are you currently attending a college or university?");
		// Choose  ----- Yes 
		Thread.sleep(2000);
		WebElement YesradioButton = driver.findElement(By.xpath("(//input[@name='request_transcripts_radio'])[1]"));
		// Get the text of the randomly selected radio button
		String selectedOption = YesradioButton.getAttribute("value");
		YesradioButton.click();
		System.out.println(selectedOption);
		log.debug(selectedOption + "Yes");
		WebElement elementToScrollTo = findElement("InstitutionCountryDD_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		// Add a Institution Country
		click("InstitutionCountryDD_ID");
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
		String 	selectedCountryText	=	findElement("InstitutionCountryDD_ID").getText();
		System.out.println("Selected Institution Country: " + selectedCountryText);
		log.debug("Selected Institution Country: " + selectedCountryText);
	}


	public void CollegeUniversities(String State , String City ,String Institution_name, String Degree_Concentration) throws InterruptedException 
	{




		WebElement elementToScrollTo1 = driver.findElement(By.id("institute_state"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		WebElement stateElement = driver.findElement(By.id("institute_state"));
		if (stateElement.getTagName().equals("div")) 
		{
			// It's a dropdown
			log.debug("State is a dropdown.");
			// Add a Institution State
			click("InstitutionStateDD_XPATH");
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
			// Get the text of the chosen random Country
			String 	selectedStateText	=	findElement("InstitutionStateDD_XPATH").getText();
			System.out.println("Selected Institution State: " + selectedStateText);
			log.debug("Selected Institution State: " + selectedStateText);
		}
		else if (stateElement.getTagName().equals("input")) 
		{
			// It's a textfield
			System.out.println("State is a textfield.");
			log.debug("State is a textfield.");
			Thread.sleep(1000);
			type("InstutStateTextfield_XPATH",State);
		}
		else 
		{
			// It's neither a dropdown nor a textfield
			System.out.println("State is neither a dropdown nor a textfield.");
			log.debug("State is neither a dropdown nor a textfield.");
		}


		// Validate City
		WebElement cityElement = driver.findElement(By.id("institute_city")); 
		if (cityElement.getTagName().equals("div")) 
		{
			// It's a dropdown
			System.out.println("City is a dropdown.");
			log.debug("City is a dropdown.");
			// Add a Institution City
			click("InstitutionCityDD_XPATH");
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
			// Get the text of the chosen random Country
			String 	selectedCityText	=	findElement("InstitutionCityDD_XPATH").getText();
			System.out.println("Selected Institution City: " + selectedCityText);
			log.debug("Selected Institution City: " + selectedCityText);
		}
		else if (cityElement.getTagName().equals("input")) 
		{
			// It's a textfield
			log.debug("State is a textfield.");
			Thread.sleep(1000);
			type("InstutCityTextfield_XPATH",City);
		}
		else 
		{
			// It's neither a dropdown nor a textfield
			System.out.println("City is neither a dropdown nor a textfield.");
			log.debug("City is neither a dropdown nor a textfield.");
		}


		WebElement elementToScrollTo111 = findElement("SelectInstutDD_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		// Add a Institution Country
		click("SelectInstutDD_ID");
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
		// Get the text of the chosen random Country
		String 	selectedInstitutionText	=	findElement("SelectInstutDD_ID").getText();
		System.out.println("Selected Institution : " + selectedInstitutionText);
		log.debug("Selected Institution : " + selectedInstitutionText);
		WebElement elementToScrollTo1111 = findElement("SelectInstutDD_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
		if(selectedInstitutionText.contains("Not listed"))
		{
			WebElement elementToScrollToInstutName = findElement("InstitutionName_ID");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToInstutName);
			Thread.sleep(1000);
			type("InstitutionName_ID",Institution_name);
			Thread.sleep(1000);
		}
		WebElement elementToScrollToDegree = findElement("DegreeAwardedDD_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDegree);
		click("DegreeAwardedDD_ID");
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
		// Get the text of the chosen random Country
		String 	selectedDegreeAwarded	=	findElement("DegreeAwardedDD_ID").getText();
		System.out.println("Selected Institution : " + selectedDegreeAwarded);
		log.debug("Selected Institution : " + selectedDegreeAwarded);
		if(!selectedDegreeAwarded.contains("No Degree Awarded"))
		{
			WebElement elementToScrollToDegree1 = findElement("DegreeConcTextfield_ID");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDegree1);
			type("DegreeConcTextfield_ID",Degree_Concentration);
			Thread.sleep(2000);
		}
	}


	public void ValidateCollegeUniversities(String State , String City ,String Institution_name, String Degree_Concentration) throws Throwable
	{
		//error message validation for State
		try
		{
			if(State.length() > 30)
			{
				String errorState = driver.findElement(By.xpath("//input[@id='institute_state']/following-sibling::div[contains(text(),' The state should not be more than 30 characters. ')]")).getText();
				System.out.println("The error message is displayed when the input for State is greater than 30 char!");
				Assert.assertEquals(errorState, "The state should not be more than 30 characters.");
				WebElement elementToScrollToSaveInst = findElement("InstutStateTextfield_XPATH");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToSaveInst);
				findElement("InstutStateTextfield_XPATH").clear();
				System.out.println("State field cleared.......");
				Thread.sleep(1000);
			}






		}catch(Exception e) {}
		//error message validation for City
		try
		{
			if(City.length() > 30)
			{
				String errorCity = driver.findElement(By.xpath("//input[@id='institute_city']/following-sibling::div[contains(text(),' The city should not be more than 30 characters. ')]")).getText();
				System.out.println("The error message is displayed when the input for City is greater than 30 char!");
				Assert.assertEquals(errorCity, "The city should not be more than 30 characters.");
				WebElement elementToScrollToSaveInst = findElement("InstutCityTextfield_XPATH");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToSaveInst);
				findElement("InstutCityTextfield_XPATH").clear();
				System.out.println("City field cleared.......");
				Thread.sleep(1000);
			}




		}catch(Exception e) {}
		//error message validation for Institution_name
		try
		{
			if(Institution_name.length()>50)
			{
				String errorInstName = driver.findElement(By.xpath("//input[@id='institute_name']/following-sibling::div[contains(text(),' The name should not be more than 50 characters. ')]")).getText();
				System.out.println("The error message is displayed when the input for School name is greater than 50 char!");
				Assert.assertEquals(errorInstName, "The name should not be more than 50 characters.");
				WebElement elementToScrollToSaveInst = findElement("InstitutionName_ID");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToSaveInst);
				findElement("InstitutionName_ID").clear();
				System.out.println("Inst name field cleared.......");
				Thread.sleep(1000);
			}




		}catch(Exception e) {}


		//error message validation for Degree_Concentration
		try
		{
			if(Degree_Concentration.length()>30)
			{
				String errorDegreeConc = driver.findElement(By.xpath("//input[@id='institute_degree_concentration']/following-sibling::div[contains(text(),' The degree concentration should not be more than 30 characters. ')]")).getText();
				System.out.println("The error message is displayed when the input for SAIS Number is greater than 30 char!");
				Assert.assertEquals(errorDegreeConc, "The degree concentration should not be more than 30 characters.");
				WebElement elementToScrollToSaveInst = findElement("DegreeConcTextfield_ID");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToSaveInst);
				findElement("DegreeConcTextfield_ID").clear();
				System.out.println("Degree conc field cleared.......");
				Thread.sleep(1000);
			}




		}catch(Exception e) {}


	}


	public void EnterFirstAndLastDate() throws InterruptedException
	{


		// Add First attended and Last attended
		// Choose Random Month for first attended date
		WebElement elementToScrollToInst = findElement("InstDateFirstMonth_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToInst);
		click("InstDateFirstMonth_ID");
		Thread.sleep(1000);
		List<WebElement> options111 = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options111 = options111.size();
		System.out.println(Options111);
		Random random = new Random();
		int randomIndex = random.nextInt(options111.size());
		WebElement randomOption111 = options111.get(randomIndex);
		Thread.sleep(1000);
		randomOption111.click();
		Thread.sleep(1000);
		String selectedMonth = findElement("InstDateFirstMonth_ID").getText();
		System.out.println("Selected Month for first attended date: " + selectedMonth);
		log.debug("Selected Month for first attended date: " + selectedMonth);














		// Choose Random Year for first attended date
		WebElement elementToScrollToFirstYear = findElement("InstDateFirstYear_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToFirstYear);
		click("InstDateFirstYear_ID");
		Thread.sleep(1000);
		List<WebElement> options1111 = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1111 = options1111.size();
		System.out.println(Options1111);
		Random random1111 = new Random();
		int randomIndex1111 = random1111.nextInt(options1111.size());
		WebElement randomOption1111 = options1111.get(randomIndex1111);
		Thread.sleep(1000);
		randomOption1111.click();
		Thread.sleep(1000);
		String selectedYear = findElement("InstDateFirstYear_ID").getText();
		System.out.println("Selected Year for first attended date: " + selectedYear);
		log.debug("Selected Year for first attended date: " + selectedYear);






		// Choose Random Year for last attended date ensuring it's greater than the first attended year
		WebElement elementToScrollToLastYear = findElement("InstDateLastYear_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToLastYear);
		click("InstDateLastYear_ID");
		Thread.sleep(1000);
		Random random11111 = new Random();
		// Choose Random Year for last attended date ensuring it's greater than or equal to the first attended year
		int firstYear = Integer.parseInt(selectedYear);
		List<WebElement> options11111 = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options11111 = options11111.size();
		System.out.println(Options11111+" No of years");
		int randomIndex11111 = random11111.nextInt(options11111.size());


		// Calculate the selected year between firstYear and 2023
		int selectedYear1 = firstYear + randomIndex11111;
		System.out.println(selectedYear1+"Selected last year");


		if (selectedYear1 <=firstYear) 
		{
			selectedYear1 = firstYear; // Set the minimum allowed year to firstYear
		}
		else if (selectedYear1==firstYear) 
		{
			selectedYear1 = firstYear+randomIndex11111; // Set the minimum allowed year to firstYear
		}
		else if (selectedYear1 > 2023) 
		{
			selectedYear1 = 2023; // Set the maximum allowed year to 2023
		}
		String selectedYear1Text;
		selectedYear1Text = String.valueOf(selectedYear1);


		List<WebElement> yearOptions = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));


		boolean yearFound = false;
		for (WebElement option : yearOptions) {
			if (option.getText().equals(selectedYear1Text)) {
				Thread.sleep(1000);
				option.click();
				yearFound = true;
				break;
			}
		}


		if (!yearFound) {
			// Handle the case when the desired year is not found in the dropdown options.
			// For example, you could handle this by selecting the first available option.
			WebElement firstOption = yearOptions.get(0);
			Thread.sleep(1000);
			firstOption.click();
			selectedYear1Text = firstOption.getText();
		}


		String SelectedLastYear = findElement("InstDateLastYear_ID").getText();
		System.out.println("Selected Year for last attended date: " + SelectedLastYear);
		log.debug("Selected Year for last attended date: " + SelectedLastYear);






		// Choose Random Month for last attended date
		Thread.sleep(1000);
		WebElement elementToScroll = findElement("InstDateLastMonth_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		click("InstDateLastMonth_ID");
		Thread.sleep(1000);
		List<WebElement> options111111 = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options111111 = options111111.size();
		System.out.println(Options111111);
		Random random111111 = new Random();
		int randomIndex111111 = random111111.nextInt(options111111.size());
		WebElement randomOption11111 = options111111.get(randomIndex111111);
		Thread.sleep(1000);
		randomOption11111.click();
		Thread.sleep(1000);
		String selectedMonth1 = findElement("InstDateLastMonth_ID").getText();
		System.out.println("Selected Month for last attended date: " + selectedMonth1);
		log.debug("Selected Month for last attended date: " + selectedMonth1);




	}




	public void saveInstitution() throws InterruptedException
	{
		// Save the School
		WebElement elementToScrollToSaveInst = findElement("SaveInstitBtn_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToSaveInst);
		Thread.sleep(1000);
		click("SaveInstitBtn_XPATH");
	}


	public void validateAddSchool()
	{
		WebElement elementToScrollToAddSchool = findElement("AddSchoolBtn_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToAddSchool);
		click("AddSchoolBtn_XPATH");
		if(findElement("InstitutionCountryDD_ID").isDisplayed())
		{
			log.debug("Country Dropdown for adding another institution is displayed");
		}
		else
			log.debug("Country Dropdown for adding another institution is Not displayed");


		click("CancelBtn_XPATH");
	}




	public void PreviousCollegeEligibility() throws InterruptedException 
	{
		WebElement elementToScrollTo = driver.findElement(By.xpath("//h3[.=' Previous college eligibility ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		log.debug("Are you eligible to return to each of the colleges or universities you have attended in the last seven years? If you have not attended college, please answer yes.");
		// Choose  ----- No 
		WebElement NoradioButton = driver.findElement(By.xpath("(//input[@name='eiligibility_to_college_radio'])[2]"));
		String selectedOption = NoradioButton.getAttribute("value");
		NoradioButton.click();
		System.out.println(selectedOption);
		log.debug(selectedOption + "No");
		WebElement elementToScrollTo1st = driver.findElement(By.xpath("//h3[.=' List the most recent college/university for which you are ineligible to return first ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1st);
		type("FirstIneligibleIN_ID","Test First Ineligible college");
		// Academic related--------
		// Choose  randomly the Reason for In eligibility-- YES or NO or No response
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='first_academic_related_radio']"));
		int Count = radioButtons.size();
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		String selectedOption1 = radioButtons.get(randomIndex).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons.get(randomIndex).click();
		if(selectedOption1.contains("Y"))
		{
			log.debug("Selected Option: " + "Yes");
		}
		if(selectedOption1.contains("N"))
		{
			log.debug("Selected Option: " + "No");
		}
		else
		{
			log.debug("Selected Option: " + "No response");
		}
		// Student Conduct related--------
				// Choose  randomly the Reason for In eligibility-- YES or NO or No response
		WebElement elementToScrollToStdConduct = driver.findElement(By.xpath("//h3[.=' Student conduct ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToStdConduct);
				List<WebElement> radioButtons1 = driver.findElements(By.xpath("//input[@name='firststudent_conduct_radio']"));
				int Count1 = radioButtons1.size();
				Random random1 = new Random();
				int randomIndex1 = random1.nextInt(radioButtons1.size());
				String selectedOption11 = radioButtons1.get(randomIndex1).getAttribute("value");
				// Click the randomly selected radio button
				radioButtons1.get(randomIndex1).click();
				if(selectedOption11.contains("Y"))
				{
					log.debug("Selected Option: " + "Yes");
				}
				if(selectedOption11.contains("N"))
				{
					log.debug("Selected Option: " + "No");
				}
				else
				{
					log.debug("Selected Option: " + "No response");
				}
				// Othert related--------
				// Choose  randomly the Reason for In eligibility-- YES or NO or No response
				WebElement elementToScrollToOther1 = driver.findElement(By.xpath("//h3[.=' Other ']"));
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToOther1);
				List<WebElement> radioButtons11 = driver.findElements(By.xpath("//input[@name='firstother_reason_radio']"));
				int Count11 = radioButtons11.size();
				Random random11 = new Random();
				int randomIndex11 = random11.nextInt(radioButtons11.size());
				String selectedOption111 = radioButtons11.get(randomIndex11).getAttribute("value");
				// Click the randomly selected radio button
				radioButtons11.get(randomIndex11).click();
				if(selectedOption111.contains("Y"))
				{
					log.debug("Selected Option: " + "Yes");
				}
				if(selectedOption111.contains("N"))
				{
					log.debug("Selected Option: " + "No");
				}
				else
				{
					log.debug("Selected Option: " + "No response");
				}
		// Explanation For 1st Ineligiblity
		WebElement elementToScrollTo1 = findElement("Explaination1stIN_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);	
		type("Explaination1stIN_ID","Test ineligible to return to the college/university listed ");
		Thread.sleep(1000);		// Additional Ineligible Coll
		WebElement elementToScrollTo2nd = findElement("AdditionalIneligibleIN_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2nd);	
		type("AdditionalIneligibleIN_ID","Test Second Ineligible college");
		Thread.sleep(1000);	
	// Reason why you are ineligible to return	
		WebElement elementToScrollTo2 = driver.findElement(By.xpath("(//h3[.=' Indicate below the reason why you are ineligible to return '])[2]"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		// Academics related -------
		// Choose  randomly the Reason for In eligibility-- YES or NO or No response
		WebElement elementToScrollRD1 = driver.findElement(By.xpath("(//h3[.=' Academic related '])[2]"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollRD1);
		List<WebElement> radioButtons111 = driver.findElements(By.xpath("//input[@name='second_academic_related_radio']"));
		int Count111 = radioButtons111.size();
		Random random111 = new Random();
		int randomIndex111 = random111.nextInt(radioButtons111.size());
		String selectedOption1111 = radioButtons111.get(randomIndex111).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons111.get(randomIndex111).click();
		if(selectedOption1111.contains("Y"))
		{
			log.debug("Selected Option: " + "Yes");
		}
		if(selectedOption1111.contains("N"))
		{
			log.debug("Selected Option: " + "No");
		}
		else
		{
			log.debug("Selected Option: " + "No response");
		}
		// Student conduct related -------
				// Choose  randomly the Reason for In eligibility-- YES or NO or No response
		WebElement elementToScrollRD2 = driver.findElement(By.xpath("(//h3[.=' Student conduct '])[2]"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollRD2);
				List<WebElement> radioButtons1111 = driver.findElements(By.xpath("//input[@name='secondstudent_conduct_radio']"));
				int Count1111 = radioButtons1111.size();
				Random random1111 = new Random();
				int randomIndex1111 = random1111.nextInt(radioButtons1111.size());
				String selectedOption11111 = radioButtons1111.get(randomIndex1111).getAttribute("value");
				// Click the randomly selected radio button
				radioButtons1111.get(randomIndex1111).click();
				if(selectedOption11111.contains("Y"))
				{
					log.debug("Selected Option: " + "Yes");
				}
				if(selectedOption11111.contains("N"))
				{
					log.debug("Selected Option: " + "No");
				}
				else
				{
					log.debug("Selected Option: " + "No response");
				}
				// Other related -------
				// Choose  randomly the Reason for In eligibility-- YES or NO or No response
				WebElement elementToScrollRD3 = driver.findElement(By.xpath("(//h3[.=' Other '])[2]"));
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollRD3);
				List<WebElement> radioButtons11111 = driver.findElements(By.xpath("//input[@name='secondother_reason_radio']"));
				int Count11111 = radioButtons11111.size();
				Random random11111 = new Random();
				int randomIndex11111 = random11111.nextInt(radioButtons11111.size());
				String selectedOption111111 = radioButtons11111.get(randomIndex11111).getAttribute("value");
				// Click the randomly selected radio button
				radioButtons11111.get(randomIndex11111).click();
				if(selectedOption111111.contains("Y"))
				{
					log.debug("Selected Option: " + "Yes");
				}
				if(selectedOption111111.contains("N"))
				{
					log.debug("Selected Option: " + "No");
				}
				else
				{
					log.debug("Selected Option: " + "No response");
				}
		
		WebElement elementToScrollTo2nd1 = driver.findElement(By.xpath("(//h3[.=' Please explain why you are ineligible to return to the college/university listed '])[2]"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2nd1);	
		type("Explaination2ndIN_ID","Test Additional ineligible to return to the college/university listed ");
		Thread.sleep(1000);
	}
	
	public void TranscriptPolicy() throws InterruptedException
	{
		WebElement elementToScroll = driver.findElement(By.xpath("//h3[.=' Transcript policy ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		Thread.sleep(1000);
		// Validate the Trancript Requirement Sidebar
		click("TranscriptRequirements_XPATH");
		WebElement Title = findElement("TranscriptRequirementsTitle_XPATH");
		boolean isElementVisible = Title.isDisplayed();


		if (isElementVisible) {
			log.debug(" Transcript Requirements sidebar opened successfully ");
		} 
		else 
		{
			log.debug("Issue in displaying the Transcript Requirements sidebar");
		}
		// Close it
		Thread.sleep(1000);
		click("TranscriptReqBAckBtn_XPATH");
		Thread.sleep(1000);
		WebElement element = findElement("AcknowledgeCheckBox_XPATH");
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
	}
		
	
	  
	public void SaveThePage() throws InterruptedException
	{
		// Clicks on Save button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[.=' Save ']")).click();
		Thread.sleep(3000);
	}


}


