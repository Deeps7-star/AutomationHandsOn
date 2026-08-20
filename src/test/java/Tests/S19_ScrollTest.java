package Tests;

import org.automationConcepts.Pages.S19_ScrollPage;
import org.testng.annotations.Test;

public class S19_ScrollTest extends BaseTest{

    @Test
    public void verifyScrollTest(){
    S19_ScrollPage scrollPage = new S19_ScrollPage(driver);
    scrollPage.scrollToTargetAndClick();
    }
}
