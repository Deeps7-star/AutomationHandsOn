package Tests;

import org.automationConcepts.Pages.S23_DynamicListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S23_DynamicListTest extends BaseTest{


    @Test(description = "Verify adding items to dynamic list")
    public void testAddItemsToDynamicList() {

        S23_DynamicListPage page = new S23_DynamicListPage(driver);

        int beforeCount = page.getItemCount();

        String[] items = {
                "Namjoon", "Seokjin", "Yoongi",
                "Hoseok", "Jimin", "Taehyung", "Jungkook"
        };

        int expected = beforeCount;

        for (String item : items) {
            expected++;
            page.addItemToList(item, expected);
        }

        int afterCount = page.getItemCount();

        Assert.assertEquals(afterCount, beforeCount + items.length);
    }
}
