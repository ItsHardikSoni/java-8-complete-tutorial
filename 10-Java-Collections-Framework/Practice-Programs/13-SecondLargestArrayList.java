import java.util.ArrayList;
import java.util.Collections;

class SecondLargestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(20);
        numbers.add(50);
        numbers.add(10);
        numbers.add(50);
        numbers.add(30);

        Integer largest = null;
        Integer secondLargest = null;
        for (Integer number : numbers) {
            if (largest == null || number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (!number.equals(largest)
                    && (secondLargest == null || number > secondLargest)) {
                secondLargest = number;
            }
        }
        System.out.println("Second largest: "
                + (secondLargest == null ? "Not present" : secondLargest));
    }
}
