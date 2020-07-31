package lab08;

/**
 * @author Pavel Zeger
 */
public abstract class Hero {

    private String name;
    private int power;
    private int hp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Kick another hero in the game
     * @param hero
     */
    public abstract void kick(Hero hero);

    /**
     * Give the indication of a hero is alive
     * @return
     */
    public abstract boolean isAlive();
}
