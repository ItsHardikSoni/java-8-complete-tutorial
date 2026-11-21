class ThreadInterruption {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Working");
                    Thread.sleep(100);
                }
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Worker interrupted");
        });
        worker.start();
        Thread.sleep(350);
        worker.interrupt();
        worker.join();
    }
}
