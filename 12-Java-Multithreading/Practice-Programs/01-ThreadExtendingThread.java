class NumberThread extends Thread {
    @Override
    public void run() {
        System.out.println("Running: " + getName());
    }
}

class ThreadExtendingThread {
    public static void main(String[] args) {
        new NumberThread().start();
    }
}
