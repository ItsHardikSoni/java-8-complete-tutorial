import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(
                () -> System.out.println("Scheduled heartbeat"),
                0,
                500,
                TimeUnit.MILLISECONDS);
        scheduler.schedule(scheduler::shutdown, 2, TimeUnit.SECONDS);
    }
}
