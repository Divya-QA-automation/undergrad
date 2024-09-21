package com.ugapp.testcases;


import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ugapp.base.Page;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest extends Page
{
	String lh = "";

	//	@BeforeTest
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
		getDriver().manage().window().fullscreen();
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

	}

	//	@BeforeMethod
	//	public void setUp() throws InterruptedException, InvalidFormatException, IOException {
	//		waitUntilExcelFileIsNotEmpty(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	//		initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	//	}

	//		public  ThreadLocal<Page> excelHandlerThreadLocal = ThreadLocal.withInitial(() -> {
	//		    BaseTest handler = new BaseTest();
	//		    try {
	//				
	//		    Page.waitUntilExcelFileIsNotEmpty(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	//			System.out.println("waitUntilExcelFileIsNotEmpty");
	//		    } catch (InterruptedException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//		    try {
	//				Page.initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	//				System.out.println("initializeWriteExcelSheets");
	//		    } catch (InvalidFormatException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			} catch (IOException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//		    return handler;
	//		});
	//		
	//		private  ThreadLocal<Page> excelHandlerThreadLocal1 = ThreadLocal.withInitial(() -> {
	//		    BaseTest handler = new BaseTest();
	//		    try {
	//				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	//				System.out.println("saveReport");
	//		    } catch (IOException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//		     
	//		    return handler;
	//		});
	//		
	//		@BeforeMethod
	//		public void setUp() {
	//		    excelHandlerThreadLocal.get();
	//		}
	//		
	//		
	//		
	//	
	//		@AfterMethod
	//		public void teardown() throws IOException 
	//		{
	//			  excelHandlerThreadLocal1.get();
	//		}
	// 

	@BeforeSuite
	//	@BeforeTest
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
	//	@AfterSuite
	public void tearDown() throws Exception
	{
		System.out.println("Quitting..");
		Page page = new Page();
		page.quitBrowser();
		System.out.println("Browser closed");
		System.out.println("After Browser closed");
		SlackIntegration slack  =new SlackIntegration();
		slack.testSlackIntegration();
		Test123 slack1  =new Test123();
		slack1.uploadFile();
		gChat G_Chat = new gChat();
		System.out.println("In G-chat");
		G_Chat.googleChat();

	}



}




