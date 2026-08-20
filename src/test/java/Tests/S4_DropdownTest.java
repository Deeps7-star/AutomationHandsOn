package Tests;

import org.automationConcepts.Pages.S4_DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class S4_DropdownTest extends BaseTest {

    @Test
    public void verifyDropdownSelections() {
        S4_DropdownPage dropdown = new S4_DropdownPage(driver);

        dropdown
                .selectCountryByText("UK")
                .selectMultipleOptions("Selenium", "Cypress")
                .selectCustomOption("Playwright")
                .selectDynamicOption("Safari");

        String country = dropdown.getSelectedCountry();
        List<String> multi = dropdown.getSelectedMultipleOptions();
        String custom = dropdown.getCustomSelectedValue();
        String dynamic = dropdown.getDynamicSelectedValue();

        Assert.assertEquals(country, "UK");

        Assert.assertEquals(multi.size(), 2);
        Assert.assertTrue(multi.contains("Selenium"));
        Assert.assertTrue(multi.contains("Cypress"));

        Assert.assertEquals(custom, "Playwright");
        Assert.assertEquals(dynamic, "Safari");
    }
}


        /*// Standard dropdown
        dropdown.selectCountryByText("UK");
        Assert.assertEquals(dropdown.getSelectedCountry(), "UK");

        // Multiple select
        dropdown.selectMultipleOptions("Robot Framework", "Selenium");
        Assert.assertTrue(dropdown.getSelectedMultipleOptions().contains("Robot Framework"));
        Assert.assertTrue(dropdown.getSelectedMultipleOptions().contains("Selenium"));

        // Custom dropdown
        dropdown.selectCustomOption("Selenium");
        Assert.assertEquals(dropdown.getCustomSelectedValue(), "Selenium");

        // Dynamic dropdown
        dropdown.selectDynamicOption("Sa", "Safari");
        Assert.assertEquals(dropdown.getDynamicSelectedValue(), "Safari");
    }
} */
