class RunnableTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable thread: " + Thread.currentThread().getName());
    }
}

class ThreadImplementingRunnable {
    public static void main(String[] args) {
        new Thread(new RunnableTask()).start();
    }
}
