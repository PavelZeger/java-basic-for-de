package lab05;

import java.util.Objects;

/**
 * @author Pavel Zeger
 */
public class Person {

    public final static int MAX_AGE = 120;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0 || age > MAX_AGE) {
            throw new IllegalStateException("Age is not in valid range: " + age);
        } else {
            this.age = age;
        }
    }

}