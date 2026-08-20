package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S10_ModalPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(S10_ModalPage.class);

    public S10_ModalPage(WebDriver driver) {
        super(driver);
    }

    private final By openModalButton = By.cssSelector("#openModalBtn");
    private final By modalDialogClose = By.cssSelector("#closeModalBtn");
    private final By modalDialogText = By.cssSelector("#modal > div > p");

    public void openModal() {
        logger.info("Clicking 'Open Modal' button");
        click(openModalButton);
    }
    public void closeModal(){
        logger.info("Clicking 'Close Modal' button");
        click(modalDialogClose);
    }
    public String getModalText() {
        logger.info("Getting text from modal dialog");
        return getText(modalDialogText);
    }

}
