package com.ugapp.base;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import org.openqa.selenium.JavascriptExecutor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ugapp.utilities.ExcelReader;
import com.ugapp.utilities.ExtentManager;
import com.ugapp.utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
public class Page extends Variables
{
	String lh = "52356";
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
	public static String selectedEmploymentOptionText;

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
				driver = new ChromeDriver(options);
			}else if (config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "//src//test//resources//executables//IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
//			driver.get(config.getProperty("testsiteurl"));
//			log.debug("Navigated to : " + config.getProperty("testsiteurl"));
			driver.manage().window().fullscreen();
			wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		}
	}
	//Common Keywords
	//To Find Elements
	public static WebElement findElement(String locator) {
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
	public static void type(String locator, String addressLine1) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(addressLine1);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(addressLine1);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(addressLine1);
		}
		log.debug("Typing in an Element : "+locator+" entered value as : "+addressLine1);
		test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + addressLine1);
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
	public static ArrayList<Integer> getRandomNumber(int from, int to, int count) {
		Random r = new Random();
		if(count>to)
		{
			count=to;
		}
		Set<Integer> list = new TreeSet<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		int number;
		while (list.size() < count) {
			while (true) {
				number = r.nextInt(to + 1);
				if (number >= from)
					break;
			}
			list.add(number);
		}
		list2.addAll(list);
		Collections.sort(list2);
		return list2;
	}
	public static void scrollDown(WebDriver driver, int times) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		for (int i = 0; i < times; i++) {
			jsExecutor.executeScript("window.scrollBy(0, 500);");
			log.debug("Scrolled down");
			try {
				Thread.sleep(1000); // Add a delay between scrolls (optional)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}}
	public static void scrollUp(WebDriver driver, int times) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		for (int i = 0; i < times; i++) {
			jsExecutor.executeScript("window.scrollBy(0, -500);");
			log.debug("Scrolled Up");
			try {
				Thread.sleep(1000); // Add a delay between scrolls (optional)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void waitTillLoaderDisappears() throws Throwable
	{
//		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='position-absolute']")));
		Thread.sleep(1500);
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
	public static void writeToExcel(String filePath, String sheetName, List<Map.Entry<String, List<String>>> data) {
		try {
			// Load the Excel file
			FileInputStream inputStream = new FileInputStream(new File(filePath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			// Access the specific sheet by name
			Sheet sheet = workbook.getSheet(sheetName);
			// Write the key-value pairs to the Excel sheet
			int rowNum = 0; // Starting row index
			for (Map.Entry<String, List<String>> entry : data) {
				Row row = sheet.createRow(rowNum++);
				// Key in the first column
				Cell keyCell = row.createCell(0);
				keyCell.setCellValue(entry.getKey());
				// Values in the second column
				Cell valueCell = row.createCell(1);
				// Check if this entry has multiple values
				List<String> values = entry.getValue();
				if (values.size() > 1) {
					// Create a StringBuilder to build the text with line breaks
					StringBuilder valuesText = new StringBuilder();
					for (String value : values) {
						valuesText.append(value).append("\n"); // Add each value with a line break
					}
					valueCell.setCellValue(valuesText.toString());
					// Set the cell as a multi-line text cell
					CellStyle cellStyle = workbook.createCellStyle();
					cellStyle.setWrapText(true);
					valueCell.setCellStyle(cellStyle);
				} else {
					// If only one value, store it as is
					valueCell.setCellValue(values.get(0));
				}
			}
			// Save the changes back to the Excel file
			FileOutputStream outputStream = new FileOutputStream(filePath);
			workbook.write(outputStream);
			outputStream.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//compare two excel sheets
	public static void compareExcelSheets(String filePath1, String sheetName1, String filePath2, String sheetName2) {
		try {
			// Load the first Excel file
			FileInputStream inputStream1 = new FileInputStream(new File(filePath1));
			Workbook workbook1 = new XSSFWorkbook(inputStream1);
			// Load the second Excel file
			FileInputStream inputStream2 = new FileInputStream(new File(filePath2));
			Workbook workbook2 = new XSSFWorkbook(inputStream2);
			// Access the specific sheets by name in both files
			Sheet sheet1 = workbook1.getSheet(sheetName1);
			Sheet sheet2 = workbook2.getSheet(sheetName2);
			// Compare the number of rows in both sheets
			int numRows1 = sheet1.getPhysicalNumberOfRows();
			int numRows2 = sheet2.getPhysicalNumberOfRows();
			int numCols1 = sheet1.getRow(0).getPhysicalNumberOfCells();
			int numCols2 = sheet2.getRow(0).getPhysicalNumberOfCells();
			if (numRows1 != numRows2 || numCols1 != numCols2) {
				System.out.println("Sheets have different dimensions.");
				return;
			}
			// Compare the content of each cell in both sheets
			boolean sheetsAreEqual = true;
			for (int i = 0; i < numRows1; i++) {
				Row row1 = sheet1.getRow(i);
				Row row2 = sheet2.getRow(i);
				for (int j = 0; j < numCols1; j++) {
					Cell cell1 = row1.getCell(j);
					Cell cell2 = row2.getCell(j);
					String cell1Value = getCellContentsAsString(cell1);
					String cell2Value = getCellContentsAsString(cell2);
					if (!cell1Value.equals(cell2Value)) {
						Cell keyCell1 = row1.getCell(0);
						Cell keyCell2 = row2.getCell(0);
						System.out.println("Difference at Row " + (i + 1) + ", Column " + (j + 1));
						System.out.println("Sheet 1 Key: " + keyCell1);
						System.out.println("Sheet 1 Value: " + cell1Value);
						System.out.println("Sheet 2 Key: " + keyCell2);
						System.out.println("Sheet 2 Value: " + cell2Value);
						sheetsAreEqual = false;
					}
				}
			}
			if (sheetsAreEqual) {
				System.out.println("Sheets are identical.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Helper method to get cell contents as a string
	public static String getCellContentsAsString(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getRichStringCellValue().getString();
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				// Handle date cells as needed
				// For example, you can format the date to a string
				return cell.getDateCellValue().toString();
			} else {
				return String.valueOf(cell.getNumericCellValue());
			}
		case Cell.CELL_TYPE_BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		default:
			return "";
		}
	}
	public static void initializeReadExcelSheets(String inputFilePath) throws EncryptedDocumentException, Exception
	{
		fis = new FileInputStream(inputFilePath);
		wb = WorkbookFactory.create(fis);
		fos = new FileOutputStream(inputFilePath);
	}
	public static void initializeWriteExcelSheets(String inputFilePath) throws EncryptedDocumentException, Exception
	{
		fis1 = new FileInputStream(inputFilePath);
		wb1 = WorkbookFactory.create(fis1);
		fos1 = new FileOutputStream(inputFilePath);
	}
	public static String getExcelData(String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException
	{
		String value=null;
		try {
			value= wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		}
		catch(Exception e)
		{
			value=wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
		}
		return value;	
	}
	public static void setExcelData(String sheetname, int rownum, String key, String... values) throws EncryptedDocumentException, IOException {
		Row row = wb1.getSheet(sheetname).getRow(rownum);
		if (row == null) {
			row = wb1.getSheet(sheetname).createRow(rownum);
		}
		// Create a new cell for the "key" and set the value
		Cell keyCell = row.createCell(0); // Assuming "key" column is at index 0
		keyCell.setCellValue(key);
		// Create a new cell for the "values" and set them with line breaks
		if (values != null && values.length > 0) {
			Cell valueCell = row.createCell(1); // Assuming "value" column is at index 1
			CellStyle cellStyle = wb1.createCellStyle();
			cellStyle.setWrapText(true); // Enable text wrapping in the cell
			valueCell.setCellStyle(cellStyle);
			StringBuilder valuesBuilder = new StringBuilder();
			for (String value : values) {
				valuesBuilder.append(value).append("\n"); // Use line breaks to separate values
			}
			valuesBuilder.setLength(valuesBuilder.length() - 1); // Remove the trailing line break
			valueCell.setCellValue(valuesBuilder.toString());
		}
	}
	public static void saveReport() throws IOException, InterruptedException
	{
		try {
			//copying data from data sheet
			wb.write(fos);
			fos.close();
			//			wb.close();
		}
		catch(Exception e) {
		}
		try {
			// Writing results to index sheet
			wb1.write(fos1);
			fos1.close();
			//			wb1.close();
		}
		catch(Exception e) {
		}
	}


	
	public static String getCurrentDate() {
        // Create a SimpleDateFormat for the desired output format
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);

        // Get the current date
        Date currentDate = new Date();

        // Format the current date in the desired output format
        String formattedDate = dateFormat.format(currentDate);

        return formattedDate;
    }
	
	

	// Method to fetch the State Code
	public static String findStateCode(String country, String state)
	{
		String jsonFilePath = "./src/test/resources/com/ugapp/states/"+country+".json";
		String jsonString = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(jsonFilePath));
			StringWriter jsonStringWriter = new StringWriter();
			String line;
			while ((line = reader.readLine()) != null) {
				jsonStringWriter.write(line);
			}
			reader.close();
			jsonString = jsonStringWriter.toString();
		}
		catch(Exception e) {}
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			JSONArray statesArray = jsonObject.getJSONArray("states");
			for (int i = 0; i < statesArray.length(); i++)
			{
				JSONObject stateObject = statesArray.getJSONObject(i);
				String description = stateObject.getString("description");
				if (description.equalsIgnoreCase(state))
				{
					return stateObject.getString("stateCode");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "State code not found for description: " + state;
	}

	// Method to fetch the Country Code
	public static String findCountryCode(String country) {
		String jsonFilePath = "./src/test/resources/com/ugapp/states/"+country+".json";
		String jsonString = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(jsonFilePath));
			StringWriter jsonStringWriter = new StringWriter();
			String line;
			while ((line = reader.readLine()) != null) {
				jsonStringWriter.write(line);
			}
			reader.close();
			jsonString = jsonStringWriter.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			JSONObject jsonObject = new JSONObject(jsonString);

			String description = jsonObject.getString("description");
			if (description.equalsIgnoreCase(country))
			{
				return jsonObject.getString("countryCode");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Country code not found for description: " + country;
	}

}


