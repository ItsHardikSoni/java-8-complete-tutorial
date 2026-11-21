import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockExample {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Runnable task = () -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()
                        + " entered");
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        };
        Thread first = new Thread(task, "First");
        Thread second = new Thread(task, "Second");
        first.start();
        second.start();
        first.join();
        second.join();
    }
}
