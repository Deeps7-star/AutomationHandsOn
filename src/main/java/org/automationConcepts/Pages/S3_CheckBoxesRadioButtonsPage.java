package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S3_CheckBoxesRadioButtonsPage extends BasePage {

    public S3_CheckBoxesRadioButtonsPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger logger = LoggerFactory.getLogger(S3_CheckBoxesRadioButtonsPage.class);
    private final By javaCheckboxLocator = By.xpath("//label[contains(.,'Java')]//input[@type='checkbox']");
    private final By pythonCheckboxLocator = By.xpath("//label[contains(.,'Python')]//input[@type='checkbox']");
    private final By javascriptCheckboxLocator = By.xpath("//label[contains(.,'JavaScript')]//input[@type='checkbox']");
    private final By selectAllCheckboxLocator = By.id("selectAllCheckbox");
    private final By juniorRadioLocator = By.cssSelector("input[name='experience'][value='junior']");
    private final By seniorRadioLocator = By.cssSelector("input[name='experience'][value='senior']");
    private final By revealHiddenTextCheckboxLocator =  By.id("revealTextCheckbox");
    private final By hiddenTextLocator = By.id("hiddenText");

    public void selectJava() {
        logger.info("Selecting Java checkbox");
        selectCheckbox(javaCheckboxLocator, "Java");
    }

    public void selectPython() {
        logger.info("Selecting Python checkbox");
        selectCheckbox(pythonCheckboxLocator, "Python");
    }

    public void selectJavaScript() {
        logger.info("Selecting JavaScript checkbox");
        selectCheckbox(javascriptCheckboxLocator, "JavaScript");
    }

    public void clickSelectAll() {
        logger.info("Clicking Select All checkbox");
        selectCheckbox(selectAllCheckboxLocator, "Select All");
    }

    public void selectJunior() {
        logger.info("Selecting Junior radio button");
        click(juniorRadioLocator);
    }

    public void selectSenior() {
        logger.info("Selecting Senior radio button");
        click(seniorRadioLocator);
    }
    public void clickRevealHiddenText() {
        logger.info("Clicking Reveal Hidden Text checkbox");
        selectCheckbox(revealHiddenTextCheckboxLocator, "Reveal Hidden Text");
    }

    public String getHiddenText() {
        WebElement text = waitUtil.waitForVisibility(hiddenTextLocator);
        return text.getText().trim();
    }
//--------------------------------------------------------------------------------
    public boolean areAllLanguagesSelected() {
        return driver.findElement(javaCheckboxLocator).isSelected()
                && driver.findElement(pythonCheckboxLocator).isSelected()
                && driver.findElement(javascriptCheckboxLocator).isSelected();
    }

    public boolean isJuniorSelected() {
        return driver.findElement(juniorRadioLocator).isSelected();
    }

    public boolean isHiddenTextVisible() {
        WebElement text = waitUtil.waitForVisibility(hiddenTextLocator);
        return text.isDisplayed();
    }

    protected void selectCheckbox(By locator, String name) {
        logger.info("Selecting checkbox: " + name);
        WebElement checkbox = waitUtil.waitForVisibility(locator);
        scrollToElement(locator);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }
//----------------------------------------------------------------------------------


}
