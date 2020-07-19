package lab03;

import java.util.ArrayList;

/**
 * @author Pavel Zeger
 */
public class SoldierServiceImpl implements SoldierService {

    private ArrayList<Soldier> soldiers;

    @Override
    public double getAverageAge() {
        return soldiers.stream()
                .mapToInt(Soldier::getAge)
                .summaryStatistics()
                .getAverage();
    }

    @Override
    public double getSummaryAge() {
        return soldiers.stream()
                .mapToInt(Soldier::getAge)
                .summaryStatistics()
                .getSum();
    }

    @Override
    public double getMaxAge() {
        return soldiers.stream()
                .mapToInt(Soldier::getAge)
                .summaryStatistics()
                .getMax();
    }

    @Override
    public void addSoldier(Soldier soldier) {
        if (soldiers.contains(soldier)) {
            System.out.println("The soldier " + soldier.getName() + " exists!");
        } else {
            soldiers.add(soldier);
        }
    }

    @Override
    public void printAllSoldiersNames() {
        soldiers.stream().forEach(soldier -> System.out.println(soldier.getName()));
    }

}
