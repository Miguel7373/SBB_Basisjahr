package J4.mover;

import java.time.Clock;
import java.time.LocalDateTime;

public class Mover {
    private LocalDateTime lastMovingTime;
    private Direction lastDirection;



    public void move(Direction direction) {
        if (Direction.getOpposite(direction) != this.lastDirection) {
            this.lastDirection = direction;
            this.lastMovingTime = LocalDateTime.now();
        }
    }

    public LocalDateTime getLastMovingTime() {
        return lastMovingTime;
    }

    public Direction getLastDirection() {
        return lastDirection;
    }

    public enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST;

        public static Direction getOpposite(Direction direction) {
            switch (direction) {
                case NORTH:
                    return SOUTH;
                case EAST:
                    return WEST;
                case SOUTH:
                    return NORTH;
                case WEST:
                    return EAST;
            }
            return null;
        }
    }
}