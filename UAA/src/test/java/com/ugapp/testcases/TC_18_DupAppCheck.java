package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.PreviewPage;

public class TC_18_DupAppCheck extends BaseTest
{
	@Test(priority = 162)
	public void DupAppSignOut() throws Throwable
	{
		PreviewPage previewPage = new PreviewPage();
		previewPage.signOut();
		log.debug("Logged Out successfully!!!");
		
	}

}
