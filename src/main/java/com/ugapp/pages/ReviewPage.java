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
				Map.entry("Electives", List.of(electivesValue)),


				
				
				// AZ Residency Page
				Map.entry("Begin by selecting the state you consider to be your permanent home.", List.of(PermanentHomeValue)),
				Map.entry("Are you currently enrolled at another college or university?", List.of("Yes")),
				Map.entry("Where are you currently enrolled?", List.of("Test College")),
				Map.entry("In which state is that school located?", List.of(EnrolledAtAnotherSchoollValue)),
				Map.entry("Do you own or operate a car, motorcycle or other motor vehicle?",List.of("Yes")),
				Map.entry("Is this vehicle registered in the state of Arizona?",List.of("Yes")),
				Map.entry("When was your vehicle registered?", List.of(VehicleRegisteredDateValue)),
				Map.entry("Do you have a current driver’s license or state issued ID?", List.of("Yes")),
				Map.entry("In which state was your license issued?", List.of("Arizona")),
				Map.entry("When was your license issued? ", List.of(LicenseIssuedDateValue)),
				Map.entry("Did you, or will you, file state taxes for 2022? ",List.of("Yes")),
				Map.entry("Where did or where will you file your state taxes for 2022? ",List.of(StateTaxesDateValue)),
				Map.entry("Parent or legal guardian financial support ", List.of(ParentLegalGuardianFSValue)),
				Map.entry("Employment financial support ", List.of(EmploymentfinancialsupportValue)),
				Map.entry("Spouse financial support ", List.of(SpousefinancialsupportValue)),
				Map.entry("Other financial support ", List.of(OtherfinancialsupportValue)),
				Map.entry("Savings/trust fund financial support ", List.of(SavingstrustfundfinancialsupportValue)),
				Map.entry("Retirement financial support ", List.of(RetirementfinancialsupportValue)),
				Map.entry("Social Security/Disability financial support ", List.of(SocialSecurityDisabilityfinancialsupportValue)),
				Map.entry("Veteran Benefits financial support ", List.of(VeteranBenefitsfinancialsupportValue)),
				Map.entry("State or Federal Benefits financial support ", List.of(StateFederalBenefitsfinancialsupportValue_)),
				Map.entry("Unemployment financial support ", List.of(UnemploymentfinancialsupportValue)),
				Map.entry("Other/none of the above ", List.of(OthernoneValue)),
				Map.entry("Are you currently employed? ", List.of("Yes")),
				Map.entry("Where is your primary work location? ",List.of("Arizona")),
				Map.entry("When did your employment at this location begin? ",List.of(EmplyomentLocBeginDateValue)),
				
				Map.entry(" In which state do your parent(s) or legal guardian(s) currently live? ", List.of("Arizona")),
				Map.entry(" Which parent or legal guardian lives in Arizona? ", List.of(WhichParentLivesInAZValue)),
				Map.entry(" Did or will your parent(s) or legal guardian(s) file a state income tax return for the 2022 tax year? ", List.of("Yes")),
				Map.entry(" In which state did, or will, your parent(s) or legal guardian(s) file state income taxes? ", List.of(ParentStateTaxStateValue)),
				Map.entry(" Does either parent or legal guardian have a current Arizona driver license? ", List.of(ParentStateTaxStateValue)),
				Map.entry(" Is either parent or legal guardian employed in Arizona? ", List.of(ParentEmployedAtAZValue)),
				
				Map.entry(" In which state does your spouse currently live? ", List.of("Arizona")),
				Map.entry(" When did your spouse begin living in Arizona? ", List.of(SpouseLivingInAZDateValue)),
				Map.entry(" Does your spouse have a valid drivers license or state-issued ID? ", List.of("Yes")),
				Map.entry(" What state issued this drivers license or state ID? ", List.of("Arizona")),
				Map.entry(" When did your spouse obtain this drivers license or state ID? ", List.of(SpouseDLDateValue)),
				Map.entry(" Is your spouse employed? ", List.of("Yes")),
				Map.entry(" In which state is your spouse employed? ", List.of("Arizona")),
				Map.entry(" When did your spouses employment at this location begin? ", List.of(SpouseEmploymentLocDateValue)),
				Map.entry(" Is your spouse currently enrolled at ASU or any other college or university? ", List.of(SpouseenrolledatASUVAlue)),
				Map.entry(" Did or will your spouse file a state income tax return for the 2022 tax year? ", List.of("Yes")),
				Map.entry(" In which state did, or will, your spouse file state income taxes? ", List.of(SpouseTaxFileStateValue)),
				Map.entry(" Is your spouse dependent on someone other than you for financial support, e.g. parents, guardians, family or financial aid? ", List.of(SpouseDependentValue)),
				
				Map.entry(" You indicated that you were the spouse or dependent of a U.S. service member or veteran. Which best describes the service member or veteran? ", List.of(SpouseDependentOfUSmemberValue)),
				Map.entry(" Where is your spouse/parent/guardian currently stationed? ", List.of(SPGStationedStateValue)),
				Map.entry(" What is your spouse/parent/guardians state of legal residence? ", List.of(SPGlegalResidenceStateValue)),
				Map.entry(" Were you enrolled at any Arizona college or university in 2023 or 2022 calendar year? ", List.of(EnrolledAtAZCalendarYearValue))



				
				
				
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

	//data present in AZresidency  section in review page
	public static void AZresidency()
	{
		PermanentHomeValue = findElement("PermanentHomeAddValue_XPATH").getText();
		EnrolledAtAnotherSchoollValue = findElement("EnrolledAtAnotherSchoollValue_XPATH").getText();
		VehicleRegisteredDateValue = findElement("VehicleRegisteredDateValue_XPATH").getText();
		LicenseIssuedDateValue = findElement("LicenseIssuedDateValue_XPATH").getText();
		StateTaxesDateValue = findElement("StateTaxesDate_XPATH").getText();
		ParentLegalGuardianFSValue = findElement("ParentLegalGuardianFSValue_XPATH").getText();
		EmploymentfinancialsupportValue =findElement("EmploymentfinancialsupportValue_XPATH").getText();
		SpousefinancialsupportValue =findElement("SpousefinancialsupportValue_XPATH").getText();
		OtherfinancialsupportValue=findElement("OtherfinancialsupportValue_XPATH").getText();
		SavingstrustfundfinancialsupportValue=findElement("SavingstrustfundfinancialsupportValue_XPATH").getText();
		RetirementfinancialsupportValue=findElement("RetirementfinancialsupportValue_XPATH").getText();
		SocialSecurityDisabilityfinancialsupportValue=findElement("SocialSecurityDisabilityfinancialsupportValue_XPATH").getText();
		VeteranBenefitsfinancialsupportValue=findElement("VeteranBenefitsfinancialsupportValue_XPATH").getText();
		StateFederalBenefitsfinancialsupportValue_=findElement("StateFederalBenefitsfinancialsupportValue_XPATH").getText();
		UnemploymentfinancialsupportValue =findElement("UnemploymentfinancialsupportValue_XPATH").getText();
		OthernoneValue = findElement("OthernoneValue_XPATH").getText();
		EmplyomentLocBeginDateValue = findElement("EmplyomentLocBeginDateValue_XPATH").getText();
		WhichParentLivesInAZValue = findElement("WhichParentLivesInAZValue_XPATH").getText();
		ParentStateTaxStateValue = findElement("ParentStateTaxStateValue_XPATH").getText();
		ParentHaveAZdlValue = findElement("ParentHaveAZdlValue_XPATH").getText();
		ParentEmployedAtAZValue = findElement("ParentEmployedAtAZValue_XPATH").getText();
		
		SpouseLivingInAZDateValue = findElement("SpouseLivingInAZDateValue_XPATH").getText();
		SpouseDLDateValue	= findElement("SpouseDLDateValue_XPATH").getText();
		SpouseEmploymentLocDateValue	= findElement("SpouseEmploymentLocDateValue_XPATH").getText();
		SpouseenrolledatASUVAlue	= findElement("SpouseenrolledatASUVAlue_XPATH").getText();
		SpouseTaxFileStateValue	= findElement("SpouseTaxFileStateValue_XPATH").getText();
		SpouseDependentValue	= findElement("SpouseDependentValue_XPATH").getText();
		SpouseDependentOfUSmemberValue = findElement("SpouseDependentOfUSmemberValue_XPATH").getText();
		
		SPGStationedStateValue	= findElement("SPGStationedStateValue_XPATH").getText();
		SPGlegalResidenceStateValue = findElement("SPGlegalResidenceStateValue_XPATH").getText();
		EnrolledAtAZCalendarYearValue = findElement("EnrolledAtAZCalendarYearValue_XPATH").getText();
	}
	
}


