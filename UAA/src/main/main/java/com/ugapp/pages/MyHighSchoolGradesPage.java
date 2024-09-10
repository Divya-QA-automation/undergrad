package com.ugapp.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ugapp.base.Page;




public class MyHighSchoolGradesPage extends Page{


	static ThreadLocal<String> courseNameSelected= new ThreadLocal<>();
	static ThreadLocal<String> durationSelected= new ThreadLocal<>();
	static ThreadLocal<String> gradingSystem= new ThreadLocal<>();;
	static ThreadLocal<String> unweightedGpa= new ThreadLocal<>();
	static ThreadLocal<String> gpaScale= new ThreadLocal<>();
	static ThreadLocal<String> classRank= new ThreadLocal<>();
	static ThreadLocal<String> classSize= new ThreadLocal<>();
	static ThreadLocal<String> sub= new ThreadLocal<>();
	static ThreadLocal<String> selectedSubject= new ThreadLocal<>();
	static ThreadLocal<String>	selectedoption = new ThreadLocal<>();
	JavascriptExecutor js = (JavascriptExecutor) getDriver();


	public void NonResidentflow() throws Throwable 
	{
		// Validating for the Students who are Non residents
		Thread.sleep(2000);
		if(findElement("AlertmsgforNonResident_XPATH").isDisplayed())
		{
			log.debug("A proper alert message is displayed for the student who are not a resident of the United States");
		}
		else
		{
			log.debug("Issue with displaying the alert message");
		}
		WebElement elementToScrollTo1 = findElement("ContinueBtn_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		click("ContinueBtn_XPATH");
		waitTillProgressbarDisappears();
	}

	public void Random_FutureOrPastGrad(String colKey,String colValue) throws Throwable
	{
		waitTillProgressbarDisappears();
		Thread.sleep(1000);
		// Future Graduated flow --- Resident  - Default [Self report]
		if(RandomGradYear.get().equals("Future Graduation date"))
		{
			System.out.println("Citizenship : "+Citizenship.get()+"Graduation Year : "+RandomGradYear.get());
			if (Citizenship.get().equals("Not Resident")) 
			{

				log.debug("Selected Graduation flow : Future Graduated flow");
				Thread.sleep(1000);
				WebElement elementToScrollTo2 = findElement("unweightedGPA_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
				// Current un-weighted GPA
				type("unweightedGPA_XPATH","1");
				// GPA Scale
				findElement("gpaScaleDropdown_XPATH").click();
				Thread.sleep(1500);
				List<WebElement> gpaDropdown = getDriver().findElements(By.xpath("(//ul[@role='listbox'])/li"));
				ArrayList<Integer> random1 = getRandomNumber(1, gpaDropdown.size(), 1);
				for(int ran: random1)
				{
					Thread.sleep(1500);
					getDriver().findElement(By.xpath("((//ul[@role='listbox'])/li)["+ran+"]")).click();
				}
				gpaScale.set(getDriver().findElement(By.xpath(" //div[@id='group-gpa-scale']//div[@role='combobox']//span")).getText());
				log.debug("gpaScale :"+gpaScale);
				// Grading system
				WebElement elementToScroll = findElement("gradingSystemDropdown_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
				findElement("gradingSystemDropdown_XPATH").click();
				Thread.sleep(1500);
				List<WebElement> GradingSystemDropdown = getDriver().findElements(By.xpath("(//ul[@role='listbox'])/li"));
				ArrayList<Integer> random11 = getRandomNumber(1, GradingSystemDropdown.size(), 1);
				for(int ran: random11)
				{
					Thread.sleep(1500);
					getDriver().findElement(By.xpath("((//ul[@role='listbox'])/li)["+ran+"]")).click();
				}
				gradingSystem.set(findElement("gradingSystemData_XPATH").getText());
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData", 115, "Unweighted GPA/Scale", "1 / "+MyHighSchoolGradesPage.gpaScale.get());
				setExcelData(colKey,colValue,"validData", 116, "Grading system", MyHighSchoolGradesPage.gradingSystem.get());
				saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");

				// Select a random Subject tab
				WebElement elementToScroll1 = getDriver().findElement(By.xpath("//div[@class='app-tab position-relative ']"));
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
				List<WebElement> subject = getDriver().findElements(By.xpath("//ul[@role='tablist']//a"));
				ArrayList<Integer> random111 = getRandomNumber(1, subject.size(), 1);
				for(int ran :random111)
				{
					Thread.sleep(2000);
					getDriver().findElement(By.xpath("(//ul[@role='tablist']//a)["+ran+"]")).click();
					sub.set(getDriver().findElement(By.xpath("(//ul[@role='tablist']//a)["+ran+"]")).getText());
					log.debug("sub :"+sub);
				}
				// Validate the Academic year DD
				String AcademicYear = findElement("academicYearDropdown_XPATH").getText();
				// Select a Course name
				WebElement elementToScroll21 = findElement("courseNameDropdown_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll21);
				findElement("courseNameDropdown_XPATH").click();
				List<WebElement> dropdownfields = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
				ArrayList<Integer> random21 = getRandomNumber(1, dropdownfields.size(), 1);
				for(int ran:random21)
				{
					getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
				}
				courseNameSelected.set(getDriver().findElement(By.xpath("//div[@id='new_course_name']//span")).getText());
				log.debug("courseNameSelected :"+courseNameSelected.get());
				if(courseNameSelected.get().contains("Other"))
				{
					courseNameSelected.set("OTHER TEST");
					try
					{
						Thread.sleep(1500);
						type("courseTitle_XPATH","OTHER TEST");
					}
					catch(Exception e) {}
				}
				// Select the Duration
				WebElement elementToScroll12 = findElement("durationDropdown_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll12);
				findElement("durationDropdown_XPATH").click();
				List<WebElement> dropdownfields1 = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
				ArrayList<Integer> random13 = getRandomNumber(1, dropdownfields1.size(), 1);
				for(int ran:random13)
				{
					getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
				}
				durationSelected.set(getDriver().findElement(By.xpath("//div[@id='new_select_duration']//span")).getText());
				log.debug("durationSelected :"+durationSelected.get());
				//Select the course level
				WebElement elementToScroll13 = findElement("courseLevelDropdown_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll13);
				findElement("courseLevelDropdown_XPATH").click();
				List<WebElement> dropdownfields12 = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
				ArrayList<Integer> random15 = getRandomNumber(1, dropdownfields12.size(), 1);
				for(int ran:random15)
				{
					getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
				}
				// Grades
				WebElement elementToScroll16 = findElement("grades_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll16);
				//		findElement("grades_XPATH").click();
				Thread.sleep(1000);
				List<WebElement> gradeDropdowns = getDriver().findElements(By.xpath("//div[@data-cy='my-high-school-grades-new-courses-grade-fields']//div[contains(@id,'grades-update')]"));
				int i=1;
				for(WebElement grade:gradeDropdowns)
				{
					getDriver().findElement(By.xpath("(//div[@data-cy='my-high-school-grades-new-courses-grade-fields']//div[contains(@id,'grades-update')])["+i+"]")).click();
					List<WebElement> data = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
					i++;
					ArrayList<Integer> random31 = getRandomNumber(1, data.size(), 1);
					for(int ran:random31)
					{
						getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
					}
				}
				subject(colKey,colValue);
				findElement("saveCourseMy_XPATH").click();
				SaveThePage();

			}



			if (Citizenship.get().equals("Resident")) 
			{
				log.debug("Selected Graduation flow : Future Graduated flow");
				Thread.sleep(1000);
				WebElement elementToScrollTo2 = findElement("unweightedGPA_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
				// Current un-weighted GPA
				type("unweightedGPA_XPATH","1");
				// GPA Scale
				findElement("gpaScaleDropdown_XPATH").click();
				Thread.sleep(1500);
				List<WebElement> gpaDropdown = getDriver().findElements(By.xpath("(//ul[@role='listbox'])/li"));
				ArrayList<Integer> random1 = getRandomNumber(1, gpaDropdown.size(), 1);
				for(int ran: random1)
				{
					Thread.sleep(1500);
					getDriver().findElement(By.xpath("((//ul[@role='listbox'])/li)["+ran+"]")).click();
				}
				gpaScale.set(getDriver().findElement(By.xpath(" //div[@id='group-gpa-scale']//div[@role='combobox']//span")).getText());
				log.debug("gpaScale :"+gpaScale.get());
				// Grading system
				WebElement elementToScroll = findElement("gradingSystemDropdown_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
				findElement("gradingSystemDropdown_XPATH").click();
				Thread.sleep(1500);
				List<WebElement> GradingSystemDropdown = getDriver().findElements(By.xpath("(//ul[@role='listbox'])/li"));
				ArrayList<Integer> random11 = getRandomNumber(1, GradingSystemDropdown.size(), 1);
				for(int ran: random11)
				{
					Thread.sleep(1500);
					getDriver().findElement(By.xpath("((//ul[@role='listbox'])/li)["+ran+"]")).click();
				}
				gradingSystem.set(findElement("gradingSystemData_XPATH").getText());
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData", 115, "Unweighted GPA/Scale", "1 / "+MyHighSchoolGradesPage.gpaScale);
				setExcelData(colKey,colValue,"validData", 116, "Grading system", MyHighSchoolGradesPage.gradingSystem.get());
				saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");

				// Select a random Subject tab
				WebElement elementToScroll1 = getDriver().findElement(By.xpath("//div[@class='app-tab position-relative ']"));
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
				List<WebElement> subject = getDriver().findElements(By.xpath("//ul[@role='tablist']//a"));
				ArrayList<Integer> random111 = getRandomNumber(1, subject.size(), 1);
				for(int ran :random111)
				{
					Thread.sleep(2000);
					getDriver().findElement(By.xpath("(//ul[@role='tablist']//a)["+ran+"]")).click();
					sub.set(getDriver().findElement(By.xpath("(//ul[@role='tablist']//a)["+ran+"]")).getText());
					log.debug("sub :"+sub);
				}
				//Course -- Select an Academic year
				WebElement elementToScroll11 = findElement("academicYearDropdown_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll11);
				findElement("academicYearDropdown_XPATH").click();
				Thread.sleep(1000);
				List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options = options.size();
				Random random1111 = new Random();
				int randomIndex1 = random1111.nextInt(options.size());
				// Click on the random Edit button
				WebElement randomOption = options.get(randomIndex1);
				Thread.sleep(1000);
				randomOption.click();
				Thread.sleep(1000);
				String AcademicYear = findElement("academicYearDropdown_XPATH").getText();
				// Select a Course name
				WebElement elementToScroll21 = findElement("courseNameDropdown_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll21);
				findElement("courseNameDropdown_XPATH").click();
				List<WebElement> dropdownfields = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
				ArrayList<Integer> random21 = getRandomNumber(1, dropdownfields.size(), 1);
				for(int ran:random21)
				{
					getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
				}
				courseNameSelected.set(getDriver().findElement(By.xpath("//div[@id='new_course_name']//span")).getText());
				log.debug("courseNameSelected :"+courseNameSelected.get());
				if(courseNameSelected.get().contains("Other"))
				{
					courseNameSelected.set("OTHER TEST");
					try
					{
						Thread.sleep(1500);
						type("courseTitle_XPATH","OTHER TEST");
					}
					catch(Exception e) {}
				}
				// Select the Duration
				WebElement elementToScroll12 = findElement("durationDropdown_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll12);
				findElement("durationDropdown_XPATH").click();
				List<WebElement> dropdownfields1 = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
				ArrayList<Integer> random13 = getRandomNumber(1, dropdownfields1.size(), 1);
				for(int ran:random13)
				{
					getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
				}
				durationSelected.set(getDriver().findElement(By.xpath("//div[@id='new_select_duration']//span")).getText());
				log.debug("durationSelected :"+durationSelected.get());
				//Select the course level
				WebElement elementToScroll13 = findElement("courseLevelDropdown_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll13);
				findElement("courseLevelDropdown_XPATH").click();
				List<WebElement> dropdownfields12 = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
				ArrayList<Integer> random15 = getRandomNumber(1, dropdownfields12.size(), 1);
				for(int ran:random15)
				{
					getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
				}
				// Grades
				WebElement elementToScroll16 = findElement("grades_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll16);
				//		findElement("grades_XPATH").click();
				Thread.sleep(1000);
				List<WebElement> gradeDropdowns = getDriver().findElements(By.xpath("//div[@data-cy='my-high-school-grades-new-courses-grade-fields']//div[contains(@id,'grades-update')]"));
				int i=1;
				for(WebElement grade:gradeDropdowns)
				{
					getDriver().findElement(By.xpath("(//div[@data-cy='my-high-school-grades-new-courses-grade-fields']//div[contains(@id,'grades-update')])["+i+"]")).click();
					List<WebElement> data = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
					i++;
					ArrayList<Integer> random31 = getRandomNumber(1, data.size(), 1);
					for(int ran:random31)
					{
						getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
					}
				}
				subject(colKey,colValue);
				findElement("saveCourseMy_XPATH").click();
				SaveThePage();
			}
		}



		// Past Graduated flow --- Resident - Optional [Choose Self report OR Transcripts only]
		System.out.println("Citizenship : "+Citizenship.get()+"Graduation Year : "+RandomGradYear.get());
		if(RandomGradYear.get().equals("Past Graduation date"))
		{
			System.out.println("RandomGradYear :"+RandomGradYear.get());
			System.out.println("Selected Graduation flow : Past Graduated flow");
			log.debug("Selected Graduation flow : Past Graduated flow");
			// Page is skipped for Non Resident users----------
			if (Citizenship.get().equals("Not Resident")) 
			{
				Thread.sleep(3000);
				NonResidentflow();
			}
			if (Citizenship.get().equals("Resident")) 
			{
				// Randomly choose either Self report OR Transcripts only-----------
				log.debug("Do you want to self-report your high school grades?");
				Thread.sleep(1000);
				//				List<WebElement> radioButtons = getDriver().findElements(By.xpath("//fieldset[@data-cy='my-high-school-grades-admission-type']//input[@name='base-radio-card']/.."));
				List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='base-radio-card']"));


				int Count = radioButtons.size();
				// Generate a random index
				Random random = new Random();
				int randomIndex = random.nextInt(radioButtons.size());
				// Get the text of the randomly selected radio button
				//				String Selectedoption = radioButtons.get(randomIndex).getAttribute("value");

				Thread.sleep(2000);
				radioButtons.get(randomIndex).click();
				Thread.sleep(2000);
				String Selectedoption = radioButtons.get(randomIndex).getAttribute("value");
				System.out.println("Selectedoption :"+Selectedoption);
				selectedoption.set(Selectedoption);
				System.out.println("Do you want to self-report your high school grades?"+" "+Selectedoption);
				log.debug("Do you want to self-report your high school grades?"+" "+Selectedoption);


				if(Selectedoption.equals("Y"))
				{
					log.debug("Selected Option: " + "Self-report high school grades now");
					Thread.sleep(1000);
					WebElement elementToScrollTo2 = findElement("unweightedGPA_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
					// Current un-weighted GPA
					type("unweightedGPA_XPATH","1");
					// GPA Scale
					findElement("gpaScaleDropdown_XPATH").click();
					Thread.sleep(1500);
					List<WebElement> gpaDropdown = getDriver().findElements(By.xpath("(//ul[@role='listbox'])/li"));
					ArrayList<Integer> random1 = getRandomNumber(1, gpaDropdown.size(), 1);
					for(int ran: random1)
					{
						Thread.sleep(1500);
						getDriver().findElement(By.xpath("((//ul[@role='listbox'])/li)["+ran+"]")).click();
					}
					gpaScale.set(getDriver().findElement(By.xpath(" //div[@id='group-gpa-scale']//div[@role='combobox']//span")).getText());
					log.debug("gpaScale :"+gpaScale.get());
					// Grading system
					WebElement elementToScroll = findElement("gradingSystemDropdown_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
					findElement("gradingSystemDropdown_XPATH").click();
					Thread.sleep(1500);
					List<WebElement> GradingSystemDropdown = getDriver().findElements(By.xpath("(//ul[@role='listbox'])/li"));
					ArrayList<Integer> random11 = getRandomNumber(1, GradingSystemDropdown.size(), 1);
					for(int ran: random11)
					{
						Thread.sleep(1500);
						getDriver().findElement(By.xpath("((//ul[@role='listbox'])/li)["+ran+"]")).click();
					}
					gradingSystem.set(findElement("gradingSystemData_XPATH").getText());
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 115, "Unweighted GPA/Scale", "1 / "+MyHighSchoolGradesPage.gpaScale);
					setExcelData(colKey,colValue,"validData", 116, "Grading system", MyHighSchoolGradesPage.gradingSystem.get());
					saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");

					// Select a random Subject tab
					WebElement elementToScroll1 = getDriver().findElement(By.xpath("//div[@class='app-tab position-relative ']"));
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
					List<WebElement> subject = getDriver().findElements(By.xpath("//ul[@role='tablist']//a"));
					ArrayList<Integer> random111 = getRandomNumber(1, subject.size(), 1);
					for(int ran :random111)
					{
						Thread.sleep(2000);
						getDriver().findElement(By.xpath("(//ul[@role='tablist']//a)["+ran+"]")).click();
						sub.set(getDriver().findElement(By.xpath("(//ul[@role='tablist']//a)["+ran+"]")).getText());
						log.debug("sub :"+sub.get());
					}
					//Course -- Select an Academic year
					WebElement elementToScroll11 = findElement("academicYearDropdown_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll11);
					findElement("academicYearDropdown_XPATH").click();
					Thread.sleep(1000);
					List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
					int Options = options.size();
					Random random1111 = new Random();
					int randomIndex1 = random1111.nextInt(options.size());
					// Click on the random Edit button
					WebElement randomOption = options.get(randomIndex1);
					Thread.sleep(1000);
					randomOption.click();
					Thread.sleep(1000);
					String AcademicYear = findElement("academicYearDropdown_XPATH").getText();
					// Select a Course name
					WebElement elementToScroll21 = findElement("courseNameDropdown_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll21);
					findElement("courseNameDropdown_XPATH").click();
					List<WebElement> dropdownfields = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
					ArrayList<Integer> random21 = getRandomNumber(1, dropdownfields.size(), 1);
					for(int ran:random21)
					{
						getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
					}
					courseNameSelected.set(getDriver().findElement(By.xpath("//div[@id='new_course_name']//span")).getText());
					log.debug("courseNameSelected :"+courseNameSelected.get());
					if(courseNameSelected.get().contains("Other"))
					{
						courseNameSelected.set("OTHER TEST");
						try
						{
							Thread.sleep(1500);
							type("courseTitle_XPATH","OTHER TEST");
						}
						catch(Exception e) {}
					}
					// Select the Duration
					WebElement elementToScroll12 = findElement("durationDropdown_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll12);
					findElement("durationDropdown_XPATH").click();
					List<WebElement> dropdownfields1 = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
					ArrayList<Integer> random13 = getRandomNumber(1, dropdownfields1.size(), 1);
					for(int ran:random13)
					{
						getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
					}
					durationSelected.set(getDriver().findElement(By.xpath("//div[@id='new_select_duration']//span")).getText());
					log.debug("durationSelected :"+durationSelected.get());
					//Select the course level
					WebElement elementToScroll13 = findElement("courseLevelDropdown_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll13);
					findElement("courseLevelDropdown_XPATH").click();
					List<WebElement> dropdownfields12 = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
					ArrayList<Integer> random15 = getRandomNumber(1, dropdownfields12.size(), 1);
					for(int ran:random15)
					{
						getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
					}
					// Grades
					WebElement elementToScroll16 = findElement("grades_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll16);
					//		findElement("grades_XPATH").click();
					Thread.sleep(1000);
					List<WebElement> gradeDropdowns = getDriver().findElements(By.xpath("//div[@data-cy='my-high-school-grades-new-courses-grade-fields']//div[contains(@id,'grades-update')]"));
					int i=1;
					for(WebElement grade:gradeDropdowns)
					{
						getDriver().findElement(By.xpath("(//div[@data-cy='my-high-school-grades-new-courses-grade-fields']//div[contains(@id,'grades-update')])["+i+"]")).click();
						List<WebElement> data = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
						i++;
						ArrayList<Integer> random31 = getRandomNumber(1, data.size(), 1);
						for(int ran:random31)
						{
							getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
						}
					}
					subject(colKey,colValue);
					findElement("saveCourseMy_XPATH").click();
					SaveThePage();

				}
				if(selectedoption.get().equals("N"))
				{
					log.debug("Selected Option: " + "Transcripts only");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 114, "Self-reported", "N");
					saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
					SaveThePage();
				}


			}
		}

	}






	public  void selectSelfReportCard() throws Throwable
	{
		waitTillProgressbarDisappears();
		try
		{
			WebElement elementToScrollTo1 = getDriver().findElement(By.xpath("//*[text()=' Self-report high school grades now ']/../../.."));
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);


			if(getDriver().findElement(By.xpath("//*[text()=' Self-report high school grades now ']/../../..")).isDisplayed())
			{
				getDriver().findElement(By.xpath("//*[text()=' Self-report high school grades now ']/../../..")).click();
			}
		}
		catch(Exception e) {}
	}
	public  void selectTranscriptOnlyCard(String colKey,String colValue) throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(1000);
		try
		{
			WebElement elementToScrollTo1 = getDriver().findElement(By.xpath("//*[text()=' Transcripts only ']/../../.."));
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);


			if(getDriver().findElement(By.xpath("//*[text()=' Transcripts only ']/../../..")).isDisplayed())
			{
				getDriver().findElement(By.xpath("//*[text()=' Transcripts only ']/../../..")).click();
				Thread.sleep(1000);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData", 114, "Self-reported", "N");
				saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}
		}
		catch(Exception e) {}
	}
	public  void validateMyHighSchoolGrade() throws Throwable
	{
		waitTillProgressbarDisappears();
		WebElement elementToScrollTo1 = findElement("MyHighSchoolGradeTitle_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		String PageTitle	= findElement("MyHighSchoolGradeTitle_XPATH").getText();
		log.debug("Page title :"+" "+PageTitle);
	}





	public  void scroll()
	{
		WebElement elementToScroll =getDriver().findElement(By.xpath("//label[text()=' Grading system ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
	}


	public  void errorMessage()
	{


		try
		{
			findElement("SaveBtn_XPATH").click() ;

			//unweightedGPA error message
			if(findElement("errorunweightedGPA_XPATH").isDisplayed())
			{
				log.debug("The error message for unweighted GPA section is displayed");
			}
		}
		catch(Exception e)
		{
			log.debug("The error message for unweighted GPA section is not displayed");
		}








		//GPA scale
		try
		{
			if(findElement("errorGpaScale_XPATH").isDisplayed())
			{
				log.debug("The error message for GPA Scale section is displayed");
			}
		}
		catch(Exception e)
		{
			log.debug("The error message for GPA Scale section is not displayed");
		}








		//grading system
		try
		{
			if(findElement("errorGradingSystem_XPATH").isDisplayed())
			{
				log.debug("The error message for grading system section is displayed");
			}
		}
		catch(Exception e)
		{
			log.debug("The error message for grading system section is not displayed");
		}
	}


	public  void academicDetails(String unweightedGPA , String classrank , String classSize) throws Throwable
	{
		Thread.sleep(1000);
		WebElement elementToScrollTo2 = findElement("unweightedGPA_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		type("unweightedGPA_XPATH",unweightedGPA);
		type("ClassRank_XPATH",classrank);
		type("ClassSize_XPATH",classSize);
	}


	public  void validateAcademicDetails(String unweightedGPA , String classrank , String classSize)
	{		
		//unweightedGPA error message
		boolean containsOnlyCharacters = unweightedGPA.matches("[a-zA-Z]+");
		if (containsOnlyCharacters) {
			try
			{
				if(findElement("UnweightedErrMsg_XPATH").isDisplayed())
				{
					log.debug("The error message is displayed for unweighted GPA section when only characters are entered!");
					findElement("unweightedGPA_XPATH").clear();
					log.debug("Unweighted GPA field cleared");
				}
			}
			catch(Exception e)
			{
				log.debug("The error message is not displayed for unweighted GPA section when only characters are entered!");
			}

		}
		else if(unweightedGPA.length()>6)
		{
			try
			{
				if(findElement("UnweightedErrMsg_XPATH").isDisplayed())
				{
					log.debug("The error message is displayed for unweighted GPA section when 6+ characters are entered!");
					findElement("unweightedGPA_XPATH").clear();
					log.debug("Unweighted GPA field cleared");
				}
			}
			catch(Exception e)
			{
				log.debug("The error message is not displayed for unweighted GPA section when 6+ characters are entered!");
			}	

		}



		//class rank 
		boolean containsCharacters = classrank.matches("[a-zA-Z]+");
		if (containsCharacters) {
			try
			{
				if(findElement("errorOnlyNumbers_XPATH").isDisplayed())
				{
					log.debug("The error message is displayed for class rank section when only characters are entered!");
					findElement("ClassRank_XPATH").clear();
					log.debug("UClass rank field cleared");
				}
			}
			catch(Exception e)
			{
				log.debug("The error message is not displayed for class rank section when only characters are entered!");
			}

		}
		else if(classrank.length() > 4)
		{
			try
			{
				if(findElement("error4char_XPATH").isDisplayed())
				{
					log.debug("The error message is displayed for class rank section when 4+ characters are entered!");
					findElement("ClassRank_XPATH").clear();
					log.debug("Class rank field cleared");
				}
			}
			catch(Exception e)
			{
				log.debug("The error message is not displayed for class rank section when 4+ characters are entered!");
			}

		}
		else if(classrank.equals("0"))
		{
			try
			{
				if(findElement("errorMin1_XPATH").isDisplayed())
				{
					log.debug("The error message is displayed for class rank section when 0 is entered!");
					findElement("ClassRank_XPATH").clear();
					log.debug("Class rank field cleared");
				}
			}
			catch(Exception e)
			{
				log.debug("The error message is not displayed for class rank section when 0 is entered!");
			}

		}












		//class size
		boolean containsCharacters1 = classSize.matches("[a-zA-Z]+");
		if (containsCharacters1) {
			try
			{
				if(findElement("errorOnlyNumbers_XPATH").isDisplayed())
				{
					log.debug("The error message is displayed for class size section when only characters are entered!");
				}
			}
			catch(Exception e)
			{
				log.debug("The error message is not displayed for class size section when only characters are entered!");
			}
			findElement("ClassSize_XPATH").clear();
		}
		else if(classSize.length() > 4)
		{
			try
			{
				if(findElement("error4char_XPATH").isDisplayed())
				{
					log.debug("The error message is displayed for class size section when 4+ characters are entered!");
				}
			}
			catch(Exception e)
			{
				log.debug("The error message is not displayed for class size section when 4+ characters are entered!");
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
					log.debug("The error message is displayed for class size section when classrank is greater than class size!");
				}
			}
			catch(Exception e)
			{
				log.debug("The error message is not displayed for class size section when classrank is greater than class size!");
			}
			findElement("ClassRank_XPATH").clear();
			findElement("ClassSize_XPATH").clear();
		}




	}


	public  void gpaScaleDropdown(String colKey,String colValue) throws Throwable
	{
		//gpascale dropdown
		findElement("gpaScaleDropdown_XPATH").click();
		Thread.sleep(1500);




		List<WebElement> gpaDropdown = getDriver().findElements(By.xpath("(//ul[@role='listbox'])/li"));
		ArrayList<Integer> random = getRandomNumber(1, gpaDropdown.size(), 1);
		for(int ran: random)
		{
			Thread.sleep(1500);
			getDriver().findElement(By.xpath("((//ul[@role='listbox'])/li)["+ran+"]")).click();
		}


		gpaScale.set(getDriver().findElement(By.xpath(" //div[@id='group-gpa-scale']//div[@role='combobox']//span")).getText());
		log.debug("gpaScale :"+gpaScale);


		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 114, "Self-reported", "Y");
		saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");


	}


	public  void gradingSystemDropdown(String colKey,String colValue) throws Throwable
	{
		//get valid data 
		unweightedGpa.set(findElement("unweightedGPA_XPATH").getText());
		log.debug("unweightedGpa :"+unweightedGpa);
		classRank.set(findElement("ClassRank_XPATH").getText());
		classSize.set(findElement("ClassSize_XPATH").getText());
		//grading system 
		WebElement elementToScroll = findElement("gradingSystemDropdown_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
		findElement("gradingSystemDropdown_XPATH").click();
		Thread.sleep(1500);
		List<WebElement> gpaDropdown = getDriver().findElements(By.xpath("(//ul[@role='listbox'])/li"));
		ArrayList<Integer> random = getRandomNumber(1, gpaDropdown.size(), 1);
		for(int ran: random)
		{
			Thread.sleep(1500);
			getDriver().findElement(By.xpath("((//ul[@role='listbox'])/li)["+ran+"]")).click();
		}

		gradingSystem.set(findElement("gradingSystemData_XPATH").getText());
		log.debug("gradingSystem :"+gradingSystem);
		log.debug("classRank :"+classRank);
		log.debug("classSize :"+classSize);
		initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		setExcelData(colKey,colValue,"validData", 115, "Unweighted GPA/Scale", "111 / "+MyHighSchoolGradesPage.gpaScale.get());
		setExcelData(colKey,colValue,"validData", 116, "Class rank/Class size", "11 / 111");
		setExcelData(colKey,colValue,"validData", 117, "Grading system", MyHighSchoolGradesPage.gradingSystem.get());
		saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
	}


	public  void errorText()
	{
		try
		{
			WebElement elementToScroll = findElement("errorAtleastOneCourse_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);




			if(findElement("errorAtleastOneCourse_XPATH").isDisplayed())
			{
				log.debug("The error message is displayed when course is not selected!");
			}
		}
		catch(Exception e)
		{
			log.debug("The error message is not displayed when course is not selected!");
		}
	}


	public  void subjectTabs() throws Throwable
	{


		WebElement elementToScroll = getDriver().findElement(By.xpath("//div[@class='app-tab position-relative ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);


		List<WebElement> subject = getDriver().findElements(By.xpath("//ul[@role='tablist']//a"));


		ArrayList<Integer> random = getRandomNumber(1, subject.size(), 1);
		for(int ran :random)
		{
			Thread.sleep(2000);
			getDriver().findElement(By.xpath("(//ul[@role='tablist']//a)["+ran+"]")).click();
			sub.set(getDriver().findElement(By.xpath("(//ul[@role='tablist']//a)["+ran+"]")).getText());
			log.debug("sub :"+sub);
		}
	}


	public  void academicYear() throws Throwable
	{
		WebElement elementToScroll = findElement("academicYearDropdown_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
		findElement("academicYearDropdown_XPATH").click();
		Thread.sleep(2000);
		findElement("senior12_XPATH").click();
	}


	public  void courseName() throws Throwable
	{
		WebElement elementToScroll = findElement("courseNameDropdown_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
		findElement("courseNameDropdown_XPATH").click();
		List<WebElement> dropdownfields = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
		ArrayList<Integer> random = getRandomNumber(1, dropdownfields.size(), 1);
		for(int ran:random)
		{
			getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
		}
		courseNameSelected.set(getDriver().findElement(By.xpath("//div[@id='new_course_name']//span")).getText());
		log.debug("courseNameSelected :"+courseNameSelected);
		if(courseNameSelected.get().contains("Other"))
		{
			courseNameSelected.set("OTHER TEST");
			try
			{
				Thread.sleep(1500);
				type("courseTitle_XPATH","OTHER TEST");
			}
			catch(Exception e) {}
		}
	}


	public  void duration()
	{
		WebElement elementToScroll = findElement("durationDropdown_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
		findElement("durationDropdown_XPATH").click();
		List<WebElement> dropdownfields = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
		ArrayList<Integer> random = getRandomNumber(1, dropdownfields.size(), 1);
		for(int ran:random)
		{
			getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
		}
		durationSelected.set(getDriver().findElement(By.xpath("//div[@id='new_select_duration']//span")).getText());
		log.debug("durationSelected :"+durationSelected);
	}


	public  void courseLevel()
	{
		WebElement elementToScroll = findElement("courseLevelDropdown_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
		findElement("courseLevelDropdown_XPATH").click();
		List<WebElement> dropdownfields = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
		ArrayList<Integer> random = getRandomNumber(1, dropdownfields.size(), 1);
		for(int ran:random)
		{
			getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
		}
	}


	public  void grades()
	{
		if(durationSelected.get().equalsIgnoreCase("Semester"))
		{
			List<WebElement> grades = getDriver().findElements(By.xpath("//div[@data-cy='grade-fields']/div"));
			if(grades.size()==2)
			{
				log.debug("Two grade dropdowns are displayed when Semester is selected from duration dropdown!");
			}
			else
			{
				log.debug("Two grade dropdowns are not displayed when Semester is selected from duration dropdown!");
			}




		}
		else if(durationSelected.get().equalsIgnoreCase("Trimester"))
		{
			List<WebElement> grades = getDriver().findElements(By.xpath("//div[@data-cy='grade-fields']/div"));
			if(grades.size()==3)
			{
				log.debug("Three grade dropdowns are displayed when Trimester is selected from duration dropdown!");
			}
			else
			{
				log.debug("Three grade dropdowns are not displayed when Trimester is selected from duration dropdown!");
			}
		}
		else if(durationSelected.get().equalsIgnoreCase("Quarterly"))
		{
			List<WebElement> grades = getDriver().findElements(By.xpath("//div[@data-cy='grade-fields']/div"));
			if(grades.size()==4)
			{
				log.debug("Four grade dropdowns are displayed when Quarterly is selected from duration dropdown!");
			}
			else
			{
				log.debug("Four grade dropdowns are not displayed when Quarterly is selected from duration dropdown!");
			}
		}
		else if(durationSelected.get().equalsIgnoreCase("Full Year"))
		{
			List<WebElement> grades = getDriver().findElements(By.xpath("//div[@data-cy='grade-fields']/div"));
			if(grades.size()==1)
			{
				log.debug("One grade dropdowns are displayed when Full Year is selected from duration dropdown!");
			}
			else
			{
				log.debug("One grade dropdowns are not displayed when Full Year is selected from duration dropdown!");
			}
		}
	}


	public  void validateGradingSystem() throws Throwable
	{




		if(gradingSystem.get().equalsIgnoreCase("A-F"))
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




			List<WebElement> grades = getDriver().findElements(By.xpath("//div[@data-cy='grade-fields']/div"));
			ArrayList<Integer> random = getRandomNumber(1, grades.size(), 1);




			for(int ran:random)
			{
				getDriver().findElement(By.xpath("(//div[@data-cy='grade-fields']//div[contains(@id,'grades-update')])["+ran+"]")).click();
			}




			ArrayList<String> ls=new ArrayList<>();
			List<WebElement> data = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
			int i=1;
			for(WebElement field:data)
			{
				Thread.sleep(1000);
				String text=getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+i+"]")).getText();
				i++;
				ls.add(text);




			}
			if(ls.equals(ls1))
			{
				log.debug("The dropdown displays point based data when 100 point based option is selected!");
			}
			else
			{
				log.debug("The dropdown does not display point based data when 100 point based option is selected!");
			}
		}
		else if(gradingSystem.get().equalsIgnoreCase("100 point based"))
		{	
			ArrayList<String> ls1=new ArrayList<>();
			ls1.add("In Progress");
			ls1.add("Pass");
			ls1.add("100-90");
			ls1.add("89-80");
			ls1.add("79-70");
			ls1.add("69-60");
			ls1.add("59 or lower");




			List<WebElement> grades = getDriver().findElements(By.xpath("//div[@data-cy='grade-fields']/div"));
			ArrayList<Integer> random = getRandomNumber(1, grades.size(), 1);




			for(int ran:random)
			{
				getDriver().findElement(By.xpath("(//div[@data-cy='grade-fields']//div[contains(@id,'grades-update')])["+ran+"]")).click();
			}




			ArrayList<String> ls=new ArrayList<>();
			List<WebElement> data = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
			int i=1;
			for(WebElement field:data)
			{
				Thread.sleep(1000);
				String text=getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+i+"]")).getText();
				i++;
				ls.add(text);
			}
			if(ls.equals(ls1))
			{
				log.debug("The dropdown displays A-F based data when A-F option is selected!");
			}
			else
			{
				log.debug("The dropdown does not display A-F based data when A-F option is selected!");
			}
		}
	}


	public  void selectGrades(String colKey,String colValue) throws Exception
	{
		WebElement elementToScroll = findElement("grades_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
		//		findElement("grades_XPATH").click();
		Thread.sleep(1000);



		List<WebElement> gradeDropdowns = getDriver().findElements(By.xpath("//div[@data-cy='my-high-school-grades-new-courses-grade-fields']//div[contains(@id,'grades-update')]"));
		int i=1;
		for(WebElement grade:gradeDropdowns)
		{
			getDriver().findElement(By.xpath("(//div[@data-cy='my-high-school-grades-new-courses-grade-fields']//div[contains(@id,'grades-update')])["+i+"]")).click();
			List<WebElement> data = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
			i++;
			ArrayList<Integer> random = getRandomNumber(1, data.size(), 1);
			for(int ran:random)
			{
				getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
			}
		}
		subject(colKey,colValue);
		findElement("saveCourseMy_XPATH").click();
	}


	// This method writes the data to excel sheet [Subject]
	public  void  subject(String colKey,String colValue) throws Exception
	{
		if(MyHighSchoolGradesPage.sub.get().equalsIgnoreCase("English"))
		{
			eng.set(MyHighSchoolGradesPage.courseNameSelected.get());
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 118, "English", eng.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		else
		{
			eng.set("No data has been entered");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 118, "English", eng.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		if(MyHighSchoolGradesPage.sub.get().equalsIgnoreCase("Math"))
		{
			math.set(MyHighSchoolGradesPage.courseNameSelected.get());
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 119, "Math", math.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		else
		{
			math.set("No data has been entered");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 119, "Math", math.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		if(MyHighSchoolGradesPage.sub.get().equalsIgnoreCase("Science"))
		{
			sci.set(MyHighSchoolGradesPage.courseNameSelected.get());
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 120, "Science", sci.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		else
		{
			sci.set("No data has been entered");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 120, "Science", sci.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		if(MyHighSchoolGradesPage.sub.get().equalsIgnoreCase("Social Science"))
		{
			soc.set(MyHighSchoolGradesPage.courseNameSelected.get());
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 121, "Social Science", soc.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		else
		{
			soc.set("No data has been entered");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 121, "Social Science", soc.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		if(MyHighSchoolGradesPage.sub.get().equalsIgnoreCase("Language"))
		{
			lang.set(MyHighSchoolGradesPage.courseNameSelected.get());
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 122, "Language", lang.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		else
		{
			lang.set("No data has been entered");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 122, "Language", lang.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		if(MyHighSchoolGradesPage.sub.get().equalsIgnoreCase("Fine Arts/CTE"))
		{
			arts.set(MyHighSchoolGradesPage.courseNameSelected.get());
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 123, "Fine Arts/CTE", arts.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		else
		{
			arts.set("No data has been entered");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 123, "Fine Arts/CTE", arts.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		if(MyHighSchoolGradesPage.sub.get().equalsIgnoreCase("Electives"))
		{
			ele.set(MyHighSchoolGradesPage.courseNameSelected.get());
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 124, "Electives", ele.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		else
		{
			ele.set("No data has been entered");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 124, "Electives", ele.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
	}


	public  void validateCoursetitle() throws Throwable
	{
		Thread.sleep(1000);
		selectedSubject.set(getDriver().findElement(By.xpath("(//table//td)[1]")).getText());
		if(courseNameSelected.get().equals(selectedSubject.get()))
		{
			log.debug("The selected course is displayed under subject and course field!");
		}
		else
		{
			log.debug("The selected course is not displayed under subject and course field!");
		}


	}
	public  void SaveThePage() throws InterruptedException
	{
		// Clicks on Save button
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//button[.=' Save ']")).click();
		Thread.sleep(3000);
	}

	public void RandomSelfReportSeniorYrOrAllHSgrades(String colKey,String colValue) throws Throwable
	{
		waitTillProgressbarDisappears();
		Thread.sleep(1000);
		WebElement elementToScrollTo2 = getDriver().findElement(By.xpath("(//input[@name='base-radio-card'])[1]"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		System.out.println("Choose a Self-report grades ");
		log.debug("Choose a Self-report grades ");
		List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='base-radio-card']/.."));
		int Count = radioButtons.size();
		Random random = new Random();
		int randomIndex = random.nextInt(radioButtons.size());
//		String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
		Thread.sleep(500);
		radioButtons.get(randomIndex).click();
		Thread.sleep(500);
		
		 String selectedOption = findElement("SelfreportcardTitle_XPATH").getText();
		log.debug("selectedOption :"+selectedOption);
		
		if(selectedOption.contains("Self-report all high school grades"))
		{
			log.debug("Selected option: " + "Self-report all high school grades");
			WebElement elementToScrollTo21 = findElement("unweightedGPA_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
			// Current un-weighted GPA
			type("unweightedGPA_XPATH","1");
			// GPA Scale
			findElement("gpaScaleDropdown_XPATH").click();
			Thread.sleep(1500);
			List<WebElement> gpaDropdown = getDriver().findElements(By.xpath("(//ul[@role='listbox'])/li"));
			ArrayList<Integer> random1 = getRandomNumber(1, gpaDropdown.size(), 1);
			for(int ran: random1)
			{
				Thread.sleep(1500);
				getDriver().findElement(By.xpath("((//ul[@role='listbox'])/li)["+ran+"]")).click();
			}
			gpaScale.set(getDriver().findElement(By.xpath(" //div[@id='group-gpa-scale']//div[@role='combobox']//span")).getText());
			log.debug("gpaScale :"+gpaScale);
			// Grading system
			WebElement elementToScroll = findElement("gradingSystemDropdown_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
			findElement("gradingSystemDropdown_XPATH").click();
			Thread.sleep(1500);
			List<WebElement> GradingSystemDropdown = getDriver().findElements(By.xpath("(//ul[@role='listbox'])/li"));
			ArrayList<Integer> random11 = getRandomNumber(1, GradingSystemDropdown.size(), 1);
			for(int ran: random11)
			{
				Thread.sleep(1500);
				getDriver().findElement(By.xpath("((//ul[@role='listbox'])/li)["+ran+"]")).click();
			}
			gradingSystem.set(findElement("gradingSystemData_XPATH").getText());
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 115, "Unweighted GPA/Scale", "1 / "+MyHighSchoolGradesPage.gpaScale.get());
			setExcelData(colKey,colValue,"validData", 116, "Grading system", MyHighSchoolGradesPage.gradingSystem.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");

			// Select a random Subject tab
			WebElement elementToScroll1 = getDriver().findElement(By.xpath("//div[@class='app-tab position-relative ']"));
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
			List<WebElement> subject = getDriver().findElements(By.xpath("//ul[@role='tablist']//a"));
			ArrayList<Integer> random111 = getRandomNumber(1, subject.size(), 1);
			for(int ran :random111)
			{
				Thread.sleep(2000);
				getDriver().findElement(By.xpath("(//ul[@role='tablist']//a)["+ran+"]")).click();
				sub.set(getDriver().findElement(By.xpath("(//ul[@role='tablist']//a)["+ran+"]")).getText());
				log.debug("sub :"+sub);
			}
			// Validate the Academic year DD -- Not senior year - Choose a Senior year - FGD flow
			WebElement elementToScroll11 = findElement("academicYearDropdown_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll11);
			findElement("academicYearDropdown_XPATH").click();
			findElement("senior12_XPATH").click();
			String AcademicYear = findElement("academicYearDropdown_XPATH").getText();
			log.debug("Selected Academic year : "+AcademicYear);
			
			// Select a Course name
			WebElement elementToScroll21 = findElement("courseNameDropdown_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll21);
			findElement("courseNameDropdown_XPATH").click();
			List<WebElement> dropdownfields = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
			ArrayList<Integer> random21 = getRandomNumber(1, dropdownfields.size(), 1);
			for(int ran:random21)
			{
				getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
			}
			courseNameSelected.set(getDriver().findElement(By.xpath("//div[@id='new_course_name']//span")).getText());
			log.debug("courseNameSelected :"+courseNameSelected.get());
			if(courseNameSelected.get().contains("Other"))
			{
				courseNameSelected.set("OTHER TEST");
				try
				{
					Thread.sleep(1500);
					type("courseTitle_XPATH","OTHER TEST");
				}
				catch(Exception e) {}
			}
			// Select the Duration
			WebElement elementToScroll12 = findElement("durationDropdown_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll12);
			findElement("durationDropdown_XPATH").click();
			List<WebElement> dropdownfields1 = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
			ArrayList<Integer> random13 = getRandomNumber(1, dropdownfields1.size(), 1);
			for(int ran:random13)
			{
				getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
			}
			durationSelected.set(getDriver().findElement(By.xpath("//div[@id='new_select_duration']//span")).getText());
			log.debug("durationSelected :"+durationSelected.get());
			//Select the course level
			WebElement elementToScroll13 = findElement("courseLevelDropdown_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll13);
			findElement("courseLevelDropdown_XPATH").click();
			List<WebElement> dropdownfields12 = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
			ArrayList<Integer> random15 = getRandomNumber(1, dropdownfields12.size(), 1);
			for(int ran:random15)
			{
				getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
			}
			// Grades
			WebElement elementToScroll16 = findElement("grades_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll16);
			//		findElement("grades_XPATH").click();
			Thread.sleep(1000);
			List<WebElement> gradeDropdowns = getDriver().findElements(By.xpath("//div[@data-cy='my-high-school-grades-new-courses-grade-fields']//div[contains(@id,'grades-update')]"));
			int i=1;
			for(WebElement grade:gradeDropdowns)
			{
				getDriver().findElement(By.xpath("(//div[@data-cy='my-high-school-grades-new-courses-grade-fields']//div[contains(@id,'grades-update')])["+i+"]")).click();
				List<WebElement> data = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
				i++;
				ArrayList<Integer> random31 = getRandomNumber(1, data.size(), 1);
				for(int ran:random31)
				{
					getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
				}
			}
			subject(colKey,colValue);
			findElement("saveCourseMy_XPATH").click();
			//			SaveThePage();


		}
		if(selectedOption.contains("Self-report senior year grades only")) 
		{
			log.debug("Selected option: " + "Self-report senior year grades only");
			WebElement elementToScrollTo21 = findElement("unweightedGPA_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
			// Current un-weighted GPA
			type("unweightedGPA_XPATH","1");
			// GPA Scale
			findElement("gpaScaleDropdown_XPATH").click();
			Thread.sleep(1500);
			List<WebElement> gpaDropdown = getDriver().findElements(By.xpath("(//ul[@role='listbox'])/li"));
			ArrayList<Integer> random1 = getRandomNumber(1, gpaDropdown.size(), 1);
			for(int ran: random1)
			{
				Thread.sleep(1500);
				getDriver().findElement(By.xpath("((//ul[@role='listbox'])/li)["+ran+"]")).click();
			}
			gpaScale.set(getDriver().findElement(By.xpath(" //div[@id='group-gpa-scale']//div[@role='combobox']//span")).getText());
			log.debug("gpaScale :"+gpaScale);
			// Grading system
			WebElement elementToScroll = findElement("gradingSystemDropdown_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
			findElement("gradingSystemDropdown_XPATH").click();
			Thread.sleep(1500);
			List<WebElement> GradingSystemDropdown = getDriver().findElements(By.xpath("(//ul[@role='listbox'])/li"));
			ArrayList<Integer> random11 = getRandomNumber(1, GradingSystemDropdown.size(), 1);
			for(int ran: random11)
			{
				Thread.sleep(1500);
				getDriver().findElement(By.xpath("((//ul[@role='listbox'])/li)["+ran+"]")).click();
			}
			gradingSystem.set(findElement("gradingSystemData_XPATH").getText());
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData", 115, "Unweighted GPA/Scale", "1 / "+MyHighSchoolGradesPage.gpaScale.get());
			setExcelData(colKey,colValue,"validData", 116, "Grading system", MyHighSchoolGradesPage.gradingSystem.get());
			saveReport(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");

			// Select a random Subject tab
			WebElement elementToScroll1 = getDriver().findElement(By.xpath("//div[@class='app-tab position-relative ']"));
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
			List<WebElement> subject = getDriver().findElements(By.xpath("//ul[@role='tablist']//a"));
			ArrayList<Integer> random111 = getRandomNumber(1, subject.size(), 1);
			for(int ran :random111)
			{
				Thread.sleep(2000);
				getDriver().findElement(By.xpath("(//ul[@role='tablist']//a)["+ran+"]")).click();
				sub.set(getDriver().findElement(By.xpath("(//ul[@role='tablist']//a)["+ran+"]")).getText());
				log.debug("sub :"+sub);
			}
			// Validate the Academic year DD
			String AcademicYear = findElement("academicYearDropdown_XPATH").getText();
			// Select a Course name
			WebElement elementToScroll21 = findElement("courseNameDropdown_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll21);
			findElement("courseNameDropdown_XPATH").click();
			List<WebElement> dropdownfields = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
			ArrayList<Integer> random21 = getRandomNumber(1, dropdownfields.size(), 1);
			for(int ran:random21)
			{
				getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
			}
			courseNameSelected.set(getDriver().findElement(By.xpath("//div[@id='new_course_name']//span")).getText());
			log.debug("courseNameSelected :"+courseNameSelected.get());
			if(courseNameSelected.get().contains("Other"))
			{
				courseNameSelected.set("OTHER TEST");
				try
				{
					Thread.sleep(1500);
					type("courseTitle_XPATH","OTHER TEST");
				}
				catch(Exception e) {}
			}
			// Select the Duration
			WebElement elementToScroll12 = findElement("durationDropdown_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll12);
			findElement("durationDropdown_XPATH").click();
			List<WebElement> dropdownfields1 = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
			ArrayList<Integer> random13 = getRandomNumber(1, dropdownfields1.size(), 1);
			for(int ran:random13)
			{
				getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
			}
			durationSelected.set(getDriver().findElement(By.xpath("//div[@id='new_select_duration']//span")).getText());
			log.debug("durationSelected :"+durationSelected.get());
			//Select the course level
			WebElement elementToScroll13 = findElement("courseLevelDropdown_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll13);
			findElement("courseLevelDropdown_XPATH").click();
			List<WebElement> dropdownfields12 = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
			ArrayList<Integer> random15 = getRandomNumber(1, dropdownfields12.size(), 1);
			for(int ran:random15)
			{
				getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
			}
			// Grades
			WebElement elementToScroll16 = findElement("grades_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll16);
			//		findElement("grades_XPATH").click();
			Thread.sleep(1000);
			List<WebElement> gradeDropdowns = getDriver().findElements(By.xpath("//div[@data-cy='my-high-school-grades-new-courses-grade-fields']//div[contains(@id,'grades-update')]"));
			int i=1;
			for(WebElement grade:gradeDropdowns)
			{
				getDriver().findElement(By.xpath("(//div[@data-cy='my-high-school-grades-new-courses-grade-fields']//div[contains(@id,'grades-update')])["+i+"]")).click();
				List<WebElement> data = getDriver().findElements(By.xpath("//ul[@role='listbox']/li"));
				i++;
				ArrayList<Integer> random31 = getRandomNumber(1, data.size(), 1);
				for(int ran:random31)
				{
					getDriver().findElement(By.xpath("(//ul[@role='listbox']/li)["+ran+"]")).click();
				}
			}
			
			subject(colKey,colValue);
			findElement("saveCourseMy_XPATH").click();
			//			SaveThePage();
		}

	}


}












