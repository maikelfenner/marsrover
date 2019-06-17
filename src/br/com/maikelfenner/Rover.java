package br.com.maikelfenner;

public class Rover {

    private Direction direction = Direction.NORTH;

    public String execute(String commands) {

        for (char c : commands.toCharArray()) {
            if (c == 'R') {
                direction = direction.right();
            }

            if (c == 'L') {
                direction = direction.left();
            }
        }
        
        return "0:0:" + direction.value();
    }

    enum Direction {
        NORTH("N", "W", "E"),
        EAST("E", "N", "S"),
        SOUTH("S", "E", "W"),
        WEST("W", "S", "N");

        private final String value;
        private final String left;
        private final String right;

        Direction(String value, String left, String right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Direction right() {
            return this.diretionToThe(right);
        }

        public Direction left() {
            return this.diretionToThe(left);
        }

        public String value() {
            return value;
        }

        private Direction diretionToThe(String side) {
            for (Direction direction : values()) {
                if (direction.value.equals(side)) {
                    return direction;
                }
            }

            return null;
        }
    }
}
