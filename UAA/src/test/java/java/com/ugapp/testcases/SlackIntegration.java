package java.com.ugapp.testcases;

import org.testng.ITestContext;
import org.testng.ISuite;
import org.testng.annotations.Test;
import java.com.ugapp.listeners.CustomListeners;
import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.model.Message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SlackIntegration {

	private static final String TOKEN = "xoxb-5627089155506-5612610658199-mvmn1dCmx3jFTSAMHIYbjdJN";
	private static final String CHANNEL = "C06HDLM93QS";

	public void testSlackIntegration() 
	{
		// Create an instance of CustomListeners to access its methods
		CustomListeners customListeners = new CustomListeners();
		customListeners.onFinish((ISuite)null); // Call onFinish to calculate percentages

		// Retrieve percentages from CustomListeners
		int passPercentage = customListeners.getPassPercentage();
		int failPercentage = customListeners.getFailPercentage();
		int totalPercentage = customListeners.getTotalPercentage();
	}


	public void sendMessageToSlack(int passPercentage, int failPercentage, int totalPercentage) 
	{
		Slack slack = Slack.getInstance();
		MethodsClient methods = slack.methods(TOKEN);

		String msg = "UnderGrad QA Automation report:\nScript execution date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("d MMM Y"))
				+ "\n\nTotal number of test cases: " + (passPercentage + failPercentage)
				+ "\n Passed: " + passPercentage + "%"
				+ "\n Failed: " + failPercentage + "%"
				+ "\n TOTAL: " + totalPercentage + "%" 
				+ "\n\nLink to the detailed report: <a href='./target/surefire-reports/html/extent.html'>View Detailed Report</a>";

		// Prepare the message to send
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
}
