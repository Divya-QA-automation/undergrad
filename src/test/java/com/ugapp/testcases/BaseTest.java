package com.ugapp.testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ugapp.base.Page;

public class BaseTest extends Page{

	@Parameters({"colKey","colValue"})
	@BeforeTest
	public void colNum(String colKey,String colValue)
	{
		colNumKey = colKey;
		colNumValue = colValue;
		System.out.println("colNumKey :"+colNumKey);
		System.out.println("colNumValue :"+colNumValue);
	}



//	@AfterSuite
//	public void tearDown(){
//		
//		Page.quitBrowser();
//		
//	}

}
