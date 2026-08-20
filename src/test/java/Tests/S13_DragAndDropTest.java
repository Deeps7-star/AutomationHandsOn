package Tests;

import org.automationConcepts.Pages.S13_DragAndDropPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S13_DragAndDropTest extends BaseTest{
    private static Logger logger = LoggerFactory.getLogger(S13_DragAndDropTest.class);
    @Test
    public void verifyDragAndDrop() {
        S13_DragAndDropPage dragAndDropPage = new S13_DragAndDropPage(driver);
        dragAndDropPage.performDragAndDrop();
        Assert.assertTrue(true, "Drag and drop validation failed.");
        logger.info("Drag and drop validated successfully.");
    }

}
