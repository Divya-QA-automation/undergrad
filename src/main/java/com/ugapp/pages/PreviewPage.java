package com.ugapp.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ugapp.base.Page;

public class PreviewPage extends Page{

	static JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	static int row=0;

	public static void validatePreview()
	{
		try
		{
			findElement("previewTitle_XPATH");
			System.out.println("Redirected to preview page");
		}
		catch(Exception e)
		{
			System.out.println("Not redirected to preview page");
		}

	}

	public static void downloadPdf()
	{
		boolean pdf = findElement("downloadPdf_XPATH").isEnabled();
		if(pdf == true)
			System.out.println("Download as pdf button is enabled!");
		else if(pdf == false)
			System.out.println("Download as pdf button is disabled!");
	}

	public static void back() throws Throwable
	{
		findElement("previewBack_XPATH").click();
		waitTillLoaderDisappears();
		Thread.sleep(1000);

		try
		{
			findElement("validateTitle_XPATH");
			System.out.println("Back button works as expected!");
		}
		catch(Exception e)
		{
			System.out.println("Back button does not work");
		}

		findElement("previewLink_XPATH").click();
		waitTillLoaderDisappears();
	}

	public static void previewProfile() throws EncryptedDocumentException, Exception
	{
		findElement("previewProfile_XPATH").click();
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
			setExcelData("PreviewPageData", row++, list1.get(i), list1.get(j));
			saveReport();
			i=i+2;
			j=i+1;
		}
		findElement("previewProfile_XPATH").click();
		Thread.sleep(1000);
	}

	public static void previewMyInfo() throws EncryptedDocumentException, Exception
	{
		findElement("previewMyInfo_XPATH").click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> previewMyInfo = driver.findElements(By.xpath("//div[@id='my-information-page-contents']//p"));
		for(WebElement text:previewMyInfo)
		{
			String details = text.getText();
			list1.add(details);
		}
		System.out.println("list 1 :"+list1);
		for(int i=0,j=1;i<list1.size()-1;)
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("PreviewPageData", row++, list1.get(i), list1.get(j));
			saveReport();
			i=i+2;
			j=i+1;
		}
		findElement("previewMyInfo_XPATH").click();
		Thread.sleep(1000);
	}

	public static void previewMyProgram() throws EncryptedDocumentException, Exception
	{
		findElement("previewMyProgram_XPATH").click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> previewMyProgram = driver.findElements(By.xpath("//div[@id='my-programs-page-contents']//p"));
		for(WebElement text:previewMyProgram)
		{
			String details = text.getText();
			list1.add(details);
		}
		System.out.println("list 1 :"+list1);
		for(int i=0,j=1;i<list1.size()-1;)
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("PreviewPageData", row++, list1.get(i), list1.get(j));
			saveReport();
			i=i+2;
			j=i+1;
		}
		findElement("previewMyProgram_XPATH").click();
		Thread.sleep(1000);
	}

	public static void previewMySchools() throws EncryptedDocumentException, Exception
	{
		findElement("previewMySchools_XPATH").click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> previewMySchools = driver.findElements(By.xpath("//div[@id='my-schools-page-contents']//p"));
		for(WebElement text:previewMySchools)
		{
			String details = text.getText();
			list1.add(details);
		}
		System.out.println("list 1 :"+list1);
		for(int i=0,j=1;i<list1.size()-1;)
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("PreviewPageData", row++, list1.get(i), list1.get(j));
			saveReport();
			i=i+2;
			j=i+1;
		}
		findElement("previewMySchools_XPATH").click();
		Thread.sleep(1000);
	}

	public static void previewMyHighSchoolGrades() throws EncryptedDocumentException, Exception
	{
		findElement("previewMyHighSchoolGrades_XPATH").click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> previewMyHighSchoolGrades = driver.findElements(By.xpath("//div[@id='my-high-school-grades-page-contents']//p"));
		for(WebElement text:previewMyHighSchoolGrades)
		{
			String details = text.getText();
			list1.add(details);
		}
		System.out.println("list 1 :"+list1);
		for(int i=0,j=1;i<list1.size()-1;)
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("PreviewPageData", row++, list1.get(i), list1.get(j));
			saveReport();
			i=i+2;
			j=i+1;
		}
		findElement("previewMyHighSchoolGrades_XPATH").click();
		Thread.sleep(1000);
	}

	public static void previewArizonaResidency() throws EncryptedDocumentException, Exception
	{
		findElement("previewArizona_XPATH").click();
		Thread.sleep(1000);
		ArrayList<String> list1 = new ArrayList<>();
		List<WebElement> previewArizona = driver.findElements(By.xpath("//div[@id='arizona-residency-page-contents']//p"));
		for(WebElement text:previewArizona)
		{
			String details = text.getText();
			list1.add(details);
		}
		System.out.println("list 1 :"+list1);
		for(int i=0,j=1;i<list1.size()-1;)
		{
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData("PreviewPageData", row++, list1.get(i), list1.get(j));
			saveReport();
			i=i+2;
			j=i+1;
		}
		findElement("previewArizona_XPATH").click();
		Thread.sleep(1000);
	}

	public static void affidavit() throws InterruptedException
	{
		WebElement elementToScrollTo1 = findElement("readAffidavit_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);

		findElement("readAffidavit_XPATH").click();
		Thread.sleep(1000);
		WebElement elementToScrollTo = findElement("prohibition_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);

		String parentWindowHandle = driver.getWindowHandle();
		findElement("prohibition_XPATH").click();
		Set<String> windowID = driver.getWindowHandles();
		for(String wid:windowID)
		{
			driver.switchTo().window(wid);
			String URL = driver.getCurrentUrl();
			if(URL.contains("policy"))
			{
				System.out.println("Prohibition link works as expected!");
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle);


		findElement("report_XPATH").click();
		String parentWindowHandle1 = driver.getWindowHandle();
		findElement("prohibition_XPATH").click();
		Set<String> windowID1 = driver.getWindowHandles();
		for(String wid:windowID1)
		{
			driver.switchTo().window(wid);
			String URL = driver.getCurrentUrl();
			if(URL.contains("reportit"))
			{
				System.out.println("reportit link works as expected!");
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle1);
	}

	public static void checkbox()
	{
		boolean checkbox = findElement("previewCheckbox_XPATH").isEnabled();
		if(checkbox == false)
			System.out.println("Checkbox is disabled as expected!");
		else
			System.out.println("Checkbox is not disabled");
	}

	//to compare the two excel sheets review and preview page
	public static void compareReviewAndPreview()
	{
		// Specify the file paths and sheet names for both Excel sheets
		String filePath1 = System.getProperty("user.dir") + "//excel//testdata.xlsx";
		String sheetName1 = "ReviewPageData";
		String filePath2 = System.getProperty("user.dir") + "//excel//testdata.xlsx";
		String sheetName2 = "PreviewPageData";


		compareExcelSheets(filePath1, sheetName1, filePath2, sheetName2);
	}

	public static void previousPage() throws Throwable
	{
		WebElement elementToScrollTo = findElement("returnToPrevious_XPATH");
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);

		findElement("returnToPrevious_XPATH").click();
		waitTillLoaderDisappears();
	}

	public static void signOut() throws Throwable
	{
		findElement("profileIcon_XPATH").click();
		Thread.sleep(1000);

		findElement("signOut_XPATH").click();
		waitTillLoaderDisappears();
	}


	public static void login() throws Throwable
	{
		//		type("email_XPATH",CreateAccountPage.validEmail);
		//		type("password_XPATH",CreateAccountPage.validPassword);

		type("email_XPATH","2718embtest@test.asu.edu");
		type("password_XPATH","Test123123123");

		findElement("logInButton_XPATH").click();
		Thread.sleep(2500);
		waitTillLoaderDisappears();
	}


	public static void validatePostLogin()
	{
		//validate the status if submitted
		String status = findElement("submittedText_XPATH").getText();
		if(status.equalsIgnoreCase("Submitted"))
			System.out.println("The status of the apllication is "+status+ " after completion");
		else
			System.out.println("The status of the apllication is "+status+ " after completion");
	
	
		//validate the date shown
		String date=getCurrentDate();
		
	}

}
