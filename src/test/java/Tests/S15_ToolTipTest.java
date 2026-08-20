package Tests;

import org.automationConcepts.Pages.S15_ToolTipPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class S15_ToolTipTest extends BaseTest {

     /*
    🔹 Test Case: Verify Tooltip Display on Hover
    1. Navigate to the page with the tooltip.
    2. Hover over the element that triggers the tooltip.
    3. Verify that the tooltip appears with the correct text.
     */
    @Test
    public void verifyTooltipDisplayOnHover(){
        S15_ToolTipPage toolTipPage = new S15_ToolTipPage(driver);
        String expectedTooltipText = "Tooltip Text Appears Here";
        String actualTooltipText = toolTipPage.validateTooltip();
        softAssert.assertEquals(actualTooltipText, expectedTooltipText, "Tooltip text should match expected value");
        softAssert.assertAll();
    }
}
