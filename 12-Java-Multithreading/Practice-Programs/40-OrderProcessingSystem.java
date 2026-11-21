import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class OrderProcessor {
    synchronized void process(int orderNumber) {
        System.out.println("Processing order " + orderNumber
                + " on " + Thread.currentThread().getName());
    }
}

class OrderProcessingSystem {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        OrderProcessor processor = new OrderProcessor();
        for (int i = 1; i <= 6; i++) {
            int orderNumber = i;
            executor.execute(() -> processor.process(orderNumber));
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("All orders processed");
    }
}
