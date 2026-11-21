import java.util.concurrent.atomic.AtomicInteger;

class AtomicIntegerCounter {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();
        Thread first = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        });
        Thread second = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        });
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println("Atomic count: " + counter.get());
    }
}
