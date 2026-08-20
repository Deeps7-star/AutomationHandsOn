package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S8_TableAutomationPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(S8_TableAutomationPage.class);
    // Constructor
    public S8_TableAutomationPage(WebDriver driver) {
        super(driver);
    }

    private final By tableSearchBoxLocator = By.xpath("//*[@id='tableSearch']");
    private final By sortSalaryLocator = By.xpath("//*[@id='sortSalaryBtn']");
    private final By fullTableLocatpr = By.xpath("//table[@id='employeeTable']//tbody/tr");
    private final By PreviousButtonLocator = By.xpath("//*[@id='prevPageBtn']");
    private final By NextButtonLocator = By.xpath("//*[@id='nextPageBtn']");


    public void searchInTable(String keyword) {
        logger.info("Searching for keyword: {}", keyword);
        type(tableSearchBoxLocator, keyword);
    }

    public void sortBySalary() {
        logger.info("Sorting table by salary");
        click(sortSalaryLocator);
    }

    public void printFullTable() {
        logger.info("Printing full table data");
        waitUtil.waitForVisibility(fullTableLocatpr);
        driver.findElements(fullTableLocatpr).forEach(row -> {
            logger.info(row.getText());
        });
    }
}
