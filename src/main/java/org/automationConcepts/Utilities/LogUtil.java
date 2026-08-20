package org.automationConcepts.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LogUtil {
        private static final String LOG_FILE_PATH = "logs/test.log";

        // ===== LOGGER CREATION =====
        public static Logger getLogger(Class<?> clazz) {
            return LoggerFactory.getLogger(clazz);
        }

        // ===== LOG VALIDATION =====
        public static boolean isLogPresent(String expectedText) {
            try {
                List<String> logs = Files.readAllLines(Paths.get(LOG_FILE_PATH));
                return logs.stream().anyMatch(line -> line.contains(expectedText));
            } catch (IOException e) {
                throw new RuntimeException("Unable to read log file", e);
            }
        }
}
