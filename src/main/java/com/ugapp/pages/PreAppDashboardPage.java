//package com.ugapp.pages;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import java.util.Random;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//
//import com.ugapp.base.Page;
//
//
//public class PreAppDashboardPage extends Page
//{
//	public JavascriptExecutor js = (JavascriptExecutor) getDriver();
//	static String validMonth="";
//	static String validDay="";
//
//
//	public void validatePreAppPage() throws Throwable
//	{
//		waitTillLoaderDisappears();
//		Thread.sleep(2000);
//		//validate the pre app page with url
//		String dashboard=getDriver().getCurrentUrl();
//		if(dashboard.contains("https://apply-qa.apps.asu.edu/dashboard"))
//		{
//			log.debug("Redirected to Pre-App Submission page successfully!");
//		}
//		else
//			log.debug("Failed to redirect to Pre-App Submission page");
//	}
//
//
//	public void userDetails(String firstName , String preferredfirstname , String middlename , String lastName) throws Throwable
//	{
//		Thread.sleep(3000);
//		type("firstName_XPATH",firstName);
//		type("preferredFirstName_XPATH",preferredfirstname);
//		type("middleName_XPATH",middlename);
//		type("lastName_XPATH",lastName);
//	}
//
//
//	public void validateUserDetails(String firstName , String preferredfirstname , String middlename , String lastName) throws Throwable
//	{
//		//regex that checks numbers , special char , space at end or start
//		String regex = "^(?!.*\\\\s$)(?!^\\\\s)(?!.*-$)[0-9A-Za-z!@#$%^&*()_+=`~{}\\\\[\\\\]:;\\\"'<>,.?\\\\\\\\/| ]+$";
//
//
//		//Firstname validation
//		boolean isFirstNameValid = firstName.matches(regex);
//		log.debug("isFirstNameValid :"+isFirstNameValid);
//		if(isFirstNameValid)
//		{
//			try {
//				String errorFirstName = findElement("errorFirstName_XPATH").getText();
//				Assert.assertEquals(errorFirstName, "The first name can only contain letters, spaces and hyphens (-).");
//			}catch(Exception e) 
//			{
//				if(firstName.length()>25)
//				{
//					String errorFirstName25 = findElement("errorFirstName25_XPATH").getText();
//					Assert.assertEquals(errorFirstName25, "The first name should not be more than 25 characters.");
//				}
//
//
//			}
//		}
//		else
//			log.debug("Firstname is not valid");
//
//
//
//
//		//preferred First Name validation
//		boolean isPreferredFirstNameValid = preferredfirstname.matches(regex);
//		log.debug("isPreferredFirstNameValid :"+isPreferredFirstNameValid);
//		if(isPreferredFirstNameValid)
//		{
//			try
//			{
//				String errorPreferredFirstName = findElement("errorPreferredFirstName_XPATH").getText();
//				Assert.assertEquals(errorPreferredFirstName, "The preferred first name can only contain letters, spaces and hyphens (-).");
//			}catch(Exception e)
//			{
//				if(preferredfirstname.length()>30)
//				{
//					String errorPreferredFirstName30 = findElement("errorPreferredFirstName30_XPATH").getText();
//					Assert.assertEquals(errorPreferredFirstName30, "The preferred first name should not be more than 30 characters.");
//				}
//			}
//		}
//		else
//			log.debug("preferredfirstname is not valid");
//
//
//
//
//		//middlename
//		boolean ismiddleNameValid = middlename.matches(regex);
//		log.debug("ismiddleNameValid :"+ismiddleNameValid);
//		if(ismiddleNameValid)
//		{
//			try
//			{
//				String errorMiddleName = findElement("errorMiddleName_XPATH").getText();
//				Assert.assertEquals(errorMiddleName, "The middle name can only contain letters, spaces and hyphens (-).");
//			}catch(Exception e)
//			{
//				if(middlename.length()>25)
//				{
//					String errorMiddleName25 = findElement("errorMiddleName25_XPATH").getText();
//					Assert.assertEquals(errorMiddleName25, "The middle name should not be more than 25 characters.");
//				}
//			}
//		}
//		else
//			log.debug("middlename is not valid");
//
//
//
//
//		//lastname
//		boolean isLastNameValid = lastName.matches(regex);
//		log.debug("isLastNameValid :"+isLastNameValid);
//		if(isLastNameValid)
//		{
//			try
//			{
//				String errorLastName = findElement("errorLastName_XPATH").getText();
//				Assert.assertEquals(errorLastName, "The last name can only contain letters, spaces and hyphens (-).");
//			}catch(Exception e)
//			{
//				if(lastName.length()>30)
//				{
//					String errorLastName30 = findElement("errorLastName30_XPATH").getText();
//					Assert.assertEquals(errorLastName30, "The last name should not be more than 30 characters.");
//				}
//			}
//		}
//		else
//			log.debug("lastName is not valid");
//
//
//
//
//		//button enability
//		boolean startnewAppButton = findElement("startNewApplicationButton_XPATH").isEnabled();
//		if(startnewAppButton==false)
//			getDriver().navigate().refresh();
//		Thread.sleep(2000);
//	}
//
//
//	public void validuser(String colKey,String colValue) throws Exception
//	{
//		WebElement ToScroll = findElement("firstName_XPATH");
//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
//		type("firstName_XPATH","Test FN");
//		type("preferredFirstName_XPATH","Automation PFN");
//		WebElement ToScroll1 = findElement("middleName_XPATH");
//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll1);
//		type("middleName_XPATH","Automation MN");
//		type("lastName_XPATH","Test LN");
//		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//		setExcelData(colKey,colValue,"validData", 1, "Legal name", "Test FN Automation MN Test LN");
//		setExcelData(colKey,colValue,"validData", 2, "Preferred first name", "Automation PFN");
//		saveReport();
//	}
//
//
//	public static void scroll()
//	{
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,400)");
//	}
//
//
//	public static void checkOptionalTag()
//	{
//		//preferred firstname Optional tag
//		try {
//			findElement("preferredOptional_XPATH");
//			log.debug("Optional tag is  present for Preferred first name!");
//		}
//		catch(Exception e) {
//			log.debug("Optional tag is not present for Preferred first name!");
//		}
//
//
//		//Middlename Optional tag
//		try {
//			findElement("middleOptional_XPATH");
//			log.debug("Optional tag is present for middle name!");
//
//
//		}
//		catch(Exception e) {
//			log.debug("Optional tag is not present for middle ame!");
//		}
//
//
//		//suffix Optional tag
//		try {
//			findElement("suffixOptional_XPATH");
//			log.debug("Optional tag is present for suffix dropdown!");
//		}
//		catch(Exception e) {
//			log.debug("Optional tag is not present for suffix dropdown!");
//		}
//
//
//	}
//
//
//	public static void verifySuffixDropdown() throws Throwable
//	{
//		//click on dropdown
//		WebElement ToScroll = findElement("suffixDropdown_XPATH");
//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
//		findElement("suffixDropdown_XPATH").click();
//		Thread.sleep(1500);
//
//
//		//get the number of elements in the dropdowm and stor them in an arraylist
//		List<WebElement> suffix = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li[contains(text(),'')]"));
//		ArrayList<String> suffixDropdownFields = new ArrayList<String>();
//
//
//		int i=1;
//		for(WebElement suff:suffix)
//		{
//			String suffixFields=driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li[contains(text(),'')])["+i+"]")).getText();
//			suffixDropdownFields.add(suffixFields);
//			i++;
//		}
//
//
//		//validate the elements present in the dropdown
//		log.debug("suffixDropdownFields :"+suffixDropdownFields);
//		if(suffixDropdownFields.contains("II") && suffixDropdownFields.contains("III") && suffixDropdownFields.contains("IV") && suffixDropdownFields.contains("Jr.") && suffixDropdownFields.contains("Sr."))
//			log.debug("The Suffix dropdown contains all the expected data!");
//		else
//			log.debug("The Suffix Dropdown does not contain all the expected data");
//
//
//	}
//
//
//	public static void verifySuffixClear() throws Throwable
//	{
//		//random click on any of the elements in the suffix dropdown 
//		List<WebElement> suffix = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//		ArrayList<Integer> ransuf = getRandomNumber(1, suffix.size(), 1);
//		for(int r:ransuf)
//		{
//			driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+r+"]")).click();
//		}
//
//
//		//click on the clear button
//		click("clearSuffix_XPATH");
//		Thread.sleep(1000);
//		try
//		{
//			List<WebElement> error = driver.findElements(By.xpath("//li[contains(text(),' This is a required field')]"));
//			log.debug("The error message is displayed when cleared the Suffix field!");
//		}
//		catch(Exception e) {
//			log.debug("The error message is not displayed when cleared the Suffix field");
//		}
//	}
//
//
//	public static void verifyMonths() throws Throwable
//	{	
//		//click on the month dropdown
//		click("month_XPATH");
//		Thread.sleep(2000);
//
//
//		//get the number of elements present in the moinths dropdown
//		List<WebElement> months = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));	
//		log.debug("months.size :"+months.size());
//		if(months.size()==12)
//		{
//			log.debug("Month dropdown has all twelve months!");
//		}
//		else
//		{
//			log.debug("Month dropdown does not have all twelve months!");
//		}
//	}
//
//
//	public static void verifyDaysPresent() throws Throwable
//	{
//		//number of months
//		List<WebElement> months = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//
//
//		//random number to choose from months
//		ArrayList<Integer> ran = getRandomNumber(1, months.size(), 1);
//
//
//		//get the randomnly selected month
//		String monthSelected="";
//		for(int r:ran)
//		{
//			monthSelected = driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li[contains(text(),'')])[" + r + "]")).getText();
//			log.debug("monthSelected :"+monthSelected);
//			driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+r+"]")).click();
//		}
//
//
//		//day dropdown
//		click("day_XPATH");
//		Thread.sleep(2000);
//
//
//		//number of days
//		List<WebElement> days = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//		ArrayList<Integer> randay = getRandomNumber(1, days.size(), 1);
//
//
//		if(monthSelected.equalsIgnoreCase("January") || monthSelected.equalsIgnoreCase("March") || monthSelected.equalsIgnoreCase("May") || monthSelected.equalsIgnoreCase("July") || monthSelected.equalsIgnoreCase("August") || monthSelected.equalsIgnoreCase("October") || monthSelected.equalsIgnoreCase("December"))
//		{
//			if(days.size()==31)
//			{
//				log.debug("Day dropdown works as expected!");
//			}
//			else
//				log.debug("Day dropwdown is not working as expected");
//		}
//		else if(monthSelected.equalsIgnoreCase("April") || monthSelected.equalsIgnoreCase("June") || monthSelected.equalsIgnoreCase("September") || monthSelected.equalsIgnoreCase("November"))	
//		{
//			if(days.size()==30)
//				log.debug("Day dropdown works as expected!");
//			else
//				log.debug("Day dropwdown is not working as expected");
//		}
//		else if(monthSelected.equalsIgnoreCase("February"))
//		{
//			if(days.size()==29)
//				log.debug("Day dropdown works as expected!");
//			else
//				log.debug("Day dropwdown is not working as expected");
//		}
//		for(int r:randay)
//		{
//			driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li[contains(text(),'')])[" + r + "]")).click();
//		}
//	}
//
//
//	public static void verifyYearsPresent() throws Throwable
//	{
//		//click year dropdown
//		click("year_XPATH");
//		Thread.sleep(2000);
//
//
//
//
//		//number of years
//		List<WebElement> year = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//		ArrayList<Integer> ranyear = getRandomNumber(1, year.size(), 1);
//		if(year.size()==100)
//			log.debug("year dropdown has 100 values as expected!");
//		else
//			log.debug("year dropdown does not have 100 values!");
//
//
//
//
//		//close the dropdown
//		for(int r:ranyear)
//		{
//			driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li[contains(text(),'')])[" + r + "]")).click();
//		}
//	}
//
//
//	public static void verifyClearButton() throws InterruptedException
//	{
//		//verify clear button
//		click("clearmonth_XPATH");
//		Thread.sleep(500);
//		click("clearDay_XPATH");
//		Thread.sleep(500);
//		click("clearYear_XPATH");
//
//
//	}
//
//
//	public static void validateErrorMessage()
//	{
//
//
//		//validate the error message present after clearing the borthday fields
//		List<WebElement> error = driver.findElements(By.xpath("//li[contains(text(),' This is a required field')]"));
//
//
//		if(error.size()==3)
//			log.debug("The error message is displayed when cleared the birthday fields!");
//		else
//			log.debug("The error message is not displayed when cleared the birthday fields");
//	}
//
//
//	public static void BirthdayAge_Greater24(String colKey,String colValue) throws Throwable
//	{
//		WebElement ToScroll = findElement("year_XPATH");
//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
//		WebElement year=driver.findElement(By.xpath("//div[@id=\"create-application-birth-year\"]//input"));
//		// Randomly select birthday year for Age greater than 24
//		String yearForAgeGreaterThan24 = getYearForAgeGreaterThan(24);
//		year.sendKeys(yearForAgeGreaterThan24);
//		year.sendKeys(Keys.ENTER);
//		System.out.println(yearForAgeGreaterThan24);
//		// Randomly select a Month
//		click("month_XPATH");
//		Thread.sleep(1000);
//		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//		int Options = options.size();
//		Random random = new Random();
//		int randomIndex = random.nextInt(options.size());
//		WebElement randomOption = options.get(randomIndex);
//		Thread.sleep(500);
//		randomOption.click();
//		Thread.sleep(500);
//		// Randomly select a Day
//		click("day_XPATH");
//		Thread.sleep(1000);
//		List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//		int Options1 = options1.size();
//		Random random1 = new Random();
//		int randomIndex1 = random1.nextInt(options1.size());
//		WebElement randomOption1 = options1.get(randomIndex1);
//		Thread.sleep(500);
//		randomOption1.click();
//		Thread.sleep(500);
//		String Month  = findElement("month_XPATH").getText();
//		String Day  = findElement("day_XPATH").getText();
//		String DOB = Month+" "+Day+", "+yearForAgeGreaterThan24;
//		log.debug("Date of Birth :"+DOB);
//		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//		setExcelData(colKey,colValue,"validData", 3, "Date of birth",DOB );
//		saveReport();
//	}
//	public static void BirthdayAge_Btn18_24(String colKey,String colValue) throws Throwable
//	{
//		WebElement ToScroll = findElement("year_XPATH");
//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
//		WebElement year=driver.findElement(By.xpath("//div[@id=\"create-application-birth-year\"]//input"));
//		// Randomly select birthday year for Age between 18 and 24
//		String yearForAge18to24 = getYearForAgeRange(18, 24);
//		year.sendKeys(yearForAge18to24);
//		year.sendKeys(Keys.ENTER);
//		System.out.println(yearForAge18to24);
//		// Randomly select a Month
//		click("month_XPATH");
//		Thread.sleep(1000);
//		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//		int Options = options.size();
//		Random random = new Random();
//		int randomIndex = random.nextInt(options.size());
//		WebElement randomOption = options.get(randomIndex);
//		Thread.sleep(500);
//		randomOption.click();
//		Thread.sleep(500);
//		// Randomly select a Day
//		click("day_XPATH");
//		Thread.sleep(1000);
//		List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//		int Options1 = options1.size();
//		Random random1 = new Random();
//		int randomIndex1 = random1.nextInt(options1.size());
//		WebElement randomOption1 = options1.get(randomIndex1);
//		Thread.sleep(500);
//		randomOption1.click();
//		Thread.sleep(500);
//		String Month  = findElement("month_XPATH").getText();
//		String Day  = findElement("day_XPATH").getText();
//		String DOB = Month+" "+Day+", "+yearForAge18to24;
//		log.debug("Date of Birth :"+DOB);
//		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//		setExcelData(colKey,colValue,"validData", 3, "Date of birth",DOB );
//		saveReport();
//	}
//	public static void BirthdayAge_24(String colKey,String colValue) throws Throwable
//	{
//		WebElement ToScroll = findElement("year_XPATH");
//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
//		WebElement year=driver.findElement(By.xpath("//div[@id=\"create-application-birth-year\"]//input"));
//		// Randomly select birthday year for Age = 24
//		String yearForAge24 = getYearForAgeRange(24);
//		year.sendKeys(yearForAge24);
//		year.sendKeys(Keys.ENTER);
//		System.out.println(yearForAge24);
//		// Randomly select a Month
//		click("month_XPATH");
//		Thread.sleep(1000);
//		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//		int Options = options.size();
//		Random random = new Random();
//		int randomIndex = random.nextInt(options.size());
//		WebElement randomOption = options.get(randomIndex);
//		Thread.sleep(500);
//		randomOption.click();
//		Thread.sleep(500);
//		// Randomly select a Day
//		click("day_XPATH");
//		Thread.sleep(1000);
//		List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//		int Options1 = options1.size();
//		Random random1 = new Random();
//		int randomIndex1 = random1.nextInt(options1.size());
//		WebElement randomOption1 = options1.get(randomIndex1);
//		Thread.sleep(500);
//		randomOption1.click();
//		Thread.sleep(500);
//		String Month  = findElement("month_XPATH").getText();
//		String Day  = findElement("day_XPATH").getText();
//		String DOB = Month+" "+Day+", "+yearForAge24;
//		log.debug("Date of Birth :"+DOB);
//		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//		setExcelData(colKey,colValue,"validData", 3, "Date of birth",DOB );
//		saveReport();
//	}
//	public static void BirthdayAge_18(String colKey,String colValue) throws Throwable
//	{
//		WebElement ToScroll = findElement("year_XPATH");
//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
//		WebElement year=driver.findElement(By.xpath("//div[@id=\"create-application-birth-year\"]//input"));
//		// Randomly select birthday year for Age = 18
//		String yearForAge18 = getYearForAgeRange(18);
//		year.sendKeys(yearForAge18);
//		year.sendKeys(Keys.ENTER);
//		// Randomly select a Month
//		click("month_XPATH");
//		Thread.sleep(1000);
//		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//		int Options = options.size();
//		Random random = new Random();
//		int randomIndex = random.nextInt(options.size());
//		WebElement randomOption = options.get(randomIndex);
//		Thread.sleep(500);
//		randomOption.click();
//		Thread.sleep(500);
//		// Randomly select a Day
//		click("day_XPATH");
//		Thread.sleep(1000);
//		List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//		int Options1 = options1.size();
//		Random random1 = new Random();
//		int randomIndex1 = random1.nextInt(options1.size());
//		WebElement randomOption1 = options1.get(randomIndex1);
//		Thread.sleep(500);
//		randomOption1.click();
//		Thread.sleep(500);
//		String Month  = findElement("month_XPATH").getText();
//		String Day  = findElement("day_XPATH").getText();
//		String DOB = Month+" "+Day+", "+yearForAge18;
//		log.debug("Date of Birth :"+DOB);
//		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//		setExcelData(colKey,colValue,"validData", 3, "Date of birth",DOB );
//		saveReport();
//	}
//	public static void BirthdayAge_Less18(String colKey,String colValue) throws Throwable
//	{
//		WebElement ToScroll = findElement("year_XPATH");
//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
//		WebElement year=driver.findElement(By.xpath("//div[@id=\"create-application-birth-year\"]//input"));
//		// Randomly select birthday year for Age less than 18
//		String yearForAgeLessThan18 = getYearForAgeLessThan(18);
//		year.sendKeys(yearForAgeLessThan18);
//		year.sendKeys(Keys.ENTER);
//		// Randomly select a Month
//		click("month_XPATH");
//		Thread.sleep(1000);
//		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//		int Options = options.size();
//		Random random = new Random();
//		int randomIndex = random.nextInt(options.size());
//		WebElement randomOption = options.get(randomIndex);
//		Thread.sleep(500);
//		randomOption.click();
//		Thread.sleep(500);
//		// Randomly select a Day
//		click("day_XPATH");
//		Thread.sleep(1000);
//		List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//		int Options1 = options1.size();
//		Random random1 = new Random();
//		int randomIndex1 = random1.nextInt(options1.size());
//		WebElement randomOption1 = options1.get(randomIndex1);
//		Thread.sleep(500);
//		randomOption1.click();
//		Thread.sleep(500);
//		String Month  = findElement("month_XPATH").getText();
//		String Day  = findElement("day_XPATH").getText();
//		String DOB = Month+" "+Day+", "+yearForAgeLessThan18;
//		log.debug("Date of Birth :"+DOB);
//		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//		setExcelData(colKey,colValue,"validData", 3, "Date of birth",DOB );
//		saveReport();
//	}
//	// Method to get a random year for a specific age
//	public static String getYearForAgeRange(int age) {
//		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
//		int birthYear = currentYear - age;
//		return Integer.toString(birthYear);
//	}
//	// Method to get a random year for an age between a specified range
//	public static String getYearForAgeRange(int minAge, int maxAge) {
//		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
//		int minBirthYear = Math.max(1919, currentYear - maxAge);
//		int maxBirthYear = Math.min(2018, currentYear - minAge);
//		return Integer.toString(getRandomNumberInRange(minBirthYear, maxBirthYear));
//	}
//	// Method to get a random year for an age less than a specified age
//	public static String getYearForAgeLessThan(int maxAge) {
//		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
//		int minBirthYear = Math.max(1919, currentYear - maxAge + 1);
//		return Integer.toString(getRandomNumberInRange(minBirthYear, 2018));
//	}
//	// Method to get a random year for an age greater than a specified age
//	public static String getYearForAgeGreaterThan(int minAge) {
//		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
//		int maxBirthYear = currentYear - minAge - 1; // subtracting a random number between 25 and 100
//		int minBirthYear = Math.max(1919, maxBirthYear - 75); // considering a range of 75 years
//		return Integer.toString(getRandomNumberInRange(minBirthYear, maxBirthYear));
//	}
//	// Method to get a random number within a specified range
//	public static int getRandomNumberInRange(int min, int max) {
//		Random random = new Random();
//		return random.nextInt((max - min) + 1) + min;
//	}
//	public static void randomBirthday() throws InterruptedException
//	{
//		WebElement ToScroll = findElement("month_XPATH");
//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
//		//click on the month dropdown
//		click("month_XPATH");
//		Thread.sleep(2000);
//		//get the number of elements present in the moinths dropdown
//		List<WebElement> months = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));	
//		ArrayList<Integer> random = getRandomNumber(1, months.size(), 1);
//		for(int ran:random)
//		{
//			driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+ran+"]")).click();	
//		}
//		click("day_XPATH");
//		Thread.sleep(2000);
//		for(int ran:random)
//		{
//			driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+ran+"]")).click();	
//		}
//		click("year_XPATH");
//		Thread.sleep(2000);
//		for(int ran:random)
//		{
//			driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+ran+"]")).click();	
//		}
//	}
//
//
//
//	public static void IfIncorrectClickhereLink() throws Throwable
//	{
//		waitTillLoaderDisappears();
//		Thread.sleep(1000);
//		//		scrollUp(driver, 1);
//		WebElement ToScroll = findElement("NeedHelpLinkAtPreappDashboard_XPATH");
//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
//		click("NeedHelpLinkAtPreappDashboard_XPATH");
//		Thread.sleep(1000);
//	}
//
//
//	public static void startNewAppbutton() throws Throwable
//	{
//		boolean startnewAppButton = findElement("startNewApplicationButton_XPATH").isEnabled();
//		if(startnewAppButton==true)
//			findElement("startNewApplicationButton_XPATH").click();
//		waitTillLoaderDisappears();
//		Thread.sleep(5000);
//	}
//
//
//
//}
//
//
//
//
//
//
