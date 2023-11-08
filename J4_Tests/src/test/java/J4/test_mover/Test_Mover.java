package J4.test_mover;

import J4.mover.Mover;
import org.junit.jupiter.api.Test;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static java.time.LocalDateTime.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;

public class Test_Mover {
    private Mover mover = new Mover();

    @Test
    public void testMoveNorth() {
        mover.move(Mover.Direction.NORTH);
        assertEquals(LocalDateTime.now().getSecond(), mover.getLastMovingTime().getSecond());
        assertEquals(Mover.Direction.NORTH, mover.getLastDirection());
    }

    @Test
    public void testMoveSouth() {
        mover.move(Mover.Direction.SOUTH);

        assertEquals(LocalDateTime.now().getSecond(), mover.getLastMovingTime().getSecond());
        assertEquals(Mover.Direction.SOUTH, mover.getLastDirection());
    }

    @Test
    public void testMoveEast() {
        mover.move(Mover.Direction.EAST);

        assertEquals(LocalDateTime.now().getSecond(), mover.getLastMovingTime().getSecond());
        assertEquals(Mover.Direction.EAST, mover.getLastDirection());
    }

    @Test
    public void testMoveWest() {
        mover.move(Mover.Direction.WEST);

        assertEquals(LocalDateTime.now().getSecond(), mover.getLastMovingTime().getSecond());
        assertEquals(Mover.Direction.WEST, mover.getLastDirection());
    }
}