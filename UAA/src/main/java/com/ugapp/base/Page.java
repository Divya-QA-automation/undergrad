package com.ugapp.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.ugapp.utilities.ExcelReader;
import com.ugapp.utilities.ExtentManager;
import com.ugapp.utilities.Utilities;



public class Page extends Variables
{
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static ThreadLocal<Workbook> workbookThreadLocal = new ThreadLocal<>();
	public static JSONObject visaData;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel;
	public static final int MAX_RETRY_ATTEMPTS = 3; // Maximum number of retry attempts
	public static final long RETRY_INTERVAL_MS = 1000; 
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static SoftAssert softAssert = new SoftAssert();
	public  String browser;
	//	public static  String validEmail;
	public static ThreadLocal<String> validEmail = new ThreadLocal<>();
	public static ThreadLocal<String> validPassword= new ThreadLocal<>();
	public static ThreadLocal<String> validInputReEmail= new ThreadLocal<>();
	public static ThreadLocal<String> selectedEmploymentOptionText= new ThreadLocal<>();
	public static ThreadLocal<String> selectedHighSchoolTextforRecentSchool= new ThreadLocal<>();
	public static ThreadLocal<String> RandomGradYear= new ThreadLocal<>();
	public static ThreadLocal<String> Citizenship= new ThreadLocal<>();
	public static ThreadLocal<String> selectedMilitaryStatus  = new ThreadLocal<>();
	public static ThreadLocal<String> SelectedMilitaryStatus_USmemberORveteran  = new ThreadLocal<>();
	

	public JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
		if (getDriver() == null) {
			try {
				fis = new FileInputStream("./src/test/resources/properties/Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis = new FileInputStream("./src/test/resources/properties/OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}



	//Common Keywords
	//To Find Elements
	public WebElement findElement(String locator) {
		WebElement element = null;
		if (locator.endsWith("_CSS")) 
		{
			element = getDriver().findElement(By.cssSelector(OR.getProperty(locator)));
		}
		else if (locator.endsWith("_XPATH")) 
		{
			String loc = OR.getProperty(locator);
			try {
				element = getDriver().findElement(By.xpath(loc));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		} 
		else if (locator.endsWith("_ID")) 
		{
			element = getDriver().findElement(By.id(OR.getProperty(locator)));
		}
		return element;
	}
	//To Click
	public void click(String locator) {
		if (locator.endsWith("_CSS")) {
			getDriver().findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			getDriver().findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			getDriver().findElement(By.id(OR.getProperty(locator))).click();
		}
		log.debug("Clicking on an Element : "+locator);
		test.log(LogStatus.INFO, "Clicking on : " + locator);
	}
	//To Type
	public void type(String locator, String addressLine1) {
		if (locator.endsWith("_CSS")) {
			getDriver().findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(addressLine1);
		} else if (locator.endsWith("_XPATH")) {
			getDriver().findElement(By.xpath(OR.getProperty(locator))).sendKeys(addressLine1);
		} else if (locator.endsWith("_ID")) {
			getDriver().findElement(By.id(OR.getProperty(locator))).sendKeys(addressLine1);
		}
		log.debug("Typing in an Element : "+locator+" entered value as : "+addressLine1);
		test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + addressLine1);
	}
	static WebElement dropdown;
	//To select
	public void select(String locator, String value) {
		if (locator.endsWith("_CSS")) {
			dropdown = getDriver().findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = getDriver().findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = getDriver().findElement(By.id(OR.getProperty(locator)));
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
			getDriver().findElement(by);
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
			getText = getDriver().findElement(By.cssSelector(OR.getProperty(locator))).getText();
		} else if (locator.endsWith("_XPATH")) {
			getText = getDriver().findElement(By.xpath(OR.getProperty(locator))).getText();
		} else if (locator.endsWith("_ID")) {
			getText = getDriver().findElement(By.id(OR.getProperty(locator))).getText();
		}
		log.debug("Text : " + getText);
		return getText;
	}
	//Verify expected and actual
	public static void verifyEquals(String expected, String actual) throws IOException {
		try 
		{
			softAssert.assertEquals(actual, expected);
		} catch (Throwable t) {
			Utilities utilities = new Utilities();
			utilities.captureScreenshot(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\");
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
	public void refreshPage() {
		getDriver().navigate().refresh();
		log.debug("Page refreshed");
	}
	//Navigate Back
	public void navigateBack() {
		getDriver().navigate().back();
	}
	//clear field
	public void clearField(String xpath) {
		WebElement element = getDriver().findElement(By.xpath(xpath));
		element.clear();
	}
	//Quit Browser
	public void quitBrowser()
	{
		if (getDriver() != null) 
		{
			getDriver().quit();
		}
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
				if (number > from)
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
		try {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='position-absolute']")));
		Thread.sleep(1500);
		}
		catch(Exception e) {System.out.println("err");}
	}
	public static void waitTillProgressbarDisappears() throws Throwable
	{
		//		WebDriverWait wait = new WebDriverWait(driver,30);
		try {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@role='progressbar']")));
		Thread.sleep(1500);
		}
		catch(Exception e) {System.out.println("err");}
	}
	
	// Perform keyboard actions based on the OS
	public void performKeyboardAction(WebElement element, String action) {
		Actions actions = new Actions(getDriver());
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
		if (cell == null) {
			return ""; // Return empty string if cell is null
		}

		CellType cellType = cell.getCellType(); // Get the cell type

		switch (cellType) {
		case STRING:
			return cell.getRichStringCellValue().getString();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				// Handle date cells as needed
				// For example, you can format the date to a string
				return cell.getDateCellValue().toString();
			} else {
				return String.valueOf(cell.getNumericCellValue());
			}
		case BOOLEAN:
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
	public static synchronized void initializeWriteExcelSheets(String inputFilePath) throws IOException, InvalidFormatException {
		try {
			FileInputStream fis = new FileInputStream(inputFilePath);
			Workbook workbook = WorkbookFactory.create(fis);
			workbookThreadLocal.set(workbook);
//			System.out.println("Iniitialized the excel sheet successfully.");
		} catch (IOException e) {
			System.err.println("Error initializing the report: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
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

	public static synchronized void setExcelData(String colKey, String colValue, String sheetname, int rownum, String key, String... values) throws IOException {
		Workbook workbook = workbookThreadLocal.get();
		try {
			int columnKey = Integer.parseInt(colKey);
			int columnValue = Integer.parseInt(colValue);

			Sheet sheet = workbook.getSheet(sheetname);
			Row row = sheet.getRow(rownum);
			if (row == null) {
				row = sheet.createRow(rownum);
			}

			Cell keyCell = row.createCell(columnKey);
			keyCell.setCellValue(key);

			if (values != null && values.length > 0) {
				Cell valueCell = row.createCell(columnValue);
				CellStyle cellStyle = workbook.createCellStyle();
				cellStyle.setWrapText(true);
				valueCell.setCellStyle(cellStyle);

				StringBuilder valuesBuilder = new StringBuilder();
				for (String value : values) {
					valuesBuilder.append(value).append("\n");
				}
				valuesBuilder.setLength(valuesBuilder.length() - 1);
				valueCell.setCellValue(valuesBuilder.toString());
			}
		} catch (NumberFormatException e) {
			// Handle the exception appropriately, for example:
			e.printStackTrace();
			// Or log the error
			log.error("NumberFormatException: " + e.getMessage());
		}
	}




	public static synchronized void saveReport(String inputFilePath) throws IOException {
		try {
			Workbook workbook = workbookThreadLocal.get();
			FileOutputStream fos = new FileOutputStream(inputFilePath);
			workbook.write(fos);
			fos.close();
//			System.out.println("Report saved successfully.");
		} catch (IOException e) {
			System.err.println("Error saving the report: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}


	public static void waitUntilExcelFileIsNotEmpty(String inputFilePath) throws InterruptedException {
		while (isExcelFileEmpty(inputFilePath)) {
			Thread.sleep(10000); // Adjust sleep duration as needed
		}
	}



	public static boolean isExcelFileEmpty(String inputFilePath) {
		try {
			FileInputStream fis = new FileInputStream(inputFilePath);
			int byteCount = fis.available();
			fis.close();
			return byteCount == 0;
		} catch (IOException e) {
			e.printStackTrace();
			return true; // Treat exceptions as if the file is empty
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




	static 
	{
		try {
			// Read JSON data from the file
			String jsonData = new String(Files.readAllBytes(Paths.get("/Users/divyashree/UAA/src/src/test/resources/com/ugapp/Visa_eligibility/Visa eligibility.json")));

			visaData = new JSONObject(jsonData);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error initializing VisaTypeChecker", e);
		}
	}

	public static String findVisaType(String visaText) 
	{
		JSONArray validVisas = visaData.getJSONArray("validVisa");
		JSONArray invalidVisas = visaData.getJSONArray("invalidVisa");

		for (int i = 0; i < validVisas.length(); i++) {
			JSONObject visa = validVisas.getJSONObject(i);
			if (visa.getString("text").equals(visaText)) {
				return "Valid Visa";
			}
		}

		for (int i = 0; i < invalidVisas.length(); i++) {
			JSONObject visa = invalidVisas.getJSONObject(i);
			if (visa.getString("text").equals(visaText)) {
				return "Invalid Visa";
			}
		}

		return "Visa not found";
	}



	// Method to fetch the State Code
	public static String findStateCode(String country, String state)
	{
		String jsonFilePath = "./src/src/test/resources/com/ugapp/states/"+country+".json";
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
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return state;

	}


	// Method to fetch the Country Code
	public static String findCountryCode(String country) {
		String jsonFilePath = "./src/src/test/resources/com/ugapp/states/"+country+".json";
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
	public static void CompareExcelSheets(String excelPath, String sheet1Name, String sheet2Name, int colKey, int colValue) throws IOException {
		// Load Excel workbook
		Workbook workbook = new XSSFWorkbook(new FileInputStream(excelPath));


		// Get the specified sheets
		Sheet sheet1 = workbook.getSheet(sheet1Name);
		Sheet sheet2 = workbook.getSheet(sheet2Name);


		// Read key-value pairs from specified columns
		Map<String, String> data1 = readKeyValuePairs(sheet1, colKey, colValue);
		Map<String, String> data2 = readKeyValuePairs(sheet2, colKey, colValue);


		// Compare key-value pairs and print only mismatches
		for (Map.Entry<String, String> entry : data1.entrySet()) {
			String key = entry.getKey();
			String value1 = entry.getValue();
			String value2 = data2.get(key);


			if (value2 != null && !value1.equals(value2)) {
				System.out.println("Mismatch - Key: " + key + ", Value Sheet 1: " + value1 + ", Value Sheet 2: " + value2);
			}
		}


		// Close workbook
		//	        workbook.close();
	}

	//	 public static void CompareAndWriteMismatches(String excelPath, String sheet1Name, String sheet2Name, int colKey, int colValue, int totalRuns) throws IOException {
	//		    // Load Excel workbook
	//		    Workbook workbook = new XSSFWorkbook(new FileInputStream(excelPath));
	//		    // Get the specified sheets
	//		    Sheet sheet1 = workbook.getSheet(sheet1Name);
	//		    Sheet sheet2 = workbook.getSheet(sheet2Name);
	//		    // Read key-value pairs from specified columns
	//		    Map<String, String> data1 = readKeyValuePairs(sheet1, colKey, colValue);
	//		    Map<String, String> data2 = readKeyValuePairs(sheet2, colKey, colValue);
	//		    // Loop through runs to create mismatch sheets
	//		    for (int runNumber = 1; runNumber <= totalRuns; runNumber++) {
	//		        // Create a new sheet for mismatches with a dynamic name
	//		        String shortSheet1Name = sheet1Name.substring(0, Math.min(sheet1Name.length(), 5)); // Adjust the length as needed
	//		        String shortSheet2Name = sheet2Name.substring(0, Math.min(sheet2Name.length(), 5)); // Adjust the length as needed
	//		        String mismatchSheetNameBase = "Mismatch_0" + runNumber + "_" + shortSheet1Name + "_vs_" + shortSheet2Name;
	//		        String mismatchSheetName = mismatchSheetNameBase;
	//		        // Check if a sheet with the same name already exists
	//		        int counter = 1;
	//		        while (workbook.getSheet(mismatchSheetName) != null) {
	//		            mismatchSheetName = mismatchSheetNameBase + "_" + counter;
	//		            counter++;
	//		        }
	//		        // Create the new sheet
	//		        Sheet mismatchSheet = workbook.createSheet(mismatchSheetName);
	//		        // Create header row for mismatch sheet
	//		        Row headerRow = mismatchSheet.createRow(0);
	//		        headerRow.createCell(0).setCellValue("Key");
	//		        headerRow.createCell(1).setCellValue("Value Sheet 1");
	//		        headerRow.createCell(2).setCellValue("Value Sheet 2");
	//		        int rowIndex = 1; // Start from the second row for data
	//		        // Compare key-value pairs and print/write mismatches
	//		        for (Map.Entry<String, String> entry : data1.entrySet()) {
	//		            String key = entry.getKey();
	//		            String value1 = entry.getValue();
	//		            String value2 = data2.get(key);
	//		            if (value2 != null && !value1.equals(value2)) {
	//		                System.out.println("Mismatch - Key: " + key + ", Value Sheet 1: " + value1 + ", Value Sheet 2: " + value2);
	//		                log.debug("Mismatch - Key: " + key + ", Value Sheet 1: " + value1 + ", Value Sheet 2: " + value2);
	//		                // Write to the new sheet
	//		                Row mismatchRow = mismatchSheet.createRow(rowIndex++);
	//		                mismatchRow.createCell(0).setCellValue(key);
	//		                mismatchRow.createCell(1).setCellValue(value1);
	//		                mismatchRow.createCell(2).setCellValue(value2);
	//		            }
	//		        }
	//		    }
	//		    // Save the changes to the workbook
	//		    try (FileOutputStream fileOut = new FileOutputStream(excelPath)) {
	//		        workbook.write(fileOut);
	//		    }
	//		    // Close workbook
	////		    workbook.close();
	//		}
	//	



	public static void CompareAndWriteMismatches(String excelPath, String sheet1Name, String sheet2Name, int colKey, int colValue, int totalRuns) throws IOException {
		// Load Excel workbook
		Workbook workbook = new XSSFWorkbook(new FileInputStream(excelPath));
		// Get the specified sheets
		Sheet sheet1 = workbook.getSheet(sheet1Name);
		Sheet sheet2 = workbook.getSheet(sheet2Name);
		// Read key-value pairs from specified columns
		Map<String, String> data1 = readKeyValuePairs(sheet1, colKey, colValue);
		Map<String, String> data2 = readKeyValuePairs(sheet2, colKey, colValue);

		// Flag to check if any mismatches are found
		boolean mismatchesFound = false;

		// Loop through runs to create mismatch sheets
		for (int runNumber = 1; runNumber <= totalRuns; runNumber++) {
			// Create a new sheet for mismatches with a dynamic name
			String shortSheet1Name = sheet1Name.substring(0, Math.min(sheet1Name.length(), 5)); // Adjust the length as needed
			String shortSheet2Name = sheet2Name.substring(0, Math.min(sheet2Name.length(), 5)); // Adjust the length as needed
			String mismatchSheetNameBase = "Mismatch_0" + runNumber + "_" + shortSheet1Name + "_vs_" + shortSheet2Name;
			String mismatchSheetName = mismatchSheetNameBase;
			// Check if a sheet with the same name already exists
			int counter = 1;
			while (workbook.getSheet(mismatchSheetName) != null) {
				mismatchSheetName = mismatchSheetNameBase + "_" + counter;
				counter++;
			}
			// Create the new sheet
			Sheet mismatchSheet = workbook.createSheet(mismatchSheetName);
			// Create header row for mismatch sheet
			Row headerRow = mismatchSheet.createRow(0);
			headerRow.createCell(0).setCellValue("Key");
			headerRow.createCell(1).setCellValue("Value Sheet 1");
			headerRow.createCell(2).setCellValue("Value Sheet 2");
			int rowIndex = 1; // Start from the second row for data
			// Compare key-value pairs and print/write mismatches
			for (Map.Entry<String, String> entry : data1.entrySet()) {
				String key = entry.getKey();
				String value1 = entry.getValue();
				String value2 = data2.get(key);
				if (value2 != null && !value1.equals(value2)) {
					mismatchesFound = true;
					System.out.println("Mismatch - Key: " + key + ", Value Sheet 1: " + value1 + ", Value Sheet 2: " + value2);
					log.debug("Mismatch - Key: " + key + ", Value Sheet 1: " + value1 + ", Value Sheet 2: " + value2);
					// Write to the new sheet
					Row mismatchRow = mismatchSheet.createRow(rowIndex++);
					mismatchRow.createCell(0).setCellValue(key);
					mismatchRow.createCell(1).setCellValue(value1);
					mismatchRow.createCell(2).setCellValue(value2);
				}
			}
		}

		// Save the changes to the workbook only if mismatches are found
		if (mismatchesFound) {
			try (FileOutputStream fileOut = new FileOutputStream(excelPath)) {
				workbook.write(fileOut);
			}
		}

		// Close workbook
		//		    workbook.close();
	}


	private static Map<String, String> readKeyValuePairs(Sheet sheet, int colKey, int colValue) {
		Map<String, String> data = new HashMap<>();
		for (Row row : sheet) {
			Cell keyCell = row.getCell(colKey);
			Cell valueCell = row.getCell(colValue);
			if (keyCell != null && valueCell != null) {
				String key = keyCell.toString().trim();
				String value = valueCell.toString().trim();
				data.put(key, value);
			}
		}
		return data;
	}



	public void setDriver(WebDriver dvr)
	{
		driver.set(dvr);
	}

	public WebDriver getDriver()
	{
		return this.driver.get();
	}

	public void createResultFile(String src, String des)
	{
		File source = new File(src);
		File dest = new File(des);
		try {
			FileUtils.copyFileToDirectory(source, dest);
		} catch (IOException e) {}

	}
	public WebElement retryUntilStable(Supplier<WebElement> action) throws InterruptedException {
	    int attempts = 0;
	    while (attempts < MAX_RETRY_ATTEMPTS) {
	        try {
	            return action.get();
	        } catch (StaleElementReferenceException e) {
	            Thread.sleep(RETRY_INTERVAL_MS);
	        }
	        attempts++;
	    }
	    throw new RuntimeException("Element not stable after retrying");
	}
	
	
	
}






