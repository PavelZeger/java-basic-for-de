package lab13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Pavel Zeger
 */
public class ListUtils {

    public static <T> List<T> sort(List<T> list, Comparator<T> comparator){
        List<T> sortedList = new ArrayList<>(list);
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (comparator.compare(sortedList.get(i), sortedList.get(j)) < 0){
                    T tempElem = sortedList.get(i);
                    sortedList.set(i, sortedList.get(j));
                    sortedList.set(j, tempElem);
                }
            }
        }
        return sortedList;
    }
}
