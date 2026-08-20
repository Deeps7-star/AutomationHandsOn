package Tests;

import org.automationConcepts.Pages.S26_KeyboardActionsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class S26_KeyboardActionsTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(S26_KeyboardActionsTest.class);
    @Test
    public void verifykeyboardActions(){
        S26_KeyboardActionsPage keyboardActionsPage = new S26_KeyboardActionsPage(driver);
        Map<String, String> expected = Map.of(
                "ARROW_UP", "Key Pressed : ArrowUp",
                "ARROW_DOWN", "Key Pressed : ArrowDown",
                "ARROW_LEFT", "Key Pressed : ArrowLeft",
                "ARROW_RIGHT", "Key Pressed : ArrowRight"
        );

        logger.info("Expected keyboard results: {}", expected);

        Map<String, String> actual =
                keyboardActionsPage.performKeyboardNavigationAndGetResults();
        logger.info("Actual keyboard results: {}", actual);

        for (String key : expected.keySet()) {
            logger.info("Validating key: {}", key);

            String actualValue = actual.get(key);
            String expectedValue = expected.get(key);

            logger.info("Expected [{}] = {}", key, expectedValue);
            logger.info("Actual   [{}] = {}", key, actualValue);

            Assert.assertEquals(actual.get(key), expected.get(key),
                    "Mismatch for: " + key);
        }
        logger.info("===== Keyboard Actions Test Passed =====");
    }
}

/* Try this later
Keyboard Framework Layer:
KeyboardActionUtil (central class)
Key → Result mapping engine
Support CTRL/SHIFT combos
Auto-suggestion navigation support*/
