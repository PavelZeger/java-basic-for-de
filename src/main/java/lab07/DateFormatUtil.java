package lab07;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author Pavel Zeger
 */
public class DateFormatUtil {

    private DateTimeFormatter formatter;

    public DateFormatUtil(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public String convert(LocalDate date) {
        return date.toString();
    }

    public String convert(LocalDateTime date) {
        return date.toString();
    }

    public LocalDate convert(String text) {
        return LocalDate.parse(text, getFormatter());
    }

    public LocalDateTime convertToLocalDateTime(String text) {
        return LocalDateTime.parse(text, getFormatter());
    }

}
