package Tests;

import org.automationConcepts.Pages.S1_BasicFormElementsPage;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class S1_BasicFormElementsTest extends BaseTest {
    private static final Logger logger = Logger.getLogger(S1_BasicFormElementsTest.class.getName());
    @Test
    public void verifyFormElements() {
        S1_BasicFormElementsPage formPage = new S1_BasicFormElementsPage(driver); // Create page object and pass driver to it.
// just checking git
        // Perform actions
        formPage.fillActions("Namjoon",
                "12345",
                "namjoon.kim@gmail.com",
                "98988989898",
                "Hello, this is a test automation.");

        // Validation
        Assert. assertTrue(driver.getCurrentUrl().contains("preview"), "Page URL validation passed.");
        logger.info("URL validation passed: " + driver.getCurrentUrl());
    }

}
