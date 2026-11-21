import java.util.Arrays;

class SortedAscending {
    public static void main(String[] args) {
        Arrays.asList(40, 10, 30, 20).stream()
                .sorted()
                .forEach(System.out::println);
    }
}
