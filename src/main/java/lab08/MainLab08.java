package lab08;

/**
 * @author Pavel Zeger
 */
public class MainLab08 {

    public static void main(String[] args) {
        int kicksAmount = 2;
        GameManager gameManager = new GameManager(kicksAmount);
        HeroFactory heroFactory = new HeroFactory();
        Hero firstHero = heroFactory.createHero();
        Hero secondHero = heroFactory.createHero();
        System.out.println();
        System.out.println(firstHero.toString());
        System.out.println(secondHero.toString());
        System.out.println();
        gameManager.fight(firstHero, secondHero);
    }
}
