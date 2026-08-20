package Tests;

import org.automationConcepts.Pages.S18_HiddenElementsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S18_HiddenElementsTest extends BaseTest{
     private static final Logger logger = LoggerFactory.getLogger(S18_HiddenElementsTest.class);
    @Test
    public void verifyHiddenElementsHandling(){
        S18_HiddenElementsPage hiddenElementsPage = new S18_HiddenElementsPage(driver);
        // Step 1: Navigate to the page with hidden elements
        try{
            hiddenElementsPage.clickRevealedButton();
            Assert.fail("Hidden button should not be clickable");
        } catch (Exception e){
            logger.info("Expected exception caught when trying to click hidden button: " + e.getMessage());
        }

        // Step 2: Click reveal button
        hiddenElementsPage.clickHiddenButton();

        // Step 3: Validate hidden button is displayed
        Assert.assertTrue(hiddenElementsPage.isHiddenButtonDisplayed(), "Hidden button is not displayed");

        // Step 4: Click revealed button successfully
        hiddenElementsPage.clickRevealedButton();
        logger.info("Successfully clicked the revealed button after it became visible");
    }

}
