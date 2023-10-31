package com.ugapp.pages;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Debug;


import com.ugapp.base.Page;


public class AZResidencyPage  extends Page
{
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	String A_SpouseEnrolledAZcoll ="";
	String A_SpouseDependentOnOtherString ="";
	String A_EnrolledAZcoll ="";
	String A_ParentHaveDLString = "";
	String A_AmericanIndianAlaskaNativeString = "";
	String A_ParentEmloyedInAZString = "";
	String A_EligibleForChapter30 ="";




	static final Map<String, String> monthMap = new HashMap<>();
	static {
		monthMap.put("January", "01");
		monthMap.put("February", "02");
		monthMap.put("March", "03");
		monthMap.put("April", "04");
		monthMap.put("May", "05");
		monthMap.put("June", "06");
		monthMap.put("July", "07");
		monthMap.put("August", "08");
		monthMap.put("September", "09");
		monthMap.put("October", "10");
		monthMap.put("November", "11");
		monthMap.put("December", "12");
	}




	public  void validateAZresidencyPage() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(3000);
		WebElement elementToScrollTo1 = findElement("ResidencyTitle_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		String PageTitle	= findElement("ResidencyTitle_XPATH").getText();
		log.debug("Page title :"+" "+PageTitle);
	}
	public void  PermanentHome() throws Throwable
	{
		WebElement elementToScrollTo1 = findElement("PermanentHome_ID");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		log.debug("Choose the Permanent Home Country");
		click("PermanentHome_ID");
		click("OOSdd_XPATH");
		String 	selectedPermanentHome	= findElement("PermanentHome_ID").getText();
		String 	Q_PermanentHome	= findElement("PermanentHomeQuestion_XPATH").getText();
		log.debug(Q_PermanentHome+" " + selectedPermanentHome);
	}
	public void EnrolledAnotherCollOrUniversity() throws InterruptedException
	{
		// Select YES to Are you currently enrolled at another college or university?
		WebElement elementToScrollTo1 = findElement("EnrolledAtOtherCollYesRadioBtn_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("EnrolledAtOtherCollYesRadioBtn_XPATH");
		String selectedOption =	findElement("EnrolledAtOtherCollYesRadioBtn_XPATH").getAttribute("value");
		String Q_EnrolledAtOtherColl =	findElement("EnrolledAtOtherQuestion_XPATH").getText();
		if(selectedOption.contains("Y"))
		{
			log.debug(Q_EnrolledAtOtherColl+" "+"Yes");
		}
		// Enter a Enrolled college or University name
		String A_CurrentlyEnrolled = "Test College";
		WebElement elementToScrollTo = findElement("EnrolledCollTxtfield_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		type("EnrolledCollTxtfield_XPATH",A_CurrentlyEnrolled);
		Thread.sleep(1000);
		String Q_EnrolledCollOrUniversity = findElement("EnrolledCollQuestion_XPATH").getText();
		log.debug( Q_EnrolledCollOrUniversity+" "+ A_CurrentlyEnrolled);
		//  Select a State of Enrolled college or University
		click("EnrolledStateDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		System.out.println(Options);
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		// Get the text of the chosen random option
		String 	A_EnrolledState	=	findElement("EnrolledStateDD_XPATH").getText();
		String 	Q_EnrolledState	=	findElement("EnrolledStateQuestion_XPATH").getText();
		log.debug(Q_EnrolledState+" " + A_EnrolledState);


	}


	public void EnrolledAtASU() throws InterruptedException 
	{
		WebElement elementToScrollTo2 = findElement("Enrolled@ASUQuestion_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		Thread.sleep(2000);
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='radio_DOM_AZ']"));
		int Count = radioButtons.size();
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		// Get the text of the randomly selected radio button
		String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
		// Click the randomly selected radio button
		Thread.sleep(1000);
		radioButtons.get(randomIndex).click();
		Thread.sleep(1000);
		String 	Q_EnrolledASU	=	findElement("Enrolled@ASUQuestion_XPATH").getText();
		if(selectedOption.contains("Y"))
		{
			log.debug(Q_EnrolledASU +" " + "Yes");
			A_EnrolledAZcoll = "Yes";
		}
		else
			log.debug(Q_EnrolledASU+"  " + "No" );
		A_EnrolledAZcoll = "No";


	}
	public void DriverLicense() throws InterruptedException
	{
		// Select YES to Do you have a current driver’s license or state issued ID?
		WebElement elementToScrollTo1 = findElement("HavingLicenceYesRadioBtn_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("HavingLicenceYesRadioBtn_XPATH");
		String selectedOption =	findElement("HavingLicenceYesRadioBtn_XPATH").getAttribute("value");
		String 	Q_EnrolledASU	=	findElement("HavingLicenceQuestion_XPATH").getText();
		if(selectedOption.contains("Y"))
		{
			log.debug(Q_EnrolledASU+" "+"Yes");
		}


		// Select In which state was your license issued?
		WebElement elementToScrollToLS = findElement("LicenseIssuedStateDD_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToLS);
		click("LicenseIssuedStateDD_XPATH");


		//choose AZ 
		WebElement elementToScrollToLSAZ = findElement("AZstateForLicence_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToLSAZ);
		click("AZstateForLicence_XPATH");
		String 	A_LicenseIssuedState	= findElement("LicenseIssuedStateDD_XPATH").getText();
		if(A_LicenseIssuedState.contains("Arizona"))
		{
			log.debug("Is this vehicle registered in the state of Arizona?"+" " + "Yes");	
		}
		else
		{
			log.debug("Is this vehicle registered in the state of Arizona?"+" " + "No");	
		}
		// Select When was your license issued?
		WebElement elementToScrollToDL1 = findElement("SelectDLmonth_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDL1);
		click("SelectDLmonth_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		WebElement elementToScrollToDL2 = findElement("SelectDLyear_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDL2);
		click("SelectDLyear_XPATH");
		Thread.sleep(1000);
		List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex1);
		Thread.sleep(1000);
		randomOption1.click();
		Thread.sleep(1000);
		String year = findElement("SelectDLyear_XPATH").getText();
		String monthInWords = findElement("SelectDLmonth_XPATH").getText(); 
		String Q_LicenseIssuedDate = findElement("LicenseIssuedDateQuestion_XPATH").getText(); 
		// Convert month in words to numeric representation using the monthMap
		String month = monthMap.get(monthInWords);


		// Format the selected year and month as 'YYYY-MM'
		String LicenseIssuedDate = year + "-" + month;
		log.debug(Q_LicenseIssuedDate+" "+LicenseIssuedDate);
	}
	public void VehicleDetails() throws InterruptedException
	{
		WebElement elementToScrollTo = findElement("OwnvehicleYesRadioBtn_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		click("OwnvehicleYesRadioBtn_XPATH");
		String Q_OwnVehicle	=findElement("OwnVehicleQuestion_XPATH").getText();
		log.debug(Q_OwnVehicle+" "+ "Yes");
		Thread.sleep(1000);
		WebElement elementToScrollTo1 = findElement("VehicleRegisteredYesRadioBtn_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("VehicleRegisteredYesRadioBtn_XPATH");
		String Q_VehicleRegistered	=findElement("VehicleRegisteredQuestion_XPATH").getText();
		log.debug(Q_VehicleRegistered+" "+ "Yes");
		WebElement elementToScrollTo11 = findElement("RegistrationMonthDD_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		click("RegistrationMonthDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		WebElement elementToScrollTo2 = findElement("RegistrationYearDD_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		click("RegistrationYearDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex1);
		Thread.sleep(1000);
		randomOption1.click();
		Thread.sleep(1000);
		String year = findElement("RegistrationMonthDD_XPATH").getText();
		String monthInWords = findElement("RegistrationYearDD_XPATH").getText(); 
		String Q_VehicleRegisteredDate = findElement("VehicleRegisteredQuestion_XPATH").getText(); 
		// Convert month in words to numeric representation using the monthMap
		String month = monthMap.get(monthInWords);
		// Format the selected year and month as 'YYYY-MM'
		String VehicleRegisteredDate = year + "-" + month;
		log.debug(Q_VehicleRegisteredDate+" "+VehicleRegisteredDate);


	}
	public void StateTaxes() throws InterruptedException
	{
		WebElement elementToScrollTo = findElement("DidFileStateTaxYesRadioBtn_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		click("DidFileStateTaxYesRadioBtn_XPATH");
		WebElement elementToScrollTo1 = findElement("DidFileStateTaxYesRadioBtn_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("StateTaxLocDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex1);
		Thread.sleep(1000);
		randomOption1.click();
		Thread.sleep(1000);
		String A_LocStateTax = findElement("StateTaxLocDD_XPATH").getText();
		String Q_LocStateTax = findElement("StateTaxQuestion_XPATH").getText();
		log.debug(Q_LocStateTax+" "+A_LocStateTax);


	}
	public void FinancialSupport() throws InterruptedException
	{
		WebElement elementToScrollTo = driver.findElement(By.xpath("//div[@data-cy='arizona-residency-financial-table']"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		Random random = new Random();
		int[] percentages = new int[5]; // Assuming 5 rows


		int remainingPercentage = 100;
		for (int i = 0; i < percentages.length - 1; i++) {
			percentages[i] = random.nextInt(remainingPercentage + 1); // Generate random percentage between 0 and remainingPercentage
			remainingPercentage -= percentages[i];
		}


		percentages[percentages.length - 1] = remainingPercentage; // Assign the remaining percentage to the last row


		List<WebElement> rows = driver.findElements(By.xpath("//div[@data-cy='arizona-residency-financial-table']//td[2]//input"));
		int Size = rows.size();
		System.out.println(Size);  




		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);
			row.sendKeys(String.valueOf(percentages[i]));
		}


		int totalSum = 0;
		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);
			totalSum += Integer.parseInt(row.getAttribute("value"));
		}


		if (totalSum == 100) {
			System.out.println("Total sum is 100.");
			log.debug("Total sum is 100.");
		} else {
			System.out.println("Total sum is not 100.");
			log.debug("Total sum is not 100.");
		}


	}
	public void OtherFinancialSupport() throws InterruptedException 
	{
		try
		{
			if(driver.findElement(By.xpath("//fieldset[@data-cy='arizona-residency-other-options']")).isDisplayed())
			{
				Thread.sleep(2000);
				WebElement elementToScrollTo1 = driver.findElement(By.xpath("//fieldset[@data-cy='arizona-residency-other-options']"));
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				log.debug("Choose Other Financial Support Options");


				// Choose random Option
				Thread.sleep(1000);
				List<WebElement> Checkboxes = driver.findElements(By.xpath("//fieldset[@data-cy='arizona-residency-other-options']//input"));
				int Count = Checkboxes.size();
				System.out.println(Count);
				Random random = new Random();
				int randomIndex = random.nextInt(Checkboxes.size());
				WebElement element = Checkboxes.get(randomIndex);
				Thread.sleep(1000);
				String selectedOption = element.getText();
				Thread.sleep(500);
				log.debug("Selected Other Financial Support : "+selectedOption);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				if(findElement("DescribeSourceOfSupport_ID").isDisplayed())
				{
					Thread.sleep(500);
					type("DescribeSourceOfSupport_ID","Test Source of Support");
				}
			}
		}
		catch(Exception e) {}
	}






	public void EmploymentDetails() throws InterruptedException
	{
		WebElement elementToScrollTo = findElement("CurrentlyEmployedQuestion_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		click("EmployedYesRdBtn_XPATH");
		WebElement elementToScrollTo1 = findElement("CurrentlyEmployedQuestion_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("PrimaryWorkLocDD_XPATH");
		Thread.sleep(1000);
		click("PrimaryWorkAZloc_XPATH");
		WebElement elementToScrollTo2= findElement("EmplyomentLocDateQuestion_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);


		click("EmploymentLocMonthDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		WebElement elementToScroll = findElement("EmploymentLocYearDD_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		click("EmploymentLocYearDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex1);
		Thread.sleep(1000);
		randomOption1.click();
		Thread.sleep(1000);
		String year = findElement("EmploymentLocMonthDD_XPATH").getText();
		String monthInWords = findElement("EmploymentLocYearDD_XPATH").getText(); 
		String Q_VehicleRegisteredDate = findElement("EmplyomentLocDateQuestion_XPATH").getText(); 
		// Convert month in words to numeric representation using the monthMap
		String month = monthMap.get(monthInWords);
		// Format the selected year and month as 'YYYY-MM'
		String EmlyomentLocationDate = year + "-" + month;
		log.debug(Q_VehicleRegisteredDate+" "+EmlyomentLocationDate);
	}
	public void SpouseOrDependentflow() throws InterruptedException
	{
		WebElement elementToScroll = findElement("SpouseDependentDD_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		click("SpouseDependentDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex1);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		String 	selectedSpouseOrDependentText	= findElement("SpouseDependentDD_XPATH").getText();
		if(selectedSpouseOrDependentText.contains("Veteran"))
		{
			log.debug("Selected Service member or veteran: "+" "+selectedSpouseOrDependentText);
			WebElement elementToScroll1 = findElement("RegisteredToVoteQuestion_XPATH");
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
			click("RegisteredToVoteYesRdBtn_XPATH");
			WebElement elementToScroll11 = findElement("RegisteredToVoteStateDD_ID");
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll11);
			click("RegisteredToVoteStateDD_ID");
			Thread.sleep(1000);
			List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex11);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			String Q_RegisteredToVoteStateQuestion = findElement("RegisteredToVoteStateQuestion_XPATH").getText();
			String 	selectedRegisteredToVoteStateText	= findElement("RegisteredToVoteStateDD_ID").getText();
			log.debug(Q_RegisteredToVoteStateQuestion+" "+selectedRegisteredToVoteStateText);


			WebElement elementToScrollTo2= findElement("PGSactiveDutyQuestion_XPATH");
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			click("PGSactiveDutymm_ID");
			Thread.sleep(1000);
			List<WebElement> options11  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			Random random = new Random();
			int randomIndex = random.nextInt(options11.size());
			WebElement randomOption11 = options11.get(randomIndex);
			Thread.sleep(1000);
			randomOption11.click();
			Thread.sleep(1000);
			click("PGSactiveDutyyy_ID");
			Thread.sleep(1000);
			List<WebElement> options111  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			Random random111 = new Random();
			int randomIndex111 = random111.nextInt(options111.size());
			WebElement randomOption111 = options111.get(randomIndex111);
			Thread.sleep(1000);
			randomOption111.click();
			Thread.sleep(1000);
			String year = findElement("PGSactiveDutymm_ID").getText();
			String monthInWords = findElement("PGSactiveDutyyy_ID").getText(); 
			String PGSactiveDutyQuestion = findElement("PGSactiveDutyQuestion_XPATH").getText(); 
			String month = monthMap.get(monthInWords);
			String PGSLocationDate = year + "-" + month;
			log.debug(PGSactiveDutyQuestion+" "+PGSLocationDate);


			// Are you eligible for Chapter 30 or Chapter 33 benefits?
			WebElement elementToScrollTo = findElement("EligibileChapter30BenefitsQuestion_XPATH");
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			Thread.sleep(500);
			List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='employment_radio_isEligibleFor30or33ChapterBenefits']"));
			int Count = radioButtons.size();
			Random random1111 = new Random();
			int randomIndex2 = random1111.nextInt(radioButtons.size());
			String selectedOption = radioButtons.get(randomIndex2).getAttribute("value");
			Thread.sleep(1000);
			radioButtons.get(randomIndex2).click();
			Thread.sleep(1000);
			if(selectedOption.contains("Y"))
			{
				log.debug( "Selected Option: " + "Yes");
				A_EligibleForChapter30 = "Yes";
			}
			else
			{
				log.debug("Selected Option: " + "No" );
				A_EligibleForChapter30 = "No";
			}








		}
		if(selectedSpouseOrDependentText.contains("Not Applicable"))
		{
			log.debug("Selected Service member or veteran: "+" "+selectedSpouseOrDependentText);
		}
		if(selectedSpouseOrDependentText.contains("Active Duty")|| selectedSpouseOrDependentText.contains("Armed Forces Reserve")|| selectedSpouseOrDependentText.contains("National Guard"))
		{
			// Spouse/Parent/Guardian Stationed
			log.debug("Selected Service member or veteran: "+" "+selectedSpouseOrDependentText);
			WebElement elementToScroll1 = findElement("SpouseParentGuardianDD_XPATH");
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
			click("SpouseParentGuardianDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options1 = options1.size();
			Random random11 = new Random();
			int randomIndex11 = random11.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex11);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			String 	selectedLocText	= findElement("SpouseParentGuardianDD_XPATH").getText();
			log.debug("Selected option: " + selectedLocText);
			if(!selectedSpouseOrDependentText.contains("Arizona"))
			{
				Thread.sleep(1000);
				WebElement elementTo = findElement("SpouseParentGuardianLegalResid_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementTo);
				click("SpouseParentGuardianLegalResid_XPATH");
				Thread.sleep(1000);
				List<WebElement> options11  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options11 = options11.size();
				Random random111 = new Random();
				int randomIndex111 = random111.nextInt(options11.size());
				WebElement randomOption11 = options11.get(randomIndex111);
				Thread.sleep(1000);
				randomOption11.click();
				Thread.sleep(1000);
				String 	selectedText	= findElement("SpouseParentGuardianDD_XPATH").getText();
				log.debug("Selected option: " + selectedText);
			}
		}
		// Check for  Veteran flow
		//		if(selectedSpouseOrDependentText.contains("Veteran"))
		//		{
		//			log.debug("Selected Service member or veteran: "+" "+selectedSpouseOrDependentText);
		//			WebElement elementToScroll1 = findElement("RegisteredToVoteQuestion_XPATH");
		//			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
		//			String RegisteredToVoteQuestion = findElement("RegisteredToVoteQuestion_XPATH").getText();
		//			// Click to Registered to Vote
		//			click("RegisteredToVoteYesRdBtn_XPATH");
		//			log.debug(RegisteredToVoteQuestion+" "+"Yes");
		//			Thread.sleep(1000);
		//			// Select in which state are you registered to Vote
		//			click("RegisteredToVoteStateDD_ID");
		//			Thread.sleep(1000);
		//			List<WebElement> options11  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		//			int Options11 = options11.size();
		//			Random random111 = new Random();
		//			int randomIndex111 = random111.nextInt(options11.size());
		//			WebElement randomOption11 = options11.get(randomIndex111);
		//			Thread.sleep(1000);
		//			randomOption11.click();
		//			Thread.sleep(1000);
		//			String 	selectedText	= findElement("RegisteredToVoteStateDD_ID").getText();
		//			log.debug("Selected option: " + selectedText);
		//
		//
		//		}


	}


	public  void AmericanIndianOrAlaskaNAtive()
	{
		try
		{
			if(findElement("AmericanIndianAlaskaNativeQuestion_XPATH").isDisplayed())
			{
				// Randomly Click on Yes OR No
				WebElement elementToScrollTo2 = findElement("AmericanIndianAlaskaNativeQuestion_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
				Thread.sleep(2000);
				List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='employment_radio_isNativeAmerican']"));
				int Count = radioButtons.size();
				Random random = new Random();
				int randomIndex = random.nextInt(radioButtons.size());
				String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
				Thread.sleep(1000);
				radioButtons.get(randomIndex).click();
				Thread.sleep(1000);
				if(selectedOption.contains("Y"))
				{
					log.debug( "Selected Option: " + "Yes");
					A_AmericanIndianAlaskaNativeString = "Yes";
				}
				else
				{
					log.debug("Selected Option: " + "No" );
					A_AmericanIndianAlaskaNativeString = "No";
				}
			}}
		catch(Exception e) {}
	}


	public void ParentLegalGuardianDetails() throws InterruptedException
	{
		WebElement elementToScrollTo = findElement("ParentCurrentLocDD_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		click("ParentCurrentLocDD_XPATH");
		Thread.sleep(1000);
		click("ParentCurrentLocAZDD_XPATH");
		WebElement elementToScrollTo1 = findElement("WhichParent_CSS");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("WhichParent_CSS");
		Thread.sleep(1000);
		List<WebElement> options11  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options11 = options11.size();
		Random random111 = new Random();
		int randomIndex111 = random111.nextInt(options11.size());
		WebElement randomOption11 = options11.get(randomIndex111);
		Thread.sleep(1000);
		randomOption11.click();
		Thread.sleep(1000);
		String 	selectedText	= findElement("WhichParent_CSS").getText();
		log.debug("Selected option: " + selectedText);


		// When did your parent(s) or legal guardian(s) begin living in Arizona continuously?
		WebElement elementToScrollTo1111 = findElement("ParentLiveInAZquestion_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
		click("ParentLivesAZmm_CSS");
		Thread.sleep(1000);
		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());
		WebElement randomOption = options.get(randomIndex);
		Thread.sleep(1000);
		randomOption.click();
		Thread.sleep(1000);
		WebElement elementToScrollTo2 = findElement("ParentLivesAZyy_CSS");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		click("ParentLivesAZyy_CSS");
		Thread.sleep(1000);
		List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		Random random1 = new Random();
		int randomIndex1 = random1.nextInt(options1.size());
		WebElement randomOption1 = options1.get(randomIndex1);
		Thread.sleep(1000);
		randomOption1.click();
		Thread.sleep(1000);
		String year = findElement("ParentLivesAZmm_CSS").getText();
		String monthInWords = findElement("ParentLivesAZyy_CSS").getText(); 
		String Q_ParentLivingInAZ = findElement("ParentLiveInAZquestion_XPATH").getText(); 
		// Convert month in words to numeric representation using the monthMap
		String month = monthMap.get(monthInWords);
		// Format the selected year and month as 'YYYY-MM'
		String A_ParentLivingInAZDate = year + "-" + month;
		log.debug(Q_ParentLivingInAZ+" "+A_ParentLivingInAZDate);


		// Parent State Income Tax Return


		WebElement elementToScroll = findElement("ParentStateTaxQuestion_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		click("ParentStateTaxYesRdBtn_XPATH");
		WebElement elementToScroll1 = findElement("ParentStateTaxLocQuestion_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
		click("ParentStateTaxLocDD_CSS");
		Thread.sleep(1000);
		List<WebElement> options111  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options111 = options111.size();
		Random random1111 = new Random();
		int randomIndex1111 = random1111.nextInt(options111.size());
		WebElement randomOption111 = options111.get(randomIndex1111);
		Thread.sleep(1000);
		randomOption111.click();
		Thread.sleep(1000);
		String 	selectedText1	= findElement("ParentStateTaxLocDD_CSS").getText();
		log.debug("Selected option: " + selectedText1);


		// Parent Driver license question
		WebElement elementToScrollToQ = findElement("ParentDLQuestion_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToQ);
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='employment_radio_isParentHavingLicenseInAz']"));
		int Count = radioButtons.size();
		Random random11 = new Random();
		int randomIndex11 = random11.nextInt(radioButtons.size());
		String selectedAnswer = radioButtons.get(randomIndex11).getAttribute("value");
		Thread.sleep(1000);
		radioButtons.get(randomIndex11).click();
		Thread.sleep(1000);
		if(selectedAnswer.contains("Y"))
		{
			log.debug( "Selected Option: " + "Yes");
			A_ParentHaveDLString = "Yes";
		}
		else
			log.debug("Selected Option: " + "No" );
		A_ParentHaveDLString = "No";




		// Parent Employment question
		WebElement elementTo = findElement("ParentEmployedQuestion_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementTo);
		List<WebElement> radioButtons1 = driver.findElements(By.xpath("//input[@name='employment_radio_isParentEmployedInAz']"));
		int Count1 = radioButtons1.size();
		Random random11111 = new Random();
		int randomIndex11111 = random11111.nextInt(radioButtons1.size());
		String selectedOpt = radioButtons1.get(randomIndex11111).getAttribute("value");
		Thread.sleep(1000);
		radioButtons1.get(randomIndex11111).click();
		Thread.sleep(1000);
		if(selectedOpt.contains("Y"))
		{
			log.debug( "Selected Option: " + "Yes");
			A_ParentEmloyedInAZString = "Yes";
		}
		else
			log.debug("Selected Option: " + "No" );
		A_ParentEmloyedInAZString = "No";
	}
	public void SpouseRelatedDetails() throws InterruptedException
	{
		try
		{
			if(findElement("SpouseCurrentLocDD_CSS").isDisplayed())
			{
				WebElement elementTo = findElement("SpouseCurrentLocDD_CSS");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementTo);
				click("SpouseCurrentLocDD_CSS");
				Thread.sleep(1000);
				click("SpouseCurrentLocAZDD_XPATH");
				WebElement elementToelement = findElement("SpouseLivesAZquestion_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToelement);
				click("SpouseLivesAZmm_CSS");
				Thread.sleep(1000);
				List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random = new Random();
				int randomIndex = random.nextInt(options.size());
				WebElement randomOption = options.get(randomIndex);
				Thread.sleep(1000);
				randomOption.click();
				Thread.sleep(1000);
				WebElement elementToScrollTo2 = findElement("SpouseLivesAZquestion_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
				click("SpouseLivesAZyy_CSS");
				Thread.sleep(1000);
				List<WebElement> options1  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random1 = new Random();
				int randomIndex1 = random1.nextInt(options1.size());
				WebElement randomOption1 = options1.get(randomIndex1);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				String year = findElement("SpouseLivesAZmm_CSS").getText();
				String monthInWords = findElement("SpouseLivesAZyy_CSS").getText(); 
				String Q_SpouseLivesAZquestion = findElement("SpouseLivesAZquestion_XPATH").getText(); 
				String month = monthMap.get(monthInWords);
				String A_SpouseLivesAZquestion = year + "-" + month;
				log.debug(Q_SpouseLivesAZquestion+" "+A_SpouseLivesAZquestion);
				WebElement elementToScrollTo = findElement("SpouseDLquestion_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				click("SpouseDLyesRdBtn_XPATH");
				click("SpouseDLlocDD_CSS");
				click("SpouseDLLocAZDD_XPATH");
				Thread.sleep(1000);
				WebElement elementToelement1 = findElement("SpouseDLDateQuestion_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToelement1);
				click("SpouseDLmm_CSS");
				Thread.sleep(1000);
				List<WebElement> options11  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random11 = new Random();
				int randomIndex11 = random11.nextInt(options11.size());
				WebElement randomOption11 = options11.get(randomIndex11);
				Thread.sleep(1000);
				randomOption11.click();
				Thread.sleep(1000);
				click("SpouseDLyy_CSS");
				Thread.sleep(1000);
				List<WebElement> options111  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random111 = new Random();
				int randomIndex111 = random111.nextInt(options111.size());
				WebElement randomOption111 = options111.get(randomIndex111);
				Thread.sleep(1000);
				randomOption111.click();
				Thread.sleep(1000);
				String year1 = findElement("SpouseDLmm_CSS").getText();
				String monthInWords1 = findElement("SpouseDLyy_CSS").getText(); 
				String Q_SpouseDLDateQuestion = findElement("SpouseDLDateQuestion_XPATH").getText(); 
				String month1 = monthMap.get(monthInWords1);
				String A_SpouseDLDateQuestion = year1 + "-" + month1;
				log.debug(Q_SpouseDLDateQuestion+" "+A_SpouseDLDateQuestion);
				WebElement elementToelementSpouseIncome = findElement("SpouseStateTaxQuestion_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToelementSpouseIncome);
				click("SpouseStateTaxYesRdBtn_XPATH");
				Thread.sleep(500);
				click("SpouseStateTaxLocDD_CSS");
				// Randomly choose the Spouse file State Income Tax
				Thread.sleep(500);
				List<WebElement> options1111  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random r = new Random();
				int randomIndex1111 = r.nextInt(options1111.size());
				WebElement randomOption1111 = options1111.get(randomIndex1111);
				Thread.sleep(1000);
				randomOption1111.click();
				Thread.sleep(1000);
				String Q_SpouseIncomeTaxState = findElement("SpouseStateTaxLocQuestion_XPATH").getText();
				String A_SpouseIncomeTaxState = findElement("SpouseStateTaxLocDD_CSS").getText();
				log.debug(Q_SpouseIncomeTaxState+" :"+A_SpouseIncomeTaxState);
				// Spouse Employment
				WebElement elementToSpouseEmplyoment = findElement("SpouseEmployedQuestion_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToSpouseEmplyoment);
				click("SpouseEmployedYesRdBtn_XPATH");
				Thread.sleep(500);
				WebElement elementToSpouseEmp = findElement("SpouseEmployedStateDD_CSS");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToSpouseEmp);
				click("SpouseEmployedStateDD_CSS");
				Thread.sleep(500);
				click("SpouseEmployedLocAZDD_XPATH");
				// When did your spouses employment at this location begin?	
				WebElement elementToScrollTo1111 = findElement("SpouseEmplyomentAtazQuestion_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
				click("SpouseEmplyomentMM_ID");
				Thread.sleep(1000);
				List<WebElement> optionsTo = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random2 = new Random();
				int randomIndex2 = random2.nextInt(optionsTo.size());
				WebElement randomOption2 = optionsTo.get(randomIndex2);
				Thread.sleep(1000);
				randomOption2.click();
				Thread.sleep(1000);
				WebElement elementToScrollTo21 = findElement("SpouseEmplyomentYY_ID");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
				click("SpouseEmplyomentYY_ID");
				Thread.sleep(1000);
				List<WebElement> options3  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random3 = new Random();
				int randomIndex3 = random3.nextInt(options3.size());
				WebElement randomOption3 = options3.get(randomIndex3);
				Thread.sleep(1000);
				randomOption3.click();
				Thread.sleep(1000);
				String year11 = findElement("SpouseEmplyomentMM_ID").getText();
				String monthInWords11 = findElement("SpouseEmplyomentYY_ID").getText(); 
				String Q_SpouseEmplyomentAtazQuestion = findElement("SpouseEmplyomentAtazQuestion_XPATH").getText(); 
				String month11 = monthMap.get(monthInWords11);
				String A_SpouseEmplyomentAtazQuestion = year11 + "-" + month11;
				log.debug(Q_SpouseEmplyomentAtazQuestion+" "+A_SpouseEmplyomentAtazQuestion);
				// Spouse Enrolled at ASU
				WebElement elementToScroll = findElement("SpouseEnrolledASUQuestion_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
				Thread.sleep(500);
				List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='employment_radio_isSpouseEmployedInAnyUni']"));
				int Count = radioButtons.size();
				Random random1111 = new Random();
				int randomIndex11111 = random1111.nextInt(radioButtons.size());
				String selectedOption = radioButtons.get(randomIndex11111).getAttribute("value");
				Thread.sleep(500);
				radioButtons.get(randomIndex11111).click();
				Thread.sleep(500);
				String 	Q_SpouseEnrolledASUQuestion	=	findElement("SpouseEnrolledASUQuestion_XPATH").getText();
				if(selectedOption.contains("Y"))
				{
					log.debug(Q_SpouseEnrolledASUQuestion +" " + "Yes");
					A_SpouseEnrolledAZcoll = "Yes";
				}
				else
					log.debug(Q_SpouseEnrolledASUQuestion+"  " + "No" );
				A_SpouseEnrolledAZcoll = "No";


				// Spouse dependent on someone
				WebElement elementToScroll3 = findElement("SpouseDependentonOtherQuestion_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll3);
				Thread.sleep(500);
				List<WebElement> radioButtons3 = driver.findElements(By.xpath("//input[@name='employment_radio_isSpouseDependent']"));
				int Count3= radioButtons.size();
				Random random11111 = new Random();
				int randomIndex111111 = random11111.nextInt(radioButtons3.size());
				String selectedOption1 = radioButtons3.get(randomIndex111111).getAttribute("value");
				Thread.sleep(500);
				radioButtons3.get(randomIndex111111).click();
				Thread.sleep(500);
				String 	Q_SpouseDependentonOtherQuestion	=	findElement("SpouseDependentonOtherQuestion_XPATH").getText();
				if(selectedOption1.contains("Y"))
				{
					log.debug(Q_SpouseDependentonOtherQuestion +" " + "Yes");
					A_SpouseDependentOnOtherString = "Yes";
				}
				else
					log.debug(Q_SpouseDependentonOtherQuestion+"  " + "No" );
				A_SpouseDependentOnOtherString = "No";


			}
		}
		catch(Exception e) {}
	}
	public void SaveThePage() throws InterruptedException
	{
		// Clicks on Save button
		Thread.sleep(1000);
		click("SaveBtn_XPATH");
		Thread.sleep(3000);
	}
}






