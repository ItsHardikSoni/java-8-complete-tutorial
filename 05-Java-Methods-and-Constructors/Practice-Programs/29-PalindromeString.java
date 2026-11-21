import java.util.Scanner;

class PalindromeString {
    public static boolean isPalindrome(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindrome(text, start + 1, end - 1);
    }

    public static boolean isPalindrome(String text) {
        String normalized = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindrome(normalized, 0, normalized.length() - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        if (isPalindrome(text)) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
        scanner.close();
    }
}
