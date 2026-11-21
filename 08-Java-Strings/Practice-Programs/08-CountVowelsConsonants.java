import java.util.Scanner;

class CountVowelsConsonants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            char lower = character >= 'A' && character <= 'Z'
                    ? (char) (character + 32) : character;
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                vowels++;
            } else if (lower >= 'a' && lower <= 'z') {
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        scanner.close();
    }
}
