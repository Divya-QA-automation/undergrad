package com.ugapp.testcases;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.WriteMode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DropboxUploader {

    // Dropbox Access Token
    private static final String ACCESS_TOKEN = ""; 

    public static void main(String[] args) {
        // Initialize Dropbox client
        DbxRequestConfig config = DbxRequestConfig.newBuilder("java-dropbox-example").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        // File to upload
        String localFilePath = "./target/surefire-reports/html/extent.html"; // Local file path
        String dropboxFilePath = "/test_results/extent.html"; // Dropbox path

        try {
            // Ensure folder exists
            ensureFolderExists(client, "/test_results");

            // Upload the file to Dropbox
            uploadFile(client, localFilePath, dropboxFilePath);
        } catch (IOException | DbxException e) {
            e.printStackTrace();
        }
    }

    private static void ensureFolderExists(DbxClientV2 client, String folderPath) throws DbxException {
        try {
            client.files().getMetadata(folderPath);
        } catch (DbxException e) {
            // If folder does not exist, create it
            client.files().createFolderV2(folderPath);
            System.out.println("Created folder: " + folderPath);
        }
    }

    private static void uploadFile(DbxClientV2 client, String localFilePath, String dropboxFilePath) throws IOException, DbxException {
        FileInputStream inputStream = null;
        try {
            // Open the local file
            inputStream = new FileInputStream(localFilePath);

            // Upload the file to Dropbox
            FileMetadata metadata = client.files().uploadBuilder(dropboxFilePath)
                    .withMode(WriteMode.OVERWRITE)
                    .uploadAndFinish(inputStream);

            System.out.println("File uploaded to Dropbox: " + metadata.getPathLower());

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + localFilePath);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
