package org.automationConcepts.Pages;

import org.automationConcepts.Utilities.DateUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S28_DatePickerPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(S28_DatePickerPage.class);

    public S28_DatePickerPage(WebDriver driver) {
        super(driver);
    }

    private final By datePickerLocator = By.id("datePicker");

    public void selectDate(String dateDDMMYYYY) {
        scrollToElement(datePickerLocator);
        logger.info("Selecting date (UI format): {}", dateDDMMYYYY);
        String isoDate = DateUtil.toISO(dateDDMMYYYY);
        WebElement element = find(datePickerLocator);
        js.executeScript("arguments[0].value = arguments[1];", element, isoDate);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'))", element);
        logger.info("Date set in ISO format: {}", isoDate);
    }

    public String getSelectedDate() {
        String selectedDate = getAttribute(datePickerLocator, "value");
        logger.info("Selected date from field: {}", selectedDate);
        return selectedDate;
    }
}