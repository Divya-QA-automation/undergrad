//package com.ugapp.testcases;
//
//import org.testng.ITestContext;
//import org.testng.ISuite;
//import org.testng.annotations.Test;
//
//import com.slack.api.Slack;
//import com.slack.api.methods.MethodsClient;
//import com.slack.api.methods.request.chat.ChatPostMessageRequest;
//import com.slack.api.methods.response.chat.ChatPostMessageResponse;
//import com.slack.api.model.Message;
//import com.ugapp.listeners.CustomListeners;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//public class SlackIntegration {
//
//	String TOKEN = "xoxb-7859208786195-8188397499396-b71pWMkIjqn7k1k9TV0DsZ77";
//	String CHANNEL = "C07RBQ3DTFW";
//	 int passedCount = 0;
//	 int failedCount = 0;
//	 int totalTestsCount = 0;
//
//
//	public  void main(String[] args) 
//	{
//		sendMessageToSlack(0, 0, 0);
//	}
//
//	public void testSlackIntegration() 
//	{
//		// Create an instance of CustomListeners to access its methods
//		CustomListeners customListeners = new CustomListeners();
//		customListeners.onFinish((ISuite)null); // Call onFinish to calculate percentages
//
//		// Retrieve percentages from CustomListeners
//		int passPercentage = customListeners.getPassPercentage();
//		int failPercentage = customListeners.getFailPercentage();
//		int totalPercentage = customListeners.getTotalPercentage();
//	}
//
//
//	public  void sendMessageToSlack(int passPercentage, int failPercentage, int totalPercentage) 
//	{
//		Slack slack = Slack.getInstance();
//		MethodsClient methods = slack.methods(TOKEN);
//		
//	
//		
//		
//		
//		
//
//		String msg = "UnderGrad QA Automation report:\nScript execution date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("d MMM Y"))
//				+ "\n\nTotal number of test cases: " + (passPercentage + failPercentage)
//				+ "\n Passed: " + passedCount + "%"
//				+ "\n Failed: " + failedCount + "%"
//				+ "\n TOTAL: " + totalTestsCount + "%" 
//				+ "\n\nLink to the detailed report: <https://www.dropbox.com/scl/fo/2g8h3kg80rghcwde83e3u/ACcEh7bQ3C9mbehpyRPrQPI?rlkey=8w1uluyl6xuj5mgiz1uest0kz&st=ii1p4l6e&dl=0|View Test Report>";
//
//		ChatPostMessageRequest request = ChatPostMessageRequest.builder()
//				.channel(CHANNEL)
//				.text(msg)
//				.iconEmoji(":twice:")
//				.build();
//
//
//		// Send the message
//		try {
//			ChatPostMessageResponse response = methods.chatPostMessage(request);
//			if (response.isOk()) {
//				Message sentMessage = response.getMessage();
//				System.out.println("Message sent: " + sentMessage.getText());
//			} else {
//				System.out.println("Failed to send message: " + response.getError());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
