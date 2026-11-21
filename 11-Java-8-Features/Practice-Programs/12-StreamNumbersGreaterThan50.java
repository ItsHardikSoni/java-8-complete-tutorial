import java.util.Arrays;

class StreamNumbersGreaterThan50 {
    public static void main(String[] args) {
        Arrays.asList(20, 55, 80, 45, 60).stream()
                .filter(number -> number > 50)
                .forEach(System.out::println);
    }
}
