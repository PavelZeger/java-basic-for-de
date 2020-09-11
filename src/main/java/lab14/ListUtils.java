package lab14;

import java.util.List;

/**
 * @author Pavel Zeger
 */
public class ListUtils {

    public static int getAverageAge(List<Customer> list) {
        return (int) list.stream()
                .mapToInt(Customer::getAge)
                .summaryStatistics()
                .getAverage();
    }

}
