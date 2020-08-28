package lab12;

import lab11.Point;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Pavel Zeger
 */
public class MainLab12 {
    static Consumer<Point> pointer = point -> System.out.println(point.toString());

    public static void main(String[] args) throws InterruptedException {
        List<Point> points = List.of(
            new Point(1, 2, 4),
            new Point(641, 896, 4333),
            new Point(11, 65, 454),
            new Point(1, 2, 4),
            new Point(32, 27, 83),
            new Point(16, 30, 90),
            new Point(1, 56, 44),
            new Point(6, 8, 4),
            new Point(1, 2, 4),
            new Point(5, 3, 5));

        ListUtils.forEachWithDelay(points, 2000, pointer);
    }
}
