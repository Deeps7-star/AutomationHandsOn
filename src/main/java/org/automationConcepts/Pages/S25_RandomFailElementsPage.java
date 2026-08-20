package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S25_RandomFailElementsPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(S25_RandomFailElementsPage.class);

    public S25_RandomFailElementsPage(WebDriver driver) {
        super(driver);
    }

    private final By randomFailButton = By.cssSelector("#randomResultBtn");
    private final By resultText = By.cssSelector("#randomResultText");

    public void clickRandomFailButton() {
        logger.info("Clicking the 'Random Fail' button");
        click(randomFailButton);
    }

    public String getResultText() {
        logger.info("Getting the result text after clicking the button");
        waitUtil.waitForVisibility(resultText);
        return getText(resultText);
    }

    public boolean isSuccess(){
        return getResultText().trim().equalsIgnoreCase("Success");
    }
}

