package com.ugapp.base;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.ugapp.pages.MyInformationPage;
public class Variables {
	
	
	//
	public static String op1="";
	public static  String op2="";
	public static String op3="";
	public static String op4="";
	public static String eng="";
	public static String math="";
	public static String sci="";
	public static String soc="";
	public static String lang="";
	public static String arts="";
	public static String ele="";
	
	
	
	//Review Page values
	public static String emailValue ="";
	public static String legalNameValue ="";
	public static String preferredFirstNameValue ="";
	public static String dateOfBirthValue ="";
	public static String firstChoiceValue ="";
	public static String firstChoiceLocationValue ="";
	public static String firstChoiceStartingTermValue ="";
	public static String preLawValue ="";
	public static String preMedValue ="";
	public static String preVeterinaryValue ="";
	public static String teachingValue ="";
	public static String selfReportedValue = "";
	public static String unweightedValue = "";
	public static String classRankSizeValue = "";
	public static String gradingSystemValue = "";
	public static String englishValue = "";
	public static String mathValue = "";
	public static String scienceValue = "";
	public static String socialScienceValue = "";
	public static String languageValue = "";
	public static String artsValue = "";
	public static String electivesValue = "";
	public static String value1 = "";
	public static String value2 = "";
	public static String value3 = "";
	public static String value4 = "";
	public static String value5 = "";
	public static String value6 = "";
	public static String value7 = "";
	public static String value8 = "";
	public static String value9 = "";
	public static String stateSelected="";
	public static String formerValue = "";
	public static String legalSexValue = "";
	public static String primaryLanguageValue = "";
	public static String homeAddressValue = "";
	
	public static String phoneValue = "";
	public static String mobilePhoneValue = "";
	public static String usCitizenshipValue = "";
	public static String countryOfCitizenshipValue = "";
	public static String countryOfBirthValue = "";
	public static String socialSecurityNumberValue = "";
	public static String parentOrGaurdianValue = "";
	public static String relationValue = "";
	public static String schoolingValue = "";
	public static String attendedASUValue = "";
	public static String parentOrGuardianValue1 = "";
	public static String relationValue1 = "";
	public static String schoolingValue1 = "";
	public static String attendedASUValue1 = "";
	
	public static String previousASUValue = "";
	
	public static String affiliateIDValue = "";
	public static String militaryStatusValue = "";
	public static String branchValue = "";
	public static String departmentOfVeteransValue = "";
	public static String educationBenefitValue = "";
	public static String currentEmployerValue = "";
}
