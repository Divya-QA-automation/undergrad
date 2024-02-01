package com.ugapp.utilities;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.ugapp.testcases.BaseTest;
import com.ugapp.testcases.gChat;

public class L extends BaseTest
{
	static String UnderGrad_QA_URL = "https://chat.googleapis.com/v1/spaces/AAAA1Yx_df8/messages?key=AIzaSyDdI0hCZtE6vySjMm-WEfRq3CPzqKqqsHI&token=p5e1cGJKa601p-8LVg4UI1spt8DpHEBZGOhhL25QwAU";


	static String fileURL = "https://drive.google.com/drive/folders/1gdeN1V2K4VBbPGpYgW9jVr1_Q947md-o";
	static String logURL = "file:///Users/divyashree/Downloads/ugapp%205/src/test/resources/com/ugapp/logs/Application.log";


	static int TotalCount = (passedCount + failedCount) ;
	static double val = ((double) passedCount / (passedCount + failedCount)) * 100;
	static int passingPercentage = (int) val;


	String body="{\r\n"            + "  \"cardsV2\": [\r\n"            + "    {\r\n"            + "      \"cardId\": \"unique-card-id\",\r\n"            + "      \"card\": {\r\n"            + "        \"header\": {\r\n"            + "          \"title\": \"Undergrad Application\",\r\n"            + "          \"subtitle\": \"QA Automation test report\",\r\n"            + "        },\r\n"            + "        \"sections\": [\r\n"            + "          {\r\n"            + "            \"collapsible\": false,\r\n"            + "            \"uncollapsibleWidgetsCount\": 1,\r\n"            + "            \"widgets\": [\r\n"            + "                 {\r\n"            + "                \"decoratedText\": {\r\n"            + "                  \"text\": \"<h1> Environment : QA </h1>\",\r\n"            + "                }\r\n"            + "              },\r\n"            + "              {\r\n"            + "                \"decoratedText\": {\r\n"            + "                  \"startIcon\": {\r\n"            + "                    \"knownIcon\": \"DESCRIPTION\",\r\n"            + "                  },\r\n"            + "                  \"text\": \"<font color=\\\"#96081f\\\"> Total number of test cases:" +totalTestsCount+ "</font>\",\r\n"            + "                }\r\n"            + "              },\r\n"            + "              {\r\n"            + "                \"decoratedText\": {\r\n"            + "                  \"startIcon\": {\r\n"            + "                    \"knownIcon\": \"DESCRIPTION\",\r\n"            + "                  },\r\n"            + "                  \"text\": \"<font color=\\\"#80e27e\\\">Passed ="+passedCount+"</font>\",\r\n"            + "                },\r\n"            + "              },\r\n"            + "               {\r\n"            + "                \"decoratedText\": {\r\n"            + "                  \"startIcon\": {\r\n"            + "                    \"knownIcon\": \"DESCRIPTION\",\r\n"            + "                  },\r\n"            + "                  \"text\": \"<font color=\\\"#FF0000\\\">Failed = "+failedCount+"</font>\",\r\n"            + "                },\r\n"            + "              }, {\r\n"            + "                \"decoratedText\": {\r\n"            + "                  \"startIcon\": {\r\n"            + "                    \"knownIcon\": \"BOOKMARK\",\r\n"            + "                  },\r\n"            + "                  \"text\": \"<font color=\\\"#0000FF\\\">Pass percentage = " +passPercentage+ "%</font>\",\r\n"            + "                },\r\n"            + "              },\r\n"            + "              {\r\n"            + "                \"buttonList\": {\r\n"            + "                  \"buttons\": [\r\n"            + "                    {\r\n"            + "                      \"text\": \"Show report\",\r\n"            + "                      \"onClick\": {\r\n"            + "                        \"openLink\": {\r\n"            + "                          \"url\": \""+fileURL+"\",\r\n"            + "                         \r\n"            + "                        }\r\n"            + "                      }\r\n"            + "                    },\r\n"            +"                         {\r\n"            + "                      \"text\": \"logs\",\r\n"            + "                      \"onClick\": {\r\n"            + "                        \"openLink\": {\r\n"            + "                          \"url\": \""+logURL+"\",\r\n"            + "                         \r\n"            + "                        }\r\n"            + "                      }\r\n"            + "                    },\r\n"            + "                  ],\r\n"            + "                }\r\n"            + "              },\r\n"            + "            ],\r\n"            + "          },\r\n"            + "        ],\r\n"            + "      },\r\n"            + "    }\r\n"            + "  ],\r\n"            + "}";


public static void main(String[] args) throws Exception 
{
	
	gChat G = new gChat();
	G.googleChat();
}
	
	
	
	public void googleChat() throws Exception {
		try {
			c2GC(UnderGrad_QA_URL, body);
			System.err.println("Message sent successfully.");
		} catch (Exception e) {
			System.err.println("Error sending message: " + e.getMessage());
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



	public void u2GC(String chatURL, String body) throws Exception
	{

		File file = new File("file:///Users/divyashree/git/undergrad1/target/surefire-reports/html/extent.html");
		URL url = new URL(chatURL);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Length", String.valueOf(file.length()));


		// Send the file content as the request body
		try (FileInputStream fileInputStream = new FileInputStream(file);
				DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = fileInputStream.read(buffer)) != -1) {
				dos.write(buffer, 0, bytesRead);
			}
			dos.flush();
		}

		int responseCode = conn.getResponseCode();
		if (responseCode != 200) {
			throw new RuntimeException("Failed to send message. Response code: " + responseCode);
		}
		conn.disconnect();
	}
}