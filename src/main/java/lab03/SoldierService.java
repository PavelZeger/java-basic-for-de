package lab03;

/**
 * @author Pavel Zeger
 */

import java.util.ArrayList;

public interface SoldierService {

    ArrayList<Soldier> soldiers = null;

    double getAverageAge();
    double getSummaryAge();
    double getMaxAge();
    void addSoldier(Soldier soldier);
    void printAllSoldiersNames();

}