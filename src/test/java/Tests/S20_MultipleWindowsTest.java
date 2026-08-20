package Tests;

import org.automationConcepts.Pages.S20_MultipleWindowsPage;
import org.automationConcepts.Utilities.WindowUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S20_MultipleWindowsTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(S20_MultipleWindowsTest.class);
    @Test(description = "Verify multiple windows handling")
    public void testMultipleWindows() {
        S20_MultipleWindowsPage multipleWindowsPage = new S20_MultipleWindowsPage(driver);

        // Step 1 — Store parent window
        String parentWindow = WindowUtil.getParentWindow(driver);

        // Step 2 — Open new tab
        multipleWindowsPage.clickOpenNewTabButton();

        // Step 3 + 4 — Switch to child window
        WindowUtil.switchToChildWindow(driver, parentWindow);

        // Step 5 — Validation/action in child tab
        String childTitle = multipleWindowsPage.getCurrentPageTitle();
        logger.info("Child Window Title: {}", childTitle);
        Assert.assertNotNull(childTitle);

        // Step 6 — Switch back to parent
        WindowUtil.switchToParentWindow(driver, parentWindow);
        logger.info("Returned to Parent Window");
    }
}