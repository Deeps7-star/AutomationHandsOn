package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.automationConcepts.Utilities.WaitUtil;

public class S2_ButtonInteractionPage extends BasePage {
    //logging
    private static final Logger logger = LoggerFactory .getLogger(S2_ButtonInteractionPage.class);

    //locators
    private final By normalButtonLocator = By.id("normalClickBtn");
    private final By doubleClickButtonLocator = By.id("doubleClickBtn");
    private final By rightClickButtonLocator = By.id("rightClickBtn");
    private final By disabledButtonLocator = By.id("disabledBtn");
    private final By delayedButtonLocator = By.id("delayedEnableBtn");
    private final By buttonTextChangeLocator = By.id("changeTextBtn");
    private final By clickMessageLocator = By.id("buttonResult");

    // Reusable Actions object
    private final Actions actions;

    //constructor
    public S2_ButtonInteractionPage(WebDriver driver){
        super(driver);
        this.waitUtil = new WaitUtil(driver);
        this.actions = new Actions(driver);
    }

    //actions
    public void clickNormalButton(){
        logger.info("Clicking normal button");
        click(normalButtonLocator);
    }
        public void doubleClickButton1(){
            logger.info("Double clicking button");
            WebElement button = waitUtil.waitForVisibility(doubleClickButtonLocator);
            actions.doubleClick(button).perform();
        }

    public void rightClick(){
        logger.info("Right clicking button");
        WebElement button = waitUtil.waitForVisibility(rightClickButtonLocator);
        actions.contextClick(button).perform();
    }

    public void validateDisabledButton() {
        logger.info("Validating disabled button state");
        WebElement button = waitUtil.waitForVisibility(disabledButtonLocator);
        if (!button.isEnabled()) {
            logger.info("Disabled button is correctly disabled");
        } else {
            logger.error("Disabled button is unexpectedly enabled");
        }
    }

    public void clickDelayedButton(){
        logger.info("Waiting for delayed button to be enabled and clicking it");
        waitUtil.waitForClickable(delayedButtonLocator).click();
    }

    public String getButtonTextChange(){
        logger.info("Clicking button to change text and getting new text");
        WebElement button = waitUtil.waitForVisibility(buttonTextChangeLocator);
        click(buttonTextChangeLocator);
        waitUtil.waitForTextToBePresent(buttonTextChangeLocator, "Button Text Changed");
        String updatedText = button.getText();
        logger.info("Updated button text: {}", updatedText);
        return updatedText;
    }

    public String getButtonResultMessage(){
        String message = waitUtil.waitForVisibility(clickMessageLocator).getText();
        logger.info("Captured button result message: {}", message);
        return message;
    }
    //business flow methods
    public void performAllButtonInteractions(){
        clickNormalButton();
        doubleClickButton1();
        rightClick();
        validateDisabledButton();
        clickDelayedButton();
        String newText = getButtonTextChange();
        logger.info("New text after clicking change text button: " + newText);
    }
}
