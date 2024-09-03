package com.ugapp.testcases;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;

import com.slack.api.Slack;
import com.slack.api.methods.response.channels.ChannelsListResponse;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
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
public class Test123 
{
	private static String token = "xoxb-5627089155506-5612610658199-mvmn1dCmx3jFTSAMHIYbjdJN";
//	static String slackToken = "xoxb-5627089155506-5612610658199-mvmn1dCmx3jFTSAMHIYbjdJN";
	private static String msg;
	private static String channel = "D06AH02LX4M" ;//C05JF2V03RQ
	
	
	// D06AH02LX4M
	
	public void testS() throws IOException
	{
		uploadFile();
	}
	
	public  void uploadFile() throws IOException 
	{
        String reportPath = System.getProperty("user.dir") + "/target/surefire-reports/html/extent.html";
        String reportFilePath = reportPath.replace("/", "\\");
        String filePath = reportPath;
        String fileName = "UnderGrad_Automation";
        String fileType = "text/html";

        
        System.out.println("reportPath  :"+reportPath);
        System.out.println("filePath  :"+filePath);
        Slack slack = Slack.getInstance();
		MethodsClient methods = slack.methods(token);

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sendTime = dateFormat.format(new Date());

        String fileNameWithTime = sendTime + "_" + fileName;

        List<String> channelids = new ArrayList<String>();
        channelids.add(channel);
        FilesUploadRequest request = FilesUploadRequest.builder()
                .file(file)
                .filename(fileNameWithTime)
                .filetype(fileType)
                .channels(channelids)
                .build();

        try {
            FilesUploadResponse response = methods.filesUpload(request);
            if (response.isOk()) {
                System.out.println("File uploaded successfully!");
            } else {
                System.out.println("File upload failed. Error: " + response.getError());
            }
        } catch (IOException | SlackApiException e) 
        {
            e.printStackTrace();
        }
    }
}


