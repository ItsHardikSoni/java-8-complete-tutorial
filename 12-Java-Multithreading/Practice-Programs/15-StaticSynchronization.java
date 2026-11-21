class StaticSyncExample {
    static synchronized void print(String name) {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + ": " + i);
        }
    }
}

class StaticSynchronization {
    public static void main(String[] args) {
        Thread first = new Thread(() -> StaticSyncExample.print("First"));
        Thread second = new Thread(() -> StaticSyncExample.print("Second"));
        first.start();
        second.start();
    }
}
