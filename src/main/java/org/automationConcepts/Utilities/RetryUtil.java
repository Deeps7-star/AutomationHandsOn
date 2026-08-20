package org.automationConcepts.Utilities;

import java.util.function.Supplier;

public class RetryUtil {
    public static <T> T retry(Supplier<T> action,
                              int maxAttempts,
                              long delayMillis) {

        Exception lastException = null;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {

            try {
                return action.get();

            } catch (Exception e) {

                lastException = e;

                System.out.println(
                        "Retry attempt "
                                + attempt
                                + " failed: "
                                + e.getMessage()
                );

                try {
                    Thread.sleep(delayMillis);
                } catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        throw new RuntimeException(
                "Action failed after retries",
                lastException
        );
    }
}
