import java.util.Arrays;

class CountLongStrings {
    public static void main(String[] args) {
        long count = Arrays.asList("Java", "Collections", "API", "Stream").stream()
                .filter(value -> value.length() > 5)
                .count();
        System.out.println("Count: " + count);
    }
}
