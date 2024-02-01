package com.ugapp.pages;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ugapp.base.Page;
public class MyInformationPage extends Page
{
	NeedHelpPage NeedHelp = new NeedHelpPage();
	static ArrayList<String> validFormerName = new ArrayList<>();
//	static String gender="";
	public static ThreadLocal<String> gender = new ThreadLocal<>();
	static  ThreadLocal<String> selectedLanguage= new ThreadLocal<>();
	public static ThreadLocal<String> state=new ThreadLocal<>();
	static ThreadLocal<String> selectedOptionText=new ThreadLocal<>();
	static ThreadLocal<String> phone = new ThreadLocal<>();
	static ThreadLocal<String> mobile = new ThreadLocal<>();
//	static String selectedCountryOfBirthOptionText = "";
	static ThreadLocal<String> selectedCountryOfBirthOptionText = new ThreadLocal<>();
	static ThreadLocal<String> Relation = new ThreadLocal<>();
	static ThreadLocal<String> Schooling = new ThreadLocal<>();
	static ThreadLocal<String> AttendedASU = new ThreadLocal<>();
	static ThreadLocal<String> Relation1 = new ThreadLocal<>();
	static ThreadLocal<String> Schooling1 =new ThreadLocal<>();
	static ThreadLocal<String> AttendedASU1 = new ThreadLocal<>();
	static ThreadLocal<String> asuAffiliation = new ThreadLocal<>();
	static ThreadLocal<String> randomASU_affiliateID = new ThreadLocal<>();
	static ThreadLocal<String> selectedBranchServiceOptionText = new ThreadLocal<>();
	static ThreadLocal<String> departmentOfVeterans = new ThreadLocal<>();
	static ThreadLocal<String> educationbenefit = new ThreadLocal<>();
	static ThreadLocal<String> selectedEmploymentOptionText = new ThreadLocal<>();
	static ThreadLocal<String> selectedBranchText =new ThreadLocal<>();
	static ThreadLocal<String> AuthorizeASU =new ThreadLocal<>();
	static ThreadLocal<String> CurrentlyInUS =new ThreadLocal<>();
	static int count = 0;
	static ThreadLocal<String> Citizenship =new ThreadLocal<>();
//	static ThreadLocal<String> colNumKey= new ThreadLocal<>();
//	static ThreadLocal<String> colNumValue= new ThreadLocal<>();


	JavascriptExecutor js = (JavascriptExecutor) getDriver();


	public void ValidateForMyInfo() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(3000);
		WebElement elementToScrollTo1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='My information']")));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		Thread.sleep(2000);
		String PageTitle	= findElement("MyInfoTitle_XPATH").getText();
		log.debug("Page title :"+" "+PageTitle);
		String url=getDriver().getCurrentUrl();
		if(url.contains("my-information") && PageTitle.contains("My information"))
		{
			log.debug("Redirected to my information page");
		}
		else
		{
			log.debug("Failed to Redirected to my information page");
		}
		
	}


	public void requiredFields() throws Throwable
	{

		//click on save button
		getDriver().findElement(By.xpath("(//footer//button)[1]")).click();
		Thread.sleep(2000);
		//error message for Legal sex
		try{
			getDriver().findElement(By.xpath("//legend[@id='group_legal_sex__BV_label_']/following-sibling::div//div[contains(text(),' This is a required field. ')]"));
			System.out.println("The error message for Legal sex is displayed when the field is left empty!");}
		catch(Exception e){	
			System.out.println("The error message for Legal sex is not displayed when the field is left empty!");}
		//error message for primary language
		try{
			getDriver().findElement(By.xpath("//div[@id='primary_language_select']//li"));
			System.out.println("The error message for Primary language is displayed when the field is left empty!");}
		catch(Exception e){	
			System.out.println("The error message for Primary Language is not displayed when the field is left empty!");}
		//error message for Home address and Phone
		try{
			getDriver().findElement(By.xpath("//div[@id='home-country-select']//li"));
			System.out.println("The error message for Home address and Phone is displayed when the field is left empty!");}
		catch(Exception e){	
			System.out.println("The error message for Home address and Phone is not displayed when the field is left empty!");}
		//error message for US Citizenship
		try{
			getDriver().findElement(By.xpath("//legend[@id='group_us_citizen__BV_label_']/following-sibling::div//div[contains(text(),' This is a required field. ')]"));
			System.out.println("The error message for US Citizenship is displayed when the field is left empty!");}
		catch(Exception e){	
			System.out.println("The error message for US Citizenship is not displayed when the field is left empty!");}
		//error message for ASU Affiliation
		try{
			getDriver().findElement(By.xpath("//legend[@id='group_asu_affiliation__BV_label_']/following-sibling::div//div[contains(text(),' This is a required field. ')]"));
			System.out.println("The error message for ASU Affiliation is displayed when the field is left empty!");}
		catch(Exception e){	
			System.out.println("The error message for ASU Affiliation is not displayed when the field is left empty!");}
		//error message for Affiliation to US Uniformed Service
		try{
			getDriver().findElement(By.xpath("//div[@id='group_us_uniformed_services']//li"));
			System.out.println("The error message for Affiliation to US Uniformed Service is displayed when the field is left empty!");}
		catch(Exception e){	
			System.out.println("The error message for Affiliation to US Uniformed Service is not displayed when the field is left empty!");}
		//error message for Partner Benefits
		try{
			getDriver().findElement(By.xpath("//legend[@id='group_education_benefit__BV_label_']/following-sibling::div//div[contains(text(),' This is a required field. ')]"));
			System.out.println("The error message for Partner Benefits is displayed when the field is left empty!");}
		catch(Exception e){	
			System.out.println("The error message for Partner Benefits is not displayed when the field is left empty!");}
		refreshPage();
		Thread.sleep(1000)	;
		waitTillLoaderDisappears();
		getDriver().manage().window().fullscreen() ;
		Thread.sleep(3000)	;
	}








	public void FormerName(String First_name, String Last_name) throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(2000);
		WebElement elementToScrollTo1 = findElement("AddFormerName_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		boolean FormerNameButton = findElement("AddFormerName_XPATH").isEnabled();
		if(FormerNameButton==true)
		{
			WebElement elementToScrollTo2 = findElement("AddFormerName_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			findElement("AddFormerName_XPATH").click();
			Thread.sleep(1000);
			scrollDown(getDriver(), 1);
		}
		else 
		{
			String MaxErrorMsg = findElement("MaxLimitErrMsg_XPATH").getText();
			Assert.assertEquals(MaxErrorMsg, "Reached maximum limit ");
			log.debug("Reached maximum limit ");
		}



		//Add around 10 former name
		type("FirstName_ID", First_name);
		type("LastName_ID", Last_name);
	}












	public void ValidateFormerName(String First_name, String Last_name) throws InterruptedException
	{
		// Validate with Entered first name and last name
		//regex that checks numbers , special char , space at end or start
		String regex = "^(?!.*\\\\s$)(?!^\\\\s)(?!.*-$)[0-9A-Za-z!@#$%^&*()_+=`~{}\\\\[\\\\]:;\\\"'<>,.?\\\\\\\\/| ]+$";
		//First_name validation
		boolean isFirstNameValid = First_name.matches(regex);
		log.debug("isFirstNameValid :"+isFirstNameValid);
		if(isFirstNameValid)
		{
			try {
				String errorFirstName = findElement("FNErrMsg_XPATH").getText();
				Assert.assertEquals(errorFirstName, "The former/alternate first name can only contain letters, spaces and hyphens (-).");
			}catch(Exception e) {
				if(First_name.length()>25)
				{
					String errorFirstName25 = findElement("errorFirstName25_XPATH").getText();
					Assert.assertEquals(errorFirstName25, "The first name should not be more than 25 characters.");
				}
			}
		}
		else
			log.debug("Firstname is not valid");
		//Last_name validation
		boolean isLastNameValid = Last_name.matches(regex);
		log.debug("isLastNameValid :"+isLastNameValid);
		if(isLastNameValid)
		{
			try
			{
				String errorLastName = findElement("LNErrMsg_XPATH").getText();
				Assert.assertEquals(errorLastName, "The former/alternate last name can only contain letters, spaces and hyphens (-).");
			}catch(Exception e)
			{
				if(Last_name.length()>30)
				{
					String errorLastName30 = findElement("errorLastName30_XPATH").getText();
					Assert.assertEquals(errorLastName30, "The last name should not be more than 30 characters.");
				}
			}
		}
		else
			log.debug("lastName is not valid");
		// Define XPaths for error messages
		String[] errorXPaths = {
				"//div[.= ' The former/alternate first name can only contain letters, spaces and hyphens (-). ']",
				"//div[text()=' The first name should not be more than 25 characters. ']",
				"//div[.= ' The former/alternate last name can only contain letters, spaces and hyphens (-). ']",
				"//div[text()=' The last name should not be more than 30 characters. ']"
		};
		// Store error messages in a list
		List<String> errorMessages = new ArrayList<>();
		for (String xpath : errorXPaths)
		{
			List<WebElement> errorElements = getDriver().findElements(By.xpath(xpath));
			for (WebElement errorElement : errorElements)
			{
				errorMessages.add(errorElement.getText());
			}
		}
		// Perform action based on error messages
		if (errorMessages.isEmpty()) {
			// No error messages found, click on Save button
			WebElement elementToScrollTo2 = findElement("SaveName_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			click("SaveName_XPATH");
		} else {
			// Error messages found, click on Cancel button
			WebElement elementToScrollTo2 = findElement("Cancel_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			click("Cancel_XPATH");
		}
	}








	public void ValidateAddedFormerNames()
	{
		List<WebElement> FormerNameslist = getDriver().findElements(By.xpath("//table[@data-cy='my-info-former-name-table']//td[1]"));
		log.debug("No. of Former Name added :"+" "+FormerNameslist.size());
		if(FormerNameslist.size()==10)
		{
			log.debug("10 Former names added successfully!!!");
		}
		else
		{
			log.debug("10 Former names Not added successfully!!!");
		}
		for(WebElement X : FormerNameslist )
		{
			String formernameslist = X.getText();
			log.debug(formernameslist);


		}








	}








	public void Edit_CancelFormerName() throws InterruptedException
	{
		WebElement elementToScrollTo2 = getDriver().findElement(By.xpath("//table[@data-cy='my-info-former-name-table']//tbody"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		List<WebElement> editButtons = getDriver().findElements(By.xpath("//table[@data-cy='my-info-former-name-table']//tbody//a[1]"));
		// Generate a random index to choose a random Edit button
		Random random = new Random();
		int randomIndex = random.nextInt(editButtons.size());
		// Click on the random Edit button
		WebElement randomEditButton = editButtons.get(randomIndex);
		Thread.sleep(1000);
		randomEditButton.click();
		log.debug("Editing the Former Names");
		WebElement elementToScrollFN = findElement("FirstName_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollFN);
		findElement("FirstName_ID").clear();
		Thread.sleep(500);
		findElement("FirstName_ID").sendKeys("FN Edited");
		Thread.sleep(500);
		WebElement elementToScrollLN = findElement("LastName_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollLN);
		findElement("LastName_ID").clear();
		Thread.sleep(500);
		findElement("LastName_ID").sendKeys("LN Edited");
		Thread.sleep(1000);
		WebElement elementToScrollCancel = findElement("Cancel_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollCancel);
		click("Cancel_XPATH");
		Thread.sleep(1000);
		List<WebElement> EditedFormerNameslist = getDriver().findElements(By.xpath("//table[@data-cy='my-info-former-name-table']//tbody//a[1]"));
		for(WebElement X : EditedFormerNameslist )
		{


			String Editedformernameslist = X.getText();


			if(!Editedformernameslist.contains("FN Edited LN Edited"))
			{
				log.debug("The Cancel button functionality is working fine!!!");
			}
		}
	}
	public void Edit_SaveFormerName() throws InterruptedException
	{
		WebElement elementToScrollTo2 = getDriver().findElement(By.xpath("(//tbody)[1]"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		List<WebElement> editButtons = getDriver().findElements(By.xpath("//table[@data-cy='my-info-former-name-table']//tbody//a[1]"));
		// Generate a random index to choose a random Edit button
		Random random = new Random();
		int randomIndex = random.nextInt(editButtons.size());
		// Click on the random Edit button
		WebElement randomEditButton = editButtons.get(randomIndex);
		randomEditButton.click();
		log.debug("Editing the Former Names");
		WebElement elementToScrollFN = findElement("FirstName_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollFN);
		findElement("FirstName_ID").clear();
		Thread.sleep(500);
		findElement("FirstName_ID").sendKeys("FN Edited");
		Thread.sleep(500);
		WebElement elementToScrollLN = findElement("LastName_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollLN);
		findElement("LastName_ID").clear();
		Thread.sleep(500);
		findElement("LastName_ID").sendKeys("LN Edited");
		Thread.sleep(500);
		WebElement elementToScrollSave = findElement("SaveName_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollSave);
		click("SaveName_XPATH");
		Thread.sleep(1000);
		List<WebElement> EditedFormerNameslist1 = getDriver().findElements(By.xpath("//table[@data-cy='my-info-former-name-table']//tbody//a[1]"));
		for(WebElement X : EditedFormerNameslist1)
		{

			String Editedformernameslist1 = X.getText();
			if(Editedformernameslist1.contains("FN Edited LN Edited"))
			{
				log.debug("The Save button functionality is working fine!!!");
			}
		}
	}




	public void DeleteAddedFormerNames() throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement elementToScrollTo2 = getDriver().findElement(By.xpath("//table[@data-cy='my-info-former-name-table']//tbody"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		Thread.sleep(1000);
		List<WebElement> deleteButtons = getDriver().findElements(By.xpath("//table[@data-cy='my-info-former-name-table']//tbody//a[2]"));
		// Generate a random index to choose a random Delete button
		Random random = new Random();
		int randomIndex = random.nextInt(deleteButtons.size());
		Thread.sleep(1000);
		// Click on the random Edit button
		WebElement randomDeleteButton = deleteButtons.get(randomIndex);
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", randomDeleteButton);
		randomDeleteButton.click();
		log.debug("Deleting the Former Name");
		Thread.sleep(500);
		WebElement elementToScrollCancel = findElement("Cancel_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollCancel);
		click("Cancel_XPATH");
		Thread.sleep(1000);
		scrollUp(getDriver(), 1);
		Thread.sleep(1000);
		WebElement elementToScrollTo = getDriver().findElement(By.xpath("//table[@data-cy='my-info-former-name-table']//tbody"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		List<WebElement> deleteButtons1 = getDriver().findElements(By.xpath("//table[@data-cy='my-info-former-name-table']//tbody//a[2]"));
		int randomIndex1 = random.nextInt(deleteButtons1.size());
		// Click on the random Edit button
		WebElement randomDeleteButton1 = deleteButtons1.get(randomIndex1);
		randomDeleteButton1.click();
		log.debug("Deleting the Former Name");
		Thread.sleep(1000);
		WebElement elementToScrollDelete = findElement("Delete_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollDelete);
		click("Delete_XPATH");
		// Validate for the Deleted Former Name using Size
		List<WebElement> FormerNameslist = getDriver().findElements(By.xpath("//table[@data-cy='my-info-former-name-table']//td[1]"));
		log.debug("No. of Former Name added :"+" "+FormerNameslist.size());
		if(FormerNameslist.size()!=10)
		{
			log.debug("The Delete Functionality is working fine!!!");
		}
		else {
			log.debug("The Delete Functionality is Not working fine!!!");
		}
	}








	public void validFormer(String colKey,String colValue) throws Exception
	{




		Thread.sleep(1000);
		List<WebElement> names = getDriver().findElements(By.xpath("//table[@data-cy='my-info-former-name-table']//td[1]"));
		int i=1;
		for(WebElement name : names)
		{
			String text=getDriver().findElement(By.xpath("(//table[@data-cy='my-info-former-name-table']//td[1])["+i+"]")).getText();
			i++;
			validFormerName.add(text);
		}








		value1.set(MyInformationPage.validFormerName.get(0));
		value2.set(MyInformationPage.validFormerName.get(1));
		value3.set( MyInformationPage.validFormerName.get(2));
		value4.set(MyInformationPage.validFormerName.get(3));
		value5.set(MyInformationPage.validFormerName.get(4));
		value6.set(MyInformationPage.validFormerName.get(5));
		value7.set(MyInformationPage.validFormerName.get(6));
		value8.set(MyInformationPage.validFormerName.get(7));
		value9.set(MyInformationPage.validFormerName.get(8));




		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 6, "Former name(s)", value1.get(), value2.get(), value3.get(), value4.get(), value5.get(), value6.get(), value7.get(), value8.get(), value9.get());
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}




	public void chooseLegalSex(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo2 = getDriver().findElement(By.xpath("//span[.=' Legal sex']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		log.debug("Choose a Legal sex");
		// Choose random gender
		Thread.sleep(2000);
		List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='legal_sex_group']"));
		int Count = radioButtons.size();
		// Generate a random index
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		// Get the text of the randomly selected radio button
		String selectedGender = radioButtons.get(randomIndex).getAttribute("value");
		// Click the randomly selected radio button
		Thread.sleep(2000);
		radioButtons.get(randomIndex).click();
		Thread.sleep(1000);
		if(selectedGender.contains("M"))
		{
			gender.set("Male");
			log.debug("Selected Gender: " + "Male");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 7, "Legal sex", gender.get());
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		else {
			gender.set("Female");
			log.debug("Selected Gender: " + "Female");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 7, "Legal sex", gender.get());
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
	}




	public void ValidateProfileLink()
	{
		log.debug("Validating the Profile link");
		// validate the Text for the link
		WebElement linkElement = getDriver().findElement(By.linkText("profile"));
		// Get the href attribute value
		String hrefValue = linkElement.getAttribute("href");
		if (hrefValue != null && !hrefValue.isEmpty()) {
			log.debug("The Profile text is a link with URL: " + hrefValue);
		} else {
			log.debug("The text is not a link.");
		}
	}








	public void ChoosePrimageLanguage(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo2 = getDriver().findElement(By.xpath("//div[@id='primary_language_select']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		log.debug("Choose the Primary language");
		Thread.sleep(2000);
		//Select a random lang
		WebElement elementToScrollPrimaryLang = findElement("SelectPrimaryLangDD_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollPrimaryLang);
		click("SelectPrimaryLangDD_XPATH");
		Thread.sleep(2000);
		List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		// Generate a random index to choose a random Edit button
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		// Click on the random Edit button
		WebElement randomOption = options.get(randomIndex);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		// Get the text of the chosen random option
		String 	selectedLanguage	=	getDriver().findElement(By.xpath("//div[@id='primary_language_select']")).getText();
		log.debug("Selected Primary language option: " + selectedLanguage);
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 8, "Primary language spoken at home", selectedLanguage);
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}








	public void HomeAddAndPhone() throws Exception
	{
		Thread.sleep(2000);
		log.debug("Choose the Home address");
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement elementToScrollTo = getDriver().findElement(By.xpath("//span[.=' Home address and phone']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		getDriver().findElement(By.xpath("//div[@id='home-country-select']")).click();
		//Validate US flow
		Thread.sleep(3000);
		List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		ArrayList<Integer> randomCountry = getRandomNumber(1, options.size(), 1);
		int Options = options.size();
		for(int ran:randomCountry)
		{
			getDriver().findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+ran+"]")).click();
			Thread.sleep(1000);
		}
	}




	//to concat the city and state with the country selected  in My Info page 1
//	public static String state()
//	{
//		return stateSelected = "Test City,"+state+selectedOptionText;
//	}

	public static String state() {
	    String selectedOption = selectedOptionText.get(); // Retrieve the String value from the ThreadLocal
	    return "Test City, " + state + selectedOption;
	}


	public void Random_HomeaddressAndPhone(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{

		Thread.sleep(2000);
		log.debug("Choose the Home address");
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement elementToScrollTo = getDriver().findElement(By.xpath("//span[.=' Home address and phone']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		getDriver().findElement(By.xpath("//div[@id='home-country-select']")).click();
		//Validate US flow
		Thread.sleep(3000);
		List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		ArrayList<Integer> randomCountry = getRandomNumber(1, options.size(), 1);
		int Options = options.size();
		for(int ran:randomCountry)
		{
			getDriver().findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+ran+"]")).click();
			Thread.sleep(1000);
		}
		selectedOptionText.set(findElement("HomeCountryDD_XPATH").getText());
		log.debug("Selected Home Country: " + selectedOptionText.get());
		if(!selectedOptionText.get().contains("United States"))
		{
			WebElement elementToScrollTo1 = findElement("AddLine1_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			type("AddLine1_ID","Test Address Line I");
			WebElement elementToScrollTo11 = findElement("AddLine2_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
			type("AddLine2_ID","Test Address Line II");
			WebElement stateElement = getDriver().findElement(By.id("address_state"));
			if (stateElement.getTagName().equals("div"))
			{
				// It's a dropdown
				log.debug("State is a dropdown.");
				WebElement elementToScroll = findElement("StateDD_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
				Thread.sleep(1000);
				click("StateDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options1 = options1.size();
				// Generate a random index to choose a random State
				Random random1 = new Random();
				int randomIndex1 = random1.nextInt(options1.size());
				// Click on the random State
				WebElement randomOption = options1.get(randomIndex1);
				Thread.sleep(1000);
				randomOption.click();
				Thread.sleep(1000);
				// Get the text of the chosen random State
				String 	selectedStateText	=	getDriver().findElement(By.xpath("//div[@id='address_state']")).getText();
				state.set(getDriver().findElement(By.xpath("//div[@id='address_state']//span")).getText());
				log.debug("Selected Home State : " + selectedStateText);
			}
			else if (stateElement.getTagName().equals("input"))
			{
				// It's a textfield
				log.debug("State is a textfield.");
				type("StateTextfield_ID","Test State");
				state.set("Test State");
			}
			WebElement elementToScrollTo2 = findElement("City_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			type("City_ID","Test City");
			Thread.sleep(1000);
			WebElement elementToScrollTo3 = findElement("ZIPcode_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo3);
			type("ZIPcode_ID","12345-678910");
			Thread.sleep(1000);
			WebElement elementToScrollTo4 = findElement("PhoneNo_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
			type("PhoneNo_XPATH","6363052399");
			Thread.sleep(1000);
			WebElement elementToScrollTo5 = findElement("MobileNo_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo5);
			type("MobileNo_XPATH","8150052399");
			Thread.sleep(1000);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey,colNumValue,"validData", 9, "Home address", "Test Address Line I Test Address Line II","Test City"+","+state.get()+","+selectedOptionText.get(),"12345-678910");
			setExcelData(colNumKey,colNumValue,"validData", 10, "Phone", "6363052399");
			setExcelData(colNumKey,colNumValue,"validData", 11, "Mobile phone", "8150052399");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


		}
		if(selectedOptionText.get().contains("United States"))
		{
			log.debug("Selected Home Country :"+selectedOptionText.get());
			WebElement elementToScrollTo1 = findElement("AddLine1_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			type("AddLine1_ID","Test Address line1");
			Thread.sleep(2000);
			WebElement elementToScrollTo11 = findElement("AddLine2_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
			type("AddLine2_ID","Test Address line2");
			Thread.sleep(2000);
			WebElement stateElement = getDriver().findElement(By.id("address_state"));
			if (stateElement.getTagName().equals("div"))
			{
				// It's a dropdown
				log.debug("State is a dropdown.");
				click("StateDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options1 = options1.size();
				// Generate a random index to choose a random State
				Random random1 = new Random();
				int randomIndex1 = random1.nextInt(options1.size());
				// Click on the random State
				WebElement randomOption = options1.get(randomIndex1);
				Thread.sleep(1000);
				randomOption.click();
				Thread.sleep(1000);
				// Get the text of the chosen random State
				String 	selectedStateText	=	getDriver().findElement(By.xpath("//div[@id='address_state']")).getText();
				state.set(getDriver().findElement(By.xpath("//div[@id='address_state']//span")).getText());
				log.debug("Selected Home State : " + selectedStateText);
			}
			else if (stateElement.getTagName().equals("input"))
			{
				// It's a textfield
				log.debug("State is a textfield.");
				type("StateTextfield_ID","Test State");
				state.set("Test State");
			}
			else
			{
				// It's neither a dropdown nor a textfield
				log.debug("State is neither a dropdown nor a textfield.");
			}
			WebElement elementToScrollTo2 = findElement("City_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			type("City_ID","Test City");
			Thread.sleep(2000);
			WebElement elementToScrollTo3 = findElement("ZIPcode_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo3);
			type("ZIPcode_ID","12345-678910");
			Thread.sleep(2000);
			WebElement elementToScrollTo4 = findElement("USPhoneNo1_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
			type("USPhoneNo1_XPATH","123");
			Thread.sleep(2000);
			WebElement elementToScrollTo5 = findElement("USPhoneNo2_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo5);
			type("USPhoneNo2_XPATH","109-2345");
			Thread.sleep(2000);








			Thread.sleep(2000);
			WebElement elementToScrollTo6 = findElement("USMobileNo1_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo6);
			type("USMobileNo1_XPATH","123");








			Thread.sleep(2000);
			WebElement elementToScrollTo7 = findElement("USMobileNo2_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo7);
			type("USMobileNo2_XPATH","109-2345");








			phone.set("123-1092345") ;
			mobile.set("123-1092345");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey,colNumValue,"validData", 9, "Home address", "Test Address Line1 Test Address L ine2","Test City"+","+state.get()+","+selectedOptionText.get(),"12345-678910");
			setExcelData(colNumKey,colNumValue,"validData", 10, "Phone", phone.get());
			setExcelData(colNumKey,colNumValue,"validData", 11, "Mobile phone", mobile.get());
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}

	}








	public void address(String AddressLine1 , String AddressLine2 ,String City , String Zip, String State,String Phone_Number, String Mobile_Number) throws Exception
	{
		selectedOptionText.set(getDriver().findElement(By.xpath("//div[@id='home-country-select']")).getText());
		log.debug("Selected Home Country: " + selectedOptionText.get());
		if(!selectedOptionText.get().contains("United States"))
		{
			WebElement elementToScrollTo = findElement("AddLine1_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			type("AddLine1_ID",AddressLine1);
			Thread.sleep(2000);
			WebElement elementToScrollTo1 = findElement("AddLine2_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			type("AddLine2_ID",AddressLine2);
			Thread.sleep(2000);
			WebElement stateElement = getDriver().findElement(By.id("address_state"));
			if (stateElement.getTagName().equals("div"))
			{
				// It's a dropdown
				log.debug("State is a dropdown.");
				WebElement elementToScroll = findElement("StateDD_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
				Thread.sleep(1000);
				click("StateDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options = options.size();
				// Generate a random index to choose a random State
				Random random1 = new Random();
				int randomIndex1 = random1.nextInt(options.size());
				// Click on the random State
				WebElement randomOption = options.get(randomIndex1);
				Thread.sleep(1000);
				randomOption.click();
				Thread.sleep(1000);
				// Get the text of the chosen random State
				String 	selectedStateText	=	getDriver().findElement(By.xpath("//div[@id='address_state']")).getText();
				state.set(getDriver().findElement(By.xpath("//div[@id='address_state']//span")).getText());
				log.debug("Selected Home State : " + selectedStateText);
			}
			else if (stateElement.getTagName().equals("input"))
			{
				// It's a textfield
				log.debug("State is a textfield.");
				type("StateTextfield_ID",State);
				state.set("Test State");
			}
			else
			{
				// It's neither a dropdown nor a textfield
				log.debug("State is neither a dropdown nor a textfield.");
			}
			WebElement elementToScrollTo2 = findElement("City_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			type("City_ID",City);
			Thread.sleep(2000);
			WebElement elementToScrollTo3 = findElement("ZIPcode_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo3);
			type("ZIPcode_ID",Zip);
			Thread.sleep(2000);
			WebElement elementToScrollTo4 = findElement("PhoneNo_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
			type("PhoneNo_XPATH",Phone_Number);
			Thread.sleep(2000);
			WebElement elementToScrollTo5 = findElement("MobileNo_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo5);
			type("MobileNo_XPATH",Mobile_Number);
			Thread.sleep(2000);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey,colNumValue,"validData", 9, "Home address", "Test Address line1 Test Address line2",City+","+state.get()+","+selectedOptionText.get(),"12345-678910");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey,colNumValue,"validData", 10, "Phone", Phone_Number);
			setExcelData(colNumKey,colNumValue,"validData", 11, "Mobile phone", Mobile_Number);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


		}
		if(selectedOptionText.get().contains("United States"))
		{
			log.debug("Selected Home Country :"+selectedOptionText.get());
			WebElement elementToScrollTo = findElement("AddLine1_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			type("AddLine1_ID",AddressLine1);
			Thread.sleep(2000);
			WebElement elementToScrollTo1 = findElement("AddLine2_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			type("AddLine2_ID",AddressLine2);
			Thread.sleep(2000);
			WebElement stateElement = getDriver().findElement(By.id("address_state"));
			if (stateElement.getTagName().equals("div"))
			{
				// It's a dropdown
				log.debug("State is a dropdown.");
				click("StateDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options = options.size();
				// Generate a random index to choose a random State
				Random random1 = new Random();
				int randomIndex1 = random1.nextInt(options.size());
				// Click on the random State
				WebElement randomOption = options.get(randomIndex1);
				Thread.sleep(1000);
				randomOption.click();
				Thread.sleep(1000);
				// Get the text of the chosen random State
				String 	selectedStateText	=	getDriver().findElement(By.xpath("//div[@id='address_state']")).getText();
				state.set(getDriver().findElement(By.xpath("//div[@id='address_state']//span")).getText());
				log.debug("Selected Home State : " + selectedStateText);
			}
			else if (stateElement.getTagName().equals("input"))
			{
				// It's a textfield
				log.debug("State is a textfield.");
				type("StateTextfield_ID",State);
				state.set("Test State");
			}
			else
			{
				// It's neither a dropdown nor a textfield
				log.debug("State is neither a dropdown nor a textfield.");
			}
			WebElement elementToScrollTo2 = findElement("City_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			type("City_ID",City);
			Thread.sleep(2000);
			WebElement elementToScrollTo3 = findElement("ZIPcode_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo3);
			type("ZIPcode_ID",Zip);
			Thread.sleep(2000);
			WebElement elementToScrollTo4 = findElement("USPhoneNo1_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
			type("USPhoneNo1_XPATH","111");
			Thread.sleep(2000);
			WebElement elementToScrollTo5 = findElement("USPhoneNo2_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo5);
			type("USPhoneNo2_XPATH","111-1111");
			Thread.sleep(2000);








			Thread.sleep(2000);
			WebElement elementToScrollTo6 = findElement("USMobileNo1_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo6);
			type("USMobileNo1_XPATH","000");








			Thread.sleep(2000);
			WebElement elementToScrollTo7 = findElement("USMobileNo2_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo7);
			type("USMobileNo2_XPATH","000-0000");








			phone.set("111-1111111") ;
			mobile.set("000-0000000");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey,colNumValue,"validData", 9, "Home address", "Test Address line1 Test Address line2",City+","+state.get()+","+selectedOptionText.get(),"12345-678910");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey,colNumValue,"validData", 10, "Phone", Phone_Number);
			setExcelData(colNumKey,colNumValue,"validData", 11, "Mobile phone", Mobile_Number);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
	}






	public void validateAddress(String AddressLine1 , String AddressLine2 ,String City , String Zip, String State, String Phone_Number,String Mobile_Number)
	{
		//error message validation for addressline 1
		try
		{
			if(AddressLine1.length() > 42)
			{
				String errorAddressLine1 = getDriver().findElement(By.xpath("//input[@id='address_line_1_input']/following-sibling::div[contains(text(),' Should not be more than 42 characters. ')]")).getText();
				Assert.assertEquals(errorAddressLine1, "Should not be more than 42 characters.");
				findElement("AddLine1_ID").clear();
			}
		}catch(Exception e) {}
		//error message validation for addressline2
		try
		{
			if(AddressLine2.length() > 42)
			{
				String errorAddressLine2 = getDriver().findElement(By.xpath("//input[@id='address_line_2_input']/following-sibling::div[contains(text(),' Should not be more than 42 characters. ')]")).getText();
				Assert.assertEquals(errorAddressLine2, "Should not be more than 42 characters.");
				findElement("AddLine2_ID").clear();
			}
		}catch(Exception e) {}
		//error message validation for city
		try
		{
			if(City.length()>30)
			{
				String errorCity = getDriver().findElement(By.xpath("//input[@id='city_input']/following-sibling::div[contains(text(),' The city should not be more than 30 characters. ')]")).getText();
				Assert.assertEquals(errorCity, "The city should not be more than 30 characters.");
				findElement("City_ID").clear();
			}
		}catch(Exception e) {}
		//error message validation for zip
		try
		{
			if(Zip.length()>12)
			{
				String errorZipCode12 = findElement("errorZipCode12_XPATH").getText();
				Assert.assertEquals(errorZipCode12, "The zip/postal code should not be more than 12 characters.");
				findElement("ZIPcode_ID").clear();
			}
		}catch(Exception e) {}
		try
		{
			if(State.length()>30)
			{
				String errorState = getDriver().findElement(By.xpath("//input[@id='address_state']/following-sibling::div[contains(text(),' The state should not be more than 30 characters. ')]")).getText();
				Assert.assertEquals(errorState, "The state should not be more than 30 characters.");
				findElement("StateTextfield_ID").clear();
			}
		}catch(Exception e) {}
		//error message validation for Phone Number
		try
		{
			String errorPhoneNo = findElement("PhoneNoErr_XPATH").getText();
			Assert.assertEquals(errorPhoneNo, "Number can contain only numeric and plus (+) at the beginning.");
			findElement("PhoneNo_XPATH").clear();
		}
		catch(Exception e) {}
		//error message validation for Mobile Number
		try
		{
			String errorMobileNo = findElement("MobileNoErr_XPATH").getText();
			Assert.assertEquals(errorMobileNo, "Number can contain only numeric and plus (+) at the beginning.");
			findElement("MobileNo_XPATH").clear();
		}
		catch(Exception e) {}
	}








	public void EthnicRacialbackground(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		Thread.sleep(2000);
		WebElement elementToScrollTo2 = getDriver().findElement(By.xpath("//span[.='Ethnic/racial background']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		Thread.sleep(2000);
		log.debug("Choose the Ethnicity");
		// Choose Ethnicity randomly -- YES or NO
		List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='hispanic_latino_radio']"));
		int Count = radioButtons.size();
		// Generate a random index
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		// Get the text of the randomly selected radio button
		String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons.get(randomIndex).click();
		if(selectedOption.contains("Y"))
		{
			log.debug("Are you Hispanic/Latino?" + "Yes");




			WebElement elementToScrollTo = findElement("EthnicityDD_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			click("EthnicityDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options = options.size();
			// Generate a random index to choose a random option
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options.size());
			// Click on the random option
			WebElement randomOption = options.get(randomIndex1);
			Thread.sleep(1000);
			randomOption.click();
			Thread.sleep(1000);
			// Get the text of the chosen random option
			String 	selectedEthnicityOptionText	=	getDriver().findElement(By.xpath("//div[@id='hispanic_latino_origin']")).getText();
			log.debug("Selected Hispanic/Latino origin option: " + selectedEthnicityOptionText);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",selectedEthnicityOptionText);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


		}
		else {
			log.debug("Are you Hispanic/Latino?" +" " +"No");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ","None");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


		}


		WebElement elementToScrollTo21 = findElement("RacialDD_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
		log.debug("Choose the Race");
		click("RacialDD_XPATH");
		Thread.sleep(2000);
		List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random2 = new Random();
		int randomIndex2 = random2.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex2);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		System.out.println("Clicked on RAce option");
		//CLOSE THE DD----------------------
		Actions actions = new Actions(getDriver());
		WebElement element = findElement("RacialDD_XPATH");
		actions.sendKeys(element, "\uE00C").perform();
		// Get the text of the chosen random option
		WebElement elementToScrollTo = findElement("RacialDD_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		String 	SelectedRace	=	getDriver().findElement(By.xpath("//div[@id='applicants_race']//span")).getText();
		log.debug("Selected Race option: " + SelectedRace);


		if(SelectedRace.contains("White"))
		{
			log.debug("Applicant race :"+" "+SelectedRace);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",SelectedRace);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		if(SelectedRace.contains("Black or African American"))
		{
			log.debug("Applicant race :"+" "+SelectedRace);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",SelectedRace);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		if(SelectedRace.contains("Asian"))
		{
			// Select random Asian race
			WebElement elementToScrollTo211 = findElement("AsianDD_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo211);
			click("AsianDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> Asianoptions = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Asianoptionslist = Asianoptions.size();
			Random randomlist1 = new Random();
			int randomIndex1 = randomlist1.nextInt(Asianoptions.size());
			WebElement randomOption1 = Asianoptions.get(randomIndex1);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			// Get the text of the chosen random option
			String 	selectedOptionText1	=	getDriver().findElement(By.xpath("//div[@id='Asian_origin']")).getText();
			log.debug("Selected Asian option: " + selectedOptionText1);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",selectedOptionText1);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		if(SelectedRace.contains("American Indian/Alaska Native"))
		{
			// Select random American Indian/Alaska Native race
			WebElement elementToScrollTo211 = findElement("AmericanAlaskaDD_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo211);
			click("AmericanAlaskaDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> AmericanAlaskaOptions = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int AmericanAlaskaOptionslist = AmericanAlaskaOptions.size();
			Random randomlist1 = new Random();
			int randomIndex1 = randomlist1.nextInt(AmericanAlaskaOptions.size());
			WebElement randomOption1 = AmericanAlaskaOptions.get(randomIndex1);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			// Get the text of the chosen random option
			String 	selectedOptionText1	=	getDriver().findElement(By.xpath("//div[@id='American Indian/Alaska Native_origin']")).getText();
			log.debug("Selected American Indian/Alaska Native option: " + selectedOptionText1);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",selectedOptionText1);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		if(SelectedRace.contains("Native Hawaiian/Pac Islander"))
		{
			// Select random Native Hawaiian/Pace race
			WebElement elementToScrollTo211 = findElement("NativeHawaiianPacIslanderDD_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo211);
			click("NativeHawaiianPacIslanderDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> NativeHawaiianPacIslanderOptions = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int NativeHawaiianPacIslanderOptionslist = NativeHawaiianPacIslanderOptions.size();
			Random randomlist1 = new Random();
			int randomIndex1 = randomlist1.nextInt(NativeHawaiianPacIslanderOptions.size());
			WebElement randomOption1 = NativeHawaiianPacIslanderOptions.get(randomIndex1);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			// Get the text of the chosen random option
			String 	selectedOptionText1	=	getDriver().findElement(By.xpath("//div[@id='Native Hawaiian/Pac Islander_origin']")).getText();
			log.debug("Selected Native Hawaiian/Pac Islander option: " + selectedOptionText1);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",selectedOptionText1);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




		}
		if (isElementPresent("PrimaryRaceHeader_XPATH")) 
		{
			// Element is present, perform your actions here
			WebElement elementToScrollTo1 = findElement("PrimaryRaceHeader_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			WebElement element1 = findElement("PrimaryRaceHeader_XPATH");
			if(element1.isDisplayed())
			{
				log.debug("Choose the Primary Race");	
				WebElement elementToScroll = findElement("PrimaryRaceDD_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
				click("PrimaryRaceDD_XPATH");
				Thread.sleep(2000);
				List<WebElement> PrimaryRaceOptions = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int PrimaryRaceOptionslist = PrimaryRaceOptions.size();
				Random randomRacelist = new Random();
				int randomIndex3 = randomRacelist.nextInt(PrimaryRaceOptions.size());
				WebElement randomOption3 = PrimaryRaceOptions.get(randomIndex3);
				randomOption3.click();

				// Get the text of the chosen random option
				String 	ReportingPreferred	=	getDriver().findElement(By.xpath("//div[@id='primary_race_select']")).getText();
				log.debug("Selected Primary Race option: " + ReportingPreferred);
				String 	selectedEthnicityOptionText	=	getDriver().findElement(By.xpath("//div[@id='hispanic_latino_origin']")).getText();
				log.debug("ReportingPreferred :"+ReportingPreferred);
				log.debug("selectedEthnicityOptionText :"+selectedEthnicityOptionText);




				if(SelectedRace.equals("White") || SelectedRace.equals("Black or African American"))
				{
					if(ReportingPreferred.equals(SelectedRace))
					{
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",SelectedRace+" (Reporting Preferred)",selectedEthnicityOptionText);
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}
					if(ReportingPreferred.equals(selectedEthnicityOptionText))
					{

						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",selectedEthnicityOptionText+" (Reporting Preferred)",SelectedRace);
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}

				}
				if(SelectedRace.equals("Asian") || SelectedRace.equals("Native Hawaiian/Pac Islander")|| SelectedRace.equals("American Indian/Alaska Native"))
				{
					WebElement elementTo = findElement("SubRaceDD_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementTo);
					String SelectedSubRaceDD =	findElement("SubRaceDD_XPATH").getText();
					if(ReportingPreferred.equals(SelectedSubRaceDD))
					{
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",SelectedSubRaceDD+" (Reporting Preferred)",selectedEthnicityOptionText);
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}
					if(ReportingPreferred.equals(selectedEthnicityOptionText))
					{

						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",selectedEthnicityOptionText+" (Reporting Preferred)",SelectedSubRaceDD);
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}
				}
			}
		}
		else 
		{
			// Element is not present, handle the situation accordingly
			log.debug("Primary Race header element is not available");
		}
	}


	public void Random_Citizenship(String colKey,String colValue) throws Exception
	{
		// Randomly selects the Citizenship - Either I am a U.S. citizen OR I am not a U.S. citizen
		WebElement elementToScrollTo2 = findElement("USCitizen_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		log.debug("Choose the Citizenship");
		Thread.sleep(2000);
		List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='us_citizen_radio']"));
		int Count = radioButtons.size();
		// Generate a random index
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		String selectedCitizenship = radioButtons.get(randomIndex).getAttribute("value");
		Thread.sleep(1000);
		radioButtons.get(randomIndex).click();
		Thread.sleep(1000);
		if(selectedCitizenship.contains("true"))
		{
			Citizenship.set("Resident");
			log.debug("Selected option: " + "I am a U.S. citizen");
			Thread.sleep(1000);
			WebElement elementToScrollTo3 = findElement("CountryOfBirthDD_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo3);
			log.debug("Choose the Country of Birth");
			click("CountryOfBirthDD_XPATH");
			Thread.sleep(700);
			List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options = options.size();
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options.size());
			// Click on the random option
			WebElement randomOption = options.get(randomIndex1);
			Thread.sleep(500);
			randomOption.click();
			Thread.sleep(500);
			selectedCountryOfBirthOptionText.set(getDriver().findElement(By.xpath("//div[@id='country_of_birth']")).getText());
			log.debug("Selected option: " + selectedCountryOfBirthOptionText.get());
			Thread.sleep(1000);
			// Generate random 9 digit SSN Number
			Random random11 = new Random();
			int randomNineDigitNumber;
			do {
				randomNineDigitNumber = random11.nextInt(900000000) + 100000000;
			} while (randomNineDigitNumber == 100000000);
			// Convert the random number to a string
			String randomNumberString = String.valueOf(randomNineDigitNumber);
			// Send the random SSN number to the text field
			WebElement elementToScrollTo4 = findElement("SSN_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
			type("SSN_XPATH",randomNumberString);

			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 13, "U.S. citizenship", "I am a U.S. citizen");
			setExcelData(colKey,colValue,"validData", 14, "Country of citizenship", "United States");
			setExcelData(colKey,colValue,"validData", 15, "Country of birth", selectedCountryOfBirthOptionText.get());
			setExcelData(colKey,colValue,"validData", 16, "Social Security Number", "*********");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		if(selectedCitizenship.contains("false")) 
		{
			log.debug("Selected option: " + "I am not a U.S. citizen");
			WebElement elementToScrollTo21 = findElement("visaTypeDropdown_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
			Thread.sleep(1500);
			log.debug("Choose the type of Visa");
			Thread.sleep(1000);
			click("visaTypeDropdown_XPATH");
			Thread.sleep(1000);
			List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options = options.size();
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options.size());
			WebElement randomOption = options.get(randomIndex1);
			Thread.sleep(1000);
			randomOption.click();
			Thread.sleep(1000);
			// Get the text of the chosen random option
			String 	Visatype	=	findElement("visaTypeDropdown_XPATH").getText();
			log.debug("Selected type of Visa : " + Visatype);
			if(Visatype.equals("Permanent resident")|| Visatype.equals("Refugee"))			
			{
				Citizenship.set("Resident");
			}
			if(Visatype.equals("Deferred Action for Childhood Arrivals (DACA)")|| Visatype.equals("International attending ASU Online programs only (JN)")|| Visatype.equals("Student (F-1)")||Visatype.equals("Exchange Visitor (J-1)")   )			
			{
				Citizenship.set("Non Resident");
			}

			// Selects - Permanent Resident OR DACA OR Refugee OR JN
			if(Visatype.equals("Permanent resident")|| Visatype.equals("Deferred Action for Childhood Arrivals (DACA)")|| Visatype.equals("Refugee")|| Visatype.equals("International attending ASU Online programs only (JN)"))
			{
				WebElement elementToScrollTo211 = findElement("countryOfCitizenship_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo211);
				findElement("countryOfCitizenship_XPATH").click();
				Thread.sleep(500);
				List<WebElement> coun = getDriver().findElements(By.xpath("//ul[@role='listbox']//li"));
				ArrayList<Integer> randomCoun = getRandomNumber(0, coun.size(), 1);
				for(int ran:randomCoun)
				{
					Thread.sleep(2000);
					getDriver().findElement(By.xpath("(//ul[@role='listbox']//li)["+ran+"]")).click();	
					Thread.sleep(1000);	
				}
				click("CountryOfBirthDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> birth = getDriver().findElements(By.xpath("//ul[@role='listbox']//li"));
				ArrayList<Integer> randombirth = getRandomNumber(0, birth.size(), 1);
				for(int ran:randombirth)
				{
					Thread.sleep(1000);	
					getDriver().findElement(By.xpath("(//ul[@role='listbox']//li)["+ran+"]")).click();
					Thread.sleep(1000);		
				}

				WebElement elementToScrollTo = findElement("countryOfCitizenship_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				String countryOfCitizenship = findElement("countryOfCitizenship_XPATH").getText();
				WebElement elementToScrollTo1 = findElement("CountryOfBirthDD_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				String CountryOfBirth = findElement("CountryOfBirthDD_XPATH").getText();

				// Generate random 9 digit SSN Number
				Random random12 = new Random();
				int randomNineDigitNumber;
				do {
					randomNineDigitNumber = random12.nextInt(900000000) + 100000000;
				} while (randomNineDigitNumber == 100000000);
				String randomNumberString = String.valueOf(randomNineDigitNumber);
				WebElement elementToScrollTo4 = findElement("SSN_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
				type("SSN_XPATH",randomNumberString);
				Thread.sleep(1000);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData", 13, "U.S. citizenship", "I am not a U.S. citizen");
				setExcelData(colKey,colValue,"validData", 14, "Which type of visa will you be holding?", Visatype);
				setExcelData(colKey,colValue,"validData", 15, "Country of citizenship",countryOfCitizenship);
				setExcelData(colKey,colValue,"validData", 16, "Country of birth", CountryOfBirth);
				setExcelData(colKey,colValue,"validData", 17, "Social Security Number", "*********");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}
			// Selects F-1 
			if(Visatype.equals("Student (F-1)"))
			{
				WebElement elementToScrollTo211 = findElement("countryOfCitizenship_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo211);
				click("countryOfCitizenship_XPATH");
				Thread.sleep(1000);
				List<WebElement> options1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options1 = options1.size();
				Random random11 = new Random();
				int randomIndex11 = random11.nextInt(options1.size());
				WebElement randomOption1 = options1.get(randomIndex11);
				Thread.sleep(500);
				randomOption1.click();
				Thread.sleep(500);
				click("CountryOfBirthDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options11 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options11 = options11.size();
				Random random111 = new Random();
				int randomIndex111 = random111.nextInt(options11.size());
				WebElement randomOption11 = options11.get(randomIndex111);
				Thread.sleep(500);
				randomOption11.click();
				Thread.sleep(500);
				WebElement elementToScrollTo2111 = findElement("CityOfBirth_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2111);
				type("CityOfBirth_ID","Test City");
				Thread.sleep(1000);

				String countryOfCitizenship = findElement("countryOfCitizenship_XPATH").getText();
				String	CountryOfBirth =  findElement("CountryOfBirthDD_XPATH").getText();

				// Generate random 9 digit SSN Number
				Random random13 = new Random();
				int randomNineDigitNumber;
				do {
					randomNineDigitNumber = random13.nextInt(900000000) + 100000000;
				} while (randomNineDigitNumber == 100000000);
				// Convert the random number to a string
				String randomNumberString = String.valueOf(randomNineDigitNumber);
				// Send the random SSN number to the text field
				WebElement elementToScrollTo4 = findElement("SSN_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
				type("SSN_XPATH",randomNumberString);
				Thread.sleep(2000);
				List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='issuing_i20_radio']"));
				Random random1111 = new Random();
				int randomIndex13 = random1111.nextInt(radioButtons1.size());
				String selectedoption = radioButtons1.get(randomIndex13).getAttribute("value");
				Thread.sleep(2000);
				radioButtons1.get(randomIndex13).click();
				Thread.sleep(1000);
				if(selectedoption.contains("yes"))
				{
					CurrentlyInUS.set("Yes");
					log.debug("Selected Option: " + "Yes");
				}
				if(selectedoption.contains("no"))
				{
					CurrentlyInUS.set("No");
					log.debug("Selected Option: " + "No");
				}

				if(selectedOptionText.get().contains("United States"))
				{
					// Validate the International address
					log.debug("Choose the International Address");
					// Select a International country
					WebElement elementToScrollTo21111 = findElement("IntCountry_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21111);
					click("IntCountry_ID");
					Thread.sleep(1000);
					List<WebElement> options111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
					int Options12 = options111.size();
					Random random112 = new Random();
					int randomIndex112 = random112.nextInt(options111.size());
					WebElement randomOption21 = options111.get(randomIndex112);
					Thread.sleep(500);
					randomOption21.click();
					Thread.sleep(500);

					WebElement elementToScrollTo = findElement("AddLine1_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
					type("AddLine1_ID","AddressLine1");
					Thread.sleep(500);
					WebElement elementToScrollTo1 = findElement("AddLine2_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
					type("AddLine2_ID","AddressLine2");
					Thread.sleep(500);
					WebElement elementToScrollTo11 = findElement("IntCity_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
					type("IntCity_ID","Test City");
					Thread.sleep(1000);
					WebElement stateElement = findElement("IntState_ID"); 
					if (stateElement.getTagName().equals("div")) 
					{
						// It's a dropdown
						log.debug("State is a dropdown.");
						click("IntState_ID");
						Thread.sleep(1000);
						List<WebElement> options113  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
						int Options111 = options113.size();
						Random random1113 = new Random();
						int randomIndex1111 = random1113.nextInt(options113.size());
						WebElement randomOption111 = options113.get(randomIndex1111);
						Thread.sleep(1000);
						randomOption111.click();
						Thread.sleep(1000);
						String 	selectedStateText	=	findElement("IntState_ID").getText();
						log.debug("Selected  State: " + selectedStateText);
						RecentState.set(selectedStateText);
					}
					else if (stateElement.getTagName().equals("input")) 
					{
						// It's a textfield
						log.debug("State is a textfield.");
						Thread.sleep(1000);
						type("SchoolStateTextfield_XPATH","Test state");
						log.debug("Selected  State: " + "Test state");
						RecentState.set("Test state");
					}
					WebElement elementToScrollTo111 = findElement("IntZipCode_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
					type("IntZipCode_ID","123456-78910");
					Thread.sleep(500);

					// Choose the I - 20 shipping address
					log.debug("Choose the I-20 shipping address");
					WebElement elementToScrollTo211111 = findElement("ShippingAddDD_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo211111);
					click("ShippingAddDD_ID");
					Thread.sleep(1000);
					List<WebElement> options1111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
					int Options121 = options1111.size();
					Random random1121 = new Random();
					int randomIndex1121 = random1121.nextInt(options1111.size());
					WebElement randomOption211 = options1111.get(randomIndex1121);
					Thread.sleep(500);
					randomOption211.click();
					Thread.sleep(500);
					String I20add = findElement("ShippingAddDD_ID").getText();
					if(I20add.equals("Other"))	
					{
						WebElement elementToScrollTo2111111 = findElement("SAcountry_ID");
						this.js = (JavascriptExecutor) getDriver();
						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2111111);
						click("SAcountry_ID");
						Thread.sleep(1000);
						List<WebElement> options11111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
						int Options1213 = options11111.size();
						Random random11213 = new Random();
						int randomIndex11213 = random11213.nextInt(options11111.size());
						WebElement randomOption2113 = options11111.get(randomIndex11213);
						Thread.sleep(500);
						randomOption2113.click();
						Thread.sleep(500);

						WebElement elementToScrollTo12 = findElement("SAaddline1_ID");
						this.js = (JavascriptExecutor) getDriver();
						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo12);
						type("SAaddline1_ID","AddressLine1");
						Thread.sleep(500);
						WebElement elementToScrollTo112 = findElement("SAaddline2_ID");
						this.js = (JavascriptExecutor) getDriver();
						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo112);
						type("SAaddline2_ID","AddressLine2");
						Thread.sleep(500);
						WebElement elementToScrollTo1112 = findElement("SAcity_ID");
						this.js = (JavascriptExecutor) getDriver();
						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1112);
						type("SAcity_ID","Test City");
						Thread.sleep(1000);
						WebElement stateElement1 = findElement("SAstate_ID"); 
						if (stateElement1.getTagName().equals("div")) 
						{
							log.debug("State is a dropdown.");
							click("SAstate_ID");
							Thread.sleep(1000);
							List<WebElement> options113  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
							int Options111 = options113.size();
							Random random1113 = new Random();
							int randomIndex1111 = random1113.nextInt(options113.size());
							WebElement randomOption111 = options113.get(randomIndex1111);
							Thread.sleep(1000);
							randomOption111.click();
							Thread.sleep(1000);
							String 	selectedStateText	=	findElement("SAstate_ID").getText();
							log.debug("Selected State: " + selectedStateText);
							RecentState.set(selectedStateText);
						}
						else if (stateElement1.getTagName().equals("input")) 
						{
							log.debug("State is a textfield.");
							Thread.sleep(1000);
							type("SchoolStateTextfield_XPATH","Test state");
							log.debug("Selected State: " + "Test state");
							RecentState.set("Test state");
						}
						WebElement elementToScrollTo1111 = findElement("SAzip_ID");
						this.js = (JavascriptExecutor) getDriver();
						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
						type("SAzip_ID","123456-78910");
						Thread.sleep(500);
					}
				}

				if(!selectedOptionText.get().contains("United States"))
				{
					// Choose the I - 20 shipping address
					log.debug("Choose the I-20 shipping address");
					WebElement elementToScrollTo21111 = findElement("ShippingAddDD_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21111);
					click("ShippingAddDD_ID");
					Thread.sleep(1000);
					List<WebElement> options111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
					int Options121 = options111.size();
					Random random1121 = new Random();
					int randomIndex1121 = random1121.nextInt(options111.size());
					WebElement randomOption211 = options111.get(randomIndex1121);
					Thread.sleep(500);
					randomOption211.click();
					Thread.sleep(500);
					String I20add = findElement("ShippingAddDD_ID").getText();
					if(I20add.equals("Other"))	
					{
						WebElement elementToScrollTo211111 = findElement("SAcountry_ID");
						this.js = (JavascriptExecutor) getDriver();
						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo211111);
						click("SAcountry_ID");
						Thread.sleep(1000);
						List<WebElement> options1111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
						int Options1213 = options1111.size();
						Random random11213 = new Random();
						int randomIndex11213 = random11213.nextInt(options1111.size());
						WebElement randomOption2113 = options1111.get(randomIndex11213);
						Thread.sleep(500);
						randomOption2113.click();
						Thread.sleep(500);

						WebElement elementToScrollTo12 = findElement("SAaddline1_ID");
						this.js = (JavascriptExecutor) getDriver();
						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo12);
						type("SAaddline1_ID","AddressLine1");
						Thread.sleep(500);
						WebElement elementToScrollTo112 = findElement("SAaddline2_ID");
						this.js = (JavascriptExecutor) getDriver();
						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo112);
						type("SAaddline2_ID","AddressLine2");
						Thread.sleep(500);
						WebElement elementToScrollTo1112 = findElement("SAcity_ID");
						this.js = (JavascriptExecutor) getDriver();
						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1112);
						type("SAcity_ID","Test City");
						Thread.sleep(1000);
						WebElement stateElement1 = findElement("SAstate_ID"); 
						if (stateElement1.getTagName().equals("div")) 
						{
							log.debug("State is a dropdown.");
							click("SAstate_ID");
							Thread.sleep(1000);
							List<WebElement> options113  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
							int Options111 = options113.size();
							Random random1113 = new Random();
							int randomIndex1111 = random1113.nextInt(options113.size());
							WebElement randomOption111 = options113.get(randomIndex1111);
							Thread.sleep(1000);
							randomOption111.click();
							Thread.sleep(1000);
							String 	selectedStateText	=	findElement("SAstate_ID").getText();
							log.debug("Selected State: " + selectedStateText);
							RecentState.set(selectedStateText);

						}
						else if (stateElement1.getTagName().equals("input")) 
						{
							log.debug("State is a textfield.");
							Thread.sleep(1000);
							type("SAstate_ID","Test state");
							log.debug("Selected State: " + "Test state");
							RecentState.set("Test state");
						}
						WebElement elementToScrollTo1111 = findElement("SAzip_ID");
						this.js = (JavascriptExecutor) getDriver();
						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
						type("SAzip_ID","123456-78910");
						Thread.sleep(500);
					}
				}

				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData", 13, "U.S. citizenship", "I am not a U.S. citizen");
				setExcelData(colKey,colValue,"validData", 14, "Which type of visa will you be holding?", Visatype);
				setExcelData(colKey,colValue,"validData", 15, "Country of citizenship",countryOfCitizenship);
				setExcelData(colKey,colValue,"validData", 16, "Country of birth", CountryOfBirth);
				setExcelData(colKey,colValue,"validData", 17, "Social Security Number", "*********");
				setExcelData(colKey,colValue,"validData", 18, "For the purposes of issuing an I-20 and obtaining a Student Visa, are you currently in the United States on any kind of Student Visa?", CurrentlyInUS.get());
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

			}
			if(Visatype.equals("Exchange Visitor (J-1)"))
			{
				WebElement elementToScrollTo211 = findElement("countryOfCitizenship_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo211);
				click("countryOfCitizenship_XPATH");
				Thread.sleep(1000);
				List<WebElement> options1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options1 = options1.size();
				Random random11 = new Random();
				int randomIndex11 = random11.nextInt(options1.size());
				WebElement randomOption1 = options1.get(randomIndex11);
				Thread.sleep(500);
				randomOption1.click();
				Thread.sleep(500);
				click("CountryOfBirthDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options11 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options11 = options11.size();
				Random random111 = new Random();
				int randomIndex111 = random111.nextInt(options11.size());
				WebElement randomOption11 = options11.get(randomIndex111);
				Thread.sleep(500);
				randomOption11.click();
				Thread.sleep(500);
				String countryOfCitizenship = findElement("countryOfCitizenship_XPATH").getText();
				String	CountryOfBirth =  findElement("CountryOfBirthDD_XPATH").getText();

				// Generate random 9 digit SSN Number
				Random random1121 = new Random();
				int randomNineDigitNumber;
				do {
					randomNineDigitNumber = random1121.nextInt(900000000) + 100000000;
				} while (randomNineDigitNumber == 100000000);
				// Convert the random number to a string
				String randomNumberString = String.valueOf(randomNineDigitNumber);
				// Send the random SSN number to the text field
				WebElement elementToScrollTo4 = findElement("SSN_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
				type("SSN_XPATH",randomNumberString);
				Thread.sleep(2000);
				List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='issuing_i20_radio']"));
				Random random1111 = new Random();
				int randomIndex21 = random1111.nextInt(radioButtons1.size());
				String selectedoption = radioButtons1.get(randomIndex21).getAttribute("value");
				Thread.sleep(2000);
				radioButtons1.get(randomIndex21).click();
				Thread.sleep(1000);
				if(selectedoption.contains("yes"))
				{
					CurrentlyInUS.set("Yes");
					log.debug("Selected Option: " + "Yes");
				}
				if(selectedoption.contains("no"))
				{
					CurrentlyInUS.set("No");
					log.debug("Selected Option: " + "No");
				}
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData", 13, "U.S. citizenship", "I am not a U.S. citizen");
				setExcelData(colKey,colValue,"validData", 14, "Which type of visa will you be holding?", Visatype);
				setExcelData(colKey,colValue,"validData", 15, "Country of citizenship",countryOfCitizenship);
				setExcelData(colKey,colValue,"validData", 16, "Country of birth", CountryOfBirth);
				setExcelData(colKey,colValue,"validData", 17, "Social Security Number", "*********");
				setExcelData(colKey,colValue,"validData", 18, "For the purposes of issuing an I-20 and obtaining a Student Visa, are you currently in the United States on any kind of Student Visa?", CurrentlyInUS.get());
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}
			if(Visatype.equals("Other"))
			{
				WebElement elementToScrollTo211 = findElement("countryOfCitizenship_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo211);
				click("countryOfCitizenship_XPATH");
				Thread.sleep(1000);
				List<WebElement> options1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options1 = options1.size();
				Random random11 = new Random();
				int randomIndex11 = random11.nextInt(options1.size());
				WebElement randomOption1 = options1.get(randomIndex11);
				Thread.sleep(500);
				randomOption1.click();
				Thread.sleep(500);
				click("CountryOfBirthDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options11 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options11 = options11.size();
				Random random111 = new Random();
				int randomIndex111 = random111.nextInt(options11.size());
				WebElement randomOption11 = options11.get(randomIndex111);
				Thread.sleep(500);
				randomOption11.click();
				Thread.sleep(500);
				String countryOfCitizenship = findElement("countryOfCitizenship_XPATH").getText();
				String	CountryOfBirth =  findElement("CountryOfBirthDD_XPATH").getText();

				// Generate random 9 digit SSN Number
				Random random1121 = new Random();
				int randomNineDigitNumber;
				do {
					randomNineDigitNumber = random1121.nextInt(900000000) + 100000000;
				} while (randomNineDigitNumber == 100000000);
				// Convert the random number to a string
				String randomNumberString = String.valueOf(randomNineDigitNumber);
				// Send the random SSN number to the text field
				WebElement elementToScrollTo4 = findElement("SSN_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
				type("SSN_XPATH",randomNumberString);
				Thread.sleep(1000);
				WebElement elementToScrollTo = findElement("OtherVisaChoices_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				click("OtherVisaChoices_ID");
				Thread.sleep(2000);
				List<WebElement> options14  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options13 = options14.size();
				Random random13 = new Random();
				int randomIndex13 = random13.nextInt(options14.size());
				WebElement randomOption13 = options14.get(randomIndex13);
				Thread.sleep(1000);
				randomOption13.click();
				Thread.sleep(1000);
				String 	selectedVisaChoices	=	findElement("OtherVisaChoices_ID").getText();
				log.debug("Selected Visa choice option: " + selectedVisaChoices);
				String ChoosenVisaValidORInvalid = findVisaType(selectedVisaChoices);
				System.out.println("The visa type for '" + selectedVisaChoices + "' is: " + ChoosenVisaValidORInvalid);
				log.debug("The visa type for '" + selectedVisaChoices + "' is: " + ChoosenVisaValidORInvalid);
				if(ChoosenVisaValidORInvalid.equals("Invalid Visa"))
				{
					Citizenship.set("Not Resident");
				}
				if(ChoosenVisaValidORInvalid.equals("Valid Visa"))
				{
					Citizenship.set("Resident");
				}

			}

		}

	}






	public void US_Citizenship(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo2 = findElement("USCitizen_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		log.debug("Choose the Citizenship as U.S Citizen");
		// Click on I am a U.S citizen
		click("USCitizen_XPATH");
		Thread.sleep(1000);
		WebElement elementToScrollTo3 = findElement("CountryOfBirthDD_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo3);
		log.debug("Choose the Country of Birth");
		click("CountryOfBirthDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		// Generate a random index to choose a random option
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		// Click on the random option
		WebElement randomOption = options.get(randomIndex1);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		// Get the text of the chosen random option
		selectedCountryOfBirthOptionText.set(getDriver().findElement(By.xpath("//div[@id='country_of_birth']")).getText());
		log.debug("Selected option: " + selectedCountryOfBirthOptionText.get());
		Thread.sleep(1000);
		// Generate random 9 digit SSN Number
		Random random = new Random();
		int randomNineDigitNumber;
		do {
			randomNineDigitNumber = random.nextInt(900000000) + 100000000;
		} while (randomNineDigitNumber == 100000000);
		// Convert the random number to a string
		String randomNumberString = String.valueOf(randomNineDigitNumber);
		// Send the random SSN number to the text field
		WebElement elementToScrollTo4 = findElement("SSN_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
		type("SSN_XPATH",randomNumberString);




		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 13, "U.S. citizenship", "I am a U.S. citizen");
		setExcelData(colKey,colValue,"validData", 14, "Country of citizenship", "United States");
		setExcelData(colKey,colValue,"validData", 15, "Country of birth", selectedCountryOfBirthOptionText.get());
		setExcelData(colKey,colValue,"validData", 16, "Social Security Number", "*********");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}


	public void ParentName(String First_name, String Last_name) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement elementToScrollTo = getDriver().findElement(By.xpath("//span[.=' Parent or legal guardian']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		if (isElementPresent("AdditionalParentBtn_XPATH"))
		{
			// Element is present, perform your actions here
			WebElement element1 = findElement("AdditionalParentBtn_XPATH");
			if(element1.isDisplayed())
			{
				log.debug("Adding the Additional Parent Info");	
				WebElement elementToScrollToAddParent = findElement("AdditionalParentBtn_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToAddParent);
				click("AdditionalParentBtn_XPATH");
			}
		}	
		//Add Parent First and Last names
		WebElement elementToScrollToAddParent = findElement("GuardianFN_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToAddParent);
		type("GuardianFN_ID", First_name);
		WebElement elementToScrollToAddParent1 = findElement("GuardianLN_ID");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToAddParent1);
		type("GuardianLN_ID", Last_name);
	}








	public void ValidateParentName(String First_name, String Last_name) throws EncryptedDocumentException, Exception
	{
		// Validate the Parent First name and Last name
		//regex that checks numbers , special char
		String regex = "^(?!.*\\\\s$)(?!^\\\\s)(?!.*-$)[0-9A-Za-z!@#$%^&*()_+=`~{}\\\\[\\\\]:;\\\"'<>,.?\\\\\\\\/| ]+$";
		//First_name validation
		boolean isFirstNameValid = First_name.matches(regex);
		log.debug("isFirstNameValid :"+isFirstNameValid);
		if(isFirstNameValid)
		{
			try {
				String errorFirstName = findElement("ParentFNErrMsg_XPATH").getText();
				Assert.assertEquals(errorFirstName, "The first name can only contain letters and hyphens (-).");
			}catch(Exception e) {
				if(First_name.length()>50)
				{
					String errorFirstName50 = findElement("errorFirstName50_XPATH").getText();
					Assert.assertEquals(errorFirstName50, "The first name should not be more than 50 characters.");
				}
			}
		}
		else
			log.debug("Parent Firstname is not valid");
		//Last_name validation
		boolean isLastNameValid = Last_name.matches(regex);
		log.debug("isLastNameValid :"+isLastNameValid);
		if(isLastNameValid)
		{
			try
			{
				String errorLastName = findElement("ParentLNErrMsg_XPATH").getText();
				Assert.assertEquals(errorLastName, "The last name can only contain letters and hyphens (-).");
			}catch(Exception e)
			{
				if(Last_name.length()>50)
				{
					String errorLastName50 = findElement("errorLastName50_XPATH").getText();
					Assert.assertEquals(errorLastName50, "The last name should not be more than 50 characters.");
				}
			}
		}
		else
			log.debug("Parent lastName is not valid");
		// Define XPaths for error messages
		String[] errorXPaths = {
				"//div[text()= ' The first name can only contain letters and hyphens (-). ']",
				"/div[text()= ' The last name can only contain letters and hyphens (-). ']",
				"//div[text()=' The first name should not be more than 50 characters. ']",
				"//div[text()=' The last name should not be more than 50 characters. ']"
		};
		// Store error messages in a list
		List<String> errorMessages = new ArrayList<>();
		for (String xpath : errorXPaths)
		{
			List<WebElement> errorElements = getDriver().findElements(By.xpath(xpath));
			for (WebElement errorElement : errorElements)
			{
				errorMessages.add(errorElement.getText());
			}
		}
		// Perform action based on error messages
		if (errorMessages.isEmpty()) {
			// No error messages found,-------------------
			// Choose Is Person living randomly -- YES or NO
			WebElement elementToScrollTo4 = getDriver().findElement(By.xpath("//h3[.=' Is this person living? ']"));
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
			log.debug("Randomly choose - Is this person living?");
			List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='guardian_is_living_radio']"));
			int Count = radioButtons.size();
			// Generate a random index
			Random random = new Random();
			int randomIndex = random.nextInt(radioButtons.size());
			// Get the text of the randomly selected radio button
			String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
			// Click the randomly selected radio button
			radioButtons.get(randomIndex).click();
			if(selectedOption.contains("true"))
			{
				log.debug("Is this person living?: Yes");
				//validate Email add, Phone no.,
				WebElement elementToScrollTo5 = findElement("GuradianEmail_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo5);
				log.debug("Entering a Test Email ID");
				type("GuradianEmail_ID","email@test.asu.edu");
				// Generate a random phone number with a maximum of 15 digits
				Random randomPhoneNO = new Random();
				long phoneNumber = (long) (randomPhoneNO.nextDouble() * Math.pow(10, 15));
				// Ensure the phone number does not exceed 15 digits
				String phoneNumberString = String.format("%015d", phoneNumber);
				// Print the random phone number
				WebElement elementToScrollTo6 = findElement("GuradianPhoneNo_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo6);
				type("GuradianPhoneNo_ID",phoneNumberString);
				// Randomly choose Relation
				WebElement elementToScrollTo = findElement("RelationDD_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				click("RelationDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				// Generate a random index to choose a option
				Random random1 = new Random();
				int randomIndex1 = random1.nextInt(options.size());
				// Click on the random option
				WebElement randomOption = options.get(randomIndex1);
				Thread.sleep(1000);
				randomOption.click();
				Thread.sleep(1000);
				// Get the text of the chosen random option
				String 	selectedOptionText	=	getDriver().findElement(By.xpath("//div[@id='guardian_guardianRelation_select']")).getText();
				log.debug("Selected Relation: " + selectedOptionText);
				//Randomly choose the Highest level of schooling
				WebElement elementToScrollTo1 = findElement("HighestLevelOfSchooling_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				click("HighestLevelOfSchooling_XPATH");
				Thread.sleep(1000);
				List<WebElement> options1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random2 = new Random();
				int randomIndex2 = random2.nextInt(options1.size());
				// Click on the random Option
				WebElement randomOption1= options1.get(randomIndex2);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				// Get the text of the chosen random option
				String 	selectedOptionText1	=	getDriver().findElement(By.xpath("//div[@id='guardian_highestSchoolingLevel_select']")).getText();
				log.debug("Selected Highest level of schooling: " + selectedOptionText1);
				//Randomly choose Did this guardian attend ASU?
				WebElement elementToScrollTo2 = getDriver().findElement(By.xpath("//h3[.=' Did this guardian attend ASU? ']"));
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
				List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='guardian_attended_asu_radio']"));
				int Count1 = radioButtons1.size();
				// Generate a random index
				Random random3 = new Random();
				int randomIndex3= random3.nextInt(radioButtons1.size());
				// Get the text of the randomly selected radio button
				String selectedOption1 = radioButtons1.get(randomIndex3).getAttribute("value");
				// Click the randomly selected radio button
				radioButtons1.get(randomIndex3).click();
				if(selectedOption1.contains("true"))
				{
					log.debug("Did this guardian attend ASU? : " + "Yes");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colNumKey,colNumValue,"validData", 21, "Parent or Legal Guardian Attended ASU", "Yes");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					if(count==1)
					{
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colNumKey,colNumValue,"validData", 25, "Parent or Legal Guardian Attended ASU", "Yes");
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}
				}
				if(selectedOption1.contains("false"))
				{
					log.debug("Did this guardian attend ASU? : " + "No");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colNumKey,colNumValue,"validData", 21, "Parent or Legal Guardian Attended ASU", "No");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					if(count==1)
					{
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colNumKey,colNumValue,"validData", 25, "Parent or Legal Guardian Attended ASU", "No");
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}
				}
				WebElement elementToScrollTo11 = findElement("SaveParentInfo_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
				click("SaveParentInfo_XPATH");
			}
			if(selectedOption.contains("false"))
			{
				log.debug("Is this person living: No");
				// Randomly choose Relation
				WebElement elementToScrollTo = findElement("RelationDD_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				click("RelationDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				// Generate a random index to choose a random Edit button
				Random random1 = new Random();
				int randomIndex1 = random1.nextInt(options.size());
				// Click on the random Edit button
				WebElement randomOption = options.get(randomIndex1);
				Thread.sleep(1000);
				randomOption.click();
				Thread.sleep(1000);
				// Get the text of the chosen random option
				String 	selectedOptionText	=	getDriver().findElement(By.xpath("//div[@id='guardian_guardianRelation_select']")).getText();
				log.debug("Selected Relation: " + selectedOptionText);
				//Randomly choose the Highest level of schooling
				WebElement elementToScrollToHighestSchool = findElement("HighestLevelOfSchooling_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToHighestSchool);
				click("HighestLevelOfSchooling_XPATH");
				Thread.sleep(1000);
				List<WebElement> options1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random2 = new Random();
				int randomIndex2 = random2.nextInt(options1.size());
				// Click on the random Option
				WebElement randomOption1= options1.get(randomIndex2);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				// Get the text of the chosen random option
				String 	selectedOptionText1	=	getDriver().findElement(By.xpath("//div[@id='guardian_highestSchoolingLevel_select']")).getText();
				log.debug("Selected Highest level of schooling: " + selectedOptionText1);
				//Randomly choose Did this guardian attend ASU?
				WebElement elementToScrollTo2 = getDriver().findElement(By.xpath("//h3[.=' Did this guardian attend ASU? ']"));
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
				List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='guardian_attended_asu_radio']"));
				int Count1 = radioButtons1.size();
				// Generate a random index
				Random random3 = new Random();
				int randomIndex3= random3.nextInt(radioButtons1.size());
				// Get the text of the randomly selected radio button
				String selectedOption1 = radioButtons1.get(randomIndex3).getAttribute("value");
				// Click the randomly selected radio button
				radioButtons1.get(randomIndex3).click();
				if(selectedOption1.contains("true"))
				{
					log.debug("Did this guardian attend ASU? : " + "Yes");
					if(count==1)
					{
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colNumKey,colNumValue,"validData", 25, "Parent or Legal Guardian Attended ASU", "Yes");
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}


				}
				if(selectedOption1.contains("false")) 
				{
					log.debug("Did this guardian attend ASU? : " + "No");
					if(count==1)
					{
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colNumKey,colNumValue,"validData", 25, "Parent or Legal Guardian Attended ASU", "No");
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}
				}
				WebElement elementToScrollTo1 = findElement("SaveParentInfo_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				click("SaveParentInfo_XPATH");
			}
		}
		else
		{
			// Error messages found, click on Clear fields button
			WebElement elementToScrollToAddParent = findElement("ClearFields_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToAddParent);
			click("ClearFields_XPATH");
		}
		count++;
	}








	public void ValidateAddedParentNames() throws EncryptedDocumentException, Exception
	{
		// Validate add max of 2 parent info
		List<WebElement> ParentNameslist = getDriver().findElements(By.xpath("//table[@data-cy='my-info-parent-legal-guardian-details-table']//td[1]"));
		log.debug("No. of Parent Info added :"+" "+ParentNameslist.size());
		if(ParentNameslist.size()==2)
		{
			log.debug("2 Parent Infos added successfully!!!");
		}
		else
		{
			log.debug("2 Parent Infos Not added successfully!!!");
		}
		for(WebElement X : ParentNameslist )
		{
			String Parentnameslist = X.getText();
			log.debug(Parentnameslist);
		}

	}




	public void ParentNames(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		//get the data of parent / legal guardian
		//first parent/gaurdian
		WebElement elementToScrollTo = getDriver().findElement(By.xpath("(//*[text()=' Parent or legal guardians ']/../../..//a[contains(text(),' Edit ')])[1]"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);	
		getDriver().findElement(By.xpath("(//*[text()=' Parent or legal guardians ']/../../..//a[contains(text(),' Edit ')])[1]")).click();
		Thread.sleep(1000);
		Relation.set(getDriver().findElement(By.xpath("//div[@id='guardian_guardianRelation_select']//span")).getText());
		Schooling.set(getDriver().findElement(By.xpath("//div[@id='guardian_highestSchoolingLevel_select']//span")).getText());
		AttendedASU.set(getDriver().findElement(By.xpath("//fieldset[@id='group_guardian_attended_asu']//div[@data-cy='radio-group']//span")).getText());
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 18, "Parent or legal guardian", "Parent FN Parent LN I");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 19, "Parent or Legal Guardian Relation", Relation.get());
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 20, "Parent or Legal Guardian Schooling Level", Schooling.get());
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


		WebElement elementToScrollTo1 = findElement("SaveParentInfo_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("SaveParentInfo_XPATH");








		//Second parent/gaurdian
		WebElement elementToScrollTo11 = getDriver().findElement(By.xpath("(//*[text()=' Parent or legal guardians ']/../../..//a[contains(text(),' Edit ')])[2]"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);	
		getDriver().findElement(By.xpath("(//*[text()=' Parent or legal guardians ']/../../..//a[contains(text(),' Edit ')])[2]")).click();
		Thread.sleep(1000);
		Relation1.set(getDriver().findElement(By.xpath("//div[@id='guardian_guardianRelation_select']//span")).getText());
		Schooling1.set(getDriver().findElement(By.xpath("//div[@id='guardian_highestSchoolingLevel_select']//span")).getText());
		AttendedASU1.set(getDriver().findElement(By.xpath("//fieldset[@id='group_guardian_attended_asu']//div[@data-cy='radio-group']//span")).getText());
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 22, "Additional parent or legal guardian", "Parent FN Parent LN II");
		setExcelData(colKey,colValue,"validData", 23, "Parent or Legal Guardian Relation", Relation1.get());
		setExcelData(colKey,colValue,"validData", 24, "Parent or Legal Guardian Schooling Level", Schooling1.get());
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		WebElement elementToScrollTo111 = findElement("SaveParentInfo_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		click("SaveParentInfo_XPATH");


	}








	public void Previous_ASU_affiliation(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		Thread.sleep(2000);
		WebElement elementToScrollTo1 = getDriver().findElement(By.xpath("//div[@id='asu_affiliation_checkbox_group']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		log.debug("Choose Previous ASU affiliation");
		// Choose random Option
		Thread.sleep(1000);
		List<WebElement> Checkboxes = getDriver().findElements(By.xpath("//input[@name='asu_affiliation_checkbox']"));
		int Count = Checkboxes.size();
		// Generate a random index
		Random random = new Random();
		int randomIndex = random.nextInt(Checkboxes.size());

		WebElement element = Checkboxes.get(randomIndex);
		Thread.sleep(1000);
		// Get the text of the randomly selected Checkbox
		String selectedOption = element.getText();
		// Click the randomly selected checkbox
		Thread.sleep(500);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
		Thread.sleep(500);


		int ran = randomIndex+1;
		asuAffiliation.set(getDriver().findElement(By.xpath("(//input[@name='asu_affiliation_checkbox']/following-sibling::label//span)["+ran+"]")).getText());
		log.debug("Selected ASU affiliation: " + asuAffiliation.get());


		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 26, "Previous ASU affiliation", asuAffiliation.get());
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		log.debug("Selected Previous ASU affiliation: " + selectedOption);
	}








	public void ASU_affiliate_ID(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo1 = getDriver().findElement(By.xpath("//span[.=' What is your ASU Affiliate ID?']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		// Create a Random 10 digit ASU affiliate ID
		Random random = new Random();
		// Generate a random 10-digit number
		long randomASUaffiliateID = (long) (random.nextDouble() * 9000000000L) + 1000000000L;
		// Convert the random number to a string
		randomASU_affiliateID.set(Long.toString(randomASUaffiliateID));
		log.debug("Random 10-digit ASU ID: " + randomASU_affiliateID.get());
		type("ASUaffiliationID_ID",randomASU_affiliateID.get());
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 27, "Affiliate ID", randomASU_affiliateID.get());
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}




	public void Random_MilitaryServices(String colKey,String colValue) throws EncryptedDocumentException, Exception 
	{
		WebElement elementToScrollTo1 = getDriver().findElement(By.xpath("//span[.=' Affiliation to U.S. Uniformed Services']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("USuniformedDD_XPATH");
		Thread.sleep(2000);
		List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		selectedMilitaryStatus.set(findElement("USuniformedDD_XPATH").getText());
		log.debug("Selected Military option: " + selectedMilitaryStatus.get());
		if(selectedMilitaryStatus.get().equals("I am a U.S. service member or veteran"))
		{
			Thread.sleep(1000);
			List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='status_radio']"));
			int Count = radioButtons.size();
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(radioButtons.size());
			 SelectedMilitaryStatus_USmemberORveteran.set(radioButtons.get(randomIndex1).getAttribute("value"));
			Thread.sleep(1000);
			radioButtons.get(randomIndex1).click();
			Thread.sleep(1000);
			log.debug("Selected Military status :"+SelectedMilitaryStatus_USmemberORveteran.get());
			// Select the Branch of service
			WebElement elementToScrollTo11 = findElement("SpouseServiceBranchDD_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
			log.debug("Select your spouse or guardian’s branch of service:");
			Thread.sleep(1000);
			click("SpouseServiceBranchDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex11);
			randomOption1.click();
			selectedBranchText.set(findElement("SpouseServiceBranchDD_XPATH").getText());
			log.debug("Branch : " + selectedBranchText.get());
			// Apply for Department of Veterans Affairs
			WebElement elementToScrollTo111 = getDriver().findElement(By.xpath("//h3[.=' I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: ']"));
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
			log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
			// Choose randomly -- YES or NO
			List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='veterans_benefits_radio']"));
			int Count1 = radioButtons1.size();
			Random random13 = new Random();
			int randomIndex13 = random13.nextInt(radioButtons1.size());
			String selectedOption = radioButtons1.get(randomIndex13).getAttribute("value");
			// Click the randomly selected radio button
			radioButtons1.get(randomIndex13).click();
			if(selectedOption.contains("Y"))
			{
				departmentOfVeterans.set("Yes") ;
				log.debug(" I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: " + "Yes");
			}
			if(selectedOption.contains("N"))
			{
				departmentOfVeterans.set("No") ;
				log.debug(" I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: " + "No");
			}
			// I authorize Arizona State University to request my Joint Service Transcript on my behalf.
			WebElement elementToScrollTo = getDriver().findElement(By.xpath("//h3[.=' I authorize Arizona State University to request my Joint Service Transcript on my behalf. ']"));
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
			// Choose randomly -- YES or NO
			List<WebElement> radioButtons11 = getDriver().findElements(By.xpath("//input[@name='request_transcripts_radio']"));
			int Count11 = radioButtons11.size();
			Random random111 = new Random();
			int randomIndex111 = random111.nextInt(radioButtons11.size());
			String selectedOption1 = radioButtons11.get(randomIndex111).getAttribute("value");
			// Click the randomly selected radio button
			radioButtons11.get(randomIndex111).click();
			if(selectedOption1.contains("Y"))
			{
				AuthorizeASU.set("Yes") ;
				log.debug(" I authorize Arizona State University to request my Joint Service Transcript on my behalf. " + "Yes");
			}
			if(selectedOption1.contains("N"))
			{
				AuthorizeASU.set("No") ;
				log.debug(" I authorize Arizona State University to request my Joint Service Transcript on my behalf. " + "No");
			}
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 28, "Military status", SelectedMilitaryStatus_USmemberORveteran.get());
			setExcelData(colKey,colValue,"validData", 29, "Branch", selectedBranchText.get());
			setExcelData(colKey,colValue,"validData", 30, "I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:", departmentOfVeterans.get());
			setExcelData(colKey,colValue,"validData", 31, "Do you plan to use an education benefit or scholarship through an employer, corporation, foundation or other ASU education partner? ", AuthorizeASU.get());
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

		}
		if(selectedMilitaryStatus.get().equals("I am the spouse/dependent of a U.S. service member or veteran"))
		{
			// Select the spouse branch of service
			WebElement elementToScrollTo11 = findElement("SpouseServiceBranchDD_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
			log.debug("Select your spouse or guardian’s branch of service:");
			Thread.sleep(1000);
			click("SpouseServiceBranchDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex1);
			randomOption1.click();
			selectedBranchServiceOptionText.set(findElement("SpouseServiceBranchDD_XPATH").getText());
			log.debug("Selected Spouse or guardian branch of service : " + selectedBranchServiceOptionText.get());

			// Department of Veteran Affairs
			WebElement elementToScrollTo111 = getDriver().findElement(By.xpath("//h3[.=' I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: ']"));
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
			log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
			// Choose randomly -- YES or NO
			List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='veterans_benefits_radio']"));
			int Count = radioButtons.size();
			Random random11 = new Random();
			int randomIndex13 = random11.nextInt(radioButtons.size());
			String selectedOption = radioButtons.get(randomIndex13).getAttribute("value");
			// Click the randomly selected radio button
			radioButtons.get(randomIndex13).click();
			if(selectedOption.contains("Y"))
			{
				departmentOfVeterans.set("Yes");
				log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:" + "Yes");
			}
			else
			{
				departmentOfVeterans.set("No");
				log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:" + "No");
			}
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 28, "Military status", "I am the spouse/dependent of a U.S. service member or veteran");
			setExcelData(colKey,colValue,"validData", 29, "Branch", selectedBranchServiceOptionText.get());
			setExcelData(colKey,colValue,"validData", 30, "I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:", departmentOfVeterans.get());
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

		}
		if(selectedMilitaryStatus.get().equals("None of these options apply to me"))
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 28, "Military status", "None of these options apply to me");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}

	}






	public void SpouseOrDependent_Military(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo1 = getDriver().findElement(By.xpath("//span[.=' Affiliation to U.S. Uniformed Services']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		// Validate for Spouse / Dependent of a US
		click("USuniformedDD_XPATH");
		Thread.sleep(2500);
		// Get the text of the selected option before clicking on it
		String MilitaryStatusOption = findElement("SpouseOrDependent_XPATH").getText();
		Thread.sleep(1000);
		click("SpouseOrDependent_XPATH");
		Thread.sleep(1000);
		log.debug("Selected Military status : " + MilitaryStatusOption);

		// Select the spouse branch of service
		WebElement elementToScrollTo11 = findElement("SpouseServiceBranchDD_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		log.debug("Select your spouse or guardian’s branch of service:");
		Thread.sleep(1000);
		click("SpouseServiceBranchDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		randomOption.click();
		selectedBranchServiceOptionText.set(findElement("SpouseServiceBranchDD_XPATH").getText());
		log.debug("Selected Spouse or guardian branch of service : " + selectedBranchServiceOptionText.get());
		// Department of Veteran Affairs
		WebElement elementToScrollTo111 = getDriver().findElement(By.xpath("//h3[.=' I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
		// Choose randomly -- YES or NO
		List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='veterans_benefits_radio']"));
		int Count = radioButtons.size();
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons.get(randomIndex).click();
		if(selectedOption.contains("Y"))
		{
			departmentOfVeterans.set("Yes");
			log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:" + "Yes");
		}
		else
		{
			departmentOfVeterans.set("No");
			log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:" + "No");
		}
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 28, "Military status", "I am the spouse/dependent of a U.S. service member or veteran");
		setExcelData(colKey,colValue,"validData", 29, "Branch", selectedBranchServiceOptionText.get());
		setExcelData(colKey,colValue,"validData", 30, "I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:", departmentOfVeterans.get());
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}


	public void ActiveDuty_Military(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo1 = getDriver().findElement(By.xpath(" //div[@id='us_uniformed_services_select']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		// Validate for Active Duty
		click("USuniformedDD_XPATH");
		Thread.sleep(2500);
		click("ServiceMemberOrVeteran_XPATH");
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(findElement("ActiveDutyRdBtn_XPATH"))).click();
//		click("ActiveDutyRdBtn_XPATH");
		log.debug("Selected Military status : Active Duty");

		// Select the Branch of service
		WebElement elementToScrollTo11 = findElement("SpouseServiceBranchDD_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		log.debug("Select your spouse or guardian’s branch of service:");
		Thread.sleep(1000);
		click("SpouseServiceBranchDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		randomOption.click();
		selectedBranchText.set(findElement("SpouseServiceBranchDD_XPATH").getText());
		log.debug("Branch : " + selectedBranchText.get());


		// Apply for Department of Veterans Affairs
		WebElement elementToScrollTo111 = getDriver().findElement(By.xpath("//h3[.=' I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
		// Choose randomly -- YES or NO
		List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='veterans_benefits_radio']"));
		int Count = radioButtons.size();
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons.get(randomIndex).click();
		if(selectedOption.contains("Y"))
		{
			departmentOfVeterans.set("Yes");
			log.debug(" I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: " + "Yes");
		}
		if(selectedOption.contains("N"))
		{
			departmentOfVeterans.set("No");
			log.debug(" I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: " + "No");
		}


		// I authorize Arizona State University to request my Joint Service Transcript on my behalf.
		WebElement elementToScrollTo = getDriver().findElement(By.xpath("//h3[.=' I authorize Arizona State University to request my Joint Service Transcript on my behalf. ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
		// Choose randomly -- YES or NO
		List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='request_transcripts_radio']"));
		int Count1 = radioButtons1.size();
		Random random11 = new Random();
		int randomIndex11 = random11.nextInt(radioButtons1.size());
		String selectedOption1 = radioButtons1.get(randomIndex11).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons1.get(randomIndex11).click();
		if(selectedOption1.contains("Y"))
		{
			AuthorizeASU.set("Yes");
			log.debug(" I authorize Arizona State University to request my Joint Service Transcript on my behalf. " + "Yes");
		}
		if(selectedOption1.contains("N"))
		{
			AuthorizeASU.set("No");
			log.debug(" I authorize Arizona State University to request my Joint Service Transcript on my behalf. " + "No");
		}
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 28, "Military status", "Active Duty");
		setExcelData(colKey,colValue,"validData", 29, "Branch", selectedBranchText.get());
		setExcelData(colKey,colValue,"validData", 30, "I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:", departmentOfVeterans.get());
		setExcelData(colKey,colValue,"validData", 31, "Do you plan to use an education benefit or scholarship through an employer, corporation, foundation or other ASU education partner? ", AuthorizeASU.get());
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}


	public void Veteran_Military(String colKey,String colValue) throws EncryptedDocumentException, Exception 
	{
		WebElement elementToScrollTo1 = getDriver().findElement(By.xpath("//span[.=' Affiliation to U.S. Uniformed Services']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		// Validate for Active Duty
		click("USuniformedDD_XPATH");
		Thread.sleep(1500);
		click("ServiceMemberOrVeteran_XPATH");
		Thread.sleep(1000);
		WebElement elementToScrollTo = findElement("VeteranRdBtn_XPATH");
		this.js = (JavascriptExecutor) getDriver();		
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		click("VeteranRdBtn_XPATH");
		log.debug("Selected Military status : Veteran" );


		// Select the Branch of service
		WebElement elementToScrollTo11 = findElement("SpouseServiceBranchDD_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		log.debug("Select your spouse or guardian’s branch of service:");
		Thread.sleep(1000);
		click("SpouseServiceBranchDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		randomOption.click();
		selectedBranchText.set(findElement("SpouseServiceBranchDD_XPATH").getText());
		log.debug("Branch : " + selectedBranchText.get());


		// Apply for Department of Veterans Affairs
		WebElement elementToScrollTo111 = getDriver().findElement(By.xpath("//h3[.=' I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
		// Choose randomly -- YES or NO
		List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='veterans_benefits_radio']"));
		int Count = radioButtons.size();
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons.get(randomIndex).click();
		if(selectedOption.contains("Y"))
		{
			departmentOfVeterans.set("Yes") ;
			log.debug(" I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: " + "Yes");
		}
		if(selectedOption.contains("N"))
		{
			departmentOfVeterans.set("No") ;
			log.debug(" I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: " + "No");
		}




		// I authorize Arizona State University to request my Joint Service Transcript on my behalf.
		WebElement elementToScrollTo1111 = getDriver().findElement(By.xpath("//h3[.=' I authorize Arizona State University to request my Joint Service Transcript on my behalf. ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
		log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
		// Choose randomly -- YES or NO
		List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='request_transcripts_radio']"));
		int Count1 = radioButtons1.size();
		Random random11 = new Random();
		int randomIndex11 = random11.nextInt(radioButtons1.size());
		String selectedOption1 = radioButtons1.get(randomIndex11).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons1.get(randomIndex11).click();
		if(selectedOption1.contains("Y"))
		{
			AuthorizeASU.set("Yes") ;
			log.debug(" I authorize Arizona State University to request my Joint Service Transcript on my behalf. " + "Yes");
		}
		if(selectedOption1.contains("N"))
		{
			AuthorizeASU.set("No") ;
			log.debug(" I authorize Arizona State University to request my Joint Service Transcript on my behalf. " + "No");
		}
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 28, "Military status", "Veteran");
		setExcelData(colKey,colValue,"validData", 29, "Branch", selectedBranchText.get());
		setExcelData(colKey,colValue,"validData", 30, "I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:", departmentOfVeterans.get());
		setExcelData(colKey,colValue,"validData", 31, " Do you plan to use an education benefit or scholarship through an employer, corporation, foundation or other ASU education partner? ", AuthorizeASU.get());
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}
	public void NoneOfTheseApply_Military(String colKey,String colValue) throws EncryptedDocumentException, Exception 
	{
		WebElement elementToScrollTo1 = getDriver().findElement(By.xpath("//span[.=' Affiliation to U.S. Uniformed Services']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		// Validate for None of these options apply to me
		click("USuniformedDD_XPATH");
		Thread.sleep(1500);
		click("NoneOftheseApplytoMe_XPATH");
		Thread.sleep(1000);
		log.debug("Selected Military status : None of these options apply to me" );
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 28, "Military status", "None of these options apply to me");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}

	public void Partner_benefits(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo1 = getDriver().findElement(By.xpath("//span[.=' Partner benefits']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		log.debug("Choose the Partner Benefits");
		// Choose Partner Benefits randomly -- YES or NO
		List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='education_benefit_radio']"));
		int Count = radioButtons.size();
		System.out.println(Count + "Yes or NO");
		// Generate a random index
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		// Get the text of the randomly selected radio button
		String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons.get(randomIndex).click();
		if(selectedOption.contains("Y"))
		{
			log.debug("Selected Option: " + "Yes");
			educationbenefit.set("Yes") ;
			WebElement elementToScroll = findElement("CurrentEmployerDD_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
			click("CurrentEmployerDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options = options.size();
			System.out.println(Options);
			// Generate a random index to choose a random option
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options.size());
			// Click on the random option
			WebElement randomOption = options.get(randomIndex1);
			Thread.sleep(1000);
			randomOption.click();
			Thread.sleep(1000);
			// Get the text of the chosen random option
			selectedEmploymentOptionText.set(getDriver().findElement(By.xpath("//div[@id='current_employer_select']")).getText());
			System.out.println("Selected option: " + selectedEmploymentOptionText.get());
			log.debug("Selected option: " + selectedEmploymentOptionText.get());
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 32, "Do you plan to use an education benefit or scholarship through an employer, corporation, foundation or other ASU education partner?", educationbenefit.get());
			setExcelData(colKey,colValue,"validData", 33, "Current employer", selectedEmploymentOptionText.get());
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		else {
			educationbenefit.set("No");
			log.debug("Selected Option: " + "No");
		}
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 32, "Do you plan to use an education benefit or scholarship through an employer, corporation, foundation or other ASU education partner?", educationbenefit.get());
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}

	public void NotUSctizenship() throws InterruptedException
	{
		WebElement elementToScrollTo2 = findElement("NotUSCitizenship_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		click("NotUSCitizenship_XPATH");
		Thread.sleep(1000);
	}


	public void visaType_F1_J1_JN(String colKey,String colValue) throws Throwable
	{


		WebElement elementToScrollTo2 = findElement("visaTypeDropdown_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		Thread.sleep(1500);
		click("visaTypeDropdown_XPATH");
		Thread.sleep(1500);

		// Choose randomly either F-1 or J-1 or JN
		List<WebElement> visa = getDriver().findElements(By.xpath("//ul[@role='listbox']//li[contains(text(),'Student (F-1)')] | //ul[@role='listbox']//li[contains(text(),'Exchange Visitor (J-1)')] |//ul[@role='listbox']//li[contains(text(),'International attending ASU Online programs only (JN)')]"));
		int Size = visa.size();
		System.out.println("Visa Size"+Size);
		ArrayList<Integer> randomvisa = getRandomNumber(0, visa.size(), 1);
		System.out.println("randomvisa"+randomvisa);
		for(int ran:randomvisa)
		{
			System.out.println("ran :"+ran);
			Thread.sleep(1500);
			getDriver().findElement(By.xpath("(//ul[@role='listbox']//li[contains(text(),'Student (F-1)')] | //ul[@role='listbox']//li[contains(text(),'Exchange Visitor (J-1)')] |//ul[@role='listbox']//li[contains(text(),'International attending ASU Online programs only (JN)')] )["+ran+"]")).click();
		}
		String visaType = findElement("visaTypeDropdown_XPATH").getText();
		if(visaType.equals("Student (F-1)"))
		{
			// Selected F-1 type of visa
			log.debug("Validating the Click here link");
			WebElement linkElement = getDriver().findElement(By.linkText("click here"));
			String hrefValue = linkElement.getAttribute("href");
			if (hrefValue != null && !hrefValue.isEmpty()) {
				log.debug("The click here text is a link with URL: " + hrefValue);
			} else
			{
				log.debug("The click here text is not a link.");
			}
			click("Clickhere_XPATH");
			Thread.sleep(2000);
			NeedHelp.ValidateNeedhelp_F1();
			Thread.sleep(500);
			NeedHelp.SelectRequestF1();
			Thread.sleep(500);
			NeedHelp.AdditionalInfo_F1();
			Thread.sleep(500);
			NeedHelp.SubmitHelpRequestF1();
			Thread.sleep(1000);
			NeedHelp.ValidateHelpRequest();
			Thread.sleep(1000);
			NeedHelp.CloseNeedhelp_F1();
			Thread.sleep(1000);
			WebElement elementToScrollTo21 = findElement("countryOfCitizenship_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
			click("countryOfCitizenship_XPATH");
			Thread.sleep(1000);
			List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options = options.size();
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options.size());
			WebElement randomOption = options.get(randomIndex1);
			Thread.sleep(500);
			randomOption.click();
			Thread.sleep(500);
			click("CountryOfBirthDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex11);
			Thread.sleep(500);
			randomOption1.click();
			Thread.sleep(500);
			WebElement elementToScrollTo211 = findElement("CityOfBirth_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo211);
			type("CityOfBirth_ID","Test City");
			Thread.sleep(1000);

			String countryOfCitizenship = findElement("countryOfCitizenship_XPATH").getText();
			String	CountryOfBirth =  findElement("CountryOfBirthDD_XPATH").getText();

			// Generate random 9 digit SSN Number
			Random random = new Random();
			int randomNineDigitNumber;
			do {
				randomNineDigitNumber = random.nextInt(900000000) + 100000000;
			} while (randomNineDigitNumber == 100000000);
			// Convert the random number to a string
			String randomNumberString = String.valueOf(randomNineDigitNumber);
			// Send the random SSN number to the text field
			WebElement elementToScrollTo4 = findElement("SSN_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
			type("SSN_XPATH",randomNumberString);
			Thread.sleep(2000);
			List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='issuing_i20_radio']"));
			Random random111 = new Random();
			int randomIndex = random111.nextInt(radioButtons.size());
			String selectedoption = radioButtons.get(randomIndex).getAttribute("value");
			Thread.sleep(2000);
			radioButtons.get(randomIndex).click();
			Thread.sleep(1000);
			if(selectedoption.contains("yes"))
			{
				CurrentlyInUS.set("Yes") ;
				log.debug("Selected Option: " + "Yes");
			}
			if(selectedoption.contains("no"))
			{
				CurrentlyInUS.set("No") ;
				log.debug("Selected Option: " + "No");
			}

			if(selectedOptionText.get().contains("United States"))
			{
				// Validate the International address
				log.debug("Choose the International Address");
				// Select a International country
				WebElement elementToScrollTo2111 = findElement("IntCountry_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2111);
				click("IntCountry_ID");
				Thread.sleep(1000);
				List<WebElement> options11 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options12 = options11.size();
				Random random112 = new Random();
				int randomIndex112 = random112.nextInt(options11.size());
				WebElement randomOption21 = options11.get(randomIndex112);
				Thread.sleep(500);
				randomOption21.click();
				Thread.sleep(500);

				WebElement elementToScrollTo = findElement("AddLine1_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				type("AddLine1_ID","AddressLine1");
				Thread.sleep(500);
				WebElement elementToScrollTo1 = findElement("AddLine2_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				type("AddLine2_ID","AddressLine2");
				Thread.sleep(500);
				WebElement elementToScrollTo11 = findElement("IntCity_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
				type("IntCity_ID","Test City");
				Thread.sleep(1000);
				WebElement stateElement = findElement("IntState_ID"); 
				if (stateElement.getTagName().equals("div")) 
				{
					// It's a dropdown
					log.debug("State is a dropdown.");
					click("IntState_ID");
					Thread.sleep(1000);
					List<WebElement> options113  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
					int Options11 = options113.size();
					Random random1113 = new Random();
					int randomIndex111 = random1113.nextInt(options113.size());
					WebElement randomOption11 = options113.get(randomIndex111);
					Thread.sleep(1000);
					randomOption11.click();
					Thread.sleep(1000);
					String 	selectedStateText	=	findElement("IntState_ID").getText();
					log.debug("Selected  State: " + selectedStateText);
					RecentState.set(selectedStateText);

				}
				else if (stateElement.getTagName().equals("input")) 
				{
					// It's a textfield
					log.debug("State is a textfield.");
					Thread.sleep(1000);
					type("SchoolStateTextfield_XPATH","Test state");
					log.debug("Selected  State: " + "Test state");
					RecentState.set("Test state");
				}
				else 
				{
					// It's neither a dropdown nor a textfield
					log.debug("State is neither a dropdown nor a textfield.");
				}
				WebElement elementToScrollTo111 = findElement("IntZipCode_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
				type("IntZipCode_ID","123456-78910");
				Thread.sleep(500);

				// Choose the I - 20 shipping address
				log.debug("Choose the I-20 shipping address");

				WebElement elementToScrollTo21111 = findElement("ShippingAddDD_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21111);
				click("ShippingAddDD_ID");
				Thread.sleep(1000);
				List<WebElement> options111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options121 = options111.size();
				Random random1121 = new Random();
				int randomIndex1121 = random1121.nextInt(options111.size());
				WebElement randomOption211 = options111.get(randomIndex1121);
				Thread.sleep(500);
				randomOption211.click();
				Thread.sleep(500);
				String I20add = findElement("ShippingAddDD_ID").getText();
				if(I20add.equals("Other"))	
				{
					WebElement elementToScrollTo211111 = findElement("SAcountry_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo211111);
					click("SAcountry_ID");
					Thread.sleep(1000);
					List<WebElement> options1111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
					int Options1213 = options1111.size();
					Random random11213 = new Random();
					int randomIndex11213 = random11213.nextInt(options1111.size());
					WebElement randomOption2113 = options1111.get(randomIndex11213);
					Thread.sleep(500);
					randomOption2113.click();
					Thread.sleep(500);

					WebElement elementToScrollTo12 = findElement("SAaddline1_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo12);
					type("SAaddline1_ID","AddressLine1");
					Thread.sleep(500);
					WebElement elementToScrollTo112 = findElement("SAaddline2_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo112);
					type("SAaddline2_ID","AddressLine2");
					Thread.sleep(500);
					WebElement elementToScrollTo1112 = findElement("SAcity_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1112);
					type("SAcity_ID","Test City");
					Thread.sleep(1000);
					WebElement stateElement1 = findElement("SAstate_ID"); 
					if (stateElement1.getTagName().equals("div")) 
					{
						// It's a dropdown
						log.debug("State is a dropdown.");
						click("SAstate_ID");
						Thread.sleep(1000);
						List<WebElement> options113  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
						int Options11 = options113.size();
						Random random1113 = new Random();
						int randomIndex111 = random1113.nextInt(options113.size());
						WebElement randomOption11 = options113.get(randomIndex111);
						Thread.sleep(1000);
						randomOption11.click();
						Thread.sleep(1000);
						String 	selectedStateText	=	findElement("SAstate_ID").getText();
						log.debug("Selected State: " + selectedStateText);
						RecentState.set(selectedStateText);

					}
					else if (stateElement1.getTagName().equals("input")) 
					{
						// It's a textfield
						log.debug("State is a textfield.");
						Thread.sleep(1000);
						type("SchoolStateTextfield_XPATH","Test state");
						log.debug("Selected State: " + "Test state");
						RecentState.set("Test state");
					}
					else 
					{
						// It's neither a dropdown nor a textfield
						log.debug("State is neither a dropdown nor a textfield.");
					}
					WebElement elementToScrollTo1111 = findElement("SAzip_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
					type("SAzip_ID","123456-78910");
					Thread.sleep(500);
				}
			}

			if(!selectedOptionText.get().contains("United States"))
			{
				// Choose the I - 20 shipping address
				log.debug("Choose the I-20 shipping address");

				WebElement elementToScrollTo21111 = findElement("ShippingAddDD_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21111);
				click("ShippingAddDD_ID");
				Thread.sleep(1000);
				List<WebElement> options111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options121 = options111.size();
				Random random1121 = new Random();
				int randomIndex1121 = random1121.nextInt(options111.size());
				WebElement randomOption211 = options111.get(randomIndex1121);
				Thread.sleep(500);
				randomOption211.click();
				Thread.sleep(500);
				String I20add = findElement("ShippingAddDD_ID").getText();
				if(I20add.equals("Other"))	
				{
					WebElement elementToScrollTo211111 = findElement("SAcountry_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo211111);
					click("SAcountry_ID");
					Thread.sleep(1000);
					List<WebElement> options1111 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
					int Options1213 = options1111.size();
					Random random11213 = new Random();
					int randomIndex11213 = random11213.nextInt(options1111.size());
					WebElement randomOption2113 = options1111.get(randomIndex11213);
					Thread.sleep(500);
					randomOption2113.click();
					Thread.sleep(500);

					WebElement elementToScrollTo12 = findElement("SAaddline1_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo12);
					type("SAaddline1_ID","AddressLine1");
					Thread.sleep(500);
					WebElement elementToScrollTo112 = findElement("SAaddline2_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo112);
					type("SAaddline2_ID","AddressLine2");
					Thread.sleep(500);
					WebElement elementToScrollTo1112 = findElement("SAcity_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1112);
					type("SAcity_ID","Test City");
					Thread.sleep(1000);
					WebElement stateElement1 = findElement("SAstate_ID"); 
					if (stateElement1.getTagName().equals("div")) 
					{
						// It's a dropdown
						log.debug("State is a dropdown.");
						click("SAstate_ID");
						Thread.sleep(1000);
						List<WebElement> options113  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
						int Options11 = options113.size();
						Random random1113 = new Random();
						int randomIndex111 = random1113.nextInt(options113.size());
						WebElement randomOption11 = options113.get(randomIndex111);
						Thread.sleep(1000);
						randomOption11.click();
						Thread.sleep(1000);
						String 	selectedStateText	=	findElement("SAstate_ID").getText();
						log.debug("Selected State: " + selectedStateText);
						RecentState.set(selectedStateText);

					}
					else if (stateElement1.getTagName().equals("input")) 
					{
						// It's a textfield
						log.debug("State is a textfield.");
						Thread.sleep(1000);
						type("SAstate_ID","Test state");
						log.debug("Selected State: " + "Test state");
						RecentState.set("Test state");
					}
					else 
					{
						// It's neither a dropdown nor a textfield
						log.debug("State is neither a dropdown nor a textfield.");
					}
					WebElement elementToScrollTo1111 = findElement("SAzip_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
					type("SAzip_ID","123456-78910");
					Thread.sleep(500);
				}
			}

		}




		if(visaType.equals("Exchange Visitor (J-1)"))
		{
			// Selected J-1 type of visa
			WebElement elementToScrollTo21 = findElement("countryOfCitizenship_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
			click("countryOfCitizenship_XPATH");
			Thread.sleep(1000);
			List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options = options.size();
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options.size());
			WebElement randomOption = options.get(randomIndex1);
			Thread.sleep(500);
			randomOption.click();
			Thread.sleep(500);
			click("CountryOfBirthDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex11);
			Thread.sleep(500);
			randomOption1.click();
			Thread.sleep(500);
			String countryOfCitizenship = findElement("countryOfCitizenship_XPATH").getText();
			String	CountryOfBirth =  findElement("CountryOfBirthDD_XPATH").getText();

			// Generate random 9 digit SSN Number
			Random random = new Random();
			int randomNineDigitNumber;
			do {
				randomNineDigitNumber = random.nextInt(900000000) + 100000000;
			} while (randomNineDigitNumber == 100000000);
			// Convert the random number to a string
			String randomNumberString = String.valueOf(randomNineDigitNumber);
			// Send the random SSN number to the text field
			WebElement elementToScrollTo4 = findElement("SSN_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
			type("SSN_XPATH",randomNumberString);
			Thread.sleep(2000);
			List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='issuing_i20_radio']"));
			Random random111 = new Random();
			int randomIndex = random111.nextInt(radioButtons.size());
			String selectedoption = radioButtons.get(randomIndex).getAttribute("value");
			Thread.sleep(2000);
			radioButtons.get(randomIndex).click();
			Thread.sleep(1000);
			if(selectedoption.contains("yes"))
			{
				CurrentlyInUS.set("Yes") ;
				log.debug("Selected Option: " + "Yes");
			}
			if(selectedoption.contains("no"))
			{
				CurrentlyInUS.set("No") ;
				log.debug("Selected Option: " + "No");
			}
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 13, "U.S. citizenship", "I am not a U.S. citizen");
			setExcelData(colKey,colValue,"validData", 14, "Which type of visa will you be holding?", visaType);
			setExcelData(colKey,colValue,"validData", 15, "Country of citizenship",countryOfCitizenship);
			setExcelData(colKey,colValue,"validData", 16, "Country of birth", CountryOfBirth);
			setExcelData(colKey,colValue,"validData", 17, "Social Security Number", "*********");
			setExcelData(colKey,colValue,"validData", 18, "For the purposes of issuing an I-20 and obtaining a Student Visa, are you currently in the United States on any kind of Student Visa?", CurrentlyInUS.get());
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


		}
		if(visaType.equals("International attending ASU Online programs only (JN)"))
		{
			// Selected JN type of visa
			WebElement elementToScrollTo21 = findElement("countryOfCitizenship_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
			click("countryOfCitizenship_XPATH");
			Thread.sleep(1000);
			List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options = options.size();
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options.size());
			WebElement randomOption = options.get(randomIndex1);
			Thread.sleep(500);
			randomOption.click();
			Thread.sleep(500);
			click("CountryOfBirthDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex11);
			Thread.sleep(500);
			randomOption1.click();
			Thread.sleep(500);
			String countryOfCitizenship = findElement("countryOfCitizenship_XPATH").getText();
			String	CountryOfBirth =  findElement("CountryOfBirthDD_XPATH").getText();

			// Generate random 9 digit SSN Number
			Random random = new Random();
			int randomNineDigitNumber;
			do {
				randomNineDigitNumber = random.nextInt(900000000) + 100000000;
			} while (randomNineDigitNumber == 100000000);
			// Convert the random number to a string
			String randomNumberString = String.valueOf(randomNineDigitNumber);
			// Send the random SSN number to the text field
			WebElement elementToScrollTo4 = findElement("SSN_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
			type("SSN_XPATH",randomNumberString);
			Thread.sleep(1000);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 13, "U.S. citizenship", "I am not a U.S. citizen");
			setExcelData(colKey,colValue,"validData", 14, "Which type of visa will you be holding?", visaType);
			setExcelData(colKey,colValue,"validData", 15, "Country of citizenship",countryOfCitizenship);
			setExcelData(colKey,colValue,"validData", 16, "Country of birth", CountryOfBirth);
			setExcelData(colKey,colValue,"validData", 17, "Social Security Number", "*********");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

		}

	}












	public void visaType_DACA_UD(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		WebElement elementToScrollTo2 = findElement("visaTypeDropdown_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		Thread.sleep(1500);
		click("visaTypeDropdown_XPATH");
		Thread.sleep(500);

		List<WebElement> visa = getDriver().findElements(By.xpath("//ul[@role='listbox']//li[contains(text(),'Deferred Action for Childhood Arrivals (DACA)')] | //ul[@role='listbox']//li[contains(text(),'Other')]"));
		ArrayList<Integer> randomvisa = getRandomNumber(0, visa.size(), 1);
		for(int ran:randomvisa)
		{
			Thread.sleep(500);
			WebElement elementToScrollTo21 = getDriver().findElement(By.xpath("//ul[@role='listbox']//li[contains(text(),'Permanent resident')]"));
			this.js = (JavascriptExecutor) getDriver();
			Thread.sleep(500);
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
			getDriver().findElement(By.xpath("(//ul[@role='listbox']//li[contains(text(),'Deferred Action for Childhood Arrivals (DACA)')] | //ul[@role='listbox']//li[contains(text(),'Other')])["+ran+"]")).click();
			//			Thread.sleep(2000);
		}



		WebElement elementToScrollTo21 = findElement("countryOfCitizenship_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
		click("countryOfCitizenship_XPATH");
		Thread.sleep(1000);
		List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		Thread.sleep(500);
		randomOption.click();
		Thread.sleep(500);
		click("CountryOfBirthDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options1 = options1.size();
		Random random11 = new Random();
		int randomIndex11 = random11.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex11);
		Thread.sleep(500);
		randomOption1.click();
		Thread.sleep(500);


		// Text of the Randomly choose Which type of visa will you be holding?
		String visaType = findElement("visaTypeDropdown_XPATH").getText();
		log.debug("Type of visa selected :"+visaType);
		// Select randomly the Type of visa -  DACA or Other
		if(visaType.equals("Other"))
		{
			// Select UD type of visa
			WebElement elementToScrollTo = findElement("OtherVisaChoices_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			click("OtherVisaChoices_ID");
			Thread.sleep(1000);
			WebElement visachoice = getDriver().findElement(By.xpath("(//div[@id='other_visa_choices']//div)[2]"));
			Actions actions = new Actions(getDriver());
			actions.sendKeys(visachoice, "UD - Undetermined").perform();
			actions.sendKeys(Keys.ENTER).perform();

		}


		// Generate random 9 digit SSN Number
		Random random = new Random();
		int randomNineDigitNumber;
		do {
			randomNineDigitNumber = random.nextInt(900000000) + 100000000;
		} while (randomNineDigitNumber == 100000000);
		// Convert the random number to a string
		String randomNumberString = String.valueOf(randomNineDigitNumber);
		// Send the random SSN number to the text field
		WebElement elementToScrollTo4 = findElement("SSN_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
		type("SSN_XPATH",randomNumberString);
		Thread.sleep(1000);

		String countryOfCitizenship = findElement("countryOfCitizenship_XPATH").getText();
		String	CountryOfBirth =  findElement("CountryOfBirthDD_XPATH").getText();

		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 13, "U.S. citizenship", "I am not a U.S. citizen");
		setExcelData(colKey,colValue,"validData", 14, "Which type of visa will you be holding?", visaType);
		setExcelData(colKey,colValue,"validData", 15, "Country of citizenship",countryOfCitizenship);
		setExcelData(colKey,colValue,"validData", 16, "Country of birth", CountryOfBirth);
		setExcelData(colKey,colValue,"validData", 17, "Social Security Number", "*********");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}









	// Permanent Resident or Refugee  ----- Not a US citizen but a Resident
	public void visaType_PermResRefugee(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		WebElement elementToScrollTo2 = findElement("visaTypeDropdown_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		Thread.sleep(3000);
		click("visaTypeDropdown_XPATH");
		//		Thread.sleep(5000);

		List<WebElement> visa = getDriver().findElements(By.xpath("//ul[@role='listbox']//li[contains(text(),'Permanent resident')] | //ul[@role='listbox']//li[contains(text(),'Refugee')]"));
		ArrayList<Integer> randomvisa = getRandomNumber(0, visa.size(), 1);
		for(int ran:randomvisa)
		{
			//			Thread.sleep(2000);
			WebElement elementToScrollTo21 = getDriver().findElement(By.xpath("//ul[@role='listbox']//li[contains(text(),'Permanent resident')]"));
			this.js = (JavascriptExecutor) getDriver();
			//			Thread.sleep(1000);
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
			getDriver().findElement(By.xpath("(//ul[@role='listbox']//li[contains(text(),'Permanent resident')] | //ul[@role='listbox']//li[contains(text(),'Refugee')])["+ran+"]")).click();
			//			Thread.sleep(2000);
		}

		// Text of the Randomly choose Which type of visa will you be holding?
		String visaType = findElement("visaTypeDropdown_XPATH").getText();
		WebElement elementToScrollTo21 = findElement("countryOfCitizenship_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
		findElement("countryOfCitizenship_XPATH").click();
		Thread.sleep(500);
		List<WebElement> coun = getDriver().findElements(By.xpath("//ul[@role='listbox']//li"));
		ArrayList<Integer> randomCoun = getRandomNumber(0, coun.size(), 1);
		for(int ran:randomCoun)
		{
			Thread.sleep(2000);
			getDriver().findElement(By.xpath("(//ul[@role='listbox']//li)["+ran+"]")).click();	
			Thread.sleep(1000);	
		}
		click("CountryOfBirthDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> birth = getDriver().findElements(By.xpath("//ul[@role='listbox']//li"));
		ArrayList<Integer> randombirth = getRandomNumber(0, birth.size(), 1);
		for(int ran:randombirth)
		{
			Thread.sleep(1000);	
			getDriver().findElement(By.xpath("(//ul[@role='listbox']//li)["+ran+"]")).click();
			Thread.sleep(1000);		}

		WebElement elementToScrollTo = findElement("countryOfCitizenship_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		String countryOfCitizenship = findElement("countryOfCitizenship_XPATH").getText();
		WebElement elementToScrollTo1 = findElement("CountryOfBirthDD_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		String CountryOfBirth = findElement("CountryOfBirthDD_XPATH").getText();


		// Generate random 9 digit SSN Number
		Random random = new Random();
		int randomNineDigitNumber;
		do {
			randomNineDigitNumber = random.nextInt(900000000) + 100000000;
		} while (randomNineDigitNumber == 100000000);
		// Convert the random number to a string
		String randomNumberString = String.valueOf(randomNineDigitNumber);
		// Send the random SSN number to the text field
		WebElement elementToScrollTo4 = findElement("SSN_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
		type("SSN_XPATH",randomNumberString);

		Thread.sleep(1000);
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 13, "U.S. citizenship", "I am not a U.S. citizen");
		setExcelData(colKey,colValue,"validData", 14, "Which type of visa will you be holding?", visaType);
		setExcelData(colKey,colValue,"validData", 15, "Country of citizenship",countryOfCitizenship);
		setExcelData(colKey,colValue,"validData", 16, "Country of birth", CountryOfBirth);
		setExcelData(colKey,colValue,"validData", 17, "Social Security Number", "*********");
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}




	public void ArmedForceReserveOrNationalGuardian_Military(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		WebElement elementToScrollTo1 = getDriver().findElement(By.xpath("//span[.=' Affiliation to U.S. Uniformed Services']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		// Validate for Active Duty
		click("USuniformedDD_XPATH");
		Thread.sleep(2500);
		click("ServiceMemberOrVeteran_XPATH");
		Thread.sleep(1000);

		//click on either armedforce or national guard
		List<WebElement> status = getDriver().findElements(By.xpath("(//input[@value='National Guard']) | (//input[@value='Armed Forces Reserve'])"));
		ArrayList<Integer> randomStatus = getRandomNumber(0, status.size(), 1);
		for(int ran:randomStatus)
		{
			Thread.sleep(1000);
			getDriver().findElement(By.xpath("((//input[@value='National Guard']) | (//input[@value='Armed Forces Reserve']))["+ran+"]")).click();
			String AForNGtext=	getDriver().findElement(By.xpath("((//input[@value='National Guard']) | (//input[@value='Armed Forces Reserve']))["+ran+"]")).getAttribute("value");
			Thread.sleep(1000);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 28, "Military status", AForNGtext);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		Thread.sleep(1000);



		// Select the Branch of service
		WebElement elementToScrollTo11 = findElement("SpouseServiceBranchDD_XPATH");
		Thread.sleep(1000);
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		log.debug("Select your spouse or guardian’s branch of service:");
		Thread.sleep(1000);
		click("SpouseServiceBranchDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		randomOption.click();
		selectedBranchText.set(findElement("SpouseServiceBranchDD_XPATH").getText());
		log.debug("Branch : " + selectedBranchText.get());
		// Apply for Department of Veterans Affairs
		WebElement elementToScrollTo111 = getDriver().findElement(By.xpath("//h3[.=' I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: ']"));
		this.js = (JavascriptExecutor) getDriver();
		Thread.sleep(500);
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
		// Choose randomly -- YES or NO
		List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='veterans_benefits_radio']"));
		int Count = radioButtons.size();
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons.get(randomIndex).click();
		if(selectedOption.contains("Y"))
		{
			departmentOfVeterans.set("Yes") ;
			log.debug(" I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: " + "Yes");
		}
		if(selectedOption.contains("N"))
		{
			departmentOfVeterans.set("No") ;
			log.debug(" I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: " + "No");
		}
		// I authorize Arizona State University to request my Joint Service Transcript on my behalf.
		WebElement elementToScrollTo = getDriver().findElement(By.xpath("//h3[.=' I authorize Arizona State University to request my Joint Service Transcript on my behalf. ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
		// Choose randomly -- YES or NO
		List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//fieldset[@id='group_request_transcripts']//input"));
		int Count1 = radioButtons1.size();
		Random random11 = new Random();
		int randomIndex11 = random11.nextInt(radioButtons1.size());
		String selectedOption1 = radioButtons1.get(randomIndex11).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons1.get(randomIndex11).click();
		if(selectedOption1.contains("Y"))
		{
			AuthorizeASU.set("Yes") ;
			log.debug(" I authorize Arizona State University to request my Joint Service Transcript on my behalf. " + "Yes");
		}
		if(selectedOption1.contains("N"))
		{
			AuthorizeASU.set("No") ;
			log.debug(" I authorize Arizona State University to request my Joint Service Transcript on my behalf. " + "No");
		}
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 29, "Branch", selectedBranchText.get());
		setExcelData(colKey,colValue,"validData", 30, "I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:", departmentOfVeterans.get());
		setExcelData(colKey,colValue,"validData", 31, " Do you plan to use an education benefit or scholarship through an employer, corporation, foundation or other ASU education partner? ", AuthorizeASU.get());
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}





	public void SaveThePage()
	{
		// Validate the Home Contry ---- To handle Bright verify
		WebElement elementToScrollTo = getDriver().findElement(By.xpath("//span[.=' Home address and phone']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		String 	selectedOptionText	=	getDriver().findElement(By.xpath("//div[@id='home-country-select']")).getText();
		log.debug("Selected Home Country: " + selectedOptionText);
		if(selectedOptionText.contains("United States")|| selectedOptionText.contains("Canada"))
		{
			// Clicks on Continue button
			getDriver().findElement(By.xpath("(//footer//button)[1]")).click();
			boolean BrightVerify = getDriver().findElement(By.xpath("//table[@data-cy='my-info-briteverify-alert-modal-address-phone-table']")).isDisplayed();
			log.debug("Bright Verify is working as expected"+ BrightVerify);
			click("SubmitBrightVerifyBtn_XPATH");
		}
		else
			// Clicks on Continue button
			getDriver().findElement(By.xpath("(//footer//button)[1]")).click();


		log.debug("----------------------------------------------------");




	}








}






























