package lab08;

import java.util.Objects;
import java.util.Random;

/**
 * @author Pavel Zeger
 */
public class King extends Hero {

    private String name;
    private int power;
    private int hp;
    private static final int MAX = 15;
    private static final int MIN = 5;

    public King(String name) {
        Random random = new Random();
        int randomNumPower = random.ints(MIN, MAX + 1)
                .findFirst()
                .getAsInt();
        int randomNumHp = random.ints(MIN, MAX + 1)
                .findFirst()
                .getAsInt();
        this.name = name;
        this.power = randomNumPower;
        this.hp = randomNumHp;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Kick another hero in the game
     *
     * @param hero
     */
    @Override
    public void kick(Hero hero) {
        System.out.println(this.getName() + " is kicking " + hero.getName());
        Random random = new Random();
        int randomNum = random.ints(MIN, MAX + 1)
                .findFirst()
                .getAsInt();
        hero.setHp(randomNum);
        System.out.println("The heat point of " + hero.getName() + " is " + hero.getHp());
    }

    /**
     * Give the indication of a hero is alive
     *
     * @return
     */
    @Override
    public boolean isAlive() {
        return getHp() != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        King king = (King) o;
        return getPower() == king.getPower() &&
                getHp() == king.getHp() &&
                Objects.equals(getName(), king.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPower(), getHp());
    }

    @Override
    public String toString() {
        return "King{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", hp=" + hp +
                '}';
    }
}
