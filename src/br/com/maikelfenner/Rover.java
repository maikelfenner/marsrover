package br.com.maikelfenner;

import java.util.Optional;

public class Rover {

    private Direction direction = Direction.NORTH;
    private Coordinate coordinate = new Coordinate(0, 0);
    private Grid grid;

    public Rover(Grid grid) {
        this.grid = grid;
    }

    public String execute(String commands) {
        String obstacleString = "";

        for (char c : commands.toCharArray()) {
            if (c == 'R') {
                direction = direction.right();
            }

            if (c == 'L') {
                direction = direction.left();
            }

            if(c == 'M') {
                obstacleString = move();
            }
        }
        
        return obstacleString + coordinate.x() + ":" + coordinate.y() + ":" + direction.value();
    }

    private String move() {
        Optional<Coordinate> nextCoordinate = grid.nextCoordinateFor(this.coordinate, this.direction);

        nextCoordinate.ifPresent(nc -> this.coordinate = nc);

        return nextCoordinate.isPresent() ? "" : "O:";

    }
}
