import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class EmployeeProcessingCallable {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(() -> "Processed Aarav");
        tasks.add(() -> "Processed Diya");
        tasks.add(() -> "Processed Kabir");

        List<Future<String>> futures = executor.invokeAll(tasks);
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        executor.shutdown();
    }
}
