package br.com.maikelfenner;

public class Rover {

    private Direction direction = Direction.NORTH;
    private Coordinate coordinate = new Coordinate(0, 0);
    private Grid grid;

    public Rover(Grid grid) {
        this.grid = grid;
    }

    public String execute(String commands) {

        for (char c : commands.toCharArray()) {
            if (c == 'R') {
                direction = direction.right();
            }

            if (c == 'L') {
                direction = direction.left();
            }

            if(c == 'M') {
                coordinate = grid.nextCoordinateFor(coordinate, direction);
            }
        }
        
        return coordinate.x() + ":" + coordinate.y() + ":" + direction.value();
    }
}
