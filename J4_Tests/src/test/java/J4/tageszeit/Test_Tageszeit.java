package J4.tageszeit;
import java.time.LocalDateTime;

import J4.tageszeit.Tageszeit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Test_Tageszeit {
    private Tageszeit tageszeit = new Tageszeit();
    @Test
    public void testNight() {
        assertEquals("Night", tageszeit.getTimeOfDay(LocalDateTime.of(2023, 1, 1, 3, 0)));
    }
    @Test
    public void testMorning() {
        assertEquals("Morning", tageszeit.getTimeOfDay(LocalDateTime.of(2023, 1, 1, 9, 0)));
    }
    @Test
    public void testAfternoon() {

        assertEquals("Afternoon", tageszeit.getTimeOfDay(LocalDateTime.of(2023, 1, 1, 15, 0)));
    }
    @Test
    public void testEvening() {
        assertEquals("Evening", tageszeit.getTimeOfDay(LocalDateTime.of(2023, 1, 1, 20, 0)));
    }
}