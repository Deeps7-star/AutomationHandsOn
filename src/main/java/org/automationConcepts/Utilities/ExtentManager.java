package org.automationConcepts.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir")
                    + "/test-output/ExtentReport.html";

            new File("test-output").mkdirs();

            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Framework", "Selenium TestNG");
            extent.setSystemInfo("User", System.getProperty("user.name"));
        }
        return extent;
    }

    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void unload() {
        test.remove();
    }
}