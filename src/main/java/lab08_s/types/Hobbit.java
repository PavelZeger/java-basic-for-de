package lab08_s.types;

import lab08_s.controllers.EntityToBeScanned;
import lab08_s.prototypes.Hero;
import java.util.Objects;

/**
 * @author Pavel Zeger
 */
@EntityToBeScanned
public class Hobbit extends Hero {

    private String name;
    private int power = 0;
    private int hp = 3;

    public Hobbit(String name) {
        super(name);
        this.name = name;
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
        System.out.println(this.getName() + " is kicking " + hero.getName());
        toCry();
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
     * Cry when kicked
     */
    public void toCry() {
        System.out.println(getName() + " is crying");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hobbit hobbit = (Hobbit) o;
        return getPower() == hobbit.getPower() &&
                getHp() == hobbit.getHp() &&
                Objects.equals(getName(), hobbit.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPower(), getHp());
    }

    @Override
    public String toString() {
        return "Hobbit{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", hp=" + hp +
                '}';
    }
}
