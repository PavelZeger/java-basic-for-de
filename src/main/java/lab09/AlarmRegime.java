package lab09;

import org.springframework.stereotype.Service;

/**
 * @author Pavel Zeger
 */
@Service
public class AlarmRegime implements Regime {

    @Override
    public void modeA() {
        System.out.println("Alarm started!");
    }

    @Override
    public void modeB() {
        System.out.println("Alarm stopped!");
    }

}
