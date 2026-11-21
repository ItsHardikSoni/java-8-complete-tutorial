import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TaskExecutionSystem {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 1; i <= 10; i++) {
            int taskNumber = i;
            executor.submit(() -> System.out.println("Executing task " + taskNumber));
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
}
