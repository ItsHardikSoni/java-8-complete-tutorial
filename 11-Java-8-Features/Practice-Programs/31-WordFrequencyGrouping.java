import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class WordFrequencyGrouping {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "stream", "java", "lambda", "stream");
        Map<String, Long> frequency = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println(frequency);
    }
}
