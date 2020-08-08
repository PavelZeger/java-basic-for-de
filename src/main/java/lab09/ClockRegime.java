package lab09;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

/**
 * @author Pavel Zeger
 */
@Service
public class ClockRegime implements Regime {

    @Override
    public void modeA() {
        System.out.println("The hour is: " + LocalDateTime.now().getHour());
    }

    @Override
    public void modeB() {
        System.out.println("The minute is: " +  + LocalDateTime.now().getMinute());
    }

}
