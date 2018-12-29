package lk.ijse.gdse.client.common;

import java.time.*;

public class DateConverter {

    public static LocalDate fromDate(java.util.Date date) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
                .toLocalDate();
    }
    public static LocalTime fromTime(java.util.Date date) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
                .toLocalTime();
    }
    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}
