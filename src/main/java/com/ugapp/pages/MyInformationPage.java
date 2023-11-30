package com.ugapp.pages;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;








import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.ugapp.base.Page;
public class MyInformationPage extends Page
{
	static ArrayList<String> validFormerName = new ArrayList<>();
	static String gender="";
	static String selectedLanguage="";
	static String state="";
	static String selectedOptionText="";
	static String phone = "";
	static String mobile = "";
	static String selectedCountryOfBirthOptionText = "";
	static String Relation = "";
	static String Schooling = "";
	static String AttendedASU = "";
	static String Relation1 = "";
	static String Schooling1 ="";
	static String AttendedASU1 = "";
	static String asuAffiliation = "";
	static String randomASU_affiliateID = "";
	static String selectedBranchServiceOptionText = "";	
	static String departmentOfVeterans = "";
	static String educationbenefit = "";
	static String selectedEmploymentOptionText = "";
	static String selectedBranchText ="";
	static String AuthorizeASU ="";
	static int count = 0;


	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;


	public void ValidateForMyInfo() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(5000);
		WebElement elementToScrollTo1 = findElement("MyInfoTitle_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		String PageTitle	= findElement("MyInfoTitle_XPATH").getText();
		log.debug("Page title :"+" "+PageTitle);
	}


	public void requiredFields() throws Throwable
	{

		//click on save button
		driver.findElement(By.xpath("(//footer//button)[1]")).click();
		Thread.sleep(2000);
		//error message for Legal sex
		try{
			driver.findElement(By.xpath("//legend[@id='group_legal_sex__BV_label_']/following-sibling::div//div[contains(text(),' This is a required field. ')]"));
			System.out.println("The error message for Legal sex is displayed when the field is left empty!");}
		catch(Exception e){	
			System.out.println("The error message for Legal sex is not displayed when the field is left empty!");}
		//error message for primary language
		try{
			driver.findElement(By.xpath("//div[@id='primary_language_select']//li"));
			System.out.println("The error message for Primary language is displayed when the field is left empty!");}
		catch(Exception e){	
			System.out.println("The error message for Primary Language is not displayed when the field is left empty!");}
		//error message for Home address and Phone
		try{
			driver.findElement(By.xpath("//div[@id='home-country-select']//li"));
			System.out.println("The error message for Home address and Phone is displayed when the field is left empty!");}
		catch(Exception e){	
			System.out.println("The error message for Home address and Phone is not displayed when the field is left empty!");}
		//error message for US Citizenship
		try{
			driver.findElement(By.xpath("//legend[@id='group_us_citizen__BV_label_']/following-sibling::div//div[contains(text(),' This is a required field. ')]"));
			System.out.println("The error message for US Citizenship is displayed when the field is left empty!");}
		catch(Exception e){	
			System.out.println("The error message for US Citizenship is not displayed when the field is left empty!");}
		//error message for ASU Affiliation
		try{
			driver.findElement(By.xpath("//legend[@id='group_asu_affiliation__BV_label_']/following-sibling::div//div[contains(text(),' This is a required field. ')]"));
			System.out.println("The error message for ASU Affiliation is displayed when the field is left empty!");}
		catch(Exception e){	
			System.out.println("The error message for ASU Affiliation is not displayed when the field is left empty!");}
		//error message for Affiliation to US Uniformed Service
		try{
			driver.findElement(By.xpath("//div[@id='group_us_uniformed_services']//li"));
			System.out.println("The error message for Affiliation to US Uniformed Service is displayed when the field is left empty!");}
		catch(Exception e){	
			System.out.println("The error message for Affiliation to US Uniformed Service is not displayed when the field is left empty!");}
		//error message for Partner Benefits
		try{
			driver.findElement(By.xpath("//legend[@id='group_education_benefit__BV_label_']/following-sibling::div//div[contains(text(),' This is a required field. ')]"));
			System.out.println("The error message for Partner Benefits is displayed when the field is left empty!");}
		catch(Exception e){	
			System.out.println("The error message for Partner Benefits is not displayed when the field is left empty!");}
		refreshPage();
		Thread.sleep(1000)	;
		waitTillLoaderDisappears();
		driver.manage().window().fullscreen() ;
		Thread.sleep(3000)	;
	}








	public void FormerName(String First_name, String Last_name) throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(2000);
		WebElement elementToScrollTo1 = findElement("AddFormerName_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		boolean FormerNameButton = findElement("AddFormerName_XPATH").isEnabled();
		if(FormerNameButton==true)
		{
			WebElement elementToScrollTo2 = findElement("AddFormerName_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			findElement("AddFormerName_XPATH").click();
			Thread.sleep(1000);
			scrollDown(driver, 1);
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
			List<WebElement> errorElements = driver.findElements(By.xpath(xpath));
			for (WebElement errorElement : errorElements)
			{
				errorMessages.add(errorElement.getText());
			}
		}
		// Perform action based on error messages
		if (errorMessages.isEmpty()) {
			// No error messages found, click on Save button
			WebElement elementToScrollTo2 = findElement("SaveName_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			click("SaveName_XPATH");
		} else {
			// Error messages found, click on Cancel button
			WebElement elementToScrollTo2 = findElement("Cancel_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			click("Cancel_XPATH");
		}
	}








	public void ValidateAddedFormerNames()
	{
		List<WebElement> FormerNameslist = driver.findElements(By.xpath("//table[@data-cy='my-info-former-name-table']//td[1]"));
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
		WebElement elementToScrollTo2 = driver.findElement(By.xpath("//table[@data-cy='my-info-former-name-table']//tbody"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		List<WebElement> editButtons = driver.findElements(By.xpath("//a[@class='text-decoration-none form-name-edit-button']"));
		// Generate a random index to choose a random Edit button
		Random random = new Random();
		int randomIndex = random.nextInt(editButtons.size());
		// Click on the random Edit button
		WebElement randomEditButton = editButtons.get(randomIndex);
		Thread.sleep(1000);
		randomEditButton.click();
		log.debug("Editing the Former Names");
		WebElement elementToScrollFN = findElement("FirstName_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollFN);
		findElement("FirstName_ID").clear();
		Thread.sleep(500);
		findElement("FirstName_ID").sendKeys("FN Edited");
		Thread.sleep(500);
		WebElement elementToScrollLN = findElement("LastName_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollLN);
		findElement("LastName_ID").clear();
		Thread.sleep(500);
		findElement("LastName_ID").sendKeys("LN Edited");
		Thread.sleep(1000);
		WebElement elementToScrollCancel = findElement("Cancel_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollCancel);
		click("Cancel_XPATH");
		Thread.sleep(1000);
		List<WebElement> EditedFormerNameslist = driver.findElements(By.xpath("//a[@class='text-decoration-none form-name-edit-button']"));
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
		WebElement elementToScrollTo2 = driver.findElement(By.xpath("(//tbody)[1]"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		List<WebElement> editButtons = driver.findElements(By.xpath("//a[@class='text-decoration-none form-name-edit-button']"));
		// Generate a random index to choose a random Edit button
		Random random = new Random();
		int randomIndex = random.nextInt(editButtons.size());
		// Click on the random Edit button
		WebElement randomEditButton = editButtons.get(randomIndex);
		randomEditButton.click();
		log.debug("Editing the Former Names");
		WebElement elementToScrollFN = findElement("FirstName_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollFN);
		findElement("FirstName_ID").clear();
		Thread.sleep(500);
		findElement("FirstName_ID").sendKeys("FN Edited");
		Thread.sleep(500);
		WebElement elementToScrollLN = findElement("LastName_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollLN);
		findElement("LastName_ID").clear();
		Thread.sleep(500);
		findElement("LastName_ID").sendKeys("LN Edited");
		Thread.sleep(500);
		WebElement elementToScrollSave = findElement("SaveName_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollSave);
		click("SaveName_XPATH");
		Thread.sleep(1000);
		List<WebElement> EditedFormerNameslist1 = driver.findElements(By.xpath("//a[@class='text-decoration-none form-name-edit-button']"));
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
		WebElement elementToScrollTo2 = driver.findElement(By.xpath("//table[@data-cy='my-info-former-name-table']//tbody"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		Thread.sleep(1000);
		List<WebElement> deleteButtons = driver.findElements(By.xpath("//a[@class='text-dark-3 ml-space-xs']"));
		// Generate a random index to choose a random Delete button
		Random random = new Random();
		int randomIndex = random.nextInt(deleteButtons.size());
		Thread.sleep(1000);
		// Click on the random Edit button
		WebElement randomDeleteButton = deleteButtons.get(randomIndex);
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", randomDeleteButton);
		randomDeleteButton.click();
		log.debug("Deleting the Former Name");
		Thread.sleep(500);
		WebElement elementToScrollCancel = findElement("Cancel_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollCancel);
		click("Cancel_XPATH");
		Thread.sleep(1000);
		scrollUp(driver, 1);
		Thread.sleep(1000);
		WebElement elementToScrollTo = driver.findElement(By.xpath("//table[@data-cy='my-info-former-name-table']//tbody"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		List<WebElement> deleteButtons1 = driver.findElements(By.xpath("//a[@class='text-dark-3 ml-space-xs']"));
		int randomIndex1 = random.nextInt(deleteButtons1.size());
		// Click on the random Edit button
		WebElement randomDeleteButton1 = deleteButtons1.get(randomIndex1);
		randomDeleteButton1.click();
		log.debug("Deleting the Former Name");
		Thread.sleep(1000);
		WebElement elementToScrollDelete = findElement("Delete_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollDelete);
		click("Delete_XPATH");
		// Validate for the Deleted Former Name using Size
		List<WebElement> FormerNameslist = driver.findElements(By.xpath("//table[@data-cy='my-info-former-name-table']//td[1]"));
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
		List<WebElement> names = driver.findElements(By.xpath("//table[@data-cy='my-info-former-name-table']//td[1]"));
		int i=1;
		for(WebElement name : names)
		{
			String text=driver.findElement(By.xpath("(//table[@data-cy='my-info-former-name-table']//td[1])["+i+"]")).getText();
			i++;
			validFormerName.add(text);
		}








		value1 = MyInformationPage.validFormerName.get(0);
		value2 = MyInformationPage.validFormerName.get(1);
		value3 = MyInformationPage.validFormerName.get(2);
		value4 = MyInformationPage.validFormerName.get(3);
		value5 = MyInformationPage.validFormerName.get(4);
		value6 = MyInformationPage.validFormerName.get(5);
		value7 = MyInformationPage.validFormerName.get(6);
		value8 = MyInformationPage.validFormerName.get(7);
		value9 = MyInformationPage.validFormerName.get(8);




		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 6, "Former name(s)", value1, value2, value3, value4, value5, value6, value7, value8, value9);
		saveReport();
	}




	public void chooseLegalSex(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo2 = driver.findElement(By.xpath("//span[.=' Legal sex']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		log.debug("Choose a Legal sex");
		// Choose random gender
		Thread.sleep(2000);
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='legal_sex_group']"));
		int Count = radioButtons.size();
		// Generate a random index
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		// Get the text of the randomly selected radio button
		String selectedGender = radioButtons.get(randomIndex).getAttribute("value");
		// Click the randomly selected radio button
		Thread.sleep(1000);
		radioButtons.get(randomIndex).click();
		Thread.sleep(1000);
		if(selectedGender.contains("M"))
		{
			gender = "Male";
			System.out.println("Selected Gender: " + "Male");
			log.debug("Selected Gender: " + "Male");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 7, "Legal sex", gender);
			saveReport();
		}
		else {
			gender = "Female";
			System.out.println("Selected Gender: " + "Female");
			log.debug("Selected Gender: " + "Female");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 7, "Legal sex", gender);
			saveReport();
		}
	}








	public void ValidateProfileLink()
	{
		log.debug("Validating the Profile link");
		// validate the Text for the link
		WebElement linkElement = driver.findElement(By.linkText("profile"));
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
		WebElement elementToScrollTo2 = driver.findElement(By.xpath("//h3[.=' Primary language spoken at home ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		log.debug("Choose the Primary language");
		Thread.sleep(2000);
		//Select a random lang
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='primary_language_select']")));
		WebElement elementToScrollPrimaryLang = findElement("SelectPrimaryLangDD_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollPrimaryLang);
		click("SelectPrimaryLangDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
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
		String 	selectedLanguage	=	driver.findElement(By.xpath("//div[@id='primary_language_select']")).getText();
		log.debug("Selected Primary language option: " + selectedLanguage);
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 8, "Primary language spoken at home", selectedLanguage);
		saveReport();
	}








	public void HomeAddAndPhone() throws Exception
	{
		Thread.sleep(2000);
		log.debug("Choose the Home address");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement elementToScrollTo = driver.findElement(By.xpath("//span[.=' Home address and phone']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		driver.findElement(By.xpath("//div[@id='home-country-select']")).click();
		//Validate US flow
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		ArrayList<Integer> randomCountry = getRandomNumber(1, options.size(), 1);
		int Options = options.size();
		for(int ran:randomCountry)
		{
			driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+ran+"]")).click();
			Thread.sleep(1000);
		}
	}




	//to concat the city and state with the country selected  in My Info page 1
	public static String state()
	{
		return stateSelected = "Test City,"+state+selectedOptionText;
	}












	public void address(String AddressLine1 , String AddressLine2 ,String City , String Zip, String State,String Phone_Number, String Mobile_Number) throws Exception
	{
		selectedOptionText	=	driver.findElement(By.xpath("//div[@id='home-country-select']")).getText();
		log.debug("Selected Home Country: " + selectedOptionText);
		if(!selectedOptionText.contains("United States"))
		{
			WebElement elementToScrollTo = findElement("AddLine1_ID");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			type("AddLine1_ID",AddressLine1);
			Thread.sleep(2000);
			WebElement elementToScrollTo1 = findElement("AddLine2_ID");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			type("AddLine2_ID",AddressLine2);
			Thread.sleep(2000);
			WebElement stateElement = driver.findElement(By.id("address_state"));
			if (stateElement.getTagName().equals("div"))
			{
				// It's a dropdown
				log.debug("State is a dropdown.");
				click("StateDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
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
				String 	selectedStateText	=	driver.findElement(By.xpath("//div[@id='address_state']")).getText();
				state = driver.findElement(By.xpath("//div[@id='address_state']//span")).getText();
				log.debug("Selected Home State : " + selectedStateText);
			}
			else if (stateElement.getTagName().equals("input"))
			{
				// It's a textfield
				log.debug("State is a textfield.");
				type("StateTextfield_ID",State);
				state = "Test State";
			}
			else
			{
				// It's neither a dropdown nor a textfield
				log.debug("State is neither a dropdown nor a textfield.");
			}
			WebElement elementToScrollTo2 = findElement("City_ID");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			type("City_ID",City);
			Thread.sleep(2000);
			WebElement elementToScrollTo3 = findElement("ZIPcode_ID");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo3);
			type("ZIPcode_ID",Zip);
			Thread.sleep(2000);
			WebElement elementToScrollTo4 = findElement("PhoneNo_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
			type("PhoneNo_XPATH",Phone_Number);
			Thread.sleep(2000);
			WebElement elementToScrollTo5 = findElement("MobileNo_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo5);
			type("MobileNo_XPATH",Mobile_Number);
			Thread.sleep(2000);






			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey,colNumValue,"validData", 9, "Home address", "Test Address line1 Test Address line2",City+","+state+","+selectedOptionText,"12345-678910");
			saveReport();
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey,colNumValue,"validData", 10, "Phone", Phone_Number);
			setExcelData(colNumKey,colNumValue,"validData", 11, "Mobile phone", Mobile_Number);
			saveReport();
		}
		if(selectedOptionText.contains("United States"))
		{
			log.debug("Selected Home Country :"+selectedOptionText );
			WebElement elementToScrollTo = findElement("AddLine1_ID");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			type("AddLine1_ID",AddressLine1);
			Thread.sleep(2000);
			WebElement elementToScrollTo1 = findElement("AddLine2_ID");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			type("AddLine2_ID",AddressLine2);
			Thread.sleep(2000);
			WebElement stateElement = driver.findElement(By.id("address_state"));
			if (stateElement.getTagName().equals("div"))
			{
				// It's a dropdown
				log.debug("State is a dropdown.");
				click("StateDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
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
				String 	selectedStateText	=	driver.findElement(By.xpath("//div[@id='address_state']")).getText();
				state=driver.findElement(By.xpath("//div[@id='address_state']//span")).getText();
				log.debug("Selected Home State : " + selectedStateText);
			}
			else if (stateElement.getTagName().equals("input"))
			{
				// It's a textfield
				log.debug("State is a textfield.");
				type("StateTextfield_ID",State);
				state = "Test State";
			}
			else
			{
				// It's neither a dropdown nor a textfield
				log.debug("State is neither a dropdown nor a textfield.");
			}
			WebElement elementToScrollTo2 = findElement("City_ID");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			type("City_ID",City);
			Thread.sleep(2000);
			WebElement elementToScrollTo3 = findElement("ZIPcode_ID");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo3);
			type("ZIPcode_ID",Zip);
			Thread.sleep(2000);
			WebElement elementToScrollTo4 = findElement("USPhoneNo1_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
			type("USPhoneNo1_XPATH","111");
			Thread.sleep(2000);
			WebElement elementToScrollTo5 = findElement("USPhoneNo2_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo5);
			type("USPhoneNo2_XPATH","111-1111");
			Thread.sleep(2000);








			Thread.sleep(2000);
			WebElement elementToScrollTo6 = findElement("USMobileNo1_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo6);
			type("USMobileNo1_XPATH","000");








			Thread.sleep(2000);
			WebElement elementToScrollTo7 = findElement("USMobileNo2_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo7);
			type("USMobileNo2_XPATH","000-0000");








			phone = "111-1111111";
			mobile = "000-0000000";
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey,colNumValue,"validData", 9, "Home address", "Test Address line1 Test Address line2",City+","+state+","+selectedOptionText,"12345-678910");
			saveReport();
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colNumKey,colNumValue,"validData", 10, "Phone", Phone_Number);
			setExcelData(colNumKey,colNumValue,"validData", 11, "Mobile phone", Mobile_Number);
			saveReport();
		}
	}






	public void validateAddress(String AddressLine1 , String AddressLine2 ,String City , String Zip, String State, String Phone_Number,String Mobile_Number)
	{
		//error message validation for addressline 1
		try
		{
			if(AddressLine1.length() > 42)
			{
				String errorAddressLine1 = driver.findElement(By.xpath("//input[@id='address_line_1_input']/following-sibling::div[contains(text(),' Should not be more than 42 characters. ')]")).getText();
				Assert.assertEquals(errorAddressLine1, "Should not be more than 42 characters.");
				findElement("AddLine1_ID").clear();
			}
		}catch(Exception e) {}
		//error message validation for addressline2
		try
		{
			if(AddressLine2.length() > 42)
			{
				String errorAddressLine2 = driver.findElement(By.xpath("//input[@id='address_line_2_input']/following-sibling::div[contains(text(),' Should not be more than 42 characters. ')]")).getText();
				Assert.assertEquals(errorAddressLine2, "Should not be more than 42 characters.");
				findElement("AddLine2_ID").clear();
			}
		}catch(Exception e) {}
		//error message validation for city
		try
		{
			if(City.length()>30)
			{
				String errorCity = driver.findElement(By.xpath("//input[@id='city_input']/following-sibling::div[contains(text(),' The city should not be more than 30 characters. ')]")).getText();
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
				String errorState = driver.findElement(By.xpath("//input[@id='address_state']/following-sibling::div[contains(text(),' The state should not be more than 30 characters. ')]")).getText();
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
		WebElement elementToScrollTo2 = driver.findElement(By.xpath("//span[.='Ethnic/racial background']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		Thread.sleep(2000);
		log.debug("Choose the Ethnicity");
		// Choose Ethnicity randomly -- YES or NO
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='hispanic_latino_radio']"));
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
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			click("EthnicityDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
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
			String 	selectedEthnicityOptionText	=	driver.findElement(By.xpath("//div[@id='hispanic_latino_origin']")).getText();
			log.debug("Selected Hispanic/Latino origin option: " + selectedEthnicityOptionText);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",selectedEthnicityOptionText);
			saveReport();


		}
		else {
			log.debug("Are you Hispanic/Latino?" +" " +"No");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ","None");
			saveReport();


		}




		WebElement elementToScrollTo21 = findElement("RacialDD_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
		log.debug("Choose the Race");
		click("RacialDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random2 = new Random();
		int randomIndex2 = random2.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex2);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		//CLOSE THE DD----------------------
		Actions actions = new Actions(driver);
		WebElement element = findElement("RacialDD_XPATH");
		actions.sendKeys(element, "\uE00C").perform();
		// Get the text of the chosen random option
		WebElement elementToScrollTo = findElement("RacialDD_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		String 	SelectedRace	=	driver.findElement(By.xpath("//div[@id='applicants_race']//span")).getText();
		log.debug("Selected Race option: " + SelectedRace);


		if(SelectedRace.contains("White"))
		{
			log.debug("Applicant race :"+" "+SelectedRace);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",SelectedRace);
			saveReport();
		}
		if(SelectedRace.contains("Black or African American"))
		{
			log.debug("Applicant race :"+" "+SelectedRace);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",SelectedRace);
			saveReport();
		}
		if(SelectedRace.contains("Asian"))
		{
			// Select random Asian race
			WebElement elementToScrollTo211 = findElement("AsianDD_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo211);
			click("AsianDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> Asianoptions = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Asianoptionslist = Asianoptions.size();
			Random randomlist1 = new Random();
			int randomIndex1 = randomlist1.nextInt(Asianoptions.size());
			WebElement randomOption1 = Asianoptions.get(randomIndex1);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			// Get the text of the chosen random option
			String 	selectedOptionText1	=	driver.findElement(By.xpath("//div[@id='Asian_origin']")).getText();
			log.debug("Selected Asian option: " + selectedOptionText1);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",selectedOptionText1);
			saveReport();
		}
		if(SelectedRace.contains("American Indian/Alaska Native"))
		{
			// Select random American Indian/Alaska Native race
			WebElement elementToScrollTo211 = findElement("AmericanAlaskaDD_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo211);
			click("AmericanAlaskaDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> AmericanAlaskaOptions = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int AmericanAlaskaOptionslist = AmericanAlaskaOptions.size();
			Random randomlist1 = new Random();
			int randomIndex1 = randomlist1.nextInt(AmericanAlaskaOptions.size());
			WebElement randomOption1 = AmericanAlaskaOptions.get(randomIndex1);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			// Get the text of the chosen random option
			String 	selectedOptionText1	=	driver.findElement(By.xpath("//div[@id='American Indian/Alaska Native_origin']")).getText();
			log.debug("Selected American Indian/Alaska Native option: " + selectedOptionText1);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",selectedOptionText1);
			saveReport();
		}
		if(SelectedRace.contains("Native Hawaiian/Pac Islander"))
		{
			// Select random Native Hawaiian/Pace race
			WebElement elementToScrollTo211 = findElement("NativeHawaiianPacIslanderDD_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo211);
			click("NativeHawaiianPacIslanderDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> NativeHawaiianPacIslanderOptions = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int NativeHawaiianPacIslanderOptionslist = NativeHawaiianPacIslanderOptions.size();
			Random randomlist1 = new Random();
			int randomIndex1 = randomlist1.nextInt(NativeHawaiianPacIslanderOptions.size());
			WebElement randomOption1 = NativeHawaiianPacIslanderOptions.get(randomIndex1);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			// Get the text of the chosen random option
			String 	selectedOptionText1	=	driver.findElement(By.xpath("//div[@id='Native Hawaiian/Pac Islander_origin']")).getText();
			log.debug("Selected Native Hawaiian/Pac Islander option: " + selectedOptionText1);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",selectedOptionText1);
			saveReport();




		}
		if (isElementPresent("PrimaryRaceHeader_XPATH")) {
			// Element is present, perform your actions here
			WebElement elementToScrollTo1 = findElement("PrimaryRaceHeader_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			WebElement element1 = findElement("PrimaryRaceHeader_XPATH");
			if(element1.isDisplayed())
			{
				log.debug("Choose the Primary Race");	
				WebElement elementToScroll = findElement("PrimaryRaceDD_XPATH");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
				click("PrimaryRaceDD_XPATH");
				Thread.sleep(2000);
				List<WebElement> PrimaryRaceOptions = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int PrimaryRaceOptionslist = PrimaryRaceOptions.size();
				Random randomRacelist = new Random();
				int randomIndex3 = randomRacelist.nextInt(PrimaryRaceOptions.size());
				WebElement randomOption3 = PrimaryRaceOptions.get(randomIndex3);
				randomOption3.click();
				// Get the text of the chosen random option
				String 	ReportingPreferred	=	driver.findElement(By.xpath("//div[@id='primary_race_select']")).getText();
				log.debug("Selected Primary Race option: " + ReportingPreferred);
				String 	selectedEthnicityOptionText	=	driver.findElement(By.xpath("//div[@id='hispanic_latino_origin']")).getText();
				if(ReportingPreferred.equals(selectedEthnicityOptionText))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",selectedEthnicityOptionText+" (Reporting Preferred)",SelectedRace);
					saveReport();
				}
				if(ReportingPreferred.equals(SelectedRace))
				{
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 12, "Ethnic/racial background ",SelectedRace+" (Reporting Preferred)",selectedEthnicityOptionText);
					saveReport();
				}
			}
		} else {
			// Element is not present, handle the situation accordingly
			log.debug("Primary Race header element is not available");
		}
	}


	public void US_Citizenship(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo2 = findElement("USCitizen_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		log.debug("Choose the Citizenship as U.S Citizen");
		// Click on I am a U.S citizen
		click("USCitizen_XPATH");
		Thread.sleep(1000);
		WebElement elementToScrollTo3 = findElement("CountryOfBirthDD_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo3);
		log.debug("Choose the Country of Birth");
		click("CountryOfBirthDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
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
		selectedCountryOfBirthOptionText	=	driver.findElement(By.xpath("//div[@id='country_of_birth']")).getText();
		log.debug("Selected option: " + selectedCountryOfBirthOptionText);
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
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
		type("SSN_XPATH",randomNumberString);




		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 13, "U.S. citizenship", "I am a U.S. citizen");
		setExcelData(colKey,colValue,"validData", 14, "Country of citizenship", "United States");
		setExcelData(colKey,colValue,"validData", 15, "Country of birth", selectedCountryOfBirthOptionText);
		setExcelData(colKey,colValue,"validData", 16, "Social Security Number", "*********");
		saveReport();
	}


	public void ParentName(String First_name, String Last_name) throws InterruptedException
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement elementToScrollTo = driver.findElement(By.xpath("//span[.=' Parent or legal guardian']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		if (isElementPresent("AdditionalParentBtn_XPATH"))
		{
			// Element is present, perform your actions here
			WebElement element1 = findElement("AdditionalParentBtn_XPATH");
			if(element1.isDisplayed())
			{
				log.debug("Adding the Additional Parent Info");	
				WebElement elementToScrollToAddParent = findElement("AdditionalParentBtn_XPATH");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToAddParent);
				click("AdditionalParentBtn_XPATH");
			}
		}	
		//Add Parent First and Last names
		WebElement elementToScrollToAddParent = findElement("GuardianFN_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToAddParent);
		type("GuardianFN_ID", First_name);
		WebElement elementToScrollToAddParent1 = findElement("GuardianLN_ID");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToAddParent1);
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
			List<WebElement> errorElements = driver.findElements(By.xpath(xpath));
			for (WebElement errorElement : errorElements)
			{
				errorMessages.add(errorElement.getText());
			}
		}
		// Perform action based on error messages
		if (errorMessages.isEmpty()) {
			// No error messages found,-------------------
			// Choose Is Person living randomly -- YES or NO
			WebElement elementToScrollTo4 = driver.findElement(By.xpath("//h3[.=' Is this person living? ']"));
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
			log.debug("Randomly choose - Is this person living?");
			List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='guardian_is_living_radio']"));
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
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo5);
				log.debug("Entering a Test Email ID");
				type("GuradianEmail_ID","email@test.asu.edu");
				// Generate a random phone number with a maximum of 15 digits
				Random randomPhoneNO = new Random();
				long phoneNumber = (long) (randomPhoneNO.nextDouble() * Math.pow(10, 15));
				// Ensure the phone number does not exceed 15 digits
				String phoneNumberString = String.format("%015d", phoneNumber);
				// Print the random phone number
				WebElement elementToScrollTo6 = findElement("GuradianPhoneNo_ID");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo6);
				type("GuradianPhoneNo_ID",phoneNumberString);
				// Randomly choose Relation
				WebElement elementToScrollTo = findElement("RelationDD_XPATH");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				click("RelationDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				// Generate a random index to choose a option
				Random random1 = new Random();
				int randomIndex1 = random1.nextInt(options.size());
				// Click on the random option
				WebElement randomOption = options.get(randomIndex1);
				Thread.sleep(1000);
				randomOption.click();
				Thread.sleep(1000);
				// Get the text of the chosen random option
				String 	selectedOptionText	=	driver.findElement(By.xpath("//div[@id='guardian_guardianRelation_select']")).getText();
				log.debug("Selected Relation: " + selectedOptionText);
				//Randomly choose the Highest level of schooling
				WebElement elementToScrollTo1 = findElement("HighestLevelOfSchooling_XPATH");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				click("HighestLevelOfSchooling_XPATH");
				Thread.sleep(1000);
				List<WebElement> options1 = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random2 = new Random();
				int randomIndex2 = random2.nextInt(options1.size());
				// Click on the random Option
				WebElement randomOption1= options1.get(randomIndex2);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				// Get the text of the chosen random option
				String 	selectedOptionText1	=	driver.findElement(By.xpath("//div[@id='guardian_highestSchoolingLevel_select']")).getText();
				log.debug("Selected Highest level of schooling: " + selectedOptionText1);
				//Randomly choose Did this guardian attend ASU?
				WebElement elementToScrollTo2 = driver.findElement(By.xpath("//h3[.=' Did this guardian attend ASU? ']"));
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
				List<WebElement> radioButtons1 = driver.findElements(By.xpath("//input[@name='guardian_attended_asu_radio']"));
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
					setExcelData(colNumKey,colNumValue,"validData", 20, "Parent or Legal Guardian Attended ASU", "Yes");
					saveReport();
					if(count==1)
					{
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colNumKey,colNumValue,"validData", 24, "Parent or Legal Guardian Attended ASU", "Yes");
						saveReport();
					}
				}
				if(selectedOption1.contains("false"))
				{
					log.debug("Did this guardian attend ASU? : " + "No");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colNumKey,colNumValue,"validData", 20, "Parent or Legal Guardian Attended ASU", "No");
					saveReport();
					if(count==1)
					{
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colNumKey,colNumValue,"validData", 24, "Parent or Legal Guardian Attended ASU", "No");
						saveReport();
					}
				}
				WebElement elementToScrollTo11 = findElement("SaveParentInfo_XPATH");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
				click("SaveParentInfo_XPATH");
			}
			if(selectedOption.contains("false"))
			{
				log.debug("Is this person living: No");
				// Randomly choose Relation
				WebElement elementToScrollTo = findElement("RelationDD_XPATH");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				click("RelationDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				// Generate a random index to choose a random Edit button
				Random random1 = new Random();
				int randomIndex1 = random1.nextInt(options.size());
				// Click on the random Edit button
				WebElement randomOption = options.get(randomIndex1);
				Thread.sleep(1000);
				randomOption.click();
				Thread.sleep(1000);
				// Get the text of the chosen random option
				String 	selectedOptionText	=	driver.findElement(By.xpath("//div[@id='guardian_guardianRelation_select']")).getText();
				log.debug("Selected Relation: " + selectedOptionText);
				//Randomly choose the Highest level of schooling
				WebElement elementToScrollToHighestSchool = findElement("HighestLevelOfSchooling_XPATH");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToHighestSchool);
				click("HighestLevelOfSchooling_XPATH");
				Thread.sleep(1000);
				List<WebElement> options1 = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random2 = new Random();
				int randomIndex2 = random2.nextInt(options1.size());
				// Click on the random Option
				WebElement randomOption1= options1.get(randomIndex2);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				// Get the text of the chosen random option
				String 	selectedOptionText1	=	driver.findElement(By.xpath("//div[@id='guardian_highestSchoolingLevel_select']")).getText();
				log.debug("Selected Highest level of schooling: " + selectedOptionText1);
				//Randomly choose Did this guardian attend ASU?
				WebElement elementToScrollTo2 = driver.findElement(By.xpath("//h3[.=' Did this guardian attend ASU? ']"));
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
				List<WebElement> radioButtons1 = driver.findElements(By.xpath("//input[@name='guardian_attended_asu_radio']"));
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
						setExcelData(colNumKey,colNumValue,"validData", 24, "Parent or Legal Guardian Attended ASU", "Yes");
						saveReport();
					}


				}
				if(selectedOption1.contains("false")) 
				{
					log.debug("Did this guardian attend ASU? : " + "No");
					if(count==1)
					{
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colNumKey,colNumValue,"validData", 24, "Parent or Legal Guardian Attended ASU", "Yes");
						saveReport();
					}
				}
				WebElement elementToScrollTo1 = findElement("SaveParentInfo_XPATH");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				click("SaveParentInfo_XPATH");
			}
		}
		else
		{
			// Error messages found, click on Clear fields button
			WebElement elementToScrollToAddParent = findElement("ClearFields_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToAddParent);
			click("ClearFields_XPATH");
		}
		count++;
	}








	public void ValidateAddedParentNames() throws EncryptedDocumentException, Exception
	{
		// Validate add max of 2 parent info
		List<WebElement> ParentNameslist = driver.findElements(By.xpath("//table[@data-cy='my-info-parent-legal-guardian-details-table']//td[1]"));
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
		WebElement elementToScrollTo = driver.findElement(By.xpath("(//*[text()=' Parent or legal guardians ']/../../..//a[contains(text(),' Edit ')])[1]"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);	
		driver.findElement(By.xpath("(//*[text()=' Parent or legal guardians ']/../../..//a[contains(text(),' Edit ')])[1]")).click();
		Thread.sleep(1000);
		Relation = driver.findElement(By.xpath("//div[@id='guardian_guardianRelation_select']//span")).getText();
		Schooling = driver.findElement(By.xpath("//div[@id='guardian_highestSchoolingLevel_select']//span")).getText();
		AttendedASU = driver.findElement(By.xpath("//fieldset[@id='group_guardian_attended_asu']//div[@data-cy='radio-group']//span")).getText();
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 17, "Parent or legal guardian", "Parent FN Parent LN I");
		saveReport();
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 18, "Parent or Legal Guardian Relation", Relation);
		saveReport();
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 19, "Parent or Legal Guardian Schooling Level", Schooling);
		saveReport();


		WebElement elementToScrollTo1 = findElement("SaveParentInfo_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("SaveParentInfo_XPATH");








		//Second parent/gaurdian
		WebElement elementToScrollTo11 = driver.findElement(By.xpath("(//*[text()=' Parent or legal guardians ']/../../..//a[contains(text(),' Edit ')])[2]"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);	
		driver.findElement(By.xpath("(//*[text()=' Parent or legal guardians ']/../../..//a[contains(text(),' Edit ')])[2]")).click();
		Thread.sleep(1000);
		Relation1 = driver.findElement(By.xpath("//div[@id='guardian_guardianRelation_select']//span")).getText();
		Schooling1 = driver.findElement(By.xpath("//div[@id='guardian_highestSchoolingLevel_select']//span")).getText();
		AttendedASU1 = driver.findElement(By.xpath("//fieldset[@id='group_guardian_attended_asu']//div[@data-cy='radio-group']//span")).getText();
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 21, "Additional parent or legal guardian", "Parent FN Parent LN II");
		setExcelData(colKey,colValue,"validData", 22, "Parent or Legal Guardian Relation", Relation1);
		setExcelData(colKey,colValue,"validData", 23, "Parent or Legal Guardian Schooling Level", Schooling1);
		saveReport();
		WebElement elementToScrollTo111 = findElement("SaveParentInfo_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		click("SaveParentInfo_XPATH");


	}








	public void Previous_ASU_affiliation(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		Thread.sleep(2000);
		WebElement elementToScrollTo1 = driver.findElement(By.xpath("//div[@id='asu_affiliation_checkbox_group']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		log.debug("Choose Previous ASU affiliation");
		// Choose random Option
		Thread.sleep(1000);
		List<WebElement> Checkboxes = driver.findElements(By.xpath("//input[@name='asu_affiliation_checkbox']"));
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
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		Thread.sleep(500);
















		int ran = randomIndex+1;
		asuAffiliation = driver.findElement(By.xpath("(//input[@name='asu_affiliation_checkbox']/following-sibling::label//span)["+ran+"]")).getText();
		log.debug("Selected ASU affiliation: " + asuAffiliation);


		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 25, "Previous ASU affiliation", asuAffiliation);
		saveReport();
		log.debug("Selected Previous ASU affiliation: " + selectedOption);
	}








	public void ASU_affiliate_ID(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo1 = driver.findElement(By.xpath("//span[.=' What is your ASU Affiliate ID?']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		// Create a Random 10 digit ASU affiliate ID
		Random random = new Random();
		// Generate a random 10-digit number
		long randomASUaffiliateID = (long) (random.nextDouble() * 9000000000L) + 1000000000L;
		// Convert the random number to a string
		randomASU_affiliateID = Long.toString(randomASUaffiliateID);
		log.debug("Random 10-digit ASU ID: " + randomASU_affiliateID);
		type("ASUaffiliationID_ID",randomASU_affiliateID);
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 26, "Affiliate ID", randomASU_affiliateID);
		saveReport();
	}








	public void SpouseOrDependent_Military(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo1 = driver.findElement(By.xpath("//span[.=' Affiliation to U.S. Uniformed Services']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
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
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		log.debug("Select your spouse or guardian’s branch of service:");
		Thread.sleep(1000);
		click("SpouseServiceBranchDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		randomOption.click();
		selectedBranchServiceOptionText	=	findElement("SpouseServiceBranchDD_XPATH").getText();
		log.debug("Selected Spouse or guardian branch of service : " + selectedBranchServiceOptionText);








		// Department of Veteran Affairs
		WebElement elementToScrollTo111 = driver.findElement(By.xpath("//h3[.=' I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
		// Choose randomly -- YES or NO
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='veterans_benefits_radio']"));
		int Count = radioButtons.size();
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons.get(randomIndex).click();
		if(selectedOption.contains("Y"))
		{
			departmentOfVeterans = "Yes";
			log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:" + "Yes");
		}
		else
		{
			departmentOfVeterans = "No";
			log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:" + "No");
		}




		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 27, "Military status", "I am the spouse/dependent of a U.S. service member or veteran");
		setExcelData(colKey,colValue,"validData", 28, "Branch", selectedBranchServiceOptionText);
		setExcelData(colKey,colValue,"validData", 29, "I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:", departmentOfVeterans);
		saveReport();
	}


	public void ActiveDuty_Military(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo1 = driver.findElement(By.xpath("//span[.=' Affiliation to U.S. Uniformed Services']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		// Validate for Active Duty
		click("USuniformedDD_XPATH");
		Thread.sleep(2500);
		click("ServiceMemberOrVeteran_XPATH");
		Thread.sleep(1000);
		click("ActiveDutyRdBtn_XPATH");
		log.debug("Selected Military status : Active Duty" );

		// Select the Branch of service
		WebElement elementToScrollTo11 = findElement("SpouseServiceBranchDD_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		log.debug("Select your spouse or guardian’s branch of service:");
		Thread.sleep(1000);
		click("SpouseServiceBranchDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		randomOption.click();
		selectedBranchText	=	findElement("SpouseServiceBranchDD_XPATH").getText();
		log.debug("Branch : " + selectedBranchText);


		// Apply for Department of Veterans Affairs
		WebElement elementToScrollTo111 = driver.findElement(By.xpath("//h3[.=' I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
		// Choose randomly -- YES or NO
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='veterans_benefits_radio']"));
		int Count = radioButtons.size();
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons.get(randomIndex).click();
		if(selectedOption.contains("Y"))
		{
			departmentOfVeterans = "Yes";
			log.debug(" I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: " + "Yes");
		}
		if(selectedOption.contains("N"))
		{
			departmentOfVeterans = "No";
			log.debug(" I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: " + "No");
		}




		// I authorize Arizona State University to request my Joint Service Transcript on my behalf.
		WebElement elementToScrollTo = driver.findElement(By.xpath("//h3[.=' I authorize Arizona State University to request my Joint Service Transcript on my behalf. ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
		// Choose randomly -- YES or NO
		List<WebElement> radioButtons1 = driver.findElements(By.xpath("//input[@name='request_transcripts_radio']"));
		int Count1 = radioButtons1.size();
		Random random11 = new Random();
		int randomIndex11 = random11.nextInt(radioButtons1.size());
		String selectedOption1 = radioButtons1.get(randomIndex11).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons1.get(randomIndex11).click();
		if(selectedOption1.contains("Y"))
		{
			AuthorizeASU = "Yes";
			log.debug(" I authorize Arizona State University to request my Joint Service Transcript on my behalf. " + "Yes");
		}
		if(selectedOption1.contains("N"))
		{
			AuthorizeASU = "No";
			log.debug(" I authorize Arizona State University to request my Joint Service Transcript on my behalf. " + "No");
		}
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 27, "Military status", "Active Duty");
		setExcelData(colKey,colValue,"validData", 28, "Branch", selectedBranchText);
		setExcelData(colKey,colValue,"validData", 29, "I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:", departmentOfVeterans);
		setExcelData(colKey,colValue,"validData", 30, "Do you plan to use an education benefit or scholarship through an employer, corporation, foundation or other ASU education partner? ", AuthorizeASU);
		saveReport();
	}


	public void Veteran_Military(String colKey,String colValue) throws EncryptedDocumentException, Exception 
	{
		WebElement elementToScrollTo1 = driver.findElement(By.xpath("//span[.=' Affiliation to U.S. Uniformed Services']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		// Validate for Active Duty
		click("USuniformedDD_XPATH");
		Thread.sleep(1500);
		click("ServiceMemberOrVeteran_XPATH");
		Thread.sleep(1000);
		click("VeteranRdBtn_XPATH");
		log.debug("Selected Military status : Veteran" );


		// Select the Branch of service
		WebElement elementToScrollTo11 = findElement("SpouseServiceBranchDD_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		log.debug("Select your spouse or guardian’s branch of service:");
		Thread.sleep(1000);
		click("SpouseServiceBranchDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		randomOption.click();
		selectedBranchText	=	findElement("SpouseServiceBranchDD_XPATH").getText();
		log.debug("Branch : " + selectedBranchText);


		// Apply for Department of Veterans Affairs
		WebElement elementToScrollTo111 = driver.findElement(By.xpath("//h3[.=' I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
		// Choose randomly -- YES or NO
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='veterans_benefits_radio']"));
		int Count = radioButtons.size();
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons.get(randomIndex).click();
		if(selectedOption.contains("Y"))
		{
			departmentOfVeterans = "Yes";
			log.debug(" I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: " + "Yes");
		}
		if(selectedOption.contains("N"))
		{
			departmentOfVeterans = "No";
			log.debug(" I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: " + "No");
		}




		// I authorize Arizona State University to request my Joint Service Transcript on my behalf.
		WebElement elementToScrollTo = driver.findElement(By.xpath("//h3[.=' I authorize Arizona State University to request my Joint Service Transcript on my behalf. ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
		// Choose randomly -- YES or NO
		List<WebElement> radioButtons1 = driver.findElements(By.xpath("//input[@name='request_transcripts_radio']"));
		int Count1 = radioButtons1.size();
		Random random11 = new Random();
		int randomIndex11 = random11.nextInt(radioButtons1.size());
		String selectedOption1 = radioButtons1.get(randomIndex11).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons1.get(randomIndex11).click();
		if(selectedOption1.contains("Y"))
		{
			AuthorizeASU = "Yes";
			log.debug(" I authorize Arizona State University to request my Joint Service Transcript on my behalf. " + "Yes");
		}
		if(selectedOption1.contains("N"))
		{
			AuthorizeASU = "No";
			log.debug(" I authorize Arizona State University to request my Joint Service Transcript on my behalf. " + "No");
		}
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 27, "Military status", "Veteran");
		setExcelData(colKey,colValue,"validData", 28, "Branch", selectedBranchText);
		setExcelData(colKey,colValue,"validData", 29, "I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:", departmentOfVeterans);
		setExcelData(colKey,colValue,"validData", 30, " Do you plan to use an education benefit or scholarship through an employer, corporation, foundation or other ASU education partner? ", AuthorizeASU);
		saveReport();
	}
	public void NoneOfTheseApply_Military(String colKey,String colValue) throws EncryptedDocumentException, Exception 
	{
		WebElement elementToScrollTo1 = driver.findElement(By.xpath("//span[.=' Affiliation to U.S. Uniformed Services']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		// Validate for None of these options apply to me
		click("USuniformedDD_XPATH");
		Thread.sleep(1500);
		click("NoneOftheseApplytoMe_XPATH");
		Thread.sleep(1000);
		log.debug("Selected Military status : None of these options apply to me" );
	}

	public void Partner_benefits(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo1 = driver.findElement(By.xpath("//span[.=' Partner benefits']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		log.debug("Choose the Partner Benefits");
		// Choose Partner Benefits randomly -- YES or NO
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='education_benefit_radio']"));
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
			educationbenefit = "Yes";
			WebElement elementToScroll = findElement("CurrentEmployerDD_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
			click("CurrentEmployerDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
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
			selectedEmploymentOptionText	=	driver.findElement(By.xpath("//div[@id='current_employer_select']")).getText();
			System.out.println("Selected option: " + selectedEmploymentOptionText);
			log.debug("Selected option: " + selectedEmploymentOptionText);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 31, "Do you plan to use an education benefit or scholarship through an employer, corporation, foundation or other ASU education partner?", educationbenefit);
			setExcelData(colKey,colValue,"validData", 32, "Current employer", selectedEmploymentOptionText);
			saveReport();
		}
		else {
			educationbenefit = "No";
			log.debug("Selected Option: " + "No");
		}
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 31, "Do you plan to use an education benefit or scholarship through an employer, corporation, foundation or other ASU education partner?", educationbenefit);
		saveReport();
	}

	public void NotUSctizenship() throws InterruptedException
	{
		WebElement elementToScrollTo2 = findElement("NotUSCitizenship_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		click("NotUSCitizenship_XPATH");
		Thread.sleep(1000);
	}



	// Permanent Resident or Refugee  ----- Not a US citizen but a Resident
	public void visaType() throws InterruptedException
	{
		findElement("visaTypeDropdown_XPATH").click();

		List<WebElement> visa = driver.findElements(By.xpath("//ul[@role='listbox']//li[contains(text(),'Permanent resident')] | //ul[@role='listbox']//li[contains(text(),'Refugee')]"));
		ArrayList<Integer> randomvisa = getRandomNumber(0, visa.size(), 1);
		for(int ran:randomvisa)
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//ul[@role='listbox']//li[contains(text(),'Permanent resident')] | //ul[@role='listbox']//li[contains(text(),'Refugee')])["+ran+"]")).click();	
		}
		findElement("countryOfCitizenship_XPATH").click();
		Thread.sleep(1000);
		List<WebElement> coun = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		ArrayList<Integer> randomCoun = getRandomNumber(0, coun.size(), 1);
		for(int ran:randomCoun)
		{
			driver.findElement(By.xpath("(//ul[@role='listbox']//li)["+ran+"]")).click();	
		}
		click("CountryOfBirthDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> birth = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		ArrayList<Integer> randombirth = getRandomNumber(0, birth.size(), 1);
		for(int ran:randombirth)
		{
			driver.findElement(By.xpath("(//ul[@role='listbox']//li)["+ran+"]")).click();	
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
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
		type("SSN_XPATH",randomNumberString);
	}




	public void ArmedForceReserveOrNationalGuardian_Military() throws InterruptedException
	{
		WebElement elementToScrollTo1 = driver.findElement(By.xpath("//span[.=' Affiliation to U.S. Uniformed Services']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		// Validate for Active Duty
		click("USuniformedDD_XPATH");
		Thread.sleep(2500);
		click("ServiceMemberOrVeteran_XPATH");
		Thread.sleep(1000);
		
		//click on either armedforce or national guard
        List<WebElement> status = driver.findElements(By.xpath("(//input[@value='National Guard']) | (//input[@value='Armed Forces Reserve'])"));
        ArrayList<Integer> randomStatus = getRandomNumber(0, status.size(), 1);
        for(int ran:randomStatus)
        {
            driver.findElement(By.xpath("((//input[@value='National Guard']) | (//input[@value='Armed Forces Reserve']))["+ran+"]")).click();
        }
        Thread.sleep(1000);
		
		// Select the Branch of service
		WebElement elementToScrollTo11 = findElement("SpouseServiceBranchDD_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		log.debug("Select your spouse or guardian’s branch of service:");
		Thread.sleep(1000);
		click("SpouseServiceBranchDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		randomOption.click();
		selectedBranchText	=	findElement("SpouseServiceBranchDD_XPATH").getText();
		log.debug("Branch : " + selectedBranchText);
		// Apply for Department of Veterans Affairs
		WebElement elementToScrollTo111 = driver.findElement(By.xpath("//h3[.=' I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
		log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
		// Choose randomly -- YES or NO
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='veterans_benefits_radio']"));
		int Count = radioButtons.size();
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons.get(randomIndex).click();
		if(selectedOption.contains("Y"))
		{
			departmentOfVeterans = "Yes";
			log.debug(" I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: " + "Yes");
		}
		if(selectedOption.contains("N"))
		{
			departmentOfVeterans = "No";
			log.debug(" I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above: " + "No");
		}
		// I authorize Arizona State University to request my Joint Service Transcript on my behalf.
		WebElement elementToScrollTo = driver.findElement(By.xpath("//h3[.=' I authorize Arizona State University to request my Joint Service Transcript on my behalf. ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		log.debug("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:");
		// Choose randomly -- YES or NO
		List<WebElement> radioButtons1 = driver.findElements(By.xpath("//fieldset[@id='group_request_transcripts']//input"));
		int Count1 = radioButtons1.size();
		Random random11 = new Random();
		int randomIndex11 = random11.nextInt(radioButtons1.size());
		String selectedOption1 = radioButtons1.get(randomIndex11).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons1.get(randomIndex11).click();
		if(selectedOption1.contains("Y"))
		{
			AuthorizeASU = "Yes";
			log.debug(" I authorize Arizona State University to request my Joint Service Transcript on my behalf. " + "Yes");
		}
		if(selectedOption1.contains("N"))
		{
			AuthorizeASU = "No";
			log.debug(" I authorize Arizona State University to request my Joint Service Transcript on my behalf. " + "No");
		}
	}











	public void SaveThePage()
	{
		// Validate the Home Contry ---- To handle Bright verify
		WebElement elementToScrollTo = driver.findElement(By.xpath("//span[.=' Home address and phone']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		String 	selectedOptionText	=	driver.findElement(By.xpath("//div[@id='home-country-select']")).getText();
		log.debug("Selected Home Country: " + selectedOptionText);
		if(selectedOptionText.contains("United States")|| selectedOptionText.contains("Canada"))
		{
			// Clicks on Continue button
			driver.findElement(By.xpath("(//footer//button)[1]")).click();
			boolean BrightVerify = driver.findElement(By.xpath("//table[@data-cy='my-info-briteverify-alert-modal-address-phone-table']")).isDisplayed();
			log.debug("Bright Verify is working as expected"+ BrightVerify);
			click("SubmitBrightVerifyBtn_XPATH");
		}
		else








			// Clicks on Continue button
			driver.findElement(By.xpath("(//footer//button)[1]")).click();


		log.debug("----------------------------------------------------");




	}








}






























