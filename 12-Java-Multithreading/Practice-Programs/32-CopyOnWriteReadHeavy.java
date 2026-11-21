import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class CopyOnWriteReadHeavy {
    public static void main(String[] args) throws InterruptedException {
        List<String> data = new CopyOnWriteArrayList<>();
        data.add("A");
        data.add("B");
        Thread reader = new Thread(() -> data.forEach(
                value -> System.out.println("Read: " + value)));
        Thread writer = new Thread(() -> data.add("C"));
        reader.start();
        writer.start();
        reader.join();
        writer.join();
        System.out.println("Final: " + data);
    }
}
