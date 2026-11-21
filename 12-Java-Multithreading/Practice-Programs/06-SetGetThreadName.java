class SetGetThreadName {
    public static void main(String[] args) {
        Thread thread = new Thread(() ->
                System.out.println("Worker name: " + Thread.currentThread().getName()));
        thread.setName("Number-Worker");
        System.out.println("Retrieved name: " + thread.getName());
        thread.start();
    }
}
