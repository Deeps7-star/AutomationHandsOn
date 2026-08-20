package org.automationConcepts.Utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter INPUT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter OUTPUT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String toISO(String ddMMyyyy) {
        return LocalDate.parse(ddMMyyyy, INPUT).format(OUTPUT);
    }

    public static String toDisplay(String iso) {
        return LocalDate.parse(iso, OUTPUT).format(INPUT);
    }
}