import java.util.Scanner;

class CountDigitsLettersSpecialCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        int digits = 0;
        int letters = 0;
        int special = 0;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character >= '0' && character <= '9') digits++;
            else if ((character >= 'A' && character <= 'Z') ||
                    (character >= 'a' && character <= 'z')) letters++;
            else special++;
        }
        System.out.println("Digits: " + digits);
        System.out.println("Letters: " + letters);
        System.out.println("Special characters: " + special);
        scanner.close();
    }
}
