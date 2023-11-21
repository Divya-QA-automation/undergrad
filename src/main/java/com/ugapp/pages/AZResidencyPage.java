package com.ugapp.pages;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


import org.apache.poi.EncryptedDocumentException;
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
	String selectedFinacialSupport = "";






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
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData("validData",123, Q_PermanentHome,selectedPermanentHome );
		saveReport();
	}
	public void EnrolledAnotherCollOrUniversity() throws EncryptedDocumentException, Exception
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
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",124, Q_EnrolledAtOtherColl,"Yes");
			saveReport();
		}
		// Enter a Enrolled college or University name
		String A_CurrentlyEnrolled = "Test College";
		WebElement elementToScrollTo = findElement("EnrolledCollTxtfield_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		type("EnrolledCollTxtfield_XPATH",A_CurrentlyEnrolled);
		Thread.sleep(1000);
		String Q_EnrolledCollOrUniversity = findElement("EnrolledCollQuestion_XPATH").getText();
		log.debug( Q_EnrolledCollOrUniversity+" "+ A_CurrentlyEnrolled);
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData("validData",125, Q_EnrolledCollOrUniversity,A_CurrentlyEnrolled);
		saveReport();


		//  Select a State of Enrolled college or University
		click("EnrolledStateDD_XPATH");
		Thread.sleep(1000);
		List<WebElement> options  = driver.findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		int Options = options.size();
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
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData("validData",126, Q_EnrolledState,A_EnrolledState);
		saveReport();


	}




	public void EnrolledAtASU() throws Exception 
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
			log.debug(Q_EnrolledASU +" : " + "Yes");
			A_EnrolledAZcoll = "Yes";
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",127, Q_EnrolledASU,A_EnrolledAZcoll);
			saveReport();
		}
		else
		{
			log.debug(Q_EnrolledASU+" : " + "No" );
			A_EnrolledAZcoll = "No";
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",127, Q_EnrolledASU,A_EnrolledAZcoll);
			saveReport();
		}
	}




	// Dependent on for income Tax on PArents i missing-------------------------
	// Question is not meant for above 24 yrs of Age




	public void DriverLicense() throws EncryptedDocumentException, Exception
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
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",128, Q_EnrolledASU,"Yes");
			saveReport();
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
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",129," In which state was your license issued? ",A_LicenseIssuedState);
			saveReport();
		}
		else
		{
			log.debug("Is this vehicle registered in the state of Arizona?"+" " + "No");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",129," In which state was your license issued? ",A_LicenseIssuedState);
			saveReport();
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
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData("validData",130,Q_LicenseIssuedDate,LicenseIssuedDate);
		saveReport();
	}
	public void VehicleDetails() throws EncryptedDocumentException, Exception
	{
		WebElement elementToScrollTo = findElement("OwnvehicleYesRadioBtn_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		click("OwnvehicleYesRadioBtn_XPATH");
		String Q_OwnVehicle	=findElement("OwnVehicleQuestion_XPATH").getText();
		log.debug(Q_OwnVehicle+" "+ "Yes");
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData("validData",131,Q_OwnVehicle,"Yes");
		saveReport();
		Thread.sleep(1000);


		WebElement elementToScrollTo1 = findElement("VehicleRegisteredYesRadioBtn_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("VehicleRegisteredYesRadioBtn_XPATH");
		String Q_VehicleRegistered	=findElement("VehicleRegisteredQuestion_XPATH").getText();
		log.debug(Q_VehicleRegistered+" "+ "Yes");
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData("validData",132," Is this vehicle registered in the state of Arizona? ","Yes");
		saveReport();


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
		String year = findElement("RegistrationYearDD_XPATH").getText();
		String monthInWords = findElement("RegistrationMonthDD_XPATH").getText(); 
		String Q_VehicleRegisteredDate = findElement("VehicleRegisteredQuestion_XPATH").getText(); 
		// Convert month in words to numeric representation using the monthMap
		String month = monthMap.get(monthInWords);
		// Format the selected year and month as 'YYYY-MM'
		String VehicleRegisteredDate = year + "-" + month;
		log.debug(Q_VehicleRegisteredDate+" "+VehicleRegisteredDate);
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData("validData",133,Q_VehicleRegisteredDate,VehicleRegisteredDate);
		saveReport();


	}
	public void StateTaxes() throws Exception
	{
		WebElement elementToScrollTo = findElement("DidFileStateTaxYesRadioBtn_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		click("DidFileStateTaxYesRadioBtn_XPATH");
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData("validData",134," Did you, or will you, file state taxes for 2022? ","Yes");
		saveReport();


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
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData("validData",135," Where did or where will you file your state taxes for 2022? ", A_LocStateTax);
		saveReport();

	}
	public void FinancialSupport() throws Exception 
	{
		int totalPercentage = 100;
		int numberOfRows = 5;

		Random random = new Random();
		int[] percentages = new int[numberOfRows];

		// Generate random percentages
		for (int i = 0; i < numberOfRows - 1; i++) {
			int bound = Math.max(1, totalPercentage - (numberOfRows - 1));
			percentages[i] = random.nextInt(bound) + 1;
			totalPercentage -= percentages[i];
		}


		// Assign the remaining percentage to the last row
		percentages[numberOfRows - 1] = totalPercentage;

		// Ensure that at least one row has 1%
		int randomRowIndex = random.nextInt(numberOfRows);
		if (percentages[randomRowIndex] > 1) {
			percentages[randomRowIndex]--;
			percentages[randomRowIndex == numberOfRows - 1 ? 0 : randomRowIndex + 1]++;
		}

		// Print the generated percentages
		for (int i = 0; i < numberOfRows; i++) 
		{
			System.out.println("Row " + (i + 1) + ": " + percentages[i] + "%");
		}

		//		
		//		WebElement elementToScrollTo = driver.findElement(By.xpath("//div[@data-cy='arizona-residency-financial-table']"));
		//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		//		Random random = new Random();
		//		int[] percentages = new int[5]; // Assuming 5 rows
		//
		//		int remainingPercentage = 100;
		//		for (int i = 0; i < percentages.length - 1; i++) {
		//			// Generate random percentage between 1 and remainingPercentage
		//			if (remainingPercentage > 0) {
		//				percentages[i] = random.nextInt(remainingPercentage) + 1;
		//				remainingPercentage -= percentages[i];
		//			} else {
		//				// If remainingPercentage is 0, assign 1 to avoid IllegalArgumentException
		//				percentages[i] = 1;
		//			}
		//		}
		//
		//		// Assign the remaining percentage to the last row
		//		percentages[percentages.length - 1] = remainingPercentage;

		List<WebElement> rows = driver.findElements(By.xpath("//div[@data-cy='arizona-residency-financial-table']//td[2]//input"));
		int size = rows.size();

		// To fetch the Titles of the Sources
		List<WebElement> titles = driver.findElements(By.xpath("(//div[@data-cy='arizona-residency-financial-table']//td[1])[position() <= 5]")); // Fetch only the first 5 titles


		List<String> sourceTitles = new ArrayList<>();
		// To store all the %
		List<String> percentagesSent = new ArrayList<>();


		for (WebElement titleElement : titles) 
		{
			String title = titleElement.getText();
			sourceTitles.add(title);


		}
		for (int i = 0; i < rows.size(); i++) 
		{
			WebElement row = rows.get(i);
			String percentageValue = String.valueOf(percentages[i]);
			row.sendKeys(percentageValue);
			percentagesSent.add(percentageValue); // Store the value in the ArrayList



		}


		for (int i1 = 0,j=136; i1 <= 4; i1++) {
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",j++,sourceTitles.get(i1)+" financial support",percentagesSent.get(i1));
			saveReport();


		}




		int totalSum = 0;
		for (int i = 0; i < rows.size(); i++) 
		{
			WebElement row = rows.get(i);
			totalSum += Integer.parseInt(row.getAttribute("value"));
		}

		if (totalSum == 100) {
			log.debug("Total sum is 100.");
		} else {
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
				List<WebElement> Checkboxes = driver.findElements(By.xpath("//fieldset[@data-cy='arizona-residency-other-options']//input/following-sibling::label//span"));
				int Count = Checkboxes.size();
				Random random = new Random();
				int randomIndex = random.nextInt(Checkboxes.size());
				WebElement element = Checkboxes.get(randomIndex);
				Thread.sleep(1000);
				String selectedOption = element.getText();
				Thread.sleep(500);
				log.debug("Selected Other Financial Support : " + selectedOption);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);


				List<String> Titles = new ArrayList<>();
				List<String> YesNoValues = new ArrayList<>();


				for (WebElement X : Checkboxes)
				{
					String CheckboxText = X.getText();
					Titles.add(CheckboxText); // Add Checkbox title to Titles list
					if (X.equals(element)) 
					{
						YesNoValues.add("Y"); // Selected checkbox is 'Yes'
					} else 
					{
						YesNoValues.add("N"); // Other checkboxes are 'No'
					}
				}


				for (int i = 0,j=141; i <= 7; i++) 
				{
					initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData("validData",j++,Titles.get(i), YesNoValues.get(i));
					saveReport();
				}




				if(findElement("DescribeSourceOfSupport_ID").isDisplayed())
				{
					Thread.sleep(500);
					type("DescribeSourceOfSupport_ID","Test Source of Support");
				}
			}
		}
		catch(Exception e) {}
	}



	public void EmploymentDetails() throws Exception
	{
		WebElement elementToScrollTo = findElement("CurrentlyEmployedQuestion_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		click("EmployedYesRdBtn_XPATH");
		Thread.sleep(1000);
		WebElement elementToScrollTo1 = findElement("CurrentlyEmployedQuestion_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("PrimaryWorkLocDD_XPATH");
		Thread.sleep(1000);
		click("PrimaryWorkAZloc_XPATH");
		Thread.sleep(1000);
		
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
		String year = findElement("EmploymentLocYearDD_XPATH").getText();
		String monthInWords = findElement("EmploymentLocMonthDD_XPATH").getText(); 
		String Q_EmplyomentLocDateQuestion = findElement("EmplyomentLocDateQuestion_XPATH").getText(); 
		// Convert month in words to numeric representation using the monthMap
		String month = monthMap.get(monthInWords);
		// Format the selected year and month as 'YYYY-MM'
		String EmlyomentLocationDate = year + "-" + month;
		log.debug(Q_EmplyomentLocDateQuestion+" "+EmlyomentLocationDate);
		saveReport();
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData("validData",147," Are you currently employed? ", "Yes");
		setExcelData("validData",148," Where is your primary work location? ", "Arizona");
		setExcelData("validData",149,Q_EmplyomentLocDateQuestion, EmlyomentLocationDate);
		saveReport();

	}
	public void SpouseOrDependentflow() throws EncryptedDocumentException, Exception
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
		Thread.sleep(1000);
		saveReport();
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData("validData",150," You indicated that you were the spouse or dependent of a U.S. service member or veteran. Which best describes the service member or veteran? ", selectedSpouseOrDependentText);
		saveReport();
		if(selectedSpouseOrDependentText.contains("Veteran"))
		{

			log.debug("Selected Service member or veteran: "+" "+selectedSpouseOrDependentText);
			WebElement elementToScroll1 = findElement("RegisteredToVoteQuestion_XPATH");
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
			click("RegisteredToVoteYesRdBtn_XPATH");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",151," Are you registered to vote? ", "Yes");
			saveReport();
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
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",152,Q_RegisteredToVoteStateQuestion, selectedRegisteredToVoteStateText);
			saveReport();


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
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",153,PGSactiveDutyQuestion, PGSLocationDate);
			saveReport();


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
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",154," Are you eligible for Chapter 30 or Chapter 33 benefits? ", A_EligibleForChapter30);
				saveReport();
			}
			else
			{
				log.debug("Selected Option: " + "No" );
				A_EligibleForChapter30 = "No";
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",154," Are you eligible for Chapter 30 or Chapter 33 benefits? ", A_EligibleForChapter30);
				saveReport();
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
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",155," Where is your spouse/parent/guardian currently stationed? ", selectedLocText);
			saveReport();
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
				String 	selectedText	= findElement("SpouseParentGuardianLegalResid_XPATH").getText();
				log.debug("Selected option: " + selectedText);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",156,"What is your spouse/parent/guardians state of legal residence?", selectedText);
				saveReport();
			}
		}

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
				String Q_AmericanIndianAlaskaNativeString = findElement("AmericanIndianAlaskaNativeQuestion_XPATH").getText();
				if(selectedOption.contains("Y"))
				{
					log.debug( "Selected Option: " + "Yes");
					A_AmericanIndianAlaskaNativeString = "Yes";
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData("validData",157,Q_AmericanIndianAlaskaNativeString, A_AmericanIndianAlaskaNativeString);
					saveReport();
				}
				else
				{
					log.debug("Selected Option: " + "No" );
					A_AmericanIndianAlaskaNativeString = "No";
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData("validData",157,Q_AmericanIndianAlaskaNativeString, A_AmericanIndianAlaskaNativeString);
					saveReport();
				}
			}
		}
		catch(Exception e) {}
	}




	public void ParentLegalGuardianDetails() throws EncryptedDocumentException, Exception
	{
		try
		{
			Thread.sleep(1000);
			WebElement elementToScrollTo = findElement("ParentCurrentLocDD_XPATH");
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			Thread.sleep(1000);
			click("ParentCurrentLocDD_XPATH");
			Thread.sleep(1000);
			click("ParentCurrentLocAZDD_XPATH");
			initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",158," In which state do your parent(s) or legal guardian(s) currently live? ", "Arizona");
			saveReport();
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
			Thread.sleep(1000);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",159," Which parent or legal guardian lives in Arizona? ", selectedText);
			saveReport();


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
			//		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			//		setExcelData("validData",116,Q_ParentLivingInAZ, A_ParentLivingInAZDate);
			//		saveReport();


			// Parent State Income Tax Return
			WebElement elementToScroll = findElement("ParentStateTaxQuestion_XPATH");
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
			click("ParentStateTaxYesRdBtn_XPATH");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",160," Did or will your parent(s) or legal guardian(s) file a state income tax return for the 2022 tax year? ", "Yes");
			saveReport();
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
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",161," In which state did, or will, your parent(s) or legal guardian(s) file state income taxes? ", selectedText1);
			saveReport();


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
				log.debug( " Does either parent or legal guardian have a current Arizona driver license? " + "Yes");
				A_ParentHaveDLString = "Yes";
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",162," Does either parent or legal guardian have a current Arizona driver license? ", "Yes");
				saveReport();
			}
			if(selectedAnswer.contains("N"))
			{
				log.debug(" Does either parent or legal guardian have a current Arizona driver license? " + "No" );
			A_ParentHaveDLString = "No";
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData",162," Does either parent or legal guardian have a current Arizona driver license? ", "");
			saveReport();

			}






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
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",163," Is either parent or legal guardian employed in Arizona? ", A_ParentEmloyedInAZString);
				saveReport();
			}
			if(selectedOpt.contains("N"))
			{
				log.debug("Selected Option: " + "No" );
				A_ParentEmloyedInAZString = "No";
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",163," Is either parent or legal guardian employed in Arizona? ", A_ParentEmloyedInAZString);
				saveReport();
			}}

		catch(Exception e) {}

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
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",164," In which state does your spouse currently live? ", "Arizona");
				saveReport();
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
				
				String year = findElement("SpouseLivesAZyy_CSS").getText();
				String monthInWords = findElement("SpouseLivesAZmm_CSS").getText(); 
				String Q_SpouseLivesAZquestion = findElement("SpouseLivesAZquestion_XPATH").getText(); 
				String month = monthMap.get(monthInWords);
				String A_SpouseLivesAZquestion = year + "-" + month;
				Thread.sleep(500)	;
				log.debug(Q_SpouseLivesAZquestion+" "+A_SpouseLivesAZquestion);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",165,Q_SpouseLivesAZquestion, A_SpouseLivesAZquestion);
				saveReport();

				WebElement elementToScrollTo = findElement("SpouseDLquestion_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				click("SpouseDLyesRdBtn_XPATH");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",166," Does your spouse have a valid drivers license or state-issued ID? ", "Yes");
				saveReport();
				click("SpouseDLlocDD_CSS");
				click("SpouseDLLocAZDD_XPATH");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",167," What state issued this drivers license or state ID?  ", "Arizona");
				saveReport();
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
				
				String year1 = findElement("SpouseDLyy_CSS").getText();
				String monthInWords1 = findElement("SpouseDLmm_CSS").getText(); 
				String Q_SpouseDLDateQuestion = findElement("SpouseDLDateQuestion_XPATH").getText(); 
				String month1 = monthMap.get(monthInWords1);
				String A_SpouseDLDateQuestion = year1 + "-" + month1;
				log.debug(Q_SpouseDLDateQuestion+" "+A_SpouseDLDateQuestion);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",168,Q_SpouseDLDateQuestion, A_SpouseDLDateQuestion);
				saveReport();

				WebElement elementToelementSpouseIncome = findElement("SpouseStateTaxQuestion_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToelementSpouseIncome);
				click("SpouseStateTaxYesRdBtn_XPATH");
				Thread.sleep(500);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",169," Did or will your spouse file a state income tax return for the 2022 tax year? ", "Yes");
				saveReport();
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
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",170,Q_SpouseIncomeTaxState, A_SpouseIncomeTaxState);
				saveReport();

				// Spouse Employment
				WebElement elementToSpouseEmplyoment = findElement("SpouseEmployedQuestion_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToSpouseEmplyoment);
				click("SpouseEmployedYesRdBtn_XPATH");
				Thread.sleep(500);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",171," Is your spouse employed? ", "Yes");
				saveReport();
				WebElement elementToSpouseEmp = findElement("SpouseEmployedStateDD_CSS");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToSpouseEmp);
				click("SpouseEmployedStateDD_CSS");
				Thread.sleep(500);
				click("SpouseEmployedLocAZDD_XPATH");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",172," In which state is your spouse employed? ", "Arizona");
				saveReport();

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
				
				String year11 = findElement("SpouseEmplyomentYY_ID").getText();
				String monthInWords11 = findElement("SpouseEmplyomentMM_ID").getText(); 
				String Q_SpouseEmplyomentAtazQuestion = findElement("SpouseEmplyomentAtazQuestion_XPATH").getText(); 
				String month11 = monthMap.get(monthInWords11);
				String A_SpouseEmplyomentAtazQuestion = year11 + "-" + month11;
				log.debug(Q_SpouseEmplyomentAtazQuestion+" "+A_SpouseEmplyomentAtazQuestion);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",173,Q_SpouseEmplyomentAtazQuestion, A_SpouseEmplyomentAtazQuestion);
				saveReport();

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
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData("validData",174,Q_SpouseEnrolledASUQuestion, "Yes");
					saveReport();
				}
				if(selectedOption.contains("N"))
				{
					log.debug(Q_SpouseEnrolledASUQuestion+"  " + "No" );
				A_SpouseEnrolledAZcoll = "No";
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",174,Q_SpouseEnrolledASUQuestion, "No");
				saveReport();

				}


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
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData("validData",175,Q_SpouseDependentonOtherQuestion, A_SpouseDependentOnOtherString);
					saveReport();
				}
				else
					log.debug(Q_SpouseDependentonOtherQuestion+"  " + "No" );
				A_SpouseDependentOnOtherString = "No";
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData("validData",175,Q_SpouseDependentonOtherQuestion, A_SpouseDependentOnOtherString);
				saveReport();




			}
		}
		catch(Exception e) {}
	}
	public void SaveThePage() throws Throwable
	{
		// Clicks on Save button
		Thread.sleep(1000);
		click("SaveBtn_XPATH");
		waitTillLoaderDisappears();
		Thread.sleep(3000);

	}
}














