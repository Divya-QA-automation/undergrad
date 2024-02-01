package com.ugapp.pages;




import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ugapp.base.Page;




public class ReviewPage extends Page
{
	MyInformationPage MyInfo = new MyInformationPage();
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	static int row = 0;
	//validate  reached review page
	public  void validateReview() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(6000);
		try
		{
			if(findElement("reviewText_XPATH").isDisplayed())
			{
				log.debug("Redirected to Review Page");
			}
		}
		catch(Exception e)
		{
			log.debug("Not redirected to Review Page");
		}
	}


	//to compare the two excel sheets that is all valid data and data in review page
	public  void compare()
	{
		// Specify the file paths and sheet names for both Excel sheets
		String filePath1 = System.getProperty("user.dir") + "/src/test/resources/com/ugapp/excel/testdata.xlsx";
		String sheetName1 = "validData";
		String filePath2 = System.getProperty("user.dir") + "/src/test/resources/com/ugapp/excel/testdata.xlsx";
		String sheetName2 = "ReviewPageData";


		compareExcelSheets(filePath1, sheetName1, filePath2, sheetName2);
	}

	public  void compareValidAndReview(String colKey,String colValue) throws IOException
	{
		int colkey = Integer.parseInt(colKey);
		int colvalue = Integer.parseInt(colValue);
		String excelPath = System.getProperty("user.dir") + "/src/test/resources/com/ugapp/excel/testdata.xlsx";
		String sheet1Name = "validData";
		String sheet2Name = "ReviewPageData";
		int totalRuns = 1;  

		//      CompareExcelSheets(excelPath, sheet1Name, sheet2Name, colKey, colValue);
		CompareAndWriteMismatches(excelPath, sheet1Name, sheet2Name, colkey, colvalue, totalRuns);

	}




	public  void profileSection(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo11 = getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[1]"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[1]")).click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> profile = getDriver().findElements(By.xpath("//div[@id='my-profile-page-contents']//p"));
		for(WebElement text:profile)
		{
			String details = text.getText();
			list1.add(details);
		}
		for(int i=0,j=1;i<list1.size()-1;)
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"ReviewPageData", row++, list1.get(i), list1.get(j));
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			i=i+2;
			j=i+1;
		}
		getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[1]")).click();
		Thread.sleep(1000);
	}








	public  void myInfoSection(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo11 = getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[2]"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[2]")).click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> myInfo = getDriver().findElements(By.xpath("//div[@id='my-information-page-contents']//p"));
		for(WebElement text:myInfo)
		{
			String details = text.getText();
			list1.add(details);
		}
		for(int i=0,j=1;i<list1.size()-1;)
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"ReviewPageData", row++, list1.get(i), list1.get(j));
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			i=i+2;
			j=i+1;
		}
		getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[2]")).click();
		Thread.sleep(1000);
	}








	public  void myProgramSection(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo11 = getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[3]"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[3]")).click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> myProgram = getDriver().findElements(By.xpath("//div[@id='my-programs-page-contents']//p"));
		for(WebElement text:myProgram)
		{
			String details = text.getText();
			list1.add(details);
		}
		for(int i=0,j=1;i<list1.size()-1;)
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"ReviewPageData", row++, list1.get(i), list1.get(j));
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			i=i+2;
			j=i+1;
		}
		getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[3]")).click();
		Thread.sleep(1000);
	}








	public  void mySchoolsSection(String colKey,String colValue) throws Exception
	{
		WebElement elementToScrollTo11 = getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[4]"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);




		getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[4]")).click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> mySchools = getDriver().findElements(By.xpath("//div[@id='my-schools-page-contents']//p"));
		for(WebElement text:mySchools)
		{
			String details = text.getText();
			list1.add(details);
		}
		for(int i=0,j=1;i<list1.size()-1;)
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"ReviewPageData", row++, list1.get(i), list1.get(j));
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			i=i+2;
			j=i+1;
		}
		getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[4]")).click();
		Thread.sleep(1000);
	}








	public  void myHighSchoolGradesSection(String colKey,String colValue) throws Exception
	{
		try {
			WebElement elementToScrollTo11 = getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[5]"));
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);


			getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[5]")).click();
			Thread.sleep(1000);
			ArrayList<String> list1 = new ArrayList<>();
			List<WebElement> myHighSchoolGrades = getDriver().findElements(By.xpath("//div[@id='my-high-school-grades-page-contents']//p"));
			for(WebElement text:myHighSchoolGrades)
			{
				String details = text.getText();
				list1.add(details);
			}
			for(int i=0,j=1;i<list1.size()-1;)
			{
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"ReviewPageData", row++, list1.get(i), list1.get(j));
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				i=i+2;
				j=i+1;
			}
			getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[5]")).click();
			Thread.sleep(1000);
		}
		catch (Exception e) {}
	}








	public  void arizonaResidencySection(String colKey,String colValue) throws Exception
	{
		try {
			WebElement elementToScrollTo11 = getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[6]"));
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
			getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[6]")).click();
			Thread.sleep(1000);
			ArrayList<String> list1 = new ArrayList<>();
			List<WebElement> arizonaResidency = getDriver().findElements(By.xpath("//div[@id='arizona-residency-page-contents']//p"));
			for(WebElement text:arizonaResidency)
			{
				String details = text.getText();
				list1.add(details);
			}
			for(int i=0,j=1;i<list1.size()-1;)
			{
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"ReviewPageData", row++, list1.get(i), list1.get(j));
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				i=i+2;
				j=i+1;
			}
			getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[6]")).click();
			Thread.sleep(1000);
		}
		catch (Exception e) {}
	}








	public  void editFunctionality() throws Throwable
	{
		String editSection = "";
		String url = "";
		//		getDriver().navigate().refresh();
		waitTillLoaderDisappears();
		Thread.sleep(6000);


		List<WebElement> edit = getDriver().findElements(By.xpath("//button[contains(text(),'Edit')]"));
		ArrayList<Integer> random = getRandomNumber(1, edit.size(), 1);








		for(int ran:random)
		{
			editSection = getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a//h2)["+ran+"]")).getText();
			WebElement elementToScrollTo1 = getDriver().findElement(By.xpath("//section[@data-cy='review-certify-your-application']"));
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			getDriver().findElement(By.xpath("(//button[contains(text(),'Edit')])["+ran+"]")).click();
			waitTillLoaderDisappears();
			Thread.sleep(3000);
			url = getDriver().getCurrentUrl();
		}








		if(editSection.equalsIgnoreCase("Profile"))
		{
			if(url.contains("profile"))
			{
				log.debug("The edit button in the review section redirects to the expected page.");
				getDriver().navigate().back();
				waitTillLoaderDisappears();
				Thread.sleep(3000);
			}
			else
				log.debug("The edit button in the review section does not redirect to the expected page.");
		}
		else if(editSection.equalsIgnoreCase("My information"))
		{
			if(url.contains("my-information"))
			{
				log.debug("The edit button in the review section redirects to the expected page.");
				getDriver().navigate().back();
				waitTillLoaderDisappears();
				Thread.sleep(3000);
			}
			else
				log.debug("The edit button in the review section does not redirect to the expected page.");
		}
		else if(editSection.equalsIgnoreCase("My program"))
		{
			if(url.contains("my-program"))
			{
				log.debug("The edit button in the review section redirects to the expected page.");
				getDriver().navigate().back();
				waitTillLoaderDisappears();
				Thread.sleep(3000);
			}
			else
				log.debug("The edit button in the review section does not redirect to the expected page.");
		}
		else if(editSection.equalsIgnoreCase("My schools"))
		{
			if(url.contains("my-schools"))
			{
				System.out.println("The edit button in the review section redirects to the expected page.");
				getDriver().navigate().back();
				waitTillLoaderDisappears();
				Thread.sleep(3000);
			}
			else
				System.out.println("The edit button in the review section does not redirect to the expected page.");
		}
		else if(editSection.equalsIgnoreCase("My high school grades"))
		{
			if(url.contains("my-high-school-grades"))
			{
				System.out.println("The edit button in the review section redirects to the expected page.");
				getDriver().navigate().back();
				waitTillLoaderDisappears();
				Thread.sleep(4000);
			}
			else
				System.out.println("The edit button in the review section does not redirect to the expected page.");
		}
		else if(editSection.equalsIgnoreCase("Arizona residency"))
		{
			if(url.contains("arizona-residency"))
			{
				System.out.println("The edit button in the review section redirects to the expected page.");
				getDriver().navigate().back();
				waitTillLoaderDisappears();
				Thread.sleep(3000);
			}
			else
				System.out.println("The edit button in the review section does not redirect to the expected page.");
		}
	}

	
	public  void ApplicationAffidavit() throws InterruptedException
	{
		WebElement elementToScrollTo11 = getDriver().findElement(By.xpath("//h3[.=' Prohibition Against Discrimination, Harassment and Retaliation ']"));
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);

		String parentWindowHandle = getDriver().getWindowHandle();
		findElement("prohibition_XPATH").click();
		Set<String> windowID = getDriver().getWindowHandles();
		for(String wid:windowID)
		{
			getDriver().switchTo().window(wid);
			String URL = getDriver().getCurrentUrl();
			if(URL.contains("policy"))
			{
				log.debug("Prohibition link works as expected!");
				getDriver().close();
			}
		}
		getDriver().switchTo().window(parentWindowHandle);



		WebElement elementToScrollTo = findElement("report_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);

		findElement("report_XPATH").click();
		String parentWindowHandle1 = getDriver().getWindowHandle();
		findElement("prohibition_XPATH").click();
		Set<String> windowID1 = getDriver().getWindowHandles();
		for(String wid:windowID1)
		{
			getDriver().switchTo().window(wid);
			String URL = getDriver().getCurrentUrl();
			if(URL.contains("reportit"))
			{
				log.debug("reportit link works as expected!");
				getDriver().close();
			}
		}
		getDriver().switchTo().window(parentWindowHandle1);

	}







//	public  void ApplicationAffidavit() throws InterruptedException
//	{
//		WebElement elementToScrollTo11 = getDriver().findElement(By.xpath("//h3[.=' Prohibition Against Discrimination, Harassment and Retaliation ']"));
//		this.js = (JavascriptExecutor) getDriver();
//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
//		String mainWindowHandle = getDriver().getWindowHandle();
//		List<WebElement> Links = getDriver().findElements(By.xpath("//a[@class='text-underline font-weight-bold']"));
//
//
//
//		for (WebElement link : Links) 
//		{
//			String linkText = link.getText();
//
//
//
//
//			// Click the link
//			Thread.sleep(1000);
//			link.click();
//			Thread.sleep(1000);
//
//
//
//			// Switch to the new tab or window
//			for (String windowHandle : getDriver().getWindowHandles()) 
//			{
//				if (!windowHandle.equals(mainWindowHandle)) 
//				{
//					getDriver().switchTo().window(windowHandle);
//
//
//
//
//					// Validate the actual URL or title
//					String actualUrl = getDriver().getCurrentUrl();
//
//
//
//
//					// Create a map to store expected URLs or titles for each link
//					Map<String, String> expectedLinks = new HashMap<>();
//					expectedLinks.put("Policy", "https://policy.asu.edu/");
//					expectedLinks.put("reportit", "https://www.asu.edu/reportit/");
//
//
//
//
//					if (expectedLinks.containsKey(linkText)) 
//					{
//						String expectedUrl = expectedLinks.get(linkText);
//
//
//
//
//						if (actualUrl.equals(expectedUrl)) 
//						{
//							log.debug("Link '" + linkText + "' navigated to the expected URL.");
//						} else 
//						{
//							log.debug("Link '" + linkText + "' did not navigate to the expected URL.");
//						}
//					} else 
//					{
//						log.debug("No expected URL found for link '" + linkText + "'.");
//					}
//
//
//
//
//					// Close the new tab or window
//					getDriver().close();
//
//
//
//
//					// Switch back to the main window
//					getDriver().switchTo().window(mainWindowHandle);
//				}
//			}
//
//
//
//
//		}
//	}
	public  void Acknowledgement() throws InterruptedException 
	{
		WebElement elementToScrollTo11 = findElement("Acknowledgementcheckbox_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		Thread.sleep(1000);
		click("Acknowledgementcheckbox_XPATH");
		Thread.sleep(1000);
	}


	public  void ApplicationFee_Visa() throws Throwable 
	{
		WebElement elementToScrollTo1111 = findElement("PayYourAppFeeQuestion_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
		try {
			if(findElement("AppWaiverMessage_XPATH").isDisplayed())
			{
				log.debug("App Fee Waived message : Your application fee has been waived. If all your information is correct, you may proceed and submit your application.");
				WebElement elementToScrollTo111 = findElement("SubmitAppBtn_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
				click("SubmitAppBtn_XPATH");
				waitTillLoaderDisappears();
				Thread.sleep(4000);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-cy='app-dashboard-application-submission-alert']//span[.='Application submitted!']")));
				WebElement elementToScroll = findElement("ApplicationSubmittedText_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
				String AppSubmissionStatus	= findElement("ApplicationSubmittedText_XPATH").getText();
				log.debug("The status of the Application :"+AppSubmissionStatus);
				String ConfirmationEmail	= findElement("ConfEmail_XPATH").getText();
				log.debug("The Confirmation Email is sent to :"+ConfirmationEmail);
				if(ConfirmationEmail.equals(validEmail))
				{
					log.debug("A confirmation email has been sent to a proper Email which was used to create account");
				}
				click("SeeMyNxtSteps_XPATH");
				Thread.sleep(1000);
			}}
		catch (Exception e) 
		{
			WebElement elementToScrollTo11 = findElement("PayYourAppFeeQuestion_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
			if(findElement("PayNow_XPATH").isDisplayed())
			{
				// PayNow---------- Using Visa card
				WebElement elementToScrollTo = findElement("PayNow_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				click("PayNow_XPATH");
				Thread.sleep(7000);
				WebElement elementToScrollTo1 = findElement("SubmitAppBtn_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				click("SubmitAppBtn_XPATH");
				waitTillLoaderDisappears();
				Thread.sleep(5000);
				click("NextPaymentMethodBtn_ID");
				Thread.sleep(3000);
				click("EnterCreditOrDebitInfo_ID");
				Thread.sleep(1000);
				// Check for the Billing Address
				WebElement elementToScroll = findElement("Country_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
				String CountryForBA	= findElement("Country_ID").getText();
				String Address1ForBA	= findElement("address1_ID").getAttribute("value");
				String Address2ForBA	= findElement("address2_ID").getAttribute("value");
				String CityForBA	= findElement("city_ID").getText();
				String StateForBA	= findElement("state_ID").getText();
				String ZipForBA	= findElement("zip_ID").getAttribute("value");


				//				System.out.println("CountryForBA :"+ CountryForBA);
				System.out.println("Address1ForBA :"+Address1ForBA);
				System.out.println("Address2ForBA :"+Address2ForBA);
				System.out.println("ZipForBA :"+ZipForBA);



				if (CountryForBA.equals(selectedOptionText)) {
					log.debug("The Home Country selected in My Info is the same as in the Billing Address");
				} 
				else {
					log.debug("The Home Country selected in My Info is Not the same as in the Billing Address");

					// Identify the dropdown element
					WebElement dropdownElement = getDriver().findElement(By.id("country"));

					// Create a Select object
					Select dropdown = new Select(dropdownElement);

					// Get all the options from the dropdown
					List<WebElement> options = dropdown.getOptions();

					// Check if there are options available
					if (options.size() > 0) {
						// Generate a random index
						int randomIndex = new Random().nextInt(options.size());

						// Select the option at the random index
						dropdown.selectByIndex(randomIndex);

						// Alternatively, you can print the selected option text
						System.out.println("Selected option: " + options.get(randomIndex).getText());
					} 

					else 
					{
						log.error("No options available in the Country dropdown.");
					}
				}

				if (Address1ForBA.equals("Test Address line 1")) 
				{
					log.debug("The Home Address 1 selectd oin My Info is the same as in the Billing Address");
				}
				if (Address2ForBA.equals("Test Address line 2")) 
				{
					log.debug("The Home Address 2 selectd oin My Info is the same as in the Billing Address");
				}
				if (CityForBA.equals(City)) 
				{
					log.debug("The Home City selectd oin My Info is the same as in the Billing Address");
				}
				if (StateForBA.equals(state)) 
				{
					log.debug("The Home State selectd oin My Info is the same as in the Billing Address");
				}
				if (ZipForBA.equals("12345-678910")) 
				{
					log.debug("The Home Zip selectd oin My Info is the same as in the Billing Address");
				}


				type("CardNo_ID","4111111111111111");
				Thread.sleep(1000);
				type("AccHolderName_ID","Test");
				type("ExpDate_ID","10/30");
				type("CVVno_ID","111");
				WebElement elementToScrollTo111 = findElement("SubmitPaymentBtn_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
				click("SubmitPaymentBtn_ID");
				Thread.sleep(3000);
				waitTillLoaderDisappears();
				Thread.sleep(10000);
				WebElement ApplicationsuccessMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-cy='app-dashboard-application-submission-alert']//span[.='Application submitted!']")));
				log.debug(ApplicationsuccessMessage);
				WebElement elementToScroll1 = findElement("ApplicationSubmittedText_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
				String AppSubmissionStatus	= findElement("ApplicationSubmittedText_XPATH").getText();
				log.debug("The status of the Application :"+AppSubmissionStatus);
				String ConfirmationEmail	= findElement("ConfEmail_XPATH").getText();
				log.debug("The Confirmation Email is sent to :"+ConfirmationEmail);
				if(ConfirmationEmail.equals(validEmail))
				{
					log.debug("A confirmation email has been sent to a proper Email which was used to create account");
				}
				click("SeeMyNxtSteps_XPATH");
				Thread.sleep(3000);
			}
		}
	}

	public  void ApplicationFee_MasterCard() throws Throwable 
	{
		WebElement elementToScrollTo1111 = findElement("PayYourAppFeeQuestion_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
		try {
			if(findElement("AppWaiverMessage_XPATH").isDisplayed())
			{
				log.debug("App Fee Waived message : Your application fee has been waived. If all your information is correct, you may proceed and submit your application.");
				WebElement elementToScrollTo111 = findElement("SubmitAppBtn_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
				click("SubmitAppBtn_XPATH");
				waitTillLoaderDisappears();
				Thread.sleep(4000);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-cy='app-dashboard-application-submission-alert']//span[.='Application submitted!']")));
				WebElement elementToScroll = findElement("ApplicationSubmittedText_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
				String AppSubmissionStatus	= findElement("ApplicationSubmittedText_XPATH").getText();
				log.debug("The status of the Application :"+AppSubmissionStatus);
				String ConfirmationEmail	= findElement("ConfEmail_XPATH").getText();
				log.debug("The Confirmation Email is sent to :"+ConfirmationEmail);
				if(ConfirmationEmail.equals(validEmail))
				{
					log.debug("A confirmation email has been sent to a proper Email which was used to create account");
				}
				click("SeeMyNxtSteps_XPATH");
				Thread.sleep(1000);
			}}
		catch (Exception e) {


			WebElement elementToScrollTo11 = findElement("PayYourAppFeeQuestion_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);

			if(findElement("PayNow_XPATH").isDisplayed())
			{
				// PayNow---------- Using Visa card
				WebElement elementToScrollTo = findElement("PayNow_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				click("PayNow_XPATH");
				Thread.sleep(3000);
				WebElement elementToScrollTo1 = findElement("SubmitAppBtn_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				click("SubmitAppBtn_XPATH");
				waitTillLoaderDisappears();
				Thread.sleep(5000);
				click("NextPaymentMethodBtn_ID");
				Thread.sleep(2000);
				click("EnterCreditOrDebitInfo_ID");
				Thread.sleep(1000);
				type("CardNo_ID","5454545454545454");
				Thread.sleep(1000);
				type("AccHolderName_ID","Test");
				type("ExpDate_ID","10/30");
				type("CVVno_ID","998");
				WebElement elementToScrollTo111 = findElement("SubmitPaymentBtn_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
				click("SubmitPaymentBtn_ID");
				Thread.sleep(3000);
				waitTillLoaderDisappears();
				Thread.sleep(10000);
				WebElement ApplicationsuccessMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-cy='app-dashboard-application-submission-alert']//span[.='Application submitted!']")));
				log.debug(ApplicationsuccessMessage);
				WebElement elementToScroll = findElement("ApplicationSubmittedText_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
				String AppSubmissionStatus	= findElement("ApplicationSubmittedText_XPATH").getText();
				log.debug("The status of the Application :"+AppSubmissionStatus);
				String ConfirmationEmail	= findElement("ConfEmail_XPATH").getText();
				log.debug("The Confirmation Email is sent to :"+ConfirmationEmail);
				if(ConfirmationEmail.equals(validEmail))
				{
					log.debug("A confirmation email has been sent to a proper Email which was usec to create account");
				}
				click("SeeMyNxtSteps_XPATH");
				Thread.sleep(3000);

			}
		}
	}
	public  void ApplicationFee_Discover() throws Throwable 
	{
		WebElement elementToScrollTo1111 = findElement("PayYourAppFeeQuestion_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
		try {
			if(findElement("AppWaiverMessage_XPATH").isDisplayed())


			{

				log.debug("App Fee Waived message : Your application fee has been waived. If all your information is correct, you may proceed and submit your application.");
				WebElement elementToScrollTo111 = findElement("SubmitAppBtn_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
				click("SubmitAppBtn_XPATH");
				waitTillLoaderDisappears();
				Thread.sleep(6000);
				WebElement elementToScroll = findElement("ApplicationSubmittedText_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
				String AppSubmissionStatus	= findElement("ApplicationSubmittedText_XPATH").getText();
				log.debug("The status of the Application :"+AppSubmissionStatus);
				String ConfirmationEmail	= findElement("ConfEmail_XPATH").getText();
				log.debug("The Confirmation Email is sent to :"+ConfirmationEmail);
				if(ConfirmationEmail.equals(validEmail))
				{
					log.debug("A confirmation email has been sent to a proper Email which was used to create account");
				}
				click("SeeMyNxtSteps_XPATH");
				Thread.sleep(1000);
			}}
		catch (Exception e) {


			WebElement elementToScrollTo11 = findElement("PayYourAppFeeQuestion_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);

			if(findElement("PayNow_XPATH").isDisplayed())
			{
				// PayNow---------- Using Visa card
				WebElement elementToScrollTo = findElement("PayNow_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				click("PayNow_XPATH");
				Thread.sleep(3000);
				WebElement elementToScrollTo1 = findElement("SubmitAppBtn_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				click("SubmitAppBtn_XPATH");
				waitTillLoaderDisappears();
				Thread.sleep(5000);
				click("NextPaymentMethodBtn_ID");
				Thread.sleep(2000);
				click("EnterCreditOrDebitInfo_ID");
				Thread.sleep(1000);
				type("CardNo_ID","6011111111111117");
				Thread.sleep(1000);
				type("AccHolderName_ID","Test");
				type("ExpDate_ID","10/30");
				type("CVVno_ID","996");
				WebElement elementToScrollTo111 = findElement("SubmitPaymentBtn_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
				click("SubmitPaymentBtn_ID");
				Thread.sleep(3000);
				waitTillLoaderDisappears();
				Thread.sleep(10000);
				WebElement ApplicationsuccessMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-cy='app-dashboard-application-submission-alert']//span[.='Application submitted!']")));
				log.debug(ApplicationsuccessMessage);
				WebElement elementToScroll = findElement("ApplicationSubmittedText_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
				String AppSubmissionStatus	= findElement("ApplicationSubmittedText_XPATH").getText();
				log.debug("The status of the Application :"+AppSubmissionStatus);
				String ConfirmationEmail	= findElement("ConfEmail_XPATH").getText();
				log.debug("The Confirmation Email is sent to :"+ConfirmationEmail);
				if(ConfirmationEmail.equals(validEmail))
				{
					log.debug("A confirmation email has been sent to a proper Email which was usec to create account");
				}
				click("SeeMyNxtSteps_XPATH");
				Thread.sleep(3000);

			}
		}
	}
	public  void ApplicationFee_PayLater() throws Throwable 
	{
		WebElement elementToScrollTo1111 = findElement("PayYourAppFeeQuestion_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
		try {
			if(findElement("AppWaiverMessage_XPATH").isDisplayed())
			{
				log.debug("App Fee Waived message : Your application fee has been waived. If all your information is correct, you may proceed and submit your application.");
				WebElement elementToScrollTo111 = findElement("SubmitAppBtn_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
				click("SubmitAppBtn_XPATH");
				waitTillLoaderDisappears();
				Thread.sleep(4000);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-cy='app-dashboard-application-submission-alert']//span[.='Application submitted!']")));
				WebElement elementToScroll = findElement("ApplicationSubmittedText_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
				String AppSubmissionStatus	= findElement("ApplicationSubmittedText_XPATH").getText();
				log.debug("The status of the Application :"+AppSubmissionStatus);
				String ConfirmationEmail	= findElement("ConfEmail_XPATH").getText();
				log.debug("The Confirmation Email is sent to :"+ConfirmationEmail);
				if(ConfirmationEmail.equals(validEmail))
				{
					log.debug("A confirmation email has been sent to a proper Email which was used to create account");
				}
				click("SeeMyNxtSteps_XPATH");
				Thread.sleep(1000);
			}}
		catch (Exception e) {


			WebElement elementToScrollTo11 = findElement("PayYourAppFeeQuestion_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);

			if(findElement("PayLater_XPATH").isDisplayed())
			{
				// PayLater----------------
				WebElement elementToScrollTo = findElement("PayLater_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				click("PayLater_XPATH");
				Thread.sleep(3000);
				WebElement elementToScrollTo1 = findElement("SubmitAppBtn_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				click("SubmitAppBtn_XPATH");
				waitTillLoaderDisappears();
				Thread.sleep(12000);
				WebElement ApplicationsuccessMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-cy='app-dashboard-application-submission-alert']//span[.='Application submitted!']")));
				log.debug(ApplicationsuccessMessage);
				WebElement elementToScroll = findElement("ApplicationSubmittedText_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
				String AppSubmissionStatus	= findElement("ApplicationSubmittedText_XPATH").getText();
				log.debug("The status of the Application :"+AppSubmissionStatus);
				String ConfirmationEmail	= findElement("ConfEmail_XPATH").getText();
				log.debug("The Confirmation Email is sent to :"+ConfirmationEmail);
				if(ConfirmationEmail.equals(validEmail))
				{
					log.debug("A confirmation email has been sent to a proper Email which was usec to create account");
				}
				click("SeeMyNxtSteps_XPATH");
				Thread.sleep(3000);

			}
		}
	}


	public  void compareValidDataWithReview(String filePath, String sheetName1, String sheetName2) throws IOException
	{
		FileInputStream file = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(file);




		Sheet sheet1 = workbook.getSheet(sheetName1);
		Sheet sheet2 = workbook.getSheet(sheetName2);




		Map<String, String> mapSheet1 = extractKeyValues(sheet1);
		Map<String, String> mapSheet2 = extractKeyValues(sheet2);




		// Find common key-value pairs and print them
		System.out.println("Common Key-Value pairs in both sheets:");
		for (Map.Entry<String, String> entrySheet1 : mapSheet1.entrySet()) {
			String keySheet1 = entrySheet1.getKey();
			String valueSheet1 = entrySheet1.getValue();




			for (Map.Entry<String, String> entrySheet2 : mapSheet2.entrySet()) {
				String keySheet2 = entrySheet2.getKey();
				String valueSheet2 = entrySheet2.getValue();




				if (keySheet1.equals(keySheet2) && valueSheet1.equals(valueSheet2)) {
					System.out.println("Key: " + keySheet1 + ", Value: " + valueSheet1);
				}
			}
		}
		// Find and print unmatched key-value pairs from sheet1
		System.out.println("Unmatched Key-Value pairs in Sheet1:");
		for (Map.Entry<String, String> entry : mapSheet1.entrySet()) {
			String keySheet1 = entry.getKey();
			String valueSheet1 = entry.getValue();




			if (!mapSheet2.containsKey(keySheet1) || !mapSheet2.get(keySheet1).equals(valueSheet1)) 
			{




				System.out.println(sheetName1+" :  "+"Key: " + keySheet1 + ", Value: " + valueSheet1);
			}
		}




		// Find and print unmatched key-value pairs from sheet2
		System.out.println("Unmatched Key-Value pairs in Sheet2:");
		for (Map.Entry<String, String> entry : mapSheet2.entrySet()) {
			String keySheet2 = entry.getKey();
			String valueSheet2 = entry.getValue();




			if (!mapSheet1.containsKey(keySheet2) || !mapSheet1.get(keySheet2).equals(valueSheet2)) {
				//				System.out.println(sheetName2+" :  "+"Key: " + keySheet2 + ", Value: " + valueSheet2);
			}
		}




		//        workbook.close();
		//        file.close();
	}




	private  Map<String, String> extractKeyValues(Sheet sheet) 
	{
		Map<String, String> keyValueMap = new HashMap<>();
		int rowCount = sheet.getPhysicalNumberOfRows();




		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			Cell keyCell = row.getCell(0); // Assuming the key is in the first column
			Cell valueCell = row.getCell(1); // Assuming the value is in the second column




			if (keyCell != null && valueCell != null) 
			{
				String key = keyCell.toString().trim();
				String value = valueCell.toString().trim();
				keyValueMap.put(key, value);
				System.out.println(keyValueMap);
			}
		}




		return keyValueMap;
	}




}


























