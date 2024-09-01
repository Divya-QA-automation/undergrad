package com.ugapp.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.ugapp.pages.FooterLinksPage;

public class TC_02_FooterLinksPageTest extends BaseTest
{
	@Test(priority=3,groups= {"Greater24_US_Res_SpouseDependent_FutureGrad_InstateSchool_OOS"})
	public void verifyFooter() throws InterruptedException
	{
		FooterLinksPage footerLinksPage = new FooterLinksPage();
		footerLinksPage.validateFooterLinks();
		}

}
