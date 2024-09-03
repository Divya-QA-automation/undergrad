package com.ugapp.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ugapp.base.Page;


public class AZResidencyPage  extends Page
{
	ThreadLocal<String> A_SpouseEnrolledAZcoll =new ThreadLocal<>();
	ThreadLocal<String> A_SpouseDependentOnOtherString =new ThreadLocal<>();
	ThreadLocal<String> A_EnrolledAZcoll =new ThreadLocal<>();
	ThreadLocal<String> A_EmployedLast12months =new ThreadLocal<>();
	ThreadLocal<String> A_ParentHaveDLString = new ThreadLocal<>();
	ThreadLocal<String> A_AmericanIndianAlaskaNativeString = new ThreadLocal<>();
	ThreadLocal<String> A_ParentEmloyedInAZString = new ThreadLocal<>();
	ThreadLocal<String> A_EligibleForChapter30 =new ThreadLocal<>();
	ThreadLocal<String> selectedFinacialSupport = new ThreadLocal<>();
	ThreadLocal<String> A_ClaimedAsDependent =new ThreadLocal<>();
	ThreadLocal<String> A_MarriedQuestion =new ThreadLocal<>();
	ThreadLocal<String> GraduatefromAZhighschool = new ThreadLocal<>();
	ThreadLocal<String> PresentInAZforTwoyrs =new ThreadLocal<>();

	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	static final Map<String, String> monthMap = new HashMap<>();
	static {
		monthMap.put("January", "01");
		monthMap.put("February", "02");
		monthMap.put("March", "03");
		monthMap.put("April", "04");
		monthMap.put("May", "05");
		monthMap.put("June", "06");
		monthMap.put("July", "07");
		monthMap.put("August", "08");
		monthMap.put("September", "09");
		monthMap.put("October", "10");
		monthMap.put("November", "11");
		monthMap.put("December", "12");
	}

	

//	public void RandomAZresidencyflow(String colKey,String colValue) throws Throwable
//	{
//		if(Citizenship.get().equals("Resident"))
//		{
//
//			// Under US member or veteran --- Active duty, Armed Forces Reserve and National Guard  -- With Recent HS = AZ
//			if(SelectedMilitaryStatus_USmemberORveteran.get().equals("Active Duty") || SelectedMilitaryStatus_USmemberORveteran.get().equals("Armed Forces Reserve") || SelectedMilitaryStatus_USmemberORveteran.get().equals("National Guard")&& RecentState.get().equals("Arizona"))  
//			{
//				WebElement elementToScrollTo1 = findElement("PermanentHome_ID");
//				this.js = (JavascriptExecutor) getDriver();
//				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
//				log.debug("Choose the Permanent Home Country");
//				click("PermanentHome_ID");
//				Thread.sleep(1000);
//				List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//				int Options = options.size();
//				Random random = new Random();
//				int randomIndex = random.nextInt(options.size());
//				WebElement randomOption = options.get(randomIndex);
//				Thread.sleep(1000);
//				randomOption.click();
//				Thread.sleep(1000);
//				String 	selectedPermanentHome	= findElement("PermanentHome_ID").getText();
//				String 	Q_PermanentHome	= findElement("PermanentHomeQuestion_XPATH").getText();
//				log.debug(Q_PermanentHome+" " + selectedPermanentHome);
//				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//				setExcelData(colKey,colValue,"validData",125, Q_PermanentHome,selectedPermanentHome );
//				saveReport(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//				if(selectedPermanentHome.equals("Arizona"))
//				{
//					WebElement elementToScrollTo11 = findElement("LivingInAZForLAst12mons_XPATH");
//					this.js = (JavascriptExecutor) getDriver();
//					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
//					log.debug("Have you been living in Arizona continuously for the last 12 months?");
//					Thread.sleep(2000);
//					List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='radio_isAzResident12m']"));
//					int Count = radioButtons.size();
//					Random random1 = new Random();
//					int randomIndex1 = random1.nextInt(radioButtons.size());
//					String selectedOption = radioButtons.get(randomIndex1).getAttribute("value");
//					Thread.sleep(2000);
//					radioButtons.get(randomIndex1).click();
//					Thread.sleep(1000);
//					String Q_LivingInAZForLAst12mons =	findElement("LivingInAZForLAst12mons_XPATH").getText();
//					if(selectedOption.contains("Y"))
//					{
//						log.debug(Q_LivingInAZForLAst12mons+" "+"Yes");
//						// When did you begin living in Arizona?
//						WebElement elementToScrollToDL1 = findElement("BeginLivingInAZmm_ID");
//						this.js = (JavascriptExecutor) getDriver();
//						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDL1);
//						click("BeginLivingInAZmm_ID");
//						Thread.sleep(1000);
//						List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//						Random random12 = new Random();
//						int randomIndex12 = random12.nextInt(options1.size());
//						WebElement randomOption1 = options1.get(randomIndex12);
//						Thread.sleep(1000);
//						randomOption1.click();
//						Thread.sleep(1000);
//
//						WebElement elementToScrollToDL2 = findElement("BeginLivingInAZyy_ID");
//						this.js = (JavascriptExecutor) getDriver();
//						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDL2);
//						click("BeginLivingInAZyy_ID");
//						Thread.sleep(1000);
//						List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//						Random random11 = new Random();
//						int randomIndex11 = random11.nextInt(options11.size());
//						WebElement randomOption11 = options11.get(randomIndex11);
//						Thread.sleep(1000);
//						randomOption11.click();
//						Thread.sleep(1000);
//						String year = findElement("BeginLivingInAZyy_ID").getText();
//						String monthInWords = findElement("BeginLivingInAZmm_ID").getText(); 
//						String Q_BeginLivingInAZ = findElement("BeginLivingInAZ_XPATH").getText(); 
//						// Convert month in words to numeric representation using the monthMap
//						String month = monthMap.get(monthInWords);
//						String BeginLivingInAZDate = year + "-" + month;
//						log.debug(Q_BeginLivingInAZ+" "+BeginLivingInAZDate);
//						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						setExcelData(colKey,colValue,"validData",126, Q_LivingInAZForLAst12mons,"Yes");
//						setExcelData(colKey,colValue,"validData",127,Q_BeginLivingInAZ,BeginLivingInAZDate);
//						saveReport(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//					}
//					if(selectedOption.contains("N"))
//					{
//						log.debug(Q_LivingInAZForLAst12mons+" "+"No");
//						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						setExcelData(colKey,colValue,"validData",126, Q_LivingInAZForLAst12mons,"No");
//						saveReport(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//					}
//					// Are you currently enrolled at another college or university?
//					WebElement elementToScrollTo121 = findElement("EnrolledAtOtherCollYesRadioBtn_XPATH");
//					this.js = (JavascriptExecutor) getDriver();
//					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo121);
//					Thread.sleep(1000);
//					log.debug("Are you currently enrolled at another college or university?");
//					Thread.sleep(1000);
//					List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='radio_isEnrolledInAnotherUni']"));
//					int Count1 = radioButtons1.size();
//					Random random12 = new Random();
//					int randomIndex12 = random12.nextInt(radioButtons1.size());
//					String selectedOption1 = radioButtons1.get(randomIndex12).getAttribute("value");
//					Thread.sleep(2000);
//					radioButtons1.get(randomIndex12).click();
//					Thread.sleep(1000);
//					String Q_EnrolledAtOtherColl =	findElement("EnrolledAtOtherQuestion_XPATH").getText();
//					if(selectedOption1.contains("Y"))
//					{
//						// Enter a Enrolled college or University name
//						String A_CurrentlyEnrolled = "Test College";
//						WebElement elementToScrollTo = findElement("EnrolledCollTxtfield_XPATH");
//						this.js = (JavascriptExecutor) getDriver();
//						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
//						findElement("EnrolledCollTxtfield_XPATH").sendKeys(A_CurrentlyEnrolled);
//						//						type("EnrolledCollTxtfield_XPATH",A_CurrentlyEnrolled);
//						Thread.sleep(1000);
//						String Q_EnrolledCollOrUniversity = findElement("EnrolledCollQuestion_XPATH").getText();
//
//						//  Select a State of Enrolled college or University
//						click("EnrolledStateDD_XPATH");
//						Thread.sleep(1000);
//						List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//						int Options1 = options1.size();
//						Random random122 = new Random();
//						int randomIndex122 = random122.nextInt(options1.size());
//						WebElement randomOption1 = options1.get(randomIndex122);
//						Thread.sleep(1000);
//						randomOption1.click();
//						Thread.sleep(1000);
//						String 	A_EnrolledState	=	findElement("EnrolledStateDD_XPATH").getText();
//						String 	Q_EnrolledState	=	findElement("EnrolledStateQuestion_XPATH").getText();
//
//						log.debug(Q_EnrolledAtOtherColl+" "+"Yes");
//						log.debug(Q_EnrolledState+" " + A_EnrolledState);
//						log.debug( Q_EnrolledCollOrUniversity+" "+ A_CurrentlyEnrolled);
//						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						setExcelData(colKey,colValue,"validData",128, Q_EnrolledAtOtherColl,"Yes");
//						setExcelData(colKey,colValue,"validData",129, Q_EnrolledCollOrUniversity,A_CurrentlyEnrolled);
//						setExcelData(colKey,colValue,"validData",130, Q_EnrolledState,A_EnrolledState);
//						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//					}
//					if(selectedOption1.contains("N"))
//					{
//						log.debug(Q_EnrolledAtOtherColl+" "+"No");
//						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						setExcelData(colKey,colValue,"validData",128, Q_EnrolledAtOtherColl,"No");
//						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//					}
//
//					// Were you enrolled at any Arizona college or university in 2024 or 2023 calendar year?
//					WebElement elementToScrollTo2 = findElement("Enrolled@ASUQuestion_XPATH");
//					this.js = (JavascriptExecutor) getDriver();
//					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
//					Thread.sleep(1000);
//					List<WebElement> radioButtons13 = getDriver().findElements(By.xpath("//input[@name='radio_DOM_AZ']"));
//					int Count13 = radioButtons13.size();
//					Random random13 = new Random();
//					int randomIndex14 = random13.nextInt(radioButtons13.size());
//					String selectedOption13 = radioButtons13.get(randomIndex14).getAttribute("value");
//					Thread.sleep(2000);
//					radioButtons13.get(randomIndex14).click();
//					Thread.sleep(1000);
//					String 	Q_EnrolledASU	=	findElement("Enrolled@ASUQuestion_XPATH").getText();
//					if(selectedOption13.contains("Y"))
//					{
//						log.debug(Q_EnrolledASU +" : " + "Yes");
//						A_EnrolledAZcoll.set("Yes");
//						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						setExcelData(colKey,colValue,"validData",131, Q_EnrolledASU,A_EnrolledAZcoll.get());
//						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//					}
//					else
//					{
//						log.debug(Q_EnrolledASU+" : " + "No" );
//						A_EnrolledAZcoll.set("No");
//						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						setExcelData(colKey,colValue,"validData",131, Q_EnrolledASU,A_EnrolledAZcoll.get());
//						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//					}
//
//
//				
//
//
//				}
//				// Under US member or veteran --- Active duty, Armed Forces Reserve and National Guard  -- With Recent HS <> AZ
//				if(SelectedMilitaryStatus_USmemberORveteran.get().equals("Active Duty") || SelectedMilitaryStatus_USmemberORveteran.get().equals("Armed Forces Reserve") || SelectedMilitaryStatus_USmemberORveteran.get().equals("National Guard")&& !RecentState.get().equals("Arizona"))  
//				{
//					WebElement elementToScrollTo1 = findElement("PermanentHome_ID");
//					this.js = (JavascriptExecutor) getDriver();
//					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
//					log.debug("Choose the Permanent Home Country");
//					click("PermanentHome_ID");
//					Thread.sleep(1000);
//					List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//					int Options = options.size();
//					Random random = new Random();
//					int randomIndex = random.nextInt(options.size());
//					WebElement randomOption = options.get(randomIndex);
//					Thread.sleep(1000);
//					randomOption.click();
//					Thread.sleep(1000);
//					String 	selectedPermanentHome	= findElement("PermanentHome_ID").getText();
//					String 	Q_PermanentHome	= findElement("PermanentHomeQuestion_XPATH").getText();
//					log.debug(Q_PermanentHome+" " + selectedPermanentHome);
//					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//					setExcelData(colKey,colValue,"validData",125, Q_PermanentHome,selectedPermanentHome );
//					saveReport(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//					if(selectedPermanentHome.equals("Arizona"))
//					{
//						WebElement elementToScrollTo11 = findElement("LivingInAZForLAst12mons_XPATH");
//						this.js = (JavascriptExecutor) getDriver();
//						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
//						log.debug("Have you been living in Arizona continuously for the last 12 months?");
//						Thread.sleep(2000);
//						List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='radio_isAzResident12m']"));
//						int Count = radioButtons.size();
//						Random random1 = new Random();
//						int randomIndex1 = random1.nextInt(radioButtons.size());
//						String selectedOption = radioButtons.get(randomIndex1).getAttribute("value");
//						Thread.sleep(2000);
//						radioButtons.get(randomIndex1).click();
//						Thread.sleep(1000);
//						String Q_LivingInAZForLAst12mons =	findElement("LivingInAZForLAst12mons_XPATH").getText();
//						if(selectedOption.contains("Y"))
//						{
//							log.debug(Q_LivingInAZForLAst12mons+" "+"Yes");
//							// When did you begin living in Arizona?
//							WebElement elementToScrollToDL1 = findElement("BeginLivingInAZmm_ID");
//							this.js = (JavascriptExecutor) getDriver();
//							js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDL1);
//							click("BeginLivingInAZmm_ID");
//							Thread.sleep(1000);
//							List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//							Random random12 = new Random();
//							int randomIndex12 = random12.nextInt(options1.size());
//							WebElement randomOption1 = options1.get(randomIndex12);
//							Thread.sleep(1000);
//							randomOption1.click();
//							Thread.sleep(1000);
//
//							WebElement elementToScrollToDL2 = findElement("BeginLivingInAZyy_ID");
//							this.js = (JavascriptExecutor) getDriver();
//							js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDL2);
//							click("BeginLivingInAZyy_ID");
//							Thread.sleep(1000);
//							List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//							Random random11 = new Random();
//							int randomIndex11 = random11.nextInt(options11.size());
//							WebElement randomOption11 = options11.get(randomIndex11);
//							Thread.sleep(1000);
//							randomOption11.click();
//							Thread.sleep(1000);
//							String year = findElement("BeginLivingInAZyy_ID").getText();
//							String monthInWords = findElement("BeginLivingInAZmm_ID").getText(); 
//							String Q_BeginLivingInAZ = findElement("BeginLivingInAZ_XPATH").getText(); 
//							// Convert month in words to numeric representation using the monthMap
//							String month = monthMap.get(monthInWords);
//							String BeginLivingInAZDate = year + "-" + month;
//							log.debug(Q_BeginLivingInAZ+" "+BeginLivingInAZDate);
//							initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							setExcelData(colKey,colValue,"validData",126, Q_LivingInAZForLAst12mons,"Yes");
//							setExcelData(colKey,colValue,"validData",127,Q_BeginLivingInAZ,BeginLivingInAZDate);
//							saveReport(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						}
//						if(selectedOption.contains("N"))
//						{
//							log.debug(Q_LivingInAZForLAst12mons+" "+"No");
//							initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							setExcelData(colKey,colValue,"validData",126, Q_LivingInAZForLAst12mons,"No");
//							saveReport(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						}
//						// Are you currently enrolled at another college or university?
//						WebElement elementToScrollTo121 = findElement("EnrolledAtOtherCollYesRadioBtn_XPATH");
//						this.js = (JavascriptExecutor) getDriver();
//						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo121);
//						Thread.sleep(1000);
//						log.debug("Are you currently enrolled at another college or university?");
//						Thread.sleep(1000);
//						List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='radio_isEnrolledInAnotherUni']"));
//						int Count1 = radioButtons1.size();
//						Random random12 = new Random();
//						int randomIndex12 = random12.nextInt(radioButtons1.size());
//						String selectedOption1 = radioButtons1.get(randomIndex12).getAttribute("value");
//						Thread.sleep(2000);
//						radioButtons1.get(randomIndex12).click();
//						Thread.sleep(1000);
//						String Q_EnrolledAtOtherColl =	findElement("EnrolledAtOtherQuestion_XPATH").getText();
//						if(selectedOption1.contains("Y"))
//						{
//							// Enter a Enrolled college or University name
//							String A_CurrentlyEnrolled = "Test College";
//							WebElement elementToScrollTo = findElement("EnrolledCollTxtfield_XPATH");
//							this.js = (JavascriptExecutor) getDriver();
//							js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
//							findElement("EnrolledCollTxtfield_XPATH").sendKeys(A_CurrentlyEnrolled);
//							//						type("EnrolledCollTxtfield_XPATH",A_CurrentlyEnrolled);
//							Thread.sleep(1000);
//							String Q_EnrolledCollOrUniversity = findElement("EnrolledCollQuestion_XPATH").getText();
//
//							//  Select a State of Enrolled college or University
//							click("EnrolledStateDD_XPATH");
//							Thread.sleep(1000);
//							List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//							int Options1 = options1.size();
//							Random random122 = new Random();
//							int randomIndex122 = random122.nextInt(options1.size());
//							WebElement randomOption1 = options1.get(randomIndex122);
//							Thread.sleep(1000);
//							randomOption1.click();
//							Thread.sleep(1000);
//							String 	A_EnrolledState	=	findElement("EnrolledStateDD_XPATH").getText();
//							String 	Q_EnrolledState	=	findElement("EnrolledStateQuestion_XPATH").getText();
//
//							log.debug(Q_EnrolledAtOtherColl+" "+"Yes");
//							log.debug(Q_EnrolledState+" " + A_EnrolledState);
//							log.debug( Q_EnrolledCollOrUniversity+" "+ A_CurrentlyEnrolled);
//							initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							setExcelData(colKey,colValue,"validData",128, Q_EnrolledAtOtherColl,"Yes");
//							setExcelData(colKey,colValue,"validData",129, Q_EnrolledCollOrUniversity,A_CurrentlyEnrolled);
//							setExcelData(colKey,colValue,"validData",130, Q_EnrolledState,A_EnrolledState);
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						}
//						if(selectedOption1.contains("N"))
//						{
//							log.debug(Q_EnrolledAtOtherColl+" "+"No");
//							initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							setExcelData(colKey,colValue,"validData",128, Q_EnrolledAtOtherColl,"No");
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						}
//
//						// Were you enrolled at any Arizona college or university in 2024 or 2023 calendar year?
//						WebElement elementToScrollTo2 = findElement("Enrolled@ASUQuestion_XPATH");
//						this.js = (JavascriptExecutor) getDriver();
//						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
//						Thread.sleep(1000);
//						List<WebElement> radioButtons13 = getDriver().findElements(By.xpath("//input[@name='radio_DOM_AZ']"));
//						int Count13 = radioButtons13.size();
//						Random random13 = new Random();
//						int randomIndex14 = random13.nextInt(radioButtons13.size());
//						String selectedOption13 = radioButtons13.get(randomIndex14).getAttribute("value");
//						Thread.sleep(2000);
//						radioButtons13.get(randomIndex14).click();
//						Thread.sleep(1000);
//						String 	Q_EnrolledASU	=	findElement("Enrolled@ASUQuestion_XPATH").getText();
//						if(selectedOption13.contains("Y"))
//						{
//							log.debug(Q_EnrolledASU +" : " + "Yes");
//							A_EnrolledAZcoll.set("Yes");
//							initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							setExcelData(colKey,colValue,"validData",131, Q_EnrolledASU,A_EnrolledAZcoll.get());
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						}
//						else
//						{
//							log.debug(Q_EnrolledASU+" : " + "No" );
//							A_EnrolledAZcoll.set("No");
//							initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							setExcelData(colKey,colValue,"validData",131, Q_EnrolledASU,A_EnrolledAZcoll.get());
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						}
//
//
//
//
//
//
//						// Do you have a current driver’s license or state issued ID?
//						WebElement elementToScrollTo1211 = findElement("HavingLicenceYesRadioBtn_XPATH");
//						this.js = (JavascriptExecutor) getDriver();
//						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1211);
//						log.debug("Do you have a current driver’s license or state issued ID?");
//						Thread.sleep(1000);
//						List<WebElement> radioButtons11 = getDriver().findElements(By.xpath("//input[@name='isHavingLicense']"));
//						int Count12 = radioButtons11.size();
//						Random random21 = new Random();
//						int randomIndex21 = random21.nextInt(radioButtons11.size());
//						String selectedOption21 = radioButtons11.get(randomIndex21).getAttribute("value");
//						Thread.sleep(2000);
//						radioButtons11.get(randomIndex21).click();
//						Thread.sleep(1000);
//						String 	Q_Licence	=	findElement("HavingLicenceQuestion_XPATH").getText();
//						if(selectedOption21.contains("Y"))
//						{
//							log.debug("Do you have a current driver’s license or state issued ID?"+" " + "No");
//							// Select In which state was your license issued?
//							WebElement elementToScrollToLS = findElement("LicenseIssuedStateDD_XPATH");
//							this.js = (JavascriptExecutor) getDriver();
//							js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToLS);
//							click("LicenseIssuedStateDD_XPATH");
//							Thread.sleep(1000);
//							List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//							int Options1 = options1.size();
//							Random random221 = new Random();
//							int randomIndex31 = random221.nextInt(options1.size());
//							WebElement randomOption1 = options1.get(randomIndex31);
//							Thread.sleep(1000);
//							randomOption1.click();
//							Thread.sleep(1000);
//							String 	A_LicenseIssuedState	= findElement("LicenseIssuedStateDD_XPATH").getText();
//							if(A_LicenseIssuedState.contains("Arizona"))
//							{
//								// Select When was your license issued?
//								WebElement elementToScrollToDL1 = findElement("SelectDLmonth_XPATH");
//								this.js = (JavascriptExecutor) getDriver();
//								js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDL1);
//								click("SelectDLmonth_XPATH");
//								Thread.sleep(1000);
//								List<WebElement> options41  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//								Random random41 = new Random();
//								int randomIndex41 = random41.nextInt(options41.size());
//								WebElement randomOption41 = options41.get(randomIndex41);
//								Thread.sleep(1000);
//								randomOption41.click();
//								Thread.sleep(1000);
//								WebElement elementToScrollToDL2 = findElement("SelectDLyear_XPATH");
//								this.js = (JavascriptExecutor) getDriver();
//								js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDL2);
//								click("SelectDLyear_XPATH");
//								Thread.sleep(1000);
//								List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//								Random random11 = new Random();
//								int randomIndex11 = random11.nextInt(options11.size());
//								WebElement randomOption11 = options11.get(randomIndex11);
//								Thread.sleep(1000);
//								randomOption11.click();
//								Thread.sleep(1000);
//								String year = findElement("SelectDLyear_XPATH").getText();
//								String monthInWords = findElement("SelectDLmonth_XPATH").getText(); 
//								String Q_LicenseIssuedDate = findElement("LicenseIssuedDateQuestion_XPATH").getText(); 
//								// Convert month in words to numeric representation using the monthMap
//								String month = monthMap.get(monthInWords);
//								// Format the selected year and month as 'YYYY-MM'
//								String LicenseIssuedDate = year + "-" + month;
//								log.debug(Q_LicenseIssuedDate+" "+LicenseIssuedDate);
//								log.debug("Is this vehicle registered in the state of Arizona?"+" " + "Yes");
//								initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//								setExcelData(colKey,colValue,"validData",137, Q_Licence,"Yes");
//								setExcelData(colKey,colValue,"validData",138," In which state was your license issued? ",A_LicenseIssuedState);
//								setExcelData(colKey,colValue,"validData",139,Q_LicenseIssuedDate,LicenseIssuedDate);
//								saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							}
//							else
//							{
//								log.debug("Do you have a current driver’s license or state issued ID?"+" " + "Yes");
//								log.debug("Is this vehicle registered in the state of Arizona?"+" " + "No");
//								initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//								setExcelData(colKey,colValue,"validData",137, Q_Licence,"Yes");
//								setExcelData(colKey,colValue,"validData",138," In which state was your license issued? ",A_LicenseIssuedState);
//								saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							}
//							if(selectedOption21.contains("N"))
//							{
//								log.debug("Do you have a current driver’s license or state issued ID?"+" " + "No");
//								initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//								setExcelData(colKey,colValue,"validData",137, Q_Licence,"No");
//								saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							}
//
//							// Do you own or operate a car, motorcycle or other motor vehicle?
//							WebElement elementToScrollTo = findElement("OwnvehicleYesRadioBtn_XPATH");
//							this.js = (JavascriptExecutor) getDriver();
//							js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
//							log.debug("Do you own or operate a car, motorcycle or other motor vehicle?");
//							Thread.sleep(2000);
//							List<WebElement> radioButtons41 = getDriver().findElements(By.xpath("//input[@name='isOwnsVehicle_radio']"));
//							int Count41 = radioButtons41.size();
//							Random random41 = new Random();
//							int randomIndex41 = random41.nextInt(radioButtons41.size());
//							String selectedoption = radioButtons41.get(randomIndex41).getAttribute("value");
//							Thread.sleep(2000);
//							radioButtons41.get(randomIndex41).click();
//							Thread.sleep(1000);
//							String Q_OwnVehicle	=findElement("OwnVehicleQuestion_XPATH").getText();
//							Thread.sleep(1000);
//							if(selectedoption.contains("Y"))
//							{
//								WebElement elementToScrollTo131 = findElement("VehicleRegisteredQuestion_XPATH");
//								this.js = (JavascriptExecutor) getDriver();
//								js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo131);
//								log.debug("Is this vehicle registered in the state of Arizona?");
//								Thread.sleep(2000);
//								List<WebElement> radioButtons51 = getDriver().findElements(By.xpath("//input[@name='isVehicleRegisteredInAZ_radio']"));
//								int Count51 = radioButtons51.size();
//								Random random441 = new Random();
//								int randomIndex51 = random441.nextInt(radioButtons51.size());
//								String selectedOption51 = radioButtons51.get(randomIndex51).getAttribute("value");
//								// Click the randomly selected radio button
//								Thread.sleep(2000);
//								radioButtons51.get(randomIndex51).click();
//								Thread.sleep(1000);
//								String Q_VehicleRegistered	=findElement("VehicleRegisteredQuestion_XPATH").getText();
//
//								if(selectedOption51.contains("Y"))
//								{
//									WebElement elementToScrollTo111 = findElement("RegistrationMonthDD_XPATH");
//									this.js = (JavascriptExecutor) getDriver();
//									js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
//									click("RegistrationMonthDD_XPATH");
//									Thread.sleep(1000);
//									List<WebElement> options61  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//									Random random61 = new Random();
//									int randomIndex71 = random61.nextInt(options61.size());
//									WebElement randomOption71 = options61.get(randomIndex71);
//									Thread.sleep(1000);
//									randomOption71.click();
//									Thread.sleep(1000);
//									WebElement elementToScrollTo21 = findElement("RegistrationYearDD_XPATH");
//									this.js = (JavascriptExecutor) getDriver();
//									js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
//									click("RegistrationYearDD_XPATH");
//									Thread.sleep(1000);
//									List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//									Random random11 = new Random();
//									int randomIndex11 = random11.nextInt(options11.size());
//									WebElement randomOption11 = options11.get(randomIndex11);
//									Thread.sleep(1000);
//									randomOption11.click();
//									Thread.sleep(1000);
//									String year = findElement("RegistrationYearDD_XPATH").getText();
//									String monthInWords = findElement("RegistrationMonthDD_XPATH").getText(); 
//									String Q_VehicleRegisteredDate = findElement("VehicleRegisteredQuestion_XPATH").getText(); 
//									String month = monthMap.get(monthInWords);
//									String VehicleRegisteredDate = year + "-" + month;
//
//									log.debug(Q_OwnVehicle+" "+ "Yes");
//									log.debug(Q_VehicleRegistered+" "+ "Yes");
//									log.debug(Q_VehicleRegisteredDate+" "+VehicleRegisteredDate);
//									initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//									setExcelData(colKey,colValue,"validData",140,Q_OwnVehicle,"Yes");
//									setExcelData(colKey,colValue,"validData",141," Is this vehicle registered in the state of Arizona? ","Yes");
//									setExcelData(colKey,colValue,"validData",142,Q_VehicleRegisteredDate,VehicleRegisteredDate);
//									saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//								}
//								if(selectedOption51.contains("N"))
//								{
//									log.debug(Q_OwnVehicle+" "+ "Yes");
//									log.debug(Q_VehicleRegistered+" "+ "No");
//									initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//									setExcelData(colKey,colValue,"validData",140,Q_OwnVehicle,"Yes");
//									setExcelData(colKey,colValue,"validData",141," Is this vehicle registered in the state of Arizona? ","No");
//									saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//								}
//
//							}
//							if(selectedoption.contains("N"))
//							{
//								log.debug(Q_OwnVehicle+" "+ "No");
//								initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//								setExcelData(colKey,colValue,"validData",140,Q_OwnVehicle,"No");
//								saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							}
//
//						}
//						// Did you, or will you, file state taxes for 2023? 
//						WebElement elementToScrollTo = findElement("DidFileStateTaxYesRadioBtn_XPATH");
//						this.js = (JavascriptExecutor) getDriver();
//						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
//						log.debug(" Did you, or will you, file state taxes for 2022?");
//						List<WebElement> radioButtons31 = getDriver().findElements(By.xpath("//input[@name='isFiledTaxLastYear_radio']"));
//						int Count31 = radioButtons31.size();
//						Random random31 = new Random();
//						int randomIndex31 = random31.nextInt(radioButtons31.size());
//						String selectedOption31 = radioButtons31.get(randomIndex31).getAttribute("value");
//						radioButtons31.get(randomIndex31).click();
//						if(selectedOption31.contains("Y"))
//						{
//							log.debug(" Did you, or will you, file state taxes for 2022? : Yes");
//							WebElement elementToScrollTo1221 = findElement("StateTaxLocDD_XPATH");
//							this.js = (JavascriptExecutor) getDriver();
//							js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1221);
//							click("StateTaxLocDD_XPATH");
//							Thread.sleep(1000);
//							List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//							Random random11 = new Random();
//							int randomIndex11 = random11.nextInt(options1.size());
//							WebElement randomOption1 = options1.get(randomIndex11);
//							Thread.sleep(1000);
//							randomOption1.click();
//							Thread.sleep(1000);
//							String A_LocStateTax = findElement("StateTaxLocDD_XPATH").getText();
//							String Q_LocStateTax = findElement("StateTaxQuestion_XPATH").getText();
//							log.debug(Q_LocStateTax+" "+A_LocStateTax);
//							initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							setExcelData(colKey,colValue,"validData",143," Did you, or will you, file state taxes for 2022? ","Yes");
//							setExcelData(colKey,colValue,"validData",144," Where did or where will you file your state taxes for 2022? ", A_LocStateTax);
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						}
//						if(selectedOption31.contains("N"))
//						{
//							log.debug(" Did you, or will you, file state taxes for 2022? : No");
//							initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							setExcelData(colKey,colValue,"validData",143," Did you, or will you, file state taxes for 2022? ","No");
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						}
//
//						// Financial support
//						FinancialSupport(colKey,colValue);
//						// Other finacial support
//						OtherFinancialSupport(colKey,colValue);
//						// SourceOfSupport
//						SourceOfSupport();
//						// Employment  ----- YES or NO
//						WebElement elementToScrollTo41 = findElement("CurrentlyEmployedQuestion_XPATH");
//						this.js = (JavascriptExecutor) getDriver();
//						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo41);
//						Thread.sleep(1000);
//						log.debug("Are you currently employed?");
//						List<WebElement> radioButtons311 = getDriver().findElements(By.xpath("//input[@name='employment_radio_isEmployed']"));
//						int Count311 = radioButtons311.size();
//						Random random311 = new Random();
//						int randomIndex311 = random311.nextInt(radioButtons311.size());
//						String selectedOption311 = radioButtons311.get(randomIndex311).getAttribute("value");
//						radioButtons311.get(randomIndex311).click();
//						//					Employment --- Yes
//						if(selectedOption311.contains("Y"))
//						{
//							log.debug(" Are you currently employed? : Yes");
//							WebElement elementToScrollTo191 = findElement("PrimaryWorkLocYesDD_XPATH");
//							this.js = (JavascriptExecutor) getDriver();
//							js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo191);
//							click("PrimaryWorkLocYesDD_XPATH");
//							Thread.sleep(1000);
//							click("PrimaryWorkAZloc_XPATH");
//							Thread.sleep(1000);
//
//
//							WebElement elementToScrollTo21= findElement("EmplyomentLocDateQuestion_XPATH");
//							this.js = (JavascriptExecutor) getDriver();
//							js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
//
//
//
//							click("EmploymentLocMonthDD_XPATH");
//							Thread.sleep(1000);
//							List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//							Random random81 = new Random();
//							int randomIndex81 = random81.nextInt(options1.size());
//							WebElement randomOption1 = options1.get(randomIndex81);
//							Thread.sleep(1000);
//							randomOption1.click();
//							Thread.sleep(1000);
//							WebElement elementToScroll = findElement("EmploymentLocYearDD_XPATH");
//							this.js = (JavascriptExecutor) getDriver();
//							js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
//							click("EmploymentLocYearDD_XPATH");
//							Thread.sleep(1000);
//							List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//							Random random11 = new Random();
//							int randomIndex11 = random11.nextInt(options11.size());
//							WebElement randomOption11 = options11.get(randomIndex11);
//							Thread.sleep(1000);
//							randomOption11.click();
//							Thread.sleep(1000);
//							String year = findElement("EmploymentLocYearDD_XPATH").getText();
//							String monthInWords = findElement("EmploymentLocMonthDD_XPATH").getText(); 
//							String Q_EmplyomentLocDateQuestion = findElement("EmplyomentLocDateQuestion_XPATH").getText(); 
//							// Convert month in words to numeric representation using the monthMap
//							String month = monthMap.get(monthInWords);
//							// Format the selected year and month as 'YYYY-MM'
//							String EmlyomentLocationDate = year + "-" + month;
//							log.debug(Q_EmplyomentLocDateQuestion+" "+EmlyomentLocationDate);
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							setExcelData(colKey,colValue,"validData",157," Are you currently employed? ", "Yes");
//							setExcelData(colKey,colValue,"validData",158," Where is your primary work location? ", "Arizona");
//							setExcelData(colKey,colValue,"validData",159,Q_EmplyomentLocDateQuestion, EmlyomentLocationDate);
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						}
//						if(selectedOption311.contains("N"))
//						{
//							log.debug(" Are you currently employed? : No");
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							setExcelData(colKey,colValue,"validData",157, "Are you currently employed?","No");
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//
//							// Were you employed in the last 12 months? - Random
//							WebElement elementToScrollTo151 = findElement("EmployedLast12months_XPATH");
//							this.js = (JavascriptExecutor) getDriver();
//							js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo151);
//							List<WebElement> radioButtons51 = getDriver().findElements(By.xpath("//input[@name='radio_isEmployedInLast12m']"));
//							int Count51 = radioButtons51.size();
//							Random random51 = new Random();
//							int randomIndex51 = random51.nextInt(radioButtons51.size());
//							// Get the text of the randomly selected radio button
//							String selectedOption51 = radioButtons51.get(randomIndex51).getAttribute("value");
//							// Click the randomly selected radio button
//							Thread.sleep(1000);
//							radioButtons51.get(randomIndex51).click();
//							Thread.sleep(1000);
//							String 	Q_EmployedLast12months	=	findElement("EmployedLast12months_XPATH").getText();
//							if(selectedOption51.contains("Y"))
//							{
//								log.debug(Q_EmployedLast12months +" : " + "Yes");
//								A_EmployedLast12months.set("Yes");
//								Thread.sleep(1000);
//								WebElement elementToScrollTo111 = findElement("PrimaryWorkLocNoDD_XPATH");
//								js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo111);
//								click("PrimaryWorkLocNoDD_XPATH");
//								// Randomly select Primary Work loc
//								Thread.sleep(1000);
//								List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//								int Options1 = options1.size();
//								Random random11 = new Random();
//								int randomIndex11 = random11.nextInt(options1.size());
//								WebElement randomOption1 = options1.get(randomIndex11);
//								Thread.sleep(500);
//								randomOption1.click();
//								Thread.sleep(500);
//								String 	selectedLPrimaryWorkLoc	=	findElement("PrimaryWorkLocNoDD_XPATH").getText();
//								log.debug("Selected Primary language option: " + selectedLPrimaryWorkLoc);
//								initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//								setExcelData(colKey,colValue,"validData",158, Q_EmployedLast12months,A_EmployedLast12months.get());
//								setExcelData(colKey,colValue,"validData",159, "Where was your primary work location? ",selectedLPrimaryWorkLoc);
//								saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							}
//							else
//							{
//								log.debug(Q_EmployedLast12months+" : " + "No" );
//								A_EmployedLast12months.set("No");
//								initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//								setExcelData(colKey,colValue,"validData",158, Q_EmployedLast12months,A_EmployedLast12months.get());
//								saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							}
//
//						}
//						// Active duty, Armed force reserve and National guard flow -- Currently stationed, LES Questions
//						WebElement elementToScroll = findElement("CurrentStationedLocQuestion_XPATH");
//						this.js = (JavascriptExecutor) getDriver();
//						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
//						// Where are you currently stationed?
//						click("CurrentStationedDD_XPATH");
//						Thread.sleep(1000);
//						List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//						int Options1 = options1.size();
//						Random random11 = new Random();
//						int randomIndex11 = random11.nextInt(options1.size());
//						WebElement randomOption1 = options1.get(randomIndex11);
//						Thread.sleep(1000);
//						randomOption1.click();
//						Thread.sleep(1000);
//						String 	selectedCurrentStationedLocQuestioText_Q	= findElement("CurrentStationedLocQuestion_XPATH").getText();
//						String 	selectedCurrentStationedDDText_A	= findElement("CurrentStationedDD_XPATH").getText();
//						Thread.sleep(1000);
//						if(!selectedCurrentStationedDDText_A.contains("Arizona"))
//						{
//							WebElement elementToScroll1 = findElement("LESquestion_XPATH");
//							this.js = (JavascriptExecutor) getDriver();
//							js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
//							//						What is your state of legal residence as noted on your leave and earnings statement (LES)?
//							click("LESquestionDD_XPATH");
//							Thread.sleep(1000);
//							List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//							int Options11 = options11.size();
//							Random random111 = new Random();
//							int randomIndex111 = random111.nextInt(options11.size());
//							WebElement randomOption11 = options11.get(randomIndex111);
//							Thread.sleep(1000);
//							randomOption11.click();
//							Thread.sleep(1000);
//							String 	LESquestionText_Q	= findElement("LESquestion_XPATH").getText();
//							String LESquestion_A	= findElement("LESquestionDD_XPATH").getText();
//							Thread.sleep(1000);
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							setExcelData(colKey,colValue,"validData",164,selectedCurrentStationedLocQuestioText_Q, selectedCurrentStationedDDText_A);
//							setExcelData(colKey,colValue,"validData",165,LESquestionText_Q, LESquestion_A);
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						}
//						if(selectedCurrentStationedDDText_A.contains("Arizona"))
//						{
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							setExcelData(colKey,colValue,"validData",164,selectedCurrentStationedLocQuestioText_Q, selectedCurrentStationedDDText_A);
//							setExcelData(colKey,colValue,"validData",165,"What is your state of legal residence as noted on your leave and earnings statement (LES)?", "Arizona");
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						}
//
//
//
//					}
//					if(!selectedPermanentHome.equals("Arizona"))
//					{
//						WebElement elementToScroll = findElement("CurrentStationedLocQuestion_XPATH");
//						this.js = (JavascriptExecutor) getDriver();
//						js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
//						// Where are you currently stationed?
//						click("CurrentStationedDD_XPATH");
//						Thread.sleep(1000);
//						List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//						int Options1 = options1.size();
//						Random random1 = new Random();
//						int randomIndex1 = random1.nextInt(options1.size());
//						WebElement randomOption1 = options1.get(randomIndex1);
//						Thread.sleep(1000);
//						randomOption1.click();
//						Thread.sleep(1000);
//						String 	selectedCurrentStationedLocQuestioText_Q	= findElement("CurrentStationedLocQuestion_XPATH").getText();
//						String 	selectedCurrentStationedDDText_A	= findElement("CurrentStationedDD_XPATH").getText();
//						Thread.sleep(1000);
//						if(!selectedCurrentStationedDDText_A.contains("Arizona"))
//						{
//							WebElement elementToScroll1 = findElement("LESquestion_XPATH");
//							this.js = (JavascriptExecutor) getDriver();
//							js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
//							//						What is your state of legal residence as noted on your leave and earnings statement (LES)?
//							click("LESquestionDD_XPATH");
//							Thread.sleep(1000);
//							List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
//							int Options11 = options11.size();
//							Random random11 = new Random();
//							int randomIndex11 = random11.nextInt(options11.size());
//							WebElement randomOption11 = options11.get(randomIndex11);
//							Thread.sleep(1000);
//							randomOption11.click();
//							Thread.sleep(1000);
//							String 	LESquestionText_Q	= findElement("LESquestion_XPATH").getText();
//							String LESquestion_A	= findElement("LESquestionDD_XPATH").getText();
//							Thread.sleep(1000);
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							setExcelData(colKey,colValue,"validData",164,selectedCurrentStationedLocQuestioText_Q, selectedCurrentStationedDDText_A);
//							setExcelData(colKey,colValue,"validData",165,LESquestionText_Q, LESquestion_A);
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						}
//						if(selectedCurrentStationedDDText_A.contains("Arizona"))
//						{
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//							setExcelData(colKey,colValue,"validData",164,selectedCurrentStationedLocQuestioText_Q, selectedCurrentStationedDDText_A);
//							setExcelData(colKey,colValue,"validData",165,"What is your state of legal residence as noted on your leave and earnings statement (LES)?", "Arizona");
//							saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
//						}
//
//					}
//				}
//
//
//				//Under US member or veteran ---  Veteran -- With Recent HS = AZ
//				if(SelectedMilitaryStatus_USmemberORveteran.get().equals("Veteran") && RecentState.get().equals("Arizona")) 
//				{
//
//				}
//				//Under US member or veteran ---  Veteran -- With Recent HS <> AZ
//				if(SelectedMilitaryStatus_USmemberORveteran.get().equals("Veteran") && !RecentState.get().equals("Arizona")) 
//				{
//
//				}
//
//
//				//Under Spouse or dependent --- With Recent HS = AZ
//				if(selectedMilitaryStatus.get().equals("I am the spouse/dependent of a U.S. service member or veteran")&& RecentState.get().equals("Arizona")) 
//				{
//
//				}
//				//Under Spouse or dependent --- With Recent HS <> AZ
//				if(selectedMilitaryStatus.get().equals("I am the spouse/dependent of a U.S. service member or veteran")&& !RecentState.get().equals("Arizona")) 
//				{
//
//				}
//
//
//
//				//Under None of these apply to me  -- With Recent HS = AZ
//				if(selectedMilitaryStatus.get().equals("None of these options apply to me")&& RecentState.get().equals("Arizona")) 
//				{
//
//				}
//				//Under None of these apply to me  -- With Recent HS <> AZ
//				if(selectedMilitaryStatus.get().equals("None of these options apply to me")&& !RecentState.get().equals("Arizona")) 
//				{
//
//				}
//
//			}
//			if(Citizenship.get().equals("Not Resident"))
//			{
//				NonResidentAZflow();
//			}}
//		}


		public  void validateAZresidencyPage() throws Throwable
		{
			waitTillProgressbarDisappears();
			Thread.sleep(2000);
			WebElement elementToScrollTo1 = findElement("ResidencyTitle_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			String PageTitle	= findElement("ResidencyTitle_XPATH").getText();
			log.debug("Page title :"+" "+PageTitle);
		}
		public void  PermanentHome_OOS(String colKey,String colValue) throws Throwable
		{
			WebElement elementToScrollTo1 = findElement("PermanentHome_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			log.debug("Choose the Permanent Home Country");
			click("PermanentHome_ID");
			Thread.sleep(2000);
			click("OOSdd_XPATH");
			Thread.sleep(500);
			String 	selectedPermanentHome	= findElement("PermanentHome_ID").getText();
			String 	Q_PermanentHome	= findElement("PermanentHomeQuestion_XPATH").getText();
			log.debug(Q_PermanentHome+" " + selectedPermanentHome);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",125, Q_PermanentHome,selectedPermanentHome );
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		public void  PermanentHome_AZ(String colKey,String colValue) throws Throwable
		{
			WebElement elementToScrollTo1 = findElement("PermanentHome_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			log.debug("Choose the Permanent Home Country");
			click("PermanentHome_ID");
			Thread.sleep(1000);
			click("AZHomeAdd_XPATH");
			String 	selectedPermanentHome	= findElement("PermanentHome_ID").getText();
			String 	Q_PermanentHome	= findElement("PermanentHomeQuestion_XPATH").getText();
			log.debug(Q_PermanentHome+" " + selectedPermanentHome);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",125, Q_PermanentHome,selectedPermanentHome );
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		public void  LivingInAZForLast12mons(String colKey,String colValue) throws Throwable
		{
			// Select YES to  - Have you been living in Arizona continuously for the last 12 months?
			WebElement elementToScrollTo1 = findElement("LivingInAZForLAst12mons_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			click("LivingInAZForLAst12monsYesDD_XPATH");
			String selectedOption =	findElement("LivingInAZForLAst12monsYesDD_XPATH").getAttribute("value");
			String Q_LivingInAZForLAst12mons =	findElement("LivingInAZForLAst12mons_XPATH").getText();
			if(selectedOption.contains("Y"))
			{
				log.debug(Q_LivingInAZForLAst12mons+" "+"Yes");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",126, Q_LivingInAZForLAst12mons,"Yes");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}
			// When did you begin living in Arizona?
			WebElement elementToScrollToDL1 = findElement("BeginLivingInAZmm_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDL1);
			click("BeginLivingInAZmm_ID");
			Thread.sleep(1000);
			List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			Random random = new Random();
			int randomIndex = random.nextInt(options.size());
			WebElement randomOption = options.get(randomIndex);
			Thread.sleep(1000);
			randomOption.click();
			Thread.sleep(1000);

			WebElement elementToScrollToDL2 = findElement("BeginLivingInAZyy_ID");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDL2);
			click("BeginLivingInAZyy_ID");
			Thread.sleep(1000);
			List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex1);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			String year = findElement("BeginLivingInAZyy_ID").getText();
			String monthInWords = findElement("BeginLivingInAZmm_ID").getText(); 
			String Q_BeginLivingInAZ = findElement("BeginLivingInAZ_XPATH").getText(); 
			// Convert month in words to numeric representation using the monthMap
			String month = monthMap.get(monthInWords);


			// Format the selected year and month as 'YYYY-MM'
			String BeginLivingInAZDate = year + "-" + month;
			log.debug(Q_BeginLivingInAZ+" "+BeginLivingInAZDate);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",127,Q_BeginLivingInAZ,BeginLivingInAZDate);

		}
		public void EnrolledAnotherCollOrUniversityYes(String colKey,String colValue) throws EncryptedDocumentException, Exception
		{
			// Select YES to Are you currently enrolled at another college or university?
			WebElement elementToScrollTo1 = findElement("EnrolledAtOtherCollYesRadioBtn_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			Thread.sleep(2000);
			click("EnrolledAtOtherCollYesRadioBtn_XPATH");
			Thread.sleep(1000);
			String selectedOption =	findElement("EnrolledAtOtherCollYesRadioBtn_XPATH").getAttribute("value");
			String Q_EnrolledAtOtherColl =	findElement("EnrolledAtOtherQuestion_XPATH").getText();
			if(selectedOption.contains("Y"))
			{
				log.debug(Q_EnrolledAtOtherColl+" "+"Yes");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",128, Q_EnrolledAtOtherColl,"Yes");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}
			// Enter a Enrolled college or University name
			String A_CurrentlyEnrolled = "Test College";
			WebElement elementToScrollTo = findElement("EnrolledCollTxtfield_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			type("EnrolledCollTxtfield_XPATH",A_CurrentlyEnrolled);
			Thread.sleep(1000);
			String Q_EnrolledCollOrUniversity = findElement("EnrolledCollQuestion_XPATH").getText();
			log.debug( Q_EnrolledCollOrUniversity+" "+ A_CurrentlyEnrolled);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",129, Q_EnrolledCollOrUniversity,A_CurrentlyEnrolled);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

			//  Select a State of Enrolled college or University
			click("EnrolledStateDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options = options.size();
			Random random = new Random();
			int randomIndex = random.nextInt(options.size());
			WebElement randomOption = options.get(randomIndex);
			Thread.sleep(1000);
			randomOption.click();
			Thread.sleep(1000);
			// Get the text of the chosen random option
			String 	A_EnrolledState	=	findElement("EnrolledStateDD_XPATH").getText();
			String 	Q_EnrolledState	=	findElement("EnrolledStateQuestion_XPATH").getText();
			log.debug(Q_EnrolledState+" " + A_EnrolledState);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",130, Q_EnrolledState,A_EnrolledState);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




		}
		public void EnrolledAnotherCollOrUniversityNo(String colKey,String colValue) throws EncryptedDocumentException, Exception
		{
			// Select NO to Are you currently enrolled at another college or university?
			WebElement elementToScrollTo1 = findElement("EnrolledAtOtherQuestion_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			click("EnrolledAtOtherCollNoRadioBtn_XPATH");
			String selectedOption =	findElement("EnrolledAtOtherCollNoRadioBtn_XPATH").getAttribute("value");
			String Q_EnrolledAtOtherColl =	findElement("EnrolledAtOtherQuestion_XPATH").getText();
			if(selectedOption.contains("N"))
			{
				log.debug(Q_EnrolledAtOtherColl+" "+"No");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",128, Q_EnrolledAtOtherColl,"No");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}

		}





		public void EnrolledAtASU(String colKey,String colValue) throws Exception 
		{
			WebElement elementToScrollTo2 = findElement("Enrolled@ASUQuestion_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			Thread.sleep(1000);
			List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='radio_DOM_AZ']"));
			int Count = radioButtons.size();
			Random random = new Random();
			int randomIndex = random.nextInt(radioButtons.size());
			// Get the text of the randomly selected radio button
			String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
			// Click the randomly selected radio button
			Thread.sleep(2000);
			radioButtons.get(randomIndex).click();
			Thread.sleep(1000);
			String 	Q_EnrolledASU	=	findElement("Enrolled@ASUQuestion_XPATH").getText();
			if(selectedOption.contains("Y"))
			{
				log.debug(Q_EnrolledASU +" : " + "Yes");
				A_EnrolledAZcoll.set("Yes");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",131, Q_EnrolledASU,A_EnrolledAZcoll.get());
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}
			else
			{
				log.debug(Q_EnrolledASU+" : " + "No" );
				A_EnrolledAZcoll.set("No");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",131, Q_EnrolledASU,A_EnrolledAZcoll.get());
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}
		}








		// Dependent on for income Tax on PArents i missing-------------------------
		// Question is meant for Only Less than 24 yrs of Age
		public void DependentOnParent_Yes(String colKey,String colValue) throws Exception 
		{
			WebElement elementToScrollTo2 = findElement("ClaimedAsDependent_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			Thread.sleep(1000);
			click("DependentOnParentYes_XPATH");
			String selectedOption = findElement("DependentOnParentYes_XPATH").getAttribute("value");
			Thread.sleep(1000);
			String 	Q_ClaimedAsDependent	=	findElement("ClaimedAsDependent_XPATH").getText();
			if(selectedOption.contains("Y"))
			{
				log.debug(Q_ClaimedAsDependent +" : " + "Yes");
				A_ClaimedAsDependent.set("Yes");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",132, Q_ClaimedAsDependent,A_ClaimedAsDependent.get());
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

			}
			else
			{
				log.debug(Q_ClaimedAsDependent+" : " + "No" );
				A_ClaimedAsDependent.set("No");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",132, Q_ClaimedAsDependent,A_ClaimedAsDependent.get());
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}


		}
		public void DependentOnParent_No(String colKey,String colValue) throws Exception 
		{
			WebElement elementToScrollTo2 = findElement("ClaimedAsDependent_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			Thread.sleep(1000);
			click("DependentOnParentNo_XPATH");
			String selectedOption = findElement("DependentOnParentNo_XPATH").getAttribute("value");
			Thread.sleep(1000);
			String 	Q_ClaimedAsDependent	=	findElement("ClaimedAsDependent_XPATH").getText();
			if(selectedOption.contains("Y"))
			{
				log.debug(Q_ClaimedAsDependent +" : " + "Yes");
				A_ClaimedAsDependent.set("Yes");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",132, Q_ClaimedAsDependent,A_ClaimedAsDependent.get());
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

			}
			else
			{
				log.debug(Q_ClaimedAsDependent+" : " + "No" );
				A_ClaimedAsDependent.set("No");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",132, Q_ClaimedAsDependent,A_ClaimedAsDependent.get());
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}


		}

		public void FiftyPercentOfFinancialSupportForParent(String colKey,String colValue) throws Exception 
		{
			WebElement elementToScrollTo = findElement("ParentLegalGuardianPercent_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			Thread.sleep(1000);
			String	ParentLegalGuardianPercent	= getDriver().findElement(By.xpath("//fieldset[@id='group-inputParentOrGuardianSupport']")).getText();
			System.out.println("ParentLegalGuardianPercent :"+ParentLegalGuardianPercent);
			//		 int percentValue = Integer.parseInt(ParentLegalGuardianPercent);

			//		    if (percentValue == 50) 
			////		    {
			if(ParentLegalGuardianPercent.equals(""))
			{
				log.debug("Parent or legal guardian : % of support = 50% ");
				int totalPercentage = 50;
				int numberOfRows = 4;


				Random random = new Random();
				int[] percentages = new int[numberOfRows];


				// Generate random percentages
				for (int i = 0; i < numberOfRows - 1; i++) 
				{
					int bound = Math.max(1, totalPercentage - (numberOfRows - 1));
					percentages[i] = random.nextInt(bound) + 1;
					totalPercentage -= percentages[i];
				}




				// Assign the remaining percentage to the last row
				percentages[numberOfRows - 1] = totalPercentage;


				// Ensure that at least one row has 1%
				int randomRowIndex = random.nextInt(numberOfRows);
				if (percentages[randomRowIndex] > 1) {
					percentages[randomRowIndex]--;
					percentages[randomRowIndex == numberOfRows - 1 ? 0 : randomRowIndex + 1]++;
				}


				// Print the generated percentages
				for (int i = 0; i < numberOfRows; i++) 
				{
					System.out.println("Row " + (i + 1) + ": " + percentages[i] + "%");
				}



				List<WebElement> rows = getDriver().findElements(By.xpath("(//div[@data-cy='arizona-residency-financial-table']//td[2]//input)[position() >=2]"));
				int size = rows.size();



				// To fetch the Titles of the Sources
				List<WebElement> titles = getDriver().findElements(By.xpath("(//div[@data-cy='arizona-residency-financial-table']//td[1])[position() >= 2 and position() <= 5]")); // Fetch from 2nd to  5 titles




				List<String> sourceTitles = new ArrayList<>();
				// To store all the %
				List<String> percentagesSent = new ArrayList<>();




				for (WebElement titleElement : titles) 
				{
					String title = titleElement.getText();
					sourceTitles.add(title);




				}
				for (int i = 0; i < rows.size(); i++) 
				{
					WebElement row = rows.get(i);
					String percentageValue = String.valueOf(percentages[i]);
					row.sendKeys(percentageValue);
					percentagesSent.add(percentageValue); // Store the value in the ArrayList

				}




				for (int i1 = 0,j=133; i1 <= 3; i1++) {
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",j++,sourceTitles.get(i1)+" financial support",percentagesSent.get(i1));
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

				}
			}
			else 
			{
				log.debug("Parent or legal guardian : % of support != 50% ");
			}




		}

		public void DriverLicense_Yes(String colKey,String colValue) throws EncryptedDocumentException, Exception
		{
			// Select YES to Do you have a current driver’s license or state issued ID?
			WebElement elementToScrollTo1 = findElement("HavingLicenceYesRadioBtn_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			click("HavingLicenceYesRadioBtn_XPATH");
			String selectedOption =	findElement("HavingLicenceYesRadioBtn_XPATH").getAttribute("value");
			String 	Q_EnrolledASU	=	findElement("HavingLicenceQuestion_XPATH").getText();
			if(selectedOption.contains("Y"))
			{
				log.debug(Q_EnrolledASU+" "+"Yes");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",137, Q_EnrolledASU,"Yes");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}
			// Select In which state was your license issued?
			WebElement elementToScrollToLS = findElement("LicenseIssuedStateDD_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToLS);
			click("LicenseIssuedStateDD_XPATH");
			//choose AZ 
			WebElement elementToScrollToLSAZ = findElement("AZstateForLicence_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToLSAZ);
			click("AZstateForLicence_XPATH");
			String 	A_LicenseIssuedState	= findElement("LicenseIssuedStateDD_XPATH").getText();
			if(A_LicenseIssuedState.contains("Arizona"))
			{
				log.debug("Is this vehicle registered in the state of Arizona?"+" " + "Yes");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",138," In which state was your license issued? ",A_LicenseIssuedState);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}
			else
			{
				log.debug("Is this vehicle registered in the state of Arizona?"+" " + "No");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",138," In which state was your license issued? ",A_LicenseIssuedState);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}
			// Select When was your license issued?
			WebElement elementToScrollToDL1 = findElement("SelectDLmonth_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDL1);
			click("SelectDLmonth_XPATH");
			Thread.sleep(1000);
			List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			Random random = new Random();
			int randomIndex = random.nextInt(options.size());
			WebElement randomOption = options.get(randomIndex);
			Thread.sleep(1000);
			randomOption.click();
			Thread.sleep(1000);
			WebElement elementToScrollToDL2 = findElement("SelectDLyear_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToDL2);
			click("SelectDLyear_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex1);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			String year = findElement("SelectDLyear_XPATH").getText();
			String monthInWords = findElement("SelectDLmonth_XPATH").getText(); 
			String Q_LicenseIssuedDate = findElement("LicenseIssuedDateQuestion_XPATH").getText(); 
			// Convert month in words to numeric representation using the monthMap
			String month = monthMap.get(monthInWords);
			// Format the selected year and month as 'YYYY-MM'
			String LicenseIssuedDate = year + "-" + month;
			log.debug(Q_LicenseIssuedDate+" "+LicenseIssuedDate);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",139,Q_LicenseIssuedDate,LicenseIssuedDate);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		public void DriverLicense_No(String colKey,String colValue) throws EncryptedDocumentException, Exception
		{
			// Select NO to Do you have a current driver’s license or state issued ID?
			WebElement elementToScrollTo1 = findElement("HavingLicenceYesRadioBtn_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			click("HavingLicenceNoRadioBtn_XPATH");
			String selectedOption =	findElement("HavingLicenceNoRadioBtn_XPATH").getAttribute("value");
			String 	Q_EnrolledASU	=	findElement("HavingLicenceQuestion_XPATH").getText();
			if(selectedOption.contains("No"))
			{
				log.debug(Q_EnrolledASU+" "+"No");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",137, Q_EnrolledASU,"No");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}
		}

		public void OwnVehicleDetails_Yes(String colKey,String colValue) throws EncryptedDocumentException, Exception
		{
			WebElement elementToScrollTo = findElement("OwnvehicleYesRadioBtn_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			click("OwnvehicleYesRadioBtn_XPATH");
			String Q_OwnVehicle	=findElement("OwnVehicleQuestion_XPATH").getText();
			log.debug(Q_OwnVehicle+" "+ "Yes");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",140,Q_OwnVehicle,"Yes");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			Thread.sleep(1000);

			WebElement elementToScrollTo1 = findElement("VehicleRegisteredYesRadioBtn_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			click("VehicleRegisteredYesRadioBtn_XPATH");
			String Q_VehicleRegistered	=findElement("VehicleRegisteredQuestion_XPATH").getText();
			log.debug(Q_VehicleRegistered+" "+ "Yes");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",141," Is this vehicle registered in the state of Arizona? ","Yes");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

			WebElement elementToScrollTo11 = findElement("RegistrationMonthDD_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
			click("RegistrationMonthDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			Random random = new Random();
			int randomIndex = random.nextInt(options.size());
			WebElement randomOption = options.get(randomIndex);
			Thread.sleep(1000);
			randomOption.click();
			Thread.sleep(1000);
			WebElement elementToScrollTo2 = findElement("RegistrationYearDD_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			click("RegistrationYearDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex1);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			String year = findElement("RegistrationYearDD_XPATH").getText();
			String monthInWords = findElement("RegistrationMonthDD_XPATH").getText(); 
			String Q_VehicleRegisteredDate = findElement("VehicleRegisteredQuestion_XPATH").getText(); 
			// Convert month in words to numeric representation using the monthMap
			String month = monthMap.get(monthInWords);
			// Format the selected year and month as 'YYYY-MM'
			String VehicleRegisteredDate = year + "-" + month;
			log.debug(Q_VehicleRegisteredDate+" "+VehicleRegisteredDate);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",142,Q_VehicleRegisteredDate,VehicleRegisteredDate);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		public void OwnVehicleDetails_No(String colKey,String colValue) throws EncryptedDocumentException, Exception
		{
			WebElement elementToScrollTo = findElement("OwnVehicleQuestion_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			click("OwnvehicleNoRadioBtn_XPATH");
			String Q_OwnVehicle	=findElement("OwnVehicleQuestion_XPATH").getText();
			log.debug(Q_OwnVehicle+" "+ "No");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",140,Q_OwnVehicle,"No");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		public void StateTaxes_Yes(String colKey,String colValue) throws Exception
		{
			WebElement elementToScrollTo = findElement("DidFileStateTaxYesRadioBtn_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			click("DidFileStateTaxYesRadioBtn_XPATH");
			log.debug(" Did you, or will you, file state taxes for 2022? : Yes");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",143," Did you, or will you, file state taxes for 2022? ","Yes");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


			WebElement elementToScrollTo1 = findElement("DidFileStateTaxYesRadioBtn_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			click("StateTaxLocDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex1);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			String A_LocStateTax = findElement("StateTaxLocDD_XPATH").getText();
			String Q_LocStateTax = findElement("StateTaxQuestion_XPATH").getText();
			log.debug(Q_LocStateTax+" "+A_LocStateTax);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",144," Where did or where will you file your state taxes for 2022? ", A_LocStateTax);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


		}
		public void StateTaxes_No(String colKey,String colValue) throws Exception
		{
			WebElement elementToScrollTo = findElement("DidFileStateTaxNoRadioBtn_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			click("DidFileStateTaxNoRadioBtn_XPATH");
			log.debug(" Did you, or will you, file state taxes for 2022? : No");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",143," Did you, or will you, file state taxes for 2022? ","No");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}

		public void FinancialSupport(String colKey,String colValue) throws Exception 
		{
			int totalPercentage = 100;
			int numberOfRows = 5;


			Random random = new Random();
			int[] percentages = new int[numberOfRows];


			// Generate random percentages
			for (int i = 0; i < numberOfRows - 1; i++) {
				int bound = Math.max(1, totalPercentage - (numberOfRows - 1));
				percentages[i] = random.nextInt(bound) + 1;
				totalPercentage -= percentages[i];
			}



			// Assign the remaining percentage to the last row
			percentages[numberOfRows - 1] = totalPercentage;


			// Ensure that at least one row has 1%
			int randomRowIndex = random.nextInt(numberOfRows);
			if (percentages[randomRowIndex] > 1) {
				percentages[randomRowIndex]--;
				percentages[randomRowIndex == numberOfRows - 1 ? 0 : randomRowIndex + 1]++;
			}


			// Print the generated percentages
			for (int i = 0; i < numberOfRows; i++) 
			{
				System.out.println("Row " + (i + 1) + ": " + percentages[i] + "%");
			}


			//		
			//		WebElement elementToScrollTo = getDriver().findElement(By.xpath("//div[@data-cy='arizona-residency-financial-table']"));
			//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			//		Random random = new Random();
			//		int[] percentages = new int[5]; // Assuming 5 rows
			//
			//		int remainingPercentage = 100;
			//		for (int i = 0; i < percentages.length - 1; i++) {
			//			// Generate random percentage between 1 and remainingPercentage
			//			if (remainingPercentage > 0) {
			//				percentages[i] = random.nextInt(remainingPercentage) + 1;
			//				remainingPercentage -= percentages[i];
			//			} else {
			//				// If remainingPercentage is 0, assign 1 to avoid IllegalArgumentException
			//				percentages[i] = 1;
			//			}
			//		}
			//
			//		// Assign the remaining percentage to the last row
			//		percentages[percentages.length - 1] = remainingPercentage;


			List<WebElement> rows = getDriver().findElements(By.xpath("//div[@data-cy='arizona-residency-financial-table']//td[2]//input"));
			int size = rows.size();



			// To fetch the Titles of the Sources
			List<WebElement> titles = getDriver().findElements(By.xpath("(//div[@data-cy='arizona-residency-financial-table']//td[1])[position() <= 5]")); // Fetch only the first 5 titles




			List<String> sourceTitles = new ArrayList<>();
			// To store all the %
			List<String> percentagesSent = new ArrayList<>();




			for (WebElement titleElement : titles) 
			{
				String title = titleElement.getText();
				sourceTitles.add(title);




			}
			for (int i = 0; i < rows.size(); i++) 
			{
				WebElement row = rows.get(i);
				String percentageValue = String.valueOf(percentages[i]);
				row.sendKeys(percentageValue);
				percentagesSent.add(percentageValue); // Store the value in the ArrayList

			}




			for (int i1 = 0,j=144; i1 <= 4; i1++) {
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",j++,sourceTitles.get(i1)+" financial support",percentagesSent.get(i1));
				saveReport(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");

			}


			int totalSum = 0;
			for (int i = 0; i < rows.size(); i++) 
			{
				WebElement row = rows.get(i);
				totalSum += Integer.parseInt(row.getAttribute("value"));
			}


			if (totalSum == 100) {
				log.debug("Total sum is 100.");
			} else {
				log.debug("Total sum is not 100.");
			}
		}
		public void OtherFinancialSupport(String colKey,String colValue) throws InterruptedException 
		{
			try
			{
				if(getDriver().findElement(By.xpath("//fieldset[@data-cy='arizona-residency-other-options']")).isDisplayed())
				{
					Thread.sleep(2000);
					WebElement elementToScrollTo1 = getDriver().findElement(By.xpath("//fieldset[@data-cy='arizona-residency-other-options']"));
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
					log.debug("Choose Other Financial Support Options");




					// Choose random Option
					Thread.sleep(1000);
					List<WebElement> Checkboxes = getDriver().findElements(By.xpath("//fieldset[@data-cy='arizona-residency-other-options']//input/following-sibling::label//span"));
					int Count = Checkboxes.size();
					Random random = new Random();
					int randomIndex = random.nextInt(Checkboxes.size());
					WebElement element = Checkboxes.get(randomIndex);
					Thread.sleep(1000);
					String selectedOption = element.getText();
					Thread.sleep(500);
					log.debug("Selected Other Financial Support : " + selectedOption);
					((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);




					List<String> Titles = new ArrayList<>();
					List<String> YesNoValues = new ArrayList<>();




					for (WebElement X : Checkboxes)
					{
						String CheckboxText = X.getText();
						Titles.add(CheckboxText); // Add Checkbox title to Titles list
						if (X.equals(element)) 
						{
							YesNoValues.add("Y"); // Selected checkbox is 'Yes'
						} else 
						{
							YesNoValues.add("N"); // Other checkboxes are 'No'
						}
					}




					for (int i = 0,j=150; i <= 7; i++) 
					{
						initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData",j++,Titles.get(i)+" financial support", YesNoValues.get(i));
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}

				}

			}

			catch(Exception e) {}


		}


		public void SourceOfSupport()
		{
			try
			{
				if(findElement("DescribeSourceOfSupport_XPATH").isDisplayed())
				{

					WebElement elementToScrollTo = findElement("DescribeSourceOfSupportQuestion_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
					Thread.sleep(500);
					type("DescribeSourceOfSupport_XPATH","Test Source of Support");
					Thread.sleep(500);
				}
			}
			catch(Exception e) {}
		}



		public void EmploymentDetails_Yes(String colKey,String colValue) throws Exception
		{
			WebElement elementToScrollTo = findElement("CurrentlyEmployedQuestion_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			click("EmployedYesRdBtn_XPATH");
			Thread.sleep(1000);
			log.debug(" Are you currently employed? : Yes");
			WebElement elementToScrollTo1 = findElement("PrimaryWorkLocYesDD_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			click("PrimaryWorkLocYesDD_XPATH");
			Thread.sleep(1000);
			click("PrimaryWorkAZloc_XPATH");
			Thread.sleep(1000);


			WebElement elementToScrollTo2= findElement("EmplyomentLocDateQuestion_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);



			click("EmploymentLocMonthDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			Random random = new Random();
			int randomIndex = random.nextInt(options.size());
			WebElement randomOption = options.get(randomIndex);
			Thread.sleep(1000);
			randomOption.click();
			Thread.sleep(1000);
			WebElement elementToScroll = findElement("EmploymentLocYearDD_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
			click("EmploymentLocYearDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options1.size());
			WebElement randomOption1 = options1.get(randomIndex1);
			Thread.sleep(1000);
			randomOption1.click();
			Thread.sleep(1000);
			String year = findElement("EmploymentLocYearDD_XPATH").getText();
			String monthInWords = findElement("EmploymentLocMonthDD_XPATH").getText(); 
			String Q_EmplyomentLocDateQuestion = findElement("EmplyomentLocDateQuestion_XPATH").getText(); 
			// Convert month in words to numeric representation using the monthMap
			String month = monthMap.get(monthInWords);
			// Format the selected year and month as 'YYYY-MM'
			String EmlyomentLocationDate = year + "-" + month;
			log.debug(Q_EmplyomentLocDateQuestion+" "+EmlyomentLocationDate);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",157," Are you currently employed? ", "Yes");
			setExcelData(colKey,colValue,"validData",158," Where is your primary work location? ", "Arizona");
			setExcelData(colKey,colValue,"validData",159,Q_EmplyomentLocDateQuestion, EmlyomentLocationDate);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}

		public void EmploymentDetails_No(String colKey,String colValue) throws Exception
		{
			// Are you currently employed? - NO
			WebElement elementToScrollTo = findElement("CurrentlyEmployedQuestion_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			click("EmployedNoRdBtn_XPATH");
			Thread.sleep(1000);
			log.debug(" Are you currently employed? : No");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",157, "Are you currently employed?","No");
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

			// Were you employed in the last 12 months? - Random
			WebElement elementToScrollTo1 = findElement("EmployedLast12months_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
			List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='radio_isEmployedInLast12m']"));
			int Count = radioButtons.size();
			Random random = new Random();
			int randomIndex = random.nextInt(radioButtons.size());
			// Get the text of the randomly selected radio button
			String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
			// Click the randomly selected radio button
			Thread.sleep(1000);
			radioButtons.get(randomIndex).click();
			Thread.sleep(1000);
			String 	Q_EmployedLast12months	=	findElement("EmployedLast12months_XPATH").getText();
			if(selectedOption.contains("Y"))
			{
				log.debug(Q_EmployedLast12months +" : " + "Yes");
				A_EmployedLast12months.set("Yes");
				Thread.sleep(1000);
				WebElement elementToScrollTo11 = findElement("PrimaryWorkLocNoDD_XPATH");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo11);
				click("PrimaryWorkLocNoDD_XPATH");
				// Randomly select Primary Work loc
				Thread.sleep(1000);
				List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options = options.size();
				Random random1 = new Random();
				int randomIndex1 = random1.nextInt(options.size());
				WebElement randomOption = options.get(randomIndex1);
				Thread.sleep(500);
				randomOption.click();
				Thread.sleep(500);
				String 	selectedLPrimaryWorkLoc	=	findElement("PrimaryWorkLocNoDD_XPATH").getText();
				log.debug("Selected Primary language option: " + selectedLPrimaryWorkLoc);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",158, Q_EmployedLast12months,A_EmployedLast12months.get());
				setExcelData(colKey,colValue,"validData",159, "Where was your primary work location? ",selectedLPrimaryWorkLoc);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}
			else
			{
				log.debug(Q_EmployedLast12months+" : " + "No" );
				A_EmployedLast12months.set("No");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",158, Q_EmployedLast12months,A_EmployedLast12months.get());
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}


		}
		public void SpouseOrDependentflow(String colKey,String colValue) throws EncryptedDocumentException, Exception
		{
			WebElement elementToScroll = findElement("SpouseDependentDD_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
			click("SpouseDependentDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options = options.size();
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options.size());
			WebElement randomOption = options.get(randomIndex1);
			Thread.sleep(1000);
			randomOption.click();
			Thread.sleep(1000);
			String 	selectedSpouseOrDependentText	= findElement("SpouseDependentDD_XPATH").getText();
			Thread.sleep(1000);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",159," You indicated that you were the spouse or dependent of a U.S. service member or veteran. Which best describes the service member or veteran? ", selectedSpouseOrDependentText);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			if(selectedSpouseOrDependentText.contains("Veteran"))
			{


				log.debug("Selected Service member or veteran: "+" "+selectedSpouseOrDependentText);
				WebElement elementToScroll1 = findElement("RegisteredToVoteQuestion_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
				click("RegisteredToVoteYesRdBtn_XPATH");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",160," Are you registered to vote? ", "Yes");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				WebElement elementToScroll11 = findElement("RegisteredToVoteStateDD_ID");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll11);
				click("RegisteredToVoteStateDD_ID");
				Thread.sleep(1000);
				List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options1 = options1.size();
				Random random11 = new Random();
				int randomIndex11 = random11.nextInt(options1.size());
				WebElement randomOption1 = options1.get(randomIndex11);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				String Q_RegisteredToVoteStateQuestion = findElement("RegisteredToVoteStateQuestion_XPATH").getText();
				String 	selectedRegisteredToVoteStateText	= findElement("RegisteredToVoteStateDD_ID").getText();
				log.debug(Q_RegisteredToVoteStateQuestion+" "+selectedRegisteredToVoteStateText);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",161,Q_RegisteredToVoteStateQuestion, selectedRegisteredToVoteStateText);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




				WebElement elementToScrollTo2= findElement("PGSactiveDutyQuestion_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
				click("PGSactiveDutymm_ID");
				Thread.sleep(1000);
				List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random = new Random();
				int randomIndex = random.nextInt(options11.size());
				WebElement randomOption11 = options11.get(randomIndex);
				Thread.sleep(2000);
				randomOption11.click();
				Thread.sleep(1000);
				click("PGSactiveDutyyy_ID");
				Thread.sleep(1000);
				List<WebElement> options111  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random111 = new Random();
				int randomIndex111 = random111.nextInt(options111.size());
				WebElement randomOption111 = options111.get(randomIndex111);
				Thread.sleep(1000);
				randomOption111.click();
				Thread.sleep(1000);
				String year = findElement("PGSactiveDutyyy_ID").getText();
				String monthInWords = findElement("PGSactiveDutymm_ID").getText(); 
				String PGSactiveDutyQuestion = findElement("PGSactiveDutyQuestion_XPATH").getText(); 
				String month = monthMap.get(monthInWords);
				String PGSLocationDate = year + "-" + month;
				log.debug(PGSactiveDutyQuestion+" "+PGSLocationDate);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",162,PGSactiveDutyQuestion, PGSLocationDate);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




				// Are you eligible for Chapter 30 or Chapter 33 benefits?
				WebElement elementToScrollTo = findElement("EligibileChapter30BenefitsQuestion_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				Thread.sleep(500);
				List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='employment_radio_isEligibleFor30or33ChapterBenefits']"));
				int Count = radioButtons.size();
				Random random1111 = new Random();
				int randomIndex2 = random1111.nextInt(radioButtons.size());
				String selectedOption = radioButtons.get(randomIndex2).getAttribute("value");
				Thread.sleep(1000);
				radioButtons.get(randomIndex2).click();
				Thread.sleep(1000);
				if(selectedOption.contains("Y"))
				{
					log.debug( "Selected Option: " + "Yes");
					A_EligibleForChapter30.set("Yes");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",163," Are you eligible for Chapter 30 or Chapter 33 benefits? ", A_EligibleForChapter30.get());
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				}
				else
				{
					log.debug("Selected Option: " + "No" );
					A_EligibleForChapter30.set("No");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",163," Are you eligible for Chapter 30 or Chapter 33 benefits? ", A_EligibleForChapter30.get());
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				}




			}
			if(selectedSpouseOrDependentText.contains("Not Applicable"))
			{
				log.debug("Selected Service member or veteran: "+" "+selectedSpouseOrDependentText);


			}
			if(selectedSpouseOrDependentText.contains("Active Duty")|| selectedSpouseOrDependentText.contains("Armed Forces Reserve")|| selectedSpouseOrDependentText.contains("National Guard"))
			{
				// Spouse/Parent/Guardian Stationed
				log.debug("Selected Service member or veteran: "+" "+selectedSpouseOrDependentText);
				WebElement elementToScroll1 = findElement("SpouseParentGuardianDD_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
				click("SpouseParentGuardianDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options1 = options1.size();
				Random random11 = new Random();
				int randomIndex11 = random11.nextInt(options1.size());
				WebElement randomOption1 = options1.get(randomIndex11);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				String 	selectedLocText	= findElement("SpouseParentGuardianDD_XPATH").getText();
				log.debug("Selected option: " + selectedLocText);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",160," Where is your spouse/parent/guardian currently stationed? ", selectedLocText);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				if(!selectedSpouseOrDependentText.contains("Arizona"))
				{
					Thread.sleep(1000);
					WebElement elementTo = findElement("SpouseParentGuardianLegalResid_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementTo);
					click("SpouseParentGuardianLegalResid_XPATH");
					Thread.sleep(1000);
					List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
					int Options11 = options11.size();
					Random random111 = new Random();
					int randomIndex111 = random111.nextInt(options11.size());
					WebElement randomOption11 = options11.get(randomIndex111);
					Thread.sleep(1000);
					randomOption11.click();
					Thread.sleep(1000);
					String 	selectedText	= findElement("SpouseParentGuardianLegalResid_XPATH").getText();
					log.debug("Selected option: " + selectedText);
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",161,"What is your spouse/parent/guardians state of legal residence?", selectedText);
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				}
			}


		}


		public void ActiveDutyflow(String colKey,String colValue) throws EncryptedDocumentException, Exception
		{
			WebElement elementToScroll = findElement("CurrentStationedLocQuestion_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
			click("CurrentStationedDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options = options.size();
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options.size());
			WebElement randomOption = options.get(randomIndex1);
			Thread.sleep(1000);
			randomOption.click();
			Thread.sleep(1000);
			String 	selectedCurrentStationedLocQuestioText_Q	= findElement("CurrentStationedLocQuestion_XPATH").getText();
			String 	selectedCurrentStationedDDText_A	= findElement("CurrentStationedDD_XPATH").getText();

			Thread.sleep(1000);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",164,selectedCurrentStationedLocQuestioText_Q, selectedCurrentStationedDDText_A);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			if(!selectedCurrentStationedDDText_A.contains("Arizona"))
			{
				WebElement elementToScroll1 = findElement("LESquestion_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
				click("LESquestionDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options1 = options1.size();
				Random random11 = new Random();
				int randomIndex11 = random11.nextInt(options1.size());
				WebElement randomOption1 = options1.get(randomIndex11);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				String 	LESquestionText_Q	= findElement("LESquestion_XPATH").getText();
				String LESquestion_A	= findElement("LESquestionDD_XPATH").getText();
				Thread.sleep(1000);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",165,LESquestionText_Q, LESquestion_A);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


			}

		}


		public void Veteranflow(String colKey,String colValue) throws EncryptedDocumentException, Exception
		{
			WebElement elementToScroll = findElement("VeteranDD214_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
			click("VeteranDD214dd_XPATH");
			Thread.sleep(1000);
			List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options = options.size();
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options.size());
			WebElement randomOption = options.get(randomIndex1);
			Thread.sleep(1000);
			randomOption.click();
			Thread.sleep(1000);
			String 	selectedVeteranDD214Text = findElement("VeteranDD214dd_XPATH").getText();
			Thread.sleep(1000);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",166,"You indicated that you are a veteran of the US military. Which character of service is noted on your DD-214? ", selectedVeteranDD214Text);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


			try
			{
				if(findElement("EligibileChapter30BenefitsQuestion_XPATH").isDisplayed())
				{
					// Are you eligible for Chapter 30 or Chapter 33 benefits?
					WebElement elementToScrollTo = findElement("EligibileChapter30BenefitsQuestion_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
					Thread.sleep(500);
					List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='employment_radio_isEligibleFor30or33ChapterBenefits']"));
					int Count = radioButtons.size();
					Random random1111 = new Random();
					int randomIndex2 = random1111.nextInt(radioButtons.size());
					String selectedOption = radioButtons.get(randomIndex2).getAttribute("value");
					Thread.sleep(1000);
					radioButtons.get(randomIndex2).click();
					Thread.sleep(1000);
					if(selectedOption.contains("Y"))
					{
						log.debug( "Selected Option: " + "Yes");
						A_EligibleForChapter30.set("Yes");
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData",167," Are you eligible for Chapter 30 or Chapter 33 benefits? ", A_EligibleForChapter30.get());
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}
					else
					{
						log.debug("Selected Option: " + "No" );
						A_EligibleForChapter30.set("No");
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData",167," Are you eligible for Chapter 30 or Chapter 33 benefits? ", A_EligibleForChapter30.get());
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}
				}
			}


			catch (Exception e) {}



			// Discharged or released from Active Duty
			WebElement elementToScrollTo2= findElement("DischargedFromActiveDuty_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
			click("DischargedFromActiveDutyMM_ID");
			Thread.sleep(1000);
			List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			Random random = new Random();
			int randomIndex = random.nextInt(options11.size());
			WebElement randomOption11 = options11.get(randomIndex);
			Thread.sleep(1000);
			randomOption11.click();
			Thread.sleep(1000);
			click("DischargedFromActiveDutyYY_ID");
			Thread.sleep(1000);
			List<WebElement> options111  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			Random random111 = new Random();
			int randomIndex111 = random111.nextInt(options111.size());
			WebElement randomOption111 = options111.get(randomIndex111);
			Thread.sleep(1000);
			randomOption111.click();
			Thread.sleep(1000);
			String year = findElement("DischargedFromActiveDutyYY_ID").getText();
			String monthInWords = findElement("DischargedFromActiveDutyMM_ID").getText(); 
			String ActiveDutyQuestion = findElement("DischargedFromActiveDuty_XPATH").getText(); 
			String month = monthMap.get(monthInWords);
			String ActiveDutyLocationDate = year + "-" + month;
			log.debug(ActiveDutyQuestion+" "+ActiveDutyLocationDate);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",168,ActiveDutyQuestion, ActiveDutyLocationDate);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		}
		//	else 
		//	{
		//		WebElement elementToScrollTo2= findElement("DischargedFromActiveDuty_XPATH");
		//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
		//		click("DischargedFromActiveDutyMM_ID");
		//		Thread.sleep(1000);
		//		List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		//		Random random = new Random();
		//		int randomIndex = random.nextInt(options11.size());
		//		WebElement randomOption11 = options11.get(randomIndex);
		//		Thread.sleep(1000);
		//		randomOption11.click();
		//		Thread.sleep(1000);
		//		click("DischargedFromActiveDutyYY_ID");
		//		Thread.sleep(1000);
		//		List<WebElement> options111  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
		//		Random random111 = new Random();
		//		int randomIndex111 = random111.nextInt(options111.size());
		//		WebElement randomOption111 = options111.get(randomIndex111);
		//		Thread.sleep(1000);
		//		randomOption111.click();
		//		Thread.sleep(1000);
		//		String year = findElement("DischargedFromActiveDutyYY_ID").getText();
		//		String monthInWords = findElement("DischargedFromActiveDutyYY_ID").getText(); 
		//		String ActiveDutyQuestion = findElement("DischargedFromActiveDutyMM_ID").getText(); 
		//		String month = monthMap.get(monthInWords);
		//		String ActiveDutyLocationDate = year + "-" + month;
		//		log.debug(ActiveDutyQuestion+" "+ActiveDutyLocationDate);
		//		// initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		//		setExcelData(colKey,colValue,"validData",167,ActiveDutyQuestion, ActiveDutyLocationDate);
		//		// saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
		//

		//	}



		public void ArmedForcesReserveOrNationalGuradianflow(String colKey,String colValue) throws EncryptedDocumentException, Exception
		{
			WebElement elementToScroll = findElement("CurrentStationedLocQuestion_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
			click("CurrentStationedDD_XPATH");
			Thread.sleep(1000);
			List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options = options.size();
			Random random1 = new Random();
			int randomIndex1 = random1.nextInt(options.size());
			WebElement randomOption = options.get(randomIndex1);
			Thread.sleep(1000);
			randomOption.click();
			Thread.sleep(1000);
			String 	selectedCurrentStationedLocQuestioText_Q	= findElement("CurrentStationedLocQuestion_XPATH").getText();
			String 	selectedCurrentStationedDDText_A	= findElement("CurrentStationedDD_XPATH").getText();

			Thread.sleep(1000);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",168,selectedCurrentStationedLocQuestioText_Q, selectedCurrentStationedDDText_A);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			if(!selectedCurrentStationedDDText_A.contains("Arizona"))
			{
				WebElement elementToScroll1 = findElement("LESquestion_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
				click("LESquestionDD_XPATH");
				Thread.sleep(1000);
				List<WebElement> options1 = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options1 = options1.size();
				System.out.println(Options1);
				// Generate a random index to choose a random option
				Random random11 = new Random();
				int randomIndex11 = random11.nextInt(options1.size());
				// Click on the random option
				WebElement randomOption1 = options1.get(randomIndex11);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				String 	LESquestionText_Q	= findElement("LESquestion_XPATH").getText();
				String LESquestion_A	= findElement("LESquestionDD_XPATH").getText();
				Thread.sleep(1000);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",169,LESquestionText_Q, LESquestion_A);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


			}

		}


		public  void AmericanIndianOrAlaskaNAtive(String colKey,String colValue)
		{
			try
			{
				if(findElement("AmericanIndianAlaskaNativeQuestion_XPATH").isDisplayed())
				{
					// Randomly Click on Yes OR No
					WebElement elementToScrollTo2 = findElement("AmericanIndianAlaskaNativeQuestion_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
					Thread.sleep(2000);
					List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='employment_radio_isNativeAmerican']"));
					int Count = radioButtons.size();
					Random random = new Random();
					int randomIndex = random.nextInt(radioButtons.size());
					String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
					Thread.sleep(1000);
					radioButtons.get(randomIndex).click();
					Thread.sleep(1000);
					String Q_AmericanIndianAlaskaNativeString = findElement("AmericanIndianAlaskaNativeQuestion_XPATH").getText();
					if(selectedOption.contains("Y"))
					{
						log.debug( "Selected Option: " + "Yes");
						A_AmericanIndianAlaskaNativeString.set("Yes");
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData",170,Q_AmericanIndianAlaskaNativeString, A_AmericanIndianAlaskaNativeString.get());
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}
					else
					{
						log.debug("Selected Option: " + "No" );
						A_AmericanIndianAlaskaNativeString.set("No");
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData",170,Q_AmericanIndianAlaskaNativeString, A_AmericanIndianAlaskaNativeString.get());
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}
				}
			}
			catch(Exception e) {}
		}








		public void ParentLegalGuardianDetails_AZ(String colKey,String colValue) throws EncryptedDocumentException, Exception
		{
			try
			{
				Thread.sleep(1000);
				WebElement elementToScrollTo = findElement("ParentCurrentLocDD_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
				Thread.sleep(1000);
				click("ParentCurrentLocDD_XPATH");
				Thread.sleep(1000);
				click("ParentCurrentLocAZDD_XPATH");
				initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",171," In which state do your parent(s) or legal guardian(s) currently live? ", "Arizona");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				WebElement elementToScrollTo1 = findElement("WhichParent_CSS");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				click("WhichParent_CSS");
				Thread.sleep(1000);
				List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options11 = options11.size();
				Random random111 = new Random();
				int randomIndex111 = random111.nextInt(options11.size());
				WebElement randomOption11 = options11.get(randomIndex111);
				Thread.sleep(1000);
				randomOption11.click();
				Thread.sleep(1000);
				String 	selectedText	= findElement("WhichParent_CSS").getText();
				log.debug("Selected option: " + selectedText);
				Thread.sleep(1000);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",172," Which parent or legal guardian lives in Arizona? ", selectedText);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




				// When did your parent(s) or legal guardian(s) begin living in Arizona continuously?
				WebElement elementToScrollTo1111 = findElement("ParentLiveInAZquestion_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
				click("ParentLivesAZmm_CSS");
				Thread.sleep(1000);
				List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random = new Random();
				int randomIndex = random.nextInt(options.size());
				WebElement randomOption = options.get(randomIndex);
				Thread.sleep(1000);
				randomOption.click();
				Thread.sleep(1000);
				WebElement elementToScrollTo2 = findElement("ParentLivesAZyy_CSS");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
				click("ParentLivesAZyy_CSS");
				Thread.sleep(1000);
				List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random1 = new Random();
				int randomIndex1 = random1.nextInt(options1.size());
				WebElement randomOption1 = options1.get(randomIndex1);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				String year = findElement("ParentLivesAZmm_CSS").getText();
				String monthInWords = findElement("ParentLivesAZyy_CSS").getText(); 
				String Q_ParentLivingInAZ = findElement("ParentLiveInAZquestion_XPATH").getText(); 
				// Convert month in words to numeric representation using the monthMap
				String month = monthMap.get(monthInWords);
				// Format the selected year and month as 'YYYY-MM'
				String A_ParentLivingInAZDate = year + "-" + month;
				log.debug(Q_ParentLivingInAZ+" "+A_ParentLivingInAZDate);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",116,Q_ParentLivingInAZ, A_ParentLivingInAZDate);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




				// Parent State Income Tax Return
				WebElement elementToScroll = findElement("ParentStateTaxQuestion_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
				click("ParentStateTaxYesRdBtn_XPATH");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",173," Did or will your parent(s) or legal guardian(s) file a state income tax return for the 2022 tax year? ", "Yes");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				WebElement elementToScroll1 = findElement("ParentStateTaxLocQuestion_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
				click("ParentStateTaxLocDD_CSS");
				Thread.sleep(1000);
				List<WebElement> options111  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options111 = options111.size();
				Random random1111 = new Random();
				int randomIndex1111 = random1111.nextInt(options111.size());
				WebElement randomOption111 = options111.get(randomIndex1111);
				Thread.sleep(1000);
				randomOption111.click();
				Thread.sleep(1000);
				String 	selectedText1	= findElement("ParentStateTaxLocDD_CSS").getText();
				log.debug("Selected option: " + selectedText1);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",174," In which state did, or will, your parent(s) or legal guardian(s) file state income taxes? ", selectedText1);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");




				// Parent Driver license question
				WebElement elementToScrollToQ = findElement("ParentDLQuestion_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToQ);
				List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='employment_radio_isParentHavingLicenseInAz']"));
				int Count = radioButtons.size();
				Random random11 = new Random();
				int randomIndex11 = random11.nextInt(radioButtons.size());
				String selectedAnswer = radioButtons.get(randomIndex11).getAttribute("value");
				Thread.sleep(1000);
				radioButtons.get(randomIndex11).click();
				Thread.sleep(1000);
				if(selectedAnswer.contains("Y"))
				{
					log.debug( "Does either parent or legal guardian have a current Arizona driver license?" + "Yes");
					A_ParentHaveDLString.set("Yes");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",175," Does either parent or legal guardian have a current Arizona driver license? ", "Yes");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				}
				if(selectedAnswer.contains("N"))
				{
					log.debug("Does either parent or legal guardian have a current Arizona driver license?" + "No" );
					A_ParentHaveDLString.set("No");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",175," Does either parent or legal guardian have a current Arizona driver license? ", "No");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				}


				// Parent Employment question
				WebElement elementTo = findElement("ParentEmployedQuestion_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementTo);
				List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='employment_radio_isParentEmployedInAz']"));
				int Count1 = radioButtons1.size();
				Random random11111 = new Random();
				int randomIndex11111 = random11111.nextInt(radioButtons1.size());
				String selectedOpt = radioButtons1.get(randomIndex11111).getAttribute("value");
				Thread.sleep(1000);
				radioButtons1.get(randomIndex11111).click();
				Thread.sleep(1000);
				if(selectedOpt.contains("Y"))
				{
					log.debug( "Selected Option: " + "Yes");
					A_ParentEmloyedInAZString.set("Yes");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",176," Is either parent or legal guardian employed in Arizona? ", A_ParentEmloyedInAZString.get());
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				}
				if(selectedOpt.contains("N"))
				{
					log.debug("Selected Option: " + "No" );
					A_ParentEmloyedInAZString.set("No");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",176," Is either parent or legal guardian employed in Arizona? ", A_ParentEmloyedInAZString.get());
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				}}


			catch(Exception e) {}


		}







		public void ParentLegalGuardianDetails(String colKey,String colValue) throws EncryptedDocumentException, Exception
		{
			WebElement elementToScrollTo = findElement("ParentCurrentLocDD_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
			Thread.sleep(2000);
			click("ParentCurrentLocDD_XPATH");	
			Thread.sleep(2000);
			List<WebElement> options111  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
			int Options111 = options111.size();
			Random random1111 = new Random();
			int randomIndex1111 = random1111.nextInt(options111.size());
			WebElement randomOption111 = options111.get(randomIndex1111);
			Thread.sleep(1000);
			randomOption111.click();
			Thread.sleep(1000);
			String 	selectedText1	= findElement("ParentCurrentLocDD_XPATH").getText();
			log.debug("Selected option: " + selectedText1);
			initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			setExcelData(colKey,colValue,"validData",177,"In which state do your parent(s) or legal guardian(s) currently live? ", selectedText1);
			saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

			if(selectedText1.equals("Arizona"))
			{
				WebElement elementToScrollTo1 = findElement("WhichParent_CSS");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1);
				click("WhichParent_CSS");
				Thread.sleep(1000);
				List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options11 = options11.size();
				Random random111 = new Random();
				int randomIndex111 = random111.nextInt(options11.size());
				WebElement randomOption11 = options11.get(randomIndex111);
				Thread.sleep(1000);
				randomOption11.click();
				Thread.sleep(1000);
				String 	selectedText	= findElement("WhichParent_CSS").getText();
				log.debug("Selected option: " + selectedText);
				Thread.sleep(1000);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",178," Which parent or legal guardian lives in Arizona? ", selectedText);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

				// When did your parent(s) or legal guardian(s) begin living in Arizona continuously?
				WebElement elementToScrollTo1111 = findElement("ParentLiveInAZquestion_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
				click("ParentLivesAZmm_CSS");
				Thread.sleep(1000);
				List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random = new Random();
				int randomIndex1 = random.nextInt(options1.size());
				WebElement randomOption = options1.get(randomIndex1);
				Thread.sleep(1000);
				randomOption.click();
				Thread.sleep(1000);
				WebElement elementToScrollTo2 = findElement("ParentLivesAZyy_CSS");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
				click("ParentLivesAZyy_CSS");
				Thread.sleep(1000);
				List<WebElement> options1111  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				Random random1 = new Random();
				int randomIndex11 = random1.nextInt(options1111.size());
				WebElement randomOption1 = options1111.get(randomIndex11);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				String year = findElement("ParentLivesAZmm_CSS").getText();
				String monthInWords = findElement("ParentLivesAZyy_CSS").getText(); 
				String Q_ParentLivingInAZ = findElement("ParentLiveInAZquestion_XPATH").getText(); 
				// Convert month in words to numeric representation using the monthMap
				String month = monthMap.get(monthInWords);
				// Format the selected year and month as 'YYYY-MM'
				String A_ParentLivingInAZDate = year + "-" + month;
				log.debug(Q_ParentLivingInAZ+" "+A_ParentLivingInAZDate);

				// Parent State Income Tax Return  
				WebElement elementToScroll = findElement("ParentStateTaxQuestion_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
				click("ParentStateTaxNoRdBtn_XPATH");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",179," Did or will your parent(s) or legal guardian(s) file a state income tax return for the 2022 tax year? ", "No");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

				// Parent Driver license question  - Random
				WebElement elementToScrollToQ = findElement("ParentDLQuestion_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollToQ);
				List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='employment_radio_isParentHavingLicenseInAz']"));
				int Count = radioButtons.size();
				Random random11 = new Random();
				int randomIndex11111 = random11.nextInt(radioButtons.size());
				String selectedAnswer = radioButtons.get(randomIndex11111).getAttribute("value");
				Thread.sleep(1000);
				radioButtons.get(randomIndex11111).click();
				Thread.sleep(1000);
				if(selectedAnswer.contains("Y"))
				{
					log.debug( " Does either parent or legal guardian have a current Arizona driver license? " + "Yes");
					A_ParentHaveDLString.set("Yes");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",180," Does either parent or legal guardian have a current Arizona driver license? ", "Yes");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				}
				if(selectedAnswer.contains("N"))
				{
					log.debug(" Does either parent or legal guardian have a current Arizona driver license? " + "No" );
					A_ParentHaveDLString.set("No");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",180," Does either parent or legal guardian have a current Arizona driver license? ", "No");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				}
				// Parent Employment question - Random
				WebElement elementTo = findElement("ParentEmployedQuestion_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementTo);
				List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='employment_radio_isParentEmployedInAz']"));
				int Count1 = radioButtons1.size();
				Random random11111 = new Random();
				int randomIndex111111 = random11111.nextInt(radioButtons1.size());
				String selectedOpt = radioButtons1.get(randomIndex111111).getAttribute("value");
				Thread.sleep(1000);
				radioButtons1.get(randomIndex111111).click();
				Thread.sleep(1000);
				if(selectedOpt.contains("Y"))
				{
					log.debug( "Selected Option: " + "Yes");
					A_ParentEmloyedInAZString.set("Yes");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",181," Is either parent or legal guardian employed in Arizona? ", A_ParentEmloyedInAZString.get());
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				}
				if(selectedOpt.contains("N"))
				{
					log.debug("Selected Option: " + "No" );
					A_ParentEmloyedInAZString.set("No");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",181," Is either parent or legal guardian employed in Arizona? ", A_ParentEmloyedInAZString.get());
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				}

			}
		}


		public void MarriageQuestion(String colKey,String colValue) throws EncryptedDocumentException, Exception
		{
			try
			{
				WebElement elementTo = findElement("Marriage_XPATH");
				this.js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementTo);
				List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='employment_radio_isMarried']"));
				int Count1 = radioButtons1.size();
				Random random11111 = new Random();
				int randomIndex11111 = random11111.nextInt(radioButtons1.size());
				String selectedOpt = radioButtons1.get(randomIndex11111).getAttribute("value");
				Thread.sleep(1000);
				radioButtons1.get(randomIndex11111).click();
				Thread.sleep(1000);
				if(selectedOpt.contains("Y"))
				{
					log.debug( "Are you married? :" + "Yes");
					A_MarriedQuestion.set("Yes");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",182,"Are you married? ", A_MarriedQuestion.get());
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					//				WebElement elementTo1 = findElement("SpouseCurrentLocDD_CSS");
					//				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementTo1);
					//				click("SpouseCurrentLocDD_CSS");
					Thread.sleep(1000);

					// Scroll to the element
					WebElement elementToScrollTo = findElement("SpouseCurrentLocDD_CSS");
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
					Thread.sleep(1000);

					// Find the div element
					WebElement divElement = findElement("SpouseCurrentLocDD_CSS");

					// Get the list of options excluding "Arizona"
					List<WebElement> options = divElement.findElements(By.tagName("div"));
					options.removeIf(option -> option.getText().equalsIgnoreCase("Arizona"));

					// Select a random option from the remaining options
					int randomIndex = (int) (Math.random() * options.size());
					WebElement selectedOption = options.get(randomIndex);
					String selectedOptionText = selectedOption.getText();

					// Print the selected option text
					System.out.println("Selected Option: " + selectedOptionText);


					// Click on the selected option
					selectedOption.click();
					initializeWriteExcelSheets(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",183,"In which state does your spouse currently live? ", selectedOptionText);
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

					// Spouse Employment --- No
					WebElement elementToSpouseEmplyoment = findElement("SpouseEmployedQuestion_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToSpouseEmplyoment);
					click("SpouseEmployedNoRdBtn_XPATH");

					// Spouse Enrolled at ASU  - Random
					WebElement ToScroll = findElement("SpouseEnrolledASUQuestion_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
					Thread.sleep(500);
					List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='employment_radio_isSpouseEmployedInAnyUni']"));
					int Count = radioButtons.size();
					Random random1111 = new Random();
					int randomIndex111111 = random1111.nextInt(radioButtons.size());
					String selectedOption1 = radioButtons.get(randomIndex111111).getAttribute("value");
					Thread.sleep(500);
					radioButtons.get(randomIndex111111).click();
					Thread.sleep(500);
					String 	Q_SpouseEnrolledASUQuestion	=	findElement("SpouseEnrolledASUQuestion_XPATH").getText();
					if(selectedOption1.contains("Y"))
					{
						log.debug(Q_SpouseEnrolledASUQuestion +" " + "Yes");
						A_SpouseEnrolledAZcoll.set("Yes");
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData",184,Q_SpouseEnrolledASUQuestion, "Yes");
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}
					if(selectedOption1.contains("N"))
					{
						log.debug(Q_SpouseEnrolledASUQuestion+"  " + "No" );
						A_SpouseEnrolledAZcoll.set("No");
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData",184,Q_SpouseEnrolledASUQuestion, "No");
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}

					// Spouse dependent on someone  - Random
					WebElement elementToScroll3 = findElement("SpouseDependentonOtherQuestion_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll3);
					Thread.sleep(500);
					List<WebElement> radioButtons3 = getDriver().findElements(By.xpath("//input[@name='employment_radio_isSpouseDependent']"));
					int Count3= radioButtons.size();
					Random random111111 = new Random();
					int randomIndex1111111 = random111111.nextInt(radioButtons3.size());
					String selectedOption11 = radioButtons3.get(randomIndex1111111).getAttribute("value");
					Thread.sleep(500);
					radioButtons3.get(randomIndex1111111).click();
					Thread.sleep(500);
					String 	Q_SpouseDependentonOtherQuestion	=	findElement("SpouseDependentonOtherQuestion_XPATH").getText();
					if(selectedOption11.contains("Y"))
					{
						log.debug(Q_SpouseDependentonOtherQuestion +" " + "Yes");
						A_SpouseDependentOnOtherString.set("Yes");
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData",185,Q_SpouseDependentonOtherQuestion, "Yes");
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}
					if(selectedOption11.contains("N"))
					{
						log.debug(Q_SpouseDependentonOtherQuestion+"  " + "No" );
						A_SpouseDependentOnOtherString.set("No");
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData",185,Q_SpouseDependentonOtherQuestion, "No");
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


					}

				}
				if(selectedOpt.contains("N"))
				{
					log.debug( "Are you married? :"+ "No" );
					A_MarriedQuestion.set("No");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",186,"Are you married? ", A_MarriedQuestion.get());
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				}
			}


			catch(Exception e) {}
		}


		public void SpouseRelatedDetails(String colKey,String colValue) throws InterruptedException
		{
			try
			{
				if(findElement("SpouseCurrentLocDD_CSS").isDisplayed())
				{
					WebElement elementTo = findElement("SpouseCurrentLocDD_CSS");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementTo);
					click("SpouseCurrentLocDD_CSS");
					Thread.sleep(1000);
					click("SpouseCurrentLocAZDD_XPATH");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",187," In which state does your spouse currently live? ", "Arizona");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					WebElement elementToelement = findElement("SpouseLivesAZquestion_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToelement);
					click("SpouseLivesAZmm_CSS");
					Thread.sleep(1000);
					List<WebElement> options  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
					Random random = new Random();
					int randomIndex = random.nextInt(options.size());
					WebElement randomOption = options.get(randomIndex);
					Thread.sleep(1000);
					randomOption.click();
					Thread.sleep(1000);
					WebElement elementToScrollTo2 = findElement("SpouseLivesAZquestion_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo2);
					click("SpouseLivesAZyy_CSS");
					Thread.sleep(1000);
					List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
					Random random1 = new Random();
					int randomIndex1 = random1.nextInt(options1.size());
					WebElement randomOption1 = options1.get(randomIndex1);
					Thread.sleep(1000);
					randomOption1.click();
					Thread.sleep(1000);


					String year = findElement("SpouseLivesAZyy_CSS").getText();
					String monthInWords = findElement("SpouseLivesAZmm_CSS").getText(); 
					String Q_SpouseLivesAZquestion = findElement("SpouseLivesAZquestion_XPATH").getText(); 
					String month = monthMap.get(monthInWords);
					String A_SpouseLivesAZquestion = year + "-" + month;
					Thread.sleep(500)	;
					log.debug(Q_SpouseLivesAZquestion+" "+A_SpouseLivesAZquestion);
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",188,Q_SpouseLivesAZquestion, A_SpouseLivesAZquestion);
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


					WebElement elementToScrollTo = findElement("SpouseDLquestion_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo);
					click("SpouseDLyesRdBtn_XPATH");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",189," Does your spouse have a valid drivers license or state-issued ID? ", "Yes");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					WebElement elementToScroll = findElement("SpouseDLlocDD_CSS");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll);
					click("SpouseDLlocDD_CSS");
					Thread.sleep(500);
					click("SpouseDLLocAZDD_XPATH");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",190," What state issued this drivers license or state ID?  ", "Arizona");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					Thread.sleep(1000);
					WebElement elementToelement1 = findElement("SpouseDLDateQuestion_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToelement1);
					click("SpouseDLmm_CSS");
					Thread.sleep(1000);
					List<WebElement> options11  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
					Random random11 = new Random();
					int randomIndex11 = random11.nextInt(options11.size());
					WebElement randomOption11 = options11.get(randomIndex11);
					Thread.sleep(1000);
					randomOption11.click();
					Thread.sleep(1000);
					click("SpouseDLyy_CSS");
					Thread.sleep(1000);
					List<WebElement> options111  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
					Random random111 = new Random();
					int randomIndex111 = random111.nextInt(options111.size());
					WebElement randomOption111 = options111.get(randomIndex111);
					Thread.sleep(1000);
					randomOption111.click();
					Thread.sleep(1000);


					String year1 = findElement("SpouseDLyy_CSS").getText();
					String monthInWords1 = findElement("SpouseDLmm_CSS").getText(); 
					String Q_SpouseDLDateQuestion = findElement("SpouseDLDateQuestion_XPATH").getText(); 
					String month1 = monthMap.get(monthInWords1);
					String A_SpouseDLDateQuestion = year1 + "-" + month1;
					log.debug(Q_SpouseDLDateQuestion+" "+A_SpouseDLDateQuestion);
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",191,Q_SpouseDLDateQuestion, A_SpouseDLDateQuestion);
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


					WebElement elementToelementSpouseIncome = findElement("SpouseStateTaxQuestion_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToelementSpouseIncome);
					click("SpouseStateTaxYesRdBtn_XPATH");
					Thread.sleep(500);
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",192," Did or will your spouse file a state income tax return for the 2022 tax year? ", "Yes");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					WebElement elementToelementStateTaxspouse = findElement("SpouseStateTaxLocDD_CSS");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToelementStateTaxspouse);
					click("SpouseStateTaxLocDD_CSS");


					// Randomly choose the Spouse file State Income Tax
					Thread.sleep(500);
					List<WebElement> options1111  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
					Random r = new Random();
					int randomIndex1111 = r.nextInt(options1111.size());
					WebElement randomOption1111 = options1111.get(randomIndex1111);
					Thread.sleep(1000);
					randomOption1111.click();
					Thread.sleep(1000);
					String Q_SpouseIncomeTaxState = findElement("SpouseStateTaxLocQuestion_XPATH").getText();
					String A_SpouseIncomeTaxState = findElement("SpouseStateTaxLocDD_CSS").getText();
					log.debug(Q_SpouseIncomeTaxState+" :"+A_SpouseIncomeTaxState);
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",193,Q_SpouseIncomeTaxState, A_SpouseIncomeTaxState);
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


					// Spouse Employment
					WebElement elementToSpouseEmplyoment = findElement("SpouseEmployedQuestion_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToSpouseEmplyoment);
					click("SpouseEmployedYesRdBtn_XPATH");
					Thread.sleep(500);
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",194," Is your spouse employed? ", "Yes");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					WebElement elementToSpouseEmp = findElement("SpouseEmployedStateDD_CSS");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToSpouseEmp);
					click("SpouseEmployedStateDD_CSS");
					Thread.sleep(500);
					click("SpouseEmployedLocAZDD_XPATH");
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",195," In which state is your spouse employed? ", "Arizona");
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


					// When did your spouses employment at this location begin?	
					WebElement elementToScrollTo1111 = findElement("SpouseEmplyomentAtazQuestion_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo1111);
					click("SpouseEmplyomentMM_ID");
					Thread.sleep(1000);
					List<WebElement> optionsTo = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
					Random random2 = new Random();
					int randomIndex2 = random2.nextInt(optionsTo.size());
					WebElement randomOption2 = optionsTo.get(randomIndex2);
					Thread.sleep(1000);
					randomOption2.click();
					Thread.sleep(1000);
					WebElement elementToScrollTo21 = findElement("SpouseEmplyomentYY_ID");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScrollTo21);
					click("SpouseEmplyomentYY_ID");
					Thread.sleep(1000);
					List<WebElement> options3  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
					Random random3 = new Random();
					int randomIndex3 = random3.nextInt(options3.size());
					WebElement randomOption3 = options3.get(randomIndex3);
					Thread.sleep(1000);
					randomOption3.click();
					Thread.sleep(1000);


					String year11 = findElement("SpouseEmplyomentYY_ID").getText();
					String monthInWords11 = findElement("SpouseEmplyomentMM_ID").getText(); 
					String Q_SpouseEmplyomentAtazQuestion = findElement("SpouseEmplyomentAtazQuestion_XPATH").getText(); 
					String month11 = monthMap.get(monthInWords11);
					String A_SpouseEmplyomentAtazQuestion = year11 + "-" + month11;
					log.debug(Q_SpouseEmplyomentAtazQuestion+" "+A_SpouseEmplyomentAtazQuestion);
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData",196,Q_SpouseEmplyomentAtazQuestion, A_SpouseEmplyomentAtazQuestion);
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


					// Spouse Enrolled at ASU  - Random
					WebElement ToScroll = findElement("SpouseEnrolledASUQuestion_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ToScroll);
					Thread.sleep(500);
					List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='employment_radio_isSpouseEmployedInAnyUni']"));
					int Count = radioButtons.size();
					Random random1111 = new Random();
					int randomIndex11111 = random1111.nextInt(radioButtons.size());
					String selectedOption = radioButtons.get(randomIndex11111).getAttribute("value");
					Thread.sleep(500);
					radioButtons.get(randomIndex11111).click();
					Thread.sleep(500);
					String 	Q_SpouseEnrolledASUQuestion	=	findElement("SpouseEnrolledASUQuestion_XPATH").getText();
					if(selectedOption.contains("Y"))
					{
						log.debug(Q_SpouseEnrolledASUQuestion +" " + "Yes");
						A_SpouseEnrolledAZcoll.set("Yes");
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData",197,Q_SpouseEnrolledASUQuestion, "Yes");
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}
					if(selectedOption.contains("N"))
					{
						log.debug(Q_SpouseEnrolledASUQuestion+"  " + "No" );
						A_SpouseEnrolledAZcoll.set("No");
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData",197,Q_SpouseEnrolledASUQuestion, "No");
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


					}




					// Spouse dependent on someone  - Random
					WebElement elementToScroll3 = findElement("SpouseDependentonOtherQuestion_XPATH");
					this.js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll3);
					Thread.sleep(500);
					List<WebElement> radioButtons3 = getDriver().findElements(By.xpath("//input[@name='employment_radio_isSpouseDependent']"));
					int Count3= radioButtons.size();
					Random random11111 = new Random();
					int randomIndex111111 = random11111.nextInt(radioButtons3.size());
					String selectedOption1 = radioButtons3.get(randomIndex111111).getAttribute("value");
					Thread.sleep(500);
					radioButtons3.get(randomIndex111111).click();
					Thread.sleep(500);
					String 	Q_SpouseDependentonOtherQuestion	=	findElement("SpouseDependentonOtherQuestion_XPATH").getText();
					if(selectedOption1.contains("Y"))
					{
						log.debug(Q_SpouseDependentonOtherQuestion +" " + "Yes");
						A_SpouseDependentOnOtherString.set("Yes");
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData",198,Q_SpouseDependentonOtherQuestion, "Yes");
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					}
					if(selectedOption1.contains("N"))
					{
						log.debug(Q_SpouseDependentonOtherQuestion+"  " + "No" );
						A_SpouseDependentOnOtherString.set("No");
						initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
						setExcelData(colKey,colValue,"validData",198,Q_SpouseDependentonOtherQuestion, "No");
						saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");


					}
				}
			}
			catch(Exception e) {}
		}

		public void RegisteredToVote(String colKey,String colValue) throws EncryptedDocumentException, Exception
		{
			WebElement elementToScroll1 = findElement("RegisteredToVoteQuestion_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll1);
			log.debug("Choose a Random -- Are you registered to vote?");
			Thread.sleep(1000);
			List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='employment_radio_isRegisteredToVote']"));
			int Count = radioButtons.size();
			Random random = new Random();
			int randomIndex = random.nextInt(radioButtons.size());
			String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
			Thread.sleep(1000);
			radioButtons.get(randomIndex).click();
			Thread.sleep(1000);
			if(selectedOption.contains("Y"))
			{

				log.debug( " Are you registered to vote? : Yes");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",199," Are you registered to vote? ", "Yes");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				WebElement elementToScroll11 = findElement("RegisteredToVoteStateDD_ID");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll11);
				click("RegisteredToVoteStateDD_ID");
				Thread.sleep(1000);
				List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options1 = options1.size();
				Random random11 = new Random();
				int randomIndex11 = random11.nextInt(options1.size());
				WebElement randomOption1 = options1.get(randomIndex11);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				String Q_RegisteredToVoteStateQuestion = findElement("RegisteredToVoteStateQuestion_XPATH").getText();
				String 	selectedRegisteredToVoteStateText	= findElement("RegisteredToVoteStateDD_ID").getText();
				log.debug(Q_RegisteredToVoteStateQuestion+" "+selectedRegisteredToVoteStateText);
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",200,Q_RegisteredToVoteStateQuestion, selectedRegisteredToVoteStateText);
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
			}

			if(selectedOption.contains("N"))
			{
				log.debug( " Are you registered to vote? : No");
				initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				setExcelData(colKey,colValue,"validData",199," Are you registered to vote? ", "No");
				saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");

			}
		}

		public void Prop308flow(String colKey,String colValue) throws Throwable
		{
			// Validating the DACA and UD students who have an AZ high school and select HiSet 

			if(findElement("AlertmsgforNonResident_XPATH").isDisplayed())
			{
				//			if(MySchoolsPage.selectedHighSchoolTextforRecentSchool.equalsIgnoreCase("HiSet"))
				log.debug("A proper alert message is displayed for the student who are not a resident of the United States");
				//			else
				//				log.debug("Issue with displaying the alert message");
			}
			else
			{
				// Select a Permanent Domicile
				WebElement elementToScroll11 = findElement("Permanentdomicile_ID");
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll11);
				click("Permanentdomicile_ID");
				Thread.sleep(1000);
				List<WebElement> options1  = getDriver().findElements(By.xpath("//ul[@class='vs__dropdown-menu']/li"));
				int Options1 = options1.size();
				Random random11 = new Random();
				int randomIndex11 = random11.nextInt(options1.size());
				WebElement randomOption1 = options1.get(randomIndex11);
				Thread.sleep(1000);
				randomOption1.click();
				Thread.sleep(1000);
				String PermanentDomicile = findElement("Permanentdomicile_ID").getText();
				log.debug("PermanentDomicile"+" "+PermanentDomicile);


				// Did you (or will you) graduate from an Arizona public or private high school, or home school equivalent, or obtain an Arizona high school equivalency diploma, e.g, GED?

				log.debug("Did you (or will you) graduate from an Arizona public or private high school, or homeschool equivalent, or obtain an Arizona high school equivalency diploma, e.g, GED?");
				Thread.sleep(2000);
				List<WebElement> radioButtons = getDriver().findElements(By.xpath("//input[@name='radio_isGraduateFromAZPublicSchool']"));
				int Count = radioButtons.size();
				Random random = new Random();
				int randomIndex = random.nextInt(radioButtons.size());
				String selectedOption = radioButtons.get(randomIndex).getAttribute("value");
				Thread.sleep(2000);
				radioButtons.get(randomIndex).click();
				Thread.sleep(1000);
				if(selectedOption.contains("Y"))
				{
					GraduatefromAZhighschool.set("Yes");
					log.debug("Selected option:  " + GraduatefromAZhighschool.get());

					// Did you (or will you) attend an Arizona public or private high school, or homeschool while physically present in Arizona for a minimum of two years?
					log.debug("Did you (or will you) attend an Arizona public or private high school, or homeschool while physically present in Arizona for a minimum of two years?");
					Thread.sleep(2000);
					List<WebElement> radioButtons1 = getDriver().findElements(By.xpath("//input[@name='radio_isGraduateFromAZPublicSchool']"));
					int Count1 = radioButtons1.size();
					Random random1 = new Random();
					int randomIndex1 = random1.nextInt(radioButtons1.size());
					String selectedOption1 = radioButtons1.get(randomIndex1).getAttribute("value");
					Thread.sleep(2000);
					radioButtons1.get(randomIndex1).click();
					Thread.sleep(1000);
					if(selectedOption1.contains("Y"))
					{
						PresentInAZforTwoyrs.set( "Yes");
						log.debug("Selected option:  " + PresentInAZforTwoyrs.get());
					}
					if(selectedOption1.contains("N"))
					{
						PresentInAZforTwoyrs.set("No");
						log.debug("Selected option:  " + PresentInAZforTwoyrs.get());
					}


					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 125, "Which state do you consider to be your permanent domicile (i.e., your true, fixed and permanent home)?", PermanentDomicile);
					setExcelData(colKey,colValue,"validData", 126, "Did you (or will you) graduate from an Arizona public or private high school, or homeschool equivalent, or obtain an Arizona high school equivalency diploma, e.g, GED?", GraduatefromAZhighschool.get());
					setExcelData(colKey,colValue,"validData", 127, "Did you (or will you) attend an Arizona public or private high school, or homeschool while physically present in Arizona for a minimum of two years?", PresentInAZforTwoyrs.get());
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				}
				if(selectedOption.contains("N"))
				{

					GraduatefromAZhighschool.set("No");
					log.debug("Selected option:  " + GraduatefromAZhighschool.get());
					initializeWriteExcelSheets(System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx");
					setExcelData(colKey,colValue,"validData", 125, "Which state do you consider to be your permanent domicile (i.e., your true, fixed and permanent home)?", PermanentDomicile);
					setExcelData(colKey,colValue,"validData", 126, "Did you (or will you) graduate from an Arizona public or private high school, or homeschool equivalent, or obtain an Arizona high school equivalency diploma, e.g, GED?", GraduatefromAZhighschool.get());
					saveReport(System.getProperty("user.dir") + "//src//test//resources//com//ugapp//excel//testdata.xlsx");
				}

			}
		}



		public void NonResidentAZflow() throws Throwable
		{
			// Validating the DACA and UD students who have an AZ high school and select HiSet 

			if(findElement("AlertmsgforNonResident_XPATH").isDisplayed())
			{
				String AlertMsg = findElement("AlertmsgforNonResident_XPATH").getText();
				log.debug("Alert message :"+AlertMsg);
				log.debug("A proper alert message is displayed for the student who are not a resident of the United States");
			}else
				log.debug("Issue with displaying the alert message");

		}


		public void DupAppCheckflow(String colKey,String colValue) throws Throwable
		{
			PermanentHome_OOS(colKey, colValue);
			ParentLegalGuardianDetails(colKey, colValue);
		}






		public void SaveThePage() throws Throwable
		{
			// Clicks on Save button
			Thread.sleep(1000);
			WebElement elementToScroll11 = findElement("ResidencySave_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll11);
			click("ResidencySave_XPATH");
			waitTillLoaderDisappears();
			Thread.sleep(5000);

		}

		public void ContinueThePage() throws Throwable
		{
			// Clicks on Save button
			Thread.sleep(1000);
			WebElement elementToScroll11 = findElement("ContinueBtn_XPATH");
			this.js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToScroll11);
			click("ContinueBtn_XPATH");
			waitTillLoaderDisappears();
			Thread.sleep(5000);

		}

	}






























