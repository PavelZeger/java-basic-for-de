package lab12;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Pavel Zeger
 */
public class ListUtils {
    public static <T> void forEachWithDelay(List<T> list, int delay, Consumer<T> consumer) throws InterruptedException {
        Predicate<T> isT = Objects::nonNull;
        for (T t : list) {
            if (isT.test(t)) {
                consumer.accept(t);
                Thread.sleep(delay);
            } else {
                throw new RuntimeException("The object isn't of required type");
            }

        }

    }

    public static <T> void forEachWithDelay(List<T> list, int delay, CustomConsumer<T> customConsumer) throws InterruptedException {
        Predicate<T> isT = Objects::nonNull;
        for (T t : list) {
            if (isT.test(t)) {
                customConsumer.accept(t);
                Thread.sleep(delay);
            } else {
                throw new RuntimeException("The object isn't of required type");
            }

        }
    }

}
