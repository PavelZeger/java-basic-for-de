package lab13;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * @author Pavel Zeger
 */
public class ListUtilsTest {

    @Test
    public void sortTest() {
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
        List<Point> pointsExpected = List.of(
                new Point(641, 896, 4333),
                new Point(11, 65, 454),
                new Point(32, 27, 83),
                new Point(16, 30, 90),
                new Point(1, 56, 44),
                new Point(6, 8, 4),
                new Point(5, 3, 5),
                new Point(1, 2, 4),
                new Point(1, 2, 4),
                new Point(1, 2, 4));
        List<Point> pointsActual = ListUtils.sort(points, new PointComparator());
        pointsActual.forEach(System.out::println);
        assertEquals(pointsExpected.size(), pointsActual.size());
        assertArrayEquals(pointsExpected.toArray(), pointsActual.toArray());
    }

}