package com.ugapp.testcases;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.WriteMode;
import com.ugapp.base.Page;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest extends Page
{
	//	String ACCESS_TOKEN = "sl.u.AFeBgBmeHePFG4uq4LS0Ja_hO3M4hDQNtEalO7FgmQcfJN6GoP9_SN9lb-XAFoSEwtIw1BRldovetJwiz-KuTatR2ygI2-yD5qOGtLDvmJ9UpPB-CQBEMAnHvDHXMRhZDVwpi2hWbo0JY_vI7gbx-JTErIIIMO8b-eezWVit-UUsClzPm4k6sxysXgYB65cw6rb8U9QniF9UaBzRBw0TrwoBe9C6CQcg9z2Uw0p5g1FAAto7s6eYNnaWtKk1vZVZ0WQi_0CXyLjkCkqfMzzh04RF2emBGz6ATpn_N2FG04ghjOqD6e0s85cTJg-mlXS-ceafwP1cn-jxIcNs5jsgaTsPYno7s2jnSG4NBCcWTl2-RgssAuVL-IWR6igTRfR0xOiwh4iASQlKd2cnOSmrM6BTibsxfXFMyvU45B-qPJN-6dclLRuLgyxCTVtwzKuw6x8wCCM2r00qU4BhVY98sQqkuOu4SnQjf7ybueE1An2e0O4nW2X_phoE3mMjn2wkjabkQNavOogSwW1qBP7FjFUjF90DnbWlDMbXOEXllfEW01P9-yGI_YQkwiX86TRqQWNPOhmcgQWUgUHKJ69mvAgDiNpY3CAMBtAj28tNWOn1BK9ZiBcAbUNENEEy3QK8ZocMBDZuSa3xwBGdjvVt8zmpxCOL6OQsSK23XobPxJW2vSyricEBExytfLpMPL1JxHQkLiYb_kIC5w4a1ODI4XxRhbclHKDPJ7FVRtUdcgTR72M7csKzJAFR2Aq2oGd9W1ZyrAcRZ-J8PUYem8KuPu__lbvw615Ri4X_elKHXBZZWwmT7CH3zb9Tc7T2H_0jYkI7X9vDRDMZWZB-VqLpIwqsue9dxLxdBMH7wsYL-SC0AeEGJjFVOj8MIyotrkM1RuIGGRgUBxh_YKVxys75FvnY9WI_IfaTmGn4gwOb175ZpH6szlSmKdP_Lh5p3LoEp07Hz17UZdApJqDT_RxtMN9kkTfjs1uSUl8rh4IKJG5lcL6ZeUAycQ8CF8jFCp5RsEqwNwGisN_eixzIZhXzO4eMReixXeipePa6ftUsl7QYKmBD3oGPOsMMfDxjXIro3jxSXEl_VPGic8i8iizNMPh1RV9b762JCLBL7EOy3DrcHH7tg4qjuCmhTth6iEW2MmN9Ycoet2k-Pb7gFN-RFO-f-xGuN_Q4egDc0JjKT6jnssDRyga7uOeR6dbIs5zbyXcbhQ2iqrUZ_aAT0GM8ccpEgvXulK0vOr4vfgTYjfluwHyqdWltHtAQrZEfveX82rVP4gV0ioa0HP1tQ3aE900HNI89j1B6mtDR-p15WO0eM7K8y8sxhAp3XDHFyjQtx8nn44MF4kzo7AUxru_2CsJgOIv5v60KXyrbBYVY6GQugB978idsRX-IMmR7A-3eY_pyMbHDRY9MtPR-VE3VTF_gB1ShZ6PF5nUmIeYBdJrRXUuv03g8NKHsmtTUuJgNX7I"; 
	String lh = "50643"
			+ "";
	public JavascriptExecutor js = (JavascriptExecutor) getDriver();
	//		@BeforeTest
	@BeforeSuite
	@Parameters({"browser"})

	public void setup(String browser) throws InterruptedException, InvalidFormatException, IOException
	{
		System.out.println("Set up");
		if(browser.equalsIgnoreCase("chrome"))
		{
			log.debug("Browser : CHROME");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-notifications");
			if(!lh.equals(""))
				options.setExperimentalOption("debuggerAddress", "localhost:"+lh);
			WebDriverManager.chromedriver().setup();
			//			WebDriverManager.chromedriver().browserVersion("124.0.6367.61").arch32().setup();
			setDriver(new ChromeDriver(options));

		}

		else if (browser.equalsIgnoreCase("firefox")) 
		{
			log.debug("Browser : FIREFOX");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-notifications");
			WebDriverManager.firefoxdriver().setup();
			setDriver(new FirefoxDriver());
		} 

		else if (browser.equalsIgnoreCase("edge")) 
		{
			log.debug("Browser : EDGE");
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-notifications");
			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver());
		}
		else if (browser.equalsIgnoreCase("safari")) 
		{
			log.debug("Browser : SAFARI");
			SafariOptions options = new SafariOptions();
			options.setCapability("safari:automaticInspection", false);
			options.setCapability("safari:automaticProfiling", false);
			options.setCapability("safari:useSimulator", false);
			WebDriverManager.safaridriver().setup();
			setDriver(new SafariDriver());
		}
		createResultFile("./src/src/test/resources/com/ugapp/data/testdata.xlsx", "src/src/test/resources/com/ugapp/excel");
		waitUntilExcelFileIsNotEmpty(System.getProperty("user.dir")+ "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
		getDriver().get(config.getProperty("testsiteurl"));
		log.debug("Navigated to : " + config.getProperty("testsiteurl"));
//		getDriver().manage().window().fullscreen();
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(100));

	}


	@BeforeSuite
	//		@BeforeTest
	@Parameters({"colKey","colValue"})
	public void colNum(String colKey, String colValue) 
	{
		colNumKey = colKey;
		colNumValue = colValue;
		System.out.println("colKey from XML parameter: " + colKey);
		System.out.println("colValue from XML parameter: " + colValue);
		System.out.println("colNumKey assigned: " + colNumKey);
		System.out.println("colNumValue assigned: " + colNumValue);
	}


	//		@AfterTest
	public class DropboxUploader {

		private static final String ACCESS_TOKEN = "your-access-token";

		@AfterSuite
		public void tearDown() throws Exception {
			System.out.println("Quitting...");
			Page page = new Page();
			page.quitBrowser();
			System.out.println("Browser closed");
			uploadTestResultsToDropbox();
			//	        uploadTestDataToDropbox();
		}

		public void uploadTestResultsToDropbox() {
			DbxRequestConfig config = DbxRequestConfig.newBuilder("java-dropbox-example").build();
			DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

			String localFilePath = "./target/surefire-reports/html/extent.html";
			String dropboxFilePath = "/test_results/extent.html";

			try {
				ensureFolderExists(client, "/test_results");
				uploadFile(client, localFilePath, dropboxFilePath);
			} catch (IOException | DbxException e) {
				e.printStackTrace();
			}
		}

		public void uploadTestDataToDropbox() {
			DbxRequestConfig config = DbxRequestConfig.newBuilder("java-dropbox-example").build();
			DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

			String localFilePath = "./src/src/test/resources/com/ugapp/excel/testdata.xlsx";
			String dropboxFolderPath = "/test_data/";
			String dropboxFilePath = dropboxFolderPath + "testdata.xlsx";

			try {
				// Ensure folder exists
				ensureFolderExists(client, dropboxFolderPath);

				// Check if file exists locally
				File file = new File(localFilePath);
				if (!file.exists()) {
					System.err.println("File does not exist: " + localFilePath);
					return;
				}

				// Upload the file
				uploadFile(client, localFilePath, dropboxFilePath);
			} catch (IOException | DbxException e) {
				e.printStackTrace();
				System.err.println("Error uploading test data to Dropbox.");
			}
		}


		private void ensureFolderExists(DbxClientV2 client, String folderPath) throws DbxException {
			try {
				client.files().getMetadata(folderPath);
			} catch (DbxException e) {
				client.files().createFolderV2(folderPath);
				System.out.println("Created folder: " + folderPath);
			}
		}

		private void uploadFile(DbxClientV2 client, String localFilePath, String dropboxFilePath) throws IOException, DbxException {
			FileInputStream inputStream = null;
			try {
				inputStream = new FileInputStream(localFilePath);

				FileMetadata metadata = client.files().uploadBuilder(dropboxFilePath)
						.withMode(WriteMode.OVERWRITE)
						.uploadAndFinish(inputStream);

				System.out.println("File uploaded to Dropbox: " + metadata.getPathLower());
			} catch (FileNotFoundException e) {
				System.err.println("File not found: " + localFilePath);
			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
			}
		}
	}


}




