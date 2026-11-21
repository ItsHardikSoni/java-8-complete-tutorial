class LambdaThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() ->
                System.out.println("Lambda thread: " + Thread.currentThread().getName()));
        thread.start();
    }
}
