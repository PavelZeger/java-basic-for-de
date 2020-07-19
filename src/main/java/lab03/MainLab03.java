package lab03;

import java.util.ArrayList;

/**
 * @author Pavel Zeger
 */
public class MainLab03 {
    public static void main(String[] args) {

        SoldierServiceImpl soldierService = new SoldierServiceImpl();

        soldierService.addSoldier(new Soldier("John", 23, 1));
        soldierService.addSoldier(new Soldier("Guy", 18, 2));
        soldierService.addSoldier(new Soldier("David", 40, 3));
        soldierService.addSoldier(new Soldier("Greg", 35, 4));
        soldierService.addSoldier(new Soldier("Chandler", 29, 5));

        System.out.println("The average age of soldiers: " + soldierService.getAverageAge());
        System.out.println("The summary age of soldiers: " + soldierService.getSummaryAge());
        System.out.println("The maximum age of soldiers: " + soldierService.getMaxAge());

        soldierService.printAllSoldiersNames();

        soldierService.addSoldier(new Soldier("Chandler", 29, 5));

    }
}
