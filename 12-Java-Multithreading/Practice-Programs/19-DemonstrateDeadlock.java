class DemonstrateDeadlock {
    public static void main(String[] args) throws InterruptedException {
        Object first = new Object();
        Object second = new Object();

        Thread a = new Thread(() -> {
            synchronized (first) {
                System.out.println("A locked first");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
                synchronized (second) {
                    System.out.println("A locked second");
                }
            }
        });
        Thread b = new Thread(() -> {
            synchronized (second) {
                System.out.println("B locked second");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
                synchronized (first) {
                    System.out.println("B locked first");
                }
            }
        });
        a.start();
        b.start();
        a.join(500);
        b.join(500);
        System.out.println("Demonstration finished");
    }
}
