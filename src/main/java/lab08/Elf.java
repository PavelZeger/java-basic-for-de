package lab08;

import java.util.Objects;

/**
 * @author Pavel Zeger
 */
public class Elf extends Hero {

    private String name;
    private int power = 10;
    private int hp = 10;

    public Elf(String name) {
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
     * @param hero
     */
    @Override
    public void kick(Hero hero) {
        System.out.println(this.getName() + " is kicking " + hero.getName());
        if (this.power > hero.getPower()) {
            hero.setHp(0);
            System.out.println("R.I.P. " + hero.getName());
        } else {
            hero.setPower(hero.getPower() - 1);
            System.out.println("The power of " + hero.getName() + " is " + hero.getPower());
        }
    }

    /**
     * Give the indication of a hero is alive
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
        Elf elf = (Elf) o;
        return getPower() == elf.getPower() &&
                getHp() == elf.getHp() &&
                Objects.equals(getName(), elf.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPower(), getHp());
    }

    @Override
    public String toString() {
        return "Elf{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", hp=" + hp +
                '}';
    }
}
