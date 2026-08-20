package Tests;

import org.automationConcepts.Pages.S25_RandomFailElementsPage;
import org.automationConcepts.Utilities.RetryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S25_RandomFailElementsTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(S25_RandomFailElementsTest.class);
    @Test
    public void testRandomFailElements(){
        S25_RandomFailElementsPage randomFailElementsPage = new S25_RandomFailElementsPage(driver);

        logger.info("Navigating to the Random Fail Elements page");

        String result = RetryUtil.retry(() -> {
            randomFailElementsPage.clickRandomFailButton();
            String text = randomFailElementsPage.getResultText();
            logger.info("Attempt result: {}", text);
            if (text.trim().equalsIgnoreCase("SUCCESS")) {
                return text;
            }
            throw new RuntimeException("Action did not succeed, retrying...");
        }, 5, 2000); // Retry up to 5 times with a

        boolean success = result.trim().equalsIgnoreCase("SUCCESS");
        logger.info("Test completed with final result: {}", result);
        Assert.assertTrue(success, "The action did not succeed after multiple attempts");
    }
}
