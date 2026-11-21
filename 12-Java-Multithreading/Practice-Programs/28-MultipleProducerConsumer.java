import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class MultipleProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        for (int producer = 1; producer <= 2; producer++) {
            int producerNumber = producer;
            new Thread(() -> {
                try {
                    for (int i = 1; i <= 3; i++) {
                        int value = producerNumber * 10 + i;
                        queue.put(value);
                        System.out.println("Producer " + producerNumber + " produced " + value);
                    }
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
        for (int consumer = 1; consumer <= 2; consumer++) {
            new Thread(() -> {
                try {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Consumed " + queue.take());
                    }
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
        Thread.sleep(500);
    }
}
