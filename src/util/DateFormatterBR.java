package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatterBR {
    public static String toDate(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return localDate.format(formatter);
    }
}
