package lab08_s.prototypes;

import java.util.Random;

/**
 * @author Pavel Zeger
 */
public abstract class Hero {

    private String name;
    private int power;
    private int hp;
    private static final int MIN = 0;
    private static final int MAX = 0;

    public Hero(String name) {
        this.name = name;
        this.power = getRandom();
        this.hp = getRandom();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Kick another hero in the game
     * @param hero - class Hero
     */
    public void kick(Hero hero) {
        System.out.println(this.getName() + " is kicking " + hero.getName());
        hero.setHp(getRandom());
        System.out.println("The heat points of " + hero.getName() + " are " + hero.getHp() + " now");
    }

    /**
     * Give the indication if this hero is alive
     * @return true
     */
    public boolean isAlive() {
        return getHp() != 0;
    }

    /**
     * Generate random number in the range for power and hp parameters
     * @return int
     */
    protected int getRandom() {
        Random random = new Random();
        return random.ints(MIN, MAX + 1)
                .findFirst()
                .getAsInt();
    }

}
