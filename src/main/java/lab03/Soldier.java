package lab03;

import java.util.Objects;

/**
 * @author Pavel Zeger
 */
public class Soldier {

    private String name;
    private int age;
    private int id;

    public Soldier(int age) {
        this.age = age;
    }

    public Soldier(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Soldier soldier = (Soldier) o;
        return id == soldier.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}