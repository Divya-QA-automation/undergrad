package com.ugapp.pages;


import java.util.Map;
import java.util.Set;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import com.ugapp.base.Page;


public class ReviewPage extends Page{
	MyInformationPage MyInfo = new MyInformationPage();
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	static int row = 0;
	//validate  reached review page
	public static void validateReview() throws Throwable
	{
		waitTillLoaderDisappears();
		Thread.sleep(6000);
		try
		{
			if(findElement("reviewText_XPATH").isDisplayed())
			{
				System.out.println("Redirected to Review Page");
			}
		}
		catch(Exception e)
		{
			System.out.println("Not redirected to Review Page");
		}
	}








	//to compare the two excel sheets that is all valid data and data in review page
	public static void compare()
	{
		// Specify the file paths and sheet names for both Excel sheets
		String filePath1 = System.getProperty("user.dir") + "//excel//testdata.xlsx";
		String sheetName1 = "validData";
		String filePath2 = System.getProperty("user.dir") + "//excel//testdata.xlsx";
		String sheetName2 = "ReviewPageData";

		compareExcelSheets(filePath1, sheetName1, filePath2, sheetName2);
	}




	public static void profileSection() throws Exception
	{
		WebElement elementToScrollTo11 = driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[1]"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[1]")).click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> profile = driver.findElements(By.xpath("//div[@id='my-profile-page-contents']//p"));
		for(WebElement text:profile)
		{
			String details = text.getText();
			list1.add(details);
		}
		System.out.println("list 1 :"+list1);
		for(int i=0,j=1;i<list1.size()-1;)
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("ReviewPageData", row++, list1.get(i), list1.get(j));
			saveReport();
			i=i+2;
			j=i+1;
		}
		driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[1]")).click();
		Thread.sleep(1000);
	}




	public static void myInfoSection() throws Exception
	{
		WebElement elementToScrollTo11 = driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[2]"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[2]")).click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> myInfo = driver.findElements(By.xpath("//div[@id='my-information-page-contents']//p"));
		for(WebElement text:myInfo)
		{
			String details = text.getText();
			list1.add(details);
		}
		System.out.println("list 1 :"+list1);
		for(int i=0,j=1;i<list1.size()-1;)
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("ReviewPageData", row++, list1.get(i), list1.get(j));
			saveReport();
			i=i+2;
			j=i+1;
		}
		driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[2]")).click();
		Thread.sleep(1000);
	}




	public static void myProgramSection() throws Exception
	{
		WebElement elementToScrollTo11 = driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[3]"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[3]")).click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> myProgram = driver.findElements(By.xpath("//div[@id='my-programs-page-contents']//p"));
		for(WebElement text:myProgram)
		{
			String details = text.getText();
			list1.add(details);
		}
		System.out.println("list 1 :"+list1);
		for(int i=0,j=1;i<list1.size()-1;)
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("ReviewPageData", row++, list1.get(i), list1.get(j));
			saveReport();
			i=i+2;
			j=i+1;
		}
		driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[3]")).click();
		Thread.sleep(1000);
	}




	public static void mySchoolsSection() throws Exception
	{
		WebElement elementToScrollTo11 = driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[4]"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);


		driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[4]")).click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> mySchools = driver.findElements(By.xpath("//div[@id='my-schools-page-contents']//p"));
		for(WebElement text:mySchools)
		{
			String details = text.getText();
			list1.add(details);
		}
		System.out.println("list 1 :"+list1);
		for(int i=0,j=1;i<list1.size()-1;)
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("ReviewPageData", row++, list1.get(i), list1.get(j));
			saveReport();
			i=i+2;
			j=i+1;
		}
		driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[4]")).click();
		Thread.sleep(1000);
	}




	public static void myHighSchoolGradesSection() throws Exception
	{
		WebElement elementToScrollTo11 = driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[5]"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);

		driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[5]")).click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> myHighSchoolGrades = driver.findElements(By.xpath("//div[@id='my-high-school-grades-page-contents']//p"));
		for(WebElement text:myHighSchoolGrades)
		{
			String details = text.getText();
			list1.add(details);
		}
		System.out.println("list 1 :"+list1);
		for(int i=0,j=1;i<list1.size()-1;)
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("ReviewPageData", row++, list1.get(i), list1.get(j));
			saveReport();
			i=i+2;
			j=i+1;
		}
		driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[5]")).click();
		Thread.sleep(1000);
	}




	public static void arizonaResidencySection() throws Exception
	{
		WebElement elementToScrollTo11 = driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[6]"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[6]")).click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> arizonaResidency = driver.findElements(By.xpath("//div[@id='arizona-residency-page-contents']//p"));
		for(WebElement text:arizonaResidency)
		{
			String details = text.getText();
			list1.add(details);
		}
		System.out.println("list 1 :"+list1);
		for(int i=0,j=1;i<list1.size()-1;)
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("ReviewPageData", row++, list1.get(i), list1.get(j));
			saveReport();
			i=i+2;
			j=i+1;
		}
		driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a)[6]")).click();
		Thread.sleep(1000);
	}




	public static void editFunctionality() throws Throwable
	{
		String editSection = "";
		String url = "";
//		driver.navigate().refresh();
		waitTillLoaderDisappears();
		Thread.sleep(5000);

		List<WebElement> edit = driver.findElements(By.xpath("//button[contains(text(),'Edit')]"));
		ArrayList<Integer> random = getRandomNumber(1, edit.size(), 1);




		for(int ran:random)
		{
			editSection = driver.findElement(By.xpath("(//button[contains(text(),'Edit')]/preceding-sibling::a//h2)["+ran+"]")).getText();
			driver.findElement(By.xpath("(//button[contains(text(),'Edit')])["+ran+"]")).click();
			waitTillLoaderDisappears();
			Thread.sleep(3000);
			url = driver.getCurrentUrl();
		}




		if(editSection.equalsIgnoreCase("Profile"))
		{
			if(url.contains("profile"))
			{
				System.out.println("The edit button in the review section redirects to the expected page.");
				driver.navigate().back();
				waitTillLoaderDisappears();
				Thread.sleep(3000);
			}
			else
				System.out.println("The edit button in the review section does not redirect to the expected page.");
		}
		else if(editSection.equalsIgnoreCase("My information"))
		{
			if(url.contains("my-information"))
			{
				System.out.println("The edit button in the review section redirects to the expected page.");
				driver.navigate().back();
				waitTillLoaderDisappears();
				Thread.sleep(3000);
			}
			else
				System.out.println("The edit button in the review section does not redirect to the expected page.");
		}
		else if(editSection.equalsIgnoreCase("My program"))
		{
			if(url.contains("my-program"))
			{
				System.out.println("The edit button in the review section redirects to the expected page.");
				driver.navigate().back();
				waitTillLoaderDisappears();
				Thread.sleep(3000);
			}
			else
				System.out.println("The edit button in the review section does not redirect to the expected page.");
		}
		else if(editSection.equalsIgnoreCase("My schools"))
		{
			if(url.contains("my-schools"))
			{
				System.out.println("The edit button in the review section redirects to the expected page.");
				driver.navigate().back();
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
				driver.navigate().back();
				waitTillLoaderDisappears();
				Thread.sleep(3000);
			}
			else
				System.out.println("The edit button in the review section does not redirect to the expected page.");
		}
		else if(editSection.equalsIgnoreCase("Arizona residency"))
		{
			if(url.contains("arizona-residency"))
			{
				System.out.println("The edit button in the review section redirects to the expected page.");
				driver.navigate().back();
				waitTillLoaderDisappears();
				Thread.sleep(3000);
			}
			else
				System.out.println("The edit button in the review section does not redirect to the expected page.");
		}
	}
















	public static void ApplicationAffidavit()
	{

		WebElement elementToScrollTo11 = driver.findElement(By.xpath("//h3[.=' Prohibition Against Discrimination, Harassment and Retaliation ']"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		String mainWindowHandle = driver.getWindowHandle();
		List<WebElement> Links = driver.findElements(By.xpath("//a[@class='text-underline font-weight-bold']"));


		for (WebElement link : Links) 
		{
			String linkText = link.getText();


			// Click the link
			link.click();


			// Switch to the new tab or window
			for (String windowHandle : driver.getWindowHandles()) 
			{
				if (!windowHandle.equals(mainWindowHandle)) 
				{
					driver.switchTo().window(windowHandle);


					// Validate the actual URL or title
					String actualUrl = driver.getCurrentUrl();


					// Create a map to store expected URLs or titles for each link
					Map<String, String> expectedLinks = new HashMap<>();
					expectedLinks.put("Policy", "https://policy.asu.edu/");
					expectedLinks.put("reportit", "https://www.asu.edu/reportit/");


					if (expectedLinks.containsKey(linkText)) 
					{
						String expectedUrl = expectedLinks.get(linkText);


						if (actualUrl.equals(expectedUrl)) 
						{
							log.debug("Link '" + linkText + "' navigated to the expected URL.");
							System.out.println("Link '" + linkText + "' navigated to the expected URL.");
						} else 
						{
							log.debug("Link '" + linkText + "' did not navigate to the expected URL.");
							System.out.println("Link '" + linkText + "' did not navigate to the expected URL.");
						}
					} else 
					{
						log.debug("No expected URL found for link '" + linkText + "'.");
						System.out.println("No expected URL found for link '" + linkText + "'.");
					}


					// Close the new tab or window
					driver.close();


					// Switch back to the main window
					driver.switchTo().window(mainWindowHandle);
				}
			}


		}
	}
	public static void Acknowledgement() 
	{
		WebElement elementToScrollTo11 = findElement("Acknowledgementcheckbox_XPATH");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
		click("Acknowledgementcheckbox_XPATH");
	}

	public static void ApplicationFee() throws Throwable 
	{
		if(selectedEmploymentOptionText.equals("Amazon career choice"))
		{
			WebElement elementToScrollTo111 = findElement("SubmitPaymentBtn_ID");
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
			click("SubmitPaymentBtn_ID");
			waitTillLoaderDisappears();
			Thread.sleep(4000);
			WebElement elementToScroll = findElement("ApplicationSubmittedText_XPATH");
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
		}
		else
		{
			WebElement elementToScrollTo11 = findElement("PayYourAppFeeQuestion_XPATH");
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);


			if(findElement("PayYourAppFeeQuestion_XPATH").isDisplayed())
			{
				// PayNow---------- Using Visa card
				WebElement elementToScrollTo = findElement("PayNow_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				click("PayNow_XPATH");
				Thread.sleep(1000);
				WebElement elementToScrollTo1 = findElement("SubmitAppBtn_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				click("SubmitAppBtn_XPATH");
				waitTillLoaderDisappears();
				Thread.sleep(3000);
				click("NextPaymentMethodBtn_ID");
				Thread.sleep(1000);
				click("EnterCreditOrDebitInfo_ID");
				Thread.sleep(1000);
				type("CardNo_ID","4111111111111111");
				Thread.sleep(1000);
				type("AccHolderName_ID","Test");
				type("ExpDate_ID","10/30");
				type("CVVno_ID","111");
				WebElement elementToScrollTo111 = findElement("SubmitPaymentBtn_ID");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
				click("SubmitPaymentBtn_ID");
				waitTillLoaderDisappears();
				Thread.sleep(4000);
				WebElement elementToScroll = findElement("ApplicationSubmittedText_XPATH");
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



			}
		}

	}
	public static void compareValidDataWithReview(String filePath, String sheetName1, String sheetName2) throws IOException
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


	private static Map<String, String> extractKeyValues(Sheet sheet) 
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












