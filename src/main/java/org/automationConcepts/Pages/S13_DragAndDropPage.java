package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class S13_DragAndDropPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(S13_DragAndDropPage.class);

    public S13_DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    private  final By sourceLocator = By.cssSelector("#dragItem");
    private  final By targetLocator = By.cssSelector("#dropZone");

    public void performDragAndDrop() {
        logger.info("Performing drag and drop action.");
        WebElement source = waitUtil.waitForVisibility(sourceLocator);
        WebElement target = waitUtil.waitForVisibility(targetLocator);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();

    }
}