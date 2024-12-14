package com.ugapp.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.Drive;
import com.google.api.services.drive.model.File;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;


public class GoogleDriveHelper {
    private static final String APPLICATION_NAME = "Drive API Java Integration";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FILE_PATH = "path/to/client_secrets.json"; // Replace with the path to client_secrets.json

    public static Drive getDriveService() throws GeneralSecurityException, IOException {
        // Load client secrets
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(CREDENTIALS_FILE_PATH))
                .createScoped(Collections.singletonList(DriveScopes.DRIVE_FILE));
        return new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, new HttpCredentialsAdapter(credentials))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static String uploadFile(String filePath, String mimeType, String folderId) throws IOException, GeneralSecurityException {
        Drive driveService = getDriveService();

        File fileMetadata = new File();
        fileMetadata.setName("UploadedFile");
        if (folderId != null) {
            fileMetadata.setParents(Collections.singletonList(folderId));
        }

        java.io.File file = new java.io.File(filePath);
        com.google.api.client.http.FileContent mediaContent = new com.google.api.client.http.FileContent(mimeType, file);

        File uploadedFile = driveService.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();

        return uploadedFile.getId();
    }
}
