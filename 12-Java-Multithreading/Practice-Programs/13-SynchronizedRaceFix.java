class SafeCounter {
    private int count;

    synchronized void increment() {
        count++;
    }

    synchronized int getCount() {
        return count;
    }
}

class SynchronizedRaceFix {
    public static void main(String[] args) throws InterruptedException {
        SafeCounter counter = new SafeCounter();
        Thread first = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        Thread second = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println("Safe count: " + counter.getCount());
    }
}
