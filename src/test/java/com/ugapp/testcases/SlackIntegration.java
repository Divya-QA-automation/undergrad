package com.ugapp.testcases;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.testng.annotations.Test;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.request.files.FilesUploadRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.methods.response.files.FilesUploadResponse;
import com.slack.api.model.Attachment;
import com.slack.api.model.Message;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.model.*;

import java.util.ArrayList;
import java.util.List;

public class SlackIntegration extends BaseTest {
	private static String token = "xoxb-5627089155506-5612610658199-mvmn1dCmx3jFTSAMHIYbjdJN";
	private static String msg;
	private static String channel = "C06AKQ310LT" ;//C05JF2V03RQ


	//user Oauth 
	//xoxp-5627089155506-5629531183108-5612610621367-00b2cbaedda1a292dd7dc582508f41a6


	//bot Oauth
	//xoxb-5627089155506-5612610658199-mvmn1dCmx3jFTSAMHIYbjdJN


	public void testS()
	{
		c2S();
	}


	public void c2S() {
		Slack slack = Slack.getInstance();
		MethodsClient methods = slack.methods(token);
		msg = "ULC_Learner_Portal QA Automation report:\nScript execution date: "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("d MMM Y"))
		+"\n\nTotal number of test cases: 12"
		+"\n Passed: 11"
		+"\n Failed: 1"
		+"\n Skipped: 0"
		+"\n\nLink to the detailed report: <link>";
		
		// Prepare the message to send
		ChatPostMessageRequest request = ChatPostMessageRequest.builder()
				.channel(channel) 
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

