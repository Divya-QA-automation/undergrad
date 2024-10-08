package com.ugapp.utilities;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.DataProvider;

import com.ugapp.base.Page;

public class Utilities extends Page {

	public static String screenshotPath;
	public static String screenshotName;

	public  String captureScreenshot(String filePath) throws WebDriverException {
		try {
			File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

			Date d = new Date();
			screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

			// Log the screenshot name for debugging
			System.out.println("Screenshot Name: " + screenshotName);

			FileUtils.copyFile(scrFile, new File(filePath));
			System.out.println("Screenshot captured successfully at: " + filePath + screenshotName);
		} catch (IOException e) {
			// Log the exception for debugging
			System.err.println("Exception occurred while capturing screenshot:");
			e.printStackTrace();
		}
		return filePath;
	}

		@DataProvider(name="dp")
		public Object[][] getData(Method m)
		{
			excel = new ExcelReader(
					System.getProperty("user.dir") + "//src//src//test//resources//com//ugapp//excel//testdata.xlsx");
			String sheetName = m.getName();
			int rows = excel.getRowCount(sheetName);
			int cols = excel.getColumnCount(sheetName);
	
			Object[][] data = new Object[rows - 1][1];
	
			Hashtable<String,String> table = null;
	
			for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2
	
				table = new Hashtable<String,String>();
	
				for (int colNum = 0; colNum < cols; colNum++) {
	
					// data[0][0]
					table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
					data[rowNum - 2][0] = table;
				}
	
			}
	
			return data;
	
		}


//	@DataProvider(name = "dp")
//	public Object[][] getData(Method m) {
//		excel = new ExcelReader(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//		String sheetName = m.getName();
//		int rows = excel.getRowCount(sheetName);
//		int cols = excel.getColumnCount(sheetName);
//
//		Object[][] data = new Object[rows - 1][cols]; // Initialize the data array
//
//		for (int rowNum = 2; rowNum <= rows; rowNum++) {
//			for (int colNum = 0; colNum < cols; colNum++) {
//				// Populate the data array with cell values from the Excel sheet
//				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
//			}
//		}
//
//		return data;
//	}













	//	public static boolean isTestRunnable(String testName, ExcelReader excel){
	//		
	//		String sheetName="test_suite";
	//		int rows = excel.getRowCount(sheetName);
	//		
	//		
	//		for(int rNum=2; rNum<=rows; rNum++){
	//			
	//			String testCase = excel.getCellData(sheetName, "TCID", rNum);
	//			
	//			if(testCase.equalsIgnoreCase(testName)){
	//				
	//				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
	//				
	//				if(runmode.equalsIgnoreCase("Y"))
	//					return true;
	//				else
	//					return false;
	//			}
	//			
	//			
	//		}
	//		return false;
	//	}
	//	
}
