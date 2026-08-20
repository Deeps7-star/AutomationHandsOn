package Tests;

import org.automationConcepts.Pages.S9_AlertsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class S9_AlertsTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(S9_AlertsTest.class);

    @Test
    public void verifyAlerts() {
        S9_AlertsPage alertsPage = new S9_AlertsPage(driver);

        // Step 1: Simple Alert
        logger.info("Testing simple alert");
        alertsPage.clickSimpleAlertButton();
        alertsPage.okAlert();

        // Step 2: Confirm Alert
        logger.info("Testing confirm alert");
        alertsPage.clickConfirmAlertButton();
        alertsPage.cancelAlert();

        // Step 3: Prompt Alert
        logger.info("Testing prompt alert");
        alertsPage.clickPromptAlertButton();
        alertsPage.enterTextInPrompt("Test");
        alertsPage.okAlert();
    }
}
