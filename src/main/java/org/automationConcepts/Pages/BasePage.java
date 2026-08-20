package org.automationConcepts.Pages;

import org.automationConcepts.Utilities.DropdownType;
import org.automationConcepts.Utilities.RetryUtil;
import org.automationConcepts.Utilities.WaitUtil;
import org.openqa.selenium.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.io.File;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtil waitUtil;
    protected Logger logger;
    protected JavascriptExecutor js;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
        this.logger = Logger.getLogger(this.getClass().getName());
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
    }

    // =========================
    // 🔹 CLICK (ROBUST FIXED)
    // =========================
    protected void click(By locator) {

        RetryUtil.retry(() -> {
            // Handle blocking alerts
            if (isAlertPresent()) {
                logger.warning("Unexpected alert detected.");
                acceptAlert();
            }

            WebElement element = waitUtil.waitForClickable(locator);
            scrollToElement(locator);
            try {
                element.click();
            } catch (ElementClickInterceptedException e) {
                logger.warning("Normal click failed. Using JS click.");
                js.executeScript("arguments[0].click();", element);
            }
            return true;
        }, 3, 1000);
    }

    // =========================
    // 🔹 TYPE
    // =========================
    protected void type(By locator, String text) {
        logger.info("Typing '" + text + "' into: " + locator);
        WebElement element = waitUtil.waitForVisibility(locator);

        String tagName = element.getTagName();
        if (tagName.equalsIgnoreCase("input")
                || tagName.equalsIgnoreCase("textarea")
                || element.getAttribute("contenteditable") != null) {
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);
            element.sendKeys(text);
        } else {
            element.click();
            element.sendKeys(text);
        }
    }

    // =========================
    // 🔹 GET TEXT
    // =========================
    protected String getText(By locator) {

        logger.info("Getting text: " + locator);

        // Handle unexpected alert before DOM interaction
        if (isAlertPresent()) {
            String alertText = getAlertText();
            logger.warning("Unexpected alert detected: " + alertText);
            acceptAlert();
            throw new UnhandledAlertException(
                    "Alert was present while getting text: " + alertText);
        }
        return waitUtil.waitForVisibility(locator)
                .getText()
                .trim();
    }

    // =========================
    // 🔹 IS DISPLAYED
    // =========================
    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    // =========================
    // 🔹 IS SELECTED
    // =========================
    protected boolean isSelected(By locator) {
        try {
            return driver.findElement(locator).isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    // =========================
    // 🔹 Clear
    // =========================
    protected void clear(By locator) {
        logger.info("Clearing field: " + locator);
        WebElement element = waitUtil.waitForVisibility(locator);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }

    // =========================
    // 🔹 GET ATTRIBUTE
    // =========================
    protected String getAttribute(By locator, String attribute) {
        logger.info("Getting attribute '" + attribute + "' from: " + locator);
        return waitUtil.waitForVisibility(locator).getAttribute(attribute);
    }

    // =========================
    // 🔹 FILE UPLOAD
    // =========================
    protected void upload(By locator, String filePath) {

        logger.info("Uploading file: " + filePath);

        WebElement element = waitUtil.waitForVisibility(locator);

        File file = new File(filePath);

        if (!file.exists()) {
            throw new RuntimeException(
                    "File not found: " + file.getAbsolutePath());
        }

        element.sendKeys(file.getAbsolutePath());
    }

    // =========================
    // 🔹 Alert Handling
    // =========================

    protected Alert switchToAlert() {
        return driver.switchTo().alert();
    }
    protected void acceptAlert() {
        switchToAlert().accept();
    }

    protected void dismissAlert() {
        switchToAlert().dismiss();
    }

    protected String getAlertText() {
        return switchToAlert().getText();
    }

    protected void enterAlertText(String text) {
        switchToAlert().sendKeys(text);
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
    // =========================
    // 🔹 FRAME HANDLING
    // =========================
    protected void switchToFrame(By locator) {
        waitUtil.waitForFrameToBeAvailable(locator);
    }

    protected void switchToDefaultContent() { driver.switchTo().defaultContent();}
    protected void switchToParentFrame() {driver.switchTo().parentFrame();}

    // =========================
    // 🔹 GET ELEMENTS
    // =========================
    protected List<WebElement> getElements(By locator) {
        return waitUtil.waitForAllElements(locator);
    }

    // =========================
    // 🔹 SCROLL
    // =========================
    protected void scrollToElement(By locator) {
        WebElement element = waitUtil.waitForVisibility(locator);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    // =========================
    // 🔹 SHADOW DOM
    // =========================
    protected SearchContext getShadowRoot(By shadowHostLocator) {
        WebElement shadowHost = driver.findElement(shadowHostLocator);
        return shadowHost.getShadowRoot();
    }

    // =========================
    // 🔹 HOVER
    // =========================
    protected void hoverAndClick(By hoverLocator, By clickLocator){
        WebElement hoverElement = waitUtil.waitForVisibility(hoverLocator);
        Actions actions = new Actions(driver);
        // Step 1: Hover parent menu FIRST
        actions.moveToElement(hoverElement).perform();
        // Step 2: NOW submenu becomes visible
        WebElement clickElement = waitUtil.waitForVisibility(clickLocator);
        // Step 3: Move and click submenu
        actions.moveToElement(clickElement)
                .click()
                .perform();
    }
    protected String hoverAndGetTooltip(By hoverLocator, By tooltipLocator) {
        WebElement hoverElement = waitUtil.waitForVisibility(hoverLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        WebElement tooltipElement = waitUtil.waitForVisibility(tooltipLocator);
        return tooltipElement.getText().trim();
    }

    // ========================
    // 🔹 Keyboard  Actions
    // =========================
    protected void performKeyboardActions(By locator, Keys... keys) {
        WebElement element = waitUtil.waitForVisibility(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click();
        for (Keys key : keys) {
            actions.sendKeys(key);
        }
        actions.perform();
    }

    // =========================
    // 🔹 Drag and Drop
    // =========================
    protected void dragAndDrop(By source, By target) {
        WebElement src = waitUtil.waitForVisibility(source);
        WebElement tgt = waitUtil.waitForVisibility(target);

        actions
                .clickAndHold(src)
                .pause(java.time.Duration.ofMillis(300))
                .moveToElement(tgt)
                .pause(java.time.Duration.ofMillis(300))
                .release()
                .perform();

        logger.info("Advanced drag and drop completed");
    }

    // =========================
    // 🔹 Drag by Offset
    // =========================
    protected void dragByOffset(By locator, int x, int y) {

        WebElement element = waitUtil.waitForVisibility(locator);

        actions
                .moveToElement(element)   // ✅ center of element
                .clickAndHold()
                .moveByOffset(x, y)
                .release()
                .perform();

        logger.info("Dragged element by offset x:" + x + " y:" + y);
    }



    // =========================
    // 🔹 FIND ELEMENT
    // =========================
    protected WebElement find(By locator) {
        return waitUtil.waitForVisibility(locator);
    }

    // =========================
    // 🔹 JS CLICK (FOR STUBBORN ELEMENTS)
    // =========================
    protected void jsClick(By locator) {
        WebElement element = find(locator);
        js.executeScript("arguments[0].click();", element);
    }

    // =========================
    // 🔹 HIGHLIGHT ELEMENT (FOR DEBUGGING)
    // =========================
    protected void highlight(By locator) {
        WebElement element = find(locator);
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }



    // =========================
    // 🔹 SELECT DROPDOWN
    // =========================
    protected void selectDropdown(By locator, DropdownType type, String... options) {
        WebElement dropdown = waitUtil.waitForVisibility(locator);
        if (!dropdown.getTagName().equalsIgnoreCase("select")) {
            throw new IllegalArgumentException(
                    "selectDropdown can only be used for <select> elements. Found: "
                            + dropdown.getTagName()
            );
        }
        Select select = new Select(dropdown);
        logger.info("Selecting from dropdown: " + locator);

        for (String option : options) {
            switch (type) {
                case TEXT -> select.selectByVisibleText(option);
                case VALUE -> select.selectByValue(option);
                case INDEX -> select.selectByIndex(Integer.parseInt(option));
                default -> throw new IllegalArgumentException("Invalid dropdown type");
            }
        }
    }

    protected void selectCustomDropdown(By dropdownLocator, By optionsLocator, String optionToSelect) {
        logger.info("Opening custom dropdown: " + dropdownLocator);
        // Step 1: open dropdown
        click(dropdownLocator);
        // Step 2: get options (AFTER dropdown opens)
        List<WebElement> options = waitUtil.waitForAllElements(optionsLocator);
        logger.info("Total options found: " + options.size());
        // Step 3: loop and select
        for (WebElement option : options) {
            String text = option.getText().trim();
            logger.info("Option found: " + text);
            if (text.equalsIgnoreCase(optionToSelect.trim())) {
                js.executeScript("arguments[0].scrollIntoView({block:'center'});", option);
                option.click();
                logger.info("Selected option: " + text);
                return;
            }
        }
        throw new NoSuchElementException("Option not found: " + optionToSelect);
    }

    protected void selectDynamicDropdown(By dropdownLocator, By optionsLocator, String optionToSelect) {
        logger.info("Selecting from dynamic dropdown: " + dropdownLocator   );
        // Step 1: click dropdown
        click(dropdownLocator);
        // Step 2: get options
        List<WebElement> options = waitUtil.waitForAllElements(optionsLocator);
        logger.info("Total options found: " + options.size());
        // Step 3: select matching option
        for (WebElement option : options) {
            String text = option.getText().trim();
            logger.info("Option found: " + text);
            if (text.equalsIgnoreCase(optionToSelect.trim())) {
                js.executeScript("arguments[0].scrollIntoView({block:'center'});", option);
                option.click();
                logger.info("Selected option: " + text);
                break;
            }
        }
    }
}