package org.automationConcepts.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class S21_AuthenticationPage extends BasePage {

    // Locators
    private final By usernameInputLocator = By.xpath("//*[@id='loginUsername']");
    private final By passwordInputLocator = By.xpath("//*[@id='loginPassword']");
    private final By loginButtonLocator = By.cssSelector("#loginBtn");
    private final By successMessageLocator = By.xpath("//*[@id='dashboard']//p");

    public S21_AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void enterUsername(String username) {
        type(usernameInputLocator, username);
    }

    public void enterPassword(String password) {
        type(passwordInputLocator, password);
    }

    public void clickLogin() {
        click(loginButtonLocator);
    }


    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    // Success Message
    public String getSuccessMessage() {
        return waitUtil.waitForVisibility(successMessageLocator).getText();
    }

    // Alert Message
    public String getAlertMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    // Common Result Method
    public String getLoginResult() {

        try {

            return getSuccessMessage();
        } catch (Exception e) {
            return getAlertMessage();
        }
    }
}
