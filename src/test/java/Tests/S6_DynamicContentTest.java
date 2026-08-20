package Tests;

import org.automationConcepts.Pages.S6_DynamicContentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S6_DynamicContentTest  extends BaseTest{

    @Test
    public void verifyDynamicContent(){
        S6_DynamicContentPage dynamicContent = new S6_DynamicContentPage(driver);

        // Test 1: Show Delayed Element
        dynamicContent.clickShowDelayedElement();
        String delayedText = dynamicContent.getDelayedText();
        System.out.println("Actual text is: " + delayedText);
        assert delayedText.trim().equals("I appeared after delay.") : "Delayed text did not match expected value";

        // Test 2: Hide Element
        dynamicContent.clickHideElement();
        boolean clickHideElement = dynamicContent.waitForHiddenTextToDisappear();
        Assert.assertTrue(clickHideElement, "Hidden text did not disappear as expected");

        // Test 3: Change Dynamic Text
        dynamicContent.clickChangeDynamicText();
        String dynamicText = dynamicContent.getDynamicText();
        System.out.println("Dynamic text is: " + dynamicText);
        assert dynamicText.equals("Dynamic Text Updated") : "Dynamic text did not match expected value";

        // Test 4: Counter Up
        dynamicContent.clickCounterUp();
        String counterValue = dynamicContent.getCounterValue();
        System.out.println("Counter value is: " + counterValue);
        assert counterValue.equals("1") : "Counter value did not increment as expected";
    }
}
