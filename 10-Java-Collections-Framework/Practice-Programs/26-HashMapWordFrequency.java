import java.util.LinkedHashMap;
import java.util.Map;

class HashMapWordFrequency {
    public static void main(String[] args) {
        String text = "java collection collection framework java map";
        Map<String, Integer> frequency = new LinkedHashMap<>();

        for (String word : text.split("\\s+")) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        System.out.println(frequency);
    }
}
