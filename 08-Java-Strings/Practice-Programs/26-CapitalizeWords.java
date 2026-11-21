import java.util.Scanner;

class CapitalizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        boolean startWord = true;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character == ' ' || character == '\t') {
                result.append(character);
                startWord = true;
            } else if (startWord) {
                if (character >= 'a' && character <= 'z') character = (char) (character - 32);
                result.append(character);
                startWord = false;
            } else {
                result.append(character);
            }
        }
        System.out.println("Result: " + result);
        scanner.close();
    }
}
