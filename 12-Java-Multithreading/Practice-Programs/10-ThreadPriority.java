class ThreadPriority {
    public static void main(String[] args) {
        Thread low = new Thread(() -> System.out.println("Low priority task"));
        Thread high = new Thread(() -> System.out.println("High priority task"));
        low.setPriority(Thread.MIN_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);
        low.start();
        high.start();
    }
}
