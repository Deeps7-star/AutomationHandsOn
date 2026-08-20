package Tests;

import org.automationConcepts.Pages.S22_StaleElementPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class S22_StaleElementTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(S22_StaleElementTest.class);
    @Test(description = "Test to demonstrate handling of StaleElementReferenceException")
    public void testStaleElementHandling() {
        S22_StaleElementPage staleElementPage = new S22_StaleElementPage(driver);
        logger.info("Navigating to Stale Element Test Page");
        // Step 1: Click old button (triggers DOM replacement)
        staleElementPage.clickReplaceButton();

        // Step 2: Click new button after DOM update
        staleElementPage.clickNewButton();

        logger.info("Stale element handled successfully");
    }
}
