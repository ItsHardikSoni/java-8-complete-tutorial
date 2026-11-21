import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableFutureSquare {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> task = () -> 12 * 12;
        Future<Integer> future = executor.submit(task);
        System.out.println("Square: " + future.get());
        executor.shutdown();
    }
}
