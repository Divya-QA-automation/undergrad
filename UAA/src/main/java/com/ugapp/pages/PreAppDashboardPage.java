package com.ugapp.pages;
import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v119.network.Network;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.ugapp.base.Page;

public class PreAppDashboardPage extends Page
{
	public JavascriptExecutor js = (JavascriptExecutor) getDriver();
	static ThreadLocal<String> validMonth=new ThreadLocal<>();
	static ThreadLocal<String> validDay=new ThreadLocal<>();
	static ThreadLocal<String> MobileNoCode=new ThreadLocal<>();
	static ThreadLocal<String> PhoneNoCode=new ThreadLocal<>();
	private static final PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

	public void validatePreAppPage() throws Throwable
	{
		waitTillProgressbarDisappears();
		//validate the pre app page with url
		String dashboard=getDriver().getCurrentUrl();
		if(dashboard.contains("https://apply-qa.apps.asu.edu/dashboard"))
		{
			log.debug("Redirected to Pre-App Submission page successfully!");
		}
		else
			log.debug("Failed to redirect to Pre-App Submission page");
	}


	public void userDetails(String firstName , String preferredfirstname , String middlename , String lastName) throws Throwable
	{
		Thread.sleep(3000);
		type("firstName_XPATH",firstName);
		type("preferredFirstName_XPATH",preferredfirstname);
		type("middleName_XPATH",middlename);
		type("lastName_XPATH",lastName);
	}


	public void validateUserDetails(String firstName , String preferredfirstname , String middlename , String lastName) throws Throwable
	{
		//regex that checks numbers , special char , space at end or start
		String regex = "^(?!.*\\\\s$)(?!^\\\\s)(?!.*-$)[0-9A-Za-z!@#$%^&*()_+=`~{}\\\\[\\\\]:;\\\"'<>,.?\\\\\\\\/| ]+$";


		//Firstname validation
		boolean isFirstNameValid = firstName.matches(regex);
		log.debug("isFirstNameValid :"+isFirstNameValid);
		if(isFirstNameValid)
		{
			try {
				String errorFirstName = findElement("errorFirstName_XPATH").getText();
				Assert.assertEquals(errorFirstName, "The first name can only contain letters, spaces and hyphens (-).");
			}catch(Exception e) 
			{
				if(firstName.length()>25)
				{
					String errorFirstName25 = findElement("errorFirstName25_XPATH").getText();
					Assert.assertEquals(errorFirstName25, "The first name should not be more than 25 characters.");
				}


			}
		}
		else
			log.debug("Firstname is not valid");




		//preferred First Name validation
		boolean isPreferredFirstNameValid = preferredfirstname.matches(regex);
		log.debug("isPreferredFirstNameValid :"+isPreferredFirstNameValid);
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
			log.debug("preferredfirstname is not valid");




		//middlename
		boolean ismiddleNameValid = middlename.matches(regex);
		log.debug("ismiddleNameValid :"+ismiddleNameValid);
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
			log.debug("middlename is not valid");




		//lastname
		boolean isLastNameValid = lastName.matches(regex);
		log.debug("isLastNameValid :"+isLastNameValid);
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
					String errorLastName30 = findElement("errorLastName30_XPATH").getText();
					Assert.assertEquals(errorLastName30, "The last name should not be more than 30 characters.");
				}
			}
		}
		else
			log.debug("lastName is not valid");




		//button enability
		boolean startnewAppButton = findElement("startNewApplicationButton_XPATH").isEnabled();
		if(startnewAppButton==false)
			getDriver().navigate().refresh();
		Thread.sleep(2000);
	}


	public void validuser(String colKey,String colValue) throws Exception
	{
		Thread.sleep(2000);
		WebElement ToScroll = getDriver().findElement(By.xpath("//input[@id='first-name']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
		Thread.sleep(1000);
		type("firstName_XPATH","Test FN");
		type("preferredFirstName_XPATH","Automation PFN");
		WebElement ToScroll1 = getDriver().findElement(By.xpath("//input[@id='middle-name']"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll1);
		type("middleName_XPATH","Automation MN");
		type("lastName_XPATH","Test LN");
		waitUntilExcelFileIsNotEmpty(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 1, "Legal name", "Test FN Automation MN Test LN");
		setExcelData(colKey,colValue,"validData", 2, "Preferred first name", "Automation PFN");
		saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}


	public  void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,400)");
	}


	public  void checkOptionalTag()
	{
		//preferred firstname Optional tag
		try {
			findElement("preferredOptional_XPATH");
			log.debug("Optional tag is  present for Preferred first name!");
		}
		catch(Exception e) {
			log.debug("Optional tag is not present for Preferred first name!");
		}


		//Middlename Optional tag
		try {
			findElement("middleOptional_XPATH");
			log.debug("Optional tag is present for middle name!");


		}
		catch(Exception e) {
			log.debug("Optional tag is not present for middle name!");
		}


		//suffix Optional tag
		try {
			findElement("suffixOptional_XPATH");
			log.debug("Optional tag is present for suffix dropdown!");
		}
		catch(Exception e) {
			log.debug("Optional tag is not present for suffix dropdown!");
		}

	}


	public  void verifySuffixDropdown() throws Throwable
	{
		//click on dropdown
		WebElement ToScroll = findElement("suffixDropdown_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
		findElement("suffixDropdown_XPATH").click();
		Thread.sleep(1500);


		//get the number of elements in the dropdowm and stor them in an arraylist
		List<WebElement> suffix = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li[contains(text(),'')]"));
		ArrayList<String> suffixDropdownFields = new ArrayList<String>();


		int i=1;
		for(WebElement suff:suffix)
		{
			String suffixFields=getDriver().findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li[contains(text(),'')])["+i+"]")).getText();
			suffixDropdownFields.add(suffixFields);
			i++;
		}


		//validate the elements present in the dropdown
		log.debug("suffixDropdownFields :"+suffixDropdownFields);
		if(suffixDropdownFields.contains("II") && suffixDropdownFields.contains("III") && suffixDropdownFields.contains("IV") && suffixDropdownFields.contains("Jr.") && suffixDropdownFields.contains("Sr."))
			log.debug("The Suffix dropdown contains all the expected data!");
		else
			log.debug("The Suffix Dropdown does not contain all the expected data");


	}


	public  void verifySuffixClear() throws Throwable
	{
		//random click on any of the elements in the suffix dropdown 
		List<WebElement> suffix = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		ArrayList<Integer> ransuf = getRandomNumber(1, suffix.size(), 1);
		for(int r:ransuf)
		{
			getDriver().findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+r+"]")).click();
		}

		//click on the clear button
		click("clearSuffix_XPATH");
		try
		{
			List<WebElement> error = getDriver().findElements(By.xpath("//li[contains(text(),' This is a required field')]"));
			log.debug("The error message is displayed when cleared the Suffix field!");
		}
		catch(Exception e) {
			log.debug("The error message is not displayed when cleared the Suffix field");
		}
	}


	public  void verifyMonths() throws Throwable
	{	
		//click on the month dropdown
		click("month_XPATH");

		//get the number of elements present in the moinths dropdown
		List<WebElement> months = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));	
		log.debug("months.size :"+months.size());
		if(months.size()==12)
		{
			log.debug("Month dropdown has all twelve months!");
		}
		else
		{
			log.debug("Month dropdown does not have all twelve months!");
		}
	}


	public  void verifyDaysPresent() throws Throwable
	{
		//number of months
		List<WebElement> months = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));


		//random number to choose from months
		ArrayList<Integer> ran = getRandomNumber(1, months.size(), 1);


		//get the randomnly selected month
		String monthSelected="";
		for(int r:ran)
		{
			monthSelected = getDriver().findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li[contains(text(),'')])[" + r + "]")).getText();
			log.debug("monthSelected :"+monthSelected);
			getDriver().findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+r+"]")).click();
		}


		//day dropdown
		click("day_XPATH");


		//number of days
		List<WebElement> days = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		ArrayList<Integer> randay = getRandomNumber(1, days.size(), 1);


		if(monthSelected.equalsIgnoreCase("January") || monthSelected.equalsIgnoreCase("March") || monthSelected.equalsIgnoreCase("May") || monthSelected.equalsIgnoreCase("July") || monthSelected.equalsIgnoreCase("August") || monthSelected.equalsIgnoreCase("October") || monthSelected.equalsIgnoreCase("December"))
		{
			if(days.size()==31)
			{
				log.debug("Day dropdown works as expected!");
			}
			else
				log.debug("Day dropwdown is not working as expected");
		}
		else if(monthSelected.equalsIgnoreCase("April") || monthSelected.equalsIgnoreCase("June") || monthSelected.equalsIgnoreCase("September") || monthSelected.equalsIgnoreCase("November"))	
		{
			if(days.size()==30)
				log.debug("Day dropdown works as expected!");
			else
				log.debug("Day dropwdown is not working as expected");
		}
		else if(monthSelected.equalsIgnoreCase("February"))
		{
			if(days.size()==29)
				log.debug("Day dropdown works as expected!");
			else
				log.debug("Day dropwdown is not working as expected");
		}
		for(int r:randay)
		{
			getDriver().findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li[contains(text(),'')])[" + r + "]")).click();
		}
	}


	public  void verifyYearsPresent() throws Throwable
	{
		//click year dropdown
		click("year_XPATH");




		//number of years
		List<WebElement> year = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		ArrayList<Integer> ranyear = getRandomNumber(1, year.size(), 1);
		if(year.size()==100)
			log.debug("year dropdown has 100 values as expected!");
		else
			log.debug("year dropdown does not have 100 values!");




		//close the dropdown
		for(int r:ranyear)
		{
			getDriver().findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li[contains(text(),'')])[" + r + "]")).click();
		}
	}


	public  void verifyClearButton() throws InterruptedException
	{
		//verify clear button
		Thread.sleep(1000);
		click("clearmonth_XPATH");
		click("clearDay_XPATH");
		click("clearYear_XPATH");


	}


	public  void validateErrorMessage()
	{


		//validate the error message present after clearing the borthday fields
		List<WebElement> error = getDriver().findElements(By.xpath("//li[contains(text(),' This is a required field')]"));


		if(error.size()==3)
			log.debug("The error message is displayed when cleared the birthday fields!");
		else
			log.debug("The error message is not displayed when cleared the birthday fields");
	}


	public  void BirthdayAge_Greater24(String colKey,String colValue) throws Throwable
	{
		WebElement ToScroll = findElement("year_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
		WebElement year=getDriver().findElement(By.xpath("//div[@id=\"create-application-birth-year\"]//input"));
		// Randomly select birthday year for Age greater than 24
		String yearForAgeGreaterThan24 = getYearForAgeGreaterThan(24);
		year.sendKeys(yearForAgeGreaterThan24);
		year.sendKeys(Keys.ENTER);
		System.out.println(yearForAgeGreaterThan24);
		// Randomly select a Month
		click("month_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex);
		Thread.sleep(500);
		randomOption.click();
		Thread.sleep(500);
		// Randomly select a Day
		click("day_XPATH");
		Thread.sleep(1000);
		List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1 = options1.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex1);
		Thread.sleep(500);
		randomOption1.click();
		Thread.sleep(500);
		String Month  = findElement("month_XPATH").getText();
		String Day  = findElement("day_XPATH").getText();
		String DOB = Month+" "+Day+", "+yearForAgeGreaterThan24;
		log.debug("Date of Birth :"+DOB);
		waitUntilExcelFileIsNotEmpty(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 3, "Date of birth",DOB );
		saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}
	public  void BirthdayAge_Btn18_24(String colKey,String colValue) throws Throwable
	{
		WebElement ToScroll = findElement("year_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
		WebElement year=getDriver().findElement(By.xpath("//div[@id=\"create-application-birth-year\"]//input"));
		// Randomly select birthday year for Age between 18 and 24
		String yearForAge18to24 = getYearForAgeRange(18, 24);
		year.sendKeys(yearForAge18to24);
		year.sendKeys(Keys.ENTER);
		System.out.println(yearForAge18to24);
		// Randomly select a Month
		click("month_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex);
		Thread.sleep(500);
		randomOption.click();
		Thread.sleep(500);
		// Randomly select a Day
		click("day_XPATH");
		Thread.sleep(1000);
		List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1 = options1.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex1);
		Thread.sleep(500);
		randomOption1.click();
		Thread.sleep(500);
		String Month  = findElement("month_XPATH").getText();
		String Day  = findElement("day_XPATH").getText();
		String DOB = Month+" "+Day+", "+yearForAge18to24;
		log.debug("Date of Birth :"+DOB);
		waitUntilExcelFileIsNotEmpty(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 3, "Date of birth",DOB);
		saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}
	public  void BirthdayAge_24(String colKey,String colValue) throws Throwable
	{
		WebElement ToScroll = findElement("year_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
		WebElement year=getDriver().findElement(By.xpath("//div[@id=\"create-application-birth-year\"]//input"));
		// Randomly select birthday year for Age = 24
		String yearForAge24 = getYearForAgeRange(24);
		year.sendKeys(yearForAge24);
		year.sendKeys(Keys.ENTER);
		System.out.println(yearForAge24);
		// Randomly select a Month
		click("month_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex);
		Thread.sleep(500);
		randomOption.click();
		Thread.sleep(500);
		// Randomly select a Day
		click("day_XPATH");
		Thread.sleep(1000);
		List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1 = options1.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex1);
		Thread.sleep(500);
		randomOption1.click();
		Thread.sleep(500);
		String Month  = findElement("month_XPATH").getText();
		String Day  = findElement("day_XPATH").getText();
		String DOB = Month+" "+Day+", "+yearForAge24;
		log.debug("Date of Birth :"+DOB);
		waitUntilExcelFileIsNotEmpty(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 3, "Date of birth",DOB );
		saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}
	public  void BirthdayAge_18(String colKey,String colValue) throws Throwable
	{
		WebElement ToScroll = findElement("year_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
		WebElement year=getDriver().findElement(By.xpath("//div[@id=\"create-application-birth-year\"]//input"));
		// Randomly select birthday year for Age = 18
		String yearForAge18 = getYearForAgeRange(18);
		year.sendKeys(yearForAge18);
		year.sendKeys(Keys.ENTER);
		// Randomly select a Month
		click("month_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex);
		Thread.sleep(500);
		randomOption.click();
		Thread.sleep(500);
		// Randomly select a Day
		click("day_XPATH");
		Thread.sleep(1000);
		List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1 = options1.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex1);
		Thread.sleep(500);
		randomOption1.click();
		Thread.sleep(500);
		String Month  = findElement("month_XPATH").getText();
		String Day  = findElement("day_XPATH").getText();
		String DOB = Month+" "+Day+", "+yearForAge18;
		log.debug("Date of Birth :"+DOB);
		waitUntilExcelFileIsNotEmpty(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 3, "Date of birth",DOB );
		saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}
	public  void BirthdayAge_Less18(String colKey,String colValue) throws Throwable
	{
		WebElement ToScroll = findElement("year_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
		WebElement year=getDriver().findElement(By.xpath("//div[@id=\"create-application-birth-year\"]//input"));
		// Randomly select birthday year for Age less than 18
		String yearForAgeLessThan18 = getYearForAgeLessThan(18);
		year.sendKeys(yearForAgeLessThan18);
		year.sendKeys(Keys.ENTER);
		// Randomly select a Month
		click("month_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex);
		Thread.sleep(500);
		randomOption.click();
		Thread.sleep(500);
		// Randomly select a Day
		click("day_XPATH");
		Thread.sleep(1000);
		List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1 = options1.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex1);
		Thread.sleep(500);
		randomOption1.click();
		Thread.sleep(500);
		String Month  = findElement("month_XPATH").getText();
		String Day  = findElement("day_XPATH").getText();
		String DOB = Month+" "+Day+", "+yearForAgeLessThan18;
		log.debug("Date of Birth :"+DOB);
		waitUntilExcelFileIsNotEmpty(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		Thread.sleep(5000);
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 3, "Date of birth",DOB);
		saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}
	// Method to get a random year for a specific age
	public  String getYearForAgeRange(int age) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int birthYear = currentYear - age;
		return Integer.toString(birthYear);
	}
	// Method to get a random year for an age between a specified range
	public  String getYearForAgeRange(int minAge, int maxAge) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int minBirthYear = Math.max(1919, currentYear - maxAge);
		int maxBirthYear = Math.min(2018, currentYear - minAge);
		return Integer.toString(getRandomNumberInRange(minBirthYear, maxBirthYear));
	}
	// Method to get a random year for an age less than a specified age
	public  String getYearForAgeLessThan(int maxAge) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int minBirthYear = Math.max(1919, currentYear - maxAge + 1);
		return Integer.toString(getRandomNumberInRange(minBirthYear, 2018));
	}
	// Method to get a random year for an age greater than a specified age
	public  String getYearForAgeGreaterThan(int minAge) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int maxBirthYear = currentYear - minAge - 1; // subtracting a random number between 25 and 100
		int minBirthYear = Math.max(1919, maxBirthYear - 75); // considering a range of 75 years
		return Integer.toString(getRandomNumberInRange(minBirthYear, maxBirthYear));
	}
	// Method to get a random number within a specified range
	public  int getRandomNumberInRange(int min, int max) {
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
	public  void randomBirthday() throws InterruptedException
	{
		WebElement ToScroll = findElement("month_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
		//click on the month dropdown
		click("month_XPATH");
		Thread.sleep(2000);
		//get the number of elements present in the moinths dropdown
		List<WebElement> months = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));	
		ArrayList<Integer> random = getRandomNumber(1, months.size(), 1);
		for(int ran:random)
		{
			getDriver().findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+ran+"]")).click();	
		}
		click("day_XPATH");
		Thread.sleep(2000);
		for(int ran:random)
		{
			getDriver().findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+ran+"]")).click();	
		}
		click("year_XPATH");
		Thread.sleep(2000);
		for(int ran:random)
		{
			getDriver().findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+ran+"]")).click();	
		}
	}

	// Phone number
	public void PhoneNumber(String colKey,String colValue) throws InterruptedException, AWTException
	{
		WebElement ToScroll = findElement("PreAppPhoneNo_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
		// click on the country code DD
		click("CountryCodeDD_XPATH");
		List<WebElement> options  = getDriver().findElements(By.xpath("//div[@class='dots-text']"));
		int Options = options.size();
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex);
		String PhoneNoCode = randomOption.getText();
		randomOption.click();
		System.out.println("Selected Country code : " + PhoneNoCode);

		// Input the national number into the text field
		type("PreAppPhoneNo_XPATH","1");
		String SamplePhNo = getDriver().findElement(By.xpath("//label[@class='input-tel__label']")).getText();
		// Remove all non-digit characters
		SamplePhNo = SamplePhNo.replaceAll("\\D", "");
		System.out.println(SamplePhNo);

		// Select all text in the input field and delete it
		Actions actions = new Actions(getDriver());
		WebElement inputField = getDriver().findElement(By.xpath("//input[@class='input-tel__input']"));
		actions.moveToElement(inputField).click().keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.DELETE).perform();
		// Enter the filtered phone number into the input field
		type("PreAppPhoneNo_XPATH", SamplePhNo);


		// Randomly select the 'Yes' or 'No' for --- Is this a mobile number?
		WebElement ToScroll1 = findElement("IsthisMbNo_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll1);
		Thread.sleep(2000);
		List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='is_a_mobile_number']"));
		int Count = radioButtons.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(radioButtons.size());
		// Get the text of the randomly selected radio button
		String selectedOption = radioButtons.get(randomIndex1).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons.get(randomIndex1).click();
		if(selectedOption.contains("Y"))
		{
			log.debug("Is this a mobile number? :" + "Yes");
			// Want to stay informed with ASU via SMS messaging?
			WebElement ToScroll11 = findElement("SMSopt_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll11);
			List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='receive_info_via_sms']"));
			int Count1 = radioButtons1.size();
			Random random111 = new Random();
			int randomIndex111 = random111.nextInt(radioButtons1.size());
			// Get the text of the randomly selected radio button
			String selectedOption1 = radioButtons1.get(randomIndex111).getAttribute("value");
			// Click the randomly selected radio button
			radioButtons1.get(randomIndex111).click();
			if(selectedOption1.contains("Y"))
			{
				log.debug("Mobile SMS :" + "Yes");
			}
			if(selectedOption1.contains("N"))
			{
				log.debug("Mobile SMS :" + "No");
			}

		}
		if(selectedOption.contains("N"))
		{
			log.debug("Is this a mobile number? :" + "No");
			// Mobile Number ----  click on the country code DD
			click("MobCountryCodeDD_XPATH");
			List<WebElement> options1  = getDriver().findElements(By.xpath("(//div[@class='dots-text'])[position() >= 244]"));
			int Options1 = options1.size();
			System.out.println("Mobile phone number options :"+Options1);
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex11);
			String MobileNoCode = randomOption1.getText();
			randomOption1.click();
			Thread.sleep(1000);
			//		String 	selectedCountryCode	=	getDriver().findElement(By.xpath("//input[@class='input-tel__input']")).getText();
			System.out.println("Selected Country code : " + MobileNoCode);

			// Input the national number into the text field
			type("MobPhoneNo_XPATH","1");
			String SamplePhNo1 = getDriver().findElement(By.xpath("(//label[@class='input-tel__label'])[2]")).getText();
			// Remove all non-digit characters
			SamplePhNo1 = SamplePhNo1.replaceAll("\\D", "");
			System.out.println(SamplePhNo1);

			// Logic for entering the Same Number-------
			if(SamplePhNo.equals(SamplePhNo1))
			{
				String SamePhNoErr = findElement("SamePhNo_XPATH").getText();
				log.debug("Error message displayed :"+SamePhNoErr);
				// Select all text in the input field and delete it
				Actions actions1 = new Actions(getDriver());
				WebElement inputField1 = getDriver().findElement(By.xpath("(//input[@class='input-tel__input'])[2]"));
				actions1.moveToElement(inputField1).click().keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.DELETE).perform();
				click("MobCountryCodeDD_XPATH");
				List<WebElement> options11  = getDriver().findElements(By.xpath("(//div[@class='dots-text'])[position() >= 244]"));
				int Options11 = options11.size();
				System.out.println("Mobile phone number options :"+Options11);
				Random random111 = new Random();
				int randomIndex111 = random111.nextInt(options11.size());
				WebElement randomOption11 = options11.get(randomIndex111);
				String MobileNoCode1 = randomOption11.getText();
				randomOption11.click();
				Thread.sleep(1000);
				//		String 	selectedCountryCode	=	getDriver().findElement(By.xpath("//input[@class='input-tel__input']")).getText();
				System.out.println("Selected Country code : " + MobileNoCode1);

				// Input the national number into the text field
				type("MobPhoneNo_XPATH","1");
				String SamplePhNo11 = getDriver().findElement(By.xpath("(//label[@class='input-tel__label'])[2]")).getText();
				// Remove all non-digit characters
				SamplePhNo11 = SamplePhNo11.replaceAll("\\D", "");
				System.out.println(SamplePhNo11);
				// Select all text in the input field and delete it
				Actions actions11 = new Actions(getDriver());
				WebElement inputField11 = getDriver().findElement(By.xpath("(//input[@class='input-tel__input'])[2]"));
				actions11.moveToElement(inputField11).click().keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.DELETE).perform();
				// Enter the filtered phone number into the input field
				type("MobPhoneNo_XPATH", SamplePhNo1);

			}




			// Select all text in the input field and delete it
			Actions actions1 = new Actions(getDriver());
			WebElement inputField1 = getDriver().findElement(By.xpath("(//input[@class='input-tel__input'])[2]"));
			actions1.moveToElement(inputField1).click().keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.DELETE).perform();
			// Enter the filtered phone number into the input field
			type("MobPhoneNo_XPATH", SamplePhNo1);
			// Want to stay informed with ASU via SMS messaging?
			WebElement ToScroll11 = findElement("SMSopt_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll11);
			List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='receive_info_via_sms']"));
			int Count1 = radioButtons1.size();
			Random random111 = new Random();
			int randomIndex111 = random111.nextInt(radioButtons1.size());
			// Get the text of the randomly selected radio button
			String selectedOption1 = radioButtons1.get(randomIndex111).getAttribute("value");
			// Click the randomly selected radio button
			radioButtons1.get(randomIndex111).click();
			if(selectedOption1.contains("Y"))
			{
				log.debug("Mobile SMS :" + "Yes");
			}
			if(selectedOption1.contains("N"))
			{
				log.debug("Mobile SMS :" + "No");
			}

		}
	} 






	//        Method to get the national number from PhoneNumber object
	private static String getNationalNumber() 
	{
		String rawPhoneNumber = "+1234567891"; // Raw phone number string
		PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
		try {
			// Parse the raw phone number string
			PhoneNumber phoneNumber = phoneNumberUtil.parse(rawPhoneNumber, null);
			System.out.println("Country code: " + phoneNumber.getCountryCode());
			System.out.println("Phone number: " + phoneNumber.getNationalNumber());
			// Return the national number as a string
			return Long.toString(phoneNumber.getNationalNumber());

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	//	public void PhoneNumber() throws InterruptedException {
	//		// Scroll to the phone number field
	//		WebElement toScroll = findElement("PreAppPhoneNo_XPATH");
	//		this.js = (JavascriptExecutor) getDriver();
	//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", toScroll);
	//
	//		// Click on the country code dropdown
	//		click("CountryCodeDD_XPATH");
	//		Thread.sleep(2000);
	//
	//		// Select a random country code
	//		List<WebElement> options = getDriver().findElements(By.xpath("//div[@class='dots-text']"));
	//		int randomIndex = new Random().nextInt(options.size());
	//		WebElement randomOption = options.get(randomIndex);
	//		Thread.sleep(1000);
	//		String selectedCountry = randomOption.getText();
	//		randomOption.click();
	//		String internationalDialingCode = getInternationalDialingCode(selectedCountry);
	//		System.out.println("Selected Country: " + selectedCountry);
	//		System.out.println("International Dialing Code: " + internationalDialingCode);
	//
	//		// Generate a random national number based on the selected country code
	//		String phoneNumber = generateRandomValidPhoneNumber(internationalDialingCode);
	//		System.out.println("nationalNumber :"+phoneNumber);
	//
	//		// Input the national number into the text field
	//		type("PreAppPhoneNo_XPATH", phoneNumber);
	//		System.out.println("Generated Phone Number: " + internationalDialingCode + phoneNumber);
	//	}
	//
	//	public static String generateRandomValidPhoneNumber(String internationalDialingCode) {
	//		Random random = new Random();
	//		while (true) {
	//			try {
	//				// Generate a random valid phone number for the selected country
	//				PhoneNumber phoneNumber = phoneNumberUtil.getExampleNumberForType(internationalDialingCode, PhoneNumberUtil.PhoneNumberType.MOBILE);
	//				return phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164);
	//			} catch (Exception e) {
	//				// If the generated number is invalid, try again
	//				System.err.println("Error generating phone number: " + e.getMessage());
	//			}
	//		}
	//	}
	//
	//
	//
	//
	//	public static String getInternationalDialingCode(String countryName) {
	//		// Look up the country code based on the country name
	//		String countryCode = getCountryCode(countryName);
	//		if (countryCode != null) {
	//			return "+" + phoneNumberUtil.getCountryCodeForRegion(countryCode);
	//		} else {
	//			System.out.println("Country code not found for country: " + countryName);
	//			return null;
	//		}
	//	}
	//
	//	private static String getCountryCode(String countryName) {
	//		// Iterate over available locales and find the one matching the country name
	//		Locale[] locales = Locale.getAvailableLocales();
	//		for (Locale locale : locales) {
	//			if (countryName.equalsIgnoreCase(locale.getDisplayCountry())) {
	//				return locale.getCountry();
	//			}
	//		}
	//		return null; // Country name not found
	//	}




















	public  void IfIncorrectClickhereLink() throws Throwable
	{
		waitTillLoaderDisappears();
		waitTillProgressbarDisappears();
		Thread.sleep(1000);
		scrollUp(getDriver(), 1);
		WebElement ToScroll = findElement("NeedHelpLinkAtPreappDashboard_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
		click("NeedHelpLinkAtPreappDashboard_XPATH");
		Thread.sleep(1000);
	}


	public  void DupAppBirthday(String colKey,String colValue) throws Throwable
	{
		WebElement ToScroll = findElement("month_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
		//click on the month dropdown
		click("month_XPATH");
		click("MonDD_XPATH");
		click("day_XPATH");
		click("DateDD_XPATH");
		click("year_XPATH");
		click("YearDD_XPATH");
		String Month  = findElement("month_XPATH").getText();
		String Day  = findElement("day_XPATH").getText();
		String year  = findElement("year_XPATH").getText();
		String DOB = Month+" "+Day+", "+year;
		log.debug("Date of Birth :"+DOB);
		waitUntilExcelFileIsNotEmpty(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		Thread.sleep(1000);
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 3, "Date of birth",DOB);
		saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");

	}




	public  void startNewAppbutton() throws Throwable
	{
		// BrightVerify for Phone no and Mobile no
		if(PhoneNoCode.equals("United States") || PhoneNoCode.equals("Canada")|| MobileNoCode.equals("United States") || MobileNoCode.equals("Canada"))
		{
			if(findElement("PhNoBriteVerify_XPATH").isDisplayed())
			{
				click("PhNoBriteVerifySubmit_XPATH");
				Thread.sleep(3000);
			}
		}

		else
		{
			boolean startnewAppButton = findElement("startNewApplicationButton_XPATH").isEnabled();
			if(startnewAppButton==true)
				findElement("startNewApplicationButton_XPATH").click();
			waitTillLoaderDisappears();
			waitTillProgressbarDisappears();
			Thread.sleep(3000);
		}

		log.debug("----------------------------------------------------");
	}



}






