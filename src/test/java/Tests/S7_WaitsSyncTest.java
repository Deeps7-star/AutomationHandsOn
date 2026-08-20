package Tests;

import org.automationConcepts.Pages.S7_WaitsSyncPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S7_WaitsSyncTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(S7_WaitsSyncTest.class);


    @Test
    public void verifyWaitsAndSynchronization() {
        S7_WaitsSyncPage waitsSyncPage = new S7_WaitsSyncPage(driver);

        // Step 1: Trigger process
        logger.info("Clicking Start Loading button");
        waitsSyncPage.clickStartLoading();

        // Step 2: Wait for UI to settle
        logger.info("Waiting for process to complete");
        waitsSyncPage.waitForProcessToComplete();

        //Step 3: wait for progress bar state
        waitsSyncPage.waitForProgressBarToComplete();

        // Step 4: Capture values ONCE (IMPORTANT FIX)
        String status = waitsSyncPage.getProcessStatus();
        String message = waitsSyncPage.getLoadingCompleteText();

        // DEBUG OUTPUT (correct place + single source of truth)
        logger.info("ProgressBar value: {}", status);
        logger.info("Message value: {}", message);

        // Step 5: Assertions
        Assert.assertEquals(message, "Loading Complete",
                "Completion message should be displayed");
    }
}