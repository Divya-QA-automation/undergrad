package com.ugapp.pages;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		waitTillLoaderDisappears();
		Thread.sleep(3000);
		//click on save button
		driver.findElement(By.xpath("(//footer//button)[1]")).click();
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
		waitTillLoaderDisappears();
		driver.manage().window().fullscreen() ;
		Thread.sleep(5000)	;
	}




	public void FormerName(String First_name, String Last_name) throws InterruptedException
	{
		WebElement elementToScrollTo1 = findElement("AddFormerName_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		boolean FormerNameButton = findElement("AddFormerName_XPATH").isEnabled();
		if(FormerNameButton==true)
		{
			WebElement elementToScrollTo2 = findElement("AddFormerName_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			findElement("AddFormerName_XPATH").click();
			System.out.println("clickinggggg");
			Thread.sleep(1000);
			scrollDown(driver, 1);
		}
		else 
		{
			String errorMiddleName = findElement("MaxLimitErrMsg_XPATH").getText();
			Assert.assertEquals(errorMiddleName, "Reached maximum limit ");
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
		System.out.println("isFirstNameValid :"+isFirstNameValid);
		if(isFirstNameValid)
		{
			try {
				String errorFirstName = findElement("FNErrMsg_XPATH").getText();
				Assert.assertEquals(errorFirstName, "The former/alternate first name can only contain letters, spaces and hyphens (-).");
				System.out.println(First_name+errorFirstName);
			}catch(Exception e) {
				if(First_name.length()>25)
				{
					String errorFirstName25 = findElement("errorFirstName25_XPATH").getText();
					Assert.assertEquals(errorFirstName25, "The first name should not be more than 25 characters.");
					System.out.println(First_name+errorFirstName25);
				}

			}
		}
		else
			log.debug("Firstname is not valid");
		System.out.println("FN is not valid");


		//Last_name validation
		boolean isLastNameValid = Last_name.matches(regex);
		log.debug("isLastNameValid :"+isLastNameValid);
		System.out.println("isLastNameValid :"+isLastNameValid);
		if(isLastNameValid)
		{
			try
			{
				String errorLastName = findElement("LNErrMsg_XPATH").getText();
				Assert.assertEquals(errorLastName, "The former/alternate last name can only contain letters, spaces and hyphens (-).");
				System.out.println(Last_name+" "+errorLastName);

			}catch(Exception e)
			{
				if(Last_name.length()>30)
				{
					String errorLastName30 = findElement("errorLastName30_XPATH").getText();
					Assert.assertEquals(errorLastName30, "The last name should not be more than 30 characters.");
					System.out.println(Last_name+" "+errorLastName30);
				}
			}
		}
		else
			log.debug("lastName is not valid");
		System.out.println("LN is not valid");

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
		WebElement elementToScrollTo2 = driver.findElement(By.xpath("//th[.=' Former or Alternate Names ']"));
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
		findElement("FirstName_ID").clear();
		Thread.sleep(500);
		findElement("FirstName_ID").sendKeys("FN Edited");
		Thread.sleep(500);
		findElement("LastName_ID").clear();
		Thread.sleep(500);
		findElement("LastName_ID").sendKeys("LN Edited");
		Thread.sleep(1000);
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
		WebElement elementToScrollTo2 = driver.findElement(By.xpath("//th[.=' Former or Alternate Names ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		List<WebElement> editButtons = driver.findElements(By.xpath("//a[@class='text-decoration-none form-name-edit-button']"));
		// Generate a random index to choose a random Edit button
		Random random = new Random();
		int randomIndex = random.nextInt(editButtons.size());
		// Click on the random Edit button
		WebElement randomEditButton = editButtons.get(randomIndex);
		randomEditButton.click();
		log.debug("Editing the Former Names");
		findElement("FirstName_ID").clear();
		Thread.sleep(500);
		findElement("FirstName_ID").sendKeys("FN Edited");
		Thread.sleep(500);
		findElement("LastName_ID").clear();
		Thread.sleep(500);
		findElement("LastName_ID").sendKeys("LN Edited");
		Thread.sleep(500);
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
		}}


	public void DeleteAddedFormerNames() throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement elementToScrollTo2 = driver.findElement(By.xpath("//th[.=' Former or Alternate Names ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		Thread.sleep(1000);
		List<WebElement> deleteButtons = driver.findElements(By.xpath("//a[@class='text-dark-3 ml-space-xs']"));
		// Generate a random index to choose a random Delete button
		Random random = new Random();
		int randomIndex = random.nextInt(deleteButtons.size());
		Thread.sleep(1000);
		System.out.println("Delete Size:"+randomIndex);
		// Click on the random Edit button
		WebElement randomDeleteButton = deleteButtons.get(randomIndex);
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", randomDeleteButton);
		randomDeleteButton.click();
		log.debug("Deleting the Former Name");
		Thread.sleep(500);
		click("Cancel_XPATH");
		Thread.sleep(1000);
		scrollUp(driver, 1);
		List<WebElement> deleteButtons1 = driver.findElements(By.xpath("//a[@class='text-dark-3 ml-space-xs']"));
		int randomIndex1 = random.nextInt(deleteButtons1.size());
		// Click on the random Edit button
		WebElement randomDeleteButton1 = deleteButtons1.get(randomIndex1);
		randomDeleteButton1.click();
		log.debug("Deleting the Former Name");
		Thread.sleep(1000);
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


	public void chooseLegalSex() throws InterruptedException 
	{
		WebElement elementToScrollTo2 = driver.findElement(By.xpath("//span[.=' Legal sex']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		log.debug("Choose a Legal sex");
		// Choose random gender
		Thread.sleep(2000);
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='legal_sex_group']"));
		int Count = radioButtons.size();
		System.out.println(Count);
		// Generate a random index
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		// Get the text of the randomly selected radio button
		String selectedGender = radioButtons.get(randomIndex).getAttribute("value");
		// Click the randomly selected radio button
		radioButtons.get(randomIndex).click();
		if(selectedGender.contains("M"))
			log.debug("Selected Gender: " + "Male");
		else {
			log.debug("Selected Gender: " + "Female");
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

	public void ChoosePrimageLanguage() throws InterruptedException
	{
		WebElement elementToScrollTo2 = driver.findElement(By.xpath("//h3[.=' Primary language spoken at home ']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		log.debug("Choose the Primary language");
		Thread.sleep(2000);
		//Select a random lang
		System.out.println("Clickinhg on Primary DD");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='primary_language_select']")));
		click("SelectPrimaryLangDD_XPATH");
		System.out.println("Clicked on Primary DD");
		Thread.sleep(1000);
		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		System.out.println(Options + "Primary DD options");
		// Generate a random index to choose a random Edit button
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		// Click on the random Edit button
		WebElement randomOption = options.get(randomIndex);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		// Get the text of the chosen random option
		String 	selectedOptionText	=	driver.findElement(By.xpath("//div[@id='primary_language_select']")).getText();
		System.out.println("Selected Primary language option: " + selectedOptionText);
		log.debug("Selected Primary language option: " + selectedOptionText);
	}





	public void HomeAddAndPhone() throws InterruptedException
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
		System.out.println(Options);
		for(int ran:randomCountry)
		{
			driver.findElement(By.xpath("(//ul[@class='vs__dropdown-menu']/li)["+ran+"]")).click();
			Thread.sleep(1000);
		}
	}
	public void address(String AddressLine1 , String AddressLine2 ,String City , String Zip, String State,String Phone_Number, String Mobile_Number) throws InterruptedException
	{
		String 	selectedOptionText	=	driver.findElement(By.xpath("//div[@id='home-country-select']")).getText();
		System.out.println("Selected Home Country:" + selectedOptionText);
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
				System.out.println("State is a dropdown.");
				log.debug("State is a dropdown.");
				click("StateDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options = options.size();
				System.out.println(Options);
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
				System.out.println("Selected Home State: " + selectedStateText);
				log.debug("Selected Home State : " + selectedStateText);

			}

			else if (stateElement.getTagName().equals("input")) 
			{
				// It's a textfield
				System.out.println("State is a textfield.");
				log.debug("State is a textfield.");
				type("StateTextfield_ID",State);
			}
			else 
			{
				// It's neither a dropdown nor a textfield
				System.out.println("State is neither a dropdown nor a textfield.");
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
				System.out.println("State is a dropdown.");
				log.debug("State is a dropdown.");
				click("StateDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options = options.size();
				System.out.println(Options);
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
				System.out.println("Selected Home State : " + selectedStateText);
				log.debug("Selected Home State : " + selectedStateText);

			}

			else if (stateElement.getTagName().equals("input")) 
			{
				// It's a textfield
				System.out.println("State is a textfield.");
				log.debug("State is a textfield.");
				type("StateTextfield_ID",State);
			}
			else 
			{
				// It's neither a dropdown nor a textfield
				System.out.println("State is neither a dropdown nor a textfield.");
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
			type("USMobileNo2_XPATH","000-000");
		}
	}
	
	
	
	
	public void validateAddress(String AddressLine1 , String AddressLine2 ,String City , String Zip, String State, String Phone_Number,String Mobile_Number)
	{
		System.out.println("AddressLine1.length()"+AddressLine1.length());
		System.out.println("AddressLine2.length()"+AddressLine2.length());
		System.out.println("City.length()"+City.length());
		System.out.println("Zip.length()"+Zip.length());
		System.out.println("State.length()"+State.length());
		System.out.println("Phone.length()"+Phone_Number.length());
		System.out.println("Mobile.length()"+Mobile_Number.length());
		//error message validation for addressline 1
		try
		{
			if(AddressLine1.length() > 42)
			{
				String errorAddressLine1 = driver.findElement(By.xpath("//input[@id='address_line_1_input']/following-sibling::div[contains(text(),' Should not be more than 42 characters. ')]")).getText();
				System.out.println("The error message is displayed when the input for addressline1 is greater than 42 char!");
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
				System.out.println("The error message is displayed when the input for addressline2 is greater than 42 char!");
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
				System.out.println("The error message is displayed when the input for city is greater than 30 char!");
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
				System.out.println("The error message is displayed when the input for Zip is greater than 12 char!");
				Assert.assertEquals(errorZipCode12, "The zip/postal code should not be more than 12 characters.");
				findElement("ZIPcode_ID").clear();
			}

		}catch(Exception e) {}

		try
		{
			if(State.length()>30)
			{
				String errorState = driver.findElement(By.xpath("//input[@id='address_state']/following-sibling::div[contains(text(),' The state should not be more than 30 characters. ')]")).getText();
				System.out.println("The error message is displayed when the input for State is greater than 30 char!");
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
			System.out.println(Phone_Number+" "+errorPhoneNo);
		}
		catch(Exception e) {}

		//error message validation for Mobile Number
		try
		{
			String errorMobileNo = findElement("MobileNoErr_XPATH").getText();
			Assert.assertEquals(errorMobileNo, "Number can contain only numeric and plus (+) at the beginning.");
			System.out.println(Mobile_Number+" "+errorMobileNo);
			findElement("MobileNo_XPATH").clear();
		}
		catch(Exception e) {}


		/*	// Define XPaths for error messages
		String[] errorXPaths = {
				"//input[@id='address_line_1_input']/following-sibling::div[contains(text(),' Should not be more than 42 characters. ')]",
				"//input[@id='address_line_2_input']/following-sibling::div[contains(text(),' Should not be more than 42 characters. ')]",
				"//input[@id='city_input']/following-sibling::div[contains(text(),' The city should not be more than 30 characters. ')]",
				"//input[@id='address_state']/following-sibling::div[contains(text(),' The state should not be more than 30 characters. ')]",
				"//div[text()=' The zip/postal code should not be more than 12 characters. ']",
				"//div[text()= ' The zip/postal code can only contain letters, integers and one hyphen (-) in between the strings. ']",
				"//div[text()= ' Number can contain only numeric and plus (+) at the beginning. ']",
				"//div[text()= ' Number can contain only numeric and plus (+) at the beginning. ']",
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
			// No error messages found, move forward with the entered data
			System.out.println("No Error messages displayed");
		} else {
			// Error messages found, clear the entered data
			findElement("AddLine1_ID").clear();
			findElement("AddLine2_ID").clear();
//			findElement("StateTextfield_ID").clear();
			findElement("City_ID").clear();
			findElement("ZIPcode_ID").clear();
			findElement("PhoneNo_XPATH").clear();
			findElement("MobileNo_XPATH").clear();
		}*/
	}








	public void EthnicityBackground() throws InterruptedException
	{
		WebElement elementToScrollTo2 = driver.findElement(By.xpath("//span[.='Ethnic/racial background']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		Thread.sleep(2000);
		log.debug("Choose the Ethnicity");
		// Choose Ethnicity randomly -- YES or NO
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='hispanic_latino_radio']"));
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
			log.debug("Are you Hispanic/Latino?" + "Yes");
			WebElement elementToScrollTo = findElement("RacialDD_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			click("EthnicityDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
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
			String 	selectedEthnicityOptionText	=	driver.findElement(By.xpath("//div[@id='hispanic_latino_origin']")).getText();
			System.out.println("Selected Hispanic/Latino origin option: " + selectedEthnicityOptionText);
			log.debug("Selected Hispanic/Latino origin option: " + selectedEthnicityOptionText);
		}
		else {
			log.debug("Are you Hispanic/Latino?" +" " +"No");
		}

	}

	public void RacialBackground() throws InterruptedException
	{
		WebElement elementToScrollTo2 = findElement("RacialDD_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		log.debug("Choose the Race");
		click("RacialDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		System.out.println(Options);
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
		String 	selectedOptionText	=	driver.findElement(By.xpath("//div[@id='applicants_race']")).getText();
		System.out.println("Selected option: " + selectedOptionText);
		log.debug("Selected option: " + selectedOptionText);
		if(selectedOptionText.contains("White"))
		{
			log.debug("Applicant race :"+" "+selectedOptionText);
		}
		if(selectedOptionText.contains("Black or African American"))
		{
			log.debug("Applicant race :"+" "+selectedOptionText);
		}
		if(selectedOptionText.contains("Asian"))
		{
			// Select random Asian race
			WebElement elementToScrollTo21 = findElement("AsianDD_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
			click("AsianDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> Asianoptions  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Asianoptionslist = Asianoptions.size();
			System.out.println(Asianoptionslist);
			Random randomlist1 = new Random();
			int randomIndex1 = randomlist1.nextInt(Asianoptions.size());
			WebElement randomOption1 = Asianoptions.get(randomIndex1);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			// Get the text of the chosen random option
			String 	selectedOptionText1	=	driver.findElement(By.xpath("//div[@id='Asian_origin']")).getText();
			System.out.println("Selected Asian option: " + selectedOptionText1);
			log.debug("Selected Asian option: " + selectedOptionText1);
		}
		if(selectedOptionText.contains("American Indian/Alaska Native"))
		{
			// Select random American Indian/Alaska Native race
			WebElement elementToScrollTo21 = findElement("AmericanAlaskaDD_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
			click("AmericanAlaskaDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> AmericanAlaskaOptions  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int AmericanAlaskaOptionslist = AmericanAlaskaOptions.size();
			System.out.println(AmericanAlaskaOptionslist);
			Random randomlist1 = new Random();
			int randomIndex1 = randomlist1.nextInt(AmericanAlaskaOptions.size());
			WebElement randomOption1 = AmericanAlaskaOptions.get(randomIndex1);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			// Get the text of the chosen random option
			String 	selectedOptionText1	=	driver.findElement(By.xpath("//div[@id='American Indian/Alaska Native_origin']")).getText();
			System.out.println("Selected American Indian/Alaska Native option: " + selectedOptionText1);
			log.debug("Selected American Indian/Alaska Native option: " + selectedOptionText1);
		}
		if(selectedOptionText.contains("Native Hawaiian/Pac Islander"))
		{
			// Select random Native Hawaiian/Pace race
			WebElement elementToScrollTo21 = findElement("NativeHawaiianPacIslanderDD_XPATH");
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
			click("NativeHawaiianPacIslanderDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> NativeHawaiianPacIslanderOptions  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int NativeHawaiianPacIslanderOptionslist = NativeHawaiianPacIslanderOptions.size();
			System.out.println(NativeHawaiianPacIslanderOptionslist);
			Random randomlist1 = new Random();
			int randomIndex1 = randomlist1.nextInt(NativeHawaiianPacIslanderOptions.size());
			WebElement randomOption1 = NativeHawaiianPacIslanderOptions.get(randomIndex1);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			// Get the text of the chosen random option
			String 	selectedOptionText1	=	driver.findElement(By.xpath("//div[@id='Native Hawaiian/Pac Islander_origin']")).getText();
			System.out.println("Selected Native Hawaiian/Pac Islander option: " + selectedOptionText1);
			log.debug("Selected Native Hawaiian/Pac Islander option: " + selectedOptionText1);
		}
		if (isElementPresent("PrimaryRaceHeader_XPATH")) {
			// Element is present, perform your actions here
			WebElement element1 = findElement("PrimaryRaceHeader_XPATH");
			if(element1.isDisplayed())
			{
				log.debug("Choose the Primary Race")	;		
				click("PrimaryRaceDD_XPATH");
				Thread.sleep(2000);
				List<WebElement> PrimaryRaceOptions  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int PrimaryRaceOptionslist = PrimaryRaceOptions.size();
				System.out.println(PrimaryRaceOptionslist);
				Random randomRacelist = new Random();
				int randomIndex3 = randomRacelist.nextInt(PrimaryRaceOptions.size());
				WebElement randomOption3 = PrimaryRaceOptions.get(randomIndex3);
				randomOption3.click();
				// Get the text of the chosen random option
				String 	selectedRaceOptionText	=	driver.findElement(By.xpath("//div[@id='primary_race_select']")).getText();
				System.out.println("Selected Primary Race option: " + selectedRaceOptionText);
				log.debug("Selected Primary Race option: " + selectedRaceOptionText);

			}
		} else {
			// Element is not present, handle the situation accordingly
			log.debug("Primary Race header element is not available");
		}
	}


	public void US_Citizenship() throws InterruptedException
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
		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
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
		String 	selectedCountryOfBirthOptionText	=	driver.findElement(By.xpath("//div[@id='country_of_birth']")).getText();
		System.out.println("Selected option: " + selectedCountryOfBirthOptionText);
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
		System.out.println(randomNumberString);
		// Send the random SSN number to the text field
		WebElement elementToScrollTo4 = findElement("SSN_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo4);
		type("SSN_XPATH",randomNumberString);
		System.out.println("Entered SSN");
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
				click("AdditionalParentBtn_XPATH");
			}
		}	
		//Add Parent First and Last names
		type("GuardianFN_ID", First_name);
		type("GuardianLN_ID", Last_name);
	}

	public void ValidateParentName(String First_name, String Last_name) throws InterruptedException
	{
		// Validate the Parent First name and Last name
		//regex that checks numbers , special char 
		String regex = "^(?!.*\\\\s$)(?!^\\\\s)(?!.*-$)[0-9A-Za-z!@#$%^&*()_+=`~{}\\\\[\\\\]:;\\\"'<>,.?\\\\\\\\/| ]+$";

		//First_name validation
		boolean isFirstNameValid = First_name.matches(regex);
		log.debug("isFirstNameValid :"+isFirstNameValid);
		System.out.println("isFirstNameValid :"+isFirstNameValid);
		if(isFirstNameValid)
		{
			try {
				String errorFirstName = findElement("ParentFNErrMsg_XPATH").getText();
				Assert.assertEquals(errorFirstName, "The first name can only contain letters and hyphens (-).");
				System.out.println(First_name+" "+errorFirstName);
			}catch(Exception e) {
				if(First_name.length()>50)
				{
					String errorFirstName50 = findElement("errorFirstName50_XPATH").getText();
					Assert.assertEquals(errorFirstName50, "The first name should not be more than 50 characters.");
					System.out.println(First_name+errorFirstName50);
				}

			}
		}
		else
			log.debug("Parent Firstname is not valid");
		System.out.println(" ParentFN is not valid");


		//Last_name validation
		boolean isLastNameValid = Last_name.matches(regex);
		log.debug("isLastNameValid :"+isLastNameValid);
		System.out.println("isLastNameValid :"+isLastNameValid);
		if(isLastNameValid)
		{
			try
			{
				String errorLastName = findElement("ParentLNErrMsg_XPATH").getText();
				Assert.assertEquals(errorLastName, "The last name can only contain letters and hyphens (-).");
				System.out.println(Last_name+" "+errorLastName);

			}catch(Exception e)
			{
				if(Last_name.length()>50)
				{
					String errorLastName50 = findElement("errorLastName50_XPATH").getText();
					Assert.assertEquals(errorLastName50, "The last name should not be more than 50 characters.");
					System.out.println(Last_name+" "+errorLastName50);
				}
			}
		}
		else
			log.debug("Parent lastName is not valid");
		System.out.println("LN is not valid");

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
			System.out.println(Count + "Yes or NO");
			// Generate a random index
			Random random = new Random();
			int randomIndex = random.nextInt(radioButtons.size());
			// Get the text of the randomly selected radio button
			String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
			System.out.println(selectedOption);
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
				System.out.println("Random Phone Number: " + phoneNumberString);
				WebElement elementToScrollTo6 = findElement("GuradianPhoneNo_ID");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo6);
				type("GuradianPhoneNo_ID",phoneNumberString);

				// Randomly choose Relation
				WebElement elementToScrollTo = findElement("RelationDD_XPATH");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				click("RelationDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
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
				System.out.println("Selected Relation: " + selectedOptionText);
				log.debug("Selected Relation: " + selectedOptionText);


				//Randomly choose the Highest level of schooling 
				WebElement elementToScrollTo1 = findElement("HighestLevelOfSchooling_XPATH");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				click("HighestLevelOfSchooling_XPATH");
				Thread.sleep(1000);
				List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random2 = new Random();
				int randomIndex2 = random2.nextInt(options1.size());
				// Click on the random Option
				WebElement randomOption1= options1.get(randomIndex2);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				// Get the text of the chosen random option
				String 	selectedOptionText1	=	driver.findElement(By.xpath("//div[@id='guardian_highestSchoolingLevel_select']")).getText();
				System.out.println("Selected Highest level of schooling: " + selectedOptionText1);
				log.debug("Selected Highest level of schooling: " + selectedOptionText1);

				//Randomly choose Did this guardian attend ASU?
				WebElement elementToScrollTo2 = driver.findElement(By.xpath("//h3[.=' Did this guardian attend ASU? ']"));
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
				List<WebElement> radioButtons1 = driver.findElements(By.xpath("//input[@name='guardian_attended_asu_radio']"));
				int Count1 = radioButtons1.size();
				System.out.println(Count1);
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
				}
				else 
				{
					log.debug("Did this guardian attend ASU? : " + "No");
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
				List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
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
				System.out.println("Selected Relation: " + selectedOptionText);
				log.debug("Selected Relation: " + selectedOptionText);


				//Randomly choose the Highest level of schooling 
				click("HighestLevelOfSchooling_XPATH");
				Thread.sleep(1000);
				List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random2 = new Random();
				int randomIndex2 = random2.nextInt(options1.size());
				// Click on the random Option
				WebElement randomOption1= options1.get(randomIndex2);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				// Get the text of the chosen random option
				String 	selectedOptionText1	=	driver.findElement(By.xpath("//div[@id='guardian_highestSchoolingLevel_select']")).getText();
				System.out.println("Selected Highest level of schooling: " + selectedOptionText1);
				log.debug("Selected Highest level of schooling: " + selectedOptionText1);

				//Randomly choose Did this guardian attend ASU?
				WebElement elementToScrollTo2 = driver.findElement(By.xpath("//h3[.=' Did this guardian attend ASU? ']"));
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
				List<WebElement> radioButtons1 = driver.findElements(By.xpath("//input[@name='guardian_attended_asu_radio']"));
				int Count1 = radioButtons1.size();
				System.out.println(Count1);
				// Generate a random index
				Random random3 = new Random();
				int randomIndex3= random3.nextInt(radioButtons1.size());
				// Get the text of the randomly selected radio button
				String selectedOption1 = radioButtons1.get(randomIndex3).getAttribute("value");
				// Click the randomly selected radio button
				radioButtons1.get(randomIndex3).click();
				if(selectedOption1.contains("true"))
					log.debug("Did this guardian attend ASU? : " + "Yes");
				else {
					log.debug("Did this guardian attend ASU? : " + "No");
				}

				WebElement elementToScrollTo1 = findElement("SaveParentInfo_XPATH");
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				click("SaveParentInfo_XPATH");
			}
		} 
		else 
		{
			// Error messages found, click on Clear fields button
			click("ClearFields_XPATH");
		}
	}

	public void ValidateAddedParentNames()
	{
		// Validate add max of  2 parent info
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



	public void Previous_ASU_affiliation() throws InterruptedException 
	{
		Thread.sleep(2000);
		WebElement elementToScrollTo1 = driver.findElement(By.xpath("//div[@id='asu_affiliation_checkbox_group']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		log.debug("Choose Previous ASU affiliation");

		// Choose random Option
		Thread.sleep(1000);
		List<WebElement> Checkboxes = driver.findElements(By.xpath("//input[@name='asu_affiliation_checkbox']"));
		int Count = Checkboxes.size();
		System.out.println(Count);

		// Generate a random index
		Random random = new Random();
		int randomIndex = random.nextInt(Checkboxes.size());
		WebElement element = Checkboxes.get(randomIndex);
		Thread.sleep(1000);
		// Get the text of the randomly selected Checkbox
		String selectedOption = element.getText();
		System.out.println(selectedOption);

		// Click the randomly selected checkbox
		System.out.println("Clicking.....");
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		Thread.sleep(500);
		System.out.println("Clicked");

		log.debug("Selected Previous ASU affiliation: " + selectedOption);
	}




	public void ASU_affiliate_ID()
	{
		WebElement elementToScrollTo1 = driver.findElement(By.xpath("//span[.=' What is your ASU Affiliate ID?']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		// Create a Random 10 digit ASU affiliate ID
		Random random = new Random();
		// Generate a random 10-digit number
		long randomASUaffiliateID = (long) (random.nextDouble() * 9000000000L) + 1000000000L;
		// Convert the random number to a string
		String randomASU_affiliateID = Long.toString(randomASUaffiliateID);
		System.out.println("Random 10-digit number as string: " + randomASU_affiliateID);
		type("ASUaffiliationID_ID",randomASU_affiliateID);

	}


	public void US_Uniformed_Services_Military()
	{
		WebElement elementToScrollTo1 = driver.findElement(By.xpath("//span[.=' Affiliation to U.S. Uniformed Services']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		// Validate for None of these apply to me
		click("USuniformedDD_XPATH");
		// Get the text of the selected option before clicking on it
		String MilitaryStatusOption = findElement("NoneOftheseApplytoMe_XPATH").getText();
		System.out.println("Text of the option before clicking: " + MilitaryStatusOption);
		System.out.println("Selected Military status : " + MilitaryStatusOption);
		click("NoneOftheseApplytoMe_XPATH");

	}


	public void Partner_benefits() throws InterruptedException
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
			click("CurrentEmployerDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
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
			String 	selectedEthnicityOptionText	=	driver.findElement(By.xpath("//div[@id='current_employer_select']")).getText();
			System.out.println("Selected option: " + selectedEthnicityOptionText);
			log.debug("Selected option: " + selectedEthnicityOptionText);
		}
		else {
			log.debug("Selected Option: " + "No");
		}
	}
public void SaveThePage()
{
	// Clicks on Continue button
	driver.findElement(By.xpath("(//footer//button)[1]")).click();
}
	
}
