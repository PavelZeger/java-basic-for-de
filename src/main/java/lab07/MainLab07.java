package lab07;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Pavel Zeger
 */
public class MainLab07 {
    public static void main(String[] args) {

        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateFormatService dateFormatServiceDate = new DateFormatService(formatterDate);

        DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateFormatService dateFormatServiceDateTime = new DateFormatService(formatterDateTime);

        LocalDate date = LocalDate.of(2017, 7, 25);
        LocalDateTime dateTime = LocalDateTime.of(2017, 8, 10, 13, 45);
        String dateString = formatterDate.format(date);
        String dateTimeString = formatterDateTime.format(dateTime);

        System.out.println(dateFormatServiceDate.convert(date));
        System.out.println(dateFormatServiceDateTime.convert(dateTime));

        System.out.println(dateFormatServiceDate.convert(dateString));
        System.out.println(dateFormatServiceDateTime.convertToLocalDateTime(dateTimeString));
    }
}
