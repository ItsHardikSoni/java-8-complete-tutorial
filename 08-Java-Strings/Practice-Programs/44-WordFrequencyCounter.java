import java.util.Scanner;

class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String text = scanner.nextLine();
        StringBuilder cleaned = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if ((character >= 'A' && character <= 'Z') ||
                    (character >= 'a' && character <= 'z') ||
                    character == ' ' || character == '\t') {
                cleaned.append(character);
            } else {
                cleaned.append(' ');
            }
        }
        String[] words = cleaned.toString().trim().toLowerCase().split("\\s+");
        if (cleaned.toString().trim().length() == 0) {
            System.out.println("No words");
        } else {
            for (int i = 0; i < words.length; i++) {
                boolean printed = false;
                for (int j = 0; j < i; j++) if (words[i].equals(words[j])) printed = true;
                if (!printed) {
                    int count = 0;
                    for (String word : words) if (words[i].equals(word)) count++;
                    System.out.println(words[i] + ": " + count);
                }
            }
        }
        scanner.close();
    }
}
