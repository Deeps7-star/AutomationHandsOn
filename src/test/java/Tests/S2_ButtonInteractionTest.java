package Tests;

import org.automationConcepts.Pages.S2_ButtonInteractionPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S2_ButtonInteractionTest extends BaseTest {
    @Test
    public void verifyButtonInteractions(){
   // Create page object and pass driver to it.
        S2_ButtonInteractionPage buttonPage = new S2_ButtonInteractionPage(driver);
   // Perform actions
        buttonPage.clickNormalButton();
        Assert.assertEquals(buttonPage.getButtonResultMessage(), "Normal Click Successful");
        buttonPage.doubleClickButton1();
        Assert.assertEquals(buttonPage.getButtonResultMessage(), "Double Click Successful");
        buttonPage.rightClick();
        Assert.assertEquals(buttonPage.getButtonResultMessage(), "Right Click Successful");
        buttonPage.validateDisabledButton();
        buttonPage.clickDelayedButton();
        String changedText = buttonPage.getButtonTextChange();
        Assert.assertEquals(changedText, "Button Text Changed");
        }
}
