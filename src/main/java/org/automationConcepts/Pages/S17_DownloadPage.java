package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S17_DownloadPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(S17_DownloadPage.class);
    public S17_DownloadPage(WebDriver driver) {
        super(driver);
    }

    private final By downloadButton = By.id("downloadFileBtn");

    public void clickDownloadButton() {
        waitUtil.waitForVisibility(downloadButton);
        scrollToElement(downloadButton);
        waitUtil.waitForClickable(downloadButton);
        logger.info("Clicking the download button");
        click(downloadButton);
    }

}
