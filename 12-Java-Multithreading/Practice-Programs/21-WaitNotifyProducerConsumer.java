import java.util.LinkedList;
import java.util.Queue;

class SimpleBuffer {
    private final Queue<Integer> items = new LinkedList<>();

    synchronized void produce(int value) throws InterruptedException {
        while (!items.isEmpty()) {
            wait();
        }
        items.add(value);
        System.out.println("Produced: " + value);
        notifyAll();
    }

    synchronized int consume() throws InterruptedException {
        while (items.isEmpty()) {
            wait();
        }
        int value = items.remove();
        System.out.println("Consumed: " + value);
        notifyAll();
        return value;
    }
}

class WaitNotifyProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        SimpleBuffer buffer = new SimpleBuffer();
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i);
                }
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                }
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
