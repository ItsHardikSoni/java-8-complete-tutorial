import java.util.Scanner;

class ReverseWordOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine().trim();
        if (text.length() == 0) {
            System.out.println("Result:");
        } else {
            String[] words = text.split("\\s+");
            StringBuilder result = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                if (i < words.length - 1) result.append(' ');
                result.append(words[i]);
            }
            System.out.println("Result: " + result);
        }
        scanner.close();
    }
}
