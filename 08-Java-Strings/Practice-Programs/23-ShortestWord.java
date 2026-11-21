import java.util.Scanner;

class ShortestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine().trim();
        if (text.length() == 0) {
            System.out.println("No words");
        } else {
            String[] words = text.split("\\s+");
            String shortest = words[0];
            for (String word : words) if (word.length() < shortest.length()) shortest = word;
            System.out.println("Shortest word: " + shortest);
        }
        scanner.close();
    }
}
