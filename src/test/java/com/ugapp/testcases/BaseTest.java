package com.ugapp.testcases;


import org.testng.annotations.AfterMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.ugapp.base.Page;
import com.ugapp.base.Variables;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest extends Page
{
	String lh = "";
//	@BeforeTest
		@BeforeSuite
	@Parameters({"browser"})

	public void setup(String browser)
	{
		System.out.println("Set up");
		if(browser.equalsIgnoreCase("chrome"))
		{
			//			WebDriverManager.chromedriver().setup();
			//			// Create ChromeOptions and set the device name for mobile emulation
			//			ChromeOptions options = new ChromeOptions();
			//			options.addArguments("--enable-automation");
			////			options.addArguments("--headless");
			//			options.addArguments("--window-size=375,667");
			//			options.addArguments("--disable-gpu");
			//			options.addArguments("--no-sandbox");
			//			options.addArguments("--disable-dev-shm-usage");
			//			options.addArguments("--disable-extensions");
			//			options.addArguments("--disable-infobars");
			//			options.addArguments("--disable-features=NetworkService");
			//
			//			// Set the device name for mobile emulation
			//			options.addArguments("--device-name=iPhone X");
			//
			//			setDriver(new ChromeDriver(options));
			//			System.out.println("Chrome");


			log.debug("Browser : CHROME");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//src//test//resources//com//ugapp//executables//chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-notifications");
			if(!lh.equals(""))
				options.setExperimentalOption("debuggerAddress", "localhost:"+lh);
			WebDriverManager.chromedriver().setup();
			setDriver(new ChromeDriver(options));
			
			createResultFile("./src/test/resources/com/ugapp/data/testdata.xlsx", "src/test/resources/com/ugapp/excel");
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

				getDriver().get(config.getProperty("testsiteurl"));
				log.debug("Navigated to : " + config.getProperty("testsiteurl"));
		//		getDriver().manage().window().fullscreen();
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));

	}




		@BeforeSuite
//	@BeforeTest
	@Parameters({"colKey","colValue"})
	public void colNum(String colKey,String colValue)
	{
		colNumKey=colKey;
		colNumValue=colValue;
		System.out.println("colNumKey :"+colNumKey);
		System.out.println("colNumValue :"+colNumValue);
	}


//	@AfterTest
		@AfterSuite
	public void tearDown() throws Exception
	{
		System.out.println("Quitting..");
		Page page = new Page();
		page.quitBrowser();
		System.out.println("Browser closed");
		System.out.println("After Browser closed");
		//		SlackIntegration slack  =new SlackIntegration();
		//		slack.testSlackIntegration();
		//		Test123 slack1  =new Test123();
		//		slack1.uploadFile();
		//		gChat G_Chat = new gChat();
		//		System.out.println("In G-chat");
		//		G_Chat.googleChat();

	}



}




