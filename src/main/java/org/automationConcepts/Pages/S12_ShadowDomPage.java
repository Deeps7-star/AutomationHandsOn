package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class S12_ShadowDomPage extends BasePage{

    public S12_ShadowDomPage(WebDriver driver) {
        super(driver);
    }

    private final By shadowHostLocator = By.cssSelector("custom-shadow-component");
    private final By shadowLabelLocator = By.cssSelector("#shadowLabel");
    private final By shadowInputLocator = By.cssSelector("#shadowInput");
    private final By shadowButtonLocator = By.cssSelector("#shadowButton");

    public String getShadowLabelText() {
        return getShadowRoot(shadowHostLocator).findElement(shadowLabelLocator).getText().trim();
    }

    public void typeInShadowInput(String text){
        getShadowRoot(shadowHostLocator).findElement(shadowInputLocator).sendKeys(text);
    }

    public void clickShadowButton(){
        getShadowRoot(shadowHostLocator).findElement(shadowButtonLocator).click();
    }

}
