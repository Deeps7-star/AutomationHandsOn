package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class S16_FileUploadPage extends BasePage{

    private final By chooseFileLocator = By.id("fileUpload");
    private final By uploadedFileName = By.id("uploadedFileName");

    public S16_FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile(String filePath){

        waitUtil.waitForVisibility(chooseFileLocator);

        scrollToElement(chooseFileLocator);

        waitUtil.waitForClickable(chooseFileLocator);

        upload(chooseFileLocator, filePath);
    }
        public String getUploadedFileName(){
            return getText(uploadedFileName);
        }


}
