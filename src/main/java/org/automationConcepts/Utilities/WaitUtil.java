package org.automationConcepts.Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class WaitUtil {
    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor to initialize WebDriver and WebDriverWait
    public WaitUtil(WebDriver driver) {
        this.driver = driver;
        int timeout = ConfigReader.getInt(ConfigKeys.EXPLICIT_WAIT);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    //Wait for element visibility
    public WebElement waitForVisibility(By locator) {
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Wait for element to be invisible
    public boolean waitForInvisibility(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    //Wait for element clickable
    public WebElement waitForClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    // Wait for frame to be available and switch to it
    public void waitForFrameToBeAvailable(By locator){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }
    // Wait for Presence of element (exists in DOM, may not be visible)
    public WebElement waitForPresence(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait for attribute to contain specific value (useful for progress bars)
    public boolean waitForAttributeContains(By locator, String attribute, String value) {
        return wait.until(ExpectedConditions.attributeContains(locator, attribute, value));
    }

    // Wait for visibility while ignoring StaleElementReferenceException (useful for dynamic content)
    public WebElement waitForVisibilityIgnoringStale(By locator) {

        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait until text changes from old value
    public boolean waitForTextToChange(By locator, String oldText) {

        return wait.until(driver ->
                !driver.findElement(locator)
                        .getText()
                        .trim()
                        .equals(oldText)
        );
    }

    //  Wait for list of all visible elements (important for dynamic provider list)
    public List<WebElement> waitForAllElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public boolean waitForTextToBePresent(By locator, String text){
        return wait.until(
                ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // Wait for number of elements to be more than a certain size (useful for dynamic lists)
    public List<WebElement> waitForElementsMoreThan(By locator, int minSize) {
        return wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(locator, minSize)
        );
    }

    // Wait for custom condition
    public boolean waitForCondition(Function<WebDriver, Boolean> condition) {

        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(StaleElementReferenceException.class)
                .until(condition);
    }

   // Wait for exact number of elements with non-empty text (stable count for dynamic lists)
    public int waitForExactElementsCount(By locator, int expectedSize) {
        return wait.until(driver -> {
            List<WebElement> elements = driver.findElements(locator);

            long count = elements.stream()
                    .map(WebElement::getText)
                    .filter(text -> text != null && !text.trim().isEmpty())
                    .count();

            return count == expectedSize ? (int) count : null;
        });
    }

    // Wait for page to load completely (useful after navigation or actions that trigger reload)
    public void waitForPageToLoad() {

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(webDriver ->
                        ((JavascriptExecutor) webDriver)
                                .executeScript("return document.readyState")
                                .equals("complete"));
    }

    // Fluent wait with custom polling and ignoring specific exceptions (advanced use case)
    public WebElement fluentWait(By locator){

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                                        .withTimeout(Duration.ofSeconds(20))
                                        .pollingEvery(Duration.ofMillis(500))
                                        .ignoring(NoSuchElementException.class);

        return fluentWait.until(driver -> {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed() ? element : null;});
    }
}
