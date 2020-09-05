package lab13;

import java.util.Comparator;

/**
 * @author Pavel Zeger
 */
public class PointComparator implements Comparator<Point> {

    @Override
    public int compare(Point point1, Point point2) {
        int points1 = point1.getX() + point1.getY() + point1.getZ();
        int points2 = point2.getX() + point2.getY() + point2.getZ();
        return Integer.compare(points1, points2);
    }
}
