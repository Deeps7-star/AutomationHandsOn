package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S9_AlertsPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(S9_AlertsPage.class);

    // Constructor
    public S9_AlertsPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By simpleAlertButtonLocator = By.xpath("//*[@id='section-alerts']/div/button[1]");
    private final By confirmAlertButtonLocator = By.xpath("//*[@id='section-alerts']/div/button[2]");
    private final By promptAlertButtonLocator = By.xpath("//*[@id='section-alerts']/div/button[3]");


    //Actions
    public void clickSimpleAlertButton() {
        logger.info("Clicking on simple alert button");
        click(simpleAlertButtonLocator);
    }
    public void clickConfirmAlertButton() {
        logger.info("Clicking on confirm alert button");
        click(confirmAlertButtonLocator);
    }
    public void clickPromptAlertButton() {
        logger.info("Clicking on prompt alert button");
        click(promptAlertButtonLocator);
    }

    public void okAlert() {
        logger.info("Accepting simple alert");
        acceptAlert();
    }
    public void cancelAlert() {
        logger.info("Dismissing confirm alert");
        dismissAlert();
    }
    public void enterTextInPrompt(String text) {
        logger.info("Entering text into prompt");
        enterAlertText(text);
    }

}
