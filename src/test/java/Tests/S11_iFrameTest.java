package Tests;

import org.automationConcepts.Pages.S11_iFramePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class S11_iFrameTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(S11_iFrameTest.class);

    @Test
    public void verifyiFrameInteraction(){
        S11_iFramePage iFramePage = new S11_iFramePage(driver);

        // Switch to iFrame before interacting with elements inside it
        iFramePage.switchToiFrame();
        // Type text inside iFrame input field
        String textToType = "Hello iFrame!";
        iFramePage.typeIniFrameInput(textToType);
        logger.info("Typed text in iFrame input: {}", textToType);
        // Click button inside iFrame
        iFramePage.clickiFrameButton();
        logger.info("Clicked button inside iFrame");
        // Switch back to main content after interacting with iFrame
        iFramePage.switchBackToMainContent();

    }
}
