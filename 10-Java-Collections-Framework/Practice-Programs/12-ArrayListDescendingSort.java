import java.util.ArrayList;
import java.util.Collections;

class ArrayListDescendingSort {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println(numbers);
    }
}
