package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class S11_iFramePage extends BasePage{

    public S11_iFramePage(WebDriver driver) {
        super(driver);
    }

    private final By iframeLocator = By.id("practiceIframe");
    private final By iframeInputLocator = By.id("iframeTextInput");
    private final By iframeButtonLocator = By.id("iframeButton");

    // Type text inside iFrame input field
    public void typeIniFrameInput(String text){
        type(iframeInputLocator, text);
    }
    // Switch to iFrame before interacting with elements inside it
    public void switchToiFrame(){
        switchToFrame(iframeLocator);
    }
    // Click button inside iFrame
    public void clickiFrameButton(){
        click(iframeButtonLocator);
    }
    // Switch back to main content after interacting with iFrame
    public void switchBackToMainContent(){
        switchToDefaultContent();
    }
}
