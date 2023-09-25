package com.ugapp.pages;


import org.openqa.selenium.WebElement;


import com.ugapp.base.Page;
import com.ugapp.testcases.BaseTest;


public class MyInformationPage extends Page
{
	public void ValidateForMyInfo() throws InterruptedException
	{
		WebElement MyInfo = findElement("MyInfoTitle_XPATH");


        // Check if the "My Information" Title is present on the page
        if (MyInfo.isDisplayed()) 
        {
        	log.debug("Navigated to My Information page");
        } 
        else 
        {
        	log.debug("Failed to navigate to My Information page");
        }
	}
	public void CheckForRequiredfields()
	{
		//Save and check for required field
		
		
	}
	
	
	
	public void ChooseLegalSex()
	{
		//choose random gender
	}
	public static void ValidateProfileLink()
	{
		//click and validate the page
	}
	
	public void ChoosePrimageLanguage()
	{
		//Select a random lang
		
	}
	public void HomeAddAndPhone()
	{
		//Enter International
		//Enter External org
		//Enter US
	}
	public void EthicRacialBackgroud()
	{
		//Yes or No
		//If yes Select Hispanic/Latino origin ------ Random
		//Select Race ----- 5(White and Blak - No sub section, American, Native and Asian - Sub questions)  -- Choose American Indian.
		//For sub question choose random
		//If both Ethnicity and Race is choosed then the Select Primary question shd be displayed.
	}
	
	public void PreviousASUaffiliation()
	{
		
	}
	


}
