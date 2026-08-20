package Tests;

import org.automationConcepts.Utilities.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected WebDriver driver; //makes driver available to ALL child test classes.
    protected SoftAssert softAssert;
    // Runs before every test method
    @BeforeMethod
    public void setUp() {
        softAssert = new SoftAssert();
        System.out.println("Starting Thread ID: " + Thread.currentThread().getId());
        DriverManager.initializeDriver();  // Initialize browser
        driver = DriverManager.getDriver(); // Get current thread driver
    }

    // Runs after every test method
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            System.out.println("Closing Thread ID: " + Thread.currentThread().getId());
        } finally {
            DriverManager.quitDriver();
        }
    }
}