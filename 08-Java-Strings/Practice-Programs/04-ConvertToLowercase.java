import java.util.Scanner;

class ConvertToLowercase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character >= 'A' && character <= 'Z') {
                character = (char) (character + 32);
            }
            result.append(character);
        }
        System.out.println("Lowercase: " + result);
        scanner.close();
    }
}
