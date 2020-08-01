package lab08_s.types;

import lab08_s.controllers.EntityToBeScanned;
import lab08_s.prototypes.Hero;
import java.util.Objects;

/**
 * @author Pavel Zeger
 */
@EntityToBeScanned
public class Knight extends Hero {

    private String name;
    private int power;
    private int hp;
    private static final int MIN = 2;
    private static final int MAX = 12;

    public Knight(String name) {
        super(name);
        this.name = name;
        this.power = getRandom();
        this.hp = getRandom();
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
     * @param hero - class Hero
     */
    @Override
    public void kick(Hero hero) {
        super.kick(hero);
    }

    /**
     * Give the indication if this hero is alive
     * @return true
     */
    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    /**
     * Generate random number in the range for power and hp parameters
     * @return int
     */
    @Override
    protected int getRandom() {
        return super.getRandom();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return getPower() == knight.getPower() &&
                getHp() == knight.getHp() &&
                Objects.equals(getName(), knight.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPower(), getHp());
    }

    @Override
    public String toString() {
        return "Knight{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", hp=" + hp +
                '}';
    }
}
