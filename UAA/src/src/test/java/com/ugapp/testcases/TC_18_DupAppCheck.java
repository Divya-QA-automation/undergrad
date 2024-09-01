package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.PreviewPage;

import jdk.internal.org.jline.utils.Log;

public class TC_18_DupAppCheck 
{
	@Test(priority = 162)
	public void DupAppSignOut() throws Throwable
	{
		PreviewPage previewPage = new PreviewPage();
		previewPage.signOut();
		Log.debug("Logged Out successfully!!!");
		
	}

}
