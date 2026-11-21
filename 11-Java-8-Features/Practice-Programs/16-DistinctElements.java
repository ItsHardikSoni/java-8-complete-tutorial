import java.util.Arrays;

class DistinctElements {
    public static void main(String[] args) {
        Arrays.asList(10, 20, 10, 30, 20, 40).stream()
                .distinct()
                .forEach(System.out::println);
    }
}
