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
	
	public static FileInputStream fis; 
	public static Workbook wb;
	public static FileOutputStream fos;
	public static FileInputStream fis1; 
	public static Workbook wb1;
	public static FileOutputStream fos1;
	
	
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
	
	public static String PermanentHomeValue="";
	public static String EnrolledAtAnotherSchoollValue="";
	public static String VehicleRegisteredDateValue="";
	public static String LicenseIssuedDateValue="";
	public static String StateTaxesDateValue="";
	public static String ParentLegalGuardianFSValue="";
	public static String EmploymentfinancialsupportValue ="";
	public static String SpousefinancialsupportValue ="";
	public static String OtherfinancialsupportValue="";
	public static String SavingstrustfundfinancialsupportValue="";
	public static String RetirementfinancialsupportValue="";
	public static String SocialSecurityDisabilityfinancialsupportValue="";
	public static String VeteranBenefitsfinancialsupportValue="";
	public static String StateFederalBenefitsfinancialsupportValue_="";
	public static String UnemploymentfinancialsupportValue ="";
	public static String OthernoneValue="";
	public static String EmplyomentLocBeginDateValue ="";
	public static String WhichParentLivesInAZValue ="";
	public static String ParentStateTaxStateValue ="";
	public static String ParentHaveAZdlValue ="";
	public static String ParentEmployedAtAZValue ="";
	
	public static String SpouseLivingInAZDateValue ="";
	public static String SpouseDLDateValue ="";
	public static String SpouseEmploymentLocDateValue ="";
	public static String SpouseenrolledatASUVAlue="";
	public static String SpouseTaxFileStateValue ="";
	public static String SpouseDependentValue ="";
	public static String SpouseDependentOfUSmemberValue ="";
	public static String SPGStationedStateValue ="";
	public static String SPGlegalResidenceStateValue ="";
	public static String EnrolledAtAZCalendarYearValue ="";
	

	public static String homeSchoolNameValue1 ="";
	public static String homeSchoolNameValue2 ="";
	public static String homeSchoolNameValue3 ="";
	public static String homeSchoolNameValue4="";
	public static String homeSchoolNameValue5 ="";
	public static String homeSchoolNameValue6 ="";
	public static String homeSchoolNameValue7 ="";
	public static String homeSchoolNameValue8 ="";
	public static String homeSchoolNameValue9 ="";
	public static String homeSchoolNameValue10 ="";
	
	public static String nameOnTranscriptValue1 ="";
	public static String nameOnTranscriptValue2 ="";
	public static String nameOnTranscriptValue3 ="";
	public static String nameOnTranscriptValue4="";
	public static String nameOnTranscriptValue5 ="";
	public static String nameOnTranscriptValue6 ="";
	public static String nameOnTranscriptValue7 ="";
	public static String nameOnTranscriptValue8 ="";
	public static String nameOnTranscriptValue9 ="";
	public static String nameOnTranscriptValue10 ="";
	public static String nameOnTranscriptValue11 ="";
	
	public static String graduationDateValue ="";
	
	public static String startDateValue1="";
	public static String startDateValue2 ="";
	public static String startDateValue3 ="";
	public static String startDateValue4 ="";
	public static String startDateValue5 ="";
	public static String startDateValue6 ="";
	public static String startDateValue7 ="";
	public static String startDateValue8 ="";
	public static String startDateValue9 ="";
	
	
	public static String endDateValue1 ="";
	public static String endDateValue2="";
	public static String endDateValue3 ="";
	public static String endDateValue4 ="";
	public static String endDateValue5 ="";
	public static String endDateValue6 ="";
	public static String endDateValue7 ="";
	public static String endDateValue8 ="";
	public static String endDateValue9 ="";
	
	public static String schoolNameValue="";
	public static String degreeValue ="";
	public static String degreeConcentrationValue ="";
	public static String dateFirstAttendedValue ="";
	public static String dateLastAttendedValue ="";
	public static String transferCreditsValue ="";
	
	
	public static String ineligibleFirstValue1 ="";
	public static String academicRelatedValue1 ="";
	public static String studentConductValue1 ="";
	public static String otherValue1 ="";	
	public static String ineligibleCollegeValue1="";
	
	public static String additionalCollegeValue ="";
	public static String academicRelatedValue2 ="";
	public static String studentConductValue2 ="";
	public static String otherValue2 ="";
	public static String ineligibleCollegeValue2 ="";
	
}
