import java.util.Scanner;

class CountUppercaseLowercase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String text = scanner.nextLine();
        int uppercase = 0;
        int lowercase = 0;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character >= 'A' && character <= 'Z') uppercase++;
            if (character >= 'a' && character <= 'z') lowercase++;
        }
        System.out.println("Uppercase: " + uppercase);
        System.out.println("Lowercase: " + lowercase);
        scanner.close();
    }
}
