package lab02;

import java.util.ArrayList;

/**
 * @author Pavel Zeger
 */
public class MainLab02 {
    public static void main(String[] args) {

        ArrayList<Soldier> soldiers = new ArrayList<>();

        soldiers.add(new Soldier("John", 23));
        soldiers.add(new Soldier("Guy", 18));
        soldiers.add(new Soldier("David", 40));
        soldiers.add(new Soldier("Greg", 35));
        soldiers.add(new Soldier("Chandler", 29));

        SoldierServiceImpl soldierServiceImpl = new SoldierServiceImpl();

        System.out.println("The average age of soldiers: " + soldierServiceImpl.getAverageAge(soldiers));
        System.out.println("The summary age of soldiers: " + soldierServiceImpl.getSummaryAge(soldiers));
        System.out.println("The maximum age of soldiers: " + soldierServiceImpl.getMaxAge(soldiers));

    }
}
