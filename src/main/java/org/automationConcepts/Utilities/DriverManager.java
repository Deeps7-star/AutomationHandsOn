package org.automationConcepts.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;

public class DriverManager {
    private DriverManager() {}  // Prevents accidental object creation
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>(); //Each thread will have its own independent browser.
    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);

    // Initialize driver per thread
    public static void initializeDriver(){
        if (driverThreadLocal.get() == null) {
            String browser = ConfigReader.getBrowser();
            logger.info("Launching browser: " + browser);
            ChromeOptions options = new ChromeOptions(); //ChromeOptions are used to customize browser behavior.

            options.setAcceptInsecureCerts(true); //Allows testing websites with SSL certificate issues.
            options.addArguments("--start-maximized"); //Launches browser maximized.
            options.addArguments("--remote-allow-origins=*"); //Fixes newer ChromeDriver communication restrictions.
            options.addArguments("--ignore-certificate-errors"); //Prevents SSL warning interruptions.


            WebDriver driver;
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver(options); //Initializes ChromeDriver with specified options.
                    break;
                // Future browser cases (e.g., Firefox, Edge) can be added here.
                default:
                    logger.warn("Unsupported browser specified in config: " + browser + ". Defaulting to Chrome.");
                     driver = new ChromeDriver(options);
            }
            //waits and timeouts
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getImplicitWait()));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigReader.getPageLoadTimeout())); //Controls maximum page loading time.
            logger.info("Opening URL: " + ConfigReader.getBaseUrl());
            driver.get(ConfigReader.getBaseUrl()); //Opens the base URL defined in configuration.
            driverThreadLocal.set(driver); // Stores browser inside current thread.
        }
    }

    // Get WebDriver instance for the current thread
    public static WebDriver getDriver() {
        return driverThreadLocal.get(); //Returns current thread’s browser.
    }

    //Quit driver for current thread and Remove WebDriver instance for the current thread (cleanup)
    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            logger.info("Closing browser");
            try {
                driverThreadLocal.get().quit();
            } catch (Exception e) {
                logger.error("Error while quitting driver", e);
            } finally {
                driverThreadLocal.remove(); // Removes driver object from ThreadLocal memory.prevents memory leak
            }
        }
    }
}
