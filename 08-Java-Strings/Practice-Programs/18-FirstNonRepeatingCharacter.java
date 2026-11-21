import java.util.Scanner;

class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        char result = '\0';
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            int count = 0;
            for (int j = 0; j < text.length(); j++) if (text.charAt(j) == character) count++;
            if (count == 1) {
                result = character;
                break;
            }
        }
        System.out.println(result == '\0' ? "No non-repeating character" : "First non-repeating character: " + result);
        scanner.close();
    }
}
