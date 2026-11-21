import java.util.Scanner;

class PalindromeString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        boolean palindrome = true;
        for (int i = 0, j = text.length() - 1; i < j; i++, j--) {
            if (text.charAt(i) != text.charAt(j)) {
                palindrome = false;
                break;
            }
        }
        System.out.println(palindrome ? "Palindrome" : "Not Palindrome");
        scanner.close();
    }
}
