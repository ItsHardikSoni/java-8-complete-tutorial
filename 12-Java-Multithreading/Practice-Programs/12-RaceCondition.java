class UnsafeCounter {
    private int count;

    void increment() {
        count++;
    }

    int getCount() {
        return count;
    }
}

class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        UnsafeCounter counter = new UnsafeCounter();
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
        System.out.println("Unsafe count: " + counter.getCount()
                + " (may be less than 2000)");
    }
}
