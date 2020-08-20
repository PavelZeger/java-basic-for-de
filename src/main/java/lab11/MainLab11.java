package lab11;

import java.util.List;
import static lab11.ListUtils.countDuplicates;

/**
 * @author Pavel Zeger
 */
public class MainLab11 {
    public static void main(String[] args) {
        List<Point> points = List.of(
                new Point(1,2, 4),
                new Point(641,896, 4333),
                new Point(11,65, 454),
                new Point(1,2, 4),
                new Point(32,27, 83),
                new Point(16,30, 90),
                new Point(1,56, 44),
                new Point(6,8, 4),
                new Point(1,2, 4),
                new Point(5,3, 5));

        Point testPoint = new Point(1, 2, 4);
        System.out.println(countDuplicates(points, testPoint));
    }
}
