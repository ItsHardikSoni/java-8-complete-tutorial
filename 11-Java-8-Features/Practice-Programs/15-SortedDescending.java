import java.util.Arrays;
import java.util.Comparator;

class SortedDescending {
    public static void main(String[] args) {
        Arrays.asList(40, 10, 30, 20).stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}
