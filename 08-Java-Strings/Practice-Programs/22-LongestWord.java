import java.util.Scanner;

class LongestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String[] words = scanner.nextLine().trim().split("\\s+");
        String longest = words.length == 0 ? "" : words[0];
        for (String word : words) if (word.length() > longest.length()) longest = word;
        System.out.println("Longest word: " + longest);
        scanner.close();
    }
}
