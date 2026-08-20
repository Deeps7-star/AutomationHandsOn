package org.automationConcepts.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class S29_ResizableElementPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(S29_ResizableElementPage.class);

    public S29_ResizableElementPage(WebDriver driver) {
        super(driver);
    }

    private final By resizableBox = By.cssSelector("#section-resizable .resizable");

    private WebElement getResizableElement() {
        return waitUtil.waitForVisibility(resizableBox);
    }

    public int getWidth() {
        return getResizableElement().getSize().getWidth();
    }

    public int getHeight() {
        return getResizableElement().getSize().getHeight();
    }

    public Dimension getSize() {
        return getResizableElement().getSize();
    }

    public void resizeJS(int x, int y) {

        scrollToElement(resizableBox);
        WebElement element = waitUtil.waitForVisibility(resizableBox);
        int oldWidth = element.getSize().getWidth();
        int oldHeight = element.getSize().getHeight();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].style.width = arguments[1] + 'px';" +
                        "arguments[0].style.height = arguments[2] + 'px';",
                element,
                oldWidth + x,
                oldHeight + y
        );

        // Re-fetch actual updated size
        int updatedWidth = element.getSize().getWidth();
        int updatedHeight = element.getSize().getHeight();

    }

    // Wait for custom condition
    public void waitForResize(int expectedWidth, boolean shouldIncrease) {

        if (shouldIncrease) {
            waitUtil.waitForCondition(d -> getWidth() > expectedWidth);
        } else {
            waitUtil.waitForCondition(d -> getWidth() < expectedWidth);
        }
    }
}