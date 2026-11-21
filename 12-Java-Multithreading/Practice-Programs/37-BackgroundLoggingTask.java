import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class BackgroundLoggingTask {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("LOG: Background event " + i);
            }
        });
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
    }
}
