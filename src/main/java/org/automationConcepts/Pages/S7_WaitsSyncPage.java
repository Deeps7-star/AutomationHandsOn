package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S7_WaitsSyncPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(S7_WaitsSyncPage.class);
    // Constructor
    public S7_WaitsSyncPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By startLoadingButtonLocator = By.xpath("//*[@id='loadingBtn']");
    private final By loadingSpinnerLocator = By.xpath("//*[@id='loadingSpinner']");
    private final By processStatusLocator = By.xpath("//*[@id='progressBar']");
    private final By loadingCompleteTextLocator = By.xpath("//*[@id='loadingMessage']");

    // Actions
    public void clickStartLoading() {
        logger.info("Clicking Start Loading button");
        click(startLoadingButtonLocator);
    }

    public boolean isLoadingSpinnerVisible() {
        logger.info("Checking spinner visibility");
        try {
            return waitUtil.waitForVisibility(loadingSpinnerLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForProcessToComplete() {
        logger.info("Waiting for spinner to disappear");
        waitUtil.waitForInvisibility(loadingSpinnerLocator);
    }

    public void waitForProgressBarToComplete() {
        logger.info("Waiting for progress bar to reach 100%");
        waitUtil.waitForAttributeContains(processStatusLocator, "value", "100");
    }


    public String getProcessStatus() {
        logger.info("Getting process status");

        // wait for spinner to disappear first
        waitUtil.waitForInvisibility(loadingSpinnerLocator);

        // just return whatever progressBar has (NO text wait)
        return waitUtil.waitForVisibility(processStatusLocator)
                .getText()
                .trim();
    }

    public String getLoadingCompleteText() {
        logger.info("Waiting for completion message");
        return waitUtil.waitForVisibility(loadingCompleteTextLocator)
                .getText()
                .trim();
    }
}