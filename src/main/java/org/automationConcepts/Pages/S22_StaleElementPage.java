package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S22_StaleElementPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(S22_StaleElementPage.class);
    public S22_StaleElementPage(WebDriver driver) {
        super(driver);
    }

    private final By replaceButton = By.id("replaceDomBtn");
    private final By newButton = By.id("newDomButton");

    public void clickReplaceButton(){
        logger.info("Clicking Replace DOM button");
        waitUtil.waitForVisibility(replaceButton);
        click(replaceButton);
    }

        public void clickNewButton(){
            logger.info("Clicking New DOM button");
            waitUtil.waitForVisibility(newButton);
            click(newButton);
        }
}
