package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S20_MultipleWindowsPage extends BasePage {

    private static final Logger logger =
            LoggerFactory.getLogger(S20_MultipleWindowsPage.class);

    public S20_MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }

    private final By clickButtonLocator = By.id("newTabBtn");

    // Step 2 — Click to Open New Tab
    public void clickOpenNewTabButton() {

        scrollToElement(clickButtonLocator);

        waitUtil.waitForVisibility(clickButtonLocator);
        waitUtil.waitForClickable(clickButtonLocator);

        logger.info("Clicking Open New Tab button");

        click(clickButtonLocator);
    }

    // Step 5 — Perform actions in new tab
    public String getCurrentPageTitle() {

        String title = driver.getTitle();

        logger.info("Current Page Title: {}", title);

        return title;
    }
}