import java.util.LinkedList;
import java.util.Queue;

class LinkedListQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");

        System.out.println("Front: " + queue.peek());
        System.out.println("Removed: " + queue.poll());
        System.out.println("Remaining: " + queue);
    }
}
