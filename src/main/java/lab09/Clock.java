package lab09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

/**
 * @author Pavel Zeger
 */
@Service
public class Clock {

    @Autowired
    private Set<Regime> regimes;
    private Regime currentRegime;

    public void modeA() {
        currentRegime.modeA();
    }

    public void modeB() {
        currentRegime.modeB();
    }

    public void setRegime(String regimeName) {
        for (Regime regime : regimes) {
            if (regime.getClass().getSimpleName().equals(regimeName))
                this.currentRegime = regime;
        }
        System.out.println("The current regime is: " + currentRegime.getClass().getSimpleName());
    }

}
