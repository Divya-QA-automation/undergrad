package java.com.ugapp.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.com.ugapp.base.*;

public class ExcelHandler extends Page
{
	private static ThreadLocal<ExcelHandler> excelHandlerThreadLocal = ThreadLocal.withInitial(() -> {
		ExcelHandler handler = new ExcelHandler();
		try {
			handler.waitUntilExcelFileIsNotEmpty(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			handler.initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		} catch (InterruptedException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return handler;
	});

}
