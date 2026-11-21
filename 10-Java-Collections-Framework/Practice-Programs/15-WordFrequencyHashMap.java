import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class WordFrequencyHashMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine().toLowerCase();
        Map<String, Integer> frequency = new HashMap<>();

        for (String word : sentence.split("\\s+")) {
            if (!word.isEmpty()) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }
        System.out.println(frequency);
        scanner.close();
    }
}
