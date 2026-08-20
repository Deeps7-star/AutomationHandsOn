package Tests;

import org.automationConcepts.Pages.S16_FileUploadPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S16_FileUploadTest extends BaseTest  {
        private static final Logger logger = LoggerFactory.getLogger(S16_FileUploadTest.class);
        @Test
        public void testFileUpload(){
            logger.info("Starting File Upload Test");

            S16_FileUploadPage fileUploadPage = new S16_FileUploadPage(driver);
            String filePath = "C:\\Users\\deepi\\Documents\\fileupload.xlsx";
            logger.info("Before Upload: File path to upload - " + filePath);

            fileUploadPage.uploadFile(filePath);
            logger.info("After Upload: File path sent to input - " + filePath);

            String uploadedFileName = fileUploadPage.getUploadedFileName();
            Assert.assertEquals(uploadedFileName, "fileupload.xlsx", "Uploaded file name should match");
        }
}
