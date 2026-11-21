class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                Thread.sleep(300);
                System.out.println("Worker finished");
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });
        worker.start();
        worker.join();
        System.out.println("Main continues after join");
    }
}
