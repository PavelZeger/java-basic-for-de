package lab11;

import java.util.List;

/**
 * @author Pavel Zeger
 */
public class ListUtils {

    public static <T> int countDuplicates(List<T> list, T t) {
        return (int) list.stream().filter(elem -> (elem.equals(t) && elem.hashCode() == t.hashCode())).count();
    }
}
