package com.ugapp.pages;
import com.ugapp.base.Page;
public class FormerNamePage extends Page
{
	
	
	public void scroll()
	{
		scrollUp(driver,5);
	}
	public void FormerName(String First_name, String Last_name) throws InterruptedException
	{
		//Add around 10 former name
		Thread.sleep(2000);
		
		System.out.println("clickinggggg");
		click("AddFormerName_XPATH");
		Thread.sleep(1000);
//		scrollUp(driver,2);
		type("FirstName_ID", First_name);
		Thread.sleep(1000);
//		scrollUp(driver,2);
		type("LastName_ID", Last_name);
		Thread.sleep(4000);
		click("SaveName_XPATH");
	}
	public void ValidateFormerName()
	{
		// Validate with Entered first name and last name
		
	}
}
