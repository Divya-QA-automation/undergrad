package com.ugapp.pages;


import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import com.ugapp.base.Page;


public class MyASUProgramPage extends Page{

	static String selectedProgram1="";
	static JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	static String validFirstChoice="";
	static String validFirstLocation="";
	static String validFirstStartingTerm="";
	static String validSecondChoice="";
	static String validSecondLocation="";
	static String validSecondStartingTerm="";
	static ArrayList<String> CA = new ArrayList<>();
	static String option1="";
	static String option2="";
	static String option3="";
	static String option4="";



	public static void validateMyProgram() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(3000);
		WebElement elementToScrollTo1 = findElement("MyProgramTitle_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		String PageTitle	= findElement("MyProgramTitle_XPATH").getText();
		log.debug("Page title :"+" "+PageTitle);
	}




	public static void errorMessage()
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

	public static void calender() throws Throwable
	{
		findElement("calender_XPATH").click();
		Thread.sleep(2000);
	}

	public static void validateCalender()
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

	public static void interestArea() throws Throwable
	{
		WebElement elementToScroll =findElement("interestAreaDropdown_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		Thread.sleep(1500);
		findElement("interestAreaDropdown_XPATH").click();	


		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		ArrayList<Integer> random = getRandomNumber(1, checkbox.size(), 4);


		ArrayList<String> ls=new ArrayList<>();
		for(int ran:random)
		{
			String checkedInterestAreas=driver.findElement(By.xpath("(//div[@id='interest_area_select']//ul//input/following-sibling::label)["+ran+"]")).getText();
			WebElement elementToScrollTo = driver.findElement(By.xpath("(//div[@id='interest_area_select']//ul//input/following-sibling::label)["+ran+"]"));
			ls.add(checkedInterestAreas);
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@id='interest_area_select']//ul//input/..)["+ran+"]")).click();
			Thread.sleep(1500);
		}




		//close the checkbox
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		findElement("interestAreaDropdown_XPATH").click();	




		//check for the selected interest areas
		ArrayList<String> ls1=new ArrayList<>();
		List<WebElement> selectedInterestAreas = driver.findElements(By.xpath("//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-interest-button']"));
		int i=1;
		for(WebElement sel:selectedInterestAreas)
		{
			String selectedAreas=driver.findElement(By.xpath("(//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-interest-button'])["+i+"]")).getText();
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

	public static void college() throws Throwable
	{
		Thread.sleep(1500);
		WebElement elementToScroll =findElement("collegeDropdown_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		findElement("collegeDropdown_XPATH").click();	






		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		ArrayList<Integer> random = getRandomNumber(1, checkbox.size(), 3);


		ArrayList<String> ls=new ArrayList<>();
		for(int ran:random)
		{
			String checkedInterestAreas=driver.findElement(By.xpath("(//div[@id='college_filter_select']//ul//input/following-sibling::label)["+ran+"]")).getText();
			WebElement elementToScrollTo = driver.findElement(By.xpath("(//div[@id='college_filter_select']//ul//input/following-sibling::label)["+ran+"]"));
			ls.add(checkedInterestAreas);
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@id='college_filter_select']//ul//input/..)["+ran+"]")).click();
			Thread.sleep(1000);
		}




		//close the checkbox
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		findElement("collegeDropdown_XPATH").click();	




		//check for the selected interest areas
		ArrayList<String> ls1=new ArrayList<>();
		List<WebElement> selectedCollege = driver.findElements(By.xpath("//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-college-button']"));
		int i=1;
		for(WebElement sel:selectedCollege)
		{
			String selectedAreas=driver.findElement(By.xpath("(//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-college-button'])["+i+"]")).getText();
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
		Thread.sleep(3000);

		//fetch the placeholder of college
		String placeholderCollege = findElement("placeholderCollege_XPATH").getText();
		String digit1 = placeholderCollege.replaceAll("[^0-9]", "");
		Thread.sleep(3000);


		//fetch the placeholder of clearallfilter
		String placeholderClear = findElement("placeholderClearAll_XPATH").getText();
		String digit2 = placeholderClear.replaceAll("[^0-9]", "");
		Thread.sleep(1000);


		// Convert the extracted digit to an integer
		int interest = Integer.parseInt(digit);
		int college = Integer.parseInt(digit1);
		int clearall = Integer.parseInt(digit2);


		int sum=interest+college;


		List<WebElement> finalList = driver.findElements(By.xpath("(//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-college-button'])  | (//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-interest-button'])"));


		if(clearall==finalList.size() && clearall==sum)
		{
			log.debug("The ClearAll placeholder displays the right number of options selected!");
		}
		else
			log.debug("The ClearAll placeholder is not displaying the right number of options selected!");
	}

	public static void checkSelectedOptions() throws Throwable
	{
		Thread.sleep(1500);
		List<WebElement> selectedOptions = driver.findElements(By.xpath("(//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-college-button'])  | (//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-interest-button'])"));
		ArrayList<Integer> random = getRandomNumber(1, selectedOptions.size(), 1);


		ArrayList<String> ls=new ArrayList<>();
		for(int ran:random)
		{
			driver.findElement(By.xpath("((//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-college-button'])  | (//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-interest-button']))["+ran+"]")).click();
			Thread.sleep(1000);
		}


		//fetch the placeholder of clearallfilter
		String placeholderClear = findElement("placeholderClearAll_XPATH").getText();
		String digit2 = placeholderClear.replaceAll("[^0-9]", "");
		int clearall = Integer.parseInt(digit2);
		List<WebElement> selectedOptions1 = driver.findElements(By.xpath("(//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-college-button'])  | (//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-interest-button'])"));
		if(selectedOptions1.size()==clearall)
		{
			log.debug("The selected options were cleared successfully!");
		}
		else
			log.debug("The selected options were not cleared!");


	}

	public static void clearAll()
	{
		findElement("clearAllFilter_XPATH").click();

	}

	public static void chooseThisProgram() throws Throwable
	{
		Thread.sleep(2000);
		List<WebElement> programs = driver.findElements(By.xpath("//button[text()=' Choose this program ']"));
		ArrayList<Integer> random = getRandomNumber(1, programs.size(), 1);


		for(int ran:random)
		{
			Thread.sleep(1000);
			WebElement elementToScrollTo = driver.findElement(By.xpath("(//button[text()=' Choose this program '])["+ran+"]"));
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			selectedProgram1=driver.findElement(By.xpath("(//button[text()=' Choose this program ']/../..//span)["+ran+"]")).getText();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[text()=' Choose this program ']/preceding-sibling::a)["+ran+"]")).click();
			waitTillLoaderDisappears();
			Thread.sleep(2000);
			String selectedProgram2 = driver.findElement(By.xpath("//div[@id='programs_details_sidebar']//h2")).getText();
			log.debug("selectedProgram1 :"+selectedProgram1);
			log.debug("selectedProgram2 :"+selectedProgram2);
			if(selectedProgram1.equalsIgnoreCase(selectedProgram2))
				log.debug("View details link works as expected!");
			else
				log.debug("View Details link does not work");
			driver.findElement(By.xpath("//div[@id='programs_details_sidebar']//span[text()='Back']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[text()=' Choose this program '])["+ran+"]")).click();
			waitTillLoaderDisappears();
		}
	}

	public static void chooseSession() throws Throwable
	{
		Thread.sleep(1000);
		List<WebElement> programs = driver.findElements(By.xpath("//fieldset[@id='group_program_select_date']//div//input"));
		ArrayList<Integer> random = getRandomNumber(1, programs.size(), 1);


		for(int ran:random)
		{

			driver.findElement(By.xpath("(//div[@id='program_select_date']//div)["+ran+"]")).click();
			waitTillLoaderDisappears();
			Thread.sleep(1000);

		}


		findElement("chooseProgramNext_XPATH").click();
		Thread.sleep(1000);
		findElement("chooseProgramSaveChoice_XPATH").click();
	}

	public static void highRequirementMajor() throws Throwable
	{
		Thread.sleep(2500);
		try
		{
			if(findElement("alert_XPATH").isDisplayed())
			{
				chooseThisProgram();
				Thread.sleep(1000);
				List<WebElement> programs = driver.findElements(By.xpath("//fieldset[@id='group_program_select_date']//div//input[not(@disabled)]"));
				ArrayList<Integer> random = getRandomNumber(1, programs.size(), 1);


				for(int ran:random)
				{

					driver.findElement(By.xpath("(//fieldset[@id='group_program_select_date']//div//input[not(@disabled)]/..)["+ran+"]")).click();
					waitTillLoaderDisappears();

				}


				findElement("chooseProgramNext_XPATH").click();
				findElement("chooseProgramSaveChoice_XPATH").click();
			}
		}
		catch(Exception e)
		{
		}
	}

	public static void careerAdvising() throws Throwable
	{
		Thread.sleep(1000);
		List<WebElement> career = driver.findElements(By.xpath("//div[@id='interested_in_anything_checkbox_group']//div"));
		ArrayList<Integer> random = getRandomNumber(1, career.size(), 2);


		for(int ran:random)
		{
			WebElement elementToScroll =driver.findElement(By.xpath("(//div[@id='interested_in_anything_checkbox_group']//label)["+ran+"]"));
			jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
			driver.findElement(By.xpath("(//div[@id='interested_in_anything_checkbox_group']//label)["+ran+"]")).click();
			String text=driver.findElement(By.xpath("(//div[@id='interested_in_anything_checkbox_group']//label/span)["+ran+"]")).getText();


			if(text.equalsIgnoreCase("Pre-law"))
			{
				option1 = "Pre-law interest";
				CA.add(option1);
			}
			if(text.equalsIgnoreCase("Pre-med or pre-health*"))
			{
				option2 = "Pre-med/health interest";
				CA.add(option2);
			}
			if(text.equalsIgnoreCase("Pre-veterinary"))
			{
				option3 = "Pre-veterinary interest";
				CA.add(option3);
			}
			if(text.equalsIgnoreCase("Future opportunities to earn a teaching certificate in the field of your major"))
			{
				option4 = "Teaching certificate interest";
				CA.add(option4);
			}

		}


		Thread.sleep(1000);

		log.debug("Checked carreer advising :"+CA);
		career();
		validData();

		driver.findElement(By.xpath("(//button[text()=' Save '])[1]")).click();
		waitTillLoaderDisappears();
		Thread.sleep(1000);
	}

	//to get yes or no for careeer advising from My asu program page 2
	public static void career() throws Exception
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
			op1="Yes";
		else
			op1="No";
		if(ls3.contains("Pre-med/health interest"))
			op2="Yes";
		else
			op2="No";
		if(ls3.contains("Pre-veterinary interest"))
			op3="Yes";
		else
			op3="No";
		if(ls3.contains("Teaching certificate interest"))
			op4="Yes";
		else
			op4="No";

		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData("validData", 38, "Pre-law interest", op1);
		setExcelData("validData", 39, "Pre-med/health interest", op2);
		setExcelData("validData", 40, "Pre-veterinary interest", op3);
		setExcelData("validData", 41, "Teaching certificate interest", op4);
		saveReport();
	}

	public static void validData() throws Throwable, Throwable
	{
		//firstChoice
		validFirstChoice =driver.findElement(By.xpath("(//div[@*='my-programs-selected-program']//h3)[2]")).getText();
		validFirstLocation=driver.findElement(By.xpath("(//div[@*='my-programs-selected-program']//p)[2]")).getText();
		validFirstStartingTerm=driver.findElement(By.xpath("(//div[@*='my-programs-selected-program']//p)[1]")).getText();;
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData("validData", 32, "First choice", validFirstChoice);
		setExcelData("validData", 33, "Location", validFirstLocation);
		setExcelData("validData", 34, "Starting term", validFirstStartingTerm);
		saveReport();


		//secondChoice
		try
		{
			validSecondChoice =driver.findElement(By.xpath("(//div[@*='my-programs-selected-program']//h3)[4]")).getText();;
			validSecondLocation=driver.findElement(By.xpath("(//div[@*='my-programs-selected-program']//p)[3]")).getText();;
			validSecondStartingTerm=driver.findElement(By.xpath("(//div[@*='my-programs-selected-program']//p)[4]")).getText();;
			initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData", 35, "Second choice", validSecondChoice);
			setExcelData("validData", 36, "Location", validSecondLocation);
			setExcelData("validData", 37, "Starting term", validSecondStartingTerm);
			saveReport();

		}
		catch(Exception e)
		{}
		log.debug("----------------------------------------------------");
	}

}

