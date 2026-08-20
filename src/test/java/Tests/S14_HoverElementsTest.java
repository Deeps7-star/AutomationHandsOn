package Tests;

import org.automationConcepts.Pages.S14_HoverElementsPage;
import org.testng.annotations.Test;

public class S14_HoverElementsTest extends BaseTest{

        @Test
        public void testHoverElements(){
            S14_HoverElementsPage hoverElementsPage = new S14_HoverElementsPage(driver);
            hoverElementsPage.hoverOverElement();
        }

}
