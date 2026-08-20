package Tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.automationConcepts.Pages.S29_ResizableElementPage;

public class S29_ResizableElementTest extends BaseTest {

    public static final boolean DEBUG_MODE = true;

    private static final Logger logger =
            LoggerFactory.getLogger(S29_ResizableElementTest.class);

    @Test
    public void verifyResizableElementShrink() {

        S29_ResizableElementPage resizablePage =
                new S29_ResizableElementPage(driver);

        int initialWidth = resizablePage.getWidth();
        int initialHeight = resizablePage.getHeight();

        logger.info("Initial size - Width: {}, Height: {}",
                initialWidth, initialHeight);

        // EXPAND
        resizablePage.resizeJS(50, 50);

        int expandedWidth = resizablePage.getWidth();
        int expandedHeight = resizablePage.getHeight();

        logger.info("Expanded size - Width: {}, Height: {}",
                expandedWidth, expandedHeight);

        Assert.assertTrue(expandedWidth > initialWidth);
        Assert.assertTrue(expandedHeight > initialHeight);

        // SHRINK
        resizablePage.resizeJS(-30, -30);

        int shrunkWidth = resizablePage.getWidth();
        int shrunkHeight = resizablePage.getHeight();

        logger.info("Shrunk size - Width: {}, Height: {}",
                shrunkWidth, shrunkHeight);


        Assert.assertTrue(shrunkWidth < expandedWidth,
                "Width did not decrease after shrink");

        Assert.assertTrue(shrunkHeight < expandedHeight,
                "Height did not decrease after shrink");
    }
}