package Listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.automationConcepts.Utilities.DriverManager;
import org.automationConcepts.Utilities.ExtentManager;
import org.automationConcepts.Utilities.ScreenshotUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private int passCount = 0;
    private int failCount = 0;
    private int skipCount = 0;

    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.setTest(
                ExtentManager.getInstance().createTest(result.getName())
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        passCount++;
        if (ExtentManager.getTest() != null) {
            ExtentManager.getTest().pass("Test Passed");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failCount++;
        try {
            String path = ScreenshotUtil.takeScreenshot(DriverManager.getDriver(),result.getName());
            if (path != null) {
                ExtentManager.getTest().fail(
                        result.getThrowable(),
                        MediaEntityBuilder
                                .createScreenCaptureFromPath(path)
                                .build());
            } else {
                if (ExtentManager.getTest() != null) {
                    ExtentManager.getTest().fail(result.getThrowable());
                }
            }
        } catch (Exception e) {
            System.out.println("Listener failure: " + e.getMessage());
            if (ExtentManager.getTest() != null) {
                ExtentManager.getTest().fail(result.getThrowable());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skipCount++;
        ExtentManager.getTest().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println("PASSED: " + passCount);
        System.out.println("FAILED: " + failCount);
        System.out.println("SKIPPED: " + skipCount);

        ExtentManager.getInstance().flush();
        ExtentManager.unload();

        // AUTO OPEN REPORT
        try {
            String path = System.getProperty("user.dir")
                    + "/test-output/ExtentReport.html";

            java.awt.Desktop.getDesktop().browse(new java.io.File(path).toURI());

        } catch (Exception e) {
            System.out.println("Could not open report automatically");
        }
    }
}