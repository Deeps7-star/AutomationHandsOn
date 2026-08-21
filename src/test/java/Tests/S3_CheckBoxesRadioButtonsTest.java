package Tests;

import org.automationConcepts.Pages.S3_CheckBoxesRadioButtonsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S3_CheckBoxesRadioButtonsTest extends BaseTest {

    @Test
 // just checking git 3
    public void verifyCheckboxesAndRadioButtons() {

        S3_CheckBoxesRadioButtonsPage checkBoxPage = new S3_CheckBoxesRadioButtonsPage(driver);

        // Step 1: Select checkboxes
        checkBoxPage.selectJava();
        checkBoxPage.selectJavaScript();

        // Step 2: Click Select All
        checkBoxPage.clickSelectAll();

        // Step 3: Validate all selected
        Assert.assertTrue(checkBoxPage.areAllLanguagesSelected(), "Not all language checkboxes are selected");

        // Step 4: Select Junior radio
        // Step 5: Validate radio selection
        checkBoxPage.selectJunior();
        Assert.assertTrue(checkBoxPage.isJuniorSelected(), "Junior radio button is not selected");

        // Step 6: Reveal hidden text
        // Step 7:  Validate text is visible
        checkBoxPage.clickRevealHiddenText();
        String actualText = checkBoxPage.getHiddenText();
        Assert.assertEquals(actualText, "Hidden text is now visible.");
    }
}
