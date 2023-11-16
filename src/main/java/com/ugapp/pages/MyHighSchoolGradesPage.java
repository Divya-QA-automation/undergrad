package com.ugapp.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import com.ugapp.base.Page;


public class MyHighSchoolGradesPage extends Page{

	static String courseNameSelected="";
	static String durationSelected="";
	static String gradingSystem="";
	static String unweightedGpa="";
	static String gpaScale="";
	static String classRank="";
	static String classSize="";
	static String sub="";
	static String selectedSubject="";
	static JavascriptExecutor js = (JavascriptExecutor) driver;


	public static void selectCard() throws Throwable
	{
		waitTillLoaderDisappears();
		try
		{
			if(driver.findElement(By.xpath("//*[text()=' Self-report high school grades now ']/../../..")).isDisplayed())
			{
				driver.findElement(By.xpath("//*[text()=' Self-report high school grades now ']/../../..")).click();
			}
		}
		catch(Exception e) {}
	}

	public static void validateMyHighSchoolGrade() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(3000);
		WebElement elementToScrollTo1 = findElement("MyHighSchoolGradeTitle_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		String PageTitle	= findElement("MyHighSchoolGradeTitle_XPATH").getText();
		log.debug("Page title :"+" "+PageTitle);
	}






	public static void scroll()
	{
		WebElement elementToScroll =driver.findElement(By.xpath("//label[text()=' Grading system ']"));
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
	}

	public static void errorMessage()
	{
		
		try
		{
			findElement("MyHighSchoolGradeContinue_XPATH").click();




			//unweightedGPA error message
			if(findElement("errorunweightedGPA_XPATH").isDisplayed())
			{
				System.out.println("The error message for unweighted GPA section is displayed");
			}
		}
		catch(Exception e)
		{
			System.out.println("The error message for unweighted GPA section is not displayed");
		}




		//GPA scale
		try
		{
			if(findElement("errorGpaScale_XPATH").isDisplayed())
			{
				System.out.println("The error message for GPA Scale section is displayed");
			}
		}
		catch(Exception e)
		{
			System.out.println("The error message for GPA Scale section is not displayed");
		}




		//grading system
		try
		{
			if(findElement("errorGradingSystem_XPATH").isDisplayed())
			{
				System.out.println("The error message for grading system section is displayed");
			}
		}
		catch(Exception e)
		{
			System.out.println("The error message for grading system section is not displayed");
		}
	}

	public static void academicDetails(String unweightedGPA , String classrank , String classSize) throws Throwable
	{
		Thread.sleep(1000);
		type("unweightedGPA_XPATH",unweightedGPA);
		type("ClassRank_XPATH",classrank);
		type("ClassSize_XPATH",classSize);
	}

	public static void validateAcademicDetails(String unweightedGPA , String classrank , String classSize)
	{		
		//unweightedGPA error message
		boolean containsOnlyCharacters = unweightedGPA.matches("[a-zA-Z]+");
		if (containsOnlyCharacters) {
			try
			{
				if(findElement("errorwholeNumber_XPATH").isDisplayed())
				{
					System.out.println("The error message is displayed for unweighted GPA section when only characters are entered!");
				}
			}
			catch(Exception e)
			{
				System.out.println("The error message is not displayed for unweighted GPA section when only characters are entered!");
			}
			findElement("unweightedGPA_XPATH").clear();
		}
		else if(unweightedGPA.length()>6)
		{
			try
			{
				if(findElement("error6char_XPATH").isDisplayed())
				{
					System.out.println("The error message is displayed for unweighted GPA section when 6+ characters are entered!");
				}
			}
			catch(Exception e)
			{
				System.out.println("The error message is not displayed for unweighted GPA section when 6+ characters are entered!");
			}	
			findElement("unweightedGPA_XPATH").clear();
		}








		//class rank 
		boolean containsCharacters = classrank.matches("[a-zA-Z]+");
		if (containsCharacters) {
			try
			{
				if(findElement("errorOnlyNumbers_XPATH").isDisplayed())
				{
					System.out.println("The error message is displayed for class rank section when only characters are entered!");
				}
			}
			catch(Exception e)
			{
				System.out.println("The error message is not displayed for class rank section when only characters are entered!");
			}
			findElement("ClassRank_XPATH").clear();
		}
		else if(classrank.length() > 4)
		{
			try
			{
				if(findElement("error4char_XPATH").isDisplayed())
				{
					System.out.println("The error message is displayed for class rank section when 4+ characters are entered!");
				}
			}
			catch(Exception e)
			{
				System.out.println("The error message is not displayed for class rank section when 4+ characters are entered!");
			}
			findElement("ClassRank_XPATH").clear();
		}
		else if(classrank.equals("0"))
		{
			try
			{
				if(findElement("errorMin1_XPATH").isDisplayed())
				{
					System.out.println("The error message is displayed for class rank section when 0 is entered!");
				}
			}
			catch(Exception e)
			{
				System.out.println("The error message is not displayed for class rank section when 0 is entered!");
			}
			findElement("ClassRank_XPATH").clear();
		}






		//class size
		boolean containsCharacters1 = classSize.matches("[a-zA-Z]+");
		if (containsCharacters1) {
			try
			{
				if(findElement("errorOnlyNumbers_XPATH").isDisplayed())
				{
					System.out.println("The error message is displayed for class size section when only characters are entered!");
				}
			}
			catch(Exception e)
			{
				System.out.println("The error message is not displayed for class size section when only characters are entered!");
			}
			findElement("ClassSize_XPATH").clear();
		}
		else if(classSize.length() > 4)
		{
			try
			{
				if(findElement("error4char_XPATH").isDisplayed())
				{
					System.out.println("The error message is displayed for class size section when 4+ characters are entered!");
				}
			}
			catch(Exception e)
			{
				System.out.println("The error message is not displayed for class size section when 4+ characters are entered!");
			}	
			findElement("ClassSize_XPATH").clear();
		}




		//valid class size
		if(classrank.length() > classSize.length())
		{
			try
			{
				if(findElement("errorValidClassSize_XPATH").isDisplayed())
				{
					System.out.println("The error message is displayed for class size section when classrank is greater than class size!");
				}
			}
			catch(Exception e)
			{
				System.out.println("The error message is not displayed for class size section when classrank is greater than class size!");
			}
			findElement("ClassRank_XPATH").clear();
			findElement("ClassSize_XPATH").clear();
		}


	}

	public static void gpaScaleDropdown() throws Throwable
	{
		//gpascale dropdown
		findElement("gpaScaleDropdown_XPATH").click();
		Thread.sleep(1500);


		List<WebElement> gpaDropdown = driver.findElements(By.xpath("(//ul[@role='listbox'])/li"));
		ArrayList<Integer> random = getRandomNumber(1, gpaDropdown.size(), 1);
		for(int ran: random)
		{
			Thread.sleep(1500);
			driver.findElement(By.xpath("((//ul[@role='listbox'])/li)["+ran+"]")).click();
		}

		gpaScale = driver.findElement(By.xpath(" //div[@id='group-gpa-scale']//div[@role='combobox']//span")).getText();
		System.out.println("gpaScale :"+gpaScale);

		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData("validData", 112, "Self-reported", "Y");
		saveReport();

	}

	public static void gradingSystemDropdown() throws Throwable
	{

		//get valid data 
		unweightedGpa=findElement("unweightedGPA_XPATH").getText();
		System.out.println("unweightedGpa :"+unweightedGpa);


		classRank=findElement("ClassRank_XPATH").getText();
		classSize=findElement("ClassSize_XPATH").getText();





		//grading system 
		WebElement elementToScroll = findElement("gradingSystemDropdown_XPATH");
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);


		findElement("gradingSystemDropdown_XPATH").click();


		Thread.sleep(1500);
		List<WebElement> gpaDropdown = driver.findElements(By.xpath("(//ul[@role='listbox'])/li"));
		ArrayList<Integer> random = getRandomNumber(1, gpaDropdown.size(), 1);
		for(int ran: random)
		{
			Thread.sleep(1500);
			driver.findElement(By.xpath("((//ul[@role='listbox'])/li)["+ran+"]")).click();
		}


		gradingSystem = findElement("gradingSystemData_XPATH").getText();
		System.out.println("gradingSystem :"+gradingSystem);
		System.out.println("classRank :"+classRank);
		System.out.println("classSize :"+classSize);
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData("validData", 113, "Unweighted GPA/Scale", "111 / "+MyHighSchoolGradesPage.gpaScale);
		setExcelData("validData", 114, "Class rank/Class size", "11 / 111");
		setExcelData("validData", 115, "Grading system", MyHighSchoolGradesPage.gradingSystem);
		saveReport();
	}

	public static void errorText()
	{
		try
		{
			WebElement elementToScroll = findElement("errorAtleastOneCourse_XPATH");
			js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);


			if(findElement("errorAtleastOneCourse_XPATH").isDisplayed())
			{
				System.out.println("The error message is displayed when course is not selected!");
			}
		}
		catch(Exception e)
		{
			System.out.println("The error message is not displayed when course is not selected!");
		}
	}

	public static void subjectTabs() throws Throwable
	{

		WebElement elementToScroll = driver.findElement(By.xpath("//div[@class='app-tab position-relative ']"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);

		List<WebElement> subject = driver.findElements(By.xpath("//ul[@role='tablist']//a"));

		ArrayList<Integer> random = getRandomNumber(1, subject.size(), 1);
		for(int ran :random)
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//ul[@role='tablist']//a)["+ran+"]")).click();
			sub=driver.findElement(By.xpath("(//ul[@role='tablist']//a)["+ran+"]")).getText();
			System.out.println("sub :"+sub);
		}
	}

	public static void academicYear() throws Throwable
	{
		WebElement elementToScroll = findElement("academicYearDropdown_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);




		findElement("academicYearDropdown_XPATH").click();
		Thread.sleep(1000);


		findElement("senior12_XPATH").click();


	}

	public static void courseName() throws Throwable
	{
		WebElement elementToScroll = findElement("courseNameDropdown_XPATH");
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);


		findElement("courseNameDropdown_XPATH").click();


		List<WebElement> dropdownfields = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		ArrayList<Integer> random = getRandomNumber(1, dropdownfields.size(), 1);
		for(int ran:random)
		{
			driver.findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
		}
		courseNameSelected=driver.findElement(By.xpath("//div[@id='new_course_name']//span")).getText();
		System.out.println("courseNameSelected :"+courseNameSelected);
		if(courseNameSelected.contains("Other"))
		{
			try
			{
				Thread.sleep(1500);
				type("courseTitle_XPATH","OTHER TEST");
			}
			catch(Exception e) {}
		}


	}

	public static void duration()
	{
		WebElement elementToScroll = findElement("courseNameDropdown_XPATH");
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);


		findElement("durationDropdown_XPATH").click();
		List<WebElement> dropdownfields = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		ArrayList<Integer> random = getRandomNumber(1, dropdownfields.size(), 1);
		for(int ran:random)
		{
			driver.findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
		}
		durationSelected=driver.findElement(By.xpath("//div[@id='new_select_duration']//span")).getText();
		System.out.println("durationSelected :"+durationSelected);
	}

	public static void courseLevel()
	{
		WebElement elementToScroll = findElement("courseLevelDropdown_XPATH");
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);


		findElement("courseLevelDropdown_XPATH").click();
		List<WebElement> dropdownfields = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		ArrayList<Integer> random = getRandomNumber(1, dropdownfields.size(), 1);
		for(int ran:random)
		{
			driver.findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
		}
	}

	public static void grades()
	{
		if(durationSelected.equalsIgnoreCase("Semester"))
		{
			List<WebElement> grades = driver.findElements(By.xpath("//div[@data-cy='grade-fields']/div"));
			if(grades.size()==2)
			{
				System.out.println("Two grade dropdowns are displayed when Semester is selected from duration dropdown!");
			}
			else
			{
				System.out.println("Two grade dropdowns are not displayed when Semester is selected from duration dropdown!");
			}


		}
		else if(durationSelected.equalsIgnoreCase("Trimester"))
		{
			List<WebElement> grades = driver.findElements(By.xpath("//div[@data-cy='grade-fields']/div"));
			if(grades.size()==3)
			{
				System.out.println("Three grade dropdowns are displayed when Trimester is selected from duration dropdown!");
			}
			else
			{
				System.out.println("Three grade dropdowns are not displayed when Trimester is selected from duration dropdown!");
			}
		}
		else if(durationSelected.equalsIgnoreCase("Quarterly"))
		{
			List<WebElement> grades = driver.findElements(By.xpath("//div[@data-cy='grade-fields']/div"));
			if(grades.size()==4)
			{
				System.out.println("Four grade dropdowns are displayed when Quarterly is selected from duration dropdown!");
			}
			else
			{
				System.out.println("Four grade dropdowns are not displayed when Quarterly is selected from duration dropdown!");
			}
		}
		else if(durationSelected.equalsIgnoreCase("Full Year"))
		{
			List<WebElement> grades = driver.findElements(By.xpath("//div[@data-cy='grade-fields']/div"));
			if(grades.size()==1)
			{
				System.out.println("One grade dropdowns are displayed when Full Year is selected from duration dropdown!");
			}
			else
			{
				System.out.println("One grade dropdowns are not displayed when Full Year is selected from duration dropdown!");
			}
		}
	}

	public static void validateGradingSystem() throws Throwable
	{


		if(gradingSystem.equalsIgnoreCase("A-F"))
		{
			ArrayList<String> ls1=new ArrayList<>();
			ls1.add("A");
			ls1.add("B");
			ls1.add("C");
			ls1.add("D");
			ls1.add("E");
			ls1.add("F");
			ls1.add("In Progress");
			ls1.add("Pass");
			System.out.println("ls1 :"+ls1);


			List<WebElement> grades = driver.findElements(By.xpath("//div[@data-cy='grade-fields']/div"));
			ArrayList<Integer> random = getRandomNumber(1, grades.size(), 1);


			for(int ran:random)
			{
				driver.findElement(By.xpath("(//div[@data-cy='grade-fields']//div[contains(@id,'grades-update')])["+ran+"]")).click();
			}


			ArrayList<String> ls=new ArrayList<>();
			List<WebElement> data = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
			int i=1;
			for(WebElement field:data)
			{
				Thread.sleep(1000);
				String text=driver.findElement(By.xpath("(//ul[@role='listbox']/li)["+i+"]")).getText();
				i++;
				ls.add(text);


			}
			System.out.println("ls A_F :"+ls);
			if(ls.equals(ls1))
			{
				System.out.println("The dropdown displays point based data when 100 point based option is selected!");
			}
			else
			{
				System.out.println("The dropdown does not display point based data when 100 point based option is selected!");
			}
		}
		else if(gradingSystem.equalsIgnoreCase("100 point based"))
		{	
			ArrayList<String> ls1=new ArrayList<>();
			ls1.add("In Progress");
			ls1.add("Pass");
			ls1.add("100-90");
			ls1.add("89-80");
			ls1.add("79-70");
			ls1.add("69-60");
			ls1.add("59 or lower");
			System.out.println("ls1 :"+ls1);


			List<WebElement> grades = driver.findElements(By.xpath("//div[@data-cy='grade-fields']/div"));
			ArrayList<Integer> random = getRandomNumber(1, grades.size(), 1);


			for(int ran:random)
			{
				driver.findElement(By.xpath("(//div[@data-cy='grade-fields']//div[contains(@id,'grades-update')])["+ran+"]")).click();
			}


			ArrayList<String> ls=new ArrayList<>();
			List<WebElement> data = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
			int i=1;
			for(WebElement field:data)
			{
				Thread.sleep(1000);
				String text=driver.findElement(By.xpath("(//ul[@role='listbox']/li)["+i+"]")).getText();
				i++;
				ls.add(text);
			}
			System.out.println("ls 100 point based:"+ls);
			if(ls.equals(ls1))
			{
				System.out.println("The dropdown displays A-F based data when A-F option is selected!");
			}
			else
			{
				System.out.println("The dropdown does not display A-F based data when A-F option is selected!");
			}
		}
	}

	public static void selectGrades() throws Exception
	{
		findElement("grades_XPATH").click();


		List<WebElement> gradeDropdowns = driver.findElements(By.xpath("//div[@data-cy='grade-fields']//div[contains(@id,'grades-update')]"));
		int i=1;
		for(WebElement grade:gradeDropdowns)
		{
			driver.findElement(By.xpath("(//div[@data-cy='grade-fields']//div[contains(@id,'grades-update')])["+i+"]")).click();
			List<WebElement> data = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
			i++;
			ArrayList<Integer> random = getRandomNumber(1, data.size(), 1);
			for(int ran:random)
			{
				driver.findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
			}
		}
		subject();
		findElement("saveCourseMy_XPATH").click();
	}

	//to get the subject selected from My high school grades page 4
	public static void  subject() throws Exception
	{
		if(MyHighSchoolGradesPage.sub.equalsIgnoreCase("English"))
		{
			eng=MyHighSchoolGradesPage.selectedSubject;
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData", 116, "English", eng);
			saveReport();
		}
		else
		{
			eng="No data has been entered";
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData", 116, "English", eng);
			saveReport();
		}

		if(MyHighSchoolGradesPage.sub.equalsIgnoreCase("Math"))
		{
			math=MyHighSchoolGradesPage.selectedSubject;
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData", 117, "Math", math);
			saveReport();
		}
		else
		{
			math="No data has been entered";
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData", 117, "Math", math);
			saveReport();
		}

		if(MyHighSchoolGradesPage.sub.equalsIgnoreCase("Science"))
		{
			sci=MyHighSchoolGradesPage.selectedSubject;
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData", 118, "Science", sci);
			saveReport();
		}
		else
		{
			sci="No data has been entered";
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData", 118, "Science", sci);
			saveReport();
		}

		if(MyHighSchoolGradesPage.sub.equalsIgnoreCase("Social Science"))
		{
			soc=MyHighSchoolGradesPage.selectedSubject;
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData", 119, "Social Science", soc);
			saveReport();
		}
		else
		{
			soc="No data has been entered";
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData", 119, "Social Science", soc);
			saveReport();
		}

		if(MyHighSchoolGradesPage.sub.equalsIgnoreCase("Language"))
		{
			lang=MyHighSchoolGradesPage.selectedSubject;
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData", 120, "Language", lang);
			saveReport();
		}
		else
		{
			lang="No data has been entered";
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData", 120, "Language", lang);
			saveReport();
		}

		if(MyHighSchoolGradesPage.sub.equalsIgnoreCase("Fine Arts/CTE"))
		{
			arts=MyHighSchoolGradesPage.selectedSubject;
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData", 121, "Fine Arts/CTE", arts);
			saveReport();
		}
		else
		{
			arts="No data has been entered";
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData", 121, "Fine Arts/CTE", arts);
			saveReport();
		}

		if(MyHighSchoolGradesPage.sub.equalsIgnoreCase("Electives"))
		{
			ele=MyHighSchoolGradesPage.selectedSubject;
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData", 122, "Electives", ele);
			saveReport();
		}
		else
		{
			ele="No data has been entered";
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("validData", 122, "Electives", ele);
			saveReport();
		}
	}

	public static void validateCoursetitle() throws Throwable
	{
		Thread.sleep(1000);
		selectedSubject =driver.findElement(By.xpath("(//table//td)[1]")).getText();
		if(courseNameSelected.equals(selectedSubject))
		{
			System.out.println("The selected course is displayed under subject and course field!");
		}
		else
		{
			System.out.println("The selected course is not displayed under subject and course field!");
		}

		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
	}

}




