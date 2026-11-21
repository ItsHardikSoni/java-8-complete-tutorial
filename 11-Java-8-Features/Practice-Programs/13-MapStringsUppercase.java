import java.util.Arrays;
import java.util.stream.Collectors;

class MapStringsUppercase {
    public static void main(String[] args) {
        System.out.println(Arrays.asList("java", "stream", "lambda").stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList()));
    }
}
