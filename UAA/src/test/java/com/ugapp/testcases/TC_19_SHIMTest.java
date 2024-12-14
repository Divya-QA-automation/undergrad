package com.ugapp.testcases;

import org.testng.annotations.Test;

import com.ugapp.pages.FooterLinksPage;
import com.ugapp.pages.SHIMPage;

public class TC_19_SHIMTest extends BaseTest
{
	SHIMPage shim = new SHIMPage();

	@Test(priority=1)
	public void VerifySHIM_Email() throws Throwable
	{
		shim.Shim_Email();
	}
	
	@Test(priority=2)
	public void VerifyImmersionMOL(String colKey,String colValue) throws Throwable
	{
		shim.Shim_InPersonMOL(colKey,colValue);
	}
	
	@Test(priority=3)
	public void VerifyOnlineMOL(String colKey,String colValue) throws Throwable
	{
		shim.Shim_OnlineMOL(colKey,colValue);
	}

	@Test(priority=4)
	public void Choose_Degree(String colKey,String colValue) throws Throwable
	{
		shim.Shim_Degree(colKey,colValue);
	}
	
	@Test(priority=4)
	public void VerifyTypeofDegree(String colKey,String colValue) throws Throwable
	{
		shim.Shim_NonDegree(colKey,colValue);
	}

}
