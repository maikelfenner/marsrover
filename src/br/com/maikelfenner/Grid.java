package br.com.maikelfenner;

public class Grid {
    private static final int MAX_HEIGHT = 10;
    private static final int MAX_WIDTH = 10;

    Coordinate nextCoordinateFor(Coordinate coordinate, Direction direction) {
        int x = coordinate.x();
        int y = coordinate.y();

        if (direction == Direction.NORTH) {
            y = ++y % MAX_HEIGHT;
        }

        if (direction == Direction.EAST) {
            x = ++x % MAX_WIDTH;
        }

        if (direction == Direction.SOUTH) {
            y = ((y > 0) ? y : MAX_HEIGHT) - 1;
        }

        if (direction == Direction.WEST) {
            x = ((x > 0) ? x : MAX_WIDTH) - 1;
        }

        return new Coordinate(x, y);
    }
}
