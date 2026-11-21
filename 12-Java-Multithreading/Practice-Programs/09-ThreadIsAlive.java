class ThreadIsAlive {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });
        worker.start();
        System.out.println("Before: " + worker.isAlive());
        worker.join();
        System.out.println("After: " + worker.isAlive());
    }
}
