package app.utils;

import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;

public class DateUtils {
    public static LocalDate parseDateStr(String dateStr) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateStr, inputFormatter);
    }
    
    public static LocalDate parseEditedDate(String dateStr) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return LocalDate.parse(dateStr, inputFormatter);
    }
    
    public static String formatLocalDate(LocalDate date) {
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return date.format(outputFormatter);
    }
    
    public static long countDays(LocalDate start, LocalDate end) {
    	return ChronoUnit.DAYS.between(start, end);
    }
}
