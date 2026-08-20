package org.automationConcepts.Utilities;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    // This class will be responsible for reading configuration properties from a file (e.g., config.properties)
    // It will provide methods to get values like base URL, browser type, timeouts, etc.
    //Properties object to hold the loaded config values. It is static so that it is shared across all instances of ConfigReader (though we won't create any instances since all methods are static).
    private static final Properties properties = new Properties();

    // Static block to load properties when the class is first loaded. This ensures that the properties are available for all static methods without needing to create an instance of ConfigReader.
    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("config.properties file NOT found in classpath");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    // Private constructor - no one should instantiate this class - Prevents object creation.
    private ConfigReader() {
    }

    // Generic getter that read property value - Fetches value for given key.
    public static String get(String key) {
        String value = properties.getProperty(key);  // reads value from loaded properties.

        if (value == null || value.trim().isEmpty()) { //Protects framework from missing or empty config values. If value is null or empty, it throws a runtime exception with a clear message.
            throw new RuntimeException(
                    "Config key missing or empty: " + key
            );
        }

        return value.trim();  //Removes accidental spaces from config values.
    }

    //Integer getter - Converts string value to int. If conversion fails, it throws a runtime exception with a clear message.
    public static int getInt(String key) {
        try {
            return Integer.parseInt(get(key).trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid integer value for key: " + key);
        }
    }

    //Boolean getter - Converts string value to boolean. It treats "true" (case-insensitive) as true, and anything else as false.
    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    // Optional getter with default value - If the key is missing or empty, it returns the provided default value instead of throwing an exception.
    public static String getOrDefault(String key, String defaultValue) {
        String value = properties.getProperty(key);
        return (value == null || value.trim().isEmpty())
                ? defaultValue
                : value.trim();
    }

    // Convenience methods for common keys (optional but improves readability)
    public static String getBaseUrl()       { return get("base.url"); }
    public static int getImplicitWait()  { return getInt("implicit.wait"); }
    public static int getPageLoadTimeout() { return getInt("page.load.timeout"); }
    public static String getBrowser()       { return get("browser"); }
}
