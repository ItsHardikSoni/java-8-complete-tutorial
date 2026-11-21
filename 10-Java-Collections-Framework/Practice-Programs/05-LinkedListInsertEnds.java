import java.util.LinkedList;

class LinkedListInsertEnds {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.addFirst(10);
        numbers.addLast(40);
        System.out.println(numbers);
    }
}
