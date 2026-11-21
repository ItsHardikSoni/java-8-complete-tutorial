class DisplayCurrentThreadName {
    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());
        new Thread(() ->
                System.out.println("Worker thread: " + Thread.currentThread().getName()))
                .start();
    }
}
