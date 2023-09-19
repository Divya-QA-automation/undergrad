package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.FooterLinksPage;

public class TC_02_FooterLinksPageTest 
{
	@Test
	public void verifyFooter() throws InterruptedException
	{
		FooterLinksPage footerLinksPage = new FooterLinksPage();
		footerLinksPage.validateFooterLinks();
		Thread.sleep(2000);	
		}

}
