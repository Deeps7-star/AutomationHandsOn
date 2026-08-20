package Tests;

import org.automationConcepts.Pages.S10_ModalPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class S10_ModalTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(S10_ModalTest.class);
    @Test
    public void verifyModalDialog(){
        S10_ModalPage modalPage = new S10_ModalPage(driver);

        modalPage.openModal();
        String modalText = modalPage.getModalText();
        logger.info("Modal text: {}", modalText);
        modalPage.closeModal();
    }
}
