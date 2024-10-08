package com.ugapp.pages;




import java.util.List;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.ugapp.base.Page;




public class MySchoolsPage  extends Page
{

	ThreadLocal<String> RecentState =new ThreadLocal<>();
	ThreadLocal<String> PreviouslyAttendedOrAttending=new ThreadLocal<>();
	ThreadLocal<String> PreviousCollegeEligibility =new ThreadLocal<>();
	static ThreadLocal<String> colNumKey= new ThreadLocal<>();
	static ThreadLocal<String> colNumValue= new ThreadLocal<>();

	static int row = 50;
	JavascriptExecutor js = (JavascriptExecutor) getDriver();


	public void ValidateForMySchools() throws Throwable
	{
		waitTillProgressbarDisappears();
		WebElement elementToScrollTo1 = findElement("MySchoolsTitle_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		String PageTitle = findElement("MySchoolsTitle_XPATH").getText();
		log.debug("Page title :"+" "+PageTitle);

	}

	public void RandomHighSchool_country() throws Throwable
	{
		log.debug("Current or most recent high school");
		click("SchoolCountryDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		// Get the text of the chosen random Country
		String 	selectedCountryText	=	getDriver().findElement(By.xpath("//div[@id='high_school_country_select']")).getText();
		log.debug("Selected High school Country: " + selectedCountryText);

	}



	public void GraduatingSchool(String State , String City ,String School_name, String SAISno ) throws InterruptedException //String State , String City ,String School_name, String SAISno 
	{
		// validate State
		Thread.sleep(2000);
		WebElement stateElement = getDriver().findElement(By.id("school_state")); 
		if (stateElement.getTagName().equals("div")) 
		{
			// It's a dropdown
			log.debug("State is a dropdown.");
			click("SchoolStateDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			// Generate a random index to choose a random State
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			// Click on the random State
			WebElement randomOption1 = options1.get(randomIndex11);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			// Get the text of the chosen random State
			String 	selectedStateText	=	getDriver().findElement(By.xpath("//div[@id='school_state']")).getText();
			log.debug("Selected High school State: " + selectedStateText);


		}




		else if (stateElement.getTagName().equals("input")) 
		{
			// It's a textfield
			log.debug("State is a textfield.");
			Thread.sleep(1000);
			type("SchoolStateTextfield_XPATH",State);
			//			type("SchoolStateTextfield_XPATH","Test State");
		}
		else 
		{
			// It's neither a dropdown nor a textfield
			log.debug("State is neither a dropdown nor a textfield.");
		}
		// Validate City
		WebElement cityElement = getDriver().findElement(By.id("school_city")); 
		if (cityElement.getTagName().equals("div")) 
		{
			// It's a dropdown
			log.debug("City is a dropdown.");
			click("SchoolCityDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex11);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			String 	selectedCityText	=	getDriver().findElement(By.xpath("//div[@id='school_city']")).getText();
			log.debug("Selected High school City: " + selectedCityText);
			Thread.sleep(2000);
			// Validate for SAISNO ----- SAIS No




			String 	selectedStateText	=	getDriver().findElement(By.xpath("//div[@id='school_state']")).getText();
			if(selectedStateText.equals("Arizona"))
			{
				WebElement elementToScrollTo1 = findElement("SAISNo_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				type("SAISNo_ID",SAISno);
			}
			// Validate High School
			click("HighSchoolDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options11 = options11.size();
			Random random111 = new Random();
			int randomIndex111 = random111.nextInt(options11.size());
			WebElement randomOption11 = options11.get(randomIndex111);
			Thread.sleep(1000);
			randomOption11.click();
			Thread.sleep(1000);
			String 	selectedHighSchoolText	=	getDriver().findElement(By.xpath("//div[@id='school_highschool']")).getText();
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
			log.debug("City is a textfield.");
			type("SchoolCityTextfield_XPATH",City);
			Thread.sleep(2000);


			// Entering the School
			type("SchoolNameTextfield_XPATH",School_name);
		}
		else 
		{
			// It's neither a dropdown nor a textfield
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
				String errorState = getDriver().findElement(By.xpath("//input[@id='school_state']/following-sibling::div[contains(text(),' The state should not be more than 30 characters. ')]")).getText();
				log.debug("The error message is displayed when the input for State is greater than 30 char!");
				Assert.assertEquals(errorState, "The state should not be more than 30 characters.");
				findElement("SchoolStateTextfield_XPATH").clear();
			}






		}catch(Exception e) {}
		//error message validation for City
		try
		{
			if(City.length() > 30)
			{
				String errorCity = getDriver().findElement(By.xpath("//input[@id='school_city']/following-sibling::div[contains(text(),' The city should not be more than 30 characters. ')]")).getText();
				log.debug("The error message is displayed when the input for City is greater than 30 char!");
				Assert.assertEquals(errorCity, "The city should not be more than 30 characters.");
				findElement("SchoolCityTextfield_XPATH").clear();
			}




		}catch(Exception e) {}
		//error message validation for School name
		try
		{
			if(School_name.length()>30)
			{
				String errorCity = getDriver().findElement(By.xpath("//input[@id='school_schoolname']/following-sibling::div[contains(text(),' The name should not be more than 30 characters. ')]")).getText();
				log.debug("The error message is displayed when the input for School name is greater than 30 char!");
				Assert.assertEquals(errorCity, "The name should not be more than 30 characters.");
				findElement("SchoolNameTextfield_XPATH").clear();
			}




		}catch(Exception e) {}
		//error message validation for SAIS no
		try
		{
			if(SAISno.length()>10)
			{
				String errorSAISNo = getDriver().findElement(By.xpath("//input[@id='school_sais']/following-sibling::div[contains(text(),' The SAIS should not be more than 10 characters. ')]")).getText();
				log.debug("The error message is displayed when the input for SAIS Number is greater than 10 char!");
				Assert.assertEquals(errorSAISNo, "The SAIS should not be more than 10 characters.");
				findElement("SAISNo_ID").clear();
			}


		}catch(Exception e) {}


	}


	public void FutureGraduationDate() throws InterruptedException {

		// Select Graduation Year ---- Future Graduation date flow
		WebElement elementToScrollTo2 = findElement("GradYear_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		click("GradYear_ID");
		Thread.sleep(500);
		List<WebElement> optionsList1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options111 = optionsList1.size();
		// Generate a random index to choose a random graduation year between 2023 and 2028
		Random random1111 = new Random();
		int randomIndex1111 = random1111.nextInt(4); // Random index between 0 and 3 (inclusive) for 5 years (2024 to 2029)
		WebElement selectedOption1 = optionsList1.get(randomIndex1111);
		selectedOption1.click();
		Thread.sleep(1000);
		String selectedYearText = findElement("GradYear_ID").getText();
		log.debug("Selected Graduation Year: " + selectedYearText);

		// Select Graduation Month
		click("GradMonth_ID");
		Thread.sleep(500);
		List<WebElement> options11 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options11 = options11.size();
		Random random111 = new Random();
		int randomIndex111 = random111.nextInt(options11.size());
		WebElement randomOption11 = options11.get(randomIndex111);
		// If the selected year is 2029, choose January (index 0)
		if (selectedYearText.equals("2029")) 
		{
			randomIndex111 = 0; // January
		}
		Thread.sleep(1000);
		randomOption11.click();
		Thread.sleep(1000);
		String selectedMonthText = findElement("GradMonth_ID").getText();
		log.debug("Selected Graduation Month: " + selectedMonthText);
	}







	public void PastGraduationDate(String colKey,String colValue) throws EncryptedDocumentException, Exception {


		// Select Graduation Year ---- Past Graduation date flow
		WebElement elementToScrollTo2 = findElement("GradYear_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		click("GradYear_ID");
		Thread.sleep(500);
		List<WebElement> optionsList1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options111 = optionsList1.size();
		Random random1111 = new Random();
		int randomIndex1111 = random1111.nextInt(101); // Random index between 0 and 100 (inclusive) for 101 years (1924 to 2023)
		WebElement selectedOption1 = optionsList1.get(randomIndex1111);
		selectedOption1.click();
		Thread.sleep(1000);
		String selectedYearText = findElement("GradYear_ID").getText();
		log.debug("Selected Graduation Year: " + selectedYearText);

		// Select Graduation Month
		WebElement elementToScrollTo1 = findElement("GradMonth_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("GradMonth_ID");
		Thread.sleep(500);
		List<WebElement> options11 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options11 = options11.size();
		Random random111 = new Random();
		int randomIndex111 = random111.nextInt(options11.size());
		WebElement randomOption11 = options11.get(randomIndex111);
		Thread.sleep(500);
		randomOption11.click();
		Thread.sleep(500);
		String selectedMonthText = findElement("GradMonth_ID").getText();
		log.debug("Selected Graduation Month: " + selectedMonthText);

		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData",48, "Graduation date", selectedMonthText+", "+selectedYearText);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

		WebElement elementToScrollTo = findElement("SaveSchool_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		click("SaveSchool_XPATH");
		Thread.sleep(1000);

	}

	public void RandomGraduationDate(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{

		// Select Graduation random Year
		WebElement elementToScrollTo2 = findElement("GradYear_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		click("GradYear_ID");
		Thread.sleep(500);
		List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1 = options1.size();
		Random random11 = new Random();
		int randomIndex11 = random11.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex11);
		Thread.sleep(1000);
		randomOption1.click();
		String GradYear = findElement("GradYear_ID").getText();

		// Select Graduation random Month
		click("GradMonth_ID");
		Thread.sleep(500);
		List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		if(GradYear.equals("2029"))
		{
			randomIndex1 = 0; // Selects January
		}
		Thread.sleep(1000);
		randomOption.click();



		String selectedMonthText = findElement("GradMonth_ID").getText();
		String selectedRandomGradYear = findElement("GradYear_ID").getText();
		String Grad = selectedMonthText+","+selectedRandomGradYear;
		log.debug("Selected Graduation Year: " + selectedRandomGradYear);
		log.debug("Selected Graduation Month: " + selectedMonthText);
		if(selectedRandomGradYear.equals("2025") ||selectedRandomGradYear.equals("2026") || selectedRandomGradYear.equals("2027")||selectedRandomGradYear.equals("2028")||selectedRandomGradYear.equals("2029") )
		{
			RandomGradYear.set("Future Graduation date");
			System.out.println("RandomGradYear :"+RandomGradYear.get());
			log.debug("Selected Graduation flow : Future Graduated flow");
		}
		if(!selectedRandomGradYear.equals("2025") || !selectedRandomGradYear.equals("2026") || !selectedRandomGradYear.equals("2027")|| !selectedRandomGradYear.equals("2028")|| !selectedRandomGradYear.equals("2029") )
		{
			RandomGradYear.set("Past Graduation date");
			System.out.println("RandomGradYear :"+RandomGradYear.get());
			log.debug("Selected Graduation flow : Past Graduated flow");
		}
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData",48, "Graduation date", Grad);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		WebElement elementToScrollTo = findElement("SaveSchool_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		// Save the School added
		click("SaveSchool_XPATH");
		Thread.sleep(1000);
	}







	public void SelectNameOnTranscript() throws InterruptedException {




		// Select Transcript name
		WebElement elementToScrollTo1 = findElement("TranscriptName_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("TranscriptName_ID");
		Thread.sleep(500);
		List<WebElement> options11 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options11 = options11.size();
		Random random111 = new Random();
		int randomIndex111 = random111.nextInt(options11.size());
		WebElement randomOption11 = options11.get(randomIndex111);
		randomOption11.click();
		Thread.sleep(1000);
		String selectedNameText = findElement("TranscriptName_ID").getText();
		log.debug("Name on transcript" + selectedNameText);
		if(selectedNameText.contains("Other"))
		{
			type("FirstName_ID","First name");
			type("LastName_ID","Last name");
			getDriver().findElement(By.xpath("(//button[.=' Save '])[2]")).click();
			Thread.sleep(500);
		}
		Thread.sleep(1000);
		WebElement elementToScrollTo = findElement("SaveSchool_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		Thread.sleep(1000);
		click("SaveSchool_XPATH");
		Thread.sleep(1000);
	}


	public void DeleteAddedSchool() throws InterruptedException
	{
		WebElement elementToScrollTo1 = getDriver().findElement(By.xpath("//span[.='Current or most recent high school']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		List<WebElement> deleteButtons1 = getDriver().findElements(By.xpath("//a[@class='text-dark-3 ml-space-xs']"));
		Random random = new Random();
		int randomIndex1 = random.nextInt(deleteButtons1.size());
		// Click on the random Edit button
		WebElement randomDeleteButton1 = deleteButtons1.get(randomIndex1);
		randomDeleteButton1.click();
		log.debug("Deleting the Randomly added Recent High school");
		Thread.sleep(1000);
		click("Delete_XPATH");
	}

	public void Random_RecentSchool(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		log.debug("Current or most recent high school");
		WebElement elementToScrollTo1 = getDriver().findElement(By.xpath("//div[@id='high_school_country_select']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='high_school_country_select']"))).click();
		click("SchoolCountryDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		// Get the text of the chosen random Country
		String 	selectedCountryText	=	getDriver().findElement(By.xpath("//div[@id='high_school_country_select']")).getText();
		log.debug("Selected High school Country: " + selectedCountryText);
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 44, " Graduating school ","");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

		WebElement stateElement = getDriver().findElement(By.id("school_state")); 
		if (stateElement.getTagName().equals("div")) 
		{
			// It's a dropdown
			log.debug("State is a dropdown.");
			click("SchoolStateDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			// Generate a random index to choose a random State
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			// Click on the random State
			WebElement randomOption1 = options1.get(randomIndex11);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			// Get the text of the chosen random State
			String 	selectedStateText	=	getDriver().findElement(By.xpath("//div[@id='school_state']")).getText();
			log.debug("Selected High school State: " + selectedStateText);
			RecentState.set(selectedStateText);
		}




		else if (stateElement.getTagName().equals("input")) 
		{
			// It's a textfield
			log.debug("State is a textfield.");
			Thread.sleep(1000);
			type("SchoolStateTextfield_XPATH","Test state");
			log.debug("Selected High school State: " + "Test state");
			RecentState.set("Test state");


		}
		else 
		{
			// It's neither a dropdown nor a textfield
			log.debug("State is neither a dropdown nor a textfield.");
		}

		// Validate City
		WebElement cityElement = getDriver().findElement(By.id("school_city")); 
		if (cityElement.getTagName().equals("div")) 
		{
			// It's a dropdown
			log.debug("City is a dropdown.");
			click("SchoolCityDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex11);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			String 	selectedCityText	=	getDriver().findElement(By.xpath("//div[@id='school_city']")).getText();
			log.debug("Selected High school City: " + selectedCityText);
			RecentCity.set(selectedCityText);
			Thread.sleep(2000);
			// Validate for SAISNO ----- SAIS No




			String 	selectedStateText	=	getDriver().findElement(By.xpath("//div[@id='school_state']")).getText();
			if(selectedStateText.equals("Arizona"))
			{
				WebElement elementToScrollTo11 = findElement("SAISNo_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
				type("SAISNo_ID","1234567890");
			}
			// Validate High School
			click("HighSchoolDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options11 = options11.size();
			Random random111 = new Random();
			int randomIndex111 = random111.nextInt(options11.size());
			WebElement randomOption11 = options11.get(randomIndex111);
			Thread.sleep(1000);
			randomOption11.click();
			Thread.sleep(1000);
			String 	selectedHighSchoolTextforRecentSchool	=	getDriver().findElement(By.xpath("//div[@id='school_highschool']")).getText();
			log.debug("Selected High school City: " + selectedHighSchoolTextforRecentSchool);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 45, "High school name", selectedHighSchoolTextforRecentSchool);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


			if(selectedHighSchoolTextforRecentSchool.contains("My High School is not on the list"))
			{
				Thread.sleep(2000);
				type("SchoolNameTextfield_XPATH","Test School");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData", 45, "High school name", "Test School");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}


		}




		else if (cityElement.getTagName().equals("input")) 
		{
			// It's a textfield ---- Enter School name
			log.debug("City is a textfield.");
			type("SchoolCityTextfield_XPATH","Test City");
			RecentCity.set("Test City");
			Thread.sleep(2000);
			type("SchoolNameTextfield_XPATH","Test School");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 45, "High school name", "Test School");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		else 
		{
			log.debug("City is neither a dropdown nor a textfield.");
		}


		//		WebElement elementToScrollTo1 = findElement("TranscriptName_ID");
		//		this.js = (JavascriptExecutor) getDriver();
		//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		//		click("TranscriptName_ID");
		//		Thread.sleep(500);
		//		List<WebElement> options111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		//		int Options111 = options111.size();
		//		Random random1111 = new Random();
		//		int randomIndex1111 = random1111.nextInt(options111.size());
		//		WebElement randomOption111 = options111.get(randomIndex1111);
		//		randomOption111.click();
		//		Thread.sleep(1000);
		//		String selectedNameText = findElement("TranscriptName_ID").getText();
		//		log.debug("Name on transcript" + selectedNameText);
		//		if(selectedNameText.contains("Other"))
		//		{
		//			type("FirstName_ID","First name");
		//			type("LastName_ID","Last name");
		//			getDriver().findElement(By.xpath("(//button[.=' Save '])[2]")).click();
		//			Thread.sleep(2000);
		//			// initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		//			setExcelData(colKey,colValue,"validData", 46, "Name on transcript", "Test FN Test LN");
		//			// saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		//		}
		//		click("SaveSchool_XPATH");

		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 46, "Name on transcript", "Test FN Test LN");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		String statecode= findStateCode(selectedCountryText,RecentState.get());
		String countrycode = findCountryCode(selectedCountryText);

		String location = RecentCity.get()+", "+statecode+", "+countrycode;
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData",47, "Location", location);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

	}


	public void RecentSchoolAZ(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{


		Thread.sleep(1000);
		log.debug("Add AZ as Recent high school");
		WebElement elementToScrollTo1 = findElement("SchoolCountryDD_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("SchoolCountryDD_XPATH");
		Thread.sleep(1000);
		click("UScountryDD_XPATH");
		String 	selectedCountryText	=	findElement("SchoolCountryDD_XPATH").getText();
		log.debug("Selected High school Country: " + selectedCountryText);
		//		WebElement elementToScrollTo11 = findElement("SchoolStateDD_XPATH");
		//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		Thread.sleep(1500);
		click("SchoolStateDD_XPATH");
		WebElement elementToScrollTo111 = findElement("AZstateDD_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		click("AZstateDD_XPATH");
		String 	selectedStateText	=	findElement("SchoolStateDD_XPATH").getText();
		log.debug("Selected High school State: " + selectedStateText);



		WebElement elementToScrollTo1111 = findElement("SchoolCityDD_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
		click("SchoolCityDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1 = options1.size();
		Random random11 = new Random();
		int randomIndex11 = random11.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex11);
		Thread.sleep(1000);
		randomOption1.click();
		Thread.sleep(1000);
		String 	selectedCityText	=	findElement("SchoolCityDD_XPATH").getText();
		log.debug("Selected High school City: " + selectedCityText);
		click("HighSchoolDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options11 = options11.size();
		Random random111 = new Random();
		int randomIndex111 = random111.nextInt(options11.size());
		WebElement randomOption11 = options11.get(randomIndex111);
		Thread.sleep(1000);
		randomOption11.click();
		Thread.sleep(1000);
		String 	selectedHighSchoolText	=	findElement("HighSchoolDD_XPATH").getText();
		log.debug("Selected High school Text: " + selectedHighSchoolText);


		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 44, " Graduating school ","");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 45, "High school name", selectedHighSchoolText);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


		if(selectedHighSchoolText.contains("My High School is not on the list"))
		{
			Thread.sleep(2000);
			type("SchoolNameTextfield_XPATH","Test School");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 45, "High school name", "Test School");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}




		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 46, "Name on transcript", "Test FN Test LN");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");






		String statecode= findStateCode(selectedCountryText,selectedStateText);

		String countrycode = findCountryCode(selectedCountryText);




		String location = selectedCityText+", "+statecode+", "+countrycode;




		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData",47, "Location", location);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


		// Select Graduation Month
		WebElement elementToScrollTo11 = findElement("GradMonth_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		click("GradMonth_ID");
		Thread.sleep(500);
		List<WebElement> options111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
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
		log.debug("Selected Graduation Month: " + selectedMonthText);




		// Select Graduation Year ---- Future Graduation date flow
		WebElement elementToScrollTo2 = findElement("GradYear_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		click("GradYear_ID");
		Thread.sleep(500);
		List<WebElement> optionsList1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1111 = optionsList1.size();




		// Generate a random index to choose a random graduation year between 2023 and 2028
		Random random11111 = new Random();
		int randomIndex11111 = random11111.nextInt(4); // Random index between 0 and 4 (inclusive) for 5 years (2023 to 2028)
		int selectedYear1 = 2028 - randomIndex11111; // Calculate the selected year

		// Assuming optionsList is your list of WebElement options retrieved from the dropdown
		WebElement selectedOption1 = optionsList1.get(randomIndex11111);
		selectedOption1.click();
		Thread.sleep(1000);
		String selectedYearText = findElement("GradYear_ID").getText();
		log.debug("Selected Graduation Year: " + selectedYearText);
		WebElement elementToScrollTo = findElement("SaveSchool_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		click("SaveSchool_XPATH");		
		log.debug("Graduation Date :"+selectedMonthText+", "+selectedYearText);

		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData",48, "Graduation date", selectedMonthText+", "+selectedYearText);
		setExcelData(colKey,colValue,"validData",49, " Past schools ","");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}



	//String State , String City ,String School_name, String SAISno 
	public void AddMaxHighSchool(String State , String City ,String School_name, String SAISno ) throws Exception 
	{
		String 	selectedCountryText	="";
		String 	selectedStateText = "";
		String 	selectedCityText = "";
		String statecode="";
		String countrycode ="";
		String location ="";


//		Thread.sleep(1500);
		WebElement elementToScrollTo1 = findElement("AddHighschoolBtn_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		boolean AddHighschoolButton = findElement("AddHighschoolBtn_XPATH").isEnabled();
		if(AddHighschoolButton==true)
		{
			WebElement elementToScrollTo2 = findElement("AddHighschoolBtn_XPATH");
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			Thread.sleep(1000);
			findElement("AddHighschoolBtn_XPATH").click();
			Thread.sleep(1000);
		}
		else 
		{
			String MaxErrorMsg = findElement("MaxLimitErrMsg_XPATH").getText();
			Assert.assertEquals(MaxErrorMsg, "Reached maximum limit ");
			log.debug("Reached maximum limit...... ");
		}




		WebElement elementToScrollTo2 = findElement("SchoolCountryDD_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		click("SchoolCountryDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		System.out.println(Options);
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		// Get the text of the chosen random Country
		selectedCountryText	=	getDriver().findElement(By.xpath("//div[@id='high_school_country_select']")).getText();
		System.out.println("Selected High school Country: " + selectedCountryText);
		log.debug("Selected High school Country: " + selectedCountryText);


		countrycode = findCountryCode(selectedCountryText);
		System.out.println("Country code :"+countrycode);




		// validate State
		Thread.sleep(2000);
		WebElement stateElement = getDriver().findElement(By.id("school_state")); 
		if (stateElement.getTagName().equals("div")) 
		{
			// It's a dropdown
			System.out.println("State is a dropdown.");
			log.debug("State is a dropdown.");
			click("SchoolStateDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
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
			selectedStateText	=	getDriver().findElement(By.xpath("//div[@id='school_state']")).getText();
			System.out.println("Selected High school State: " + selectedStateText);
			log.debug("Selected High school State: " + selectedStateText);


			statecode= findStateCode(selectedCountryText,selectedStateText);
			System.out.println("State code :"+statecode);

		}




		else if (stateElement.getTagName().equals("input")) 
		{
			// It's a textfield
			System.out.println("State is a textfield.");
			log.debug("State is a textfield.");
			Thread.sleep(1000);
			type("SchoolStateTextfield_XPATH",State);
			statecode = State;
			//			type("SchoolStateTextfield_XPATH","Test State");
		}
		else 
		{
			// It's neither a dropdown nor a textfield
			log.debug("State is neither a dropdown nor a textfield.");
		}




		// Validate City
		WebElement cityElement = getDriver().findElement(By.id("school_city")); 
		if (cityElement.getTagName().equals("div")) 
		{
			// It's a dropdown
			log.debug("City is a dropdown.");
			click("SchoolCityDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex11);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			selectedCityText	=	getDriver().findElement(By.xpath("//div[@id='school_city']")).getText();
			log.debug("Selected High school City: " + selectedCityText);
			Thread.sleep(2000);
			// Validate for Arizona ----- SAIS No
			selectedStateText	=	getDriver().findElement(By.xpath("//div[@id='school_state']")).getText();
			if(selectedStateText.equals("Arizona"))
			{
				type("SAISNo_ID",SAISno);
				//				type("SAISNo_ID","1234567891");
			}
			// Validate High School
			click("HighSchoolDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options11 = options11.size();
			Random random111 = new Random();
			int randomIndex111 = random111.nextInt(options11.size());
			WebElement randomOption11 = options11.get(randomIndex111);
			Thread.sleep(1000);
			randomOption11.click();
			Thread.sleep(1000);
			String 	selectedHighSchoolText	=	getDriver().findElement(By.xpath("//div[@id='school_city']")).getText();
			log.debug("Selected High school City: " + selectedHighSchoolText);


			if(selectedHighSchoolText.contains("My High School is not on the list"))
			{
				Thread.sleep(2000);
				type("SchoolNameTextfield_XPATH",School_name);


				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colNumKey.get(),colNumValue.get(),"validData", row++, "High school name", School_name);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				//				type("SchoolNameTextfield_XPATH","Test School");
			}
			location = selectedCityText+", "+statecode+", "+countrycode;


		}




		else if (cityElement.getTagName().equals("input")) 
		{
			// It's a textfield ---- Enter School name
			log.debug("City is a textfield.");
			type("SchoolCityTextfield_XPATH",City);
			selectedCityText = City;


			location = selectedCityText+", "+statecode+", "+countrycode;

			Thread.sleep(2000);
			type("SchoolNameTextfield_XPATH",School_name);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey.get(),colNumValue.get(),"validData", row++, "High school name", School_name);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		else 
		{
			// It's neither a dropdown nor a textfield
			log.debug("City is neither a dropdown nor a textfield.");
		}


		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colNumKey.get(),colNumValue.get(),"validData", row++, "Name on transcript", "Test FN Test LN");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

		log.debug("Location :"+location);


		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colNumKey.get(),colNumValue.get(),"validData", row++, "Location", location);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


		// Choose Random Year for first attended date
		WebElement elementToScrollTo11 = findElement("DateFirstYear_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		click("DateFirstYear_ID");
		Thread.sleep(500);

		List<WebElement> options11 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));

		// Exclude the year 2023 from options
		options11.removeIf(option -> option.getText().equals("2024"));
		int Options11 = options11.size();
		Random random11 = new Random();
		int randomIndex11 = random11.nextInt(options11.size());
		WebElement randomOption11 = options11.get(randomIndex11);
		Thread.sleep(1000);
		randomOption11.click();
		Thread.sleep(1000);
		String selectedYear = findElement("DateFirstYear_ID").getText();
		log.debug("Selected Year for first attended date: " + selectedYear);






		// Choose Random Month for first attended date
		WebElement elementToScrollTo = findElement("DateFirstMonth_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		click("DateFirstMonth_ID");
		Thread.sleep(1000);
		List<WebElement> options1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1 = options1.size();
		Random random = new Random();
		int randomIndex = random.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex);
		Thread.sleep(1000);
		randomOption1.click();
		Thread.sleep(1000);
		String selectedMonth = findElement("DateFirstMonth_ID").getText();
		log.debug("Selected Month for first attended date: " + selectedMonth);



		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colNumKey.get(),colNumValue.get(),"validData", row++, "Start date", selectedMonth+", "+selectedYear);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




		WebElement elementToScrollTo111 = findElement("DateLastYear_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		click("DateLastYear_ID");
		Thread.sleep(1000);


		Random random1111 = new Random();
		int firstYear = Integer.parseInt(selectedYear);
		List<WebElement> options11111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int randomIndex11111 = random1111.nextInt(options11111.size());


		// Calculate the selected year between firstYear and 2023
		int selectedYear1 = firstYear + randomIndex11111 + 1;


		// Ensure that the selected year is always greater than the firstYear
		if (selectedYear1 <= firstYear) 
		{
			selectedYear1 = firstYear + 1;
			System.out.println("selectedYear1 :"+ selectedYear1);
		}


		// Ensure that the selected year is within the desired range (between firstYear and 2023)
		if (selectedYear1 > 2024) 
		{
			selectedYear1 = 2024;
		}


		String selectedYear1Text = String.valueOf(selectedYear1);

		//		// Choose Random Year for last attended date ensuring it's greater than the first attended year
		//		WebElement elementToScrollTo111 = findElement("DateLastYear_ID");
		//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		//		click("DateLastYear_ID");
		//		Thread.sleep(1000);
		//		Random random1111 = new Random();
		//		// Choose Random Year for last attended date ensuring it's greater than or equal to the first attended year
		//		int firstYear = Integer.parseInt(selectedYear);
		//		List<WebElement> options11111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		//		int Options111 = options11111.size();
		//		int randomIndex11111 = random1111.nextInt(options11111.size());
		//
		//
		//		// Calculate the selected year between firstYear and 2023
		//		int selectedYear1 = firstYear + randomIndex11111;
		//
		//
		//		if (selectedYear1 < firstYear) 
		//		{
		//			selectedYear1 = firstYear; // Set the minimum allowed year to firstYear
		//		} 
		//		else if (selectedYear1==firstYear) 
		//		{
		//			selectedYear1 = firstYear+randomIndex11111; // Set the minimum allowed year to firstYear
		//		}
		//		else if (selectedYear1 > 2023) 
		//		{
		//			selectedYear1 = 2023; // Set the maximum allowed year to 2023
		//		}
		//		String selectedYear1Text;
		//		selectedYear1Text = String.valueOf(selectedYear1);




		List<WebElement> yearOptions = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));




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
		log.debug("Selected Year for last attended date: " + SelectedLastYear);












		// Choose Random Month for last attended date
		Thread.sleep(500);
		WebElement elementToScroll = findElement("DateLastMonth_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		click("DateLastMonth_ID");
		Thread.sleep(1000);
		List<WebElement> options111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1111 = options111.size();
		Random random111 = new Random();
		int randomIndex111 = random111.nextInt(options111.size());
		WebElement randomOption111 = options111.get(randomIndex111);
		Thread.sleep(1000);
		randomOption111.click();
		Thread.sleep(1000);
		String selectedMonth1 = findElement("DateLastMonth_ID").getText();
		log.debug("Selected Month for last attended date: " + selectedMonth1);
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colNumKey.get(),colNumValue.get(),"validData", row++, "End date", selectedMonth1+", "+SelectedLastYear);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




		// Save the School
		WebElement elementToScrollTo1111 = findElement("SaveSchool_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
		Thread.sleep(1000);
		click("SaveSchool_XPATH");
		log.debug("High school added successfully!!!");
	}


	public void HaveAttendedOrAttendingCollegeAndUniversities_Yes(String colKey,String colValue) throws InterruptedException, Exception
	{

		WebElement elementToScrollTo2 = getDriver().findElement(By.xpath("//h3[.=' Have you previously attended or are you currently attending a college or university? ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		log.debug("Have you previously attended or are you currently attending a college or university?   :  Yes" );
		// Choose  ----- Yes 
		Thread.sleep(2000);
		WebElement YesradioButton = getDriver().findElement(By.xpath("(//input[@name='request_transcripts_radio'])[1]"));
		// Get the text of the randomly selected radio button
		String selectedOption = YesradioButton.getAttribute("value");
		YesradioButton.click();

		try
		{
			if(findElement("SemesterCredits_XPATH").isDisplayed())
			{


				WebElement elementToScrollTo = findElement("SemesterCredits_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				type("SemesterCredits_XPATH", "5");
				WebElement elementToScrollTo1 = findElement("TransferCreditGuide_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				click("TransferCreditGuide_XPATH");
				Thread.sleep(2000);
				try
				{
					findElement("ValidateTransferCreditGuide_XPATH");
					log.debug("Transfer credits to ASU section is displayed when clicked on Transfer Credit Guide link!");
					findElement("BackBtnTransferCreditGuide_XPATH").click();
					Thread.sleep(1000);
				}
				catch(Exception e)
				{
					log.debug("Transfer credits to ASU section is not displayed when clicked on Transfer Credit Guide link!");

				}
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData", 103, "Transfer credits to ASU", "5");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}
		}
		catch(Exception e) {}

	}


	public void HaveAttendedOrAttendingCollegeAndUniversities_No(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		WebElement elementToScrollTo2 = getDriver().findElement(By.xpath("//h3[.=' Have you previously attended or are you currently attending a college or university? ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		log.debug("Have you previously attended or are you currently attending a college or university?    :   No");
		// Choose  ----- Yes 
		Thread.sleep(2000);
		WebElement NoradioButton = getDriver().findElement(By.xpath("(//input[@name='request_transcripts_radio'])[2]"));
		// Get the text of the randomly selected radio button
		String selectedOption = NoradioButton.getAttribute("value");
		NoradioButton.click();
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 49, "Transfer credits to ASU", "0");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}






	public void CollegeUniversities(String State , String City ,String Institution_name, String Degree_Concentration) throws Exception 
	{
		// initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colNumKey.get(),colNumValue.get(),"validData", 95, " Past colleges/universities ","");
		// saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		String 	selectedStateText = "";
		String 	selectedCityText = "";
		String statecode="";
		WebElement elementToScrollTo = findElement("InstitutionCountryDD_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		// Add a Institution Country
		click("InstitutionCountryDD_ID");
		Thread.sleep(2000);
		List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		Thread.sleep(1500);
		randomOption.click();
		Thread.sleep(1500);
		// Get the text of the chosen random Country
		String 	selectedCountryText	=	findElement("InstitutionCountryDD_ID").getText();
		log.debug("Selected Institution Country: " + selectedCountryText);

		String countryCode= findCountryCode(selectedCountryText);


		WebElement elementToScrollTo1 = getDriver().findElement(By.id("institute_state"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		WebElement stateElement = getDriver().findElement(By.id("institute_state"));
		if (stateElement.getTagName().equals("div")) 
		{
			// It's a dropdown
			log.debug("State is a dropdown.");
			// Add a Institution State
			click("InstitutionStateDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex11);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			// Get the text of the chosen random Country
			selectedStateText	=	findElement("InstitutionStateDD_XPATH").getText();
			log.debug("Selected Institution State: " + selectedStateText);


			statecode= findStateCode(selectedCountryText,selectedStateText);
		}
		else if (stateElement.getTagName().equals("input")) 
		{
			// It's a textfield
			log.debug("State is a textfield.");
			Thread.sleep(1000);
			type("InstutStateTextfield_XPATH",State);
			statecode = State;
		}
		else 
		{
			// It's neither a dropdown nor a textfield
			log.debug("State is neither a dropdown nor a textfield.");
		}




		// Validate City
		WebElement cityElement = getDriver().findElement(By.id("institute_city")); 
		if (cityElement.getTagName().equals("div")) 
		{
			// It's a dropdown
			log.debug("City is a dropdown.");
			// Add a Institution City
			click("InstitutionCityDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options11 = options11.size();
			Random random111 = new Random();
			int randomIndex111 = random111.nextInt(options11.size());
			WebElement randomOption11 = options11.get(randomIndex111);
			Thread.sleep(1000);
			randomOption11.click();
			Thread.sleep(1000);
			// Get the text of the chosen random Country
			selectedCityText	=	findElement("InstitutionCityDD_XPATH").getText();
			log.debug("Selected Institution City: " + selectedCityText);
		}
		else if (cityElement.getTagName().equals("input")) 
		{
			// It's a textfield
			log.debug("State is a textfield.");
			Thread.sleep(1000);
			type("InstutCityTextfield_XPATH",City);
			selectedCityText = City;
		}
		else 
		{
			// It's neither a dropdown nor a textfield
			log.debug("City is neither a dropdown nor a textfield.");
		}




		String location = selectedCityText+", "+statecode+", "+countryCode;
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colNumKey.get(),colNumValue.get(),"validData", 98, "Location",location);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");






		WebElement elementToScrollTo111 = findElement("SelectInstutDD_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		// Add a Institution Country
		click("SelectInstutDD_ID");
		Thread.sleep(1000);
		List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1 = options1.size();
		Random random11 = new Random();
		int randomIndex11 = random11.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex11);
		Thread.sleep(1000);
		randomOption1.click();
		Thread.sleep(1000);
		// Get the text of the chosen random Country
		String 	selectedInstitutionText	=	findElement("SelectInstutDD_ID").getText();
		log.debug("Selected Institution : " + selectedInstitutionText);
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colNumKey.get(),colNumValue.get(),"validData", 96, "School name", selectedInstitutionText);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




		log.debug("Selected Institution : " + selectedInstitutionText);
		WebElement elementToScrollTo1111 = findElement("SelectInstutDD_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
		if(selectedInstitutionText.contains("Not listed"))
		{
			WebElement elementToScrollToInstutName = findElement("InstitutionName_ID");
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToInstutName);
			Thread.sleep(1000);
			type("InstitutionName_ID",Institution_name);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey.get(),colNumValue.get(),"validData", 96, "School name", Institution_name);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			Thread.sleep(1000);
		}






		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colNumKey.get(),colNumValue.get(),"validData", 97, "Name on transcript", "Test FN Test LN");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




		WebElement elementToScrollToDegree = findElement("DegreeAwardedDD_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDegree);
		click("DegreeAwardedDD_ID");
		Thread.sleep(1000);
		List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options11 = options11.size();
		Random random111 = new Random();
		int randomIndex111 = random111.nextInt(options11.size());
		WebElement randomOption11 = options11.get(randomIndex111);
		Thread.sleep(1000);
		randomOption11.click();
		Thread.sleep(1000);
		// Get the text of the chosen random Country
		String 	selectedDegreeAwarded	=	findElement("DegreeAwardedDD_ID").getText();
		log.debug("Selected Institution : " + selectedDegreeAwarded);
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colNumKey.get(),colNumValue.get(),"validData", 99, "Degree", selectedDegreeAwarded);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		log.debug("Selected Institution : " + selectedDegreeAwarded);
		if(!selectedDegreeAwarded.contains("No Degree Awarded"))
		{
			WebElement elementToScrollToDegree1 = findElement("DegreeConcTextfield_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDegree1);
			type("DegreeConcTextfield_ID",Degree_Concentration);


			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey.get(),colNumValue.get(),"validData", 100, "Degree concentration", Degree_Concentration);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


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
				String errorState = getDriver().findElement(By.xpath("//input[@id='institute_state']/following-sibling::div[contains(text(),' The state should not be more than 30 characters. ')]")).getText();
				log.debug("The error message is displayed when the input for State is greater than 30 char!");
				Assert.assertEquals(errorState, "The state should not be more than 30 characters.");
				WebElement elementToScrollToSaveInst = findElement("InstutStateTextfield_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToSaveInst);
				findElement("InstutStateTextfield_XPATH").clear();
				log.debug("State field cleared.......");
				Thread.sleep(1000);
			}


		}catch(Exception e) {}
		//error message validation for City
		try
		{
			if(City.length() > 30)
			{
				String errorCity = getDriver().findElement(By.xpath("//input[@id='institute_city']/following-sibling::div[contains(text(),' The city should not be more than 30 characters. ')]")).getText();
				log.debug("The error message is displayed when the input for City is greater than 30 char!");
				Assert.assertEquals(errorCity, "The city should not be more than 30 characters.");
				WebElement elementToScrollToSaveInst = findElement("InstutCityTextfield_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToSaveInst);
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
				String errorInstName = getDriver().findElement(By.xpath("//input[@id='institute_name']/following-sibling::div[contains(text(),' The name should not be more than 50 characters. ')]")).getText();
				log.debug("The error message is displayed when the input for School name is greater than 50 char!");
				Assert.assertEquals(errorInstName, "The name should not be more than 50 characters.");
				WebElement elementToScrollToSaveInst = findElement("InstitutionName_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToSaveInst);
				findElement("InstitutionName_ID").clear();
				Thread.sleep(1000);
			}


		}catch(Exception e) {}




		//error message validation for Degree_Concentration
		try
		{
			if(Degree_Concentration.length()>30)
			{
				String errorDegreeConc = getDriver().findElement(By.xpath("//input[@id='institute_degree_concentration']/following-sibling::div[contains(text(),' The degree concentration should not be more than 30 characters. ')]")).getText();
				log.debug("The error message is displayed when the input for SAIS Number is greater than 30 char!");
				Assert.assertEquals(errorDegreeConc, "The degree concentration should not be more than 30 characters.");
				WebElement elementToScrollToSaveInst = findElement("DegreeConcTextfield_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToSaveInst);
				findElement("DegreeConcTextfield_ID").clear();
				Thread.sleep(1000);
			}

		}catch(Exception e) {}




	}


	public void EnterFirstAndLastDate(String colKey,String colValue) throws Exception
	{
		// Add First attended and Last attended
		// Choose Random Month for first attended date
		WebElement elementToScrollToInst = findElement("InstDateFirstMonth_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToInst);
		click("InstDateFirstMonth_ID");
		Thread.sleep(1000);
		List<WebElement> options111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options111 = options111.size();
		Random random = new Random();
		int randomIndex = random.nextInt(options111.size());
		WebElement randomOption111 = options111.get(randomIndex);
		Thread.sleep(1000);
		randomOption111.click();
		Thread.sleep(1000);
		String selectedMonth = findElement("InstDateFirstMonth_ID").getText();
		log.debug("Selected Month for first attended date: " + selectedMonth);






		// Choose Random Year for first attended date
		WebElement elementToScrollToFirstYear = findElement("InstDateFirstYear_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToFirstYear);
		click("InstDateFirstYear_ID");
		Thread.sleep(1000);
		List<WebElement> options1111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1111 = options1111.size();
		Random random1111 = new Random();
		int randomIndex1111 = random1111.nextInt(options1111.size());
		WebElement randomOption1111 = options1111.get(randomIndex1111);
		Thread.sleep(1000);
		randomOption1111.click();
		Thread.sleep(1000);
		String selectedYear = findElement("InstDateFirstYear_ID").getText();
		log.debug("Selected Year for first attended date: " + selectedYear);








		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 101, "Date first attended", selectedMonth+", "+selectedYear);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");






		// Choose Random Year for last attended date ensuring it's greater than the first attended year
		WebElement elementToScrollToLastYear = findElement("InstDateLastYear_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToLastYear);
		click("InstDateLastYear_ID");
		Thread.sleep(1000);
		Random random11111 = new Random();
		// Choose Random Year for last attended date ensuring it's greater than or equal to the first attended year
		int firstYear = Integer.parseInt(selectedYear);
		List<WebElement> options11111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options11111 = options11111.size();
		int randomIndex11111 = random11111.nextInt(options11111.size());




		// Calculate the selected year between firstYear and 2023
		int selectedYear1 = firstYear + randomIndex11111;
		log.debug(selectedYear1+"Selected last year");




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




		List<WebElement> yearOptions = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));




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
		log.debug("Selected Year for last attended date: " + SelectedLastYear);












		// Choose Random Month for last attended date
		Thread.sleep(1000);
		WebElement elementToScroll = findElement("InstDateLastMonth_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		click("InstDateLastMonth_ID");
		Thread.sleep(1000);
		List<WebElement> options111111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options111111 = options111111.size();
		Random random111111 = new Random();
		int randomIndex111111 = random111111.nextInt(options111111.size());
		WebElement randomOption11111 = options111111.get(randomIndex111111);
		Thread.sleep(1000);
		randomOption11111.click();
		Thread.sleep(1000);
		String selectedMonth1 = findElement("InstDateLastMonth_ID").getText();
		System.out.println("Selected Month for last attended date: " + selectedMonth1);
		log.debug("Selected Month for last attended date: " + selectedMonth1);

		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 102, "Date last attended", selectedMonth1+", "+SelectedLastYear);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

	}


	public void saveInstitution() throws InterruptedException
	{
		// Save the School
		WebElement elementToScrollToSaveInst = findElement("SaveInstitBtn_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToSaveInst);
		Thread.sleep(1000);
		click("SaveInstitBtn_XPATH");
	}


	public void validateAddSchool()
	{
		WebElement elementToScrollToAddSchool = findElement("AddSchoolBtn_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToAddSchool);
		click("AddSchoolBtn_XPATH");
		if(findElement("InstitutionCountryDD_ID").isDisplayed())
		{
			log.debug("Country Dropdown for adding another institution is displayed");
		}
		else
			log.debug("Country Dropdown for adding another institution is Not displayed");



		WebElement elementToScrollToCancel = findElement("CancelBtn_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToCancel);
		click("CancelBtn_XPATH");
	}


	public void PreviousCollegeEligibility(String colKey,String colValue) throws EncryptedDocumentException, Exception 
	{


		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 103, "Transfer credits to ASU", "0");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

		WebElement elementToScrollTo = getDriver().findElement(By.xpath("//h3[.=' Previous college eligibility ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		log.debug("Are you eligible to return to each of the colleges or universities you have attended in the last seven years? If you have not attended college, please answer yes.");
		// Choose  ----- No 
		WebElement NoradioButton = getDriver().findElement(By.xpath("(//input[@name='eiligibility_to_college_radio'])[2]"));
		NoradioButton.click();
		log.debug("Are you eligible to return to each of the colleges or universities you have attended in the last seven years? If you have not attended college, please answer yes." + "No");
		WebElement elementToScrollTo1st = getDriver().findElement(By.xpath("//h3[.=' List the most recent college/university for which you are ineligible to return first ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1st);
		type("FirstIneligibleIN_ID","Test First Ineligible college");




		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 104, "List the most recent college/university for which you are ineligible to return first", "Test First Ineligible college");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




		// Academic related--------
		// Choose  randomly the Reason for In eligibility-- YES or NO or No response


		WebElement elementToScrollTo1 = getDriver().findElement(By.xpath("//h3[.=' Indicate below the reason why you are ineligible to return ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='first_academic_related_radio']"));
		int Count = radioButtons.size();
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		String selectedOption1 = radioButtons.get(randomIndex).getAttribute("value");
		Thread.sleep(500);
		// Click the randomly selected radio button
		radioButtons.get(randomIndex).click();
		Thread.sleep(500);
		if(selectedOption1.contains("Y"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 105, "Academic related", "Y");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Academic related   :" + "Yes");
		}
		if(selectedOption1.contains("N"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 105, "Academic related", "N");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Academic related   :" + "No");
		}
		if(selectedOption1.contains("NA"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 105, "Academic related", "NA");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Academic related   :" + "No response");
		}




		// Student Conduct related--------
		// Choose  randomly the Reason for In eligibility-- YES or NO or No response
		WebElement elementToScrollToStdConduct = getDriver().findElement(By.xpath("//h3[.=' Student conduct ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToStdConduct);
		List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='firststudent_conduct_radio']"));
		int Count1 = radioButtons1.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(radioButtons1.size());
		String selectedOption11 = radioButtons1.get(randomIndex1).getAttribute("value");
		Thread.sleep(500);
		// Click the randomly selected radio button
		radioButtons1.get(randomIndex1).click();
		Thread.sleep(500);
		if(selectedOption11.contains("Y"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 106, "Student conduct", "Y");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Student conduct :" + "Yes");
		}
		if(selectedOption11.contains("N"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 106, "Student conduct", "N");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Student conduct :" + "No");
		}
		if(selectedOption11.contains("NA"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 106, "Student conduct", "NA");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Student conduct :" + "No response");
		}




		// Other related--------
		// Choose  randomly the Reason for In eligibility-- YES or NO or No response
		WebElement elementToScrollToOther1 = getDriver().findElement(By.xpath("//h3[.=' Other ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToOther1);
		List<WebElement> radioButtons11 = getDriver().findElements(By.xpath("//input[@name='firstother_reason_radio']"));
		int Count11 = radioButtons11.size();
		Random random11 = new Random();
		int randomIndex11 = random11.nextInt(radioButtons11.size());
		String selectedOption111 = radioButtons11.get(randomIndex11).getAttribute("value");
		Thread.sleep(500);
		// Click the randomly selected radio button
		radioButtons11.get(randomIndex11).click();
		Thread.sleep(500);


		if(selectedOption111.contains("Y"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 107, "Other", "Y");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Other: " + "Yes");
		}
		if(selectedOption111.contains("N"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 107, "Other", "Y");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Other: " + "No");
		}
		if(selectedOption111.contains("NA"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 107, "Other", "NA");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Other : " + "No response");
		}




		// Explanation For 1st Ineligiblity
		WebElement elementToScrollTo11 = findElement("Explaination1stIN_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);	
		type("Explaination1stIN_ID","Test ineligible to return to the college/university listed ");


		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 108, "Please explain why you are ineligible to return to the college/university listed", "Test ineligible to return to the college/university listed ");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


		Thread.sleep(1000);		// Additional Ineligible Coll
		WebElement elementToScrollTo2nd = findElement("AdditionalIneligibleIN_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2nd);	
		type("AdditionalIneligibleIN_ID","Test Second Ineligible college");
		Thread.sleep(1000);	




		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 109, "Additional college/university for which you are ineligible to return, if applicable:", "Test Second Ineligible college");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




		// Reason why you are ineligible to return	
		WebElement elementToScrollTo2 = getDriver().findElement(By.xpath("(//h3[.=' Indicate below the reason why you are ineligible to return '])[2]"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		// Academics related -------
		// Choose  randomly the Reason for In eligibility-- YES or NO or No response
		WebElement elementToScrollRD1 = getDriver().findElement(By.xpath("(//h3[.=' Academic related '])[2]"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollRD1);
		List<WebElement> radioButtons111 = getDriver().findElements(By.xpath("//input[@name='second_academic_related_radio']"));
		int Count111 = radioButtons111.size();
		Random random111 = new Random();
		int randomIndex111 = random111.nextInt(radioButtons111.size());
		String selectedOption1111 = radioButtons111.get(randomIndex111).getAttribute("value");
		Thread.sleep(500);
		// Click the randomly selected radio button
		radioButtons111.get(randomIndex111).click();
		Thread.sleep(500);
		if(selectedOption1111.contains("Y"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 110, "Academic related", "Y");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Academic related 2: " + "Yes");
		}
		if(selectedOption1111.contains("N"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 110, "Academic related", "N");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Academic related 2: " + "No");
		}
		if(selectedOption1111.contains("NA"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 110, "Academic related", "NA");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Academic related 2: " + "No response");
		}
		// Student conduct related -------
		// Choose  randomly the Reason for In eligibility-- YES or NO or No response
		WebElement elementToScrollRD2 = getDriver().findElement(By.xpath("(//h3[.=' Student conduct '])[2]"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollRD2);
		List<WebElement> radioButtons1111 = getDriver().findElements(By.xpath("//input[@name='secondstudent_conduct_radio']"));
		int Count1111 = radioButtons1111.size();
		Random random1111 = new Random();
		int randomIndex1111 = random1111.nextInt(radioButtons1111.size());
		String selectedOption11111 = radioButtons1111.get(randomIndex1111).getAttribute("value");
		Thread.sleep(500);
		// Click the randomly selected radio button
		radioButtons1111.get(randomIndex1111).click();
		Thread.sleep(500);
		if(selectedOption11111.contains("Y"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 111, "Student conduct", "Y");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Student conduct 2: " + "Yes");
		}
		if(selectedOption11111.contains("N"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 111, "Student conduct", "N");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Student conduct 2: " + "No");
		}
		if(selectedOption11111.contains("NA"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 111, "Student conduct", "NA");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Student conduct 2: " + "No response");
		}
		// Other related -------
		// Choose  randomly the Reason for In eligibility-- YES or NO or No response
		WebElement elementToScrollRD3 = getDriver().findElement(By.xpath("(//h3[.=' Other '])[2]"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollRD3);
		List<WebElement> radioButtons11111 = getDriver().findElements(By.xpath("//input[@name='secondother_reason_radio']"));
		int Count11111 = radioButtons11111.size();
		Random random11111 = new Random();
		int randomIndex11111 = random11111.nextInt(radioButtons11111.size());
		String selectedOption111111 = radioButtons11111.get(randomIndex11111).getAttribute("value");
		Thread.sleep(500);
		// Click the randomly selected radio button
		radioButtons11111.get(randomIndex11111).click();
		Thread.sleep(500);
		if(selectedOption111111.contains("Y"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 112, "Other", "Y");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Other 2: " + "Yes");
		}
		if(selectedOption111111.contains("N"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 112, "Other", "N");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Other 2: " + "No");
		}
		if(selectedOption111111.contains("NA"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 112, "Other", "NA");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Other 2: " + "No response");
		}

		WebElement elementToScrollTo2nd1 = getDriver().findElement(By.xpath("(//h3[.=' Please explain why you are ineligible to return to the college/university listed '])[2]"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2nd1);	
		type("Explaination2ndIN_ID","Test Additional ineligible to return to the college/university listed ");


		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 113, "Please explain why you are ineligible to return to the college/university listed", "Test Additional ineligible to return to the college/university listed ");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




		Thread.sleep(1000);
	}

	public void Random_CollegeUniversities(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		WebElement elementToScrollTo2 = getDriver().findElement(By.xpath("//h3[.=' Have you previously attended or are you currently attending a college or university? ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		log.debug("Have you previously attended or are you currently attending a college or university?" );
		Thread.sleep(2000);
		List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='request_transcripts_radio']"));
		int Count = radioButtons.size();
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
		Thread.sleep(2000);
		radioButtons.get(randomIndex).click();
		Thread.sleep(1000);
		if(selectedOption.contains("attended/attending college"))
		{
			PreviouslyAttendedOrAttending.set("Yes");
			log.debug("Selected option:  " + PreviouslyAttendedOrAttending.get());

			// If the student is a Past Graduate needs to enter the semester credits
			try
			{
				if(findElement("SemesterCredits_XPATH").isDisplayed())
				{


					WebElement elementToScrollTo = findElement("SemesterCredits_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
					type("SemesterCredits_XPATH", "5");
					WebElement elementToScrollTo1 = findElement("TransferCreditGuide_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
					click("TransferCreditGuide_XPATH");
					Thread.sleep(2000);
					try
					{
						findElement("ValidateTransferCreditGuide_XPATH");
						log.debug("Transfer credits to ASU section is displayed when clicked on Transfer Credit Guide link!");
						findElement("BackBtnTransferCreditGuide_XPATH").click();
						Thread.sleep(1000);
					}
					catch(Exception e)
					{
						log.debug("Transfer credits to ASU section is not displayed when clicked on Transfer Credit Guide link!");

					}
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 103, "Transfer credits to ASU", "5");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				}
			}
			catch(Exception e) {}

			// Select an Institution
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey.get(),colNumValue.get(),"validData", 95, " Past colleges/universities ","");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			String 	selectedStateText = "";
			String 	selectedCityText = "";
			String statecode="";
			WebElement elementToScrollTo = findElement("InstitutionCountryDD_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			// Add a Institution Country
			click("InstitutionCountryDD_ID");
			Thread.sleep(2000);
			List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options = options.size();
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options.size());
			WebElement randomOption = options.get(randomIndex1);
			Thread.sleep(1500);
			randomOption.click();
			Thread.sleep(1500);
			// Get the text of the chosen random Country
			String 	selectedCountryText	=	findElement("InstitutionCountryDD_ID").getText();
			log.debug("Selected Institution Country: " + selectedCountryText);

			String countryCode= findCountryCode(selectedCountryText);


			WebElement elementToScrollTo1 = getDriver().findElement(By.id("institute_state"));
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			WebElement stateElement = getDriver().findElement(By.id("institute_state"));
			if (stateElement.getTagName().equals("div")) 
			{
				// It's a dropdown
				log.debug("State is a dropdown.");
				// Add a Institution State
				click("InstitutionStateDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options1 = options1.size();
				Random random11 = new Random();
				int randomIndex11 = random11.nextInt(options1.size());
				WebElement randomOption1 = options1.get(randomIndex11);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				// Get the text of the chosen random Country
				selectedStateText	=	findElement("InstitutionStateDD_XPATH").getText();
				log.debug("Selected Institution State: " + selectedStateText);


				statecode= findStateCode(selectedCountryText,selectedStateText);
			}
			else if (stateElement.getTagName().equals("input")) 
			{
				// It's a textfield
				log.debug("State is a textfield.");
				Thread.sleep(1000);
				type("InstutStateTextfield_XPATH","Test State");
				statecode = "Test State";
			}
			else 
			{
				// It's neither a dropdown nor a textfield
				log.debug("State is neither a dropdown nor a textfield.");
			}




			// Validate City
			WebElement cityElement = getDriver().findElement(By.id("institute_city")); 
			if (cityElement.getTagName().equals("div")) 
			{
				// It's a dropdown
				log.debug("City is a dropdown.");
				// Add a Institution City
				click("InstitutionCityDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options11 = options11.size();
				Random random111 = new Random();
				int randomIndex111 = random111.nextInt(options11.size());
				WebElement randomOption11 = options11.get(randomIndex111);
				Thread.sleep(1000);
				randomOption11.click();
				Thread.sleep(1000);
				// Get the text of the chosen random Country
				selectedCityText	=	findElement("InstitutionCityDD_XPATH").getText();
				log.debug("Selected Institution City: " + selectedCityText);
			}
			else if (cityElement.getTagName().equals("input")) 
			{
				// It's a textfield
				log.debug("State is a textfield.");
				Thread.sleep(1000);
				type("InstutCityTextfield_XPATH","Test City");
				selectedCityText = "Test City";
			}
			else 
			{
				// It's neither a dropdown nor a textfield
				log.debug("City is neither a dropdown nor a textfield.");
			}




			String location = selectedCityText+", "+statecode+", "+countryCode;
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey.get(),colNumValue.get(),"validData", 98, "Location",location);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");






			WebElement elementToScrollTo111 = findElement("SelectInstutDD_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
			// Add a Institution Country
			click("SelectInstutDD_ID");
			Thread.sleep(1000);
			List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex11);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			// Get the text of the chosen random Country
			String 	selectedInstitutionText	=	findElement("SelectInstutDD_ID").getText();
			log.debug("Selected Institution : " + selectedInstitutionText);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey.get(),colNumValue.get(),"validData", 96, "School name", selectedInstitutionText);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




			log.debug("Selected Institution : " + selectedInstitutionText);
			WebElement elementToScrollTo1111 = findElement("SelectInstutDD_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
			if(selectedInstitutionText.contains("Not listed"))
			{
				WebElement elementToScrollToInstutName = findElement("InstitutionName_ID");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToInstutName);
				Thread.sleep(1000);
				type("InstitutionName_ID","Test Institution");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colNumKey.get(),colNumValue.get(),"validData", 96, "School name", "Test Institution");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				Thread.sleep(1000);
			}

			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey.get(),colNumValue.get(),"validData", 97, "Name on transcript", "Test FN Test LN");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


			WebElement elementToScrollToDegree = findElement("DegreeAwardedDD_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDegree);
			click("DegreeAwardedDD_ID");
			Thread.sleep(1000);
			List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options11 = options11.size();
			Random random111 = new Random();
			int randomIndex111 = random111.nextInt(options11.size());
			WebElement randomOption11 = options11.get(randomIndex111);
			Thread.sleep(1000);
			randomOption11.click();
			Thread.sleep(1000);
			// Get the text of the chosen random Country
			String 	selectedDegreeAwarded	=	findElement("DegreeAwardedDD_ID").getText();
			log.debug("Selected Institution : " + selectedDegreeAwarded);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey.get(),colNumValue.get(),"validData", 99, "Degree", selectedDegreeAwarded);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			log.debug("Selected Institution : " + selectedDegreeAwarded);
			if(!selectedDegreeAwarded.contains("No Degree Awarded"))
			{
				WebElement elementToScrollToDegree1 = findElement("DegreeConcTextfield_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDegree1);
				type("DegreeConcTextfield_ID","Degree_Concentration");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colNumKey.get(),colNumValue.get(),"validData", 100, "Degree concentration", "Degree_Concentration");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				Thread.sleep(2000);

			}
			// Add First attended and Last attended
			// Choose Random Month for first attended date
			WebElement elementToScrollToInst = findElement("InstDateFirstMonth_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToInst);
			click("InstDateFirstMonth_ID");
			Thread.sleep(1000);
			List<WebElement> options111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options111 = options111.size();
			Random random1111 = new Random();
			int randomIndex1111 = random1111.nextInt(options111.size());
			WebElement randomOption111 = options111.get(randomIndex1111);
			Thread.sleep(1000);
			randomOption111.click();
			Thread.sleep(1000);
			String selectedMonth = findElement("InstDateFirstMonth_ID").getText();
			log.debug("Selected Month for first attended date: " + selectedMonth);


			// Choose Random Year for first attended date
			WebElement elementToScrollToFirstYear = findElement("InstDateFirstYear_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToFirstYear);
			click("InstDateFirstYear_ID");
			Thread.sleep(1000);
			List<WebElement> options1111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1111 = options1111.size();
			Random random11111 = new Random();
			int randomIndex11111 = random11111.nextInt(options1111.size());
			WebElement randomOption1111 = options1111.get(randomIndex11111);
			Thread.sleep(1000);
			randomOption1111.click();
			Thread.sleep(1000);
			String selectedYear = findElement("InstDateFirstYear_ID").getText();
			log.debug("Selected Year for first attended date: " + selectedYear);


			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 101, "Date first attended", selectedMonth+", "+selectedYear);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");






			// Choose Random Year for last attended date ensuring it's greater than the first attended year
			WebElement elementToScrollToLastYear = findElement("InstDateLastYear_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToLastYear);
			click("InstDateLastYear_ID");
			Thread.sleep(1000);
			Random random111111 = new Random();
			// Choose Random Year for last attended date ensuring it's greater than or equal to the first attended year
			int firstYear = Integer.parseInt(selectedYear);
			List<WebElement> options11111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options11111 = options11111.size();
			int randomIndex111111 = random111111.nextInt(options11111.size());
			// Calculate the selected year between firstYear and 2023
			int selectedYear1 = firstYear + randomIndex111111;
			log.debug(selectedYear1+"Selected last year");

			if (selectedYear1 <=firstYear) 
			{
				selectedYear1 = firstYear; // Set the minimum allowed year to firstYear
			}
			else if (selectedYear1==firstYear) 
			{
				selectedYear1 = firstYear+randomIndex111111; // Set the minimum allowed year to firstYear
			}
			else if (selectedYear1 > 2023) 
			{
				selectedYear1 = 2023; // Set the maximum allowed year to 2023
			}
			String selectedYear1Text;
			selectedYear1Text = String.valueOf(selectedYear1);


			List<WebElement> yearOptions = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));




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
			log.debug("Selected Year for last attended date: " + SelectedLastYear);


			// Choose Random Month for last attended date
			Thread.sleep(1000);
			WebElement elementToScroll = findElement("InstDateLastMonth_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
			click("InstDateLastMonth_ID");
			Thread.sleep(1000);
			List<WebElement> options111111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options111111 = options111111.size();
			Random random1111111 = new Random();
			int randomIndex1111111 = random1111111.nextInt(options111111.size());
			WebElement randomOption11111 = options111111.get(randomIndex1111111);
			Thread.sleep(1000);
			randomOption11111.click();
			Thread.sleep(1000);
			String selectedMonth1 = findElement("InstDateLastMonth_ID").getText();
			System.out.println("Selected Month for last attended date: " + selectedMonth1);
			log.debug("Selected Month for last attended date: " + selectedMonth1);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 102, "Date last attended", selectedMonth1+", "+SelectedLastYear);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

			// Save the School
			WebElement elementToScrollToSaveInst = findElement("SaveInstitBtn_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToSaveInst);
			Thread.sleep(1000);
			click("SaveInstitBtn_XPATH");
			Thread.sleep(1000);



			// Previous College Eligibility    - Randomly select Yes or No

			WebElement elementToScrollTo11 = getDriver().findElement(By.xpath("//h3[.=' Previous college eligibility ']"));
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
			log.debug("Are you eligible to return to each of the colleges or universities you have attended in the last seven years? If you have not attended college, please answer yes.");
			Thread.sleep(2000);
			List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='eiligibility_to_college_radio']"));
			int Count1 = radioButtons1.size();
			Random random11111111 = new Random();
			int randomIndex11111111 = random11111111.nextInt(radioButtons1.size());
			String selectedOption1 = radioButtons1.get(randomIndex11111111).getAttribute("value");
			Thread.sleep(2000);
			radioButtons1.get(randomIndex11111111).click();
			Thread.sleep(1000);
			if(selectedOption1.contains("Y"))
			{
				PreviousCollegeEligibility.set("Yes");
				log.debug("Selected option:  " + PreviousCollegeEligibility.get());

			}
			if(selectedOption1.contains("N"))
			{
				PreviousCollegeEligibility.set("No");
				log.debug("Selected option:  " + PreviousCollegeEligibility.get());
				WebElement elementToScrollTo1st = getDriver().findElement(By.xpath("//h3[.=' List the most recent college/university for which you are ineligible to return first ']"));
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1st);
				type("FirstIneligibleIN_ID","Test First Ineligible college");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData", 104, "List the most recent college/university for which you are ineligible to return first", "Test First Ineligible college");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


				// Academic related--------
				// Choose  randomly the Reason for In eligibility-- YES or NO or No response


				WebElement elementToScrollTo11111 = getDriver().findElement(By.xpath("//h3[.=' Indicate below the reason why you are ineligible to return ']"));
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11111);
				List<WebElement> radioButtons11 = getDriver().findElements(By.xpath("//input[@name='first_academic_related_radio']"));
				int Count11 = radioButtons11.size();
				Random random111111111 = new Random();
				int randomIndex111111111 = random111111111.nextInt(radioButtons11.size());
				String selectedOption11 = radioButtons11.get(randomIndex111111111).getAttribute("value");
				Thread.sleep(500);
				// Click the randomly selected radio button
				radioButtons11.get(randomIndex111111111).click();
				Thread.sleep(500);
				if(selectedOption11.contains("Y"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 105, "Academic related", "Y");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Academic related   :" + "Yes");
				}
				if(selectedOption11.contains("N"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 105, "Academic related", "N");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Academic related   :" + "No");
				}
				if(selectedOption11.contains("NA"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 105, "Academic related", "NA");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Academic related   :" + "No response");
				}




				// Student Conduct related--------
				// Choose  randomly the Reason for In eligibility-- YES or NO or No response
				WebElement elementToScrollToStdConduct = getDriver().findElement(By.xpath("//h3[.=' Student conduct ']"));
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToStdConduct);
				List<WebElement> radioButtons111 = getDriver().findElements(By.xpath("//input[@name='firststudent_conduct_radio']"));
				int Count111 = radioButtons111.size();
				Random random1111111111 = new Random();
				int randomIndex1111111111 = random1111111111.nextInt(radioButtons111.size());
				String selectedOption111 = radioButtons111.get(randomIndex1111111111).getAttribute("value");
				Thread.sleep(500);
				// Click the randomly selected radio button
				radioButtons111.get(randomIndex1111111111).click();
				Thread.sleep(500);
				if(selectedOption111.contains("Y"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 106, "Student conduct", "Y");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Student conduct :" + "Yes");
				}
				if(selectedOption111.contains("N"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 106, "Student conduct", "N");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Student conduct :" + "No");
				}
				if(selectedOption111.contains("NA"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 106, "Student conduct", "NA");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Student conduct :" + "No response");
				}




				// Other related--------
				// Choose  randomly the Reason for In eligibility-- YES or NO or No response
				WebElement elementToScrollToOther1 = getDriver().findElement(By.xpath("//h3[.=' Other ']"));
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToOther1);
				List<WebElement> radioButtons1111 = getDriver().findElements(By.xpath("//input[@name='firstother_reason_radio']"));
				int Count1111 = radioButtons1111.size();
				Random random11111111111 = new Random();
				int randomIndex11111111111 = random11111111111.nextInt(radioButtons1111.size());
				String selectedOption1111 = radioButtons1111.get(randomIndex11111111111).getAttribute("value");
				Thread.sleep(500);
				// Click the randomly selected radio button
				radioButtons1111.get(randomIndex11111111111).click();
				Thread.sleep(500);


				if(selectedOption1111.contains("Y"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 107, "Other", "Y");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Other: " + "Yes");
				}
				if(selectedOption1111.contains("N"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 107, "Other", "Y");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Other: " + "No");
				}
				if(selectedOption1111.contains("NA"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 107, "Other", "NA");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Other : " + "No response");
				}




				// Explanation For 1st Ineligiblity
				WebElement elementToScrollTo111111 = findElement("Explaination1stIN_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111111);	
				type("Explaination1stIN_ID","Test ineligible to return to the college/university listed ");


				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData", 108, "Please explain why you are ineligible to return to the college/university listed", "Test ineligible to return to the college/university listed ");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


				Thread.sleep(1000);		// Additional Ineligible Coll
				WebElement elementToScrollTo2nd = findElement("AdditionalIneligibleIN_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2nd);	
				type("AdditionalIneligibleIN_ID","Test Second Ineligible college");
				Thread.sleep(1000);	


				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData", 109, "Additional college/university for which you are ineligible to return, if applicable:", "Test Second Ineligible college");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

				// Reason why you are ineligible to return	
				WebElement elementToScrollTo21 = getDriver().findElement(By.xpath("(//h3[.=' Indicate below the reason why you are ineligible to return '])[2]"));
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
				// Academics related -------
				// Choose  randomly the Reason for In eligibility-- YES or NO or No response
				WebElement elementToScrollRD1 = getDriver().findElement(By.xpath("(//h3[.=' Academic related '])[2]"));
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollRD1);
				List<WebElement> radioButtons11112 = getDriver().findElements(By.xpath("//input[@name='second_academic_related_radio']"));
				int Count11111 = radioButtons11112.size();
				Random random11112 = new Random();
				int randomIndex11112 = random11112.nextInt(radioButtons11112.size());
				String selectedOption11111 = radioButtons11112.get(randomIndex11112).getAttribute("value");
				Thread.sleep(500);
				// Click the randomly selected radio button
				radioButtons11112.get(randomIndex11112).click();
				Thread.sleep(500);
				if(selectedOption11111.contains("Y"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 110, "Academic related", "Y");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Academic related 2: " + "Yes");
				}
				if(selectedOption11111.contains("N"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 110, "Academic related", "N");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Academic related 2: " + "No");
				}
				if(selectedOption11111.contains("NA"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 110, "Academic related", "NA");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Academic related 2: " + "No response");
				}
				// Student conduct related -------
				// Choose  randomly the Reason for In eligibility-- YES or NO or No response
				WebElement elementToScrollRD2 = getDriver().findElement(By.xpath("(//h3[.=' Student conduct '])[2]"));
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollRD2);
				List<WebElement> radioButtons11111 = getDriver().findElements(By.xpath("//input[@name='secondstudent_conduct_radio']"));
				int Count111112 = radioButtons11111.size();
				Random random111113 = new Random();
				int randomIndex111112 = random111113.nextInt(radioButtons11111.size());
				String selectedOption111111 = radioButtons11111.get(randomIndex111112).getAttribute("value");
				Thread.sleep(500);
				// Click the randomly selected radio button
				radioButtons11111.get(randomIndex111112).click();
				Thread.sleep(500);
				if(selectedOption111111.contains("Y"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 111, "Student conduct", "Y");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Student conduct 2: " + "Yes");
				}
				if(selectedOption111111.contains("N"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 111, "Student conduct", "N");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Student conduct 2: " + "No");
				}
				if(selectedOption111111.contains("NA"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 111, "Student conduct", "NA");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Student conduct 2: " + "No response");
				}
				// Other related -------
				// Choose  randomly the Reason for In eligibility-- YES or NO or No response
				WebElement elementToScrollRD3 = getDriver().findElement(By.xpath("(//h3[.=' Other '])[2]"));
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollRD3);
				List<WebElement> radioButtons111111 = getDriver().findElements(By.xpath("//input[@name='secondother_reason_radio']"));
				int Count111111 = radioButtons111111.size();
				Random random1111112 = new Random();
				int randomIndex1111112 = random1111112.nextInt(radioButtons111111.size());
				String selectedOption1111111 = radioButtons111111.get(randomIndex1111112).getAttribute("value");
				Thread.sleep(500);
				// Click the randomly selected radio button
				radioButtons111111.get(randomIndex1111112).click();
				Thread.sleep(500);
				if(selectedOption1111111.contains("Y"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 112, "Other", "Y");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Other 2: " + "Yes");
				}
				if(selectedOption1111111.contains("N"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 112, "Other", "N");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Other 2: " + "No");
				}
				if(selectedOption1111111.contains("NA"))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 112, "Other", "NA");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					log.debug("Other 2: " + "No response");
				}

				WebElement elementToScrollTo2nd1 = getDriver().findElement(By.xpath("(//h3[.=' Please explain why you are ineligible to return to the college/university listed '])[2]"));
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2nd1);	
				type("Explaination2ndIN_ID","Test Additional ineligible to return to the college/university listed ");


				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData", 113, "Please explain why you are ineligible to return to the college/university listed", "Test Additional ineligible to return to the college/university listed ");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

				Thread.sleep(1000);

			}



		}


		if(selectedOption.contains("never attended"))
		{
			PreviouslyAttendedOrAttending.set("No");
			log.debug("Selected option:  " + PreviouslyAttendedOrAttending.get());
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 103, "Transfer credits to ASU", "0");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}

	}




	public void TranscriptPolicy() throws InterruptedException
	{
		WebElement elementToScroll = getDriver().findElement(By.xpath("//h3[.=' Transcript policy ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
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
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
	}


	public void SaveThePage() throws InterruptedException
	{
		// Clicks on Save button
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//button[.=' Save ']")).click();
		Thread.sleep(3000);
	}




}








