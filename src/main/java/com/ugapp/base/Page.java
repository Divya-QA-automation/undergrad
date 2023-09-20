package com.ugapp.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ugapp.utilities.ExcelReader;
import com.ugapp.utilities.ExtentManager;
import com.ugapp.utilities.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page 
{

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	public static String validEmail;
	public static String validPassword;
	public static String validInputReEmail;

	/*
	 * Logs,
	 * Properties - OR, Config
	 * Excel
	 * Implicit and ExplicitWait
	 * Extent Reports
	 * Common Keywords
	 * Driver Quit
	 */

	public Page() {
		
		
		if (driver == null) {

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "//src//test//resources//com//ugapp//properties//Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "//src//test//resources//com//ugapp//properties//OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//Jenkins Browser filter configuration
			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				browser = System.getenv("browser");
			} else {

				browser = config.getProperty("browser");

			}

			config.setProperty("browser", browser);
			
			
			if (config.getProperty("browser").equals("firefox")) {

				// System.setProperty("webdriver.gecko.driver", "gecko.exe");
				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("chrome")) {
			
//			System.setProperty("webdriver.chrome.driver",
//					System.getProperty("user.dir") + "//src//test//resources//com//ugapp//executables//chromedriver.exe");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			}else if (config.getProperty("browser").equals("ie")) {

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "//src//test//resources//executables//IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to : " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, Duration.ofSeconds(100)); 
			
		}
	}
		
	//Common Keywords
//To Find Elements
	public WebElement findElement(String locator) {
	    WebElement element = null;
	    
	    if (locator.endsWith("_CSS")) {
	        element = driver.findElement(By.cssSelector(OR.getProperty(locator)));
	    } else if (locator.endsWith("_XPATH")) {
	        element = driver.findElement(By.xpath(OR.getProperty(locator)));
	    } else if (locator.endsWith("_ID")) {
	        element = driver.findElement(By.id(OR.getProperty(locator)));
	    }
	    
	    return element;
	}

//To Click
	public static void click(String locator) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
		log.debug("Clicking on an Element : "+locator);
		test.log(LogStatus.INFO, "Clicking on : " + locator);
	}

//To Type
	public static void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}

		log.debug("Typing in an Element : "+locator+" entered value as : "+value);
		
		test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + value);

	}
	
	static WebElement dropdown;

//To select
	public void select(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}
		
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		log.debug("Selecting from an element : "+locator+" value as : "+value);
		test.log(LogStatus.INFO, "Selecting from dropdown : " + locator + " value as " + value);

	}

// To check if element is present 
	public boolean isElementPresent(String locator) {
	    By by = getByLocator(locator);
	    try {
	        driver.findElement(by);
	        log.debug("Element is present: " + locator);
	        test.log(LogStatus.INFO, "Element is present: " + locator);
	        return true;
	    } catch (NoSuchElementException e) {
	        log.debug("Element is not present: " + locator);
	        test.log(LogStatus.INFO, "Element is not present: " + locator);
	        return false;
	    }
	}

	private By getByLocator(String locator) {
	    if (locator.endsWith("_CSS")) {
	        return By.cssSelector(OR.getProperty(locator));
	    } else if (locator.endsWith("_XPATH")) {
	        return By.xpath(OR.getProperty(locator));
	    } else if (locator.endsWith("_ID")) {
	        return By.id(OR.getProperty(locator));
	    } else {
	        throw new IllegalArgumentException("Invalid locator type: " + locator);
	    }
	}

//To get Text 	
	public String getText(String locator) {
	    String getText = "";	
	    if (locator.endsWith("_CSS")) {
	    	getText = driver.findElement(By.cssSelector(OR.getProperty(locator))).getText();
	    } else if (locator.endsWith("_XPATH")) {
	    	getText = driver.findElement(By.xpath(OR.getProperty(locator))).getText();
	    } else if (locator.endsWith("_ID")) {
	    	getText = driver.findElement(By.id(OR.getProperty(locator))).getText();
	    }
	    log.debug("Text : " + getText);
	    return getText;
	}

	//Verify expected and actual
	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			Utilities.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Reports
			test.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));

		}

}
	//Refresh Page
	public static void refreshPage() {
        driver.navigate().refresh();
        log.debug("Page refreshed");
    }
	
	//Navigate Back
	public static void navigateBack() {
	driver.navigate().back();
	}
	
	//clear field 
	public void clearField(String xpath) {
	    WebElement element = driver.findElement(By.xpath(xpath));
	    element.clear();
	}

	
	//Quit Browser
	public static void quitBrowser(){
		
		driver.quit();
		
	}
	// Perform keyboard actions based on the OS
	public static void performKeyboardAction(WebElement element, String action) {
	    Actions actions = new Actions(driver);
	    
	    // Determine the appropriate key combinations based on the action and OS
	    if (System.getProperty("os.name").toLowerCase().contains("windows")) {
	    	System.out.println("OKay working");
	        if (action.equalsIgnoreCase("copy")) {
	            actions.keyDown(element, Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
	        } else if (action.equalsIgnoreCase("paste")) {
	            actions.keyDown(element, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
	        } else if (action.equalsIgnoreCase("clear")) {
	        	System.out.println("Inside performKeyboardAction");
	            actions.keyDown(element, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
	        } else {
	            // Handle other actions as needed
	        }
	    } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
	        if (action.equalsIgnoreCase("copy")) {
	            actions.keyDown(element, Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).build().perform();
	        } else if (action.equalsIgnoreCase("paste")) {
	            actions.keyDown(element, Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).build().perform();
	        } else if (action.equalsIgnoreCase("clear")) {
	            actions.keyDown(element, Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.DELETE).build().perform();
	        } else {
	            // Handle other actions as needed
	        }
	    }
	}

}
