import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class BoundedTaskQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> tasks = new ArrayBlockingQueue<>(3);
        tasks.put("Task 1");
        tasks.put("Task 2");
        tasks.put("Task 3");

        while (!tasks.isEmpty()) {
            System.out.println("Processed: " + tasks.take());
        }
    }
}
