class ConsistentLockOrdering {
    public static void main(String[] args) throws InterruptedException {
        Object first = new Object();
        Object second = new Object();
        Runnable task = () -> {
            synchronized (first) {
                synchronized (second) {
                    System.out.println(Thread.currentThread().getName()
                            + " acquired locks consistently");
                }
            }
        };
        Thread one = new Thread(task, "Thread-1");
        Thread two = new Thread(task, "Thread-2");
        one.start();
        two.start();
        one.join();
        two.join();
    }
}
