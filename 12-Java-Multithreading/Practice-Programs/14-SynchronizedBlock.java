class SynchronizedBlock {
    private int count;

    public static void main(String[] args) throws InterruptedException {
        SynchronizedBlock application = new SynchronizedBlock();
        Runnable task = () -> {
            synchronized (application) {
                for (int i = 0; i < 5; i++) {
                    application.count++;
                }
            }
        };
        Thread first = new Thread(task);
        Thread second = new Thread(task);
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println("Count: " + application.count);
    }
}
