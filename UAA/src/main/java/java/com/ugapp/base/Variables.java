package java.com.ugapp.base;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.relevantcodes.extentreports.ExtentTest;
public class Variables
{
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static FileInputStream fis; 
	public static Workbook wb;
	public static FileOutputStream fos;
	public static FileInputStream fis1; 
	public static Workbook wb1;
	public static FileOutputStream fos1;
	public static String colNumKey;
	public static String colNumValue;


	
	public static int passedCount;
	public static int failedCount;
	public static int totalTestsCount;
	public static int passPercentage;
	public static ThreadLocal<String> op1= new ThreadLocal<>();
	public static  ThreadLocal<String> op2= new ThreadLocal<>();
	public static ThreadLocal<String> op3=new ThreadLocal<>();
	public static ThreadLocal<String> op4=new ThreadLocal<>();
	public static ThreadLocal<String> eng=new ThreadLocal<>();
	public static ThreadLocal<String> math=new ThreadLocal<>();
	public static ThreadLocal<String> sci=new ThreadLocal<>();
	public static ThreadLocal<String> soc=new ThreadLocal<>();
	public static ThreadLocal<String> lang=new ThreadLocal<>();
	public static ThreadLocal<String> arts=new ThreadLocal<>();
	public static ThreadLocal<String> ele=new ThreadLocal<>();
	
	
	
	//Review Page values
	public static ThreadLocal<String> emailValue =new ThreadLocal<>();
	public static ThreadLocal<String> legalNameValue =new ThreadLocal<>();
	public static ThreadLocal<String> preferredFirstNameValue =new ThreadLocal<>();
	public static ThreadLocal<String> dateOfBirthValue =new ThreadLocal<>();
	public static ThreadLocal<String> firstChoiceValue =new ThreadLocal<>();
	public static ThreadLocal<String> firstChoiceLocationValue =new ThreadLocal<>();
	public static ThreadLocal<String> firstChoiceStartingTermValue =new ThreadLocal<>();
	public static ThreadLocal<String> preLawValue =new ThreadLocal<>();
	public static ThreadLocal<String> preMedValue =new ThreadLocal<>();
	public static ThreadLocal<String> preVeterinaryValue =new ThreadLocal<>();
	public static ThreadLocal<String> teachingValue =new ThreadLocal<>();
	public static ThreadLocal<String> selfReportedValue = new ThreadLocal<>();
	public static ThreadLocal<String> unweightedValue = new ThreadLocal<>();
	public static ThreadLocal<String> classRankSizeValue = new ThreadLocal<>();
	public static ThreadLocal<String> gradingSystemValue = new ThreadLocal<>();
	public static ThreadLocal<String> englishValue = new ThreadLocal<>();
	public static ThreadLocal<String> mathValue = new ThreadLocal<>();
	public static ThreadLocal<String> scienceValue = new ThreadLocal<>();
	public static ThreadLocal<String> socialScienceValue = new ThreadLocal<>();
	public static ThreadLocal<String> languageValue = new ThreadLocal<>();
	public static ThreadLocal<String> artsValue = new ThreadLocal<>();
	public static ThreadLocal<String> electivesValue = new ThreadLocal<>();
	public static ThreadLocal<String> value1 = new ThreadLocal<>();
	public static ThreadLocal<String> value2 = new ThreadLocal<>();
	public static ThreadLocal<String> value3 = new ThreadLocal<>();
	public static ThreadLocal<String> value4 = new ThreadLocal<>();
	public static ThreadLocal<String> value5 = new ThreadLocal<>();
	public static ThreadLocal<String> value6 = new ThreadLocal<>();
	public static ThreadLocal<String> value7 = new ThreadLocal<>();
	public static ThreadLocal<String> value8 = new ThreadLocal<>();
	public static ThreadLocal<String> value9 = new ThreadLocal<>();
	public static ThreadLocal<String> stateSelected=new ThreadLocal<>();
	public static ThreadLocal<String> formerValue = new ThreadLocal<>();
	public static ThreadLocal<String> legalSexValue = new ThreadLocal<>();
	public static ThreadLocal<String> primaryLanguageValue = new ThreadLocal<>();
	public static ThreadLocal<String> homeAddressValue = new ThreadLocal<>();
	
	public static ThreadLocal<String> phoneValue = new ThreadLocal<>();
	public static ThreadLocal<String> mobilePhoneValue = new ThreadLocal<>();
	public static ThreadLocal<String> usCitizenshipValue = new ThreadLocal<>();
	public static ThreadLocal<String> countryOfCitizenshipValue = new ThreadLocal<>();
	public static ThreadLocal<String> countryOfBirthValue = new ThreadLocal<>();
	public static ThreadLocal<String> socialSecurityNumberValue = new ThreadLocal<>();
	public static ThreadLocal<String> parentOrGaurdianValue = new ThreadLocal<>();
	public static ThreadLocal<String> relationValue = new ThreadLocal<>();
	public static ThreadLocal<String> schoolingValue = new ThreadLocal<>();
	public static ThreadLocal<String> attendedASUValue = new ThreadLocal<>();
	public static ThreadLocal<String> parentOrGuardianValue1 = new ThreadLocal<>();
	public static ThreadLocal<String> relationValue1 = new ThreadLocal<>();
	public static ThreadLocal<String> schoolingValue1 = new ThreadLocal<>();
	public static ThreadLocal<String> attendedASUValue1 = new ThreadLocal<>();
	
	public static ThreadLocal<String> previousASUValue = new ThreadLocal<>();
	
	public static ThreadLocal<String> affiliateIDValue = new ThreadLocal<>();
	public static ThreadLocal<String> militaryStatusValue = new ThreadLocal<>();
	public static ThreadLocal<String> branchValue = new ThreadLocal<>();
	public static ThreadLocal<String> departmentOfVeteransValue = new ThreadLocal<>();
	public static ThreadLocal<String> educationBenefitValue = new ThreadLocal<>();
	public static ThreadLocal<String> currentEmployerValue = new ThreadLocal<>();
	
	public static ThreadLocal<String> PermanentHomeValue=new ThreadLocal<>();
	public static ThreadLocal<String> EnrolledAtAnotherSchoollValue=new ThreadLocal<>();
	public static ThreadLocal<String> VehicleRegisteredDateValue=new ThreadLocal<>();
	public static ThreadLocal<String> LicenseIssuedDateValue=new ThreadLocal<>();
	public static ThreadLocal<String> StateTaxesDateValue=new ThreadLocal<>();
	public static ThreadLocal<String> ParentLegalGuardianFSValue=new ThreadLocal<>();
	public static ThreadLocal<String> EmploymentfinancialsupportValue =new ThreadLocal<>();
	public static ThreadLocal<String> SpousefinancialsupportValue =new ThreadLocal<>();
	public static ThreadLocal<String> OtherfinancialsupportValue=new ThreadLocal<>();
	public static ThreadLocal<String> SavingstrustfundfinancialsupportValue=new ThreadLocal<>();
	public static ThreadLocal<String> RetirementfinancialsupportValue=new ThreadLocal<>();
	public static ThreadLocal<String> SocialSecurityDisabilityfinancialsupportValue=new ThreadLocal<>();
	public static ThreadLocal<String> VeteranBenefitsfinancialsupportValue=new ThreadLocal<>();
	public static ThreadLocal<String> StateFederalBenefitsfinancialsupportValue_=new ThreadLocal<>();
	public static ThreadLocal<String> UnemploymentfinancialsupportValue =new ThreadLocal<>();
	public static ThreadLocal<String> OthernoneValue=new ThreadLocal<>();
	public static ThreadLocal<String> EmplyomentLocBeginDateValue =new ThreadLocal<>();
	public static ThreadLocal<String> WhichParentLivesInAZValue =new ThreadLocal<>();
	public static ThreadLocal<String> ParentStateTaxStateValue =new ThreadLocal<>();
	public static ThreadLocal<String> ParentHaveAZdlValue =new ThreadLocal<>();
	public static ThreadLocal<String> ParentEmployedAtAZValue =new ThreadLocal<>();
	
	public static ThreadLocal<String> SpouseLivingInAZDateValue =new ThreadLocal<>();
	public static ThreadLocal<String> SpouseDLDateValue =new ThreadLocal<>();
	public static ThreadLocal<String> SpouseEmploymentLocDateValue =new ThreadLocal<>();
	public static ThreadLocal<String> SpouseenrolledatASUVAlue=new ThreadLocal<>();
	public static ThreadLocal<String> SpouseTaxFileStateValue =new ThreadLocal<>();
	public static ThreadLocal<String> SpouseDependentValue =new ThreadLocal<>();
	public static ThreadLocal<String> SpouseDependentOfUSmemberValue =new ThreadLocal<>();
	public static ThreadLocal<String> SPGStationedStateValue =new ThreadLocal<>();
	public static ThreadLocal<String> SPGlegalResidenceStateValue =new ThreadLocal<>();
	public static ThreadLocal<String> EnrolledAtAZCalendarYearValue =new ThreadLocal<>();
	

	public static ThreadLocal<String> homeSchoolNameValue1 =new ThreadLocal<>();
	public static ThreadLocal<String> homeSchoolNameValue2 =new ThreadLocal<>();
	public static ThreadLocal<String> homeSchoolNameValue3 =new ThreadLocal<>();
	public static ThreadLocal<String> homeSchoolNameValue4=new ThreadLocal<>();
	public static ThreadLocal<String> homeSchoolNameValue5 =new ThreadLocal<>();
	public static ThreadLocal<String> homeSchoolNameValue6 =new ThreadLocal<>();
	public static ThreadLocal<String> homeSchoolNameValue7 =new ThreadLocal<>();
	public static ThreadLocal<String> homeSchoolNameValue8 =new ThreadLocal<>();
	public static ThreadLocal<String> homeSchoolNameValue9 =new ThreadLocal<>();
	public static ThreadLocal<String> homeSchoolNameValue10 =new ThreadLocal<>();
	
	public static ThreadLocal<String> nameOnTranscriptValue1 =new ThreadLocal<>();
	public static ThreadLocal<String> nameOnTranscriptValue2 =new ThreadLocal<>();
	public static ThreadLocal<String> nameOnTranscriptValue3 =new ThreadLocal<>();
	public static ThreadLocal<String> nameOnTranscriptValue4=new ThreadLocal<>();
	public static ThreadLocal<String> nameOnTranscriptValue5 =new ThreadLocal<>();
	public static ThreadLocal<String> nameOnTranscriptValue6 =new ThreadLocal<>();
	public static ThreadLocal<String> nameOnTranscriptValue7 =new ThreadLocal<>();
	public static ThreadLocal<String> nameOnTranscriptValue8 =new ThreadLocal<>();
	public static ThreadLocal<String> nameOnTranscriptValue9 =new ThreadLocal<>();
	public static ThreadLocal<String> nameOnTranscriptValue10 =new ThreadLocal<>();
	public static ThreadLocal<String> nameOnTranscriptValue11 =new ThreadLocal<>();
	
	public static ThreadLocal<String> graduationDateValue =new ThreadLocal<>();
	
	public static ThreadLocal<String> startDateValue1=new ThreadLocal<>();
	public static ThreadLocal<String> startDateValue2 =new ThreadLocal<>();
	public static ThreadLocal<String> startDateValue3 =new ThreadLocal<>();
	public static ThreadLocal<String> startDateValue4 =new ThreadLocal<>();
	public static ThreadLocal<String> startDateValue5 =new ThreadLocal<>();
	public static ThreadLocal<String> startDateValue6 =new ThreadLocal<>();
	public static ThreadLocal<String> startDateValue7 =new ThreadLocal<>();
	public static ThreadLocal<String> startDateValue8 =new ThreadLocal<>();
	public static ThreadLocal<String> startDateValue9 =new ThreadLocal<>();
	
	
	public static ThreadLocal<String> endDateValue1 =new ThreadLocal<>();
	public static ThreadLocal<String> endDateValue2=new ThreadLocal<>();
	public static ThreadLocal<String> endDateValue3 =new ThreadLocal<>();
	public static ThreadLocal<String> endDateValue4 =new ThreadLocal<>();
	public static ThreadLocal<String> endDateValue5 =new ThreadLocal<>();
	public static ThreadLocal<String> endDateValue6 =new ThreadLocal<>();
	public static ThreadLocal<String> endDateValue7 =new ThreadLocal<>();
	public static ThreadLocal<String> endDateValue8 =new ThreadLocal<>();
	public static ThreadLocal<String> endDateValue9 =new ThreadLocal<>();
	
	public static ThreadLocal<String> schoolNameValue=new ThreadLocal<>();
	public static ThreadLocal<String> degreeValue =new ThreadLocal<>();
	public static ThreadLocal<String> degreeConcentrationValue =new ThreadLocal<>();
	public static ThreadLocal<String> dateFirstAttendedValue =new ThreadLocal<>();
	public static ThreadLocal<String> dateLastAttendedValue =new ThreadLocal<>();
	public static ThreadLocal<String> transferCreditsValue =new ThreadLocal<>();
	
	
	public static ThreadLocal<String> ineligibleFirstValue1 =new ThreadLocal<>();
	public static ThreadLocal<String> academicRelatedValue1 =new ThreadLocal<>();
	public static ThreadLocal<String> studentConductValue1 =new ThreadLocal<>();
	public static ThreadLocal<String> otherValue1 =new ThreadLocal<>();	
	public static ThreadLocal<String> ineligibleCollegeValue1=new ThreadLocal<>();
	
	public static ThreadLocal<String> additionalCollegeValue =new ThreadLocal<>();
	public static ThreadLocal<String> academicRelatedValue2 =new ThreadLocal<>();
	public static ThreadLocal<String> studentConductValue2 =new ThreadLocal<>();
	public static ThreadLocal<String> otherValue2 =new ThreadLocal<>();
	public static ThreadLocal<String> ineligibleCollegeValue2 =new ThreadLocal<>();
	public static ThreadLocal<String> RecentCity  =new ThreadLocal<>();
	public static ThreadLocal<String> RecentState =new ThreadLocal<>();
	public static ThreadLocal<String> selectedOptionText =new ThreadLocal<>();
	public static ThreadLocal<String> state =new ThreadLocal<>();
	public static ThreadLocal<String> City = new ThreadLocal<>();
	
	public static ExtentReports extent;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest test;
	public static String  browserName;
	public static int screenShot=1;
	public static String time;
	public static TakesScreenshot screenshot;


}
