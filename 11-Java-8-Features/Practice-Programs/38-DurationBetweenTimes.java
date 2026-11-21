import java.time.Duration;
import java.time.LocalTime;

class DurationBetweenTimes {
    public static void main(String[] args) {
        LocalTime start = LocalTime.of(9, 30);
        LocalTime end = LocalTime.of(11, 45);
        Duration duration = Duration.between(start, end);
        System.out.println("Duration: " + duration.toHours() + " hours "
                + duration.toMinutes() % 60 + " minutes");
    }
}
