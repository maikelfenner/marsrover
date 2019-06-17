package br.com.maikelfenner;

public class Rover {

    private static final int MAX_HEIGHT = 10;
    private static final int MAX_WIDTH = 10;

    private Direction direction = Direction.NORTH;
    private Coordinate coordinate = new Coordinate(0, 0);

    public String execute(String commands) {

        for (char c : commands.toCharArray()) {
            if (c == 'R') {
                direction = direction.right();
            }

            if (c == 'L') {
                direction = direction.left();
            }

            if(c == 'M') {
                coordinate = move();
            }
        }
        
        return coordinate.x() + ":" + coordinate.y() + ":" + direction.value();
    }

    private Coordinate move() {
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
