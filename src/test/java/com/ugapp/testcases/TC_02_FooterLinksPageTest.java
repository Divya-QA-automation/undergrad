package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.FooterLinksPage;

public class TC_02_FooterLinksPageTest 
{
	@Test
	public void verifyFooter()
	{
		FooterLinksPage footerLinksPage = new FooterLinksPage();
		footerLinksPage.validateFooterLinks();
	}

}
