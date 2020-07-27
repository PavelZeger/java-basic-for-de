package lab06;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author Pavel Zeger
 */
public class DateServiceTest {

    private DateService dateService = new DateService();

    //@Test
    public void differenceInDays() {
        MyDate from = new MyDate(2019, 5, 22);
        MyDate till = new MyDate(2019, 12, 31);
        Assert.assertEquals(223, dateService.differenceInDays(from, till));
    }

    //@Test
    public void addDays() {
        MyDate from = new MyDate(2019, 1, 1);
        MyDate till = dateService.addDays(from, 143);
        Assert.assertEquals(till, new MyDate(2019, 5, 24));
    }
}