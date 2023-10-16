package com.ugapp.pages;


import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import com.ugapp.base.Page;


public class MyASUProgramPage extends Page{


	static JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;


	public static void validateMyProgram() throws Throwable
	{
		waitTillLoaderDisappears();
		try
		{
			findElement("MyProgramTitle_XPATH");
			System.out.println("Redirected to MyAsuProgram page !");
		}
		catch(Exception e)
		{
			System.out.println("Not redirected to MyAsuProgram Page");
		}
	}






	public static void errorMessage()
	{
		findElement("continue_XPATH").click();
		try
		{
			String error=findElement("continueError_XPATH").getText();
			System.out.println("The error message : "+error+ " pops up when clicked on continue without filling the form!");
		}
		catch(Exception e)
		{
			System.out.println("The error message does not pop up when clicked on continue without filling the form!");
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
			System.out.println("Acedemic calender section is displayed when clicked on academic calender link!");
			findElement("calenderBack_XPATH").click();
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println("Acedemic calender section is not displayed when clicked on academic calender link!");
		}
	}




	public static void interestArea() throws Throwable
	{
		WebElement elementToScroll =findElement("interestAreaDropdown_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
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
		System.out.println("ls :"+ls);




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
		System.out.println("ls1 :"+ls1);


		//validate if checked areas is same as selected areas
		if(ls.equals(ls1))
		{
			System.out.println("The selected Interested Areas from the dropdown is displayed in the UI!");
		}
		else
			System.out.println("The selected Interested Areas from the dropdown is not displayed in the UI!");




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
			System.out.println("The InterestArea and ClearAll placeholder displays the right number of InterestArea options selected!");
		}
		else
			System.out.println("The InterestArea and ClearAll placeholder is not displaying the right number of InterestArea options selected!");


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
		System.out.println("ls :"+ls);




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
		System.out.println("ls1 :"+ls1);


		//validate if checked areas is same as selected areas
		if(ls.equals(ls1))
		{
			System.out.println("The selected College from the dropdown is displayed in the UI!");
		}
		else
			System.out.println("The selected College from the dropdown is not displayed in the UI!");




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


		List<WebElement> finalList = driver.findElements(By.xpath("(//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-college-button'])  | (//div[@data-cy='my-programs-filters-clear-all-button']/button[@data-cy='my-programs-filters-clear-selected-interest-button'])"));


		if(clearall==finalList.size() && clearall==sum)
		{
			System.out.println("The ClearAll placeholder displays the right number of options selected!");
		}
		else
			System.out.println("The ClearAll placeholder is not displaying the right number of options selected!");
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
			System.out.println("The selected options were cleared successfully!");
		}
		else
			System.out.println("The selected options were not cleared!");


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
			String selectedProgram1=driver.findElement(By.xpath("(//button[text()=' Choose this program ']/../..//span)["+ran+"]")).getText();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[text()=' Choose this program ']/preceding-sibling::a)["+ran+"]")).click();
			waitTillLoaderDisappears();
			Thread.sleep(2000);
			String selectedProgram2=driver.findElement(By.xpath("//div[@id='programs_details_sidebar']//h2")).getText();
			System.out.println("selectedProgram1 :"+selectedProgram1);
			System.out.println("selectedProgram2 :"+selectedProgram2);
			if(selectedProgram1.equalsIgnoreCase(selectedProgram2))
				System.out.println("View details link works as expected!");
			else
				System.out.println("View Details link does not work");
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
				System.out.println("inside try");
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
			System.out.println("inside catch");
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
			Thread.sleep(1000);
		}
		
		driver.findElement(By.xpath("(//button[text()=' Save '])[1]")).click();
		waitTillLoaderDisappears();
		Thread.sleep(1000);
	}
}




