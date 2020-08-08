package lab09;

import org.springframework.stereotype.Service;
import java.time.LocalDate;

/**
 * @author Pavel Zeger
 */
@Service
public class CalendarRegime implements Regime {

    @Override
    public void modeA() {
        System.out.println("The month is: " + LocalDate.now().getMonth().toString());
    }

    @Override
    public void modeB() {
        System.out.println("The day is: " + LocalDate.now().getDayOfMonth());
    }

}
