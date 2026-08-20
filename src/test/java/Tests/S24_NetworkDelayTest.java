package Tests;

import org.automationConcepts.Pages.S24_NetworkDelaypage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S24_NetworkDelayTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(S24_NetworkDelayTest.class);

    @Test
    public void testNetworkDelay() {

        logger.info("Starting Network Delay Test");

        S24_NetworkDelaypage networkDelayPage = new S24_NetworkDelaypage(driver);

        // Step 1 - Click button
        networkDelayPage.clickSimulateApiButton();

        // Step 2 - Wait for final response
        networkDelayPage.waitForFinalApiResponse();

        // Step 3 - Get response text
        String response = networkDelayPage.getApiResponseText();
        logger.info("Received response: {}", response);

        // Step 4 - Validate response
        Assert.assertEquals(
                response,
                "API Response Received",
                "API response mismatch!"
        );

        logger.info("Network Delay Test Passed");
    }
}