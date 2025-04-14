package com.ugapp.listeners;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.model.Message;
import com.ugapp.base.Page;
import com.ugapp.utilities.ExtentManager;
import com.ugapp.utilities.Utilities;


public class CustomListeners extends Page implements ITestListener, ISuiteListener {

	private static final String TOKEN = "xoxb-7859208786195-8188397499396-b71pWMkIjqn7k1k9TV0DsZ77";
	private static final String CHANNEL = "C07RBQ3DTFW";
	private int passedCount = 0;
	private int failedCount = 0;
	private int totalTestsCount = 0;
	static String UnderGrad_QA_URL = "https://chat.googleapis.com/v1/spaces/AAAA1Yx_df8/messages?key=AIzaSyDdI0hCZtE6vySjMm-WEfRq3CPzqKqqsHI&token=p5e1cGJKa601p-8LVg4UI1spt8DpHEBZGOhhL25QwAU";


	static String fileURL = "https://drive.google.com/drive/folders/1gdeN1V2K4VBbPGpYgW9jVr1_Q947md-o";
	static String logURL = "file://Users/divyashree/Downloads/ugapp%205/src/test/resources/com/ugapp/logs/Application.log";


	// Getter methods for percentages
	public int getPassPercentage() 
	{
		return (passedCount * 100) / totalTestsCount;
	}

	public int getFailPercentage() {
		return (failedCount * 100) / totalTestsCount;
	}

	public int getTotalPercentage() {
		return getPassPercentage() + getFailPercentage();
	}

	public void onFinish(ITestContext context) {
		// Not used for percentage calculation in this version
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	//    public void onTestFailure(ITestResult result) {
	//        failedTestsCount++;
	//        System.setProperty("org.uncommons.reportng.escape-output", "false");
	//        Utilities utilities = new Utilities();
	//		utilities.captureScreenshot(System.getProperty("user.dir") + "//target//surefire-reports//html//extent.html");
	//        test.log(LogStatus.FAIL, result.getName().toUpperCase() + " Failed with exception : " + result.getThrowable());
	//        test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));
	//
	//        Reporter.log("Click to see Screenshot");
	//        Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + ">Screenshot</a>");
	//        Reporter.log("<br>");
	//        Reporter.log("<br>");
	//        Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName + " height=200 width=200></img></a>");
	//        rep.endTest(test);
	//        rep.flush();
	//    }
	public void onTestFailure(ITestResult result) 
	{
		ExtentReports extent = ExtentManager.getInstance();
		ExtentTest test = extent.startTest(result.getName());


		failedCount++;
		//        System.setProperty("org.uncommons.reportng.escape-output", "false");
		Utilities utilities = new Utilities();
		//        utilities.captureScreenshot(System.getProperty("user.dir") + "/target/surefire-reports/html/extent.html");
		//        test.log(LogStatus.FAIL, result.getName().toUpperCase() + " Failed with exception : " + result.getThrowable());

		// Add the following code to capture and attach the screenshot on failure
		try {
			// Capture screenshot and get the file path
			String filepath = System.getProperty("user.dir") + "//target//surefire-reports//html//extent.html";
			String screenshotPath = utilities.captureScreenshot(filepath);

			// Log the failure along with the screenshot
			test.log(LogStatus.FAIL, result.getName().toUpperCase() + " Failed with exception: " + result.getThrowable());
			test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenshotPath));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Your existing code...
		extent.endTest(test);
		extent.flush();


		//        Reporter.log("Click to see Screenshot");
		//        Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + ">Screenshot</a>");
		//        Reporter.log("<br>");
		//        Reporter.log("<br>");
		//        Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName + " height=200 width=200></img></a>");
		//        
		//        rep.endTest(test);
		//        rep.flush();
	}









	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getName().toUpperCase() + " Skipped the test as the Run mode is NO");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestStart(ITestResult result) {
		totalTestsCount++;
		test = rep.startTest(result.getName().toUpperCase());
	}

	public void onTestSuccess(ITestResult result) {
		passedCount++;
		test.log(LogStatus.PASS, result.getName().toUpperCase() + " PASS");
		rep.endTest(test);
		rep.flush();
	}

	public void onFinish(ISuite suite) 
	{
		// Calculate percentages and display the results
		int passPercentage = (passedCount * 100) / totalTestsCount;
		int failPercentage = (failedCount * 100) / totalTestsCount;
		int totalPercentage = passPercentage + failPercentage;

		System.out.println("Total Test cases: " + totalTestsCount);
		System.out.println("Pass Test cases: " + passedCount );
		System.out.println("Fail Test cases: " + failedCount);
		System.out.println("Pass Percentage: " + passPercentage + "%");

		//	    // Prepare the Extent Report link
		//	    String reportLink = "https:./target/surefire-reports/html/extent.html.com";  // Replace with your actual report link
		//
		//	    // Prepare the message to send in Slack
		Slack slack = Slack.getInstance();
		MethodsClient methods = slack.methods(TOKEN);

		String msg = "UnderGrad NAA QA Automation report:\nScript execution date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("d MMM Y"))
				+ "\n\nTotal number of test cases executed : " + totalTestsCount
				+ "\n Pass Test cases : " + passedCount 
				+ "\n Fail Test cases : " + failedCount
				+ "\n Pass  % : " + passPercentage + "%" 
				+ "\n Fail  % : " + failPercentage + "%" 
				+ "\n TOTAL % : " + totalPercentage + "%" 
				+ "\n\nLink to the detailed report: <https://www.dropbox.com/scl/fo/2g8h3kg80rghcwde83e3u/ACcEh7bQ3C9mbehpyRPrQPI?rlkey=8w1uluyl6xuj5mgiz1uest0kz&st=kg2n0srg&dl=0|View Test Report>";
//				+ "\n\nLink to the Test data : <https://www.dropbox.com/scl/fo/nynt9gwzei5143rfddrik/ADsuOQu5q5UKSGfcJQDgLb0?rlkey=k7v68e5xeziur2djy3io8xqae&st=5h7pi2k6&dl=0|View Test Data>";

		
		ChatPostMessageRequest request = ChatPostMessageRequest.builder()
				.channel(CHANNEL)
				.text(msg)
				.iconEmoji(":twice:")
				.build();


		// Send the message
		try {
			ChatPostMessageResponse response = methods.chatPostMessage(request);
			if (response.isOk()) {
				Message sentMessage = response.getMessage();
				System.out.println("Message sent: " + sentMessage.getText());
			} else {
				System.out.println("Failed to send message: " + response.getError());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




public void c2GC(String chatURL , String body) throws Exception {
	URL url = new URL(chatURL);
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setRequestMethod("POST");
	conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	conn.setDoOutput(true);

	String requestBody = body;

	try (OutputStream os = conn.getOutputStream()) {
		os.write(requestBody.getBytes());
		os.flush();
		os.close();
	}

	int responseCode = conn.getResponseCode();
	if (responseCode != 200) {
		throw new RuntimeException("Failed to send message. Response code: " + responseCode);
	}
	conn.disconnect();
}













public void onStart(ISuite suite) 
{
	// TODO Auto-generated method stub
}



}
