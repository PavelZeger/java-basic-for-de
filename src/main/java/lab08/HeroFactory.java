package lab08;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Pavel Zeger
 */
public class HeroFactory {

    public Hero createHero() {
        Faker faker = new Faker();
        Random random = new Random();
        List<Hero> heroes = Arrays.asList(
                new Elf(faker.name().firstName()),
                new Hobbit(faker.name().firstName()),
                new Knight(faker.name().firstName()),
                new King(faker.name().firstName()));
        Hero randomHero = heroes.get(random.nextInt(heroes.size()));
        System.out.println("The new " +
                randomHero.getClass().getSimpleName() +
                " born: " +
                randomHero.getName() +
                "!");
        return randomHero;
    }

}
