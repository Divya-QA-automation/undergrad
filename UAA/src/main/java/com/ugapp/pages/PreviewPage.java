package com.ugapp.pages;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ugapp.base.Page;


public class PreviewPage extends Page{

//	CreateAccountPage createacc = new CreateAccountPage();
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	static int row=0;


	public  void validatePreview() throws Throwable
	{
		waitTillProgressbarDisappears();
		Thread.sleep(3000);
		try
		{
			findElement("previewTitle_XPATH");
			log.debug("Redirected to preview page");
		}
		catch(Exception e)
		{
			log.debug("Not redirected to preview page");
		}


	}


	public  void downloadPdf()
	{
		boolean pdf = findElement("downloadPdf_XPATH").isEnabled();
		if(pdf == true)
			log.debug("Download as pdf button is enabled!");
		else if(pdf == false)
			log.debug("Download as pdf button is disabled!");
	}


	public  void back() throws Throwable
	{
		findElement("previewBack_XPATH").click();
		waitTillLoaderDisappears();
		waitTillProgressbarDisappears();
		Thread.sleep(2000);


		try
		{
			findElement("validateTitle_XPATH");
			log.debug("Back button works as expected!");
		}
		catch(Exception e)
		{
			log.debug("Back button does not work");
		}


		findElement("previewLink_XPATH").click();
		waitTillLoaderDisappears();
		waitTillProgressbarDisappears();
		Thread.sleep(2000);
	}


	public  void previewProfile(String colKey,String colValue) throws Throwable
	{
		WebElement elementToScrollTo1 = findElement("previewProfile_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		findElement("previewProfile_XPATH").click();
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
			// initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"PreviewPageData", row++, list1.get(i), list1.get(j));
			// saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			i=i+2;
			j=i+1;
		}
		findElement("previewProfile_XPATH").click();
		waitTillLoaderDisappears();
		waitTillProgressbarDisappears();
		Thread.sleep(1000);
	}


	public  void previewMyInfo(String colKey,String colValue) throws Throwable
	{
		WebElement elementToScrollTo1 = findElement("previewMyInfo_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		findElement("previewMyInfo_XPATH").click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> previewMyInfo = getDriver().findElements(By.xpath("//div[@id='my-information-page-contents']//p"));
		for(WebElement text:previewMyInfo)
		{
			String details = text.getText();
			list1.add(details);
		}
		for(int i=0,j=1;i<list1.size()-1;)
		{
			// initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"PreviewPageData", row++, list1.get(i), list1.get(j));
			// saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			i=i+2;
			j=i+1;
		}
		findElement("previewMyInfo_XPATH").click();
		waitTillLoaderDisappears();
		waitTillProgressbarDisappears();
		Thread.sleep(1000);
	}


	public  void previewMyProgram(String colKey,String colValue) throws Throwable
	{
		WebElement elementToScrollTo1 = findElement("previewMyProgram_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		findElement("previewMyProgram_XPATH").click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> previewMyProgram = getDriver().findElements(By.xpath("//div[@id='my-programs-page-contents']//p"));
		for(WebElement text:previewMyProgram)
		{
			String details = text.getText();
			list1.add(details);
		}
		for(int i=0,j=1;i<list1.size()-1;)
		{
			// initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"PreviewPageData", row++, list1.get(i), list1.get(j));
			// saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			i=i+2;
			j=i+1;
		}
		findElement("previewMyProgram_XPATH").click();
		waitTillLoaderDisappears();
		waitTillProgressbarDisappears();
		Thread.sleep(1000);
	}


	public  void previewMySchools(String colKey,String colValue) throws EncryptedDocumentException, Exception
	{
		WebElement elementToScrollTo1 = findElement("previewMySchools_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		findElement("previewMySchools_XPATH").click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> previewMySchools = getDriver().findElements(By.xpath("//div[@id='my-schools-page-contents']//p"));
		for(WebElement text:previewMySchools)
		{
			String details = text.getText();
			list1.add(details);
		}
		System.out.println("list 1 :"+list1);
		for(int i=0,j=1;i<list1.size()-1;)
		{
			// initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"PreviewPageData", row++, list1.get(i), list1.get(j));
			// saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			i=i+2;
			j=i+1;
		}
		findElement("previewMySchools_XPATH").click();
		Thread.sleep(1000);
	}


	public  void previewMyHighSchoolGrades(String colKey,String colValue) throws Throwable
	{
		try 
		{
		WebElement elementToScrollTo1 = findElement("previewMyHighSchoolGrades_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		findElement("previewMyHighSchoolGrades_XPATH").click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> previewMyHighSchoolGrades = getDriver().findElements(By.xpath("//div[@id='my-high-school-grades-page-contents']//p"));
		for(WebElement text:previewMyHighSchoolGrades)
		{
			String details = text.getText();
			list1.add(details);
		}
		for(int i=0,j=1;i<list1.size()-1;)
		{
			// initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"PreviewPageData", row++, list1.get(i), list1.get(j));
			// saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			i=i+2;
			j=i+1;
		}
		findElement("previewMyHighSchoolGrades_XPATH").click();
		waitTillLoaderDisappears();
		waitTillProgressbarDisappears();
		Thread.sleep(1000);
		}
		catch(Exception e) {}
		
	}


	public  void previewArizonaResidency(String colKey,String colValue) throws Throwable
	{
		try {
		WebElement elementToScrollTo1 = findElement("previewArizona_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
		findElement("previewArizona_XPATH").click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> previewArizona = getDriver().findElements(By.xpath("//div[@id='arizona-residency-page-contents']//p"));
		for(WebElement text:previewArizona)
		{
			String details = text.getText();
			list1.add(details);
		}
		for(int i=0,j=1;i<list1.size()-1;)
		{
			// initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"PreviewPageData", row++, list1.get(i), list1.get(j));
			// saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			i=i+2;
			j=i+1;
		}
		
		findElement("previewArizona_XPATH").click();
		waitTillLoaderDisappears();
		waitTillProgressbarDisappears();
		Thread.sleep(1000);
		}
		catch(Exception e) {}
	}

	public  void affidavit() throws InterruptedException
	{
		
		WebElement elementToScrollTo1 = findElement("readAffidavit_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);


		findElement("readAffidavit_XPATH").click();
		Thread.sleep(1000);
		WebElement elementToScrollTo = findElement("prohibition_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);


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


	public  void checkbox()
	{
		boolean checkbox = findElement("previewCheckbox_XPATH").isEnabled();
		if(checkbox == false)
			log.debug("Checkbox is disabled as expected!");
		else
			log.debug("Checkbox is not disabled");
	}


	//	//to compare the two excel sheets review and preview page
	//	public static void compareReviewAndPreview()
	//	{
	//		// Specify the file paths and sheet names for both Excel sheets
	//		String filePath1 = System.getProperty("user.dir") + "/src/test/resources/com/ugapp/excel/testdata.xlsx";
	//		String sheetName1 = "ReviewPageData";
	//		String filePath2 = System.getProperty("user.dir") + "//excel//testdata.xlsx";
	//		String sheetName2 = "PreviewPageData";
	//
	//
	//
	//
	//		compareExcelSheets(filePath1, sheetName1, filePath2, sheetName2);
	//	}
	public  void compareReviewAndPreview(String colKey,String colValue) throws IOException
	{
		int colkey = Integer.parseInt(colKey);
		int colvalue = Integer.parseInt(colValue);
		String excelPath = System.getProperty("user.dir") + "/src/src/test/resources/com/ugapp/excel/testdata.xlsx";
		String sheet1Name = "ReviewPageData";
		String sheet2Name = "PreviewPageData";
		int totalRuns = 1;  

		//      CompareExcelSheets(excelPath, sheet1Name, sheet2Name, colKey, colValue);
		CompareAndWriteMismatches(excelPath, sheet1Name, sheet2Name, colkey, colvalue, totalRuns);

	}


	public  void previousPage() throws Throwable
	{
		WebElement elementToScrollTo = findElement("returnToPrevious_XPATH");
		this.js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);


		findElement("returnToPrevious_XPATH").click();
		waitTillLoaderDisappears();
		waitTillProgressbarDisappears();
		Thread.sleep(3000);
	}


	public  void signOut() throws Throwable
	{
		findElement("profileIcon_XPATH").click();
		Thread.sleep(1000);
		findElement("signOut_XPATH").click();
		Thread.sleep(2000);
	}



	public  void login() throws Throwable
	{
		type("email_XPATH",CreateAccountPage.validEmail.get());
		type("password_XPATH","Testing10!");
		findElement("logInButton_XPATH").click();
		Thread.sleep(3000);
		waitTillLoaderDisappears();
		waitTillProgressbarDisappears();
		Thread.sleep(2000);
	}




	public  void validatePostLogin() throws InterruptedException
	{
		//validate the status if submitted
		String status = findElement("submittedText_XPATH").getText();
		if(status.equalsIgnoreCase("Submitted"))
			log.debug("The status of the application is "+status+ " after completion");
		else
			log.debug("The status of the application is "+status+ " after completion");




		//validate the date shown
		String date=getCurrentDate();
		Thread.sleep(2000);
		log.debug("The Application Submitted on : "+date);

	}

	
	
	

}




