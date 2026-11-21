import java.util.ArrayList;
import java.util.Iterator;

class RemoveEvenNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(11);
        numbers.add(12);
        numbers.add(15);
        numbers.add(18);
        numbers.add(21);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(numbers);
    }
}
