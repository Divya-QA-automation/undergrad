//package com.ugapp.testcases;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.security.GeneralSecurityException;
//import java.util.Collections;
//
//import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.http.FileContent;
//import com.google.api.client.util.store.FileDataStoreFactory;
////import com.fasterxml.jackson.core.JsonFactory;
//import com.fasterxml.jackson.core.JsonFactoryBuilder;
//import com.fasterxml.jackson.core.JsonFactory;
//import com.fasterxml.jackson.core.JsonFactoryBuilder;
////import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.JsonFactory;
//
//import com.google.api.services.drive.Drive;
//import com.google.api.services.drive.DriveScopes;
//import com.google.api.services.drive.model.File;
//import com.google.api.services.drive.model.Permission;
//
//public class GoogleDriveUploader {
//    private static final String APPLICATION_NAME = "Your Application Name";
//    private static final String CREDENTIALS_FILE_PATH = "/path/to/your/credentials.json";
//    private static final String TOKENS_DIRECTORY_PATH = "tokens";
//
//    public static String uploadReport(File reportFile) throws IOException, GeneralSecurityException 
//    {
//        Drive service = getDriveService();
//
//        // Upload the report file
//        File fileMetadata = new File();
//        fileMetadata.setName(reportFile.getName()); // Use the original file name
//        FileContent mediaContent = new FileContent("text/html", reportFile);
//        File uploadedFile = service.files().create(fileMetadata, mediaContent)
//                .setFields("id")
//                .execute();
//
//        // Get the file ID
//        String fileId = uploadedFile.getId();
//
//        // Get the shareable link
//        return getShareableLink(service, fileId);
//   
//     // Get the shareable link
//        String shareableLink = getShareableLink(service, fileId);
//
//    // Print or return the link
//    System.out.println("Shareable Link: " + shareableLink);
//    }
//
//    private static String getShareableLink(Drive service, String fileId) throws IOException 
//    {
//        Permission permission = new Permission()
//                .setType("anyone")
//                .setRole("reader");
//
//        service.permissions().create(fileId, permission).execute();
//
//        File file = service.files().get(fileId).setFields("webViewLink").execute();
//        return file.getWebViewLink();
//    }
//
//    
//    private static Drive getDriveService() throws IOException, GeneralSecurityException {
//        InputStream in = GoogleDriveUploader.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
//        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
//                com.google.api.client.json.JsonFactory.getDefaultInstance(), // Fully qualified name
//                new InputStreamReader(in)
//        );
//
//        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
//                GoogleNetHttpTransport.newTrustedTransport(),
//                com.google.api.client.json.JsonFactory.getDefaultInstance(), // Fully qualified name
//                clientSecrets,
//                Collections.singleton(DriveScopes.DRIVE_FILE))
//                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
//                .setAccessType("offline")
//                .build();
//
//        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
//        return new Drive.Builder(
//                GoogleNetHttpTransport.newTrustedTransport(),
//                com.google.api.client.json.JsonFactory.getDefaultInstance(), // Fully qualified name
//                clientSecrets)
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//    }
//
//
//
//
//
//}


