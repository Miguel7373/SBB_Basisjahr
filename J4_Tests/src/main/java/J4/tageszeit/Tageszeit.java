package J4.tageszeit;
    import java.time.LocalDateTime;

    public class Tageszeit {
        public String getTimeOfDay(LocalDateTime time) {
            if (time.getHour() < 6) {
                return "Night";
            }
            if (time.getHour() < 12) {
                return "Morning";
            }
            if (time.getHour() < 18) {
                return "Afternoon";
            }
            return "Evening";
        }
    }
