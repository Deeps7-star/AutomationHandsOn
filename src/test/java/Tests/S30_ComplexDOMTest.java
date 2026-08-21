package Tests;

import org.automationConcepts.Pages.S30_ComplexDOMPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class S30_ComplexDOMTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(S30_ComplexDOMTest.class);
    @Test
    // Test method to verify complex DOM interactions
    public void verifyComplexDOMInteractions(){
        S30_ComplexDOMPage complexDOMPage = new S30_ComplexDOMPage(driver).clickComplexDOMButton();
        logger.info("Validation completed");
    }
}
