class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread daemon = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Daemon heartbeat");
                    Thread.sleep(100);
                } catch (InterruptedException exception) {
                    break;
                }
            }
        });
        daemon.setDaemon(true);
        daemon.start();
        Thread.sleep(350);
        System.out.println("Main thread exiting");
    }
}
