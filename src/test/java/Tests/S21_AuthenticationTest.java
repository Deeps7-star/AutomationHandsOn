package Tests;

import org.automationConcepts.Pages.S21_AuthenticationPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S21_AuthenticationTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(S21_AuthenticationTest.class);

    @Test(description = "Verify valid login")
    public void testValidLogin() {
        logger.info("Starting Valid Login Test");
        S21_AuthenticationPage authPage = new S21_AuthenticationPage(driver);
        authPage.login("admin", "password");
        String actualResult = authPage.getLoginResult();
        logger.info("Actual Result: {}", actualResult);
        Assert.assertEquals(actualResult, "Login Successful");
        logger.info("Valid Login Test Passed");
    }
}