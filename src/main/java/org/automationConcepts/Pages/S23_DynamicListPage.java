package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class S23_DynamicListPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(S23_DynamicListPage.class);
    public S23_DynamicListPage(WebDriver driver) {
        super(driver);
    }

    private final By enterItem = By.cssSelector("#listInput");
    private final By addItem = By.cssSelector("#addListItemBtn");

    public void addItemToList(String item, int expectedSize) {
        logger.info("Adding item to list: {}", item);

        waitUtil.waitForVisibility(enterItem);
        type(enterItem, item);
        click(addItem);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> updatedList = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.cssSelector("#dynamicList li"),
                        expectedSize - 1   // because "more than" means > value
                )
        );

        logger.info("List size after update: {}", updatedList.size());
    }

    public int getItemCount() {
        By listItems = By.cssSelector("#dynamicList li");
        List<WebElement> items = driver.findElements(listItems);

        long count = items.stream()
                .map(WebElement::getText)
                .filter(text -> text != null && !text.trim().isEmpty())
                .count();

        logger.info("Stable list size: {}", count);

        return (int) count;
    }
}
