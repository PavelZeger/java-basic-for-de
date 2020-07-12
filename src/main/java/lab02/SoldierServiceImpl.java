package lab02;

import java.util.ArrayList;

/**
 * @author Pavel Zeger
 */
public class SoldierServiceImpl implements SoldierService {

    public double getAverageAge(ArrayList<Soldier> soldiers) {
        return soldiers.stream()
                .mapToInt(Soldier::getAge)
                .summaryStatistics()
                .getAverage();
    }

    public double getSummaryAge(ArrayList<Soldier> soldiers) {
        return soldiers.stream()
                .mapToInt(Soldier::getAge)
                .summaryStatistics()
                .getSum();
    }

    public double getMaxAge(ArrayList<Soldier> soldiers) {
        return soldiers.stream()
                .mapToInt(Soldier::getAge)
                .summaryStatistics()
                .getMax();
    }
}
