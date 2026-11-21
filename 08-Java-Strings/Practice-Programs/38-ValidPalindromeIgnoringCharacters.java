import java.util.Scanner;

class ValidPalindromeIgnoringCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        StringBuilder filtered = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character >= 'A' && character <= 'Z') character = (char) (character + 32);
            if ((character >= 'a' && character <= 'z') || (character >= '0' && character <= '9')) {
                filtered.append(character);
            }
        }
        boolean palindrome = true;
        for (int i = 0, j = filtered.length() - 1; i < j; i++, j--) {
            if (filtered.charAt(i) != filtered.charAt(j)) {
                palindrome = false;
                break;
            }
        }
        System.out.println(palindrome ? "Valid palindrome" : "Not a valid palindrome");
        scanner.close();
    }
}
