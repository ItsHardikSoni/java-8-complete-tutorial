import java.util.Scanner;

class ReverseEachWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();
        String[] words = text.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i > 0) result.append(' ');
            result.append(new StringBuilder(words[i]).reverse());
        }
        System.out.println("Result: " + result);
        scanner.close();
    }
}
