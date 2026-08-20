package Tests;

import org.automationConcepts.Pages.S27_SliderElementPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S27_SliderElementTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(S27_SliderElementTest.class);

    //Later in page: try with drag and drop action, if it fails, use JavaScript to set the slider value directly

    @Test
    public void verifySliderElements()  {

        S27_SliderElementPage sliderPage = new S27_SliderElementPage(driver);

        Assert.assertTrue(sliderPage.isSliderVisible());

        sliderPage.moveSliderUsingJS(95);

        sliderPage.verifySliderValue(95);

    }
}