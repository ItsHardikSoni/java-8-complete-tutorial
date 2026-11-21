import java.util.PriorityQueue;

class Task implements Comparable<Task> {
    private final String name;
    private final int priority;

    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return name + " (priority " + priority + ")";
    }
}

class PriorityQueueTasks {
    public static void main(String[] args) {
        PriorityQueue<Task> tasks = new PriorityQueue<>();
        tasks.offer(new Task("Write report", 3));
        tasks.offer(new Task("Fix server", 1));
        tasks.offer(new Task("Reply to email", 2));

        while (!tasks.isEmpty()) {
            System.out.println(tasks.poll());
        }
    }
}
