class VolatileVisibility {
    private volatile boolean running = true;

    void stop() {
        running = false;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileVisibility example = new VolatileVisibility();
        Thread worker = new Thread(() -> {
            int count = 0;
            while (example.running) {
                count++;
            }
            System.out.println("Stopped after " + count + " iterations");
        });
        worker.start();
        Thread.sleep(10);
        example.stop();
        worker.join();
    }
}
