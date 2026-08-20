package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor; // ADD THIS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S27_SliderElementPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(S27_SliderElementPage.class);

    public S27_SliderElementPage(WebDriver driver) {
        super(driver);
    }

    private final By sliderLocator = By.id("rangeSlider");
    private final By sliderValueLocator = By.id("sliderValue");


    public void moveSliderToValue(int targetPercentage) {
        scrollToElement(sliderLocator);
        WebElement slider = waitUtil.waitForVisibility(sliderLocator);
        int sliderWidth = slider.getSize().getWidth();
        int targetOffset = (sliderWidth * targetPercentage / 100) - (sliderWidth / 2);
        Actions actions = new Actions(driver);
        actions
                .clickAndHold(slider)
                .moveByOffset(targetOffset, 0)
                .release()
                .perform();

        logger.info("Moved slider to {}%", targetPercentage);
    }


    public void moveSliderUsingJS(int value) {
        scrollToElement(sliderLocator);
        WebElement slider = waitUtil.waitForVisibility(sliderLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].value='" + value + "';" +
                                "arguments[0].dispatchEvent(new Event('input'));", slider);

        logger.info("Moved slider to {} using JavaScript", value);
    }

    public boolean isSliderVisible() {
        WebElement slider = waitUtil.waitForVisibility(sliderLocator);
        boolean isVisible = slider.isDisplayed();
        logger.info("Slider visibility status: {}", isVisible);
        return isVisible;
    }

    public int getSliderValue() {
        waitUtil.waitForVisibility(sliderValueLocator);
        String actualText = driver.findElement(sliderValueLocator).getText();
        int actualValue = Integer.parseInt(actualText.replaceAll("[^0-9]", ""));
        logger.info("Current slider value: {}", actualValue);
        return actualValue;
    }

    public void verifySliderValue(int expectedValue) {
        waitUtil.waitForTextToBePresent(sliderValueLocator, String.valueOf(expectedValue));
        int actualValue = getSliderValue();

        if (actualValue != expectedValue) {
            throw new AssertionError(
                    "Expected: " + expectedValue +
                            " but found: " + actualValue
            );
        }

        logger.info("Verified slider value: {}", actualValue);
    }
}