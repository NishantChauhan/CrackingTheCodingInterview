import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RobotInAGrid {
    @Data
    @AllArgsConstructor
    @EqualsAndHashCode
    private static class Point {
        int row;
        int col;

        static Point of(int row, int col) {
            return new Point(row, col);
        }
    }

    static boolean[][] grid;
    static List<Point> path = new ArrayList<>();
    static Set<Point> invalidPoints = new HashSet<>();

    public List<Point> getPath(boolean[][] iGrid) {
        grid = iGrid;
        if (grid.length == 0 || grid[0].length == 0) {
            return List.of();
        }
        int destRow = grid.length - 1;
        int destCol = grid[0].length - 1;

        if (isPathOfValidPoints(Point.of(destRow, destCol))) {
            return path;
        }
        return List.of();
    }

    public boolean isPathOfValidPoints(Point p) {
        int row = p.getRow();
        int col = p.getCol();
        if (row < 0 || col < 0 || !grid[row][col]) {
            return false;
        }
        if (isInvalidPoint(p)) {
            return false;
        }
        Point left = Point.of(row, col - 1);
        Point up = Point.of(row - 1, col);
        if (isAtOrigin(p) || isPathOfValidPoints(up) || isPathOfValidPoints(left)) {
            path.add(Point.of(row, col));
            return true;
        }
        invalidPoints.add(p);
        return false;
    }

    private boolean isInvalidPoint(Point p) {
        return invalidPoints.contains(p);
    }

    private boolean isAtOrigin(Point p) {
        return p.equals(Point.of(0, 0));
    }

    @Test
    void e1() {
        List<Point> expectedPath = List.of();
        Assertions.assertEquals(expectedPath, getPath(new boolean[][]{{}}));
    }

    @Test
    void e2() {
        List<Point> expectedPath = List.of(
                Point.of(0, 0), Point.of(0, 1), Point.of(0, 2),
                Point.of(1, 2),
                Point.of(2, 2)
        );
        Assertions.assertEquals(expectedPath, getPath(new boolean[][]{
                {
                        true, true, true
                },
                {
                        true, true, true
                },
                {
                        true, true, true
                }
        }));
    }

    @Test
    void e3() {
        List<Point> expectedPath = List.of();
        Assertions.assertEquals(expectedPath, getPath(new boolean[][]{
                {
                        true, true, false
                },
                {
                        true, false, true
                },
                {
                        false, true, true
                }
        }));
    }


    @Test
    void e4() {
        List<Point> expectedPath = List.of(
                Point.of(0, 0), Point.of(0, 1), Point.of(1, 1),
                Point.of(2, 1),
                Point.of(2, 2)
        );
        Assertions.assertEquals(expectedPath, getPath(new boolean[][]{
                {
                        true, true, true
                },
                {
                        false, true, false
                },
                {
                        true, true, true
                }
        }));
    }

}
