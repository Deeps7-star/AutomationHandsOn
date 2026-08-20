package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S1_BasicFormElementsPage extends BasePage { //(OOPs - INHERITANCE)

    //Create one constant logger object for this class so we can print execution logs.
    // info(), warn(), error() etc. methods of logger need an object to execute.
    private static final Logger logger = LoggerFactory.getLogger(S1_BasicFormElementsPage.class);

    //Locators for form elements
      private final By usernameFieldLocator = By.id("textInput");
      private final By passwordFieldLocator = By.className("input-field");
      private final By emailFieldLocator = By.cssSelector("#emailInput");
      private final By phoneFieldLocator = By.xpath("//input[@placeholder='Enter Phone Number']");
      private final By messageFieldLocator = By.name("message");
      private final By submitButtonLocator = By.id("submitBtn");
      private final By resetButtonLocator = By.id("resetBtn");
      private final By successMessageLocator = By.id("successMsg");

    //Constructor - This constructor receives browser driver from test.
    //Test creates driver -> Driver passed to Page Constructor -> Constructor passes driver to BasePage ->
    // -> BasePage stores driver -> All methods can use browser
    public S1_BasicFormElementsPage(WebDriver driver) {
        super(driver);
    }

    //Actions
    public void enterUsername(String username) {
        logger.info("Entering username: " + username);
        type(usernameFieldLocator, username);
    }

    public void enterPassword(String password) {
        logger.info("Entering password");
        type(passwordFieldLocator, password);
    }

    public void enterEmail(String email){
        logger.info("Entering email: " + email);
        type(emailFieldLocator, email);
    }

    public void enterPhone(String phone){
        logger.info("Entering Phone number: " + phone);
        type(phoneFieldLocator, phone);
    }

    public void enterMessage(String msg){
        logger.info("Entering message:" +msg);
        type(messageFieldLocator, msg);
    }

    public void clickSubmit(){
        logger.info("Clicking submit button");
        click(submitButtonLocator);
    }

    public void clickReset(){
        logger.info("Clicking reset button");
        click(resetButtonLocator);
    }

    public String getSuccessMessage() {
        logger.info("Getting success message");
        return getText(successMessageLocator);
    }

    //BusinessFlow method to fill the form and submit - (OOPs - ABSTRACTION)
    public void fillActions(String username, String password, String email, String phone, String message){
        logger.info("Starting to fill the form with provided data");
        enterUsername(username);
        enterPassword(password);
        enterEmail(email);
        enterPhone(phone);
        enterMessage(message);
        clickSubmit();
        logger.info("Form submitted successfully");
    }
}
