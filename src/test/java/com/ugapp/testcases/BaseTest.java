package com.ugapp.testcases;


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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.ugapp.base.Page;


import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest extends Page{

	String lh = "";
	@BeforeTest
	@Parameters({"browser"})
	public void setup(String browser)
	{
		System.out.println("Set up");
		if(browser.equalsIgnoreCase("chrome"))
		{
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
			if(!lh.equals(""))
				options.setExperimentalOption("debuggerAddress", "localhost:"+lh);
			WebDriverManager.chromedriver().setup();
			setDriver(new ChromeDriver(options));
			System.out.println("Chrome");
		}


		else if (browser.equalsIgnoreCase("firefox")) 
		{
			log.debug("Browser : FIREFOX");

			FirefoxOptions options = new FirefoxOptions();

			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			WebDriverManager.firefoxdriver().setup();
			setDriver(new FirefoxDriver());
			System.out.println("Firefox");
		} 

		else if (browser.equalsIgnoreCase("edge")) 
		{
			log.debug("Browser : EDGE");
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			WebDriverManager.edgedriver().setup();
			System.out.println("Edge");
			setDriver(new EdgeDriver());
			System.out.println("Edge");
		}
		getDriver().get("https://apply-qa.apps.asu.edu");
		log.debug("Navigated to :https://apply-qa.apps.asu.edu" );
		//		driver.manage().window().fullscreen();
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(100));

	}




	@BeforeTest
	@Parameters({"colKey","colValue"})
	public void colNum(String colKey,String colValue)
	{
		colNumKey = colKey;
		colNumValue = colValue;
		System.out.println("colNumKey :"+colNumKey);
		System.out.println("colNumValue :"+colNumValue);
	}


	@AfterTest
	public void tearDown()
	{
		System.out.println("Quitting..");
		Page page = new Page();
		page.quitBrowser();
		System.out.println("Browser closed");
		SlackIntegration slack  =new SlackIntegration();
		slack.c2S();

	}



}




