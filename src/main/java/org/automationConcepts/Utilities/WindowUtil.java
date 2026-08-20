package org.automationConcepts.Utilities;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowUtil {

    private static final Logger logger =
            LoggerFactory.getLogger(WindowUtil.class);

    private WindowUtil() {
        // Prevent object creation
    }

    // Get parent window handle
    public static String getParentWindow(WebDriver driver) {

        String parentWindow = driver.getWindowHandle();

        logger.info("Parent Window ID: {}", parentWindow);

        return parentWindow;
    }

    // Switch to child window
    public static void switchToChildWindow(WebDriver driver,
                                           String parentWindow) {

        for (String window : driver.getWindowHandles()) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);

                logger.info("Switched to child window: {}", window);

                return;
            }
        }

        throw new NoSuchWindowException("No child window found");
    }

    // Switch back to parent window
    public static void switchToParentWindow(WebDriver driver,
                                            String parentWindow) {

        driver.switchTo().window(parentWindow);

        logger.info("Switched back to parent window");
    }

    // Get total window count
    public static int getWindowCount(WebDriver driver) {

        int count = driver.getWindowHandles().size();

        logger.info("Total windows count: {}", count);

        return count;
    }

    // Close current window
    public static void closeCurrentWindow(WebDriver driver) {

        logger.info("Closing current window");

        driver.close();
    }

    // Switch window using exact title
    public static void switchToWindowByTitle(WebDriver driver,
                                             String expectedTitle) {

        for (String window : driver.getWindowHandles()) {

            driver.switchTo().window(window);

            if (driver.getTitle().equals(expectedTitle)) {

                logger.info("Switched to window with title: {}",
                        expectedTitle);

                return;
            }
        }

        throw new NoSuchWindowException(
                "No window found with title: " + expectedTitle);
    }

    // Switch window using partial URL
    public static void switchToWindowByURL(WebDriver driver,
                                           String partialUrl) {

        for (String window : driver.getWindowHandles()) {

            driver.switchTo().window(window);

            if (driver.getCurrentUrl().contains(partialUrl)) {

                logger.info("Switched to window with URL containing: {}",
                        partialUrl);

                return;
            }
        }

        throw new NoSuchWindowException(
                "No window found with URL containing: " + partialUrl);
    }
}