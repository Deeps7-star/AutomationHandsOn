package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class S18_HiddenElementsPage extends BasePage{

    private final By revealHiddenButtonLocator = By.id("revealHiddenBtn");
    private final By hiddenButtonLocator = By.id("hiddenButton");

    public S18_HiddenElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickHiddenButton() {
        scrollToElement(revealHiddenButtonLocator);
        waitUtil.waitForVisibility(revealHiddenButtonLocator);
        waitUtil.waitForClickable(revealHiddenButtonLocator);
        logger.info("Clicking hidden button: " + revealHiddenButtonLocator);
        click(revealHiddenButtonLocator);
    }

    public void clickRevealedButton() {
        scrollToElement(hiddenButtonLocator);
        waitUtil.waitForVisibility(hiddenButtonLocator);
        waitUtil.waitForClickable(hiddenButtonLocator);
        logger.info("Clicking revealed button: " + hiddenButtonLocator);
        click(hiddenButtonLocator);
    }

    public boolean isHiddenButtonDisplayed() {
        waitUtil.waitForVisibility(hiddenButtonLocator);
        return driver.findElement(hiddenButtonLocator).isDisplayed();
    }
}
