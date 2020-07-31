package lab08;

/**
 * @author Pavel Zeger
 */
public class GameManager {

    private int kicksAmount;

    public GameManager(int kicksAmount) {
        this.kicksAmount = kicksAmount;
    }

    public void fight(Hero firstHero, Hero secondHero) {
        System.out.println("The fight started till death or end of kicks!");
        System.out.println("You have " + kicksAmount + " kicks only.");
        System.out.println();
        while(kicksAmount >= 0) {
            if (!firstHero.isAlive() || !secondHero.isAlive()) {
                System.out.println("The fight finished!");
                System.out.println("The winner is: " +
                        (firstHero.isAlive() ? firstHero.getName() : secondHero.getName()) +
                        "!");
                break;
            }
            if (kicksAmount == 0) {
                System.out.println("The fight finished!");
                if (firstHero.getHp() > secondHero.getHp()) {
                    System.out.println("The winner is: "  + firstHero.getName());
                } else if (firstHero.getHp() < secondHero.getHp()) {
                    System.out.println("The winner is: "  + secondHero.getName());
                } else {
                    System.out.println("Nobody won!");
                }
                break;
            }
            firstHero.kick(secondHero);
            secondHero.kick(firstHero);
            kicksAmount -= 2;
        }
    }
}
