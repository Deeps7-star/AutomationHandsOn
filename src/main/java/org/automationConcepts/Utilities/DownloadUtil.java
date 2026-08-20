package org.automationConcepts.Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DownloadUtil {
    // Download directory
    private static final String DOWNLOAD_DIR =
            System.getProperty("user.home") + "/Downloads/";

    // Wait for download
    public static String waitForFileDownload(String fileName, int timeoutSeconds) {
        File file = new File(DOWNLOAD_DIR + fileName);
        int waited = 0;
        while (waited < timeoutSeconds) {
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            waited++;
        }
        throw new RuntimeException("File not downloaded within timeout");
    }

    // Verify file exists
    public static boolean isFileDownloaded(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    // Validate file size
    public static boolean isFileSizeValid(String filePath) {
        File file = new File(filePath);
        return file.length() > 0;
    }
    // Read file content (for further validation if needed)
    public static String readFileContent(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read downloaded file: " + filePath, e);
        }
    }
}
