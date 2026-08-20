package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S6_DynamicContentPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(S6_DynamicContentPage.class);

    // Locators
    private final By showDelayedElementLocator = By.xpath("//*[@id='showDelayedElementBtn']");
    private final By delayedTextLocator = By.xpath("//*[@id='delayedElement']");

    private final By hideElementLocator = By.cssSelector("#hideElementBtn");
    private final By hiddenTextLocator = By.xpath("//*[@id='hideTarget']");

    private final By changeDynamicTextLocator = By.id("changeDynamicTextBtn");
    private final By dynamicTextLocator = By.xpath("//*[@id='dynamicText']");

    private final By counterUpLocator = By.xpath("//*[@id='counterBtn']");
    private final By counterValueLocator = By.xpath("//*[@id='counterValue']");

    // Constructor
    public S6_DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void clickShowDelayedElement() {
        logger.info("Clicking Show Delayed Element button");
        click(showDelayedElementLocator);
    }
    public String getDelayedText() {
        logger.info("Getting delayed text");
        waitUtil.waitForVisibility(delayedTextLocator);
        return getText(delayedTextLocator);
    }

    public void clickHideElement() {
        logger.info("Clicking Hide Element button");
        click(hideElementLocator);
    }
    public boolean waitForHiddenTextToDisappear() {
        logger.info("Waiting for hidden text to disappear");
        try {
            return waitUtil.waitForInvisibility(hiddenTextLocator);
        } catch (Exception e) {
            return true;
        }
    }

    public void clickChangeDynamicText() {
        logger.info("Clicking Change Dynamic Text button");
        click(changeDynamicTextLocator);
    }
    public String getDynamicText() {
        logger.info("Getting dynamic text");
        return getText(dynamicTextLocator);
    }

    public void clickCounterUp() {
        logger.info("Clicking Counter Up button");
        click(counterUpLocator);
    }
    public String getCounterValue() {
        logger.info("Getting counter value");
        return getText(counterValueLocator);
    }


}
