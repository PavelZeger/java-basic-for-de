package lab08_s.controllers;

import com.github.javafaker.Faker;
import lab08_s.prototypes.Hero;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Pavel Zeger
 */
public class HeroFactory {

    private static final String PACKAGE_NAME = "lab08_s.types";

    public ArrayList<String> scan(final Class<? extends Annotation> annotation) {
        Reflections reflections = new Reflections(PACKAGE_NAME);
        Iterable<String> annotated = reflections.getStore().get(TypeAnnotationsScanner.class.getSimpleName(), annotation.getName());
        ArrayList<String> classes = new ArrayList<>();
        annotated.forEach(classes::add);
        return classes;
    }

    public Hero createHero() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Faker faker = new Faker();
        Random random = new Random();
        ArrayList<String> classes = scan(EntityToBeScanned.class);
        String randomHero = classes.get(random.nextInt(classes.size()));
        String heroName = faker.name().firstName();
        System.out.println("The new " + randomHero.substring(randomHero.lastIndexOf(".") + 1) + " born: " + heroName + "!");
        return (Hero) Class.forName(randomHero).getConstructor(String.class).newInstance(heroName);
    }
}
