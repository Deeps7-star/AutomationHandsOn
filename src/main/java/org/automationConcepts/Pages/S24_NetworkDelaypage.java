package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S24_NetworkDelaypage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(S24_NetworkDelaypage.class);

    public S24_NetworkDelaypage(WebDriver driver) {
        super(driver);
    }

    private final By simulateApiBtnLocator = By.cssSelector("#simulateApiBtn");
    private final By apiResultLocator = By.cssSelector("#apiResult");

    public void clickSimulateApiButton() {
        logger.info("Clicking Simulate API button");
        click(simulateApiBtnLocator);
    }

    public void waitForFinalApiResponse() {
        logger.info("Waiting for final API response");
        waitUtil.waitForTextToBePresent(apiResultLocator, "API Response Received");
    }

    public String getApiResponseText() {
        logger.info("Getting API response text");
        return getText(apiResultLocator);
    }
}