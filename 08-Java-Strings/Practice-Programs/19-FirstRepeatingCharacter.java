import java.util.Scanner;

class FirstRepeatingCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        char result = '\0';
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    result = text.charAt(i);
                    i = text.length();
                    break;
                }
            }
        }
        System.out.println(result == '\0' ? "No repeating character" : "First repeating character: " + result);
        scanner.close();
    }
}
