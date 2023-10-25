package com.ugapp.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ugapp.base.Page;

public class ReviewPage extends Page{


	//validate  reached review page
	public static void validateReview() throws Throwable
	{
		waitTillLoaderDisappears();
		try
		{
			if(findElement("reviewText_XPATH").isDisplayed())
			{
				System.out.println("Redirected to Review Page");
			}
		}
		catch(Exception e)
		{
			System.out.println("Not redirected to Review Page");
		}
	}


	//to write all valid data from all pages to excel
	public static void  writeExcel()
	{
		// Specify the Excel file path
		String filePath = System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx";

		// Specify the sheet name
		String sheetName = "validData";


		// Create a list of key-value pairs

		List<Map.Entry<String, List<String>>> data = List.of(

				//Profile
				Map.entry("Email", List.of(CreateAccountPage.validEmail)),
				Map.entry("Legal name", List.of("Test FN Automation MN Test LN")),
				Map.entry("Preferred first name", List.of("Automation PFN")),



				//My Info
				Map.entry("Former name(s)", List.of(value1,value2,value3,value4,value5,value6,value7,value8,value9)),
				Map.entry("Legal sex", List.of(MyInformationPage.gender)),
				Map.entry("Primary language spoken at home", List.of(MyInformationPage.selectedLanguage)),
				Map.entry("Home address", List.of("Test Address line1 Test Address line2",state(),"12345-678910")),
				Map.entry("Phone",List.of(MyInformationPage.phone)),
				Map.entry("Mobile phone", List.of(MyInformationPage.mobile)),
				Map.entry("U.S. citizenship",List.of("I am a U.S. citizen")),
				Map.entry("Country of citizenship",List.of("United States")),
				Map.entry("Country of birth", List.of(MyInformationPage.selectedCountryOfBirthOptionText)),
				Map.entry("Social Security Number", List.of("*********")),

				Map.entry("Parent or legal guardian", List.of("Parent FN Parent LN I")),
				Map.entry("Parent or Legal Guardian Relation", List.of(MyInformationPage.Relation)),
				Map.entry("Parent or Legal Guardian Schooling Level", List.of(MyInformationPage.Schooling)),
				Map.entry("Parent or Legal Guardian Attended ASU", List.of(MyInformationPage.AttendedASU)),

				Map.entry("Additional parent or legal guardian", List.of("Parent FN Parent LN II")),
				Map.entry("Parent or Legal Guardian Relation", List.of(MyInformationPage.Relation1)),
				Map.entry("Parent or Legal Guardian Schooling Level", List.of(MyInformationPage.Schooling1)),
				Map.entry("Parent or Legal Guardian Attended ASU", List.of(MyInformationPage.AttendedASU1)),

				Map.entry("Previous ASU affiliation", List.of(MyInformationPage.asuAffiliation)),
				Map.entry("Affiliate ID", List.of(MyInformationPage.randomASU_affiliateID)),

				Map.entry("Military status", List.of("I am the spouse/dependent of a U.S. service member or veteran")),
				Map.entry("Branch", List.of(MyInformationPage.selectedBranchServiceOptionText)),
				Map.entry("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:", List.of(MyInformationPage.departmentOfVeterans)),

				Map.entry("Do you plan to use an education benefit or scholarship through an employer, corporation, foundation or other ASU education partner?", List.of(MyInformationPage.educationbenefit)),
				Map.entry("Current employer", List.of(MyInformationPage.selectedEthnicityOptionText)),



				//My Program
				Map.entry("First choice", List.of(MyASUProgramPage.validFirstChoice)),
				Map.entry("Location", List.of(MyASUProgramPage.validFirstLocation)),
				Map.entry("Starting term", List.of(MyASUProgramPage.validFirstStartingTerm)),
				Map.entry("Second choice", List.of(MyASUProgramPage.validSecondChoice)),
				Map.entry("Location", List.of(MyASUProgramPage.validSecondLocation)),
				Map.entry("Starting term", List.of(MyASUProgramPage.validSecondStartingTerm)),
				Map.entry("Pre-law interest", List.of(op1)),
				Map.entry("Pre-med/health interest", List.of(op2)),
				Map.entry("Pre-veterinary interest", List.of(op3)),
				Map.entry("Teaching certificate interest", List.of(op4)),


				//My High School Grades
				Map.entry("Self-reported", List.of("Y")),
				Map.entry("Unweighted GPA/Scale", List.of("111/"+MyHighSchoolGradesPage.gpaScale)),
				Map.entry("Class rank/Class size", List.of("11/111")),
				Map.entry("Grading system", List.of(MyHighSchoolGradesPage.gradingSystem)),

				Map.entry("English", List.of(eng)),
				Map.entry("Math",List.of(math)),
				Map.entry("Science", List.of(sci)),
				Map.entry("Social Science", List.of(soc)),
				Map.entry("Language", List.of(lang)),
				Map.entry("Fine Arts/CTE", List.of(arts)),
				Map.entry("Electives", List.of(ele))
				);


		writeToExcel(filePath, sheetName, data);
	}



	//to write all the data present in review page to excel
	public static void  writeReviewData()
	{
		// Specify the Excel file path
		String filePath = System.getProperty("user.dir")+ "//src//test//resources//com//ugapp//excel//testdata.xlsx";

		// Specify the sheet name
		String sheetName = "ReviewPageData";


		// Create a list of key-value pairs
		List<Map.Entry<String, List<String>>> data = List.of(

				//Profile
				Map.entry("Email",List.of(emailValue)),
				Map.entry("Legal name", List.of(legalNameValue)),
				Map.entry("Preferred first name", List.of(preferredFirstNameValue)),
				Map.entry("Date of birth", List.of(dateOfBirthValue)),


				//my info
				Map.entry("Former name(s)",List.of(formerValue)),
				Map.entry("Legal sex",List.of(legalSexValue)),
				Map.entry("Primary language spoken at home",List.of(primaryLanguageValue)),
				Map.entry("Home address",List.of(homeAddressValue)),
				Map.entry("Phone",List.of(phoneValue)),
				Map.entry("Mobile phone",List.of(mobilePhoneValue)),
				Map.entry("U.S. citizenship",List.of(usCitizenshipValue)),
				Map.entry("Country of citizenship",List.of(countryOfCitizenshipValue)),
				Map.entry("Country of birth",List.of(countryOfBirthValue)),
				Map.entry("Social Security Number",List.of(socialSecurityNumberValue)),
				Map.entry("Parent or legal guardian",List.of(parentOrGaurdianValue)),
				Map.entry("Parent or Legal Guardian Relation",List.of(relationValue)),
				Map.entry("Parent or Legal Guardian Schooling Level",List.of(schoolingValue)),
				Map.entry("Parent or Legal Guardian Attended ASU",List.of(attendedASUValue)),
				Map.entry("Additional parent or legal guardian",List.of(parentOrGuardianValue1)),
				Map.entry("Parent or Legal Guardian Relation",List.of(relationValue1)),
				Map.entry("Parent or Legal Guardian Schooling Level",List.of(schoolingValue1)),
				Map.entry("Parent or Legal Guardian Attended ASU",List.of(attendedASUValue1)),
				Map.entry("Previous ASU affiliation",List.of(previousASUValue)),
				Map.entry("Affiliate ID",List.of(affiliateIDValue)),
				Map.entry("Military status",List.of(militaryStatusValue)),
				Map.entry("Branch",List.of(branchValue)),
				Map.entry("I have applied or plan to apply for Department of Veterans Affairs educational benefits based on my U.S. services affiliation identified above:",List.of(departmentOfVeteransValue)),
				Map.entry("Do you plan to use an education benefit or scholarship through an employer, corporation, foundation or other ASU education partner?",List.of(educationBenefitValue)),
				Map.entry("Current employer",List.of(currentEmployerValue)),



				//My Program
				Map.entry("First choice", List.of(firstChoiceValue)),
				Map.entry("Location", List.of(firstChoiceLocationValue)),
				Map.entry("Starting term", List.of(firstChoiceStartingTermValue)),

				//				Map.entry("Second choice", List.of(MyASUProgramPage.validSecondChoice)),
				//				Map.entry("Location", List.of(MyASUProgramPage.validSecondLocation)),
				//				Map.entry("Starting term", List.of(MyASUProgramPage.validSecondStartingTerm)),


				Map.entry("Pre-law interest", List.of(preLawValue)),
				Map.entry("Pre-med/health interest",List.of(preMedValue)),
				Map.entry("Pre-veterinary interest", List.of(preVeterinaryValue)),
				Map.entry("Teaching certificate interest", List.of(teachingValue)),


				//My High School Grades
				Map.entry("Self-reported", List.of(selfReportedValue)),
				Map.entry("Unweighted GPA/Scale", List.of(unweightedValue)),
				Map.entry("Class rank/Class size", List.of(classRankSizeValue)),
				Map.entry("Grading system", List.of(gradingSystemValue)),

				Map.entry("English", List.of(englishValue)),
				Map.entry("Math", List.of(mathValue)),
				Map.entry("Science", List.of(scienceValue)),
				Map.entry("Social Science", List.of(socialScienceValue)),
				Map.entry("Language", List.of(languageValue)),
				Map.entry("Fine Arts/CTE", List.of(artsValue)),
				Map.entry("Electives", List.of(electivesValue))
				);


		writeToExcel(filePath, sheetName, data);
	}



	//to compare the two excel sheets that is all valid data and data in review page
	public static void compare()
	{
		// Specify the file paths and sheet names for both Excel sheets
		String filePath1 = System.getProperty("user.dir") + "//excel//testdata.xlsx";
		String sheetName1 = "validData";
		String filePath2 = System.getProperty("user.dir") + "//excel//testdata.xlsx";
		String sheetName2 = "ReviewPageData";


		compareExcelSheets(filePath1, sheetName1, filePath2, sheetName2);
	}

	//data present in profile section in review page
	public static void profileSection()
	{
		emailValue = findElement("emailValue_XPATH").getText();
		legalNameValue = findElement("legalNameValue_XPATH").getText();
		preferredFirstNameValue = findElement("preferredFirstNameValue_XPATH").getText();
		dateOfBirthValue = findElement("DateOfBirthValue_XPATH").getText();
	}

	//data present in my info section in review page
	public static void myInfoSection()
	{
		formerValue = findElement("formerValidValue_XPATH").getText();
		legalSexValue = findElement("legalSexValue_XPATH").getText();
		primaryLanguageValue = findElement("primaryLanguageValue_XPATH").getText();
		homeAddressValue = findElement("homeAddressValue_XPATH").getText();

		phoneValue = findElement("phoneValue_XPATH").getText();
		mobilePhoneValue = findElement("mobilePhoneValue_XPATH").getText();
		usCitizenshipValue = findElement("usCitizenshipValue_XPATH").getText();
		countryOfCitizenshipValue = findElement("countryOfCitizenshipValue_XPATH").getText();
		countryOfBirthValue = findElement("countryOfBirthValue_XPATH").getText();

		socialSecurityNumberValue = findElement("socialSecurityNumberValue_XPATH").getText();
		parentOrGaurdianValue = findElement("parentOrGaurdianValue_XPATH").getText();
		relationValue = findElement("relationValue_XPATH").getText();
		schoolingValue = findElement("schoolingValue_XPATH").getText();
		attendedASUValue = findElement("attendedASUValue_XPATH").getText();
		parentOrGuardianValue1 = findElement("parentOrGuardianValue1_XPATH").getText();
		relationValue1 = findElement("relationValue1_XPATH").getText();
		schoolingValue1 = findElement("schoolingValue1_XPATH").getText();
		attendedASUValue1 = findElement("attendedASUValue1_XPATH").getText();

		previousASUValue = findElement("previousASUValue_XPATH").getText();
		affiliateIDValue = findElement("affiliateIDValue_XPATH").getText();
		militaryStatusValue = findElement("militaryStatusValue_XPATH").getText();
		branchValue = findElement("branchValue_XPATH").getText();

		departmentOfVeteransValue = findElement("departmentOfVeteransValue_XPATH").getText();
		educationBenefitValue = findElement("educationBenefitValue_XPATH").getText();
		currentEmployerValue = findElement("currentEmployerValue_XPATH").getText();

	}

	//data present in my program section in review page
	public static void myProgramSection()
	{
		firstChoiceValue = findElement("firstChoiceValue_XPATH").getText();
		firstChoiceLocationValue = findElement("firstChoiceLocationValue_XPATH").getText();	
		firstChoiceStartingTermValue = findElement("firstChoiceStartingTermValue_XPATH").getText();

		preLawValue = findElement("preLawValue_XPATH").getText();
		preMedValue = findElement("preMedValue_XPATH").getText();
		preVeterinaryValue = findElement("preVeterinaryValue_XPATH").getText();
		teachingValue = findElement("teachingValue_XPATH").getText();


	}

	//data present in my high school grades section in review page
	public static void myHighSchoolGradesSection()
	{
		selfReportedValue = findElement("selfReportedValue_XPATH").getText();	
		unweightedValue = findElement("unweightedValue_XPATH").getText();
		classRankSizeValue = findElement("classRankSizeValue_XPATH").getText();
		gradingSystemValue = findElement("gradingSystemValue_XPATH").getText();
		englishValue = findElement("englishValue_XPATH").getText();
		mathValue = findElement("mathValue_XPATH").getText();
		scienceValue = findElement("scienceValue_XPATH").getText();
		socialScienceValue = findElement("socialScienceValue_XPATH").getText();
		languageValue = findElement("languageValue_XPATH").getText();
		artsValue = findElement("artsValue_XPATH").getText();
		electivesValue = findElement("electivesValue_XPATH").getText();
	}

	//to concat month day and year from preapp dashboard page 
	public static String birthday()
	{

		String formattedDate = String.format("%s %02d, %s", PreAppDashboardPage.validMonth, Integer.parseInt(PreAppDashboardPage.validDay), "1995");
		System.out.println(formattedDate);  // Output: "January 01, 1995"
		return formattedDate;
	}

	//to store the former names in seperate string in My info page 1
	public static void former()
	{
		System.out.println(MyInformationPage.validFormerName);

		value1 = MyInformationPage.validFormerName.get(0);
		value2 = MyInformationPage.validFormerName.get(1);
		value3 = MyInformationPage.validFormerName.get(2);
		value4 = MyInformationPage.validFormerName.get(3);
		value5 = MyInformationPage.validFormerName.get(4);
		value6 = MyInformationPage.validFormerName.get(5);
		value7 = MyInformationPage.validFormerName.get(6);
		value8 = MyInformationPage.validFormerName.get(7);
		value9 = MyInformationPage.validFormerName.get(8);

	}

	//to concat the city and state with the country selected  in My Info page 1
	public static String state()
	{
		return stateSelected = "Test City,"+MyInformationPage.state+MyInformationPage.selectedOptionText;
	}

	//to get yes or no for careeer advising from My asu program page 2
	public static void career()
	{
		ArrayList<String> ls2 = new ArrayList<>();
		ArrayList<String> ls3 = new ArrayList<>();
		ls2.add("Pre-law interest");
		ls2.add("Pre-med/health interest");
		ls2.add("Pre-veterinary interest");
		ls2.add("Teaching certificate interest");


		for (String element2 : ls2) {
			if (MyASUProgramPage.CA.contains(element2)) {
				ls3.add(element2);
				System.out.println("Found in list1: " + element2);
			}
		}

		if(ls3.contains("Pre-law interest"))
			op1="YES";
		else
			op1="NO";
		if(ls3.contains("Pre-med/health interest"))
			op2="YES";
		else
			op2="NO";
		if(ls3.contains("Pre-veterinary interest"))
			op3="YES";
		else
			op3="NO";
		if(ls3.contains("Teaching certificate interest"))
			op4="YES";
		else
			op4="NO";

	}

	//to concat unweighted gpa and gpa scale from my HighschoolGrades page 4
	public static String gpa()
	{
		String result = MyHighSchoolGradesPage.unweightedGpa + "/" + MyHighSchoolGradesPage.gpaScale;
		return result;
	}

	//to concat the class rank and class size from my high school grades page 4
	public static String classRS()
	{
		String result = MyHighSchoolGradesPage.classRank + "/" + MyHighSchoolGradesPage.classSize;
		return result;
	}

	//to get the subject selected from My high school grades page 4
	public static void  subject()
	{
		if(MyHighSchoolGradesPage.sub.equalsIgnoreCase("English"))
			eng=MyHighSchoolGradesPage.selectedSubject;
		else
			eng="No data has been entered";

		if(MyHighSchoolGradesPage.sub.equalsIgnoreCase("Math"))
			math=MyHighSchoolGradesPage.selectedSubject;
		else
			math="No data has been entered";

		if(MyHighSchoolGradesPage.sub.equalsIgnoreCase("Science"))
			sci=MyHighSchoolGradesPage.selectedSubject;
		else
			sci="No data has been entered";

		if(MyHighSchoolGradesPage.sub.equalsIgnoreCase("Social Science"))
			soc=MyHighSchoolGradesPage.selectedSubject;
		else
			soc="No data has been entered";

		if(MyHighSchoolGradesPage.sub.equalsIgnoreCase("Language"))
			lang=MyHighSchoolGradesPage.selectedSubject;
		else
			lang="No data has been entered";

		if(MyHighSchoolGradesPage.sub.equalsIgnoreCase("Fine Arts/CTE"))
			arts=MyHighSchoolGradesPage.selectedSubject;
		else
			arts="No data has been entered";

		if(MyHighSchoolGradesPage.sub.equalsIgnoreCase("Electives"))
			ele=MyHighSchoolGradesPage.selectedSubject;
		else
			ele="No data has been entered";

	}



}


