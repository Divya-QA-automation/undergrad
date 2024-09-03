package com.ugapp.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ugapp.base.Page;




public class MyASUProgramPage extends Page{


	static ThreadLocal<String> selectedProgram1= new ThreadLocal<>();
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	static ThreadLocal<String> validFirstChoice=new ThreadLocal<>();
	static ThreadLocal<String> validFirstLocation=new ThreadLocal<>();
	static ThreadLocal<String> validFirstStartingTerm=new ThreadLocal<>();
	static ThreadLocal<String> validSecondChoice=new ThreadLocal<>();
	static ThreadLocal<String> validSecondLocation=new ThreadLocal<>();
	static ThreadLocal<String> validSecondStartingTerm=new ThreadLocal<>();
	static ArrayList<String> CA = new ArrayList<>();
	static ThreadLocal<String> option1=new ThreadLocal<>();
	static ThreadLocal<String> option2=new ThreadLocal<>();
	static ThreadLocal<String> option3=new ThreadLocal<>();
	static ThreadLocal<String> option4=new ThreadLocal<>();


	public void GetProgList()
	{
		System.out.println("Start......");
		List<WebElement> x = getDriver().findElements(By.xpath("//div[@class='row py-space-sm py-lg-space-md border-bottom']//div//h3"));
		int	count=x.size();
		log.debug("count"+count);
		System.out.println("count"+count);
		for(WebElement X:x)
		{
			String Programs = X.getText();
			System.out.println("Programs list :+"+Programs);
			log.debug("Programs list :+"+Programs);
		}

	}



	public  void validateMyProgram() throws Throwable
	{
		waitTillProgressbarDisappears();
		WebElement elementToScrollTo1 = findElement("MyProgramTitle_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		String PageTitle	= findElement("MyProgramTitle_XPATH").getText();
		log.debug("Page title :"+" "+PageTitle);
	}








	public  void errorMessage()
	{
		findElement("continue_XPATH").click();
		try
		{
			String error=findElement("continueError_XPATH").getText();
			log.debug("The error message : "+error+ " pops up when clicked on continue without filling the form!");
		}
		catch(Exception e)
		{
			log.debug("The error message does not pop up when clicked on continue without filling the form!");
		}
	}


	public  void calender() throws Throwable
	{
		findElement("calender_XPATH").click();
		Thread.sleep(2000);
	}


	public  void validateCalender()
	{
		try
		{
			findElement("validateCalender_XPATH");
			log.debug("Acedemic calender section is displayed when clicked on academic calender link!");
			findElement("calenderBack_XPATH").click();
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			log.debug("Acedemic calender section is not displayed when clicked on academic calender link!");
		}
	}


	public  void interestArea() throws Throwable
	{
		WebElement elementToScroll =findElement("interestAreaDropdown_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		Thread.sleep(1500);
		findElement("interestAreaDropdown_XPATH").click();	




		List<WebElement> checkbox = getDriver().findElements(By.xpath("//input[@type='checkbox']"));
		ArrayList<Integer> random = getRandomNumber(1, checkbox.size(), 4);




		ArrayList<String> ls=new ArrayList<>();
		for(int ran:random)
		{
			String checkedInterestAreas=getDriver().findElement(By.xpath("(//div[@id='interest_area_select']//ul//input/following-sibling::label)["+ran+"]")).getText();
			WebElement elementToScrollTo = getDriver().findElement(By.xpath("(//div[@id='interest_area_select']//ul//input/following-sibling::label)["+ran+"]"));
			ls.add(checkedInterestAreas);
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			Thread.sleep(1000);
			getDriver().findElement(By.xpath("(//div[@id='interest_area_select']//ul//input/..)["+ran+"]")).click();
			Thread.sleep(1500);
		}








		//close the checkbox
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		findElement("interestAreaDropdown_XPATH").click();	
		Thread.sleep(1000);







		//check for the selected interest areas
		ArrayList<String> ls1=new ArrayList<>();
		List<WebElement> selectedInterestAreas = getDriver().findElements(By.xpath("//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-interest-button']"));
		int i=1;
		for(WebElement sel:selectedInterestAreas)
		{
			String selectedAreas=getDriver().findElement(By.xpath("(//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-interest-button'])["+i+"]")).getText();
			i++;
			ls1.add(selectedAreas);
		}




		//validate if checked areas is same as selected areas
		if(ls.equals(ls1))
		{
			log.debug("The selected Interested Areas from the dropdown is displayed in the UI!");
		}
		else
			log.debug("The selected Interested Areas from the dropdown is not displayed in the UI!");








		//fetch the placeholder of interestAreas
		String placeholder = findElement("placeholderInterest_XPATH").getText();
		String digit = placeholder.replaceAll("[^0-9]", "");




		//fetch the placeholder of clearallfilter
		String placeholderClear = findElement("placeholderClearAll_XPATH").getText();
		String digit1 = placeholderClear.replaceAll("[^0-9]", "");




		// Convert the extracted digit to an integer
		int intValue = Integer.parseInt(digit);
		int intValue1 = Integer.parseInt(digit1);


		if(intValue==ls1.size() && intValue1==ls1.size())
		{
			log.debug("The InterestArea and ClearAll placeholder displays the right number of InterestArea options selected!");
		}
		else
			log.debug("The InterestArea and ClearAll placeholder is not displaying the right number of InterestArea options selected!");




	}


	public  void college() throws Throwable
	{
		Thread.sleep(1500);
		WebElement elementToScroll =findElement("collegeDropdown_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		findElement("collegeDropdown_XPATH").click();	
		Thread.sleep(1500);



		List<WebElement> checkbox = getDriver().findElements(By.xpath("//input[@type='checkbox']"));
		ArrayList<Integer> random = getRandomNumber(1, checkbox.size(), 4);




		ArrayList<String> ls=new ArrayList<>();
		for(int ran:random)
		{
			String checkedInterestAreas=getDriver().findElement(By.xpath("(//div[@id='college_filter_select']//ul//input/following-sibling::label)["+ran+"]")).getText();
			WebElement elementToScrollTo = getDriver().findElement(By.xpath("(//div[@id='college_filter_select']//ul//input/following-sibling::label)["+ran+"]"));
			ls.add(checkedInterestAreas);
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			Thread.sleep(1000);
			getDriver().findElement(By.xpath("(//div[@id='college_filter_select']//ul//input/..)["+ran+"]")).click();
			Thread.sleep(1000);
		}


		//close the checkbox
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		findElement("collegeDropdown_XPATH").click();	
		Thread.sleep(3000);

		//check for the selected interest areas
		ArrayList<String> ls1=new ArrayList<>();
		List<WebElement> selectedCollege = getDriver().findElements(By.xpath("//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-college-button']"));
		int i=1;
		for(WebElement sel:selectedCollege)
		{
			String selectedAreas=getDriver().findElement(By.xpath("(//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-college-button'])["+i+"]")).getText();
			i++;
			ls1.add(selectedAreas);
		}




		//validate if checked areas is same as selected areas
		if(ls.equals(ls1))
		{
			log.debug("The selected College from the dropdown is displayed in the UI!");
		}
		else
			log.debug("The selected College from the dropdown is not displayed in the UI!");








		//fetch the placeholder of interestAreas
		String placeholder = findElement("placeholderInterest_XPATH").getText();
		String digit = placeholder.replaceAll("[^0-9]", "");


		//fetch the placeholder of college
		String placeholderCollege = findElement("placeholderCollege_XPATH").getText();
		String digit1 = placeholderCollege.replaceAll("[^0-9]", "");




		//fetch the placeholder of clearallfilter
		String placeholderClear = findElement("placeholderClearAll_XPATH").getText();
		String digit2 = placeholderClear.replaceAll("[^0-9]", "");


		// Convert the extracted digit to an integer
		int interest = Integer.parseInt(digit);
		int college = Integer.parseInt(digit1);
		int clearall = Integer.parseInt(digit2);




		int sum=interest+college;




		List<WebElement> finalList = getDriver().findElements(By.xpath("(//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-college-button'])  | (//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-interest-button'])"));




		if(clearall==finalList.size() && clearall==sum)
		{
			log.debug("The ClearAll placeholder displays the right number of options selected!");
		}
		else
			log.debug("The ClearAll placeholder is not displaying the right number of options selected!");
	}


	public  void checkSelectedOptions() throws Throwable
	{
		Thread.sleep(1500);
		List<WebElement> selectedOptions = getDriver().findElements(By.xpath("(//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-college-button'])  | (//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-interest-button'])"));
		ArrayList<Integer> random = getRandomNumber(1, selectedOptions.size(), 1);




		ArrayList<String> ls=new ArrayList<>();
		for(int ran:random)
		{
			getDriver().findElement(By.xpath("((//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-college-button'])  | (//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-interest-button']))["+ran+"]")).click();
			Thread.sleep(1000);
		}




		//fetch the placeholder of clearallfilter
		String placeholderClear = findElement("placeholderClearAll_XPATH").getText();
		String digit2 = placeholderClear.replaceAll("[^0-9]", "");
		int clearall = Integer.parseInt(digit2);
		List<WebElement> selectedOptions1 = getDriver().findElements(By.xpath("(//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-college-button'])  | (//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-interest-button'])"));
		if(selectedOptions1.size()==clearall)
		{
			log.debug("The selected options were cleared successfully!");
		}
		else
			log.debug("The selected options were not cleared!");

	}


	public  void clearAll()
	{
		findElement("clearAllFilter_XPATH").click();
	}


	public  void chooseThisProgram() throws Throwable
	{
		Thread.sleep(2000);
		List<WebElement> programs = getDriver().findElements(By.xpath("//button[text()=' Choose this program ']"));
		ArrayList<Integer> random = getRandomNumber(1, programs.size(), 1);



		for(int ran:random)
		{
			Thread.sleep(1000);
			WebElement elementToScrollTo = getDriver().findElement(By.xpath("(//button[text()=' Choose this program '])["+ran+"]"));
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			selectedProgram1.set(getDriver().findElement(By.xpath("(//button[text()=' Choose this program ']/../..//span)["+ran+"]")).getText());
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("(//button[text()=' Choose this program ']/preceding-sibling::a)["+ran+"]")).click();
			waitTillLoaderDisappears();
			Thread.sleep(2000);
			String selectedProgram2 = getDriver().findElement(By.xpath("//div[@id='programs_details_sidebar']//h2")).getText();
			log.debug("selectedProgram1 :"+selectedProgram1.get());
			log.debug("selectedProgram2 :"+selectedProgram2);
			if(selectedProgram1.get().equalsIgnoreCase(selectedProgram2))
				log.debug("View details link works as expected!");
			else
				log.debug("View Details link does not work");
			getDriver().findElement(By.xpath("//div[@id='programs_details_sidebar']//span[text()='Back']")).click();
			Thread.sleep(2000);
			getDriver().findElement(By.xpath("(//button[text()=' Choose this program '])["+ran+"]")).click();
			waitTillLoaderDisappears();
		}
	}


	public  void DupApp_chooseThisProgram() throws Throwable
	{
		WebElement elementToScrollTo = findElement("AfricanProgram_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		click("AfricanProgram_XPATH");
		Thread.sleep(2000);
		click("AfricanProgramTerm_XPATH");
		WebElement elementToScrollTo11 = findElement("chooseProgramNext_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		findElement("chooseProgramNext_XPATH").click();
		Thread.sleep(1000);
		WebElement elementToScrollTo1111 = findElement("chooseProgramSaveChoice_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
		findElement("chooseProgramSaveChoice_XPATH").click();
		Thread.sleep(1500);

	}




	public  void chooseSession() throws Throwable
	{
		Thread.sleep(1000);
		List<WebElement> programs = getDriver().findElements(By.xpath("//fieldset[@id='group_program_select_date']//div//input"));
		ArrayList<Integer> random = getRandomNumber(1, programs.size(), 1);

		for(int ran:random)
		{
			System.out.println("ran   :"+ran);
			getDriver().findElement(By.xpath("(//div[@id='program_select_date']//div//label//span)["+ran+"]")).click();
			waitTillLoaderDisappears();
			Thread.sleep(1000);
		}

		WebElement elementToScrollTo = findElement("chooseProgramNext_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
		findElement("chooseProgramNext_XPATH").click();
		Thread.sleep(1000);
		WebElement elementToScrollTo1 = findElement("chooseProgramSaveChoice_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		findElement("chooseProgramSaveChoice_XPATH").click();
		Thread.sleep(1500);
	}


	public  void highRequirementMajor() throws Throwable
	{
		try
		{
			if(findElement("alert_XPATH").isDisplayed())
			{
				chooseThisProgram();
				Thread.sleep(1000);
				List<WebElement> programs = getDriver().findElements(By.xpath("//fieldset[@id='group_program_select_date']//div//input[not(@disabled)]"));
				ArrayList<Integer> random = getRandomNumber(1, programs.size(), 1);


				for(int ran:random)
				{
					Thread.sleep(500);
					getDriver().findElement(By.xpath("(//fieldset[@id='group_program_select_date']//div//input[not(@disabled)]/..//label//span)["+ran+"]")).click();
					waitTillLoaderDisappears();
					Thread.sleep(500);
				}


				findElement("chooseProgramNext_XPATH").click();
				findElement("chooseProgramSaveChoice_XPATH").click();
			}
		}
		catch(Exception e)
		{
		}
	}


	public  void careerAdvising(String colKey,String colValue) throws Throwable
	{
		Thread.sleep(1000);
		List<WebElement> career = getDriver().findElements(By.xpath("//div[@id='interested_in_anything_checkbox_group']//div"));
		ArrayList<Integer> random = getRandomNumber(1, career.size(), 2);




		for(int ran:random)
		{
			WebElement elementToScroll =getDriver().findElement(By.xpath("(//div[@id='interested_in_anything_checkbox_group']//label)["+ran+"]"));
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
			getDriver().findElement(By.xpath("(//div[@id='interested_in_anything_checkbox_group']//label)["+ran+"]")).click();
			String text=getDriver().findElement(By.xpath("(//div[@id='interested_in_anything_checkbox_group']//label/span)["+ran+"]")).getText();




			if(text.equalsIgnoreCase("Pre-law"))
			{
				option1.set("Pre-law interest");
				CA.add(option1.get());
			}
			if(text.equalsIgnoreCase("Pre-med or pre-health*"))
			{
				option2.set("Pre-med/health interest");
				CA.add(option2.get());
			}
			if(text.equalsIgnoreCase("Pre-veterinary"))
			{
				option3.set("Pre-veterinary interest");
				CA.add(option3.get());
			}
			if(text.equalsIgnoreCase("Future opportunities to earn a teaching certificate in the field of your major"))
			{
				option4.set("Teaching certificate interest");
				CA.add(option4.get());
			}
		}




		Thread.sleep(1000);


		log.debug("Checked carreer advising :"+CA);
		career(colKey,colValue);
		validData(colKey,colValue);


		waitTillLoaderDisappears();
		Thread.sleep(1000);
	}


	//to get yes or no for careeer advising from My asu program page 2
	public  void career(String colKey,String colValue) throws Exception
	{
		ArrayList<String> ls2 = new ArrayList<>();
		ArrayList<String> ls3 = new ArrayList<>();
		ls2.add("Pre-law interest");
		ls2.add("Pre-med/health interest");
		ls2.add("Pre-veterinary interest");
		ls2.add("Teaching certificate interest");




		for (String element2 : ls2) {
			if (MyASUProgramPage.CA.contains(element2)) {
				ls3.add(element2);
			}
		}


		if(ls3.contains("Pre-law interest"))
			op1.set("Yes");
		else
			op1.set("No");
		if(ls3.contains("Pre-med/health interest"))
			op2.set("Yes");
		else
			op2.set("No");
		if(ls3.contains("Pre-veterinary interest"))
			op3.set("Yes");
		else
			op3.set("No");
		if(ls3.contains("Teaching certificate interest"))
			op4.set("Yes");
		else
			op4.set("No");


		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 40, "Pre-law interest", op1.get());
		setExcelData(colKey,colValue,"validData", 41, "Pre-med/health interest", op2.get());
		setExcelData(colKey,colValue,"validData", 42, "Pre-veterinary interest", op3.get());
		setExcelData(colKey,colValue,"validData", 43, "Teaching certificate interest", op4.get());
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}


	public  void validData(String colKey,String colValue) throws Throwable, Throwable
	{
		//firstChoice
		validFirstChoice.set(getDriver().findElement(By.xpath("(//div[@*='my-programs-selected-program']//h3)[2]")).getText());
		validFirstLocation.set(getDriver().findElement(By.xpath("(//div[@*='my-programs-selected-program']//p)[2]")).getText());
		validFirstStartingTerm.set(getDriver().findElement(By.xpath("(//div[@*='my-programs-selected-program']//p)[1]")).getText());
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 34, "First choice", validFirstChoice.get());
		setExcelData(colKey,colValue,"validData", 35, "Location", validFirstLocation.get());
		setExcelData(colKey,colValue,"validData", 36, "Starting term", validFirstStartingTerm.get());
		saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


		//SecondChoice
		try
		{
			validSecondChoice.set(getDriver().findElement(By.xpath("((//div[@daya-cy='my-programs-selected-program'])[2]//h3)[2]")).getText());
			validSecondLocation.set(getDriver().findElement(By.xpath("(//div[@*='my-programs-selected-program']//p)[4]")).getText());
			validSecondStartingTerm.set(getDriver().findElement(By.xpath("(//div[@*='my-programs-selected-program']//p)[3]")).getText());
			initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 37, "Second choice", validSecondChoice.get());
			setExcelData(colKey,colValue,"validData", 38, "Location",validSecondLocation.get());
			setExcelData(colKey,colValue,"validData", 39, "Starting term", validSecondStartingTerm.get());
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

		}
		catch(Exception e)
		{}
		log.debug("----------------------------------------------------");
	}

	public  void searchNursing() throws Throwable
	{
		//select nursing
		WebElement elementToScrollTo1 = findElement("search_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		findElement("search_XPATH");
		Thread.sleep(1000);
		type("search_XPATH","Nursing");
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//span[text()='Nursing - RN/BSN, BSN']/../../following-sibling::div//button[@data-cy='my-programs-choose-program-button']")).click();
		chooseSession();
		highRequirementMajor();
		Thread.sleep(1000);
		//practice as RN
		WebElement elementToScrollTo = getDriver().findElement(By.xpath("//h3[.=' Are you licensed in good standing to practice as an RN? ']"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);

		List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='licensed_standing_practice']"));
		int Count = radioButtons.size();
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
		String selectedGender = radioButtons.get(randomIndex).getAttribute("value");
		Thread.sleep(2000);
		radioButtons.get(randomIndex).click();
		Thread.sleep(1000);
		if(selectedGender.contains("Y"))
		{
			log.debug("Are you licensed in good standing to practice as an RN?" + "Yes");
		}
		if(selectedGender.contains("N")) 
		{
			log.debug("Are you licensed in good standing to practice as an RN?" + "No");
		}

		//praticeRegisteredNurse
		findElement("practiceRegisteredNurse_XPATH").click();
		Thread.sleep(1000);
		List<WebElement> state = getDriver().findElements(By.xpath("//ul[@role='listbox']//li"));
		ArrayList<Integer> randomState = getRandomNumber(0, state.size(), 1);
		for(int ran:randomState)
		{
			getDriver().findElement(By.xpath("(//ul[@role='listbox']//li)["+ran+"]")).click();	
		}
		//RN License number
		type("RNlicense_XPATH","12345");
		//license expiration date
		WebElement scroll = getDriver().findElement(By.xpath("//div[@id='group_license_expiration_date']//input"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", scroll);
		getDriver().findElement(By.xpath("(//div[@id='group_license_expiration_date']//input)[1]")).click();
		Thread.sleep(1000);
		List<WebElement> month = getDriver().findElements(By.xpath("//ul[@role='listbox']//li"));
		ArrayList<Integer> randomMonth = getRandomNumber(0, month.size(), 1);
		for(int ran:randomMonth)
		{
			getDriver().findElement(By.xpath("(//ul[@role='listbox']//li)["+ran+"]")).click();	
		}
		getDriver().findElement(By.xpath("(//div[@id='group_license_expiration_date']//input)[2]")).click();
		Thread.sleep(1000);
		List<WebElement> day = getDriver().findElements(By.xpath("//ul[@role='listbox']//li"));
		ArrayList<Integer> randomDay = getRandomNumber(0, day.size(), 1);
		for(int ran:randomDay)
		{
			getDriver().findElement(By.xpath("(//ul[@role='listbox']//li)["+ran+"]")).click();	
		}
		getDriver().findElement(By.xpath("(//div[@id='group_license_expiration_date']//input)[3]")).click();
		Thread.sleep(1000);
		List<WebElement> year = getDriver().findElements(By.xpath("//ul[@role='listbox']//li"));
		ArrayList<Integer> randomYear = getRandomNumber(0, year.size(), 1);
		for(int ran:randomYear)
		{
			getDriver().findElement(By.xpath("(//ul[@role='listbox']//li)["+ran+"]")).click();	
		}
		//license encumbered
		WebElement scroll1 = getDriver().findElement(By.xpath("//fieldset[@id='license_disciplinary_action_group']//input"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", scroll1);
		Thread.sleep(2000);
		List<WebElement> licenseEncumbered = getDriver().findElements(By.xpath("//fieldset[@id='license_disciplinary_action_group']//input"));
		ArrayList<Integer> randomlicense = getRandomNumber(0, licenseEncumbered.size(), 1);
		for(int ran:randomlicense)
		{
			getDriver().findElement(By.xpath("(//fieldset[@id='license_disciplinary_action_group']//input)["+ran+"]")).click();	
		}
		getDriver().findElement(By.xpath("(//div[@id='group_date_scheduled_for_nclexrn']//input)[1]")).click();
		Thread.sleep(1000);
		List<WebElement> month1 = getDriver().findElements(By.xpath("//ul[@role='listbox']//li"));
		ArrayList<Integer> randomMonth1 = getRandomNumber(0, month1.size(), 1);
		for(int ran:randomMonth)
		{
			getDriver().findElement(By.xpath("(//ul[@role='listbox']//li)["+ran+"]")).click();	
		}
		getDriver().findElement(By.xpath("(//div[@id='group_date_scheduled_for_nclexrn']//input)[2]")).click();
		Thread.sleep(1000);
		List<WebElement> day1 = getDriver().findElements(By.xpath("//ul[@role='listbox']//li"));
		ArrayList<Integer> randomDay1 = getRandomNumber(0, day1.size(), 1);
		for(int ran:randomDay)
		{
			getDriver().findElement(By.xpath("(//ul[@role='listbox']//li)["+ran+"]")).click();	
		}
		getDriver().findElement(By.xpath("(//div[@id='group_date_scheduled_for_nclexrn']//input)[3]")).click();
		Thread.sleep(1000);
		List<WebElement> year1 = getDriver().findElements(By.xpath("//ul[@role='listbox']//li"));
		ArrayList<Integer> randomYear1 = getRandomNumber(0, year1.size(), 1);
		for(int ran:randomYear)
		{
			getDriver().findElement(By.xpath("(//ul[@role='listbox']//li)["+ran+"]")).click();	
		}
		//employer
		WebElement scroll2 = findElement("employer_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", scroll2);
		Thread.sleep(1500);
		type("employer_XPATH","Test Employer");
		//partnerCode
		type("partnerCode_XPATH","12345");
		//Authorize ASU
		List<WebElement> releaseInfo = getDriver().findElements(By.xpath("//fieldset[@id='release_info_to_employer_group']//input"));
		ArrayList<Integer> random1 = getRandomNumber(0, releaseInfo.size(), 1);
		Thread.sleep(3000);
		WebElement scroll3 = getDriver().findElement(By.xpath("//fieldset[@id='release_info_to_employer_group']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", scroll3);
		Thread.sleep(2000);
		for(int ran:random1)
		{
			getDriver().findElement(By.xpath("(//fieldset[@id='release_info_to_employer_group']//input)["+ran+"]")).click();
		}
		findElement("communityCollege_XPATH").click();
		Thread.sleep(1000);
		List<WebElement> college = getDriver().findElements(By.xpath("//ul[@role='listbox']//li"));
		ArrayList<Integer> randomCollege = getRandomNumber(0, college.size(), 1);
		for(int ran:randomCollege)
		{
			getDriver().findElement(By.xpath("(//ul[@role='listbox']//li)["+ran+"]")).click();	
		}
		//reverse transfer agreement
		List<WebElement> agg = getDriver().findElements(By.xpath("//fieldset[@id='reverse_transfer_group']//input"));
		ArrayList<Integer> randomAgg = getRandomNumber(0, agg.size(), 1);
		for(int ran:randomAgg)
		{
			getDriver().findElement(By.xpath("(//fieldset[@id='reverse_transfer_group']//input)["+ran+"]")).click();	
		}

		//		//clear search
		//		WebElement scroll4 = findElement("search_XPATH");
		//		this.js = (JavascriptExecutor) getDriver();
		//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", scroll4);
		//		findElement("search_XPATH").clear();

	}


	public  void SaveThePage() throws InterruptedException
	{
		// Clicks on Save button
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//button[.=' Save ']")).click();
		Thread.sleep(4000);
	}
}




