class CoordinationBuffer {
    private boolean ready;

    synchronized void waitForSignal() throws InterruptedException {
        while (!ready) {
            wait();
        }
        System.out.println("Worker received signal");
    }

    synchronized void sendSignal() {
        ready = true;
        notifyAll();
    }
}

class ThreadCoordination {
    public static void main(String[] args) throws InterruptedException {
        CoordinationBuffer buffer = new CoordinationBuffer();
        Thread worker = new Thread(() -> {
            try {
                buffer.waitForSignal();
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });
        worker.start();
        Thread.sleep(100);
        buffer.sendSignal();
        worker.join();
    }
}
