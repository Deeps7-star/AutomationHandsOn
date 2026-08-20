package Tests;

import org.automationConcepts.Pages.S28_DatePickerPage;
import org.automationConcepts.Utilities.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S28_DatePickerTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(S28_DatePickerTest.class);

    @Test
    public void testDatePicker() {
        S28_DatePickerPage datePickerPage = new S28_DatePickerPage(driver);

        logger.info("Starting Date Picker Test");
        String inputDate = "25/12/2024";

        // Step 1: set date
        datePickerPage.selectDate(inputDate);
        // Step 2: get actual value from DOM
        String actualISO = datePickerPage.getSelectedDate();
        // Step 3: expected value conversion
        String expectedISO = DateUtil.toISO(inputDate);
        logger.info("Expected ISO: {}", expectedISO);
        logger.info("Actual ISO: {}", actualISO);
        // Step 4: assertion (TestNG recommended)
        Assert.assertEquals(actualISO, expectedISO, "Date mismatch in Date Picker");
        logger.info("Date Picker Test completed successfully");
    }
}