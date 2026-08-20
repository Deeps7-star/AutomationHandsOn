package Tests;

import org.automationConcepts.Pages.S12_ShadowDomPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S12_ShadowDomTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(S12_ShadowDomTest.class);
    @Test
    public void verifyUserCanInteractWithShadowDomElements() {
        S12_ShadowDomPage shadowDomPage = new S12_ShadowDomPage(driver);

        // Get and print the text of the label inside Shadow DOM
        String labelText = shadowDomPage.getShadowLabelText();
        logger.info("Label text inside Shadow DOM: {}", labelText);
        Assert.assertEquals(labelText, "Shadow Label", "Shadow label text mismatch"
        );

        // Type text into the input field inside Shadow DOM
        String textToType = "Hello Shadow DOM!";
        shadowDomPage.typeInShadowInput(textToType);
        logger.info("Typed text in Shadow DOM input: {}", textToType);

        // Click the button inside Shadow DOM
        shadowDomPage.clickShadowButton();
        logger.info("Clicked button inside Shadow DOM");
    }
}
