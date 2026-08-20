package org.automationConcepts.Utilities;

import org.openqa.selenium.*;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String testName) {

        try {
            if (driver == null) {
                return null;
            }

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            String dir = System.getProperty("user.dir") + "/screenshots/";

            new File(dir).mkdirs();

            String path = dir + testName + "_" + timestamp + ".png";

            File dest = new File(path);

            Files.copy(src.toPath(), dest.toPath());

            return path;

        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
            return null;
        }
    }
}