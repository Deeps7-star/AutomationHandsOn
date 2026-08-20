package Tests;

import org.automationConcepts.Pages.S17_DownloadPage;
import org.automationConcepts.Utilities.DownloadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class S17_DownloadTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(S17_DownloadTest.class);
    @Test
    public void verifyFileDownload() {

        S17_DownloadPage downloadPage = new S17_DownloadPage(driver);

        // Expected file name
        String fileName = "practice-file.txt";

        // Step 1: Click download
        downloadPage.clickDownloadButton();

        // Step 2: Wait for file download
        String downloadedFilePath =
                DownloadUtil.waitForFileDownload(fileName, 30);

        // Step 3: Validate file exists
        assertTrue(DownloadUtil.isFileDownloaded(downloadedFilePath), "File was not downloaded successfully.");

        // Step 4: Validate file size
        assertTrue(DownloadUtil.isFileSizeValid(downloadedFilePath), "Downloaded file size is invalid.");

        // Step 5: Read file content
        String fileContent = DownloadUtil.readFileContent(downloadedFilePath);
        logger.info("Downloaded File Content:");
        logger.info(fileContent);

        // Step 6: Validate content
        assertTrue(
                fileContent.contains("Automation Practice Playground File"),
                "Expected text not found in downloaded file.");

    }
}
